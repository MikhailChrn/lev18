import java.io.*;

//lev18:

//Считать с консоли 3 имени файла.
//Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла.
//Закрыть потоки.

public class Solution18 {
    public static void main() throws IOException {
        BufferedReader sourceReader = new BufferedReader(new InputStreamReader(System.in));
        String source1 = sourceReader.readLine().trim();
        String source2 = sourceReader.readLine().trim();
        String source3 = sourceReader.readLine().trim();
        sourceReader.close();

        int data;

        FileOutputStream outputStream1 = new FileOutputStream(source1);
        FileInputStream inputStream2 = new FileInputStream(source2);
        FileInputStream inputStream3 = new FileInputStream(source3);

        while (inputStream2.available() > 0) {
            data = inputStream2.read();
            outputStream1.write(data);
        }

        while (inputStream3.available() > 0) {
            data = inputStream3.read();
            outputStream1.write(data);
        }

        inputStream2.close();
        inputStream3.close();
        outputStream1.close();
    }// end void main
}