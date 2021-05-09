package model;

public class Human implements PrintInfo{
    protected String firstName = "Adam";
    protected String lastName = "Adamyan";
    protected int yearOfBirth = 1;
    protected String nationality = "armenian";
    protected char gender = 'm';

    @Override
    public String toString() {
        return new StringBuilder()
                .append(firstName)
                .append(",")
                .append(lastName)
                .append(",")
                .append(yearOfBirth)
                .append(",")
                .append(nationality)
                .append(",")
                .append(gender).toString();
    }

    @Override
    public void print() {
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Year of birth: " + yearOfBirth);
        System.out.println("Nationality: " + nationality);
        System.out.println("Gender: " + (gender == 'm' ? "male" : "female"));
    }

    public Human(String firstName, String lastName, int yearOfBirth, String nationality, char gender) {
        setFirstName(firstName);
        setLastName(lastName);
        setYearOfBirth(yearOfBirth);
        setNationality(nationality);
        setGender(gender);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (startsWithCapital(firstName)) {
            this.firstName = firstName;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (startsWithCapital(lastName)) {
            this.lastName = lastName;
        }
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        if (yearOfBirth > 0) {
            this.yearOfBirth = yearOfBirth;
        }
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        if(!nationality.isEmpty()) {
            this.nationality = nationality;
        }
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        if (gender == 'm' || gender == 'f') {
            this.gender = gender;
        }
    }

    protected boolean startsWithCapital(String string) {
        return (!string.isEmpty()) && (string.charAt(0) >= 'A') && (string.charAt(0) <= 'Z');
    }
}


