import java.io.FileInputStream;
import java.io.IOException;

public class CountByteExample {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("c:/java/data1.txt");
        long sum = 0;
        int count = 0;

        while (inputStream.available() > 0) //пока остались непрочитанные байты
        {
            int data = inputStream.read();//прочитать очередной байт
            System.out.print(data);
            count++;
            sum += data;
        }

        inputStream.close();

        System.out.println();
        System.out.println("Количество байт: " + count);
        System.out.println("     Сумма байт: " + count);
    }//end main
}
