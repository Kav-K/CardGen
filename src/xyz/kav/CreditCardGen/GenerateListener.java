package xyz.kav.CreditCardGen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class GenerateListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// GRAB JSONOBJECS FROM API HERE <--
		read();
	}

	public static void read() {
		URLConnection con = null;
		URL site = null;
		try {
			site = new URL("http://credit-card-generator.2-ee.com/q_credit-card-generator-cvv2.htm");
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			con = site.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InputStream is = null;
		try {
			is = con.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String line = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		try {
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				if (line.contains("number: ")) {
					String number = line.replaceAll("number: <b>", "");
					number = number.replaceAll("</b><br>", "");
					CardGen.cardnumber.setText(number.trim());
					
					

				} else if (line.contains("cvv: ")) {
             String ccv = line.replaceAll("cvv: <b>", "");
             ccv = ccv.replaceAll("</b><br>", "");
             CardGen.ccv.setText(ccv.trim());
					
					
				} else if (line.contains("exp: ")) {
					String exp = line.replaceAll("exp: <b>", "");
					exp = exp.replaceAll("</b><br>", "");
					CardGen.expiry.setText(exp.trim());
					
					
				}
			}
			return;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
