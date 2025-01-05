package ru.courses.OOP_7;

public class Department {
    private String name;
    private Employee boss;

    public Department(String name, Employee boss) {
        this.name = name;
        privateSetBoss(boss);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getBoss() {
        return boss;
    }

    public void setBoss(Employee boss) {
        privateSetBoss(boss);
    }

    private void privateSetBoss(Employee boss) {
        if (boss != null && !boss.getDepartment().equals(this))
            throw new IllegalArgumentException("Начальник должен работать в этом отделе");
        this.boss = boss;
    }

    @Override
    public String toString() {
        return "В отделе " + name +" начальник " + boss.getName();
    }

 }
