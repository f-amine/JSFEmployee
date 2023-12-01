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
import service.ServiceService;

/**
 *
 * @author lenovo
 */
@ManagedBean
@RequestScoped
public class CollaborateurBean{
    
    private Employe chef;
    private Service service;
    private List<Employe> employes;
    private List<Service> services;
    private EmployeService  es;
    private ServiceService ss;

    public CollaborateurBean() {
        service= new Service();
        chef = new Employe();
        es = new EmployeService();
        ss = new ServiceService(); 
    }

    public Employe getChef() {
        return chef;
    }

    public void setChef(Employe chef) {
        this.chef = chef;
    }
    
    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }
    
     public List<Service> getServices() {
        if(services == null)
            services = ss.getAll();
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
    
    public void load(){
        service = ss.getById(service.getId());
        List<Employe> emps = es.getAll();
        for(Employe e: emps)
        {
            if(e.getService().getId()== service.getId())
            {
                if(e.getEnmployeChef() == null )
                {
                    for(Employe ee : emps){
                        if(ee.getEnmployeChef()!=null && ee.getEnmployeChef().getId() == e.getId())
                        {
                            chef = e;
                            break;
                        }
                    }
                }
            }
        }
        for(Employe e: emps){
             if(e.getEnmployeChef()!=null && e.getEnmployeChef().getId()!=0)
             {
                 System.out.println("Em Service : " + e.getService().getLibelle());
                 System.out.println("Employe : " + e.getId() + " -- Chef : " + e.getEnmployeChef().getId());
                 System.out.println("Chef Service : " + chef.getService().getLibelle());
                 System.out.println("Chef : " +chef.getId());
                 System.out.println("-----------------------");
             }
         }
    }
    
}
