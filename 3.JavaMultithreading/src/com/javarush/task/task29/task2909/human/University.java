package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private int age;
    private List<Student> students = new ArrayList<>();

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        for(Student student : students) {
            if (student.getAverageGrade() == averageGrade) {
                return student;
            }
        }
        //TODO:
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        int MaxAverageGrade = 0;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getAverageGrade() > students.get(MaxAverageGrade).getAverageGrade()) {
                MaxAverageGrade = i;
            }
        }
        //TODO:
        return students.size() == 0 ? null: students.get(MaxAverageGrade);
    }

    public Student getStudentWithMinAverageGrade() {
        int MinAverageGrade = 0;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getAverageGrade() < students.get(MinAverageGrade).getAverageGrade()) {
                MinAverageGrade = i;
            }
        }
        //TODO:
        return students.size() == 0 ? null: students.get(MinAverageGrade);//TODO:
    }

    public void expel(Student student) {
        students.remove(student);
    }
}