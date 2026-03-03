package academic.model;

public class Student {
    private String id;
    private String name;
    private int academicYear; // Tipe data seharusnya INT, sesuai Task 02
    private String studyProgram;

    // Konstruktor yang benar: (String id, String name, int academicYear, String studyProgram)
    public Student(String id, String name, int academicYear, String studyProgram) {
        this.id = id;
        this.name = name;
        this.academicYear = academicYear;
        this.studyProgram = studyProgram;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAcademicYear() { // Getter juga harus mengembalikan int
        return academicYear;
    }

    public String getStudyProgram() {
        return studyProgram;
    }

    @Override
    public String toString() {
        return id + "|" + name + "|" + academicYear + "|" + studyProgram;
    }
}