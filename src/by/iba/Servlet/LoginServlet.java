package by.iba.Servlet;

import by.iba.Servlet.List.ListService;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/*Перед определением класса указана аннотация WebServlet, которая
указывает, с какой конечной точкой будет сопоставляться данный сервлет. То есть
данный сервлет будет обрабатывать запросы по адресу "/login".*/
@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        /*request.setCharacterEncoding("UTF-8");
        request.setAttribute("name", request.getParameter("name"));
        request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);*/

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        if (validateUser(name, password)) {
            request.getSession().setAttribute("name", name);
            response.sendRedirect(request.getContextPath()+"/GroupServlet");
            /*request.setAttribute("group", ListService.retrieveList());
            request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);*/
        } else {
            request.setAttribute("errorMessage", "Invalid Login and password!");
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
       /* PrintWriter out=response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Good morning</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("First Servlet");
        out.println("</body>");
        out.println("</html>");*/
        request.setAttribute("name", "Tarasova");
        request.setAttribute("password", "888");
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
    }

    public boolean validateUser(String user, String password) {
        return user.equalsIgnoreCase("admin") && password.equals("admin");
    }
}
