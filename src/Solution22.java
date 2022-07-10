import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

//lev18:
//Считать с консоли имя файла.
//Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
//Программа запускается с одним параметром: id (int).
//Закрыть потоки.

public class Solution22 {
    public static void main(String[] args) throws IOException {
        if (args.length != 1)
            return;

        // select work-file
        BufferedReader sourceFileReader = new BufferedReader(new InputStreamReader(System.in));
        String sourceFileName = sourceFileReader.readLine().trim();
        sourceFileReader.close();

        // work with file
        BufferedReader fileLineReader = new BufferedReader(new FileReader(sourceFileName));
        String line = fileLineReader.readLine();// first string

        while (line != null) {
            String[] str = line.split(" ");
            if (args[0].equals(str[0])) {
                System.out.println(line);
                fileLineReader.close();
                return;
            }
            line = fileLineReader.readLine();
        }//end while

        System.out.println("No records found.");
        fileLineReader.close();
    }//end void main
}