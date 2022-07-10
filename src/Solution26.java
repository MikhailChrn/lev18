import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//lev18:
//Придумать механизм шифровки/дешифровки.

//Программа запускается с одним из следующих наборов параметров:
//-e fileName fileOutputName
//-d fileName fileOutputName

public class Solution26 {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[1]);
        FileOutputStream outputStream = new FileOutputStream(args[2]);
        int data;

        if ("-e".equals(args[0])) {
            while (inputStream.available() > 0) {
                data = inputStream.read() + 1;
                outputStream.write(data);
            }

        } else if ("-d".equals(args[0])) {
            while (inputStream.available() > 0) {
                data = inputStream.read() - 1;
                outputStream.write(data);
            }
        }//end else if

        inputStream.close();
        outputStream.close();
    }//end void main
}

