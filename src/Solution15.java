import java.util.List;

//lev18:
//������ ����� TableInterfaceWrapper ���, ����� �� ���� Wrapper-�� ��� TableInterface.
//����� setModel ������ ������� � ������� ���������� ��������� � ������ ����� ����������� ������ (������� ������ setModel � ������� ���� TableInterface).
//����� getHeaderText ������ ���������� ����� � ������� �������� - ��������� ����� toUpperCase().

public class Solution15 {

    public class TableInterfaceWrapper implements TableInterface {

        private TableInterface component;

        public TableInterfaceWrapper(TableInterface component) {
            this.component = component;
        }

        @Override
        public void setModel(List rows) {
            System.out.println(rows.size());
            component.setModel(rows);
        }

        @Override
        public String getHeaderText() {
            return component.getHeaderText().toUpperCase();
        }

        @Override
        public void setHeaderText(String newHeaderText) {
            component.setHeaderText(newHeaderText);
        }
    }//end class TableInterfaceWrapper

    public interface TableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);

    }//end interface TableInterface

    public static void main(String[] args) {
    }//end void main
}
