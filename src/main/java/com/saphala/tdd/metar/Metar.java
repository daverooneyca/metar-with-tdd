package com.saphala.tdd.metar;

import java.util.Arrays;
import java.util.List;

public class Metar {

   public static final int STATION_INDEX = 0;
   public static final int REPORT_TIME_INDEX = 1;
   public static final int WINDS_INDEX = 2;
   public static final int VISIBILITY_INDEX = 3;
   public static final int WEATHER_INDEX = 4;
   public static final int CLOUDS_BEGIN_INDEX = 5;
   
   public static final int TEMPERATURE_OFFSET = 0;
   private static final int ALTIMETER_OFFSET = 1;

   
   private String rawMetar;
   private String[] rawMetarArray;

   public Metar(String metar) {
      this.rawMetar = metar;
      this.rawMetarArray = this.rawMetar.split(" ");
   }

   public List<String> extractClouds() {
      int cloudsEndIndex = getCloudsEndIndex();
      
      int cloudsBeginIndex = getCloudsBeginIndex();
      List<String> clouds = Arrays.asList(rawMetarArray).subList(cloudsBeginIndex, cloudsEndIndex);
            
      return clouds;
   }

   public String getItemAt(int index) {
      return rawMetarArray[index];
   }

   public String extractTemperature() {
      return getItemAt(getCloudsEndIndex() + TEMPERATURE_OFFSET);
   }

   private int getCloudsEndIndex() {
      int cloudsBeginIndex = getCloudsBeginIndex();
      int cloudsEndIndex = cloudsBeginIndex;
      
      for (int i = cloudsBeginIndex; i < rawMetarArray.length; i++) {
         if(Character.isDigit(rawMetarArray[i].charAt(0))) {
            break;
         }
         
         cloudsEndIndex++;
      }
      return cloudsEndIndex;
   }

   private int getCloudsBeginIndex() {
      int cloudsBeginIndex = VISIBILITY_INDEX;
      
      List<String> cloudPrefixes = Arrays.asList(new String[]{"SKC", "FEW", "SCT", "BKN", "OVC"});
      
      for (int i = VISIBILITY_INDEX; i < rawMetarArray.length; i++) {
         String element = rawMetarArray[i];
         
         String prefix = prefixFrom(element);
         
         if(cloudPrefixes.contains(prefix)) {
            break;
         }
         
         cloudsBeginIndex++;
      }
      
      return cloudsBeginIndex;
   }

   private String prefixFrom(String element) {
      if (element.length() < 3) {
         return element;
      }
      
      return element.substring(0, 3);
   }

   public String extractAltimeter() {
      return getItemAt(getCloudsEndIndex() + ALTIMETER_OFFSET);
   }
}
