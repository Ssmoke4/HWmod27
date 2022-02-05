package universitets;

public enum StudyProfile {
    PHYSICS("Физика"),
    COMPUTER_SCIENCE("Информатика"),
    MATHEMATICS("Математика"),
    JURISPRUDENCE("Юриспруденция"),
    MEDICINE("Медицина"),
    LINGUISTICS("Лингвистика");


    public String getProfile_name() {
        return Profile_name;
    }

    private final String Profile_name;


    StudyProfile(String profile_name) {
        Profile_name = profile_name;
    }
}
