package OOP_8.Student;

import java.util.ArrayList;
import java.util.List;

public final class Student {
    private final List<Object> grades = new ArrayList<>();
    String name;
    Rule rule;

    public Student(String name, Rule rule) {
        this.name = name;
        this.rule = rule;
    }

    public void addGrade(int grade) {
        if (rule.check(grade)) grades.add(grade);
    }

    public String toString() {
        return "Student{" + " grades =" + grades + ", name=" + name + '}';
    }
}
