package com.alvaromenezes.example.view;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import com.alvaromenezes.example.connection.ProgressListener;

/**
 * 
 * @author alvaromenezes 27/05/2017
 *
 */
public class CustomDialog extends JDialog implements ProgressListener {
	private static final long serialVersionUID = 1L;

	public JProgressBar progressBar;

	private boolean loadingTitle = false;

	public CustomDialog(JFrame parent) {
		super(parent, "Progress Dialog");

		progressBar = new JProgressBar();
		progressBar.setMaximum(0);
		progressBar.setMaximum(100);
		progressBar.setStringPainted(true);
		progressBar.setString("5%");
		progressBar.setValue(5);

		add(BorderLayout.CENTER, progressBar);
		add(BorderLayout.NORTH, new JLabel("Loading..."));
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setSize(300, 75);
		setLocationRelativeTo(parent);
	}

	public void resetProgress() {
		progressBar.setValue(0);
		// progressBar.setMaximum(100);
		progressBar.setString("0%");
	}

	@Override
	public void update(long bytesRead, long contentLength) {
		int size = (int) ((100 * bytesRead) / contentLength);
		System.out.println(size);
		progressBar.setValue(size);
		progressBar.setString(String.format("%d%%", size));

	}

}
