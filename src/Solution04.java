import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;

public class Solution04 {
    //lev18:Самые редкие байты
    //Ввести с консоли имя файла.
    //Найти байт или байты с минимальным количеством повторов.
    //Вывести их на экран через пробел.
    //Закрыть поток ввода-вывода.

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());

        HashMap<Integer, Integer> bytesMap = new HashMap<>();
        bytesMap.put(inputStream.read(), 1);

        while (inputStream.available() > 0) {
            int currentByte = inputStream.read();
            if (bytesMap.containsKey(currentByte))
                bytesMap.put(currentByte, bytesMap.get(currentByte) + 1);
            else if (!bytesMap.containsKey(currentByte))
                bytesMap.put(currentByte, 1);
        }//end while

        reader.close();
        inputStream.close();

        Integer minQuantity = Collections.min(bytesMap.values());//минимальное кол-во
        bytesMap.entrySet().forEach(entry -> {
            if (entry.getValue() == minQuantity) System.out.print(entry.getKey() + " ");
        });
    }//end void main
}
