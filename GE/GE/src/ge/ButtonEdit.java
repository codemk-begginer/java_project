/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author BLENDER
 */
public class ButtonEdit extends JButton implements TableCellRenderer{
    public ButtonEdit()
    {
      setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
      setForeground(Color.black);
      setBackground(Color.red);
      setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico-edit.png")));
      setText((value == null) ? "" : value.toString());
      return this;
    }
}
