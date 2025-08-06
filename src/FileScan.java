import javax.swing.JFileChooser;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileScan {
    public static void main(String[] args) {
        File file = null;

        if (args.length > 0) {
            file = new File(args[0]);
            if (!file.exists()) {
                System.out.println("File not found: " + args[0]);
                return;
            }
        } else {
            // Launch JFileChooser if no argument
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File("src"));
            int result = chooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                file = chooser.getSelectedFile();
            } else {
                System.out.println("No file selected.");
                return;
            }
        }

        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;

        try {
            List<String> lines = Files.readAllLines(file.toPath());
            for (String line : lines) {
                System.out.println(line);
                lineCount++;
                wordCount += line.trim().isEmpty() ? 0 : line.trim().split("\\s+").length;
                charCount += line.length();
            }

            System.out.println("\n--- File Summary ---");
            System.out.println("File Name: " + file.getName());
            System.out.println("Number of Lines: " + lineCount);
            System.out.println("Number of Words: " + wordCount);
            System.out.println("Number of Characters: " + charCount);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
