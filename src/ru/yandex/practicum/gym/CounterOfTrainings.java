package ru.yandex.practicum.gym;

import java.util.ArrayList;
import java.util.HashMap;

public class CounterOfTrainings {

    private HashMap<Coach, Integer> coachMap = new HashMap<>();

    public HashMap<Coach, Integer> getCoachMap() {
        return coachMap;
    }

    public void setCoachMap(HashMap<Coach, Integer> coachMap) {
        this.coachMap = coachMap;
    }

    public void addCoachToMap(Coach coach){
        if(coachMap.containsKey(coach)) {
            coachMap.replace(coach, coachMap.get(coach) + 1);
        } else coachMap.put(coach,1);
    }

    public ArrayList<Coach> getSortedCoaches() {
        return new ArrayList<>();
    }
}
