package Solution14;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//lev18
//������ ����� TxtInputStream ���, ����� �� ������� ������ � txt-������� (*.txt).
//��������, first.txt ��� name.1.part3.txt.
//���� ������� �� txt-����, ��������, file.txt.exe, �� ����������� ������ ����������� ���������� UnsupportedFileNameException.
//�������, ��� ��� ����� �������, � ������ ������������ ����������.

public class TxtInputStream extends FileInputStream {

    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {
        super(fileName);
        if (!fileName.endsWith(".txt")) {
            super.close();
            throw new UnsupportedFileNameException();
        }
    }//end constructor

    public static void main(String[] args) {
    }
}
