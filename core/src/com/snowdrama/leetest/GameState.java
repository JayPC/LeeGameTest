package com.snowdrama.leetest;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.snowdrama.leetest.entitys.Player;
import com.sun.javafx.font.directwrite.RECT;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class GameState implements Screen, InputProcessor{
	private SpriteBatch batch;
	private ShapeRenderer shapeRend;
    private boolean up,down,left,right,aButton,bButton;
	private int playerVert;
	private int playerHor;

    private Player p1;
	
	private Texture debugGrid;
	private Texture testCharacter;
	private Texture testMap;
    private OrthographicCamera camera;
	private Rectangle[] collision;

	public GameState(MainGame game){
		batch = new SpriteBatch();
		shapeRend = new ShapeRenderer();
		debugGrid = new Texture("sprites/64x64_frame.png");
		testCharacter = new Texture("sprites/PokemonPlayer.png");
		testMap = new Texture("maps/pallet_town.png");
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 64, 64);
        Gdx.input.setInputProcessor(this);
        p1 = new Player(10,10);
        collision = new Rectangle[10];
        collision[0] = new Rectangle(0,0,16,16);
        collision[1] = new Rectangle(16,0,16,16);
        collision[2] = new Rectangle(16*2,0,16,16);
        collision[3] = new Rectangle(16*3,0,16,16);
        collision[4] = new Rectangle(16*4,0,16,16);
        collision[5] = new Rectangle(16*5,0,16,16);
        collision[6] = new Rectangle(16*6,0,16,16);
        collision[7] = new Rectangle(16*7,0,16,16);
        collision[8] = new Rectangle(16*8,0,16,16);
        collision[9] = new Rectangle(16*9,0,16,16);
	}
	@Override
	public void show() {
		//What to do on show of the state
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.1f, 0.2f, 0.5f, 1 );
		Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );

        update(Gdx.graphics.getDeltaTime());
		//What to do each frame
        camera.translate((int)p1.x-(int)camera.position.x, (int)p1.y-(int)camera.position.y, 0);
        camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(testMap, 0, 0);
		batch.draw(debugGrid, 0, 0);
		batch.draw(testCharacter, (int)p1.x, (int)p1.y);
		batch.end();
		
		
		//Testing Bounds and such
		shapeRend.translate((int)p1.x-(int)camera.position.x, (int)p1.y-(int)camera.position.y, 0);
		shapeRend.setProjectionMatrix(camera.combined);
		shapeRend.begin(ShapeType.Filled);
		
		for(Rectangle r : collision){

			if(r.overlaps(p1.rect)){
				shapeRend.setColor(new Color(1f,0f,0f, 1));
				shapeRend.rect(r.x,r.y,r.width,r.height);
			}else{
				shapeRend.setColor(new Color(1f,1f,0f, 1));
				shapeRend.rect(r.x,r.y,r.width,r.height);
			}
		}
		shapeRend.end();
		shapeRend.begin(ShapeType.Line);
		
		shapeRend.setColor(new Color(0f,0f,1f, 1));
		shapeRend.rect(p1.x,p1.y,p1.rect.width,p1.rect.height);
		shapeRend.end();
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
	
	public void update(float deltaTime){
		if(up == true) {
			System.out.println("UP");
			playerVert = 1;
		}else if(down == true){
			System.out.println("DOWN");
			playerVert = -1;
		}else{
			playerVert = 0;
		}
		if(left == true){
			System.out.println("LEFT");
			playerHor = -1;
		}else if(right == true){
			System.out.println("RIGHT");
			playerHor = 1;
		}else{
			playerHor = 0;
		}
		
		
		p1.move(playerHor, playerVert);
	}
	
	@Override
	public boolean keyDown(int keycode) {
		if(Input.Keys.UP == keycode){
			up = true;
		}
		if(Input.Keys.DOWN == keycode){
			down = true;
		}
		if(Input.Keys.LEFT == keycode){
			left = true;
		}
		if(Input.Keys.RIGHT == keycode){
			right = true;
		}
		if(Input.Keys.Z == keycode){
			aButton = true;
		}
		if(Input.Keys.X == keycode){
			bButton = true;
		}
		return false;
	}
	@Override
	public boolean keyUp(int keycode) {	
		if(Input.Keys.UP == keycode){
			up = false;
		}
		if(Input.Keys.DOWN == keycode){
			down = false;
		}
		if(Input.Keys.LEFT == keycode){
			left = false;
		}
		if(Input.Keys.RIGHT == keycode){
			right = false;
		}		
		if(Input.Keys.Z == keycode){
			aButton = false;
		}
		if(Input.Keys.X == keycode){
			bButton = false;
		}
		return false;
	}
	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
