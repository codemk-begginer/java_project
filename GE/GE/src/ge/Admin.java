/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author BLENDER
 */
public class Admin {
    String user;
    String nom;
    String prenom;
    String mdp;

    public Admin(String user, String nom, String prenom, String mdp) {
        this.user = user;
        this.nom = nom;
        this.prenom = prenom;
        this.mdp = mdp;
    }
    public Admin(String user){
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    
    public void Ajouter(){
        BD bd = new BD();
        Connection conn = bd.GetConnection();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM admin WHERE user = \""+user+"\"");
            if(rs.next()){
                System.out.println("Cet administrateur existe dans la base de données. Impossible de l'ajouter");
            }else{
                //insertion
                stm.executeUpdate("INSERT INTO admin(user, nom, prenom, mdp) VALUES(\""+user+"\",\""+nom+"\",\""+prenom+"\",\""+mdp+"\") ");
                System.out.println("Admin ajouté avec Succès ...");
                ButtonInfo bi = new ButtonInfo(new JFrame(),true);
                bi.pan.setBackground(new Color(47,149,116));
                bi.titre1.setText("Succès !!");
                bi.titre2.setText("Administrateur inséré avec Succès ..");
                bi.titre3.setText("");
                bi.setVisible(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Modifier(){
        BD bd = new BD();
        Connection conn = bd.GetConnection();
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate("UPDATE admin SET nom = \""+this.nom+"\", prenom = \""+prenom+"\", mdp = \""+mdp+"\" WHERE user = \""+user+"\"");
            System.out.println("Administrateur modifié avec Succès ...");
            ButtonInfo bi = new ButtonInfo(new JFrame(),true);
                bi.pan.setBackground(new Color(47,149,116));
                bi.titre1.setText("Succès !!");
                bi.titre2.setText("Administrateur modifié avec Succès ..");
                bi.titre3.setText("");
                bi.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Supprimer(){
        BD bd = new BD();
        Connection conn = bd.GetConnection();
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate("DELETE FROM admin WHERE user = \""+user+"\"");
            System.out.println("Administrateur Supprimé avec Succès ...");
            ButtonInfo bi = new ButtonInfo(new JFrame(),true);
                bi.pan.setBackground(new Color(47,149,116));
                bi.titre1.setText("Succès !!");
                bi.titre2.setText("Administrateur Suppeirmé avec Succès ..");
                bi.titre3.setText("");
                bi.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
