package by.iba.Servlet;

import by.iba.Servlet.List.ListService;
import by.iba.Servlet.Model.Person;
import by.iba.Servlet.dao.PersonDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/GroupServlet", name = "GroupServlet")
public class GroupListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    //private ListService todoService = new ListService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PersonDao daoPerson = new PersonDao();

        String nname = request.getParameter("nname");
        String nphone = request.getParameter("nphone");
        String nemail = request.getParameter("nemail");
        if ((nname == null) || (nphone == null) || (nemail == null)) {
            request.setAttribute("errorMessage", "Заполните все поля");
        } else {
            daoPerson.insertPerson(new Person(nname, nphone, nemail));
            //ListService.addPerson(new Person(nname, nphone, nemail));
        }
        //request.setAttribute("group", ListService.retrieveList());
        request.setAttribute("group", daoPerson.getPersons());
        request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PersonDao daoPerson = new PersonDao();

        //request.setAttribute("group", ListService.retrieveList());
        request.setAttribute("group", daoPerson.getPersons());
        daoPerson.closeConnection();
        request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
    }
}
