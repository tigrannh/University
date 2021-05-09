package model;

public class HeadOfChair extends UniversityWorker {
    private int yearOfBecoming = 1900;
    private String scientificTitle = "assistant";

    @Override
    public String toString() {
        return super.toString() + "," +yearOfBecoming + "," + scientificTitle;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Year of becoming head chair: " + yearOfBecoming);
        System.out.println("Scientific title: " + scientificTitle);
    }

    public HeadOfChair(String firstName, String lastName, int yearOfBirth, String nationality, char gender, int yearOfBecoming) {
        super(firstName, lastName, yearOfBirth, nationality, gender);
        setYearOfBecoming(yearOfBecoming);
    }

    public int getYearOfBecoming() {
        return yearOfBecoming;
    }

    public void setYearOfBecoming(int yearOfBecoming) {
        if (yearOfBecoming > 0) {
            this.yearOfBecoming = yearOfBecoming;
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
}
