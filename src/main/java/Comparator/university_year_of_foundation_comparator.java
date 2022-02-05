package Comparator;

import model.University;
import org.apache.commons.lang3.StringUtils;

public class university_year_of_foundation_comparator implements universityComparator{
    @Override
    public int compare(University o1, University o2) {
        return Integer.compare(o1.getYearOfFoundation(),o2.getYearOfFoundation());
    }
}
