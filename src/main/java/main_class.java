import Comparator.*;
import UTILITY.JsonUtil;
import UTILITY.StatUtil;
import io.XlsWriter;
import model.statistic;
import universitets.*;
import io.XlsReader;
import model.Student;
import model.University;
import UTILITY.util ;

import java.io.IOException;
import java.util.List;

public class main_class {

    public static void main(String[] args) throws IOException {

        List<University> universities =
                XlsReader.readXlsUniversities("src/main/resources/universityInfo.xlsx");
        universityComparator universityComparator =
                util.getUniversityComparator(university_compartor.YEAR_OF_FOUNDATION);
        universities.sort(universityComparator);
        String universitiesJson = JsonUtil.universityListToJson(universities);
        // проверяем, что json создан успешно
        System.out.println(universitiesJson);
        List<University> universitiesFromJson = JsonUtil.jsonToUniversityList(universitiesJson);
        // проверяем, что обратно коллекция воссоздаётся в таком же количестве элементов
        System.out.println(universities.size() == universitiesFromJson.size());
        universities.forEach(university -> {
            String universityJson = JsonUtil.universityToJson(university);
            // проверяем, что json из отдельного элемента создан успешно
            System.out.println(universityJson);
            University universityFromJson = JsonUtil.jsonToUniversity(universityJson);
            // проверяем, что обратно элемент воссоздаётся
            System.out.println(universityFromJson);
        });

        List<Student> students =
                XlsReader.readXlsStudents("src/main/resources/universityInfo.xlsx");
        StudentComparator studentComparator =
                util.getStudentComparator(students_comparator.AVGEXAMSCORE);
        students.sort(studentComparator);
        String studentsJson = JsonUtil.studentListToJson(students);
        // проверяем, что json создан успешно
        System.out.println(studentsJson);
        List<Student> studentsFromJson = JsonUtil.jsonToStudentList(studentsJson);
        // проверяем, что обратно коллекция воссоздаётся в таком же количестве элементов
        System.out.println(students.size() == studentsFromJson.size());
        students.forEach(student -> {
            String studentJson = JsonUtil.studentToJson(student);
            // проверяем, что json из отдельного элемента создан успешно
            System.out.println(studentJson);
            Student studentFromJson = JsonUtil.jsonToStudent(studentJson);
            // проверяем, что обратно элемент воссоздаётся
            System.out.println(studentFromJson);
        });

        List<statistic> statisticsList = StatUtil.createStat(students,universities);
        XlsWriter.writeWorkbook(statisticsList, "statistics.xlsx");
    }
}
