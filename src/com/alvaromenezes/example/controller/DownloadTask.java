package com.alvaromenezes.example.controller;

import javax.swing.SwingWorker;

import com.alvaromenezes.example.connection.HttpClient;
import com.alvaromenezes.example.view.CustomDialog;

/**
 * 
 * @author Alvaro Menezes 28/05/2017
 *
 */
public class DownloadTask extends SwingWorker<String, Object> {

	private String url;
	private CustomDialog dlg;

	public DownloadTask(String url, CustomDialog dlg) {
		this.url = url;
		this.dlg = dlg;
	}

	@Override
	protected String doInBackground() throws Exception {
		HttpClient client = new HttpClient(url, dlg);
		return client.run();
	}

	@Override
	protected void done() {

		try {
			Thread.sleep(300);
			new ProcessResponseTask(get(), dlg).execute();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
