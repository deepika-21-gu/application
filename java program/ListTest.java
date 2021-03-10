import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListTest extends JFrame {

	private String colorNames[] = {
			"Black",
			"Blue",
			"Yellow",
			"White",
			"Green",
			"Pink",
			"Orange"
	};
	
	private Color colors[] = {
			Color.BLACK,
			Color.BLUE,
			Color.YELLOW,
			Color.WHITE,
			Color.GREEN,
			Color.PINK,
			Color.ORANGE
	};
	
	private JList list;
	private Container container;
	
	public ListTest() {
		
		// Keep reference of container so that we can change background color from other inner class
		container = getContentPane();
		container.setLayout(new FlowLayout());
		container.setBackground(Color.WHITE);
		
		MyListSelectionHandler handler = new MyListSelectionHandler();
		
		list = new JList(colorNames);
		list.setVisibleRowCount(3);
		// Use ListSelectionModel to define selection mode
		// SINGLE_SELECTION - only one
		// SINGLE_INTERVAL_SELECTION - one contiguous range
		// MULTIPLE_INTERVAL_SELECTION - one or more contiguous range
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		// List Selection Listener
		list.addListSelectionListener(handler);
		
		// To show scroll bar and limit number of items to display
		JScrollPane scrollPane = new JScrollPane(list);
		
		// ALways add scroll rather than list directly
		container.add(scrollPane);
		
		setSize(500, 200);
		setVisible(true);
	}
	
	public class MyListSelectionHandler implements ListSelectionListener {

		// ActionListener -> addActionListener -> actionPerformed(ActionEvent e)
		// ItemListener -> addItemListener -> itemStateChanged(ItemEvent e)
		// ListSelectionListener -> addListSelectionListener -> valueChanged(ListSelectionEvent e)

		@Override
		public void valueChanged(ListSelectionEvent e) {
			
			if (e.getSource() == list) {
				
				// Get selected item index.
				int index = list.getSelectedIndex();
				
				// Asks color array to give color located at that index
				Color color = colors[index];
				
				// Set that color as background color to container.
				container.setBackground(color);
			}
		}
	}
}
