package gregoriandate2stardewdateconverter;

public class Methods
{
    public int day365(int month, int day) //returns day out of 365
    {
        int dayOfYear = 0;
        if (month >= 1)
        {
            dayOfYear = day;
        }
        if (month >= 2)
        {
            dayOfYear += 31;
        }
        if (month >= 3)
        {
            dayOfYear += 28;
        }
        if (month >= 4)
        {
            dayOfYear += 31;
        }
        if (month >= 5)
        {
            dayOfYear += 30;
        }
        if (month >= 6)
        {
            dayOfYear += 31;
        }
        if (month >= 7)
        {
            dayOfYear += 30;
        }
        if (month >= 8)
        {
            dayOfYear += 31;
        }
        if (month >= 9)
        {
            dayOfYear += 31;
        }
        if (month >= 10)
        {
            dayOfYear += 30;
        }
        if (month >= 11)
        {
            dayOfYear += 31;
        }
        if (month >= 12)
        {
            dayOfYear += day;
        }
        
        return dayOfYear;
    }
    
    public boolean isLeapYear(int year) //returns true if year is boolean
    {
        if((year%4 == 0 ) && !(year%100==0 && year%400 != 0))
        {
            return true;
        }
        return false;
    }
    
    public int dayOfYearAdjust(int dayOfYear) //Adjusts day out of 365 so year starts at spring
    {
        int adjDay;
        if(dayOfYear < 79)
        {
            adjDay = dayOfYear + 287;
        }
        else
        {
            adjDay = dayOfYear - 78;
        }
        
        return adjDay;
    }
    
    public int leapYearAdjust(int dayOfYear, int year) //Adjusts day of year if it is a leap year
    {
        if(isLeapYear(year))
        {
            return dayOfYear+1;
        }
        return dayOfYear;
    }
    
    public int convertDayOfYear(int dayOfYear, int year) //Converts day of year to Stardew day of year
    {
        int yearAmnt = 365;
        
        if(isLeapYear(year))
        {
            yearAmnt++;
        }
        
        return (int)(((double)(dayOfYear) / (double)(yearAmnt)) * 112);
    }
    
    public int sdMonthInt(int convertedDate) //finds out which Stardew season Stardew day of year is
    {
        if(convertedDate <= 28)
        {
            return 1;
        }
        else if(convertedDate <= 56)
        {
            return 2;
        }
        else if(convertedDate <= 84)
        {
            return 3;
        }
        else
        {
            return 4;
        }
    }
    
    public int dayOfMonth(int convertedDate) //returns the day of the season 
    {
        int month = sdMonthInt(convertedDate);
        
        if(month == 1)
        {
            return convertedDate;
        }
        else if(month == 2)
        {
            return convertedDate - 28;
        }
        else if(month == 3)
        {
            return convertedDate - 56;
        }
        else
        {
            return convertedDate - 84;
        }
    }
    
    public String getSeason(int convertedDate) //returns the Season
    {
        int month = sdMonthInt(convertedDate);
        if(month == 1)
        {
            return "Spring";
        }
        else if(month == 2)
        {
            return "Summer";
        }
        else if(month == 3)
        {
            return "Fall";
        }
        else
        {
            return "Winter";
        }
    }
    
    public String getSDWeek(int dayOfSeason)
    {
        int day = dayOfSeason;
        while(day > 7)
        {
            day -= 7;
        }
        
        if(day == 1)
        {
            return "Monday";
        }
        else if(day == 2)
        {
            return "Tuesday";
        }
        else if(day == 3)
        {
            return "Wednesday";
        }
        else if(day == 4)
        {
            return "Thursday";
        }
        else if(day == 5)
        {
            return "Friday";
        }
        else if(day == 6)
        {
            return "Saturday";
        }
        else
        {
            return "Sunday";
        }
    }
    public String fullConversion(int month, int day, int year)
    {
        int dayOfIRLYear = day365(month, day);
        int dayOfSpringYear = dayOfYearAdjust(dayOfIRLYear);
        int dayLeapYearAdj =  leapYearAdjust(dayOfSpringYear, year);
        int sdDayOfYear =  convertDayOfYear(dayLeapYearAdj, year);
        int dayOfSeason = dayOfMonth(sdDayOfYear);
        String season = getSeason(sdDayOfYear);
        String dayOfWeek = getSDWeek(dayOfSeason);
        
        return dayOfWeek + ", " + dayOfSeason + ", " + season;
    }
}
