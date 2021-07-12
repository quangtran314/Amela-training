public class Calculator {
    private double firstOperand;
    private double secondOperand;

    public Calculator(){
        this.firstOperand = 1;
        this.secondOperand = 1;
    }

    public Calculator(double firstOperand, double secondOperand) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }

    public double getFirstOperand() {
        return firstOperand;
    }

    public void setFirstOperand(double firstOperand) {
        this.firstOperand = firstOperand;
    }

    public double getSecondOperand() {
        return secondOperand;
    }

    public void setSecondOperand(double secondOperand) {
        this.secondOperand = secondOperand;
    }

    public double sum(){
        return this.firstOperand + this.secondOperand;
    }

    public double subtract(){
        return this.firstOperand - this.secondOperand;
    }

    public double divide(){
        double result = 0;
        if(this.secondOperand == 0){
            throw new ArithmeticException();
        }
        result = this.firstOperand / this.secondOperand;
        return result;
    }

    public double multiply(){
        return this.firstOperand * this.secondOperand;
    }
}
