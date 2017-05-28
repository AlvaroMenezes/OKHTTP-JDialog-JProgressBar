package com.alvaromenezes.example.view;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 * 
 * @author alvaromenezes 27/05/2017
 *
 */
public class CustomDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	public JProgressBar progressBar;

	public CustomDialog(JFrame parent) {
		super(parent, "Progress Dialog");

		progressBar = new JProgressBar();
		progressBar.setMaximum(0);
		progressBar.setMaximum(100);
		progressBar.setStringPainted(true);
		progressBar.setString("0%");
		progressBar.setValue(0);

		add(BorderLayout.CENTER, progressBar);
		add(BorderLayout.NORTH, new JLabel("Progress..."));
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setSize(300, 75);
		setLocationRelativeTo(parent);
	}

}
