import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    public static int[] readNumbers(String filename, int count) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null && numbers.size() < count) {
                if (line.startsWith("a ")) {
                    String[] parts = line.split(" ");
                    if (parts.length >= 3) {
                        try {
                            numbers.add(Integer.parseInt(parts[3]));
                        } catch (NumberFormatException e) {
                        }
                    }
                }
            }
        }
        return numbers.stream().mapToInt(i -> i).toArray();
    }

    public static void writeNumbers(String filename, int[] numbers) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (int number : numbers) {
                bw.write(Integer.toString(number));
                bw.newLine();
            }
        }
    }
}
