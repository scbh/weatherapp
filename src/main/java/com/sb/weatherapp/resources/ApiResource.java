package com.sb.weatherapp.resources;

import javax.ws.rs.core.Response;

/**
 * @author shamalbhole
 */
public interface ApiResource {
    Response getWeatherInfo(String value, String unit);

}
