# metar-with-tdd - Parsing and Decoding METAR Data Exercise
A TDD exercise based on parsing and decoding aviation weather METAR data in Java. A typical METAR looks like this:

     CYOW 081900Z 33007KT 15SM -RA SCT030TCU BKN100 BKN180 24\/22 A2984 RMK TCU4AC2AC1 SLP107 DENSITY ALT 1600FT

This is read as:
 - Station: Ottawa Macdonald/Cartier Airport, ICAO code 'CYOW'
 - Reporting Time: the day of the month 08, time in 'Zulu' or UTC 19:00
 - Wind Velocity: 330 degrees at 7 knots
 - Visibility: 15 statute miles
 - Conditions: -RA, rain
 - Clouds:
   - Scattered, 3000 feet AGL (above ground level), towering cumulus (TCU)
   - Broken, 10000 feet AGL
   - Broken, 18000 feet AGL
 - Temperature & Dewpoint: 24C and 22C, respectively
 - Altimeter Setting: 29.84 inches of mercury
 - Remarks: (not implementing them in this exercise)

The definitions and specifications used for the code are found in [MANOBS Manual of Surface Weather Observations: aviation routine weather report from Environment Canada](https://www.canada.ca/en/environment-climate-change/services/weather-manuals-documentation/manobs-surface-observations/aviation-routine-report.html).

The `master` branch contains the final version of the Java code used in the TDD exercise. Interim steps are contained in the various branches.

The overall goals of the exercise were:
 - using a truly test-driven approach to building code
 - focusing on what's really important first, in this case parsing & decoding the raw METAR rather than building the service to retrieve it
 - showing that you can ship a usable product without needing 100% of the functionality completed
 - not requiring a mocking library in order to create test doubles (one can be used, but isn't necessary)
 - using concrete examples of data to drive design and development
