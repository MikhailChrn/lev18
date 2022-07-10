package Solution12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
lev18:
Используя шаблон проектирования Wrapper (Decorator) расширь функциональность AmigoOutputStream.
В классе QuestionFileOutputStream при вызове метода close() должна быть реализована следующая функциональность:
1. Вывести в консоль фразу "Вы действительно хотите закрыть поток? Д/Н".
2. Считай строку.
3. Если считанная строка равна "Д", то закрыть поток.
4. Если считанная строка не равна "Д", то не закрывать поток.
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
        System.out.println("Âû äåéñòâèòåëüíî õîòèòå çàêðûòü ïîòîê? Ä/Í");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        if ("Ä".equals(reader.readLine())) component.close();
        reader.close();
    }
}
