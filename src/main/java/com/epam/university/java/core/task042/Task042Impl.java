package com.epam.university.java.core.task042;

import java.util.List;

public class Task042Impl implements Task042 {
    @Override
    public BookingResponse checkAvailability(List<String> schedule, String currentTime) {
        if (schedule == null || currentTime == null) {
            throw new IllegalArgumentException();
        }
        if (schedule.size() == 0) {
            if (parseTime(currentTime) >= parseTime("18:00")) {
                return new BusyResponse();
            } else if (parseTime(currentTime) < parseTime("09:00")) {
                TimeProposalResponse timeToMeet = new TimeProposalResponse();
                timeToMeet.setProposedTime("09:00");
                return timeToMeet;
            } else {
                return new AvailableResponse();
            }
        }
        return null;
    }

    private int parseTime(String time) {
        int hours = Integer.parseInt(time.split(":")[0]);
        int minutes = Integer.parseInt(time.split(":")[1]);
        return 60 * hours + minutes;
    }
}
