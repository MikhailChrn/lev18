import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;

public class Solution03 {
    //lev18:Самые частые байты
    //Ввести с консоли имя файла.
    //Найти байт или байты с максимальным количеством повторов.
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

        Integer maxQuantity = Collections.max(bytesMap.values());//максимальное кол-во
        bytesMap.entrySet().forEach(entry -> {
            if (entry.getValue() == maxQuantity) System.out.print(entry.getKey() + " ");
        });
    }//end void main
}
