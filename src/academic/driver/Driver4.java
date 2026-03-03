package academic.driver;

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 12S24029 Adithya Silaban
 * @author NIM Nama
 *
 * Driver class untuk menyimulasikan kemampuan penyimpanan multiple entitas
 * (Course, Student, Enrollment) dan menerima input interaktif dari pengguna,
 * serta menampilkannya sesuai format dan URUTAN input yang diminta.
 */
public class Driver4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Menggunakan satu List of Object untuk menyimpan semua entitas.
        // Ini adalah kunci untuk memastikan urutan output sama dengan urutan input.
        List<Object> academicEntities = new ArrayList<>();

        String line;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();

            if (line.equals("---")) {
                break; // Hentikan pembacaan input jika "---" ditemukan
            }

            String[] segments = line.split("#");
            String command = segments[0]; // Bagian pertama adalah perintah (command)

            switch (command) {
                case "course-add":
                    if (segments.length == 5) {
                        String code = segments[1];
                        String name = segments[2];
                        int credits = Integer.parseInt(segments[3]);
                        String passingGrade = segments[4];
                        Course course = new Course(code, name, credits, passingGrade);
                        academicEntities.add(course); // Tambahkan ke list tunggal
                    } else {
                        System.err.println("Error: Format input tidak valid untuk course-add: " + line);
                    }
                    break;

                case "student-add":
                    if (segments.length == 5) {
                        String id = segments[1];
                        String name = segments[2];
                        int entranceYear = Integer.parseInt(segments[3]); // Mengubah String ke int
                        String major = segments[4];
                        Student student = new Student(id, name, entranceYear, major);
                        academicEntities.add(student); // Tambahkan ke list tunggal
                    } else {
                        System.err.println("Error: Format input tidak valid untuk student-add: " + line);
                    }
                    break;

                case "enrollment-add":
                    if (segments.length == 5) { // Command + 4 data = 5 segmen
                        String courseCode = segments[1];
                        String studentId = segments[2];
                        String academicYear = segments[3];
                        String semester = segments[4];
                        Enrollment enrollment = new Enrollment(courseCode, studentId, academicYear, semester);
                        academicEntities.add(enrollment); // Tambahkan ke list tunggal
                    } else {
                        System.err.println("Error: Format input tidak valid untuk enrollment-add: " + line);
                    }
                    break;

                default:
                    System.err.println("Error: Perintah tidak dikenal: " + command);
                    break;
            }
        }

        // Menampilkan semua entitas yang telah tersimpan.
        // Karena disimpan dalam satu List<Object> secara berurutan,
        // outputnya akan sama dengan urutan input.
        for (Object entity : academicEntities) {
            System.out.println(entity.toString());
        }

        scanner.close(); // Tutup scanner
    }
}