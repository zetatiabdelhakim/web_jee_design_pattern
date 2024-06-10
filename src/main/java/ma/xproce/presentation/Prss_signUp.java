package ma.xproce.presentation;

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

@WebServlet("/signup")
public class Prss_signUp extends HttpServlet {
    private EtudiantManager manager;
    private Util util;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String errorMessage = "";
        String name = req.getParameter("nom");
        String password = req.getParameter("password");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        if (name.trim().isEmpty()){
            errorMessage = "Name must not be empty";
        }else if (login.trim().isEmpty()){
            errorMessage = "login must not be empty";
        }else if (!util.isPasswordValid(password)){
            errorMessage = "Password must have at least 4 characters";
        } else if (!util.isValidEmail(email)){
            errorMessage = "The form of the email is invalid";
        } else{
            Etudiant e = manager.save(Etudiant.builder()
                    .password(password)
                    .name(name)
                    .email(email)
                    .build());
            if(e != null){
                HttpSession session =  req.getSession();
                session.setAttribute("name", e.getName());
                session.setAttribute("id", e.getId());
                resp.sendRedirect("indexUser.jsp");
                return;
            }
            else{
                errorMessage = "Email already exists";
            }
        }
        req.setAttribute("error", errorMessage);
        RequestDispatcher view = req.getRequestDispatcher("signup.jsp");
        view.forward(req, resp);



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
