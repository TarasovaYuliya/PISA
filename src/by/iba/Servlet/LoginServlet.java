package by.iba.Servlet;

import by.iba.Servlet.List.ListService;
import by.iba.Servlet.Util.HashPassword;
import by.iba.Servlet.dao.UserDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/*Перед определением класса указана аннотация WebServlet, которая
указывает, с какой конечной точкой будет сопоставляться данный сервлет. То есть
данный сервлет будет обрабатывать запросы по адресу "/login".*/
@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request,
                          javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        /*request.setCharacterEncoding("UTF-8");
        request.setAttribute("name", request.getParameter("name"));
        request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);*/

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        UserDao daoUser = new UserDao();

        //if (validateUser(name, password)) {
        if (daoUser.isValidUser(name, HashPassword.getHash(password))) {
            //request.setAttribute("name", name);
            request.getSession().setAttribute("name", name);

            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie c : cookies) {
                    Cookie cookie = c;
                    System.out.println(cookie.getName()+cookie.getValue());
                    if (name.equals((cookie.getName()))){
                        request.setAttribute("lastdate", cookie.getValue());
                    }
                }
            }

            Cookie userCookie = new Cookie(name, LocalDateTime.now().toString());
            userCookie.setMaxAge(60*60*24*100);
            response.addCookie(userCookie);

            request.getRequestDispatcher("/GroupServlet").forward(request, response);
           /* request.getSession().setAttribute("name", name);
            response.sendRedirect(request.getContextPath()+"/GroupServlet");
            request.setAttribute("group", ListService.retrieveList());
            request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);*/
        } else {
            request.setAttribute("errorMessage", "Неверный логин или пароль!");
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request,
                         javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
       /* PrintWriter out=response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Good morning</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("First Servlet");
        out.println("</body>");
        out.println("</html>");*/
        //request.setAttribute("name", "Tarasova");
        //request.setAttribute("password", "888");
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
    }

   /* public boolean validateUser(String user, String password) {
        return user.equalsIgnoreCase("admin") && password.equals("admin");
    }*/
}
