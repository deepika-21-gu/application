import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ButtonTest extends JFrame {
	
	JButton button1, button2;
	
	public ButtonTest() {
		
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		
		ButtonHandler handler = new ButtonHandler();
		
		button1 = new JButton();
		button1.setText("Button1");
		button1.addActionListener(handler);
		container.add(button1);
		
		Icon normalStateIcon = new ImageIcon("button.png");
		Icon rolloverStateIcon = new ImageIcon("button_change.png");
		
		button2 = new JButton();
		button2.setText("Button2");
		button2.setIcon(normalStateIcon);
		button2.setRolloverIcon(rolloverStateIcon);
		button2.addActionListener(handler);
		container.add(button2);
		
		setSize(500, 500);
		setVisible(true);
	}

	public class ButtonHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			// Get Source = object location
			// getActionCommand - button title
			
			
			
			if (e.getSource() == button1) {
				System.out.println("Button 1 has originated this event.");
			}
			else if (e.getSource() == button2) {
				System.out.println("It's button2");
			}
			else {
				System.out.println("Something else " + e.getActionCommand());
			}
			
			
			/*
			if (e.getActionCommand() == "Button1") {
				System.out.println("Button 1 clicked");
			}
			else if (e.getActionCommand() == "Button2") {
				System.out.println("Button 2 clicked");
			}
			else {
				System.out.println("Something else " + e.getActionCommand());
			}
			*/
		}
	}
}
