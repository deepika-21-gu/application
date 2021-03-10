import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ComboxBoxTest extends JFrame {

	private JLabel label;
	
	private JComboBox iconComboBox;
	
	private String iconNames[] = { "button1.png", "button2.png", "button3.png", "button4.png" };
	
	private Icon icons[] = {
			new ImageIcon(iconNames[0]),
			new ImageIcon(iconNames[1]),
			new ImageIcon(iconNames[2]),
			new ImageIcon(iconNames[3])
	};
	
	public ComboxBoxTest() {
	
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
	
		ComboxBoxHandler handler = new ComboxBoxHandler();
		
		// Has to be array - list of elements
		iconComboBox = new JComboBox(iconNames);
		iconComboBox.setMaximumRowCount(2);
		iconComboBox.addItemListener(handler);
		
		container.add(iconComboBox);
		
		label = new JLabel();
		label.setIcon(icons[iconComboBox.getSelectedIndex()]);
		container.add(label);
		
		setSize(500, 500);
		setVisible(true);
	}

	public class ComboxBoxHandler implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			
			if (e.getStateChange() == ItemEvent.SELECTED) {
				
				// Get the selected item index
				int index = iconComboBox.getSelectedIndex();
				
				// Get the icon located at that index from icons list (stores list of imageicon)
				Icon icon = icons[index];
				
				// Set the icon for the label.
				label.setIcon(icon);
			}
		}
		
	}
}
