package ma.xproce.presentation;

import com.mongodb.client.MongoDatabase;
import ma.xproce.business.EtudiantManager;
import ma.xproce.dao.Etudiant;
import ma.xproce.dao.EtudiantDAOArrayList;
import ma.xproce.dao.MongoDAO;
import ma.xproce.database.ArrayListDatabase;
import ma.xproce.database.Mongodb;
import org.bson.Document;

public class TestApp {

    public TestApp() {

        String connectionString = "mongodb+srv://zetati:Xofr2019@cluster0.ecywqeo.mongodb.net/";
        String dbName = "Etudiants";
        Mongodb databaseFacade = Mongodb.builder().dbName(dbName).conection(connectionString).build();
        MongoDAO etudiantFacade = new MongoDAO(databaseFacade);

//        ArrayListDatabase databaseFacade = new ArrayListDatabase();
//        EtudiantDAOArrayList etudiantFacade = new EtudiantDAOArrayList(databaseFacade);
        EtudiantManager etudiantManagerFacade = new EtudiantManager(etudiantFacade);


        Etudiant etudiant1 = Etudiant.builder().id(1).name("x").password("kkkk").email("x@gmail.com").build();
        Etudiant etudiant2 = Etudiant.builder().id(2).name("b").password("ttt").email("b@gmail.com").build();
        Etudiant etudiant3 = Etudiant.builder().id(3).name("i").password("kkjuhgk").email("x@gmail.com").build();


        Etudiant etudiantchacked1 = etudiantManagerFacade.save(etudiant1);
        if (etudiantchacked1 != null) {
            System.out.println(etudiantchacked1 + " has been added successfully");
        } else {
            System.out.println("The email already exists !! Try an other email");
        }
        Etudiant etudiantchacked2 = etudiantManagerFacade.save(etudiant2);
        if (etudiantchacked2 != null) {
            System.out.println(etudiantchacked2 + "has been added successfully");
        } else {
            System.out.println("The email already exists !! Try an other email");
        }
        Etudiant etudiantchacked3 = etudiantManagerFacade.save(etudiant3);
        if (etudiantchacked3 != null) {
            System.out.println(etudiantchacked3 + "has been added successfully");
        } else {
            System.out.println("The email already exists !! Try an other email");
        }

        System.out.println(etudiantManagerFacade.getAll());



    }

    public static void main(String[] args) {
        new TestApp();
    }
}








