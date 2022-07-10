import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

//lev18:DownloadException
//1 Считывать с консоли имена файлов.
//2 Если файл меньше 1000 байт, то:
//2.1 Закрыть потоки работы с файлами.
//2.2 Выбросить исключение DownloadException.

public class Solution10 {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        do {
            FileInputStream inputStream = new FileInputStream(reader.readLine());
            int size = inputStream.available();
            inputStream.close();
            if (size < 1000) throw new DownloadException();
        } while (true);
    }
    public static class DownloadException extends Exception {

    }
}



