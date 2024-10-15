/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge;

import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author BLENDER
 */
public class CellCenter extends DefaultTableCellRenderer {
	//private static final long serialVersionUID = 1L;
	public CellCenter() {
		setHorizontalAlignment(CENTER);
		setVerticalAlignment(CENTER);
	}
    }
