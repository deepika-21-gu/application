import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TextFieldTest extends JFrame {

	JTextField tf1, tf2, tf3;
	JPasswordField pf;
	
	public TextFieldTest() {
		
		// Step1: Get Container from your Frame
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		
		TextFieldHandler handler = new TextFieldHandler();
		
		tf1 = new JTextField("TextField1");
		tf1.addActionListener(handler);
		container.add(tf1);
		
		tf2 = new JTextField("TextField2");
		tf2.addActionListener(handler);
		container.add(tf2);
		
		// I want to show content "123456789" but visible characters would be 5
		tf3 = new JTextField("123456AJKDsbfajkwdADF789", 25);
		tf3.addActionListener(handler);
		
		// I don't want that user can edit anything in this text field
		tf3.setEditable(false);
		
		container.add(tf3);
		
		pf = new JPasswordField("MyPassword");
		pf.addActionListener(handler);
		container.add(pf);
		
		// Last two steps : Set Size and Set Visible
		setSize(500, 500);
		setVisible(true);
	}
	
	public class TextFieldHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String message = "";
			
			if(e.getSource() == tf1) {
				message = "Text Field 1 " + e.getActionCommand();
			}
			else if(e.getSource() == tf2) {
				message = "Text Field 2 " + e.getActionCommand();
			}
			else if(e.getSource() == tf3) {
				message = "Text Field 3 " + e.getActionCommand();
			}
			else if(e.getSource() == pf) {
				JPasswordField field = (JPasswordField)e.getSource();
				
				message = "Password Field " + new String(field.getPassword());
			}
			
			// Show message
			JOptionPane.showMessageDialog(null, message);
		}
		
	
	}
}
