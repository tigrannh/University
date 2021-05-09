package Comparators;

import model.UniversityWorker;

import java.util.Comparator;

public class SalaryComparator implements Comparator<UniversityWorker> {
    @Override
    public int compare(UniversityWorker o1, UniversityWorker o2) {
        return o1.getSalary() - o2.getSalary();
    }
}
