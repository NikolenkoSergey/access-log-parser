package ru.courses.OOP_7;

import java.util.Arrays;

public class Student {
    private final String name;
    private int[] grades;

    public Student(String name, int[] grades) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("name не может быть пустым");
        setGradesArr(grades);
        this.name = name;

    }

    public int[] getGrades() {
        return grades;
    }

    public String getName() {
        return name;
    }

    private void setGradesArr(int[] grades) {
        for (int grade : grades) {
            if (grade == 0) continue;
            if (grade < 2 || grade > 5) throw new IllegalArgumentException("Оценки должны быть в диапазоне от 2 до 5");
            this.grades = grades.clone();
        }
    }

    public void setGrades(int grade) {
        int index = 0;
        if (grade > 1 && grade < 6) {
            for (int i = 0; i < this.grades.length; i++) {
                index = i;
                if (this.grades[i] != 0 && index == this.grades.length - 1) {
                    System.out.println("Невозможно добавить оценку " + grade + " - превышен лимит");
                    return;
                }
                if (this.grades[i] == 0) {
                    this.grades[i] = grade;
                    return;
                }
            }
        } else throw new IllegalArgumentException("Оценки должны быть в диапазоне от 2 до 5");

    }

    @Override
    public String toString() {
        return name + ": " + Arrays.toString(grades);
    }

}
