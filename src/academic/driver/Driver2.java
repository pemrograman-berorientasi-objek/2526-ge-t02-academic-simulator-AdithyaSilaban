package academic.driver;

import academic.model.Student; // Mengimpor kelas Student dari paket academic.model
import java.util.ArrayList;   // Digunakan untuk menyimpan daftar Student secara dinamis
import java.util.List;        // Antarmuka untuk koleksi data
import java.util.Scanner;     // Digunakan untuk membaca input dari konsol

/**
 * @author 12S24029 Adithya Silaban
 * @author NIM Nama
 *
 * Driver class untuk menyimulasikan kemampuan penyimpanan multiple Student
 * dan menerima input interaktif dari pengguna, serta menampilkannya.
 */
public class Driver2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Inisialisasi Scanner untuk membaca input
        List<Student> students = new ArrayList<>();   // Menggunakan ArrayList untuk menyimpan objek Student

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
                String id = segments[0];        // Segmen pertama adalah NIM Mahasiswa
                String name = segments[1];      // Segmen kedua adalah nama Mahasiswa
                int year = 0;                   // Segmen ketiga adalah tahun masuk, perlu diubah ke int
                String program = segments[3];   // Segmen keempat adalah program studi/jurusan

                // Melakukan parsing untuk tahun masuk, dengan penanganan kesalahan dasar
                try {
                    year = Integer.parseInt(segments[2]);
                } catch (NumberFormatException e) {
                    System.err.println("Error: Tahun masuk untuk mahasiswa '" + name + "' tidak valid (bukan angka). Melewatkan mahasiswa ini.");
                    continue; // Lewati baris ini jika tahun masuk tidak valid
                }

                // Membuat objek Student baru dan menambahkannya ke daftar
                Student student = new Student(id, name, year, program);
                students.add(student);
            } else {
                System.err.println("Error: Format input tidak valid untuk baris: " + line + ". Harusnya 4 segmen dipisahkan '#'.");
            }
        }

        // Menampilkan semua Student yang telah tersimpan
        for (Student student : students) {
            System.out.println(student.toString()); // Menggunakan metode toString() dari kelas Student
        }

        scanner.close(); // Menutup objek Scanner untuk mencegah resource leak
    }
}