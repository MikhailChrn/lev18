package Solution12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
lev18:��������� AmigoOutputStream
��������� ������ �������������� Wrapper (Decorator) ������� ���������������� AmigoOutputStream.
� ������ QuestionFileOutputStream ��� ������ ������ close() ������ ���� ����������� ��������� ����������������:
1. ������� � ������� ����� "�� ������������� ������ ������� �����? �/�".
2. ������ ������.
3. ���� ��������� ������ ����� "�", �� ������� �����.
4. ���� ��������� ������ �� ����� "�", �� �� ��������� �����.


*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    private AmigoOutputStream component;

    public QuestionFileOutputStream(AmigoOutputStream component) {
        this.component = component;
    }

    @Override
    public void flush() throws IOException {
        component.flush();
    }

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
        System.out.println("�� ������������� ������ ������� �����? �/�");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        if ("�".equals(reader.readLine())) component.close();
        reader.close();
    }
}