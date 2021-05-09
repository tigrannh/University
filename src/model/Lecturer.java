package model;

public class Lecturer extends UniversityWorker {
    private int yearOfBecomingLecturer = 1900;
    private String scientificTitle = "lecturer";
    private boolean isWorkingInOtherUniver;

    @Override
    public String toString() {
        return new StringBuilder()
                .append(super.toString())
                .append(",")
                .append(yearOfBecomingLecturer)
                .append(",")
                .append(scientificTitle)
                .append(",")
                .append(isWorkingInOtherUniver)
                .append("\n").toString();
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Year of becoming lecturer: " + yearOfBecomingLecturer);
        System.out.println("Scientific title" + scientificTitle);
        System.out.println("Is working in another university?: " + (isWorkingInOtherUniver ? "Yes" : "No"));
    }

    public Lecturer(String firstName, String lastName, int yearOfBirth, String nationality, char gender, int year) {
        super(firstName, lastName, yearOfBirth, nationality, gender);
        setYearOfBecomingLecturer(year);
    }

    public int getYearOfBecomingLecturer() {
        return yearOfBecomingLecturer;
    }

    public void setYearOfBecomingLecturer(int yearOfBecomingLecturer) {
        if (yearOfBecomingLecturer > 0) {
            this.yearOfBecomingLecturer = yearOfBecomingLecturer;
        }
    }

    public String getScientificTitle() {
        return scientificTitle;
    }

    public void setScientificTitle(String scientificTitle) {
        if (!scientificTitle.isEmpty()) {
            this.scientificTitle = scientificTitle;
        }
    }

    public boolean isWorkingInOtherUniver() {
        return isWorkingInOtherUniver;
    }

    public void setWorkingInOtherUniver(boolean workingInOtherUniver) {
        isWorkingInOtherUniver = workingInOtherUniver;
    }
}
