import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

//lev18:
//Читайте с консоли имена файлов, пока не будет введено слово "exit".
//Передайте имя файла в нить ReadThread.
//Нить ReadThread должна найти байт, который встречается в файле максимальное
//число раз, и добавить его в словарь resultMap,
//где параметр String - это имя файла, параметр Integer - это искомый байт.
//Закрыть потоки.

public class Solution23 {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();;

    public static void main() throws IOException {
        // select work-file
        BufferedReader sourceFileReader = new BufferedReader(new InputStreamReader(System.in));
        String source = "";
        int threadCount = 0;
        ArrayList<ReadThread> threads = new ArrayList<>();
        while (true) {
            source = sourceFileReader.readLine().trim();
            if ("exit".equals(source)) break;
            threads.add(new ReadThread(source));
            threads.get(threadCount).start();
            threadCount++;
        }
        //from stackOverFlow for Java 8 or later
        resultMap.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " " + entry.getValue());
        });
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            // implement constructor body
            this.fileName = fileName;
        }

        // implement file reading here - реализуйте чтение из файла тут
        public void run() {
            try {
                FileInputStream inputStream = new FileInputStream(fileName);
                int[] ASCIIbytes = new int[256];
                while (inputStream.available() > 0)
                    ASCIIbytes[inputStream.read()]++;
                inputStream.close();

                int maxRepeat = 0;
                for (int i = 0; i < ASCIIbytes.length; i++) {
                    if (ASCIIbytes[i] > maxRepeat)
                        maxRepeat = ASCIIbytes[i];
                }
                for (int i = 0; i < ASCIIbytes.length; i++) {
                    if (ASCIIbytes[i] == maxRepeat)
                        resultMap.put(fileName, i);
                }

            } catch (IOException ex) {
                System.out.println("File are not found!");
                return;
            }
        }// end void run
    }// end class ReadThread
}

