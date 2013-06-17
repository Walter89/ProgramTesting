package javagame;

import java.util.Random;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public abstract class MovingObjects {
	protected Animation current, movingUp, movingDown, movingLeft, movingRight;
	protected int[] duration;// duration or length of the frame
	private float positionX; // bucky will start at coordinates 0,0
	private float positionY;
	private int counter = 0;
	private float speed = .05f;
	

	int direction = 0;

	Random rand = new Random();

	MovingObjects(int[] duration, float positionX, float positionY)
			throws SlickException {
		this.positionX = positionX;
		this.positionY = positionY;
		this.duration = duration;



							// facing down
		setImages();
	}
	

	/**
	 * Must give the variables  current, movingUp, movingDown, movingLeft, movingRight values.
	 * @throws SlickException 
	 */
	protected abstract void setImages() throws SlickException;

	public void update(int delta, Play play) {

		if (counter % 1000 == 0) {
			direction = rand.nextInt(4);

		}
		// direction=2;
		counter++;
		switch (direction) {

		case 0:
			positionX += delta * speed;
			current = movingRight;
			if (positionX > (Play.worldMap.getWidth() - current.getWidth())) {
				positionX -= delta * speed;
			}

			break;

		case 1:
			positionX -= delta * speed;
			current = movingLeft;
			if (positionX < 0) {
				positionX += delta * speed;
			}

			break;

		case 2:
			positionY += delta * speed;
			current = movingUp;

			if (positionY > Play.worldMap.getHeight() - current.getHeight()) {
				positionY -= delta * speed;
			}
			break;

		case 3:
			positionY -= delta * speed;
			current = movingDown;

			if (positionY < 0) {
				positionY += delta * speed;
			}
			break;
		default:
		}

	}

	public void draw(float centerX, float centerY) {
		current.draw(this.positionX + centerX, this.positionY + centerY);

	}
	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}


	public float getPositionX() {
		return positionX;
	}


	public float getPositionY() {
		return positionY;
	}
	
}
