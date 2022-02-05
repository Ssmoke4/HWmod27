package Comparator;

import model.University;
import org.apache.commons.lang3.StringUtils;

public class university_shortname_comparator implements universityComparator{
    @Override
    public int compare(University o1, University o2) {
        return StringUtils.compare(o1.getShortName(),o2.getShortName());
    }
}
