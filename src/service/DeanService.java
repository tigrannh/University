package service;

import Comparators.SalaryComparator;
import model.Dean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DeanService {

    public static Dean create() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter dean's first name");
        String name = s.nextLine();

        System.out.println("Enter dean's last name");
        String lastName = s.nextLine();

        System.out.println("Enter dean's year of birth");
        int year = Integer.parseInt(s.nextLine());

        System.out.println("Enter dean's nationality");
        String nation = s.nextLine();

        System.out.println("Enter dean's gender (m/f)");
        char gender = s.nextLine().charAt(0);

        System.out.println("Enter year of becoming dean");
        int deanYear = Integer.parseInt(s.nextLine());

        System.out.println("Enter dean's salary");
        int salary = Integer.parseInt(s.nextLine());

        System.out.println("Enter years of working at university");
        short workYear = Short.parseShort(s.nextLine());

        System.out.println("Enter dean's university email");
        String email = s.nextLine();

        System.out.println("Has dean scientific degree? (y/n)");
        boolean hasDegree = s.nextLine().charAt(0) == 'y';

        Dean dean = new Dean(name, lastName, year, nation, gender, deanYear);
        dean.setScientificDegree(hasDegree);
        dean.setSalary(salary);
        dean.setYearsOfWorkingAtUniversity(workYear);
        dean.setUniversityEmail(email);

        return dean;
    }


    public static int highestSalaryAmongDeans(ArrayList<Dean> deans) {
        return Collections.max(deans, new SalaryComparator()).getSalary();
    }

    public static ArrayList<String> emailsOfDeansHavingScientificDegree(ArrayList<Dean> deans) {
        ArrayList<String> emails = new ArrayList<>();
        for (Dean dean : deans){
            if (dean.hasScientificDegree()) emails.add(dean.getUniversityEmail());
        }
        return emails;
    }

    public static void sortBySalary(ArrayList<Dean> deans) {
        deans.sort(new SalaryComparator());
    }

}
