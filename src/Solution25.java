import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

//lev18:
//Собираем файл из кусочков.
//Считывать с консоли имена файлов.
//Каждый файл имеет имя: [someName].partN.
//
//Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.

public class Solution25 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> inputFilesList = new ArrayList<>();
        String fileName;
        while (true) {
            fileName = reader.readLine();
            if ("end".equals(fileName)) break;
            inputFilesList.add(fileName);
        }
        Collections.sort(inputFilesList);

        String outputFileName = inputFilesList.get(0).substring(0, inputFilesList.get(0).lastIndexOf("."));
        FileOutputStream outputStream = new FileOutputStream(outputFileName); //Нужен буфер!!

        for (String inp : inputFilesList) {
            try {
                FileInputStream inputStream = new FileInputStream(inp);
                while (inputStream.available() > 0) {
                    byte[] buffer = new byte[inputStream.available()];
                    int count = inputStream.read(buffer);
                    outputStream.write(buffer, 0, count);
                }
                inputStream.close();
            } catch (IOException ex) {
                outputStream.close();
            }
        }//end for
        outputStream.close();
    }//end void main
}