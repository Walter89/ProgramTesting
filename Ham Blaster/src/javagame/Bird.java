package javagame;

import java.util.Random;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Bird {
	Animation bird, movingUp, movingDown, movingLeft, movingRight;
	int[] duration;// duration or length of the frame
	float positionX; // bucky will start at coordinates 0,0
	float positionY;
	int counter =0;
	float speed = .05f;
	int direction=0;
	
	
	Random rand = new Random();

	Bird(int[] duration, float positionX, float positionY)
			throws SlickException {
		this.positionX = positionX;
		this.positionY = positionY;
		this.duration = duration;
		Image[] walkUp = { new Image("res/bird.png"), new Image("res/bird.png") }; // these
																					// are
																					// the
																					// images
																					// to
																					// be
																					// used
																					// in
																					// the
																					// "walkUp"
																					// animation
		Image[] walkDown = { new Image("res/bird.png"),
				new Image("res/bird.png") };
		Image[] walkLeft = { new Image("res/bird.png"),
				new Image("res/bird.png") };
		Image[] walkRight = { new Image("res/bird.png"),
				new Image("res/bird.png") };

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

		bird = movingDown; // by default as soon as game loads, bucky will be
							// facing down
	}

	public void update(int delta) {
		
		if(counter%2500==0){
			direction = rand.nextInt(1);
			
		}
		direction=2;
		counter++;
		switch (direction) {
		
		case 0:
			positionX += delta  * speed;
			bird = movingRight;
			if(positionX>(Play.worldMap.getWidth()-bird.getWidth())){
				 positionX -= delta * speed ;
		         }
			
			break;
			
		case 1:
			positionX -= delta * speed;
			bird = movingLeft;
			if (positionX < 0) {
				positionX += delta * speed;
			}
			 
			break;
			
		case 2:
			positionY += delta * speed;
			bird = movingUp;

			  if(positionY>Play.worldMap.getHeight()-bird.getHeight()){
				  positionY -= delta  * speed; 
		         }
			break;
			
		case 3:
			positionY -= delta * speed ;
			bird = movingDown;

			 if(positionY<0){
				 positionY += delta  * speed;
		         }
			break;
			default: 
		}
		

	}

	public void draw(float buckyPositionX, float buckyPositionY) {
		bird.draw(this.positionX+buckyPositionX,this.positionY+buckyPositionY);
		
	}
}
