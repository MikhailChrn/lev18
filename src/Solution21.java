import java.io.FileInputStream;
import java.io.IOException;
import java.util.TreeMap;

//lev18:
//
//Программа запускается с одним параметром - именем файла, который содержит английский текст.
//Посчитать частоту встречания каждого символа.
//Отсортировать результат по возрастанию кода ASCII (почитать в инете).

public class Solution21 {
    public static void main(String[] args) throws IOException {
        if (args.length > 1 || args.length == 0)
            return;
        TreeMap<Integer, Integer> symbols = new TreeMap<>();
        FileInputStream inputStream = new FileInputStream(args[0]);
        symbols.put(inputStream.read(), 1);
        Integer i;
        while (inputStream.available() > 0) {
            i = inputStream.read();
            if (symbols.containsKey(i) == true) {
                Integer currentValue = symbols.get(i);
                symbols.put(i, ++currentValue);
            } else if (symbols.containsKey(i) == false)
                symbols.put(i, 1);
        }//end while
        inputStream.close();

        symbols.entrySet().forEach(entry -> {
            System.out.println((char) ((int) entry.getKey()) + " " + entry.getValue());
        });
    }
}