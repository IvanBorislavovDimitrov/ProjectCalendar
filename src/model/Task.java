package model;

public class Task {

    private String hour;
    private String location;
    private String description;

    public Task(String hour, String location, String description) {
        if (isHourValid(hour)) {
            this.hour = hour;
        } else {
            // will show error box
        }
        this.location = location;
        this.description = description;
    }

    public Task() { }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        if (isHourValid(hour)) {
            this.hour = hour;
        } else {
            // will show error box
        }
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private boolean isHourValid(String hour) {
        String[] hoursAndMinutes = hour.split("[:]");
        try {
            byte currentHours = Byte.parseByte(hoursAndMinutes[0].trim());
            byte currentMinutes = 0;
            if (hoursAndMinutes.length == 2) {
                currentMinutes = Byte.parseByte(hoursAndMinutes[1].trim());
            }
            if ((currentHours < 0 || currentHours > 24) || (currentMinutes < 0 || currentMinutes > 60)) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
}
