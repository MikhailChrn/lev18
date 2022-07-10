import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//lev18:Реверс файла
//Считать с консоли 2 имени файла: файл1, файл2.
//Записать в файл2 все байты из файл1, но в обратном порядке.
//Закрыть потоки.

public class Solution09 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        FileOutputStream outputStream = new FileOutputStream(reader.readLine());
        reader.close();
        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
        for (int i = (buffer.length - 1); i >= 0; i--) outputStream.write(buffer[i]);
        inputStream.close();
        outputStream.close();
    }//end void main
}
