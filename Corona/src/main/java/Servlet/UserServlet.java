package Servlet;

import Dao.EmployeeDao;
import Dto.EmployeeDto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserServlet extends HttpServlet {

    private final EmployeeDao dao = new EmployeeDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get method is called");
        try {
            List<EmployeeDto> dtos = dao.getAllEmployee();

            System.out.println("Got employees of size:: " + dtos.size());

            req.setAttribute("employees", dtos);

            System.out.println("Forwarding to index.jsp..");
            req.getRequestDispatcher("Db.jsp").forward(req, resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error:: " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeDto employee= new EmployeeDto();
        employee.setFullName(req.getParameter("name"));
        employee.setEmail(req.getParameter("email"));
        employee.setPassword(req.getParameter("password"));
        employee.setAddress(req.getParameter("address"));
        employee.setZip(req.getParameter("zip"));
        employee.setCity(req.getParameter("city"));
        employee.setState(req.getParameter("state"));
        try {
            dao.saveEmployee(employee);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        resp.sendRedirect("user");
    }
}
