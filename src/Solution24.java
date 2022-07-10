import java.io.*;

//lev18:
//Читайте с консоли имена файлов.
//Если файла не существует (передано неправильное имя файла), то перехватить
//исключение FileNotFoundException, вывести в консоль переданное неправильное
//имя файла и завершить работу программы.
//Закрыть потоки.
//Не используй System.exit();

public class Solution24 {
    public static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream in; //Новое решение
        String fileName;
        while(true){
            fileName = reader.readLine();
            try{
                in = new FileInputStream(fileName);
                while (in.available() > 0) System.out.print(in.read());
                in.close();
            } catch (FileNotFoundException e){
                System.out.println(fileName);
                reader.close();
                break;
            }
        }
    }
}