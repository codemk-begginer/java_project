/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author BLENDER
 */
public class EleveList extends javax.swing.JPanel {

    /**
     * Creates new form EleveList
     */
    public EleveList() {
        initComponents();
        InitEleve();
    }

    public void InitEleve(){
        String[] entete = {"Matricule","Nom de l'élève","Prénom de l'élève","Date de naissance","Lieu de naissance","Téléphone","Langue","Nationalité","Modifier","Supprimer"};
        String req = "SELECT user,nom,prenom,date_n,lieu_n,tel,langue,n_candidat FROM candidat ";
        Table table = new Table(entete,entete.length,entete.length-2,req);
        JTable tab = table.getTable();
        JScrollPane pane = table.getPane(content.getWidth());
        TableColumnModel modele = tab.getColumnModel();
        modele.getColumn(0).setCellRenderer(new CellCenter());
        modele.getColumn(1).setCellRenderer(new CellCenter());
        modele.getColumn(2).setCellRenderer(new CellCenter());
        modele.getColumn(3).setCellRenderer(new CellCenter());
        modele.getColumn(4).setCellRenderer(new CellCenter());
        modele.getColumn(7).setCellRenderer(new CellCenter());
        modele.getColumn(8).setCellRenderer(new ButtonEdit());
        modele.getColumn(9).setCellRenderer(new ButtonDelete());
        modele.getColumn(8).setCellEditor(new CellEditorEdit(new JCheckBox()));
        modele.getColumn(9).setCellEditor(new CellEditorDelete(new JCheckBox()));
        content.removeAll();
        content.setLayout(new BorderLayout());
        content.add(pane);
        content.revalidate();
    }
    
    
    public class CellEditorEdit extends DefaultCellEditor{
    private JButton button;
    private String label;
    private boolean clicked;
    private int row, col;
    private JTable table;
    
    public CellEditorEdit(JCheckBox checkBox){
        super(checkBox);
        button = new JButton();
        button.setOpaque(true);
        button.setForeground(Color.black);
        button.setBackground(Color.red);
        //button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wn.png")));
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                fireEditingStopped();
            }
        });
    }
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column){
        this.table = table;
        this.row = row;
        this.col = column;
        button.setForeground(Color.black);
        button.setBackground(Color.red);
        button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico-edit.png")));
        label = (value == null) ? "" : value.toString();
        //button.setText(label);
        clicked = true;
        return button;
    }
    public Object getCellEditorValue(){
        if (clicked){
           //Action au clic de la souris
            Edit(table.getValueAt(row, 0).toString());
        }
        clicked = false;
        return new String(label);
    }

    public boolean stopCellEditing(){
        clicked = false;
        return super.stopCellEditing();
    }

    protected void fireEditingStopped(){
        super.fireEditingStopped();
    }    
}
    public class CellEditorDelete extends DefaultCellEditor{
    private JButton button;
    private String label;
    private boolean clicked;
    private int row, col;
    private JTable table;
    
    public CellEditorDelete(JCheckBox checkBox){
        super(checkBox);
        button = new JButton();
        button.setOpaque(true);
        button.setForeground(Color.black);
        button.setBackground(Color.red);
        //button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wn.png")));
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                fireEditingStopped();
            }
        });
    }
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column){
        this.table = table;
        this.row = row;
        this.col = column;
        button.setForeground(Color.black);
        button.setBackground(Color.red);
        button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico-delete.png")));
        label = (value == null) ? "" : value.toString();
        //button.setText(label);
        clicked = true;
        return button;
    }
    public Object getCellEditorValue(){
        if (clicked){
           //Action au clic de la souris
            Delete(table.getValueAt(row, 0).toString());
        }
        clicked = false;
        return new String(label);
    }

    public boolean stopCellEditing(){
        clicked = false;
        return super.stopCellEditing();
    }

    protected void fireEditingStopped(){
        super.fireEditingStopped();
    }    
}
    public void Edit(String user){
       //edition 
        EleveEdit ee = new EleveEdit(new JFrame(),true,user,this);
        ee.setVisible(true);
    }
    public void Delete(String user){
        //suppression
        UI ui = new UI();
        ui.SetRed();
        BD bd = new BD();
        Connection conn = bd.GetConnection();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM candidat WHERE user = \""+user+"\"");
            rs.first(); String nom = rs.getString("nom"); String prenom = rs.getString("prenom");
            int valid = JOptionPane.showOptionDialog(
                    null,
                    new Object[]{
                        "Voulez-vous vraiment supprimer cet élève ?",
                        nom+" "+prenom,
                        "____________________________________________________",
                        "Cette opération est irreversible",
                        "____________________________________________________",
                        "Cliquez sur \"OUI\" pour valider ou sur \"NON\" pour annuler"
                    },
                    "Suppression de l'élève "+nom+" "+prenom,
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null,
                    null,
                    "OK"
            );
            ui.ResetUI();
            if(valid == JOptionPane.OK_OPTION){
                Eleve e = new Eleve(user);
                e.Supprimer();
                this.InitEleve();
            }
        } catch (SQLException ex) {
            Logger.getLogger(EleveList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        content = new javax.swing.JPanel();

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Liste des élèves");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 494, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel content;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
