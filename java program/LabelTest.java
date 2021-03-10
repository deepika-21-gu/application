import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LabelTest extends JFrame {

	private JLabel label1, label2, label3;

	public LabelTest() {
		
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		// BorderLayout (Default), FlowLayout (Default Direction: Left To Right), GridLayout, CardLayout
		
		// Creation of Label
		label1 = new JLabel("Label 1");
		label1.setToolTipText("Hi this is label1");
		
		// Add label in container
		container.add(label1);
		
		Icon buttonIcon = new ImageIcon("button.png");
		label2 = new JLabel("Label 2", buttonIcon, SwingConstants.LEFT);
		container.add(label2);
		
		label3 = new JLabel();
		label3.setText("Label 3");
		label3.setIcon(buttonIcon);
		label3.setHorizontalTextPosition(SwingConstants.CENTER);
		label3.setVerticalTextPosition(SwingConstants.BOTTOM);
		container.add(label3);
		
		setSize(500, 500);
		setVisible(true);
	}
}