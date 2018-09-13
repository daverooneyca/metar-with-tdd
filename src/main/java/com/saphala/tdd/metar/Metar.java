package com.saphala.tdd.metar;

import java.util.List;

public class Metar {
   
   private String station;
   private String reportTime;
   private String winds;
   private String visibility;
   private List<String> weather;
   private List<String> clouds;
   private String temperature;
   private String altimeter;
   

   public String getStation() {
      return this.station;
   }

   public void setStation(String station) {
      this.station = station;
   }

   public String getReportTime() {
      return reportTime;
   }

   public void setReportTime(String reportTime) {
      this.reportTime = reportTime;
   }

   public String getWinds() {
      return winds;
   }

   public void setWinds(String winds) {
      this.winds = winds;
   }

   public String getVisibility() {
      return visibility;
   }

   public void setVisibility(String visibility) {
      this.visibility = visibility;
   }

   public List<String> getWeather() {
      return weather;
   }

   public void setWeather(List<String> weather) {
      this.weather = weather;
   }

   public List<String> getClouds() {
      return clouds;
   }

   public void setClouds(List<String> clouds) {
      this.clouds = clouds;
   }

   public String getTemperature() {
      return temperature;
   }

   public void setTemperature(String temperature) {
      this.temperature = temperature;
   }

   public String getAltimeter() {
      return altimeter;
   }

   public void setAltimeter(String altimeter) {
      this.altimeter = altimeter;
   }

}
