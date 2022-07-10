/* 
lev18:Wrapper (Decorator)
Аналогично классу DecoratorRunnableImpl создай класс DecoratorMyRunnableImpl.
Вывод в консоль должен быть таким:
DecoratorRunnableImpl body
DecoratorMyRunnableImpl body
RunnableImpl body
*/

public class Solution11 {

    public static void main(String[] args) {
        new Thread(new DecoratorRunnableImpl(new DecoratorMyRunnableImpl(new RunnableImpl()))).start();
    }//end void main

    public static class RunnableImpl implements Runnable {
        @Override
        public void run() {
            System.out.println("RunnableImpl body");
        }
    }//end void class RunnableImpl

    public static class DecoratorRunnableImpl implements Runnable {
        private Runnable component;

        public DecoratorRunnableImpl(Runnable component) {
            this.component = component;
        }//end Constructor

        @Override
        public void run() {
            System.out.println("DecoratorRunnableImpl body");
            component.run();
        }
    }//end class DecoratorRunnableImpl

    public static class DecoratorMyRunnableImpl implements Runnable {
        private Runnable component;

        public DecoratorMyRunnableImpl(Runnable component) {
            this.component = component;
        }//end Constructor

        @Override
        public void run() {
            System.out.println("DecoratorMyRunnableImpl body");
            component.run();
        }
    }//end class DecoratorMyRunnableImpl
}