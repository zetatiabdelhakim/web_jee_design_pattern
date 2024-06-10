package ma.xproce.dao;

import ma.xproce.database.DatabaseFacade;

import java.util.List;

public class EtudiantDAOArrayList implements EtudiantFacade{
    private DatabaseFacade database;

    private List<Etudiant> etudiants;

    public EtudiantDAOArrayList(DatabaseFacade databaseFacade) {
        this.database = databaseFacade;
        this.etudiants = (List<Etudiant>) database.databaseLayer();
        //etudiants.add(Etudiant.builder().name("Badr").email("badr@gmail.com").build());
    }

    @Override
    public Etudiant save(Etudiant etudiant) {
        try {
            etudiants.add(etudiant);
            return etudiant;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Etudiant update(Etudiant etudiant) {
        for (Etudiant etudiant_ : etudiants) {
            if (etudiant_.getId() == etudiant.getId()) {
                etudiants.set(etudiants.indexOf(etudiant_), etudiant);
                return etudiant;
            }
        }
        return null;
    }

    @Override
    public Etudiant delete(Etudiant etudiant) {

        if (etudiants.remove(etudiant)) {
            return etudiant;
        }
        return null;
    }

    @Override
    public List<Etudiant> findAll() {
        return etudiants;
    }

    @Override
    public Etudiant findById(int id) {

        for (Etudiant etudiant : etudiants) {
            if (etudiant.getId() == id) {
                return etudiant;
            }
        }
        return null;
    }

    @Override
    public Etudiant findByEmail(String email) {
        for (Etudiant etudiant : etudiants) {
            if (etudiant.getEmail() == email) {
                return etudiant;
            }
        }
        return null;
    }

    @Override
    public Etudiant checkUser(String email, String password) {
        for (Etudiant etudiant : etudiants) {
            if (etudiant.getEmail().equals(email) && etudiant.getPassword().equals(password)) {
                return etudiant;
            }
        }
        return null;
    }
}
