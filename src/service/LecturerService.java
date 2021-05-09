package service;

import model.Lecturer;
import Comparators.SalaryComparator;
import Comparators.WorkingComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LecturerService {

    public static Lecturer create() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter lecturer's first name");
        String name = s.nextLine();

        System.out.println("Enter lecturer's last name");
        String lastName = s.nextLine();

        System.out.println("Enter lecturer's year of birth");
        int year = Integer.parseInt(s.nextLine());

        System.out.println("Enter lecturer's nationality");
        String nation = s.nextLine();

        System.out.println("Enter lecturer's gender (m/f)");
        char gender = s.nextLine().charAt(0);

        System.out.println("Enter year of becoming lecturer");
        int lecturerYear = Integer.parseInt(s.nextLine());

        System.out.println("Enter lecturer's salary");
        int salary = Integer.parseInt(s.nextLine());

        System.out.println("Enter years of working at university");
        short workYear = Short.parseShort(s.nextLine());

        System.out.println("Enter lecturer's university email");
        String email = s.nextLine();

        System.out.println("Enter lecturer's scientific title");
        String title = s.nextLine();

        System.out.println("Is lecturer working in another university? (y/n)");
        boolean work = s.nextLine().charAt(0) == 'y';

        Lecturer lecturer = new Lecturer(name, lastName, year, nation, gender, lecturerYear);
        lecturer.setSalary(salary);
        lecturer.setYearsOfWorkingAtUniversity(workYear);
        lecturer.setUniversityEmail(email);
        lecturer.setScientificTitle(title);
        lecturer.setWorkingInOtherUniver(work);

        return lecturer;
    }

    public static int lecturersHighestSalary(ArrayList<Lecturer> lecturers) {
       return Collections.max(lecturers,new SalaryComparator()).getSalary();
    }

    public static void printFullNamesOfProfessors(ArrayList<Lecturer> lecturers) {
        for (Lecturer lecturer : lecturers) {
            if (lecturer.getScientificTitle().equals("professor") || lecturer.getScientificTitle().equals("Professor")){
                System.out.println(lecturer.getFirstName() + " " + lecturer.getLastName());
            }
        }
    }

    public static ArrayList<Lecturer> lecturersWorkingAfter(ArrayList<Lecturer> lecturers, int number) {
        ArrayList<Lecturer> newLecturers = new ArrayList<>();
        for (Lecturer lecturer : lecturers) {
            if (lecturer.getYearOfBecomingLecturer() > number)
                newLecturers.add(lecturer);
        }
        return newLecturers;
    }

    public static void sortBySalary(ArrayList<Lecturer> lecturers) {
        lecturers.sort(new SalaryComparator());
    }

    public static void sortByWorkingYear(ArrayList<Lecturer> lecturers) {
        lecturers.sort(new WorkingComparator());
    }

    public static ArrayList<String> emailsOfLectWorkInOtherUniver(ArrayList<Lecturer> lecturers) {
        ArrayList<String > emails = new ArrayList<>();
        for (Lecturer lecturer : lecturers) {
            if (lecturer.isWorkingInOtherUniver())
                emails.add(lecturer.getUniversityEmail());
        }
        return emails;
    }

    public static int countOfFemaleLecturers(ArrayList<Lecturer> lecturers) {
        int count = 0;
        for (Lecturer lecturer : lecturers) {
            if (lecturer.getGender() == 'f') ++count;
        }
        return count;
    }
}
