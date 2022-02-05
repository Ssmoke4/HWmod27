package model;

import com.zaxxer.sparsebits.SparseBitSet;
import universitets.StudyProfile;

public class statistic {
    private StudyProfile profile;
    String UniversityNames;
    float avgExam;
    int numOfStudents, numOfUniversity;

    public statistic() {
    }

    public void setProfile(StudyProfile profile) {
        this.profile = profile;
    }

    public StudyProfile getProfile() {
        return profile;
    }

    public String getUniversityNames() {
        return UniversityNames;
    }

    public float getAvgExam() {
        return avgExam;
    }

    public int getNumOfStudents() {
        return numOfStudents;
    }

    public int getNumOfUniversity() {
        return numOfUniversity;
    }



    public void setUniversityNames(String universityNames) {
        UniversityNames = universityNames;
    }

    public void setAvgExam(float avgExam) {
        this.avgExam = avgExam;
    }

    public void setNumOfStudents(int numOfStudents) {
        this.numOfStudents = numOfStudents;
    }

    public void setNumOfUniversity(int numOfUniversity) {
        this.numOfUniversity = numOfUniversity;
    }
}
