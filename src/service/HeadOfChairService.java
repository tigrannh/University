package service;

import model.HeadOfChair;
import Comparators.SalaryComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HeadOfChairService {

    public static HeadOfChair create() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter head's first name");
        String name = s.nextLine();

        System.out.println("Enter head's last name");
        String lastName = s.nextLine();

        System.out.println("Enter head's year of birth");
        int year = Integer.parseInt(s.nextLine());

        System.out.println("Enter head's nationality");
        String nation = s.nextLine();

        System.out.println("Enter head's gender (m/f)");
        char gender = s.nextLine().charAt(0);

        System.out.println("Enter year of becoming head of chair");
        int headYear = Integer.parseInt(s.nextLine());

        System.out.println("Enter head's salary");
        int salary = Integer.parseInt(s.nextLine());

        System.out.println("Enter years of working at university");
        short workYear = Short.parseShort(s.nextLine());

        System.out.println("Enter head's university email");
        String email = s.nextLine();

        System.out.println("Enter head's scientific title (assistant, professor ...");
        String title = s.nextLine();

        HeadOfChair head = new HeadOfChair(name, lastName, year, nation, gender, headYear);
        head.setSalary(salary);
        head.setYearsOfWorkingAtUniversity(workYear);
        head.setUniversityEmail(email);
        head.setScientificTitle(title);

        return head;
    }

    public static int highestSalaryAmongHeads(ArrayList<HeadOfChair> heads) {
        return Collections.max(heads, new SalaryComparator()).getSalary();
    }

    public static ArrayList<String> fullNamesOfHeadsWithDegree(ArrayList<HeadOfChair> heads, String degree) {
        ArrayList<String> names = new ArrayList<>();
        for (HeadOfChair head : heads){
            if (head.getScientificTitle().equals(degree)){
                names.add(head.getFirstName() + " " + head.getLastName());
            }
        }
        return names;
    }

    public static void sortBySalary(ArrayList<HeadOfChair> heads) {
        heads.sort(new SalaryComparator());
    }
}
