package siit.homework10;

import java.time.Duration;

public class Athlete {
    private final Integer number;
    private final String name;
    private final String countryCode;
    private final Duration totalTime;
    private final String convertedTime;

    public Athlete(Integer number, String name, String countryCode, Duration totalTime) {
        this.number = number;
        this.name = name;
        this.countryCode = countryCode;
        this.totalTime = totalTime;
        convertedTime = ConvertTime.convertTime(totalTime);
    }

    public Duration getTotalTime() {
        return totalTime;
    }

    public String getName() {
        return name;
    }

    public String getConvertedTime() {
        return convertedTime;
    }
}
