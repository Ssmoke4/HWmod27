package Comparator;
import model.Student;
import org.apache.commons.lang3.StringUtils;

public class student_comparator_avgExamScore implements StudentComparator {
    @Override
    public int compare(Student o1, Student o2) {
        return Float.compare(o1.getAvgExamScore(),o2.getAvgExamScore());
    }
}
