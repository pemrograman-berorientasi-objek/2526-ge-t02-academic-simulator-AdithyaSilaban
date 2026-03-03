package academic.model;

/**
 * @author 12S24029 Adithya Silaban
 */
public class Course {

    private String code; // Kode unik untuk mata kuliah
    private String name; // Nama lengkap mata kuliah
    private int credits; // Jumlah SKS (Sistem Kredit Semester) atau kredit mata kuliah
    private String gradeComponent; // Komponen nilai atau kategori mata kuliah (misal: 'C' untuk Compulsory, dll.)

    // Konstruktor untuk inisialisasi objek Course
    public Course(String code, String name, int credits, String gradeComponent) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.gradeComponent = gradeComponent;
    }

    // Metode getter untuk mengakses kode mata kuliah
    public String getCode() {
        return code;
    }

    // Metode getter untuk mengakses nama mata kuliah
    public String getName() {
        return name;
    }

    // Metode getter untuk mengakses jumlah SKS/kredit mata kuliah
    public int getCredits() {
        return credits;
    }

    // Metode getter untuk mengakses komponen nilai/kategori mata kuliah
    public String getGradeComponent() {
        return gradeComponent;
    }

    // Override metode toString untuk representasi string objek Course sesuai format output yang diminta
    @Override
    public String toString() {
        return code + "|" + name + "|" + credits + "|" + gradeComponent;
    }
}