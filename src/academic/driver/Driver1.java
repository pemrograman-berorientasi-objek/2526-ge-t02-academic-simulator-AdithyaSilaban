package academic.driver;

import academic.model.Course;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 12S24029 Adithya Silaban
 * @author NIM Nama
 *
 * Driver class untuk menyimulasikan kemampuan penyimpanan multiple Course
 * dan menerima input interaktif dari pengguna, serta menampilkannya.
 */
public class Driver1 {

    public static void main(String[] args) {
        // Baris ini telah dikoreksi: satu 'new' keyword dihilangkan
        Scanner scanner = new Scanner(System.in); // Inisialisasi Scanner untuk membaca input
        List<Course> courses = new ArrayList<>();

        String line;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();

            if (line.equals("---")) {
                break;
            }

            String[] segments = line.split("#");

            if (segments.length == 4) {
                String code = segments[0];
                String name = segments[1];
                int credits = 0;
                String gradeComponent = segments[3];

                try {
                    credits = Integer.parseInt(segments[2]);
                } catch (NumberFormatException e) {
                    System.err.println("Error: SKS untuk course '" + name + "' tidak valid (bukan angka). Melewatkan course ini.");
                    continue;
                }

                Course course = new Course(code, name, credits, gradeComponent);
                courses.add(course);
            } else {
                System.err.println("Error: Format input tidak valid untuk baris: " + line + ". Harusnya 4 segmen dipisahkan '#'.");
            }
        }

        for (Course course : courses) {
            System.out.println(course.toString());
        }

        scanner.close();
    }
}