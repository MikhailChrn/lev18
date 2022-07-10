import java.io.*;

//lev18:
//Считать с консоли 3 имени файла.
//Записать в первый файл содержимого второго файла, а потом дописать в первый
//файл содержимое третьего файла.
//Закрыть потоки.

public class Solution18true {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();

        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName1);
             FileInputStream fileInputStream1 = new FileInputStream(fileName2);
             FileInputStream fileInputStream2 = new FileInputStream(fileName3)) {
            while (fileInputStream1.available() > 0) {
                fileOutputStream.write(fileInputStream1.read());
            }
            while (fileInputStream2.available() > 0) {
                fileOutputStream.write(fileInputStream2.read());
            }
        }
    }
}
