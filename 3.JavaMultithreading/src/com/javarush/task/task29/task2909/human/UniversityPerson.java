package com.javarush.task.task29.task2909.human;

/**
 * Created by chikishev on 21.04.17.
 */
public class UniversityPerson extends Human {
    private University university;

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public UniversityPerson(String name, int age) {
        super(name, age);
    }
}
