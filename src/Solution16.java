import java.io.FileInputStream;
import java.io.IOException;

//lev18:
//В метод main первым параметром приходит путь к файлу.
//Посчитать количество символов в файле, которые соответствуют буквам английского алфавита.
//Вывести на экран число (количество символов).
//Закрыть потоки.

public class Solution16 {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        int count = 0;
        char c;
        while (inputStream.available() > 0) {
            c = (char) inputStream.read();
            if ((c >= 'a' & c <= 'z') | (c >= 'A' & c <= 'Z'))
                count++;
        }
        inputStream.close();
        System.out.println(count);
    }
}
