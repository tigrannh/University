package model;

public class Student extends Human implements Comparable<Student>{
    private String degree = "bachelor";
    private short yearOfUniversity = 1;
    private double gpa = 0;  // 0 - 20
    private int id;

    @Override
    public int compareTo(Student student) {
        return Double.compare(this.gpa,student.gpa);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(super.toString())
                .append(",")
                .append(degree)
                .append(",")
                .append(yearOfUniversity)
                .append(",")
                .append(gpa)
                .append(",")
                .append(id)
                .append("\n").toString();
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Degree: " + degree);
        System.out.println("Year at university: " + yearOfUniversity);
        System.out.println("GPA: " + gpa);
        System.out.println("ID: " + id);
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        if (degree.equals("bachelor") || degree.equals("master") || degree.equals("associate")) {
            this.degree = degree;
        }
    }

    public short getYearOfUniversity() {
        return yearOfUniversity;
    }

    public void setYearOfUniversity(short yearOfUniversity) {
        if (yearOfUniversity > 0) {
            this.yearOfUniversity = yearOfUniversity;
        }
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        if (gpa >= 0 && gpa <= 20) {
            this.gpa = gpa;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public Student(String firstName, String lastName, int yearOfBirth, String nationality, char gender, int id) {
        super(firstName, lastName, yearOfBirth, nationality, gender);
        setId(id);
    }
}
