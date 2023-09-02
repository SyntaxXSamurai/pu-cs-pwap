/*
 * Description: The data type Clock.java represents time on 
 * a 24-hour clock, such as 00:00, 13:30, or 23:59. Time is 
 * measured in hours (00–23) and minutes (00–59).
 */
public class Clock {
    private static final int MINIMUM_HOURS = 0;
    private static final int MINIMUM_MINUTES = 0;
    private static final int MAXIMUM_HOURS = 23;
    private static final int MAXIMUM_MINUTES = 59;

    private int iHours, iMinutes;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        if (h < Clock.MINIMUM_HOURS || h > Clock.MAXIMUM_HOURS) {
            throw new IllegalArgumentException("Hour must be between 0 and 23");
        } else if (m < Clock.MINIMUM_MINUTES || m > Clock.MAXIMUM_MINUTES) {
            throw new IllegalArgumentException("Minute must be between 0 and 59");
        }

        iHours = h;
        iMinutes = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
        String[] sClock = s.split(":");
        int iTempHour = 0;
        int iTempMin = 0;

        if (s.length() != 5 || sClock.length != 2) {
            throw new IllegalArgumentException("String must be in the formart HH:MM");
        }

        iTempHour = Integer.parseInt(sClock[0]);
        iTempMin = Integer.parseInt(sClock[1]);

        if (iTempHour < Clock.MINIMUM_HOURS || iTempHour > Clock.MAXIMUM_HOURS) {
            throw new IllegalArgumentException("Hour must be between 0 and 23");
        } else if (iTempMin < Clock.MINIMUM_MINUTES || iTempMin > Clock.MAXIMUM_MINUTES) {
            throw new IllegalArgumentException("Minute must be between 0 and 59");
        }

        iHours = iTempHour;
        iMinutes = iTempMin;
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        String iTempHour = "" + this.iHours;
        String iTempMin = "" + this.iMinutes;

        if (this.iHours < 10) {
            iTempHour = "0" + this.iHours;
        } 

        if (this.iMinutes < 10) {
            iTempMin = "0" + this.iMinutes;    
        }

        return iTempHour + ":" + iTempMin;
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if (this.iHours < that.iHours) {
            return true;
        } else if (this.iHours == that.iHours && this.iMinutes < that.iMinutes) {
            return true;
        }

        return false; 
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        if (this.iMinutes == Clock.MAXIMUM_MINUTES) {
            if (this.iHours == Clock.MAXIMUM_HOURS) {
                this.iHours = 0;
            } else {
                this.iHours++;
            }

            this.iMinutes = 0;
        } else {
            this.iMinutes++;
        }

    }

    // Adds delta minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0) {
            throw new IllegalArgumentException("Delta must be a positive integer");
        }
        
        int iAddHour = delta / 60;
        int iAddMin = delta % 60;

        this.iHours += iAddHour;
        this.iMinutes += iAddMin;
        
        if (this.iMinutes > Clock.MAXIMUM_MINUTES) {
            this.iHours++;
            this.iMinutes %= 60;
        } 

        this.iHours %= 24;
    }

    // Test client (see below).
    public static void main(String[] args) {
        Clock time = new Clock(args[0]);

        StdOut.println(time);

        time.toc(1);
        StdOut.println(time);

        time.tic();
        StdOut.println(time);
    }
}