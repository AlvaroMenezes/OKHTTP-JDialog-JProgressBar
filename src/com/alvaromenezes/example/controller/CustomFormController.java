package com.alvaromenezes.example.controller;

import javax.swing.SwingWorker;

import com.alvaromenezes.example.connection.Connection;
import com.alvaromenezes.example.view.CustomDialog;
import com.alvaromenezes.example.view.CustomForm;

/**
 * 
 * @author alvaromenezes 27/05/2017
 *
 */
public class CustomFormController {

	private CustomForm view;
	private CustomDialog dlg;

	public CustomFormController(CustomForm view) {
		this.view = view;
	}

	public void runAction() {

		dlg = new CustomDialog(view);
		dlg.setVisible(true);
		new Task(view.getURL(), dlg).execute();
	}

	private void testProgress() throws Exception {

		for (int i = 0; i <= 100; i = i + 10) {

			dlg.progressBar.setValue(i);
			dlg.progressBar.setString(String.format("%d%%", i));
			Thread.sleep(200);

		}

	}

	private class Task extends SwingWorker<String, Object> {

		private String url;
		private CustomDialog dlg;

		public Task(String url, CustomDialog dlg) {
			this.url = url;
			this.dlg = dlg;
		}

		@Override
		protected String doInBackground() throws Exception {
			Connection conn = new Connection(view.getURL(), dlg);
			return conn.run();
		}

		@Override
		protected void done() {
			dlg.dispose();
			// dlg.resetProgress();
			try {
				new TaskPrintSlow(get()).execute();
			} catch (Exception e) {
			}

		}
	}

	private class TaskPrintSlow extends SwingWorker {

		private String text;
		private CustomDialog dlg;

		public TaskPrintSlow(String text) {
			this.text = text;
		}

		@Override
		protected Void doInBackground() throws Exception {

			String textStr[] = text.split("\\r\\n|\\n|\\r");

			for (String line : textStr) {
				System.out.println(line);
				Thread.sleep(200);
			}

			return null;
		}
	}

}
