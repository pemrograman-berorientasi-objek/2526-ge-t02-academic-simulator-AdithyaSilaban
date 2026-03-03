package academic.model;

/**
 * @author 12S24029 Adithya Silaban
 * @author NIM Nama
 *
 * Kelas model untuk merepresentasikan data pendaftaran (enrollment) mahasiswa pada suatu mata kuliah.
 */
public class Enrollment {

    private String courseCode;      // Kode mata kuliah
    private String studentId;       // NIM (Nomor Induk Mahasiswa)
    private String academicYear;    // Tahun ajaran (misalnya "2021/2022")
    private String semester;        // Semester (misalnya "even" untuk genap, "odd" untuk ganjil)
    private String grade;           // Nilai grade mahasiswa untuk mata kuliah ini

    // Konstruktor untuk inisialisasi objek Enrollment
    // Grade diinisialisasi sebagai "None" secara default
    public Enrollment(String courseCode, String studentId, String academicYear, String semester) {
        this.courseCode = courseCode;
        this.studentId = studentId;
        this.academicYear = academicYear;
        this.semester = semester;
        this.grade = "None"; // Sesuai dengan contoh output, grade default adalah "None"
    }

    // Metode getter untuk mengakses kode mata kuliah
    public String getCourseCode() {
        return courseCode;
    }

    // Metode getter untuk mengakses NIM mahasiswa
    public String getStudentId() {
        return studentId;
    }

    // Metode getter untuk mengakses tahun ajaran
    public String getAcademicYear() {
        return academicYear;
    }

    // Metode getter untuk mengakses semester
    public String getSemester() {
        return semester;
    }

    // Metode getter untuk mengakses grade
    public String getGrade() {
        return grade;
    }

    // Override metode toString untuk representasi string objek Enrollment sesuai format output yang diminta
    @Override
    public String toString() {
        return courseCode + "|" + studentId + "|" + academicYear + "|" + semester + "|" + grade;
    }
}