import java.io.*;

//lev18:Разделение файла
//Считать с консоли три имени файла: файл1, файл2, файл3.
//Разделить файл1 по следующему критерию:
//Первую половину байт записать в файл2, вторую половину байт записать в файл3.
//Если в файл1 количество байт нечетное, то файл2 должен содержать большую часть.
//Закрыть потоки.

public class Solution08 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        FileOutputStream outputStream1 = new FileOutputStream(reader.readLine());
        FileOutputStream outputStream2 = new FileOutputStream(reader.readLine());
        reader.close();
        int size = inputStream.available();

        if ((inputStream.available() > 0) & (size % 2 == 0))
        {
            byte[] buffer = new byte[inputStream.available() / 2];
            inputStream.read(buffer);
            outputStream1.write(buffer); //первая половина
            inputStream.read(buffer);
            outputStream2.write(buffer); //вторая половина
        }
        else if ((inputStream.available() > 0) & (size % 2 == 1))
        {
            byte[] buffer = new byte[(inputStream.available() / 2) + 1];
            inputStream.read(buffer);
            outputStream1.write(buffer); //первая половина
            int count = inputStream.read(buffer);
            outputStream2.write(buffer,0, count); //вторая половина
        }
        inputStream.close();
        outputStream1.close();
        outputStream2.close();
    }//end void main
}
