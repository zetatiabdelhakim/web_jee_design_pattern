package ma.xproce.dao;

import ma.xproce.database.DatabaseFacade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class EtudiantDAO implements EtudiantFacade {
    private final DatabaseFacade database;
    private final Connection connection;
    public EtudiantDAO(DatabaseFacade databaseFacade) {
        this.database = databaseFacade;
        this.connection = (Connection) database.databaseLayer();
    }
    @Override
    public Etudiant save(Etudiant etudiant) {
        PreparedStatement query = null;
        Etudiant result = null;
        String insertQuery = "INSERT INTO etudiant (name, email, password) VALUES (?, ?, ?)";
        try{
            query = connection.prepareStatement(insertQuery);
            query.setString(1, etudiant.getName());
            query.setString(2, etudiant.getEmail());
            query.setString(3, etudiant.getPassword());
            int numAdd = query.executeUpdate();
            result = (numAdd > 0)? etudiant : null;
        }catch (Exception e){
            System.out.println("Error ," + e.getMessage());
        }
        return result;
    }
    public Etudiant checkUser(String email, String password) {
        PreparedStatement query = null;
        ResultSet result = null;
        Etudiant etudiant = null;

        String selectQuery = "SELECT * FROM etudiant WHERE email=? AND password=?";
        try {
            query = connection.prepareStatement(selectQuery);
            query.setString(1, email);
            query.setString(2, password);
            result = query.executeQuery();

            if (result.next()) {
                etudiant = Etudiant.builder()
                        .id(result.getInt("id"))
                        .name(result.getString("name"))
                        .email(result.getString("email"))
                        .password(result.getString("password"))
                        .build();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return etudiant;
    }

    @Override
    public Etudiant update(Etudiant etudiant) {
        PreparedStatement query = null;
        Etudiant result = null;
        String updateQuery = "UPDATE etudiant SET name=?, email=?, password=? WHERE id=?";
        try {
            query = connection.prepareStatement(updateQuery);
            query.setString(1, etudiant.getName());
            query.setString(2, etudiant.getEmail());
            query.setString(3, etudiant.getPassword());
            query.setLong(4, etudiant.getId());

            int numUpdate = query.executeUpdate();
            result = (numUpdate > 0) ? etudiant : null;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return result;
    }


    @Override
    public Etudiant delete(Etudiant etudiant) {

        PreparedStatement query = null;
        Etudiant result = null;
        String deleteQuery = "DELETE FROM etudiant WHERE id=?";
        try {
            query = connection.prepareStatement(deleteQuery);
            query.setLong(1, etudiant.getId());

            int numDelete = query.executeUpdate();
            result = (numDelete > 0) ? etudiant : null;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return result;
    }

    @Override
    public List<Etudiant> findAll() {
        List<Etudiant> etudiants = new ArrayList<>();
        PreparedStatement query = null;
        ResultSet result = null;

        String selectQuery = "SELECT * FROM etudiant";
        try {
            query = connection.prepareStatement(selectQuery);
            result = query.executeQuery();

            while (result.next()) {
                Etudiant etudiant = Etudiant.builder()
                        .id(result.getInt("id"))
                        .name(result.getString("name"))
                        .email(result.getString("email"))
                        .password(result.getString("password"))
                        .build();
                etudiants.add(etudiant);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return etudiants;
    }

    @Override
    public Etudiant findById(int id) {
        PreparedStatement query = null;
        ResultSet result = null;
        Etudiant etudiant = null;

        String selectQuery = "SELECT * FROM etudiant WHERE id=?";
        try {
            query = connection.prepareStatement(selectQuery);
            query.setInt(1, id);
            result = query.executeQuery();

            if (result.next()) {
                etudiant = Etudiant.builder()
                        .id(result.getInt("id"))
                        .name(result.getString("name"))
                        .email(result.getString("email"))
                        .password(result.getString("password"))
                        .build();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return etudiant;
    }

    @Override
    public Etudiant findByEmail(String email) {

        PreparedStatement query = null;
        ResultSet result = null;
        Etudiant etudiant = null;

        String selectQuery = "SELECT * FROM etudiant WHERE email=?";
        try {
            query = connection.prepareStatement(selectQuery);
            query.setString(1, email);
            result = query.executeQuery();
            if (result.next()) {
                etudiant = Etudiant.builder()
                        .id(result.getInt("id"))
                        .name(result.getString("name"))
                        .email(result.getString("email"))
                        .password(result.getString("password"))
                        .build();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return etudiant;
    }
}
