import java.io.FileInputStream;
import java.io.IOException;

//lev18:
//В метод main первым параметром приходит путь к файлу.
//Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45.
//1. Посчитать количество всех символов.
//2. Посчитать количество пробелов.
//3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой до ближайшего.
//4. Закрыть потоки.

public class Solution17 {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        int total = inputStream.available();
        int spcCh = 0;
        while (inputStream.available() > 0)
            if ((char) inputStream.read() == ' ') spcCh++;
        inputStream.close();
        System.out.printf("%.2f", (double) spcCh*100/total);
    }
}