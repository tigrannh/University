package model;

public class Dean extends UniversityWorker{
    private boolean hasScientificDegree;
    private int yearOfBecomingDean = 1900;

    @Override
    public String toString() {
        return super.toString() + "," + hasScientificDegree + "," + yearOfBecomingDean;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Has scientific degree: " + (hasScientificDegree ? "yes" : "no"));
        System.out.println("Year of becoming dean: " + yearOfBecomingDean);
    }

    public Dean(String firstName, String lastName, int yearOfBirth, String nationality, char gender, int yearOfBecomingDean) {
        super(firstName, lastName, yearOfBirth, nationality, gender);
        setYearOfBecomingDean(yearOfBecomingDean);
    }

    public boolean hasScientificDegree() {
        return hasScientificDegree;
    }

    public void setScientificDegree(boolean scientificDegree) {
        this.hasScientificDegree = scientificDegree;
    }

    public int getYearOfBecomingDean() {
        return yearOfBecomingDean;
    }

    public void setYearOfBecomingDean(int yearOfBecomingDean) {
        if (yearOfBecomingDean > 0 ) {
            this.yearOfBecomingDean = yearOfBecomingDean;
        }
    }

}
