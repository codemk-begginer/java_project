/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author BLENDER
 */
public class Eleve {
    String user;
    String nom;
    String prenom;
    String date_n;
    String lieu_n;
    String tel;
    String n_candidat;
    String n_reçue;
    String langue;
    String cycle;
    String sexe;
    String diplome;
    int id;

    public Eleve(String user, String nom, String prenom, String date_n, String lieu_n, String tel,
            String n_candidat,String n_reçue,String langue,String cycle,String sexe) {
        this.user = user;
        this.nom = nom;
        this.prenom = prenom;
        this.date_n = date_n;
        this.lieu_n = lieu_n;
        this.tel = tel;
        this.n_candidat = n_candidat;
        this.n_reçue = n_reçue;
        this.langue = langue;
        this.cycle = cycle;
        this.sexe = sexe;
    }

    public String getN_candidat() {
        return n_candidat;
    }

    public void setN_candidat(String n_candidat) {
        this.n_candidat = n_candidat;
    }

    public String getN_reçue() {
        return n_reçue;
    }

    public void setN_reçue(String n_reçue) {
        this.n_reçue = n_reçue;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }
    public Eleve(String user){
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

    public String getDate_n() {
        return date_n;
    }

    public void setDate_n(String date_n) {
        this.date_n = date_n;
    }

    public String getLieu_n() {
        return lieu_n;
    }

    public void setLieu_n(String lieu_n) {
        this.lieu_n = lieu_n;
    }





    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    
    public void InsertImage(){
        File file = new File("images/"+user+".jpg");
        try {
            FileInputStream input = new FileInputStream(file);
            BD bd = new BD();
            Connection conn = bd.GetConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE candidat SET photo = ? WHERE user = \""+user+"\"");
            ps.setBinaryStream(1, (InputStream)input,(int)file.length());
            ps.executeUpdate();
            ps.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Eleve.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Eleve.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
       public void InsertImage1(){
        File file = new File("diplome/"+user+".jpg");
        try {
            FileInputStream input = new FileInputStream(file);
            BD bd = new BD();
            Connection conn = bd.GetConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE candidat SET diplome = ? WHERE user = \""+user+"\"");
            ps.setBinaryStream(1, (InputStream)input,(int)file.length());
            ps.executeUpdate();
            ps.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Eleve.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Eleve.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
       public void InsertImage2(){
        File file = new File("acte_n/"+user+".jpg");
        try {
            FileInputStream input = new FileInputStream(file);
            BD bd = new BD();
            Connection conn = bd.GetConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE candidat SET acte_n = ? WHERE user = \""+user+"\"");
            ps.setBinaryStream(1, (InputStream)input,(int)file.length());
            ps.executeUpdate();
            ps.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Eleve.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Eleve.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
       public void InsertImage3(){
        File file = new File("cni/"+user+".jpg");
        try {
            FileInputStream input = new FileInputStream(file);
            BD bd = new BD();
            Connection conn = bd.GetConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE candidat SET cni = ? WHERE user = \""+user+"\"");
            ps.setBinaryStream(1, (InputStream)input,(int)file.length());
            ps.executeUpdate();
            ps.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Eleve.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Eleve.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
          public void InsertImage4(){
        File file = new File("certificat_m/"+user+".jpg");
        try {
            FileInputStream input = new FileInputStream(file);
            BD bd = new BD();
            Connection conn = bd.GetConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE candidat SET certificat_m = ? WHERE user = \""+user+"\"");
            ps.setBinaryStream(1, (InputStream)input,(int)file.length());
            ps.executeUpdate();
            ps.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Eleve.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Eleve.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
          
       public void InsertImage5(){
        File file = new File("casier_j/"+user+".jpg");
        try {
            FileInputStream input = new FileInputStream(file);
            BD bd = new BD();
            Connection conn = bd.GetConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE candidat SET casier_j = ? WHERE user = \""+user+"\"");
            ps.setBinaryStream(1, (InputStream)input,(int)file.length());
            ps.executeUpdate();
            ps.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Eleve.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Eleve.class.getName()).log(Level.SEVERE, null, ex);
        }
    }      
    
    public void TakeImage(){
        File dossierBD = new File("images_bd");
        if(!dossierBD.exists()){
            dossierBD.mkdir();
        }
        BD bd = new BD();
        Connection conn = bd.GetConnection();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT photo FROM candidat WHERE user = \""+user+"\"");
            if(rs.next()){
                rs.beforeFirst();
                int i = 0;
                while(rs.next()){
                    InputStream input = rs.getBinaryStream(1);
                    OutputStream output = new FileOutputStream(new File("images_bd/"+user+".jpg"));
                    i++;
                    int b = 0;
                    while((b = input.read()) > -1){
                        output.write(b);
                    }
                    output.close();
                    input.close();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Eleve.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Eleve.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Eleve.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Ajouter(){
        BD bd = new BD();
        Connection conn = bd.GetConnection();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM candidat WHERE user = \""+user+"\"");
            if(rs.next()){
                System.out.println("Cet candidat existe déjà dans la base de données");
                ButtonInfo bi = new ButtonInfo(new JFrame(),true);
                bi.pan.setBackground(Color.red);
                bi.titre1.setText("Erreur de dupplication");
                bi.titre2.setText("Ce matricule existe déjà");
                bi.titre3.setText("Impossible de duppliquer un Matricule dans la base de données");
                bi.setVisible(true);
            }else{
                stm.executeUpdate("INSERT INTO candidat (user, nom, prenom, date_n, lieu_n, tel,n_candidat,n_reçue,langue,cycle,sexe) VALUES( \""+this.user+"\",\""+nom+"\","
                        + "\""+prenom+"\",\""+date_n+"\",\""+lieu_n+"\",\""+tel+"\",\""+n_candidat+"\",\""+n_reçue+"\",\""+langue+"\",\""+cycle+"\",\""+sexe+"\")");
                System.out.println("élève inséré avec Succès");
                ButtonInfo bi = new ButtonInfo(new JFrame(),true);
                bi.pan.setBackground(new Color(47,149,116));
                bi.titre1.setText("Succès !!");
                bi.titre2.setText("candidat Ajouté avec Succès ..");
                bi.titre3.setText("Vous avez ajouté un candidat dans la base de données");
                bi.setVisible(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Eleve.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Modifier(){
        BD bd = new BD();
        Connection conn = bd.GetConnection();
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate("UPDATE candidat SET nom = \""+nom+"\", prenom = \""+prenom+"\", date_n = \""+date_n+"\", lieu_n = \""+lieu_n+"\", "+ "  tel = \""+tel+"\",n_candidat = \""+n_candidat+"\",n_reçue = \""+n_reçue+"\",langue = \""+langue+"\",cycle = \""+cycle+"\",sexe = \""+sexe+"\" WHERE user = \""+user+"\"");
            System.out.println("élève modifié avec Succès");
            ButtonInfo bi = new ButtonInfo(new JFrame(),true);
                bi.pan.setBackground(new Color(47,149,116));
                bi.titre1.setText("Succès !!");
                bi.titre2.setText("Candidat Modifié avec Succès ..");
                bi.titre3.setText("Vous avez Modifié un candidat dans la base de données");
                bi.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Eleve.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Supprimer(){
        BD bd = new BD();
        Connection conn = bd.GetConnection();
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate("DELETE FROM candidat WHERE user = \""+user+"\"");
            System.out.println("candidat Supprimé avec Succès");
            ButtonInfo bi = new ButtonInfo(new JFrame(),true);
                bi.pan.setBackground(new Color(47,149,116));
                bi.titre1.setText("Succès !!");
                bi.titre2.setText("candidat Supprimé avec Succès ..");
                bi.titre3.setText("Vous avez Supprimé un candidat de la base de données");
                bi.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Eleve.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void PrintEleve(){
        File folder = new File("documents");
        if(!folder.exists()){
            folder.mkdir();
        }
        String nom_fichier = "documents/Informations_de_"+user+".pdf";
        Font TitleFont = new Font(Font.FontFamily.TIMES_ROMAN,16,Font.BOLD,BaseColor.BLUE);
        Font RedFont = new Font(Font.FontFamily.TIMES_ROMAN,14,Font.BOLD,BaseColor.RED);
        File imageEleve = new File("images/"+user+".jpg");
        String chemin = imageEleve.getAbsolutePath();
        LineSeparator ls = new LineSeparator();
        ls.setLineColor(BaseColor.BLUE);
        Image image = null;
        BD bd = new BD();
        Document document = new Document();
        Connection conn = bd.GetConnection();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM candidat WHERE user = \""+user+"\"");
            rs.first(); String nom = rs.getString("nom"),prenom = rs.getString("prenom"),date_n = rs.getString("date_n"),
                    lieu_n = rs.getString("lieu_n"),tel = rs.getString("tel"),mat = user,langue = rs.getString("langue")
                    ,cycle = rs.getString("cycle"),sexe = rs.getString("sexe"),nationalité = rs.getString("n_candidat");

            //
            if(imageEleve.exists()){
                image = Image.getInstance(chemin);
            }else{
                image = Image.getInstance("default.png");
            }
            PdfWriter.getInstance(document, new FileOutputStream(nom_fichier));
            document.open();
            document.addTitle("Informations sur l'élève "+nom+" "+prenom);
            document.addAuthor("STEVE MK");
            nom = nom.toUpperCase(); prenom = prenom.toUpperCase();
            Paragraph preface = new Paragraph();
            Paragraph titre = new Paragraph("INFORMATIONS SUR LE CANDIDAT "+nom+" "+prenom,TitleFont);
            titre.setAlignment(Element.ALIGN_CENTER);
            preface.add(titre);
            //ajout de l'image
            image.scaleAbsolute(120,120);
            document.add(image);
            preface.add(ls);
            //création des chunks
            Chunk c_langue = new Chunk(langue,RedFont);
            Chunk c_sexe = new Chunk(sexe,RedFont);
            Chunk c_cycle = new Chunk(cycle,RedFont);
            Chunk c_nationalité = new Chunk(nationalité,RedFont);
            Chunk c_nom = new Chunk(nom,RedFont);Chunk c_prenom = new Chunk(prenom,RedFont);
            Chunk c_date_n = new Chunk(date_n,RedFont);
            Chunk c_lieu_n = new Chunk(lieu_n,RedFont);
            Chunk c_tel = new Chunk(tel,RedFont);
            Chunk c_mat = new Chunk(mat,RedFont);
            preface.add(new Paragraph(" "));preface.add(new Paragraph(" "));
            preface.add("E-MAIL DU CANDIDAT : ");preface.add(c_mat);preface.add(new Paragraph(" "));
            preface.add("NOM DU CANDIDAT : ");preface.add(c_nom);preface.add(new Paragraph(" "));
            preface.add("PRENOM DU CANDIDAT : ");preface.add(c_prenom);preface.add(new Paragraph(" "));
            preface.add("DATE DE NAISSANCE : ");preface.add(c_date_n);preface.add(new Paragraph(" "));
            preface.add("LIEU DE NAISSANCE : ");preface.add(c_lieu_n);preface.add(new Paragraph(" "));
            preface.add("LANGUE DU CANDIDAAT : ");preface.add(c_langue);preface.add(new Paragraph(" "));
            preface.add("SEXE DU CANDIDAT : ");preface.add(c_sexe);preface.add(new Paragraph(" "));
            preface.add("NATIONALITE : ");preface.add(c_nationalité);preface.add(new Paragraph(" "));
            preface.add("CYCLE CHOISIE : ");preface.add(c_cycle);preface.add(new Paragraph(" "));
            preface.add("TELEPHONE : ");preface.add(c_tel);preface.add(new Paragraph(" "));
            //preface.add("CLASSE DE l'ELEVE : ");preface.add(c_classe);preface.add(new Paragraph(" "));
            //preface.add("REDOUBLE-T-IL LA CLASSE ? : ");preface.add(c_red);preface.add(new Paragraph(" "));
            document.add(preface);
            document.close();
            UI ui = new UI();
            ui.SetRed();
            int valid = JOptionPane.showOptionDialog(
                  null,
                    new Object[]{
                        "Voulez-vous directement ouvrir le fichier ?",
                        "___________________________________________",
                        "Cliquez sur \"OUI\" pour ouvrir ou sur \"NON\" pour annuler",
                    },
                    "Ouverture du fichier "+nom_fichier,
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null,
                    null,
                    "OK"
            );
            if(valid == JOptionPane.OK_OPTION){
                File ouvrir = new File(nom_fichier);
                Desktop desk = Desktop.getDesktop();
                desk.open(ouvrir);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Eleve.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadElementException ex) {
            Logger.getLogger(Eleve.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Eleve.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(Eleve.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void PrintEleves(){
        BaseColor couleurEntete = new BaseColor(155,221,247);
        File folder = new File("documents");
        if(!folder.exists()){
            folder.mkdir();
        }
        String nom_fichier = "documents/Liste_Des_Candidats.pdf";
        Font TitleFont = new Font(Font.FontFamily.TIMES_ROMAN,16,Font.BOLD,BaseColor.BLUE);
        Font RedFont = new Font(Font.FontFamily.TIMES_ROMAN,14,Font.BOLD,BaseColor.RED);
        File imageEleve = new File("images/"+user+".jpg");
        String chemin = imageEleve.getAbsolutePath();
        LineSeparator ls = new LineSeparator();
        ls.setLineColor(BaseColor.BLUE);
        Image image = null;
        BD bd = new BD();
        Document document = new Document();
        Connection conn = bd.GetConnection();
        try {
            Statement stm = conn.createStatement();
           
            PdfWriter.getInstance(document, new FileOutputStream(nom_fichier));
            document.open();
            document.addTitle("Liste des Candidats");
            document.addAuthor("STEVE MK");
            Paragraph preface = new Paragraph();
            Paragraph titre = new Paragraph("LISTE DES CANDIDATS",TitleFont);
            titre.setAlignment(Element.ALIGN_CENTER);
            preface.add(titre);
            preface.add(ls);
            
            PdfPTable table = new PdfPTable(8);
            PdfPCell c1 = new PdfPCell(new Phrase("ID"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setBackgroundColor(couleurEntete);
            table.addCell(c1);
            c1 = new PdfPCell(new Phrase("Nom"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setBackgroundColor(couleurEntete);
            table.addCell(c1);
            
            c1 = new PdfPCell(new Phrase("Prénom"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setBackgroundColor(couleurEntete);
            table.addCell(c1);
            
            c1 = new PdfPCell(new Phrase("Date Naissance"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setBackgroundColor(couleurEntete);
            table.addCell(c1);
            
            c1 = new PdfPCell(new Phrase("Lieu Naissance"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setBackgroundColor(couleurEntete);
            table.addCell(c1);
            
            c1 = new PdfPCell(new Phrase("Téléphone"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setBackgroundColor(couleurEntete);
            table.addCell(c1);
            
            c1 = new PdfPCell(new Phrase("langue"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setBackgroundColor(couleurEntete);
            table.addCell(c1);
            
            c1 = new PdfPCell(new Phrase("Nationalité"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setBackgroundColor(couleurEntete);
            table.addCell(c1);
            
            ResultSet rs = stm.executeQuery("SELECT * FROM candidat");
            while(rs.next()){
               String red = String.valueOf(rs.getInt("id"));
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String date_n = rs.getString("date_n");
                String lieu_n = rs.getString("lieu_n");
                String tel = rs.getString("tel");
                String langue = rs.getString("langue");
                String nationalité = rs.getString("n_candidat");
                table.addCell(red);
                table.addCell(nom);
                table.addCell(prenom);
                table.addCell(date_n);
                table.addCell(lieu_n);
                table.addCell(tel);
                table.addCell(langue);
                table.addCell(nationalité);
            }
            table.setHeaderRows(1);
            table.setWidthPercentage((float)100.0);
            document.add(preface);
            document.add(new Paragraph(" "));
            document.add(ls);
            document.add(table);
            document.close();
            UI ui = new UI();
            ui.SetRed();
            int valid = JOptionPane.showOptionDialog(
                  null,
                    new Object[]{
                        "Voulez-vous directement ouvrir le fichier ?",
                        "___________________________________________",
                        "Cliquez sur \"OUI\" pour ouvrir ou sur \"NON\" pour annuler",
                    },
                    "Ouverture du fichier "+nom_fichier,
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null,
                    null,
                    "OK"
            );
            if(valid == JOptionPane.OK_OPTION){
                File ouvrir = new File(nom_fichier);
                Desktop desk = Desktop.getDesktop();
                desk.open(ouvrir);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Eleve.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadElementException ex) {
            Logger.getLogger(Eleve.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Eleve.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(Eleve.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
