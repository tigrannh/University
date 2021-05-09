package model;

public class UniversityWorker extends Human{
    protected int salary;
    protected short yearsOfWorkingAtUniversity;
    protected String universityEmail;

    public UniversityWorker(String firstName, String lastName, int yearOfBirth, String nationality, char gender) {
        super(firstName, lastName, yearOfBirth, nationality, gender);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(super.toString())
                .append(",")
                .append(salary)
                .append(",")
                .append(yearsOfWorkingAtUniversity)
                .append(",")
                .append(universityEmail).toString();

    }

    @Override
    public void print() {
        super.print();
        System.out.println("Salary: " + salary);
        System.out.println("Count of years working at university: " + yearsOfWorkingAtUniversity);
        System.out.println("University Email: " + universityEmail);
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        if (salary > 0) {
            this.salary = salary;
        }
    }

    public short getYearsOfWorkingAtUniversity() {
        return yearsOfWorkingAtUniversity;
    }

    public void setYearsOfWorkingAtUniversity(short yearsOfWorkingAtUniversity) {
        if (yearsOfWorkingAtUniversity > 0) {
            this.yearsOfWorkingAtUniversity = yearsOfWorkingAtUniversity;
        }
    }

    public String getUniversityEmail() {
        return universityEmail;
    }

    public void setUniversityEmail(String universityEmail) {
        if (!universityEmail.isEmpty()) {
            this.universityEmail = universityEmail;
        }
    }
}
