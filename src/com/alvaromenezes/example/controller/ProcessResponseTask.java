package com.alvaromenezes.example.controller;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import com.alvaromenezes.example.view.CustomDialog;

/**
 * 
 * @author Alvaro Menezes 28/05/2017
 *
 */
public class ProcessResponseTask extends SwingWorker<Void, Void> {

	private String text;
	private CustomDialog dlg;

	public ProcessResponseTask(String text, CustomDialog dlg) {
		this.text = text;
		this.dlg = dlg;
	}

	@Override
	protected Void doInBackground() throws Exception {

		String textStr[] = text.split("\\r\\n|\\n|\\r");
		
		dlg.resetProgress();

		int count = 0;
		for (String line : textStr) {
			dlg.txtTitle.setText(String.format("  Process line %d", ++count));
			
			dlg.update(count, textStr.length);
			System.out.println(line);
			Thread.sleep(100);
		}

		return null;
	}

	@Override
	protected void done() {
		dlg.dispose();
		JOptionPane.showMessageDialog(dlg, "Done!", "Finish", JOptionPane.PLAIN_MESSAGE);
	}

}
