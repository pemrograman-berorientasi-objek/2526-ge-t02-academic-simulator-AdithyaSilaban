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
 * serta menampilkannya sesuai format dan URUTAN GRUP (Course, Student, Enrollment) yang diminta.
 */
public class Driver4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Menggunakan daftar terpisah untuk setiap tipe entitas.
        // Ini memungkinkan pencetakan berurutan berdasarkan tipe (Course, Student, Enrollment).
        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        List<Enrollment> enrollments = new ArrayList<>();

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
                        courses.add(course); // Tambahkan ke daftar Course
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
                        students.add(student); // Tambahkan ke daftar Student
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
                        enrollments.add(enrollment); // Tambahkan ke daftar Enrollment
                    } else {
                        System.err.println("Error: Format input tidak valid untuk enrollment-add: " + line);
                    }
                    break;

                default:
                    System.err.println("Error: Perintah tidak dikenal: " + command);
                    break;
            }
        }

        // --- Bagian untuk menampilkan output sesuai urutan yang diinginkan ---

        // 1. Menampilkan semua Course (sesuai urutan input Course)
        for (Course course : courses) {
            System.out.println(course.toString());
        }

        // 2. Menampilkan semua Student (sesuai urutan input Student)
        for (Student student : students) {
            System.out.println(student.toString());
        }

        // 3. Menampilkan semua Enrollment (sesuai urutan input Enrollment)
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment.toString());
        }

        scanner.close(); // Tutup scanner
    }
}
