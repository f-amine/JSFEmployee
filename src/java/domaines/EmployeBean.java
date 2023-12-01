/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domaines;

import java.util.List;
import entities.Employe;
import entities.Service;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import service.EmployeService;

/**
 *
 * @author lenovo
 */
@ManagedBean
@RequestScoped
public class EmployeBean{
    
    private Employe employe;
    private List<Employe> employes;
    private EmployeService  es;

    public EmployeBean() {
        employe = new Employe();
        employe.setService(new Service());
        employe.setEnmployeChef(new Employe());
        es = new EmployeService();
        
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public List<Employe> getEmployes() {
        if(employes == null)
            employes = es.getAll();
        return employes;
    }

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }
    
    public void onCreateAction(){
        if(employe.getEnmployeChef().getId() == 0){
            employe.setEnmployeChef(null);
        }
        es.create(employe);
        employe = new Employe();
    }
    
}
