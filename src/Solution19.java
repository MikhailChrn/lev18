import java.io.*;
import java.util.ArrayList;

//lev18:
//Считать с консоли 2 имени файла.
//В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов.
//Закрыть потоки.

public class Solution19 {
    public static void main() throws IOException {
        BufferedReader sourceReader = new BufferedReader(new InputStreamReader(System.in));
        String source1 = sourceReader.readLine().trim();
        String source2 = sourceReader.readLine().trim();
        sourceReader.close();

        FileInputStream inputStream1 = new FileInputStream(source1);
        ArrayList<Integer> tempData = new ArrayList<Integer>();
        while (inputStream1.available() > 0) tempData.add(inputStream1.read());
        inputStream1.close();

        FileOutputStream outputStream1 = new FileOutputStream(source1);
        FileInputStream inputStream2 = new FileInputStream(source2);
        while (inputStream2.available() > 0) outputStream1.write(inputStream2.read());
        inputStream2.close();
        for (Integer i : tempData) outputStream1.write(i);
        outputStream1.close();
    }
}

