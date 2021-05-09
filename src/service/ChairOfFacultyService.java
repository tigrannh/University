package service;

import model.ChairOfFaculty;
import model.HeadOfChair;
import model.Lecturer;

import java.util.ArrayList;
import java.util.Scanner;

public class ChairOfFacultyService {

    public static ChairOfFaculty create() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter name of faculty chair");
        String name = s.nextLine();

        HeadOfChair head = HeadOfChairService.create();

        ChairOfFaculty chair = new ChairOfFaculty(name);
        chair.setHeadOfChair(head);

        System.out.println("Enter count of lecturers in chair of faculty");
        int count = Integer.parseInt(s.nextLine());

        ArrayList<Lecturer> lecturers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lecturers.add(LecturerService.create());
        }

        chair.setLecturers(lecturers);

        return chair;
    }

    public static int highestSalaryInChair(ChairOfFaculty chair) {
        return LecturerService.lecturersHighestSalary(chair.getLecturers());
    }

    public static void printProfessors(ChairOfFaculty chair) {
        LecturerService.printFullNamesOfProfessors(chair.getLecturers());
    }

    public static ArrayList<Lecturer> lecturersWorkingAfter(ChairOfFaculty chair, int number) {
        return LecturerService.lecturersWorkingAfter(chair.getLecturers(), number);
    }

    public static void sortLecturersBySalary(ChairOfFaculty chair) {
        LecturerService.sortBySalary(chair.getLecturers());
    }

    public static void sortLecturersByWorkYear(ChairOfFaculty chair) {
        LecturerService.sortByWorkingYear(chair.getLecturers());
    }

    public static void printEmailsOfLectWorkInOtherUniver(ChairOfFaculty chair) {
        System.out.println(LecturerService.emailsOfLectWorkInOtherUniver(chair.getLecturers()));
    }

    public static int countOfFemaleLecturers(ChairOfFaculty chair){
        return LecturerService.countOfFemaleLecturers(chair.getLecturers());
    }

    public static int countOfAllLecturers(ArrayList<ChairOfFaculty> chairs){
        int count = 0;
            for (ChairOfFaculty chair : chairs) {
                    count += chair.getLecturers().size();
            }
        return count;
    }

}
