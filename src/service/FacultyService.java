package service;

import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class FacultyService {

    public static Faculty create() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter name of faculty");
        String name = s.nextLine();

        Dean dean = DeanService.create();

        System.out.println("Enter count of faculty chairs");
        int count = Integer.parseInt(s.nextLine());

        ArrayList<ChairOfFaculty> chairs = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            chairs.add(ChairOfFacultyService.create());
        }

        System.out.println("Enter number of faculty students ");
        int count1 = Integer.parseInt(s.nextLine());

        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < count1; i++) {
            students.add(StudentService.create());
        }

        Faculty faculty = new Faculty(name);
        faculty.setDean(dean);
        faculty.setChairsOfFaculty(chairs);
        faculty.setStudents(students);
        return faculty;

    }

    public static ArrayList<String> facultiesWithMostStudents(ArrayList<Faculty> faculties) {
        ArrayList<String> names = new ArrayList<>();
        int max = -1;
        for (Faculty faculty : faculties) {
            if(faculty.getStudents() != null && faculty.getStudents().size() > max) {
                max = faculty.getStudents().size();
            }
        }
        for (Faculty faculty : faculties){
            if (faculty.getStudents() != null && faculty.getStudents().size() == max) names.add(faculty.getName());
        }
        return names;
    }

    public static int allStudentsCount(ArrayList<Faculty> faculties) {
        int count = 0;
        for (Faculty faculty : faculties) {
                count += faculty.getStudents().size();
            }
        return count;
    }

    public static int allLecturersCountInFac(Faculty faculty) {
        return ChairOfFacultyService.countOfAllLecturers(faculty.getChairsOfFaculty());
    }

    public static ArrayList<HeadOfChair> getHeadOfChairs(Faculty faculty) {
        ArrayList<HeadOfChair> heads = new ArrayList<>();
        for(ChairOfFaculty chair : faculty.getChairsOfFaculty()) {
            heads.add(chair.getHeadOfChair());
        }
        return heads;
    }

}
