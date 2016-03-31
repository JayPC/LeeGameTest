package com.snowdrama.leetest;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public class MainGame extends Game {
	public GameState game;
	public GameState game2;
	public GameState game3;
	public GameState game4;
	public GameState game5;
	@Override
	public void create () {
		GameState game = new GameState();
		this.setScreen(game);
	}
	
	public void enterState(Screen state){
		this.setScreen(state);
	}
}
