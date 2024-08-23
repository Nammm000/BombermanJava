package com.company.gui;

import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import sound.GameSound;

public class GUI extends JFrame {

	public static final int WIDTHJF = 905;
	public static final int HEIGHTJF = 620;

	ImageIcon img = new ImageIcon(getClass().getResource("/Images/heart_1.png"));

	public GUI() {
		setTitle("Bomberman");
		setIconImage(img.getImage());
		setSize(WIDTHJF, HEIGHTJF);
		setLayout(new CardLayout());
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		MyContainer mContainer = new MyContainer(this);
		add(mContainer);
		/*WindowAdapter mwindow = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				GameSound.getIstance().stop();
				PlayGame.IS_RUNNING = false;
			}
		};
		addWindowListener(mwindow);*/
	}

	public static void main(String[] args) {
		new GUI().setVisible(true);
	}
}
