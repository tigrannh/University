package main;

import model.*;
import service.*;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        System.out.println("Let's input first university");
        University firstUniversity = UniversityService.create();

        System.out.println("Let's input second university");
        University secondUniversity = UniversityService.create();

        University[] universities = {firstUniversity, secondUniversity};

        System.out.println("First University");
        firstUniversity.print();

        System.out.println("Second University");
        secondUniversity.print();

        ChairOfFaculty chair = firstUniversity.getFaculties().get(0).getChairsOfFaculty().get(0);
        Student student = firstUniversity.getFaculties().get(0).getStudents().get(0);
        Faculty faculty = firstUniversity.getFaculties().get(0);
        ArrayList<Dean> deans = UniversityService.getDeans(firstUniversity);
        ArrayList<HeadOfChair> heads = FacultyService.getHeadOfChairs(faculty);

        Scanner s = new Scanner(System.in);

        boolean isMenuActive = true;
        while (isMenuActive) {
            System.out.println("1. University");
            System.out.println("2. Faculties");
            System.out.println("3. Chairs of faculty");
            System.out.println("4. Rector");
            System.out.println("5. Deans");
            System.out.println("6. Head of chairs");
            System.out.println("7. Lecturers");
            System.out.println("8. Students");
            System.out.println("9. Save model to file.");
            System.out.println("10. Exit");

            int command = Integer.parseInt(s.nextLine());

            switch (command) {
                case 1:
                    System.out.println("1. Print count of all created universities.");
                    System.out.println("2. Print number of faculties in university.");
                    System.out.println("3. Print count of all top universities in Armenia from array.");
                    System.out.println("4. Print full address of university.");
                    System.out.println("5. Print names of public universities.");
                    System.out.println("6. Print faculties with the most students.");
                    System.out.println("7. Print all students count in university.");
                    System.out.println("8. Print all lecturers count in university.");
                    System.out.println("9. Print all chairs count in university.");
                    System.out.println("10. Print highest salaries in chairs of faculties");

                    command = Integer.parseInt(s.nextLine());

                    switch (command) {
                        case 1:
                            System.out.println("------------------------------------------------------------");
                            System.out.print("Count of all universities: ");
                            System.out.println(University.getCountOfAllUniversities());
                            System.out.println("------------------------------------------------------------");
                            break;
                        case 2:
                            System.out.println("------------------------------------------------------------");
                            System.out.print("Number of faculties in first university: ");
                            System.out.println(UniversityService.numberOfFaculties(firstUniversity));
                            System.out.println("------------------------------------------------------------");
                            break;
                        case 3:
                            System.out.println("------------------------------------------------------------");
                            System.out.print("Count of top universities in Armenia: ");
                            UniversityService.printCountOfTopUniverInArm(universities);
                            System.out.println("------------------------------------------------------------");
                            break;
                        case 4:
                            System.out.println("------------------------------------------------------------");
                            System.out.print("Full address of first university: ");
                            UniversityService.printFullAddress(firstUniversity);
                            System.out.println("------------------------------------------------------------");
                            break;
                        case 5:
                            System.out.println("------------------------------------------------------------");
                            System.out.print("Public universities: ");
                            UniversityService.printPublicUniversities(universities);
                            System.out.println("------------------------------------------------------------");
                            break;
                        case 6:
                            System.out.println("------------------------------------------------------------");
                            System.out.print("Faculty with most students in first university: ");
                            System.out.println(UniversityService.facultyWithMostStudents(firstUniversity));
                            System.out.println("------------------------------------------------------------");
                            break;
                        case 7:
                            System.out.println("------------------------------------------------------------");
                            System.out.print("All students count in first university: ");
                            System.out.println(UniversityService.allStudentCount(firstUniversity));
                            System.out.println("------------------------------------------------------------");
                            break;
                        case 8:
                            System.out.println("------------------------------------------------------------");
                            System.out.print("All lecturers count in first university: ");
                            System.out.println(UniversityService.allLecturersCountInUniversity(firstUniversity));
                            System.out.println("------------------------------------------------------------");
                            break;
                        case 9:
                            System.out.println("------------------------------------------------------------");
                            System.out.print("All chairs count in first university: ");
                            System.out.println(UniversityService.allChairsCount(firstUniversity));
                            System.out.println("------------------------------------------------------------");
                            break;
                        case 10:
                            System.out.println("------------------------------------------------------------");
                            System.out.println("Highest salaries in chairs: ");
                            UniversityService.printHighestSalariesInChairs(firstUniversity);
                            System.out.println("------------------------------------------------------------");
                            break;
                        default:
                            System.out.println("Invalid command number!");

                    }
                    break;

                case 2:
                    System.out.println("1. Print lecturers count in every faculty.");
                    System.out.println("2. Add new faculty to university.");

                    command = Integer.parseInt(s.nextLine());

                    switch (command) {
                        case 1:
                            System.out.println("------------------------------------------------------------");
                            System.out.println("Faculty:  lecturers count in faculty.");
                            for (Faculty faculty1 : firstUniversity.getFaculties()) {
                                System.out.println(faculty1.getName() + ": " + FacultyService.allLecturersCountInFac(faculty1));
                            }
                            System.out.println("------------------------------------------------------------");
                            break;
                        case 2:
                            System.out.println("------------------------------------------------------------");
                            firstUniversity.addFaculty(FacultyService.create());
                            System.out.println("------------------------------------------------------------");
                            break;
                        default:
                            System.out.println("Invalid command number!");
                    }
                    break;
                case 3:
                    System.out.println("1. Print full names of professors in chair of faculty");
                    System.out.println("2. Print lecturers of chair who has started working after that year.");
                    System.out.println("3. Sort lecturers by salary in some chair of faculty.");
                    System.out.println("4. Sort lecturers by working year in some chair of faculty.");
                    System.out.println("5. Print emails of lecturers working in other universities too.");
                    System.out.println("6. Print count of female lectures in some chair of faculty.");
                    System.out.println("7. Print count of all lecturers in some faculty.");
                    System.out.println("8. Add chair to some faculty.");

                    command = Integer.parseInt(s.nextLine());

                    switch (command) {
                        case 1:
                            System.out.println("------------------------------------------------------------");
                            System.out.println("Professors in chair: ");
                            System.out.println(chair.getName() + ": ");
                            ChairOfFacultyService.printProfessors(chair);
                            System.out.println("------------------------------------------------------------");
                            break;
                        case 2:
                            System.out.println("------------------------------------------------------------");
                            System.out.println("Please input the year.");
                            int year = Integer.parseInt(s.nextLine());
                            System.out.println("Lecturers working after " + year + " in " + chair.getName());
                            System.out.println(ChairOfFacultyService.lecturersWorkingAfter(chair, year));
                            System.out.println("------------------------------------------------------------");
                            break;
                        case 3:
                            System.out.println("------------------------------------------------------------");
                            ChairOfFacultyService.sortLecturersBySalary(chair);
                            System.out.println("After sorting lectures by salary in " + chair.getName());
                            for (Lecturer lect : chair.getLecturers()) {
                                System.out.println(lect.getFirstName() + " " + lect.getSalary());
                            }
                            System.out.println("------------------------------------------------------------");
                            break;
                        case 4:
                            System.out.println("------------------------------------------------------------");
                            ChairOfFacultyService.sortLecturersByWorkYear(chair);
                            System.out.println("After sorting lectures by working year in " + chair.getName());
                            for (Lecturer lect : chair.getLecturers()) {
                                System.out.println(lect.getFirstName() + " " + lect.getYearsOfWorkingAtUniversity());
                            }
                            System.out.println("------------------------------------------------------------");
                            break;
                        case 5:
                            System.out.println("------------------------------------------------------------");
                            System.out.println("Lecturers working in other universities too from chair " + chair.getName());
                            ChairOfFacultyService.printEmailsOfLectWorkInOtherUniver(chair);
                            System.out.println("------------------------------------------------------------");
                            break;
                        case 6:
                            System.out.println("------------------------------------------------------------");
                            System.out.print("Count of female lecturers in " + chair.getName() + ": ");
                            System.out.println(ChairOfFacultyService.countOfFemaleLecturers(chair));
                            System.out.println("------------------------------------------------------------");
                            break;
                        case 7:
                            System.out.println("------------------------------------------------------------");
                            System.out.print("Count of all lecturers in faculty " + faculty.getName() + ": ");
                            System.out.println(ChairOfFacultyService.countOfAllLecturers(faculty.getChairsOfFaculty()));
                            System.out.println("------------------------------------------------------------");
                            break;
                        case 8:
                            System.out.println("------------------------------------------------------------");
                            faculty.addChairOfFaculty(ChairOfFacultyService.create());
                            System.out.println("After adding chair: ");
                            for (ChairOfFaculty c : faculty.getChairsOfFaculty()) {
                                System.out.println(c.getName());
                            }
                            System.out.println("------------------------------------------------------------");
                            break;
                        default:
                            System.out.println("Invalid command number!");
                    }
                    break;
                case 4:
                    System.out.println("1. Print rector's full name with email.");
                    System.out.println("2. Print rector's age at the time becoming rector.");

                    command = Integer.parseInt(s.nextLine());

                    switch (command) {
                        case 1:
                            System.out.println("------------------------------------------------------------");
                            System.out.println("Rector information: ");
                            RectorService.printFullNameWithEmail(firstUniversity.getRector());
                            System.out.println("------------------------------------------------------------");
                            break;
                        case 2:
                            System.out.println("------------------------------------------------------------");
                            System.out.print("Age becoming rector: ");
                            System.out.println(RectorService.ageBecomingRector(firstUniversity.getRector()));
                            System.out.println("------------------------------------------------------------");
                            break;
                        default:
                            System.out.println("Invalid command number!");
                    }
                    break;
                case 5:
                    System.out.println("1. Print highest salary among deans.");
                    System.out.println("2. Print emails of deans having scientific degree. ");
                    System.out.println("3. Sort deans' array by salary.");

                    command = Integer.parseInt(s.nextLine());

                    switch (command) {
                        case 1:
                            System.out.println("------------------------------------------------------------");
                            System.out.print("Highest salary among deans: ");
                            System.out.println(DeanService.highestSalaryAmongDeans(deans));
                            System.out.println("------------------------------------------------------------");
                            break;
                        case 2:
                            System.out.println("------------------------------------------------------------");
                            System.out.println("Emails of deans having scientific degree: ");
                            System.out.println(DeanService.emailsOfDeansHavingScientificDegree(deans));
                            System.out.println("------------------------------------------------------------");
                            break;
                        case 3:
                            System.out.println("------------------------------------------------------------");
                            DeanService.sortBySalary(deans);
                            System.out.println("After sorting deans by salary.");
                            for (Dean dean : deans) {
                                System.out.println(dean.getFirstName() + " " + dean.getSalary());
                            }
                            System.out.println("------------------------------------------------------------");
                            break;
                        default:
                            System.out.println("Invalid command number!");
                    }
                    break;
                case 6:
                    System.out.println("1. Print highest salary among heads of chairs in some faculty.");
                    System.out.println("2. Print full names of heads with specified degree.");
                    System.out.println("3. Sort heads of chairs by salary.");

                    command = Integer.parseInt(s.nextLine());

                    switch (command) {
                        case 1:
                            System.out.println("------------------------------------------------------------");
                            System.out.print("Highest salary among heads in faculty " + faculty.getName() + " ");
                            System.out.println(HeadOfChairService.highestSalaryAmongHeads(heads));
                            System.out.println("------------------------------------------------------------");
                            break;
                        case 2:
                            System.out.println("------------------------------------------------------------");
                            System.out.println("Please input degree.");
                            String degree = s.nextLine();
                            System.out.println("Full names of heads who have " + degree + " degree in faculty " + faculty.getName());
                            System.out.println(HeadOfChairService.fullNamesOfHeadsWithDegree(heads, degree));
                            System.out.println("------------------------------------------------------------");
                            break;
                        case 3:
                            System.out.println("------------------------------------------------------------");
                            HeadOfChairService.sortBySalary(heads);
                            System.out.println("After sorting: ");
                            for (HeadOfChair hd : heads) {
                                System.out.println(hd.getFirstName() + " " + hd.getSalary());
                            }
                            System.out.println("------------------------------------------------------------");
                            break;
                        default:
                            System.out.println("Invalid command number!");
                    }
                    break;
                case 7:
                    System.out.println("1. Add lecturer to some chair of faculty.");
                    System.out.println("2. Print lecturer's highest salary in chair of faculty.");
                    System.out.println("3. Print full names of professors in chair of faculty.");
                    System.out.println("4. Print lecturers working after specified year.");
                    System.out.println("5. Sort lecturers by salary in some chair.");
                    System.out.println("6. Sort lecturers by working year in some chair.");
                    System.out.println("7. Print email of lecturers working in other universities too.");
                    System.out.println("8. Print count of female lecturers in some chair of faculty.");

                    command = Integer.parseInt(s.nextLine());

                    switch (command) {
                        case 1:
                            System.out.println("------------------------------------------------------------");
                            System.out.println("Adding lecturer to " + chair.getName());
                            Lecturer newLecturer = LecturerService.create();
                            chair.addLecturer(newLecturer);
                            System.out.println("------------------------------------------------------------");
                            break;
                        case 2:
                            System.out.println("------------------------------------------------------------");
                            System.out.print("Lecturer's highest salary in " + chair.getName() + ": ");
                            System.out.println(LecturerService.lecturersHighestSalary(chair.getLecturers()));
                            System.out.println("------------------------------------------------------------");
                            break;
                        case 3:
                            System.out.println("------------------------------------------------------------");
                            System.out.println("Full names of professors in chair " + chair.getName());
                            LecturerService.printFullNamesOfProfessors(chair.getLecturers());
                            System.out.println("------------------------------------------------------------");
                            break;
                        case 4:
                            System.out.println("------------------------------------------------------------");
                            System.out.println("Please input year.");
                            int yr = Integer.parseInt(s.nextLine());
                            System.out.println("Lecturers working after " + yr + " year.");
                            System.out.println(LecturerService.lecturersWorkingAfter(chair.getLecturers(), yr));
                            System.out.println("------------------------------------------------------------");
                            break;
                        case 5:
                            System.out.println("------------------------------------------------------------");
                            LecturerService.sortBySalary(chair.getLecturers());
                            System.out.println("After sorting lecturers by salary in " + chair.getName());
                            for (Lecturer lect : chair.getLecturers()) {
                                System.out.println(lect.getFirstName() + " " + lect.getSalary());
                            }
                            System.out.println("------------------------------------------------------------");
                            break;
                        case 6:
                            System.out.println("------------------------------------------------------------");
                            LecturerService.sortByWorkingYear(chair.getLecturers());
                            System.out.println("After sorting lecturers by working year in " + chair.getName());
                            for (Lecturer lect : chair.getLecturers()) {
                                System.out.println(lect.getFirstName() + " " + lect.getYearsOfWorkingAtUniversity());
                            }
                            System.out.println("------------------------------------------------------------");
                            break;
                        case 7:
                            System.out.println("------------------------------------------------------------");
                            System.out.println("Email of lecturers from " + chair.getName() + " chair working in other universities.");
                            System.out.println(LecturerService.emailsOfLectWorkInOtherUniver(chair.getLecturers()));
                            System.out.println("------------------------------------------------------------");
                            break;
                        case 8:
                            System.out.println("------------------------------------------------------------");
                            System.out.print("Count of female lecturers in " + chair.getName() + " chair:  ");
                            System.out.println(LecturerService.countOfFemaleLecturers(chair.getLecturers()));
                            System.out.println("------------------------------------------------------------");
                            break;
                        default:
                            System.out.println("Invalid command number!");
                    }
                    break;
                case 8:
                    System.out.println("1. Print some student's full name with ID.");
                    System.out.println("2. Print IDs of excellent students in some faculty.");
                    System.out.println("3. Print bachelor degree students in some faculty.");
                    System.out.println("4. Print master degree female students in some faculty.");
                    System.out.println("5. Print students with highest GPA in some faculty.");
                    System.out.println("6. Sort students by GPA in some faculty.");
                    System.out.println("7. Print first Armenian student with min GPA.");
                    System.out.println("8. Delete student by ID from some faculty.");
                    System.out.println("9. Add student to some faculty.");

                    command = Integer.parseInt(s.nextLine());

                    switch (command) {
                        case 1:
                            System.out.println("------------------------------------------------------------");
                            System.out.println("Student information: ");
                            System.out.println(StudentService.studentFullNameWithID(student));
                            System.out.println("------------------------------------------------------------");
                            break;
                        case 2:
                            System.out.println("------------------------------------------------------------");
                            System.out.print("IDs of excellent students in " + faculty.getName() + ":  ");
                            System.out.println(StudentService.idsOfExcellentStudents(faculty.getStudents()));
                            System.out.println("------------------------------------------------------------");
                            break;
                        case 3:
                            System.out.println("------------------------------------------------------------");
                            System.out.println("Bachelor degree students in " + faculty.getName());
                            StudentService.printBachelorDegreeStudents(faculty.getStudents());
                            System.out.println("------------------------------------------------------------");
                            break;
                        case 4:
                            System.out.println("------------------------------------------------------------");
                            System.out.println("Master degree female students in " + faculty.getName());
                            System.out.println(StudentService.masterDegreeFemaleStudents(faculty.getStudents()));
                            System.out.println("------------------------------------------------------------");
                            break;
                        case 5:
                            System.out.println("------------------------------------------------------------");
                            System.out.println("Students with highest GPA in " + faculty.getName());
                            System.out.println(StudentService.studentsWithHighestGPA(faculty.getStudents()));
                            System.out.println("------------------------------------------------------------");
                            break;
                        case 6:
                            System.out.println("------------------------------------------------------------");
                            StudentService.sortByGpa(faculty.getStudents());
                            System.out.println("Sort students by GPA in " + faculty.getName());
                            for (Student stud : faculty.getStudents()) {
                                System.out.printf("%s %s %f \n", stud.getFirstName(), stud.getLastName(), stud.getGpa());
                            }
                            System.out.println("------------------------------------------------------------");
                            break;
                        case 7:
                            System.out.println("------------------------------------------------------------");
                            System.out.println("First armenian students with min GPA in " + faculty.getName() + ": ");
                            System.out.println(StudentService.armenianStudentWithMinGPA(faculty.getStudents()));
                            System.out.println("------------------------------------------------------------");
                            break;
                        case 8:
                            System.out.println("------------------------------------------------------------");
                            System.out.println("Please input ID for deleting student from " + faculty.getName());
                            int id = Integer.parseInt(s.nextLine());
                            StudentService.deleteStudentsById(faculty.getStudents(), id);
                            System.out.print("IDs after deleting: ");
                            for (Student std : faculty.getStudents()) {
                                System.out.print(std.getId() + " ");
                            }
                            System.out.println("\n");
                            System.out.println("------------------------------------------------------------");
                            break;
                        case 9:
                            System.out.println("------------------------------------------------------------");
                            System.out.println("Adding student to faculty " + faculty.getName());
                            faculty.addStudent(StudentService.create());
                            System.out.println("After adding student");
                            for (Student stud : faculty.getStudents()) {
                                System.out.println(stud.getFirstName() + " " + stud.getLastName());
                            }
                            System.out.println("------------------------------------------------------------");
                            break;
                        default:
                            System.out.println("Invalid command number!");
                    }
                    break;
                case 9:
                    try {
                        FileService.write("src\\University.txt", firstUniversity.toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 10:
                    isMenuActive = false;
                    System.out.println("Bye");
                    break;
                default:
                    System.out.println("Invalid command number.");
            }
        }
    }
}