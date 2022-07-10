import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution01 {
    //lev18:Максимальный байт
    //Ввести с консоли имя файла.
    //Найти максимальный байт в файле, вывести его на экран.
    //Закрыть поток ввода-вывода.

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        int maxByte = inputStream.read();
        int data;

        while (inputStream.available() > 0)
        {
            data = inputStream.read();
            if (data > maxByte) maxByte = data;
        }
        System.out.println(maxByte);
        inputStream.close();
    }//end main
}
