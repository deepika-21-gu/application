import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class CheckBoxTest extends JFrame {

	private JTextField tf;
	private JCheckBox boldCheckBox, italicCheckBox;
	
	public CheckBoxTest() {
		
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		
		
		tf = new JTextField("Watch the font style change", 20);
		
		// Create Font
		Font f = new Font("Serif", Font.PLAIN, 14);
		
		// Set the font
		tf.setFont(f);
		
		container.add(tf);
		
		CheckBoxHandler handler = new CheckBoxHandler();
		
		boldCheckBox = new JCheckBox("Bold");
		boldCheckBox.addItemListener(handler);
		container.add(boldCheckBox);
		
		italicCheckBox = new JCheckBox("Italic");
		italicCheckBox.addItemListener(handler);
		container.add(italicCheckBox);
		
		setSize(500, 500);
		setVisible(true);
	}

	public class CheckBoxHandler implements ItemListener {

		private int boldValue = Font.PLAIN;
		private int italicValue = Font.PLAIN;
		
		// ActionListener -> addActionListener -> actionPerformed(ActionEvent e)
		// ItemListener -> addItemListener -> itemStateChanged(ItemEvent e)
		
		@Override
		public void itemStateChanged(ItemEvent e) {
		
			if (e.getSource() == boldCheckBox) {
				
				if (e.getStateChange() == ItemEvent.SELECTED) {
					boldValue = Font.BOLD;
				}
				else {
					boldValue = Font.PLAIN;
				}
			}
			
			if (e.getSource() == italicCheckBox) {
				
				if (e.getStateChange() == ItemEvent.SELECTED) {
					italicValue = Font.ITALIC;
				}
				else {
					italicValue = Font.PLAIN;
				}
			}
			
			Font newFont = new Font("Serif", boldValue + italicValue, 14);
			tf.setFont(newFont);
		}
	}
}
