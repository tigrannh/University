package model;

public class Rector extends UniversityWorker {
    private int yearOfBecomingRector = 1900;

    @Override
    public String toString() {
        return super.toString() + "," + yearOfBecomingRector;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Rector becoming year: " + yearOfBecomingRector);
    }

    public int getYearOfBecomingRector() {
        return yearOfBecomingRector;
    }

    public void setYearOfBecomingRector(int yearOfBecomingRector) {
        if (yearOfBecomingRector > 0) {
            this.yearOfBecomingRector = yearOfBecomingRector;
        }
    }

    public Rector(String firstName, String lastName, int yearOfBirth, String nationality, char gender, int yearOfBecomingRector) {
        super(firstName, lastName, yearOfBirth, nationality, gender);
        setYearOfBecomingRector(yearsOfWorkingAtUniversity);
    }
}
