package model;

import java.util.ArrayList;

public class ChairOfFaculty implements PrintInfo{
    private String name = "New Chair";
    private HeadOfChair headOfChair;
    private ArrayList<Lecturer> lecturers;

    @Override
    public String toString() {
        return new StringBuilder()
                .append(name)
                .append("\n")
                .append(headOfChair)
                .append("\n")
                .append(lecturers)
                .append("\n").toString();
    }

    @Override
    public void print() {
        System.out.println("Chair of faculty: " + name);
        System.out.println("--------------------");
        headOfChair.print();
        System.out.println("--------------------");
        System.out.println("Lecturers: " + lecturers);
        for (Lecturer lecturer : lecturers) {
            System.out.println("----------------");
            lecturer.print();
            System.out.println("----------------");
        }
    }

    public ChairOfFaculty(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.isEmpty()) {
            this.name = name;
        }
    }

    public HeadOfChair getHeadOfChair() {
        return headOfChair;
    }

    public void setHeadOfChair(HeadOfChair headOfChair) {
        this.headOfChair = headOfChair;
    }

    public ArrayList<Lecturer> getLecturers() {
        return lecturers;
    }

    public void setLecturers(ArrayList<Lecturer> lecturers) {
        this.lecturers = lecturers;
    }

    public void addLecturers(ArrayList<Lecturer> lecturers) {
        if (this.lecturers == null) this.lecturers = new ArrayList<>();
        this.lecturers.addAll(lecturers);
    }

    public void addLecturer(Lecturer lecturer) {
        if (lecturer != null) {
            if(this.lecturers == null) {
                this.lecturers = new ArrayList<>();
            }
            this.lecturers.add(lecturer);
        }
    }
}
