package com.sb.weatherapp.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sb.weatherapp.pojo.WeatherResponse;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class WeatherService {

    public WeatherService() {
    }

    public WeatherResponse getResponse(String value, String unit) {

        Client client = Client.create();
        StringBuilder builder = new StringBuilder();
        builder.append("http://api.openweathermap.org/data/2.5/weather?");

        try(InputStream input = WeatherService.class.getClassLoader().getResourceAsStream("application.properties")){
            Properties prop = new Properties();
            if (input == null) {
                return new WeatherResponse.Builder()
                        .withStatusCode(500)
                        .withMessage("Internal Server Error: Cannot read properties file")
                        .build();
            }

            prop.load(input);
            final String apiKey = prop.getProperty("apiKey");

            builder.append("q=");
            builder.append(value.replace(" ", "%20"));

            if(unit!=null && !unit.equals("")){
                builder.append("&units=");
                builder.append(unit);
            }

            builder.append("&appid=");
            builder.append(apiKey);

            WebResource webResource = client.resource(builder.toString());
            ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

            String op = response.getEntity(String.class);

            ObjectMapper mapper = new ObjectMapper();
            JsonNode json = mapper.readTree(op);

            if(json.get("cod").intValue() == 200){
                return new WeatherResponse.Builder()
                        .withLocation(json.get("name").textValue())
                        .withCurrentCondition(json.get("weather").get(0).get("main").textValue())
                        .withCurrentTemperature(json.path("main").path("temp").asText())
                        .withHighTemp(json.path("main").path("temp_max").asText())
                        .withLowestTemp(json.path("main").path("temp_min").asText())
                        .withLatitude(json.path("coord").path("lat").asText())
                        .withLongitude(json.path("coord").path("lon").asText())
                        .withIcon("http://openweathermap.org/img/w/"+json.get("weather").get(0).get("icon").textValue()+".png")
                        .withStatusCode(json.get("cod").intValue())
                        .build();
            }
            else{
                return new WeatherResponse.Builder()
                        .withStatusCode(Integer.parseInt(json.get("cod").textValue()))
                        .withMessage(json.get("message").textValue())
                        .build();
            }
        }
        catch (IOException ex) {
            return new WeatherResponse.Builder()
                    .withStatusCode(500)
                    .withMessage("Internal Server Error")
                    .build();
        }
    }
}
