package ma.xproce.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import ma.xproce.database.DatabaseFacade;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MongoDAO implements EtudiantFacade{
    private final DatabaseFacade database;
    private final MongoDatabase connection;
    public MongoDAO(DatabaseFacade databaseFacade) {
        this.database = databaseFacade;
        this.connection = (MongoDatabase) database.databaseLayer();
    }

    @Override
    public Etudiant save(Etudiant etudiant) {
        MongoCollection<Document> collection = connection.getCollection("etudiant");
        Document document = new Document("id", etudiant.getId())
                .append("name", etudiant.getName())
                .append("email", etudiant.getEmail())
                .append("password", etudiant.getPassword());
        collection.insertOne(document);
        return etudiant;
    }

    @Override
    public Etudiant update(Etudiant etudiant) {
        MongoCollection<Document> collection = connection.getCollection("etudiant");
        Document query = new Document("id", etudiant.getId());

        Document updatedDocument = new Document("$set",
                new Document("name", etudiant.getName())
                        .append("email", etudiant.getEmail())
                        .append("password", etudiant.getPassword()));
        collection.updateOne(query, updatedDocument);
        return etudiant;
    }

    @Override
    public Etudiant delete(Etudiant etudiant) {
        MongoCollection<Document> collection = connection.getCollection("etudiant");
        Document query = new Document("id", etudiant.getId());
        collection.deleteOne(query);
        return etudiant;
    }

    @Override
    public List<Etudiant> findAll() {
        MongoCollection<Document> collection = connection.getCollection("etudiant");
        List<Etudiant> etudiants = new ArrayList<>();
        for (Document document : collection.find()) {
            Etudiant etudiant = new Etudiant();
            etudiant.setId(document.getInteger("id"));
            etudiant.setName(document.getString("name"));
            etudiant.setEmail(document.getString("email"));
            etudiant.setPassword(document.getString("password"));
            etudiants.add(etudiant);
        }
        return etudiants;
    }

    @Override
    public Etudiant findById(int id) {
        MongoCollection<Document> collection = connection.getCollection("etudiant");
        Document query = new Document("id", id);
        Document result = collection.find(query).first();
        if (result != null) {
            Etudiant etudiant = new Etudiant();
            etudiant.setId(result.getInteger("id"));
            etudiant.setName(result.getString("name"));
            etudiant.setEmail(result.getString("email"));
            etudiant.setPassword(result.getString("password"));
            return etudiant;
        }
        return null;
    }

    @Override
    public Etudiant findByEmail(String email) {
        MongoCollection<Document> collection = connection.getCollection("etudiant");
        Document query = new Document("email", email);
        Document result = collection.find(query).first();
        if (result != null) {
            Etudiant etudiant = new Etudiant();
            etudiant.setId(result.getInteger("id"));
            etudiant.setName(result.getString("name"));
            etudiant.setEmail(result.getString("email"));
            etudiant.setPassword(result.getString("password"));
            return etudiant;
        }
        return null;
    }

    @Override
    public Etudiant checkUser(String email, String password) {
        MongoCollection<Document> collection = connection.getCollection("etudiant");
        Document query = new Document("email", email).append("password", password);
        Document result = collection.find(query).first();
        if (result != null) {
            Etudiant etudiant = new Etudiant();
            etudiant.setId(result.getInteger("id"));
            etudiant.setName(result.getString("name"));
            etudiant.setEmail(result.getString("email"));
            etudiant.setPassword(result.getString("password"));
            return etudiant;
        }
        return null;

    }
}
