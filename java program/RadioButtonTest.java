import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import CheckBoxTest.CheckBoxHandler;

public class RadioButtonTest extends JFrame {

	private JTextField tf;
	private Font plainF, boldF, italicF, boldItalicF;
	private JRadioButton plainRB, boldRB, italicRB, boldItalicRB;
	
	public RadioButtonTest() {

		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		
		tf = new JTextField("Watch the font style change", 20);
		container.add(tf);
		
		plainF = new Font("Serif", Font.PLAIN, 14);
		boldF = new Font("Serif", Font.BOLD, 14);
		italicF = new Font("Serif", Font.ITALIC, 14); 
		boldItalicF = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
		
		RadionButtonHandler handler = new RadionButtonHandler();
		
		plainRB = new JRadioButton("Plain", true);
		plainRB.addItemListener(handler);
		container.add(plainRB);
		
		boldRB = new JRadioButton("Bold");
		boldRB.addItemListener(handler);
		container.add(boldRB);
		
		italicRB = new JRadioButton("Italic");
		italicRB.addItemListener(handler);
		container.add(italicRB);
		
		boldItalicRB = new JRadioButton("Bold Italic");
		boldItalicRB.addItemListener(handler);
		container.add(boldItalicRB);
		
		// This is definately required so that only one can be selected out of many
		// on selecting one other would be automatically de-selected.
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(plainRB);
		buttonGroup.add(boldRB);
		buttonGroup.add(italicRB);
		buttonGroup.add(boldItalicRB);

		setSize(500, 500);
		setVisible(true);
	}
	
	public class RadionButtonHandler implements ItemListener {
		
		private Font fontToUse;
		
		@Override
		public void itemStateChanged(ItemEvent e) {
		
			if (e.getSource() == plainRB) {
				fontToUse = plainF;
			}
			else if (e.getSource() == boldRB) {
				fontToUse = boldF;
			}
			else if (e.getSource() == italicRB) {
				fontToUse = italicF;
			}
			else if (e.getSource() == boldItalicRB) {
				fontToUse = boldItalicF;
			}
			tf.setFont(fontToUse);
		}
	}
}
