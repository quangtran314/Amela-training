import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet", value = "/calculate")
public class CalculatorServlet extends HttpServlet {
    private final String SUM = "+";
    private final String SUB = "-";
    private final String DIV = "/";
    private final String MUL = "*";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double first_operand = Double.parseDouble(request.getParameter("first-operand"));
        double second_operand = Double.parseDouble(request.getParameter("second-operand"));
        String operator = request.getParameter("operator");
        try{
            double result = calculate(first_operand, second_operand, operator);
            RequestDispatcher dispatcher = request.getRequestDispatcher("calculator.jsp");
            request.setAttribute("first_operand", first_operand);
            request.setAttribute("second_operand", second_operand);
            request.setAttribute("operator", operator);
            request.setAttribute("result", result);
            try{
                dispatcher.forward(request, response);
            } catch (ServletException e){
                e.getStackTrace();
            } catch (IOException e){
                e.getStackTrace();
            }
        } catch (ArithmeticException e){
            PrintWriter writer = response.getWriter();
            writer.println("Can't divide by 0");
        }
    }

    private double calculate(double operand1, double operand2, String operator) throws ArithmeticException{
        Calculator calculator = new Calculator(operand1, operand2);
        double result = 0;
        switch (operator){
            case SUM:
                result = calculator.sum();
                break;
            case SUB:
                result = calculator.subtract();
                break;
            case DIV:
                result = calculator.divide();
                break;
            case MUL:
                result = calculator.multiply();
                break;
            default:
                break;
        }
        return result;
    }
}
