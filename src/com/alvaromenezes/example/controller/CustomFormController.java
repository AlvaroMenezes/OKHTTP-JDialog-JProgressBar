package com.alvaromenezes.example.controller;

import com.alvaromenezes.example.view.CustomDialog;
import com.alvaromenezes.example.view.CustomForm;

/**
 * 
 * @author Alvaro Menezes 27/05/2017
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
		new DownloadTask(view.getURL(), dlg).execute();
	}

	@SuppressWarnings("unused")
	private void testProgress() throws Exception {

		for (int i = 0; i <= 100; i = i + 10) {
			dlg.progressBar.setValue(i);
			dlg.progressBar.setString(String.format("%d%%", i));
			Thread.sleep(200);
		}
	}
}