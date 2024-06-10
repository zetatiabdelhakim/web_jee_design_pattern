package ma.xproce.business;

import ma.xproce.dao.Etudiant;
import ma.xproce.dao.EtudiantFacade;

import java.util.List;

public class EtudiantManager implements EtudiantManagerFacade {
    private EtudiantFacade etudiantFacade;
    private Util util;
    public EtudiantManager(EtudiantFacade etudiantFacade){
        this.etudiantFacade = etudiantFacade;
        this.util = Util.getInstance();
    }
    @Override
    public Etudiant checkMail(String email) {
        if(! util.isValidEmail(email))
            return null;
        return etudiantFacade.findByEmail(email);
    }

    @Override
    public Etudiant save(Etudiant etudiant) {
        Etudiant etudiantIsThere = checkMail(etudiant.getEmail());
        etudiant.setPassword(util.hashPassword(etudiant.getPassword()));
        if (etudiantIsThere == null) {
            etudiantFacade.save(etudiant);
            return etudiant;
        }
        return null;
    }
    public Etudiant checkUser(String email, String password){
        return etudiantFacade.checkUser(email, util.hashPassword(password));
    }
    @Override
    public Etudiant update(Etudiant etudiant) {
        Etudiant etudiantIsThere = checkMail(etudiant.getEmail());
        etudiant.setPassword(util.hashPassword(etudiant.getPassword()));
        if (etudiantIsThere == null) {
            etudiantFacade.update(etudiant);
            return etudiant;
        }
        return null;
    }

    @Override
    public Etudiant delete(Etudiant etudiant) {
        return etudiantFacade.delete(etudiant);
    }

    @Override
    public List<Etudiant> getAll() {
        return  etudiantFacade.findAll();
    }

    @Override
    public Etudiant getById(int id) {
        return etudiantFacade.findById(id);
    }

    @Override
    public Etudiant getByEmail(String email) {
        return etudiantFacade.findByEmail(email);
    }
}
