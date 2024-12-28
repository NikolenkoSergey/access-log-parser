package OOP_7;

public class Employee {
    private String name;
    private Department department;

    public Employee(String name, Department department) {
        this.name = name;
        privateSetDepartment(department);
    }

    private void privateSetDepartment(Department department) {
        if (department != null && department.getBoss() != this) {
            throw new IllegalStateException(
                    "Сотрудник не может быть назначен в другой отдел, если он руководитель текущего отдела.");
        }
        this.department = department;
    }

    public void setDepartment(Department department) {
        privateSetDepartment(department);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        if (this.name.equals(department.getBoss().getName())) {
            return name + " начальник отдела " + department.getName();
        }
        return name + " работает в отделе " + department.getName() + ", начальник которого " + department.getBoss().getName();
    }

}
