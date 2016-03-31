package com.snowdrama.leetest;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class GameState implements Screen{
	private SpriteBatch batch;
	private Texture img;
    private OrthographicCamera camera;


	public GameState(){
		batch = new SpriteBatch();
		img = new Texture("sprites/64x64_frame.png");
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 64, 64);
        
	}
	@Override
	public void show() {
		//What to do on show of the state
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.1f, 0.2f, 0.5f, 1 );
		Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
		//What to do each frame
		camera.translate(32, 32);
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
		
	}

	@Override
	public void resize(int width, int height) {
		//What to do on resize
		
	}

	@Override
	public void pause() {
		//What to do when inactive window
		
	}

	@Override
	public void resume() {
		//What to do on focus after pause
		
	}

	@Override
	public void hide() {
		//What to do when minimized
		
	}

	@Override
	public void dispose() {
		//What to do when the scene ends
		
	}
	
	public void update(){
		//Poll input
		
	}

}
