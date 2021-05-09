package service;

import model.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentService {

    public static Student create() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter student's first name");
        String name = s.nextLine();

        System.out.println("Enter student's last name");
        String lastName = s.nextLine();

        System.out.println("Enter student's year of birth");
        int year = Integer.parseInt(s.nextLine());

        System.out.println("Enter student's nationality");
        String nation = s.nextLine();

        System.out.println("Enter students gender (m/f)");
        char gender = s.nextLine().charAt(0);

        System.out.println("Enter student's ID number");
        int id = Integer.parseInt(s.nextLine());

        System.out.println("Enter student's degree");
        String degree = s.nextLine();

        System.out.println("Enter student's year at university");
        short yearAtUniv = Short.parseShort(s.nextLine());

        System.out.println("Enter student's GPA");
        double gpa = Double.parseDouble(s.nextLine());

        Student student = new Student(name, lastName, year, nation, gender, id);
        student.setDegree(degree);
        student.setYearOfUniversity(yearAtUniv);
        student.setGpa(gpa);

        return student;

    }

    public static String studentFullNameWithID(Student student){
            return new StringBuilder()
                    .append(student.getFirstName())
                    .append(" ")
                    .append(student.getLastName())
                    .append("(")
                    .append(student.getId())
                    .append(")").toString();
    }

    public static ArrayList<Integer> idsOfExcellentStudents(ArrayList<Student> students) {
        ArrayList<Integer> ids = new ArrayList<>();
        for (Student student : students) {
            if (student.getGpa() >= 18) ids.add(student.getId());
        }
        return ids;
    }

    public static void printBachelorDegreeStudents(ArrayList<Student> students){
        for (Student student : students){
            if (student.getDegree().equals("bachelor") || student.getDegree().equals("Bachelor")){
                System.out.println(studentFullNameWithID(student));
            }
        }
    }

    public static ArrayList<Student> masterDegreeFemaleStudents(ArrayList<Student> students) {
        ArrayList<Student> newStudents = new ArrayList<>();
        for (Student student : students){
            if (student.getGender() == 'f' &&
                    (student.getDegree().equals("master") || student.getDegree().equals("Master"))){
                newStudents.add(student);
            }
        }
        return newStudents;
    }

    public static ArrayList<Student> studentsWithHighestGPA(ArrayList<Student> students) {
        ArrayList<Student> newStudents = new ArrayList<>();
        if (!students.isEmpty()) {
            double maxGpa = Collections.max(students).getGpa();
            for (Student student : students) {
                if (student.getGpa() == maxGpa) newStudents.add(student);
            }
        }
        return newStudents;
    }

    public static void sortByGpa(ArrayList<Student> students) {
        Collections.sort(students);
    }

    public static Student armenianStudentWithMinGPA(ArrayList<Student> students) { //if there many students, return first one
        Student stud = null;
        for (Student student : students) {
            if (student.getNationality().equals("armenian") || student.getNationality().equals("Armenian")){
                if (stud == null) stud = student;
                else if(student.getGpa() < stud.getGpa()){
                    stud = student;
                }
            }
        }
        return stud;
    }

    public static void deleteStudentsById(ArrayList<Student> students, int id) {
        students.removeIf(student1 -> student1.getId() == id);
    }

}
