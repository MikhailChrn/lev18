import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//lev18:Исправить ошибки
//Исправить функциональность в соответствии с требованиями.
//
//Программа должна:
//1. Переписать все байты одного файла в другой одним куском.
//2. Закрывать потоки ввода-вывода.

public class Solution06 {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("c:/data.txt");
        // Создаем поток-записи-байт-в-файл
        FileOutputStream outputStream = new FileOutputStream("c:/result.txt");

        if (inputStream.available() > 0) {
            //читаем весь файл одним куском
            byte[] buffer = new byte[inputStream.available()];
            int count = inputStream.read(buffer);
            outputStream.write(buffer, 0, count);
        }

        inputStream.close();
        outputStream.close();
    }//end void main
}
