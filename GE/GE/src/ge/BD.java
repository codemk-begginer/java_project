/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge;

import com.mysql.jdbc.Connection;
import java.awt.Color;
import java.sql.DriverManager;
import javax.swing.JFrame;

/**
 *
 * @author BLENDER
 */
public class BD {
    //éléments de connexion à la base de données
    String hostBD;
    String userBD;
    String mdpBD;
    String nameBD;
    String portBD;
    Connection conn;
    public BD(){
        hostBD = "localhost";
        userBD = "root";
        mdpBD = "";
        nameBD = "java";
        portBD = "3306";
    }
    public Connection GetConnection(){
        String url = "jdbc:mysql://"+hostBD+":"+portBD+"/"+nameBD;
        //chargement du driver
        String Driver = "com.mysql.jdbc.Driver";
        try{
            Class.forName(Driver);
            System.out.println("Le driver JDBC a été chargé avec Succès !!!");
            try{
                conn = (Connection) DriverManager.getConnection(url, userBD, mdpBD);
                
            }catch(Exception ex){
                System.out.println("Erreur de connexion à la base de données");
            }
        }catch(Exception ex){
            System.out.println("Erreur de chargement du driver : "+ex.getLocalizedMessage());
            ButtonInfo bi = new ButtonInfo(new JFrame(),true);
            bi.pan.setBackground(Color.red);
            bi.titre1.setText("Erreur de chargement du Driver JDBC");
            bi.titre2.setText("Le driver JDBC n'a pas été chargé");
            bi.titre3.setText("Verifier le nom et le chemin d'accès au Driver dans le projet");
            bi.setVisible(true);
        }
        return conn;
    }
}
