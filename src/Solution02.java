import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution02 {
    //lev18:Минимальный байт
    //Ввести с консоли имя файла.
    //Найти минимальный байт в файле, вывести его на экран.
    //Закрыть поток ввода-вывода.

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        int minByte = inputStream.read();
        int data;

        while (inputStream.available() > 0)
        {
            data = inputStream.read();
            if (data < minByte) minByte = data;
        }
        System.out.println(minByte);
        inputStream.close();
    }//end void main
}
