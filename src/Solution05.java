import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution05 {
    //lev18:Сортировка байт
    //Ввести с консоли имя файла.
    //Считать все байты из файла.
    //Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
    //Вывести на экран.
    //Закрыть поток ввода-вывода.

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());

        ArrayList<Integer> byteList = new ArrayList<>();
        byteList.add(inputStream.read());

        while (inputStream.available() > 0) {
            int currentByte = inputStream.read();
            if (!byteList.contains(currentByte)) byteList.add(currentByte);
        }//end while

        reader.close();
        inputStream.close();

        Collections.sort(byteList); //сортировка списка
        for (int i : byteList) System.out.print(i + " ");
    }//end void main
}
