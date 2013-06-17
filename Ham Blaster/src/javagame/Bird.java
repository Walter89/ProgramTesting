package javagame;

import java.util.Random;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Bird extends MovingObjects {

	Bird(int[] duration, float positionX, float positionY)
			throws SlickException {
		super(duration, positionX, positionY);
		// TODO Auto-generated constructor stub

	}

	@Override
	protected void setImages() throws SlickException {

		Image[] walkUp = { new Image("res/bird.png"), new Image("res/bird.png") }; // these

		Image[] walkDown = { new Image("res/bird.png"),
				new Image("res/bird.png") };
		Image[] walkLeft = { new Image("res/bird.png"),
				new Image("res/bird.png") };
		Image[] walkRight = { new Image("res/bird.png"),
				new Image("res/bird.png") };

		movingUp = new Animation(walkUp, duration, false); // each animation

		movingDown = new Animation(walkDown, duration, false);
		movingLeft = new Animation(walkLeft, duration, false);
		movingRight = new Animation(walkRight, duration, false);
		movingRight = new Animation(walkRight, duration, false);

		current = movingDown; // by default as soon as game loads, bucky will be

	}

}
