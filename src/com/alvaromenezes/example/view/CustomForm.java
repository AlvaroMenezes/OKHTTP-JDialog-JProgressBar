package com.alvaromenezes.example.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.alvaromenezes.example.controller.CustomFormController;

/**
 * 
 * @author alvaromenezes 27/05/2017
 *
 */
public class CustomForm extends JFrame implements ActionListener {

	private JButton btRun;
	private JTextField txtURL;
	private JLabel url;

	private CustomFormController ctrl;

	public CustomForm() {

		super("TEST OKHTTP - JDIALOG + PROGRESSBAR");
		setLayout(new FlowLayout());

		initFields();
		addFields();

		setSize(450, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ctrl = new CustomFormController(this);
	}

	private void addFields() {

		add(url);
		add(txtURL);
		add(btRun);
	}

	private void initFields() {
		url = new JLabel("URL: ");
		txtURL = new JTextField(30);

		String url = "http://api.wunderground.com/api/57dd9039b81a9c21/conditions/q/CA/San_Francisco.json";
		// txtURL.setText(url);
		txtURL.setText("https://publicobject.com/helloworld.txt");
		btRun = new JButton("  RUN  ");
		btRun.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btRun)) {

			try {
				ctrl.runAction();
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
			}

		}

	}

	public String getURL() {
		return txtURL.getText().trim();
	}

}
