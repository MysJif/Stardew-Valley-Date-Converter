# Stardew Valley Date Converter
Converts Gregorian Calender dates to Stardew Valley dates.

Process:

1. Converts Gregorian date into a day of the year. (January the 1st being the first day of the year.)

2. Adjusts this day number so that the year starts with spring.

3. Adds 1 to this day number if the year is a leap year.

4. Converts the adjusted Gregorian day number to Stardew Valley day number.
  (gregDayNumber / gregYearLength(depending on Leap Year) * 112(SV Year Length) = SV Day of Year.
  
5. Determines Season the day number falls in, and the day of week the day number would be.

6. Converts the day of year to day of month(season).

7. Returns Day of week, day of month, and season.
