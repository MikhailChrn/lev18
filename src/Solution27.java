import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

//lev18:

//CRUD для таблицы внутри файла.
//Напиши программу, которая считывает с консоли путь к файлу для операций CRUD и при запуске со следующим набором параметров:
//-c productName price quantity
//добавляет товар с заданными параметрами с новой строки в конец файла,
//генерируя id (8 символов) самостоятельно путем инкремента максимального id, найденного в файле.

public class Solution27 {
    public static void main(String[] args) throws Exception {
        if (args.length < 4 || !args[0].equals("-c")) return;
        switch (args[0]) {
            case ("-c"):
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String source = reader.readLine();
                reader.close();

                FileReader fileReader = new FileReader(source);
                IdReader idReader = new IdReader();
                Integer maxID = idReader.findMaxID(fileReader);
                fileReader.close();

                String id = String.format("%-8.8s", ++maxID);
                String productName = String.format("%-30.30s", args[1]);
                String price = String.format("%-8.8s", args[2]);
                String quantity = String.format("%-4.4s", args[3]);
                String currentWrite = id + productName + price + quantity;

                FileWriter fileWriter = new FileWriter(source, true);
                fileWriter.write("\n");
                fileWriter.write(currentWrite);
                fileWriter.close();
                break;
            default:
                System.out.println("try again");
        }
    }//end void main

    public static class IdReader {
        Integer currentID;
        ArrayList<Integer> IDs = new ArrayList<Integer>();
        public int findMaxID(FileReader fileReader) throws IOException {
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();
            while (line != null) {
                IDs.add(Integer.parseInt(line.substring(0, 8).trim()));
                line = reader.readLine();
            }
            reader.close();
            return Collections.max(IDs);
        }//end int findMaxID
    }//end class IdReader
}