package com.alvaromenezes.example;

import com.alvaromenezes.example.view.CustomForm;

/**
 * 
 * @author alvaromenezes 27/05/2017
 *
 */
public class Main {

	String url = "http://api.wunderground.com/api/57dd9039b81a9c21/conditions/q/CA/San_Francisco.json";

	public static void main(String[] args) {
		CustomForm form = new CustomForm();
		form.setVisible(true);

	}

}
