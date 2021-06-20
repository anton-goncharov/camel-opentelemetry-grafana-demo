package com.antongoncharov.demo.camel.otel;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author antongoncharov
 */
@Component
@ConfigurationProperties(prefix = "srv")
public class ServiceProperties {

    private String downstreamEndpoint;

    public String getDownstreamEndpoint() {
        return downstreamEndpoint;
    }

    public void setDownstreamEndpoint(String downstreamEndpoint) {
        this.downstreamEndpoint = downstreamEndpoint;
    }

}

