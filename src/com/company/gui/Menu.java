package com.company.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import sound.GameSound;

public class Menu extends JPanel {

	private final GUI mGui;
	private final MyContainer mContainer;
	private JLabel lbPlayGame;
	private JLabel lbOption;
	private JLabel lbHighScore;
	private JLabel lbExit;

	public Menu(MyContainer mContainer) {
		this.mContainer = mContainer;
		this.mGui = mContainer.getGui();
		//setBackground(Color.YELLOW);
		setLayout(null);
		initComps(mGui);
		initbackground();
	}
	
	public void initComps(GUI mGui) {
		lbPlayGame = setLabel((mGui.getWidth() - 150) / 2 - 30, (mGui.getHeight() - 30) / 2 - 150, "/Images/Play.png");
		int padding = 15;
		lbOption = setLabel(lbPlayGame.getX(), lbPlayGame.getY() + lbPlayGame.getHeight() + padding, "/Images/Option.png");
		lbHighScore = setLabel(lbOption.getX(), lbOption.getY() + lbOption.getHeight() + padding, "/Images/HightScore.png");
		lbExit = setLabel(lbHighScore.getX(), lbHighScore.getY() + lbHighScore.getHeight() + padding, "/Images/Exit.png");
		
		lbPlayGame.addMouseListener(mMouseAdapter);
		lbOption.addMouseListener(mMouseAdapter);
		lbHighScore.addMouseListener(mMouseAdapter);
		lbExit.addMouseListener(mMouseAdapter);
		
		add(lbPlayGame);
		add(lbOption);
		add(lbHighScore);
		add(lbExit);
	}
	
	public void initbackground() {
		JLabel lbbackground = new JLabel();
		lbbackground.setBounds(0, -10, mGui.getWidth(), mGui.getHeight());
		lbbackground.setBackground(Color.BLACK);
		ImageIcon backgroundIcon = new ImageIcon(getClass().getResource("/Images/background_Menu.png"));
		lbbackground.setIcon(backgroundIcon);
		add(lbbackground);
	}
	
	public JLabel setLabel(int x, int y, String ImageIcon) {
		JLabel label = new JLabel();
		ImageIcon Icon = new ImageIcon(getClass().getResource(ImageIcon));
		label.setBounds(x, y, Icon.getIconWidth(), Icon.getIconHeight());
		label.setIcon(Icon);
		return label;
	}
	
	private final MouseAdapter mMouseAdapter = new MouseAdapter() {
		@Override
		public void mouseEntered(MouseEvent e) {
			if (e.getSource()==lbPlayGame) {
				ImageIcon playIcon = new ImageIcon(getClass().getResource("/Images/Play2.png"));
				lbPlayGame.setIcon(playIcon);
			}
			if (e.getSource()==lbOption) {
				ImageIcon optionIcon = new ImageIcon(getClass().getResource("/Images/Option2.png"));
				lbOption.setIcon(optionIcon);
			}
			if (e.getSource()==lbHighScore) {
				ImageIcon highScoreIcon = new ImageIcon(getClass().getResource("/Images/HightScore2.png"));
				lbHighScore.setIcon(highScoreIcon);
			}
			if (e.getSource()==lbExit) {
				ImageIcon exitIcon = new ImageIcon(getClass().getResource("/Images/Exit2.png"));
				lbExit.setIcon(exitIcon);
			}
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			if (e.getSource()==lbPlayGame) {
				ImageIcon playIcon = new ImageIcon(getClass().getResource("/Images/Play.png"));
				lbPlayGame.setIcon(playIcon);
			}
			if (e.getSource()==lbOption) {
				ImageIcon optionIcon = new ImageIcon(getClass().getResource("/Images/Option.png"));
				lbOption.setIcon(optionIcon);
			}
			if (e.getSource()==lbHighScore) {
				ImageIcon highScoreIcon = new ImageIcon(getClass().getResource("/Images/HightScore.png"));
				lbHighScore.setIcon(highScoreIcon);
			}
			if (e.getSource()==lbExit) {
				ImageIcon exitIcon = new ImageIcon(getClass().getResource("/Images/Exit.png"));
				lbExit.setIcon(exitIcon);
			}
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			if (e.getSource() == lbPlayGame) {
				mContainer.setShowPlay();
			}
			if (e.getSource() == lbOption) {
				mContainer.setShowOption();
			}
			if (e.getSource() == lbHighScore) {
				mContainer.setShowHighScore();
			}
			if (e.getSource() == lbExit) {
				GameSound.getIstance().getAudio(GameSound.MENU).stop();
				mGui.dispose();
				PlayGame.IS_RUNNING = false;
			}
		}
	};
}	
