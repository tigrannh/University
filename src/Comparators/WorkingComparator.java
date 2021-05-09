package Comparators;

import model.Lecturer;

import java.util.Comparator;

public class WorkingComparator implements Comparator<Lecturer> {

    @Override
    public int compare(Lecturer o1, Lecturer o2) {
        return o1.getYearsOfWorkingAtUniversity() - o2.getYearsOfWorkingAtUniversity();
    }
}
