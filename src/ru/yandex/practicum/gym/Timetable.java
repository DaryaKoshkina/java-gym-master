package ru.yandex.practicum.gym;

import java.util.*;

public class Timetable {

    private final Map<DayOfWeek, TreeMap<TimeOfDay, List<TrainingSession>>> timetable  = new HashMap<>();
    public void addNewTrainingSession(TrainingSession trainingSession) {
        DayOfWeek day = trainingSession.getDayOfWeek();
        TimeOfDay time = trainingSession.getTimeOfDay();

        // 1. Если дня еще нет, создаем для него TreeMap
        if (!timetable.containsKey(day)) {
            timetable.put(day, new TreeMap<>());
        }

        TreeMap<TimeOfDay, List<TrainingSession>> dayMap = timetable.get(day);

        // 2. Если на это время еще нет тренировок, создаем новый список ArrayList
        if (!dayMap.containsKey(time)) {
            dayMap.put(time, new ArrayList<>());
        }

        // 3. Добавляем тренировку в список для этого времени
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
// Заполнить counterOfTrainings передавая Коуча циклом в цикле
        // Вызвать у counterOfTraining
        return counterOfTrainings.getSortedCoaches();
    }
}
