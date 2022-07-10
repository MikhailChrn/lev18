import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

//lev18:
//С консоли считать имя файла.
//Посчитать в файле количество символов ',', количество вывести на консоль.
//Закрыть потоки.

public class Solution07 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        reader.close();
        int numberComma = 0;//кол-во запятых
        while (inputStream.available() > 0) if (inputStream.read() == 44) numberComma++;
        System.out.println(numberComma);
        inputStream.close();
    }//end main
}
