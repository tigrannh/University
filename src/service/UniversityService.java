package service;

import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class UniversityService {
    public static University create() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter name of university");
        String name = s.nextLine();

        System.out.println("Enter year of foundation");
        int year = Integer.parseInt(s.nextLine());

        System.out.println("Enter type of university (public/private)");
        String type = s.nextLine();

        System.out.println("Enter country of university");
        String country = s.nextLine();

        System.out.println("Enter town of university");
        String town = s.nextLine();

        System.out.println("Enter address of university");
        String address = s.nextLine();

        System.out.println("Enter email of university");
        String email = s.nextLine();

        System.out.println("Enter phone number of university");
        String number = s.nextLine();

        System.out.println("Is university in top? (y/n)");
        boolean top = s.nextLine().charAt(0) == 'y';


        Rector rector = RectorService.create();

        System.out.println("Enter number of university faculties");
        int count = Integer.parseInt(s.nextLine());

        ArrayList<Faculty> faculties = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            faculties.add(FacultyService.create());
        }

        University university = new University(name, type, country, town, address, year);
        university.setEmail(email);
        university.setPhoneNumber(number);
        university.setTopUniversity(top);
        university.setRector(rector);
        university.setFaculties(faculties);

        return university;
    }

    public static int numberOfFaculties(University university) {
        return university.getFaculties().size();
    }

    public static void printCountOfTopUniverInArm(University[] universities) {
        int count = 0;
        for (University university : universities) {
            if (university.getCountry().equals("Armenia") && university.isTopUniversity()) {
                ++count;
            }
        }
        System.out.println(count);
    }

    public static void printFullAddress(University university) {
        System.out.println(new StringBuilder().append(university.getCountry())
                                                .append(",")
                                                .append(university.getTown())
                                                .append(",")
                                                .append(university.getAddress())
                            );
    }

    public static void printPublicUniversities(University[] universities){
        for (University university : universities){
            if (university.getType().equals("public") || university.getType().equals("Public"))
                System.out.println(university.getName());
        }
    }

    public static ArrayList<String> facultyWithMostStudents(University university) {
        return FacultyService.facultiesWithMostStudents(university.getFaculties());
    }

    public static int allStudentCount(University university) {
        return FacultyService.allStudentsCount(university.getFaculties());
    }

    public static int allLecturersCountInUniversity(University university) {
        int count = 0;
        for (Faculty faculty : university.getFaculties()) {
            count += FacultyService.allLecturersCountInFac(faculty);
        }
        return count;
    }

    public static int allChairsCount(University university) {
        int count = 0;
        for (Faculty faculty : university.getFaculties()){
            count += faculty.getChairsOfFaculty().size();
        }
        return count;
    }

    public static void printHighestSalariesInChairs(University university) {
        for (Faculty faculty : university.getFaculties()) {
            for (ChairOfFaculty chair : faculty.getChairsOfFaculty()){
                System.out.println(chair.getName() + ": " + ChairOfFacultyService.highestSalaryInChair(chair));
            }
        }
    }


    public static ArrayList<Dean> getDeans(University university){
        ArrayList<Dean> deans = new ArrayList<>();
        for (Faculty faculty : university.getFaculties()){
            deans.add(faculty.getDean());
        }
        return deans;
    }
}
