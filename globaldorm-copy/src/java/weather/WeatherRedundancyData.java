package weather;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

public class WeatherRedundancyData {
    
    private double latitude;
    private double longitude;

    @SerializedName("generationtime_ms")
    private double generationTime;

    @SerializedName("utc_offset_seconds")
    private int utcOffset;

    private String timezone;

    @SerializedName("timezone_abbreviation")
    private String timezoneAbv;

    private double elevation;

    @SerializedName("hourly_units")
    private Map<String, String> hourlyUnits;

    private HourlyData hourly;

    public static class HourlyData {
        private List<String> time;
        @SerializedName("temperature_2m")
        private List<Double> temperature2m;

        public List<String> getTime() {
            return time;
        }

        public void setTime(List<String> time) {
            this.time = time;
        }

        public List<Double> getTemperature2m() {
            return temperature2m;
        }

        public void setTemperature2m(List<Double> temperature2m) {
            this.temperature2m = temperature2m;
        }
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getGenerationTime() {
        return generationTime;
    }

    public void setGenerationTime(double generationTime) {
        this.generationTime = generationTime;
    }

    public int getUtcOffset() {
        return utcOffset;
    }

    public void setUtcOffset(int utcOffset) {
        this.utcOffset = utcOffset;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getTimezoneAbv() {
        return timezoneAbv;
    }

    public void setTimezoneAbv(String timezoneAbv) {
        this.timezoneAbv = timezoneAbv;
    }

    public double getElevation() {
        return elevation;
    }

    public void setElevation(double elevation) {
        this.elevation = elevation;
    }

    public Map<String, String> getHourlyUnits() {
        return hourlyUnits;
    }

    public void setHourlyUnits(Map<String, String> hourlyUnits) {
        this.hourlyUnits = hourlyUnits;
    }

    public HourlyData getHourly() {
        return hourly;
    }

    public void setHourly(HourlyData hourly) {
        this.hourly = hourly;
    }
}
