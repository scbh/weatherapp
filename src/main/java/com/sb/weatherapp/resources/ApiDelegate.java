package com.sb.weatherapp.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * @author shamalbhole
 */
@Path("/v1")
public class ApiDelegate {

    @Inject
    private ApiResource apiResource;

    public ApiDelegate() {
    }

    @GET
    @Path("/weatherinfo")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response getWeatherInfo(@QueryParam("value") String value, @QueryParam("unit") String unit) {

        return this.apiResource.getWeatherInfo(value, unit);
    }

    @GET
    @Path("/hello")
    public Response hello() {
        return Response.ok().entity("Hello World!").build();
    }

}
