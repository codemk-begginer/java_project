
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class CellEditor extends DefaultCellEditor{
    private JButton button;
    private String label;
    private boolean clicked;
    private int row, col;
    private JTable table;
    
    public CellEditor(JCheckBox checkBox){
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