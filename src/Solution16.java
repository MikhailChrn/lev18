import java.io.FileInputStream;
import java.io.IOException;

//lev18:
//� ����� main ������ ���������� �������� ���� � �����.
//��������� ���������� �������� � �����, ������� ������������� ������ ����������� ��������.
//������� �� ����� ����� (���������� ��������).
//������� ������.

public class Solution16 {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        int count = 0;
        char c;
        while (inputStream.available() > 0) {
            c = (char) inputStream.read();
            if ((c >= 'a' & c <= 'z') | (c >= 'A' & c <= 'Z'))
                count++;
        }
        inputStream.close();
        System.out.println(count);
    }
}
