package com.sb.weatherapp.resources;

import com.sb.weatherapp.pojo.WeatherResponse;
import com.sb.weatherapp.services.WeatherService;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

public class WeatherResource implements ApiResource {

    private WeatherService weatherService;

    @Inject
    public WeatherResource(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public Response getWeatherInfo(String value, String unit) {

        try {
            WeatherResponse response = weatherService.getResponse(value, unit);

            if(response.getStatusCode() == 200){
                return Response.ok().entity(response).build();
            }

            return Response.status(response.getStatusCode()).entity(response).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
