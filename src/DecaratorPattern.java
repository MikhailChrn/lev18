public class DecaratorPattern {
    public static void main(String[] args) {
        PrinterInterface printer = new DecoratorPrinter(new Printer("Привет!"));
        printer.print();
    }
}

interface PrinterInterface {
    void print();
}//end interface PrinterInterface

class Printer implements PrinterInterface {
    String value;

    public Printer(String value) {
        this.value = value;
    }

    @Override
    public void print() {
        System.out.println(value);
    }
}//end class Printer

class DecoratorPrinter implements PrinterInterface {
    PrinterInterface component;

    public DecoratorPrinter(PrinterInterface component) {
        this.component = component;
    }

    @Override
    public void print() {
        System.out.println("\"");
        component.print();
        System.out.println("\"");
    }
}//end class DecoratorPrinter
