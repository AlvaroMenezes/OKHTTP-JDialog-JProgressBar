package com.alvaromenezes.example.controller;

import com.alvaromenezes.example.connection.Connection;
import com.alvaromenezes.example.connection.ProgressListener;
import com.alvaromenezes.example.view.CustomDialog;
import com.alvaromenezes.example.view.CustomForm;

/**
 * 
 * @author alvaromenezes 27/05/2017
 *
 */
public class CustomFormController implements ProgressListener {

	private CustomForm view;
	private CustomDialog dlg;

	public CustomFormController(CustomForm view) {
		this.view = view;
	}

	public void runAction() throws Exception {

		dlg = new CustomDialog(view);
		dlg.setVisible(true);
	//	Connection conn = new Connection(view.getURL(), this);
		//conn.run();

	}

	@Override
	public void update(long bytesRead, long contentLength, boolean done) {

		int size = (int) ((100 * bytesRead) / contentLength);
		System.out.println(size);
		dlg.progressBar.setValue(size);
		dlg.progressBar.setString(String.format("%d%%", size));

		if (done) {

			dlg.setVisible(false);
			dlg.dispose();
		}

	}

	/*
	 * final ProgressListener progressListener = new ProgressListener() {
	 * 
	 * @Override public void update(long bytesRead, long contentLength, boolean
	 * done) { System.out.println(bytesRead); System.out.println(contentLength);
	 * System.out.println(done); System.out.format("%d%% done\n", (100 *
	 * bytesRead) / contentLength); } };
	 */

}
