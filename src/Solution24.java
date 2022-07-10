import java.io.*;

//lev18:
//������� � ������� ����� ������.
//���� ����� �� ���������� (�������� ������������ ��� �����), �� �����������
//���������� FileNotFoundException, ������� � ������� ���������� ������������
//��� ����� � ��������� ������ ���������.
//������� ������.
//�� ��������� System.exit();

public class Solution24 {
    public static void main() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream in; //����� �������
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