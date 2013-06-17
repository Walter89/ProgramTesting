package javagame;

import org.newdawn.slick.Image;

public  class FixedObject {

	private float positionX;
	private float positionY;
	private Image img;
	private int heigth;
	private int width;

	public FixedObject(float positionX, float positionY, Image img) {
		this.img = img;
		this.heigth = img.getHeight();
		this.width = img.getWidth();

		this.positionX = positionX;
		this.positionY = positionY;

	}

	public void draw(float centerX, float centerY) {
		
		img.draw(this.positionX + centerX, this.positionY+ centerY);
	}

	public float getPositionX() {
		return positionX;
	}

	public float getPositionY() {
		return positionY;
	}

	public Image getImg() {
		return img;
	}

	public int getHeigth() {
		return heigth;
	}

	public int getWidth() {
		return width;
	}
}