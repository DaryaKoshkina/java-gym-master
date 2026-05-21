package ru.yandex.practicum.gym;

import java.util.*;

public class Timetable {

    private final Map<DayOfWeek, TreeMap<TimeOfDay, List<TrainingSession>>> timetable  = new HashMap<>();
    public void addNewTrainingSession(TrainingSession trainingSession) {
        DayOfWeek day = trainingSession.getDayOfWeek();
        TimeOfDay time = trainingSession.getTimeOfDay();

        if (!timetable.containsKey(day)) {
            timetable.put(day, new TreeMap<>());
        }

        TreeMap<TimeOfDay, List<TrainingSession>> dayMap = timetable.get(day);

        if (!dayMap.containsKey(time)) {
            dayMap.put(time, new ArrayList<>());
        }

        dayMap.get(time).add(trainingSession);
    }

    public Map<TimeOfDay, List<TrainingSession>> getTrainingSessionsForDay(DayOfWeek dayOfWeek) {
        TreeMap<TimeOfDay, List<TrainingSession>> dayMap = timetable.get(dayOfWeek);
        if (dayMap == null) {
            return Map.of();
        }
        return dayMap;
    }

    public List<TrainingSession> getTrainingSessionsForDayAndTime(DayOfWeek dayOfWeek, TimeOfDay timeOfDay) {
        TreeMap<TimeOfDay, List<TrainingSession>> dayMap = timetable.get(dayOfWeek);

        if (dayMap == null) {
            return List.of();
        }

        List<TrainingSession> sessions = dayMap.get(timeOfDay);

        if (sessions == null) {
            return List.of();
        }

        return sessions;
    }

    public ArrayList<Coach> getSortedCoaches() {
        CounterOfTrainings counterOfTrainings = new CounterOfTrainings();
        for (DayOfWeek day : timetable.keySet()) {
            TreeMap<TimeOfDay, List<TrainingSession>> dailySchedule = timetable.get(day);
            if (dailySchedule != null) {
                for (List<TrainingSession> sessions : dailySchedule.values()) {
                    for(TrainingSession session : sessions) {
                        counterOfTrainings.addCoachToMap(session.getCoach());
                    }
                }
            }
        }
        return counterOfTrainings.getSortedCoaches();
    }
}
