package customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

@WebServlet(name = "CustomersServlet", value = "/list")
public class CustomersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Customer> list = getListCustomer();
        RequestDispatcher dispatcher = request.getRequestDispatcher("listCustomer.jsp");
        request.setAttribute("list", list);
        try{
            dispatcher.forward(request, response);
        } catch (ServletException e){
            e.getStackTrace();
        } catch (IOException e){
            e.getStackTrace();
        }
    }

    protected ArrayList<Customer> getListCustomer(){
        ArrayList<Customer> list = new ArrayList<>();
        list.add(new Customer("hello", 1997, "TB"));
        list.add(new Customer("world", 2000, "TB"));
        list.add(new Customer("earth", 1000, "galaxy"));
        return list;
    }
}
