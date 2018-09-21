package Syllabus;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableInNullLayout
{
  public static void main(String[] argv) throws Exception {

      DefaultTableModel model = new DefaultTableModel(
          new String[][] { { "a", "123"} , {"b", "456"} }, 
          new String[] { "name", "value" } );

      JTable t = new JTable(model);

      JPanel panel = new JPanel(null);

      JScrollPane scroll = new JScrollPane(t);
      scroll.setBounds( 0, 20, 150, 100 ); // x, y, width, height
      panel.add(scroll);

      JFrame frame = new JFrame();
      frame.add(panel);
     frame.setExtendedState(6);
      frame.setVisible(true);
  }
}