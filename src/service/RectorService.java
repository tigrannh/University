package service;

import model.Rector;

import java.util.Scanner;

public class RectorService {

    public static Rector create(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter rector's first name");
        String name = s.nextLine();

        System.out.println("Enter rector's last name");
        String lastName = s.nextLine();

        System.out.println("Enter rector's year of birth");
        int year = Integer.parseInt(s.nextLine());

        System.out.println("Enter rector's nationality");
        String nation = s.nextLine();

        System.out.println("Enter rector's gender (m/f)");
        char gender = s.nextLine().charAt(0);

        System.out.println("Enter year of becoming rector");
        int rectorYear = Integer.parseInt(s.nextLine());

        System.out.println("Enter rector's salary");
        int salary = Integer.parseInt(s.nextLine());

        System.out.println("Enter years of working at university");
        short workYear = Short.parseShort(s.nextLine());

        System.out.println("Enter rector's university email");
        String email = s.nextLine();

        Rector rector = new Rector(name, lastName, year, nation, gender, rectorYear);
        rector.setSalary(salary);
        rector.setYearsOfWorkingAtUniversity(workYear);
        rector.setUniversityEmail(email);

        return rector;
    }

    public static void printFullNameWithEmail (Rector rector) {
        String data =new StringBuilder()
                .append(rector.getFirstName())
                .append(" ")
                .append(rector.getLastName())
                .append(" ")
                .append(rector.getUniversityEmail()).toString();
        System.out.println(data);
    }

    public static int ageBecomingRector(Rector rector) {
        return rector.getYearOfBecomingRector() - rector.getYearOfBirth();
    }

}
