package com.epam.university.java.core.task042;

import java.util.ArrayList;
import java.util.List;

public class Task042Impl implements Task042 {
    final String START_OF_THE_DAY = "09:00";
    final String END_OF_THE_DAY = "18:00";
    @Override
    public BookingResponse checkAvailability(List<String> schedule, String currentTime) {
        //handling nulls
        if (schedule == null || currentTime == null) {
            throw new IllegalArgumentException();
        }
        //handling empty lists
        if (schedule.size() == 0) {
            if (parseTime(currentTime) >= parseTime(END_OF_THE_DAY)) {
                return new BusyResponse();
            } else if (parseTime(currentTime) < parseTime(START_OF_THE_DAY)) {
                TimeProposalResponse timeToMeet = new TimeProposalResponse();
                timeToMeet.setProposedTime(START_OF_THE_DAY);
                return timeToMeet;
            } else {
                return new AvailableResponse();
            }
        }
        //TODO: here should be code to process non-empty Lists
        //getting the list of gaps in the schedule
        List<String> freeTime = new ArrayList<>();
        String startOfFirstMeeting = schedule.get(0).split("-")[0];
        if (parseTime(startOfFirstMeeting) > parseTime(START_OF_THE_DAY)) {
            freeTime.add(String.join("-", START_OF_THE_DAY, startOfFirstMeeting));
        }
        for (int i = 0; i < schedule.size() - 1; i++) {
            String endOfCurrentPeriod = schedule.get(i).split("-")[1];
            String startOfNextPeriod = schedule.get(i + 1).split("-")[0];
            boolean hasGap = parseTime(startOfNextPeriod) - parseTime(endOfCurrentPeriod) > 0;
            if (hasGap) {
                String freePeriod = String.join("-", endOfCurrentPeriod, startOfNextPeriod);
                freeTime.add(freePeriod);
            }
        }
        String endOfLastMeeting = schedule.get(schedule.size() - 1).split("-")[1];
        if (parseTime(endOfLastMeeting) < parseTime(END_OF_THE_DAY)) {
            freeTime.add(String.join("-", endOfLastMeeting, END_OF_THE_DAY));
        }
        // finding the nearest free time if that exists.
        // check if time is actually in a schedule gap
        for (int i = 0; i < freeTime.size(); i++) {
            String currentPeriod = freeTime.get(i);
            if (isInside(currentTime, currentPeriod)) {
                return new AvailableResponse();
            }
        }
        //finding the nearest gap and return TimeProposalResponse

        return null;
    }

    private int parseTime(String time) {
        int hours = Integer.parseInt(time.split(":")[0]);
        int minutes = Integer.parseInt(time.split(":")[1]);
        return 60 * hours + minutes;
    }

    private boolean isInside(String currentTime, String period) {
        int start = parseTime(period.split("-")[0]);
        int end = parseTime(period.split("-")[1]);
        int time = parseTime(currentTime);
        if (time < end && time >= start) {
            return true;
        }
        return false;
    }

}
