package ru.yandex.practicum.gym;

import java.util.Comparator;
import java.util.HashMap;

public class CoachTrainingsComparator implements Comparator<Coach> {
    private HashMap<Coach, Integer> coachMap;

    public CoachTrainingsComparator(HashMap<Coach, Integer> coachMap) {
        this.coachMap = coachMap;
    }

    @Override
    public int compare(Coach coach1, Coach coach2) {
        Integer count1 = coachMap.get(coach1);
        Integer count2 = coachMap.get(coach2);
        return count2.compareTo(count1);
    }
}
