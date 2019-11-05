package StreamsFilesAndDirectories.Exercises;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class P2SumBytes {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\Kaloyan\\Desktop\\JavaAdvanceMay2019\\6.STREAMS, FILES AND DIRECTORIES" +
                "\\04. Java-Advanced-Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";


        FileReader fileReader = new FileReader(filePath);

        BufferedReader reader = new BufferedReader(fileReader);

        String line = reader.readLine();

        int totalSum = 0;
        while (line != null){





            line = reader.readLine();
        }
    }
}
