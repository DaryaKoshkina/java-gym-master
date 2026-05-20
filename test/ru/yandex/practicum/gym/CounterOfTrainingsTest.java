package ru.yandex.practicum.gym;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.*;

public class CounterOfTrainingsTest {

    private Coach coach;
    private Timetable timetable;
    private CounterOfTrainings counter;

    @BeforeEach
    public void initTimetable() {
        System.out.println("Инициализируем расписание и одну тренировку");
        timetable = new Timetable();
        counter = new CounterOfTrainings();
        coach = new Coach("Васильев", "Николай", "Сергеевич");
        Group groupAdult = new Group("Акробатика для взрослых", Age.ADULT, 90);
        TrainingSession thursdayAdultTrainingSession = new TrainingSession(groupAdult, coach,
                DayOfWeek.THURSDAY, new TimeOfDay(20, 0));
        timetable.addNewTrainingSession(thursdayAdultTrainingSession);
        counter.addCoachToMap(coach);
    }

    @Test
    void testAddCoachToCounter() {
        // Проверить, что каунтер стал 1
        assertTrue(counter.getCoachMap().containsKey(coach));
        assertEquals(1, counter.getCoachMap().get(coach));
    }

    @Test
    void testCounterFromHighesToLowest(){
        Coach coach2 = new Coach("Петрова", "Анна", "Валерьевна");
        Group groupChild = new Group("Акробатика для детей", Age.CHILD, 60);
        TrainingSession mondayChildTrainingSession = new TrainingSession(groupChild, coach2,
                DayOfWeek.MONDAY, new TimeOfDay(15, 0));
        TrainingSession thursdayChildTrainingSession = new TrainingSession(groupChild, coach2,
                DayOfWeek.THURSDAY, new TimeOfDay(17, 0));
        TrainingSession saturdayChildTrainingSession = new TrainingSession(groupChild, coach2,
                DayOfWeek.SATURDAY, new TimeOfDay(18, 0));
        timetable.addNewTrainingSession(mondayChildTrainingSession);
        timetable.addNewTrainingSession(thursdayChildTrainingSession);
        timetable.addNewTrainingSession(saturdayChildTrainingSession);
        counter.addCoachToMap(coach2);
        counter.addCoachToMap(coach2);
        counter.addCoachToMap(coach2);
        ArrayList<Coach> sortedCoach = counter.getSortedCoaches();
        assertEquals(coach2, sortedCoach.get(0));
        assertEquals(coach, sortedCoach.get(1));
    }

    @Test
    void testCounterFroLowestToHigh(){
        Coach coach2 = new Coach("Петрова", "Анна", "Валерьевна");
        Group groupChild = new Group("Акробатика для детей", Age.CHILD, 60);
        TrainingSession mondayChildTrainingSession = new TrainingSession(groupChild, coach2,
                DayOfWeek.MONDAY, new TimeOfDay(15, 0));
        TrainingSession thursdayChildTrainingSession = new TrainingSession(groupChild, coach2,
                DayOfWeek.THURSDAY, new TimeOfDay(17, 0));
        TrainingSession saturdayChildTrainingSession = new TrainingSession(groupChild, coach2,
                DayOfWeek.SATURDAY, new TimeOfDay(18, 0));
        timetable.addNewTrainingSession(mondayChildTrainingSession);
        timetable.addNewTrainingSession(thursdayChildTrainingSession);
        timetable.addNewTrainingSession(saturdayChildTrainingSession);
        counter.addCoachToMap(coach2);
        counter.addCoachToMap(coach2);
        counter.addCoachToMap(coach2);

        ArrayList<Coach> sortedCoach = counter.getSortedCoaches();
        assertEquals(coach2, sortedCoach.get(0));
        assertEquals(coach, sortedCoach.get(1));
    }
}
