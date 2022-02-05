package UTILITY;
import model.Student;
import model.University;
import model.statistic;
import org.apache.commons.lang3.StringUtils;
import universitets.StudyProfile;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

public class StatUtil {
    public StatUtil() {
    }


    public static List<statistic> createStat (List<Student> students, List<University> universities){
        List<statistic> statisticList = new ArrayList<>();
        Set<StudyProfile> profiles = universities.stream()
                .map(University::getMainProfile)
                .collect(Collectors.toSet());
        profiles.forEach(profile -> {
            statistic statistics = new statistic();
            statisticList.add(statistics);
            statistics.setProfile(profile);

            List<String> profileUniversityIds = universities.stream()
                    .filter(university -> university.getMainProfile().equals(profile))
                    .map(University::getId)
                    .collect(Collectors.toList());
            statistics.setNumOfUniversity(profileUniversityIds.size());
            statistics.setUniversityNames(StringUtils.EMPTY);
            universities.stream()
                    .filter(university -> profileUniversityIds.contains(university.getId()))
                    .map(University::getFullName)
                    .forEach(fullNameUniversity -> statistics.setUniversityNames(
                            statistics.getUniversityNames() + fullNameUniversity + ";"));
            List<Student> profileStudents = students.stream()
                    .filter(student -> profileUniversityIds.contains(student.getUniversityId()))
                    .collect(Collectors.toList());
            statistics.setNumOfStudents(profileStudents.size());
            OptionalDouble avgExamScore = profileStudents.stream()
                    .mapToDouble(Student::getAvgExamScore)
                    .average();
            statistics.setAvgExam(0);
            avgExamScore.ifPresent(value -> statistics.setAvgExam(
                    (float) BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue()));
        });

        return statisticList;

    }
}
