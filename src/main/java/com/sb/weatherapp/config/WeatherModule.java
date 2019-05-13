package com.sb.weatherapp.config;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.sb.weatherapp.resources.ApiResource;
import com.sb.weatherapp.resources.WeatherResource;

/**
 * @author shamalbhole
 */
public class WeatherModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ApiResource.class).to(WeatherResource.class).in(Scopes.SINGLETON);
    }
}
