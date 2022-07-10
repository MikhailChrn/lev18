package Solution13;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//lev18:
//1 ������ ����� AmigoOutputStream ���, ����� �� ���� Wrapper-�� ��� ������ FileOutputStream. ��������� ������������.
//2 ��� ������ ������ close() ������ ����������� ��������� ������������������ ��������:
//2.1 ������� ����� flush().
//2.2 �������� � ����� ����� ����� "JavaRush � All rights reserved.", ��������� ����� getBytes().
//2.3 ������� ����� ������� close().

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
        String str = "JavaRush � All rights reserved.";
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
