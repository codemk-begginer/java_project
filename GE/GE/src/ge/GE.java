/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge;

import java.sql.Connection;

/**
 *
 * @author BLENDER
 */
public class GE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connexion con = new Connexion();
        con.setVisible(true);
        BD bd  = new BD();
        Connection conn = bd.GetConnection();
    }
    
}
