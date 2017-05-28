package com.alvaromenezes.example.view;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import com.alvaromenezes.example.controller.ProgressListener;

/**
 * 
 * @author Alvaro Menezes 27/05/2017
 *
 */
public class CustomDialog extends JDialog implements ProgressListener {
	private static final long serialVersionUID = 1L;

	public JProgressBar progressBar;
	public JLabel txtTitle;

	private boolean loadingTitle = false;

	public CustomDialog(JFrame parent) {
		super(parent, "Progress Dialog");

		progressBar = new JProgressBar();
		progressBar.setMaximum(0);
		progressBar.setMaximum(100);
		progressBar.setStringPainted(true);
		progressBar.setString("0%");
		progressBar.setValue(0);

		txtTitle = new JLabel("  Loading...");

		add(BorderLayout.CENTER, progressBar);
		add(BorderLayout.NORTH, txtTitle);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setSize(300, 75);
		setLocationRelativeTo(parent);
	}

	public void resetProgress() {
		progressBar.setValue(0);
		progressBar.setString("0%");
	}

	@Override
	public void update(long bytesRead, long contentLength) {
		int size = (int) ((100 * bytesRead) / contentLength);
		progressBar.setValue(size);
		progressBar.setString(String.format("%d%%", size));

	}

}
