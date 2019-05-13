package com.sb.weatherapp.config;

import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shamalbhole
 */
public class RestModule extends JerseyServletModule{

    @Override
    protected void configureServlets() {
        serve("/*").with(GuiceContainer.class, initParams());
    }

    private Map<String, String> initParams() {
        Map<String, String> initParams = new HashMap<String, String>();
        initParams.put(PackagesResourceConfig.PROPERTY_PACKAGES, "com.sb.weatherapp");
        return initParams;
    }
}
