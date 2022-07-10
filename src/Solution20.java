import java.io.*;

//lev18:
//Считать с консоли 2 имени файла.
//Первый файл содержит вещественные(дробные) числа, разделенные пробелом.
//Например, 3.1415.
//Округлить числа до целых и записать через пробел во второй файл.
//Закрыть потоки.

public class Solution20 {
    public static void main() throws IOException {
        BufferedReader sourceFileReader = new BufferedReader(new InputStreamReader(System.in));
        String sourceFileName = sourceFileReader.readLine().trim();
        String resultFileName = sourceFileReader.readLine().trim();
        sourceFileReader.close();

        String[] string = readFileToString(sourceFileName).split(" ");
        Double[] doubles = new Double[string.length];
        for (int i = 0; i < string.length; i++) doubles[i] = Double.parseDouble(string[i]);

        try (FileWriter fileWriter = new FileWriter(new File(resultFileName));
             BufferedWriter writer = new BufferedWriter(fileWriter)) {
            for (Double dbl : doubles) writer.write(Math.round(dbl) + " ");
            writer.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFileToString(String fileName) {
        //Procerdure from stackOverFlow
        StringBuilder sb = new StringBuilder();
        try (FileReader fileReader = new FileReader(new File(fileName));
             BufferedReader reader = new BufferedReader(fileReader)) {
            String str;
            while ((str = reader.readLine()) != null) {
                sb.append(str);
            }
            reader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
