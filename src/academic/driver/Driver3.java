package academic.driver;

import academic.model.Enrollment; // Mengimpor kelas Enrollment dari paket academic.model
import java.util.ArrayList;       // Digunakan untuk menyimpan daftar Enrollment secara dinamis
import java.util.List;            // Antarmuka untuk koleksi data
import java.util.Scanner;         // Digunakan untuk membaca input dari konsol

/**
 * @author 12S24029 Adithya Silaban
 * @author NIM Nama
 *
 * Driver class untuk menyimulasikan kemampuan penyimpanan multiple Enrollment
 * dan menerima input interaktif dari pengguna, serta menampilkannya.
 */
public class Driver3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Inisialisasi Scanner untuk membaca input
        List<Enrollment> enrollments = new ArrayList<>(); // Menggunakan ArrayList untuk menyimpan objek Enrollment

        String line;
        // Loop untuk terus membaca input hingga bertemu delimiter "---"
        while (scanner.hasNextLine()) {
            line = scanner.nextLine(); // Membaca satu baris input

            if (line.equals("---")) { // Kondisi untuk menghentikan pembacaan input
                break;
            }

            // Memisahkan setiap segmen data berdasarkan karakter '#'
            String[] segments = line.split("#");

            // Memastikan input memiliki 4 segmen sesuai yang diharapkan
            if (segments.length == 4) {
                String courseCode = segments[0];    // Segmen pertama adalah kode mata kuliah
                String studentId = segments[1];     // Segmen kedua adalah NIM mahasiswa
                String academicYear = segments[2];  // Segmen ketiga adalah tahun ajaran
                String semester = segments[3];      // Segmen keempat adalah semester

                // Membuat objek Enrollment baru. Grade akan diinisialisasi sebagai "None" di konstruktor.
                Enrollment enrollment = new Enrollment(courseCode, studentId, academicYear, semester);
                enrollments.add(enrollment);
            } else {
                System.err.println("Error: Format input tidak valid untuk baris: " + line + ". Harusnya 4 segmen dipisahkan '#'.");
            }
        }

        // Menampilkan semua Enrollment yang telah tersimpan
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment.toString()); // Menggunakan metode toString() dari kelas Enrollment
        }

        scanner.close(); // Menutup objek Scanner untuk mencegah resource leak
    }
}