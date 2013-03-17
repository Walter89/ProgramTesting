package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState {

	Animation bucky, movingUp, movingDown, movingLeft, movingRight; // 4
																	// animations,
																	// bucky
																	// will be
																	// set to
																	// one
	public static Image worldMap;
	boolean quit = false;
	int[] duration = { 200, 200 }; // duration or length of the frame
	float buckyPositionX = 0; // bucky will start at coordinates 0,0
	float buckyPositionY = 0;
	float shiftX = buckyPositionX + 320; // this will shift the screen so bucky
											// appears in middle
	float shiftY = buckyPositionY + 160; // half the length and half the width
	float centerX = 0;
	float centerY = 0;
	private Bird bird;

	public Play(int state) {
	}

	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		worldMap = new Image("res/world.png");
		System.out.println(worldMap.getHeight());
		System.out.println(worldMap.getWidth());
		Image[] walkUp = { new Image("res/buckysBack.png"),
				new Image("res/buckysBack.png") }; // these are the images to be
													// used in the "walkUp"
													// animation
		Image[] walkDown = { new Image("res/buckysFront.png"),
				new Image("res/buckysFront.png") };
		Image[] walkLeft = { new Image("res/buckysLeft.png"),
				new Image("res/buckysLeft.png") };
		Image[] walkRight = { new Image("res/buckysRight.png"),
				new Image("res/buckysRight.png") };

		movingUp = new Animation(walkUp, duration, false); // each animation
															// takes array of
															// images, duration
															// for each image,
															// and autoUpdate
															// (just set to
															// false)
		movingDown = new Animation(walkDown, duration, false);
		movingLeft = new Animation(walkLeft, duration, false);
		movingRight = new Animation(walkRight, duration, false);
		movingRight = new Animation(walkRight, duration, false);

		bucky = movingDown; // by default as soon as game loads, bucky will be
							// facing down

		bird = new Bird(duration, 100, 100);
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {

		float drawX = centerX;
		float drawY = centerY;
		float drawBuckyY = 0;
		float drawBuckyX = 0;
		
		

		if (buckyPositionY < -440) {
			
			drawBuckyY = shiftY + (-440 - buckyPositionY);
			
		}else if (buckyPositionY > 0) {

			drawBuckyY = shiftY -  buckyPositionY;
		}else{
			centerY = buckyPositionY;
			drawBuckyY = shiftY;
		}
		
		
	if (buckyPositionX > 0) {
		drawBuckyX = shiftX - buckyPositionX;
		
	}else if (buckyPositionX < -560) {
			drawBuckyX = shiftX + (-560 - buckyPositionX);
			
		}else{
			centerX = buckyPositionX;
			drawBuckyX = shiftX;
	}
		worldMap.draw(centerX, centerY);

		bird.draw(centerX, centerY);
		bucky.draw(drawBuckyX, drawBuckyY);
		g.drawString("Buckys X: " + centerX + "\nBuckys Y: " + buckyPositionY,
				400, 20); // indicator to see where bucky is
							// in his world

		// when they press escape
		if (quit == true) {
			g.drawString("Resume (R)", 250, 100);
			g.drawString("Main Menu (M)", 250, 150);
			g.drawString("Quit Game (Q)", 250, 200);
			if (quit == false) {
				g.clear();
			}
		}
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		Input input = gc.getInput();

		// during the game if the user hits the up arrow...
		if (input.isKeyDown(Input.KEY_UP)) {
			bucky = movingUp; // change bucky to up image
			buckyPositionY += delta * .1f; // increase the Y coordinates of
											// bucky (move him up)
			if (buckyPositionY > 162) {
				buckyPositionY -= delta * .1f; // dont let him keep going up if
												// he reaches the top
			}
		}
		if (input.isKeyDown(Input.KEY_DOWN)) {
			bucky = movingDown;
			buckyPositionY -= delta * .1f;
			if (buckyPositionY < -600) {
				buckyPositionY += delta * .1f;
			}
		}
		if (input.isKeyDown(Input.KEY_LEFT)) {
			bucky = movingLeft;
			buckyPositionX += delta * .1f;
			if (buckyPositionX > 324) {
				buckyPositionX -= delta * .1f;
			}
		}
		if (input.isKeyDown(Input.KEY_RIGHT)) {
			bucky = movingRight;
			buckyPositionX -= delta * .1f;
			if (buckyPositionX < -840) {
				buckyPositionX += delta * .1f;
			}
		}

		// escape
		if (input.isKeyDown(Input.KEY_ESCAPE)) {
			quit = true;
		}

		// when they hit escape
		if (quit == true) {
			if (input.isKeyDown(Input.KEY_R)) {
				quit = false;
			}
			if (input.isKeyDown(Input.KEY_M)) {
				sbg.enterState(0);
				try {
					Thread.sleep(250);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if (input.isKeyDown(Input.KEY_Q)) {
				System.exit(0);
			}
		}
		bird.update(delta);
	}

	public int getID() {
		return 1;
	}
}