package com.sb.weatherapp.config;

import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.servlet.GuiceServletContextListener;

/**
 * @author shamalbhole
 */
public class Bootstrap extends GuiceServletContextListener {

    void configureBinder(Binder binder) {
        binder.install(new RestModule());
        binder.install(new WeatherModule());
    }
    protected Injector getInjector() {
        return Guice.createInjector(new Module[]{new GuiceBootstrapModule()});
    }

    class GuiceBootstrapModule extends AbstractModule {
        protected GuiceBootstrapModule() {
        }

        protected void configure() {
            Bootstrap.this.configureBinder(this.binder());
        }
    }
}
