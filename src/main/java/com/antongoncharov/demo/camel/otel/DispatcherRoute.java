package com.antongoncharov.demo.camel.otel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.opentelemetry.OpenTelemetryTracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author antongoncharov
 */
@Component
public class DispatcherRoute extends RouteBuilder {

    private final ServiceProperties serviceProperties;

    @Autowired
    public DispatcherRoute(ServiceProperties serviceProperties) {
        this.serviceProperties = serviceProperties;
    }

    @Override
    public void configure() {

        OpenTelemetryTracer ott = new OpenTelemetryTracer();
        ott.init(this.getContext());

        from("direct:dispatcher").routeId("dispatcher-route")
            .log("incoming request, body = ${body}")
            .to("direct:sayHello");

        from("direct:sayHello").routeId("sayHello-route")
            .log("dispatching to /hello endpoint")
            .setHeader("status", constant("dispatched"))
            .toD("undertow:" + serviceProperties.getDownstreamEndpoint() + "?name=${body}")
            .convertBodyTo(String.class);

    }

}

