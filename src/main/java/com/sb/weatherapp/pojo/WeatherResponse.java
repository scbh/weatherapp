package com.sb.weatherapp.pojo;

import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author shamalbhole
 */
@XmlRootElement
@Produces("application/json")
public class WeatherResponse {

    private String location;
    private String lat;
    private String lon;
    private String currentCondition;
    private String currentTemp;
    private String highTemp;
    private String lowestTemp;
    private String icon;
    private int statusCode;
    private String message;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getCurrentCondition() {
        return currentCondition;
    }

    public void setCurrentCondition(String currentCondition) {
        this.currentCondition = currentCondition;
    }

    public String getCurrentTemp() {
        return currentTemp;
    }

    public void setCurrentTemp(String currentTemp) {
        this.currentTemp = currentTemp;
    }

    public String getHighTemp() {
        return highTemp;
    }

    public void setHighTemp(String highTemp) {
        this.highTemp = highTemp;
    }

    public String getLowestTemp() {
        return lowestTemp;
    }

    public void setLowestTemp(String lowestTemp) {
        this.lowestTemp = lowestTemp;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private WeatherResponse() {
    }

    public static class Builder {
        private String location;
        private String lat;
        private String lon;
        private String currentCondition;
        private String currentTemp;
        private String highTemp;
        private String lowestTemp;
        private String icon;
        private int statusCode;
        private String message;

        public Builder() {
        }

        public Builder withLocation(String location){
            this.location = location;
            return this;
        }

        public Builder withLatitude(String lat){
            this.lat = lat;
            return this;
        }

        public Builder withLongitude(String lon) {
            this.lon = lon;
            return this;
        }

        public Builder withCurrentCondition(String currentCondition){
            this.currentCondition = currentCondition;
            return this;
        }

        public Builder withCurrentTemperature(String currentTemp){
            this.currentTemp = currentTemp;
            return this;
        }

        public Builder withHighTemp(String highTemp){
            this.highTemp = highTemp;
            return this;
        }

        public Builder withLowestTemp(String lowestTemp){
            this.lowestTemp = lowestTemp;
            return this;
        }

        public Builder withIcon(String icon){
            this.icon = icon;
            return this;
        }

        public Builder withStatusCode(int statusCode){
            this.statusCode = statusCode;
            return this;
        }

        public Builder withMessage(String message){
            this.message = message;
            return this;
        }

        public WeatherResponse build() {
            WeatherResponse response = new WeatherResponse();

            response.location = this.location;
            response.lat = this.lat;
            response.lon = this.lon;
            response.currentCondition = this.currentCondition;
            response.currentTemp = this.currentTemp;
            response.highTemp = this.highTemp;
            response.lowestTemp = this.lowestTemp;
            response.icon = this.icon;
            response.statusCode = this.statusCode;
            response.message = this.message;

            return response;
        }
    }
}
