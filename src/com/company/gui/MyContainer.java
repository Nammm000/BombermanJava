package com.company.gui;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

import sound.GameSound;

public class MyContainer extends JPanel {

	private static final String TAG_MENU = "tag_menu";
	private static final String TAG_PLAY_GAME = "tag_play_game";
	private static final String TAG_OPTION = "tag_option";
	private static final String TAG_HIGH_SCORE = "tag_high_score";
	private final CardLayout mCardLayout;
	private final GUI gui;
	private final Menu mMenu;
	private final PlayGame mPlayGame;
	private final Option mOption;
	private final HighScorePanel mHighScorePanel;
	
	public MyContainer(GUI mGui) {
		this.gui = mGui;
		//setBackground(Color.BLUE);
		mCardLayout = new CardLayout();
		setLayout(mCardLayout);
		mMenu = new Menu(this);
		add(mMenu,TAG_MENU);
		mPlayGame = new PlayGame(this);
		add(mPlayGame, TAG_PLAY_GAME);
		mOption = new Option(this);
		add(mOption, TAG_OPTION);
		mHighScorePanel = new HighScorePanel(this);
		add(mHighScorePanel, TAG_HIGH_SCORE);
		
		setShowMenu();
	}

	public GUI getGui() {
		return gui;
	}

	public void setShowMenu() {
		mCardLayout.show(MyContainer.this, TAG_MENU);
		mMenu.requestFocus();
		GameSound.getIstance().stop();
		GameSound.getIstance().getAudio(GameSound.MENU).loop();
	}

	public void setShowPlay() {
		mCardLayout.show(MyContainer.this, TAG_PLAY_GAME);
		mPlayGame.requestFocus();
		GameSound.getIstance().getAudio(GameSound.MENU).stop();
		GameSound.getIstance().getAudio(GameSound.PLAYGAME).loop();
	}
	
	public void setShowOption() {
		mCardLayout.show(MyContainer.this, TAG_OPTION);
		mOption.requestFocus();
	}
	
	public void setShowHighScore() {
		mCardLayout.show(MyContainer.this, TAG_HIGH_SCORE);
		mHighScorePanel.requestFocus();
	}
}
