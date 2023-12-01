/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author lenovo
 */
@Entity
public class Employe {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String photo ;

    @ManyToOne
    private Service service;
    
    @ManyToOne
    @JoinColumn(name = "chef")
    private Employe enmployeChef;
    
    public Employe() {
    }

    public Employe(String nom, String prenom, Date dateNaissance, String photo, Service service, Employe enmployeChef) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.photo = photo;
        this.service = service;
        this.enmployeChef = enmployeChef;
    }
    
     public Employe(String nom, String prenom, Date dateNaissance, Service service,Employe enmployeChef) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        if(enmployeChef!=null)
        {
            this.enmployeChef = enmployeChef;
        }
        this.service = service;
    }
     
      public Employe(String nom, String prenom, Date dateNaissance, Service service) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.service = service;
    }


    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Employe getEnmployeChef() {
        return enmployeChef;
    }

    public void setEnmployeChef(Employe enmployeChef) {
        this.enmployeChef = enmployeChef;
    }
    
    
    
}
