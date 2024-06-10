package ma.xproce.presentation;

import com.mongodb.client.MongoClient;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import ma.xproce.database.CollectionDatabase;
import ma.xproce.dao.*;
import ma.xproce.business.*;
import ma.xproce.database.Mongodb;

import com.mongodb.client.MongoDatabase;
import ma.xproce.business.EtudiantManager;
import ma.xproce.dao.Etudiant;
import ma.xproce.dao.EtudiantDAOArrayList;
import ma.xproce.dao.MongoDAO;
import ma.xproce.database.ArrayListDatabase;
import ma.xproce.database.Mongodb;
import org.bson.Document;

//import java.sql.Connection;
public class ListenerContext implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
//        ServletContext get = sce.getServletContext();
////        CollectionDatabase databaseFacade = CollectionDatabase.builder()
////                .dbUrl(get.getInitParameter("url"))
////                .username(get.getInitParameter("username"))
////                .password(get.getInitParameter("password"))
////                .build();
//        String connectionString = "mongodb+srv://zetati:Xofr2019@cluster0.ecywqeo.mongodb.net/";
//        String dbName = "Etudiants";
//        Mongodb databaseFacade = Mongodb.builder().dbName(dbName).conection(connectionString).build();
////        MongoDAO etudiantFacade = new MongoDAO(databaseFacade);
//        get.setAttribute("database", databaseFacade);
//        get.setAttribute("connection", databaseFacade.databaseLayer());
//        EtudiantDAO dao = new EtudiantDAO(databaseFacade);
//        EtudiantManager manager = new EtudiantManager(dao);
//        get.setAttribute("manager", manager);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
//        ServletContext get = sce.getServletContext();
//        MongoClient connection = (MongoClient) get.getAttribute("connection");
//        try {
//            connection.close();
//        }catch (Exception e) {
//            System.out.println("Error closing connection");
//        }

    }
}
