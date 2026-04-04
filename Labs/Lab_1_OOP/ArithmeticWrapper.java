package Labs.Lab_1_OOP;

public class ArithmeticWrapper {

    private static class Arithmetic {
        private int a;
        private int b;
        
        private Arithmetic (int a, int b){
            this.a = a;
            this.b = b;
        }

        public int getA(){
            return a;
        }

        public int getB() {
            return b;
        }

        public void setA(int a) {
            this.a = a;
        }

        public void setB(int b) {
            this.b = b;
        }

        public int add(){
            return a + b;
        }

        public int subtract(){
            return a - b;
        }

        public int multiply(){
            return a * b;
        }

        public double divide(){
            return a / b;
        }
    }

    public static class Calculator extends Arithmetic {

        public Calculator(int a, int b) {
            super(a, b);
        }
    }
}
