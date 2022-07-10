import java.io.*;
import java.util.ArrayList;

public class Solution28 {

    //lev18:
    //
    //CRUD для таблицы внутри файла.
    //Напиши программу, которая считывает с консоли путь к файлу для операций CRUD и при запуске в зависимости от флага,
    //переданного в параметрах обновляет данные товара с заданным id или производит физическое удаление товара с заданным id
    // (удаляет из файла все данные, которые относятся к переданному id).
    //-u id productName price quantity
    //-d id

    public static void main(String[] args) throws Exception {
        if (args.length != 2 & args.length != 5) {
            System.out.println("Try again!");
            return;
        }
        Integer currentID = Integer.parseInt(args[1]);

        // select work-file
        BufferedReader sourceReader = new BufferedReader(new InputStreamReader(System.in));
        String source = sourceReader.readLine().trim();
        sourceReader.close();

        // bulding new list from file
        BufferedReader fileLineReader = new BufferedReader(new FileReader(source));
        ArrayList<String> temporary = new ArrayList<String>();
        String line = fileLineReader.readLine();// first string
        while (line != null) {
            if (Integer.parseInt(line.substring(0, 8).trim()) != currentID)
                temporary.add(line);
            else if (args[0].equals("-d") & Integer.parseInt(line.substring(0, 8).trim()) == currentID) ;
            else if (args[0].equals("-u") & Integer.parseInt(line.substring(0, 8).trim()) == currentID) {
                // add updated string block
                String ID = String.format("%-8.8s", currentID);
                String productName = String.format("%-30.30s", args[2]);
                String price = String.format("%-8.8s", args[3]);
                String quantity = String.format("%-4.4s", args[4]);
                temporary.add(ID + productName + price + quantity);
            } // end else if
            line = fileLineReader.readLine();
        } // end while
        fileLineReader.close();

        // updaiting file block
        BufferedWriter fileLineWriter = new BufferedWriter(new FileWriter(source));
        if (temporary.size() == 1)
            fileLineWriter.write(temporary.get(0));
        else {
            fileLineWriter.write(temporary.get(0));
            for (int i = 1; i < temporary.size(); i++) {
                fileLineWriter.write("\n");
                fileLineWriter.write(temporary.get(i));
            }
        }
        fileLineWriter.close();
    }// end void main
}