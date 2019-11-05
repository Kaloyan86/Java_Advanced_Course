package StreamsFilesAndDirectories.Exercises;

import java.io.*;

public class P1SumLines {
    public static void main(String[] args) throws IOException {


        String filePath = "C:\\Users\\Kaloyan\\Desktop\\JavaAdvanceMay2019\\6.STREAMS, FILES AND DIRECTORIES" +
                "\\04. Java-Advanced-Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        FileWriter writer = new FileWriter(
                filePath.substring(0, filePath.lastIndexOf("\\") + 1) + "asciiSum.txt"
        );
        try {
            String line = reader.readLine();
            while (line != null) {
                int asciiSum = 0;
                for (char symbol : line.toCharArray()) {
                    asciiSum += symbol;
                }

                writer.write(asciiSum + "");
                writer.write(System.lineSeparator());


                line = reader.readLine();

            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        writer.close();

    }
}
