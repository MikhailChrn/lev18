package Solution13;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//lev18:
//1 Измени класс AmigoOutputStream так, чтобы он стал Wrapper-ом для класса FileOutputStream. Используй наследование.
//2 При вызове метода close() должны выполняться следующая последовательность действий:
//2.1 Вызвать метод flush().
//2.2 Записать в конец файла фразу "JavaRush © All rights reserved.", используй метод getBytes().
//2.3 Закрыть поток методом close().

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";

    private FileOutputStream component;

    public AmigoOutputStream(FileOutputStream component) throws FileNotFoundException {
        super(fileName);
        this.component = component;
    }//end constructor

    @Override
    public void write(int b) throws IOException {
        component.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        component.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        component.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        String str = "JavaRush © All rights reserved.";
        component.flush();
        component.write(str.getBytes());
        component.close();
    }

    @Override
    public void flush() throws IOException {
        component.flush();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }//end void main
}
