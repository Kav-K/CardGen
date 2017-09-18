package xyz.kav.CreditCardGen;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CardGen {
	public static JFrame frame;
	public static Container pane;
	public static JTextField cardnumber,ccv,expiry;

	public static void main(String[] args) {
		draw();

	}

	private static void draw() {
		frame = new JFrame("CardGen");
		frame.setSize(250, 250);
		frame.setLocationRelativeTo(null);
		pane = frame.getContentPane();
		pane.setLayout(null);

		// TODO add components

		JButton generate = new JButton("Generate");
		generate.setBounds(0, 200, generate.getPreferredSize().width, generate.getPreferredSize().height);
		generate.setSize(250, 50);
		// COMP ADD
		pane.add(generate);

		cardnumber = new JTextField(15);
		cardnumber.setBounds(40, 167, cardnumber.getPreferredSize().width, cardnumber.getPreferredSize().height);
		pane.add(cardnumber);

		ccv = new JTextField(4);
		ccv.setBounds(95, 135, ccv.getPreferredSize().width, ccv.getPreferredSize().height);
		pane.add(ccv);

		 expiry = new JTextField(6);
		expiry.setBounds(83, 102, expiry.getPreferredSize().width, expiry.getPreferredSize().height);
		pane.add(expiry);

		JLabel cardnumberlabel = new JLabel("Card Number");
		cardnumberlabel.setBounds(73, 153, cardnumberlabel.getPreferredSize().width,
				cardnumberlabel.getPreferredSize().height);
		pane.add(cardnumberlabel);

		JLabel ccvlabel = new JLabel("CCV");
		ccvlabel.setBounds(103,122,ccvlabel.getPreferredSize().width,ccvlabel.getPreferredSize().height);
		pane.add(ccvlabel);
		
		JLabel expirylabel = new JLabel("Expiry");
		expirylabel.setBounds(95,88,expirylabel.getPreferredSize().width,expirylabel.getPreferredSize().height);
		pane.add(expirylabel);
		
		JLabel title = new JLabel("Card Gen");
		Font font = new Font(title.getFont().getName(), Font.BOLD, 40);
		title.setFont(font);
		
		
		
		title.setBounds(20,20,title.getPreferredSize().width,title.getPreferredSize().height);
		pane.add(title);
		
		
		generate.addActionListener(new GenerateListener());
		
		
		
		frame.setContentPane(pane);
        frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		repaint();
	}

	private static void repaint() {
		// TODO
		pane.repaint();
		frame.repaint();
	}

}
