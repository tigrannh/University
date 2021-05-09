package model;

import java.util.ArrayList;

public class Faculty implements PrintInfo {
    private String name = "General";
    private Dean dean;
    private ArrayList<ChairOfFaculty> chairsOfFaculty;
    private ArrayList<Student> students;

    @Override
    public String toString() {
        return new StringBuilder()
                .append(name)
                .append("\n")
                .append(dean)
                .append("\n")
                .append(chairsOfFaculty)
                .append("\n")
                .append(students).toString();

    }

    @Override
    public void print() {
        System.out.println("Faculty: " + name);
        System.out.println("---------------------------------------");
        dean.print();
        System.out.println("---------------------------------------");
        System.out.println("Students: " + students);
        for (Student student : students) {
            System.out.println("---------------------------");
            student.print();
            System.out.println("---------------------------");
        }
        System.out.println("---------------------------------------");
        System.out.println("Chairs of faculty: " + chairsOfFaculty);
        for (ChairOfFaculty chair : chairsOfFaculty) {
            System.out.println("---------------------------");
            chair.print();
            System.out.println("---------------------------");

        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.isEmpty() && (name.charAt(0) >= 'A') && (name.charAt(0) <= 'Z')) {
            this.name = name;
        }
    }

    public Dean getDean() {
        return dean;
    }

    public void setDean(Dean dean) {
        this.dean = dean;
    }

    public ArrayList<ChairOfFaculty> getChairsOfFaculty() {
        return chairsOfFaculty;
    }

    public void setChairsOfFaculty(ArrayList<ChairOfFaculty> chairsOfFaculty) {
        this.chairsOfFaculty = chairsOfFaculty;
    }

    public void addChairOfFaculty(ChairOfFaculty chairOfFaculty) {
        if (chairOfFaculty != null) {
            if(this.chairsOfFaculty == null) this.chairsOfFaculty = new ArrayList<>();
            this.chairsOfFaculty.add(chairOfFaculty);
        }
    }

    public void addChairsOfFaculty(ArrayList<ChairOfFaculty> chairsOfFaculty) {
        if (this.chairsOfFaculty == null) this.chairsOfFaculty = new ArrayList<>();
        this.chairsOfFaculty.addAll(chairsOfFaculty);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public void addStudents(ArrayList<Student> students) {
        if (this.students == null) this.students = new ArrayList<>();
        this.students.addAll(students);
    }

    public void addStudent(Student student) {
        if (student != null) {
            if (this.students == null) this.students = new ArrayList<>();
            this.students.add(student);
        }
    }

    public Faculty(String name) {
        if (!name.isEmpty()) {
            this.name = name;
        }
    }

}
