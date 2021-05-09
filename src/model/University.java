package model;

import java.util.ArrayList;

public class University implements PrintInfo {
    private String name = "Main University";
    private final int yearOfFoundation;
    private String type = "public";   //private or public university
    private String country = "Armenia";
    private String town = "Yerevan";
    private String address = "Main address";
    private String email;
    private String phoneNumber;
    private boolean isTopUniversity;
    private static int countOfAllUniversities;
    private ArrayList<Faculty> faculties;
    private Rector rector;

    @Override
    public String toString() {
        return new StringBuilder()
                .append(name)
                .append(",")
                .append(yearOfFoundation)
                .append(",")
                .append(type)
                .append(",")
                .append(country)
                .append(",")
                .append(town)
                .append(",")
                .append(address)
                .append(",")
                .append(email)
                .append(",")
                .append(phoneNumber)
                .append(",")
                .append(isTopUniversity)
                .append("\n")
                .append(rector)
                .append("\n")
                .append(faculties).toString();
    }

    @Override
    public void print() {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("University: " + name);
        System.out.println("Year of foundation: " + yearOfFoundation);
        System.out.println("Type: " + type);
        System.out.println("Country: " + country);
        System.out.println("Town: " + town);
        System.out.println("Address: " + address);
        System.out.println("Email: " + email);
        System.out.println("Phone number: " + phoneNumber);
        System.out.println("Is top university?: " + (isTopUniversity ? "Yes" : "No"));
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Rector: ");
        rector.print();
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Faculties: " + faculties);
        for (Faculty faculty : faculties) {
            System.out.println("-------------------------------------------------");
            faculty.print();
            System.out.println("-------------------------------------------------");
        }
        System.out.println("-----------------------------------------------------------------------------");
    }

    public University(String name, String type, String country, String town, String address, int yearOfFoundation) {
        setName(name);
        setType(type);
        setCountry(country);
        setTown(town);
        setAddress(address);
        this.yearOfFoundation = yearOfFoundation > 0 ? yearOfFoundation : 1900;
        ++countOfAllUniversities;
    }

    public boolean isTopUniversity() {
        return isTopUniversity;
    }

    public void setTopUniversity(boolean topUniversity) {
        isTopUniversity = topUniversity;
    }

    public ArrayList<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(ArrayList<Faculty> faculties) {
        this.faculties = faculties;
    }

    public void addFaculty(Faculty faculty){
        if (faculty != null) {
            if(this.faculties == null) this.faculties = new ArrayList<>();
            this.faculties.add(faculty);
        }
    }

    public void addFaculties(ArrayList<Faculty> faculties){
        if (this.faculties == null) this.faculties = new ArrayList<>();
        this.faculties.addAll(faculties);
    }

    public Rector getRector() {
        return rector;
    }

    public void setRector(Rector rector) {
        this.rector = rector;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (startsWithCapital(name)) {
            this.name = name;
        }
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if(type.equals("public") || type.equals("private")) {
            this.type = type;
        }
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if (startsWithCapital(country)) {
            this.country = country;
        }
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        if (startsWithCapital(town)) {
            this.town = town;
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (startsWithCapital(address)) {
            this.address = address;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String number) {
            this.phoneNumber = number;
    }

    public static int getCountOfAllUniversities() {
        return countOfAllUniversities;
    }

    private boolean startsWithCapital(String string) {
        return (!string.isEmpty()) && (string.charAt(0) >= 'A') && (string.charAt(0) <= 'Z');
    }
}
