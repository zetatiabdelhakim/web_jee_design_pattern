package ma.xproce.presentation;

import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ma.xproce.business.EtudiantManager;
import ma.xproce.business.Util;
import ma.xproce.dao.Etudiant;
import ma.xproce.dao.EtudiantDAO;
import ma.xproce.dao.MongoDAO;
import ma.xproce.database.Mongodb;

import java.io.IOException;

@WebServlet("/login")
public class Prss_logIn extends HttpServlet {
    private EtudiantManager manager;
    private Util util;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String errorMessage = "";
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        Etudiant e = manager.checkUser(email, password);
        if(e != null){
            HttpSession session =  req.getSession();
            session.setAttribute("name", e.getName());
            session.setAttribute("id", e.getId());
            resp.sendRedirect("indexUser.jsp");

            return;
        }
        else{
            errorMessage = "The email or password is incorrect";
            req.setAttribute("error", errorMessage);
            RequestDispatcher view = req.getRequestDispatcher("login.jsp");
            view.forward(req, resp);
        }
    }

    @Override
    public void init() throws ServletException {
        ServletContext get = getServletContext();
//        CollectionDatabase databaseFacade = CollectionDatabase.builder()
//                .dbUrl(get.getInitParameter("url"))
//                .username(get.getInitParameter("username"))
//                .password(get.getInitParameter("password"))
//                .build();
        String connectionString = "mongodb+srv://zetati:Xofr2019@cluster0.ecywqeo.mongodb.net/";
        String dbName = "Etudiants";
        Mongodb databaseFacade = Mongodb.builder().dbName(dbName).conection(connectionString).build();
//        MongoDAO etudiantFacade = new MongoDAO(databaseFacade);
        get.setAttribute("database", databaseFacade);
        get.setAttribute("connection", databaseFacade.databaseLayer());
        MongoDAO dao = new MongoDAO(databaseFacade);
        manager = new EtudiantManager(dao);
        get.setAttribute("manager", manager);
//        manager = (EtudiantManager) getServletContext().getAttribute("manager");
        util = Util.getInstance();
    }
}
