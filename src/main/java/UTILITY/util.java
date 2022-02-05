package UTILITY;

import Comparator.*;
import universitets.*;

import static universitets.students_comparator.*;

public class util {
    private util() {
    }

    public static StudentComparator getStudentComparator(students_comparator students_comparator){
        if (students_comparator == FULL_NAME){
            return new student_comparator_fullName();
        }else if (students_comparator == AVGEXAMSCORE){
            return new student_comparator_avgExamScore();
        }else if (students_comparator == CURRENT_COURSE_NUMBER){
            return new student_comparator_currentCourseNumber();
        }
        {
            return new student_comparator_universityId();
        }

    }


    public static universityComparator getUniversityComparator(university_compartor university_compartor){
        switch (university_compartor){
            case ID -> {return new university_id_comparator();}
            case FULLNAME -> {return new university_fullName_comparator();}
            case SHORT_NAME -> {return new university_shortname_comparator();}
            case YEAR_OF_FOUNDATION -> {return new university_year_of_foundation_comparator();}
            default -> {return new university_fullName_comparator();}

        }

    }
}
