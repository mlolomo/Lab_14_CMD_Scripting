import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();
        int idCounter = 1;

        boolean more = true;
        while (more) {
            System.out.print("Enter your First Name: ");
            String first = in.nextLine();

            System.out.print("Enter your Last Name: ");
            String last = in.nextLine();

            String id = String.format("%06d", idCounter++);

            System.out.print("Enter your Email: ");
            String email = in.nextLine();

            System.out.print("Enter your Year of Birth: ");
            String yob = in.nextLine();

            String record = String.join(", ", first, last, id, email, yob);
            records.add(record);

            System.out.print("Do you want to add another? (Y/N): ");
            more = in.nextLine().trim().equalsIgnoreCase("Y");
        }

        System.out.print("Enter file name to save (.csv): ");
        String fileName = in.nextLine();

        try (FileWriter writer = new FileWriter("src/" + fileName)) {
            for (String rec : records) {
                writer.write(rec + "\n");
            }
            System.out.println("File saved successfully in src/");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
