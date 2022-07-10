import java.io.FileInputStream;
import java.io.IOException;

//lev18:
//� ����� main ������ ���������� �������� ���� � �����.
//������� �� ����� ����������� ���������� �������� � ���������� ���� ��������. ��������, 10.45.
//1. ��������� ���������� ���� ��������.
//2. ��������� ���������� ��������.
//3. ������� �� ����� �2/�1*100, �������� �� 2 ������ ����� ������� �� ����������.
//4. ������� ������.

public class Solution17 {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        int total = inputStream.available();
        int spcCh = 0;
        while (inputStream.available() > 0)
            if ((char) inputStream.read() == ' ') spcCh++;
        inputStream.close();
        System.out.printf("%.2f", (double) spcCh*100/total);
    }
}