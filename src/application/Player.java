package application;

import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import java.awt.*;
import javafx.geometry.Bounds;

public class Player {
	private int CF = 0;
	private static final double GRAVITY = 1.0;
	private static final double WALK_SPEED = 5.0;
	
	private double playerVelocityY = 0.0;
	private double playerX = 50;
	private double playerY = 100;
	private boolean isOnGround = true;
	private double GROUND_LEVEL = 0;
	
	private boolean movingLeft = false;
	private boolean movingRight = false;
	
	private ImageView Sprite;
	private AssetType animation;
	
	public Player(AssetType SpriteSheet) {
		this.animation = SpriteSheet;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        double screenHeight = screenSize.height;
        this.GROUND_LEVEL = screenHeight - SpriteSheet.getWidth() - 20;
		this.Sprite = new ImageView(animation.getImage());
		
		new AnimationTimer() {
			double timeElapsed = 0.0;
			double delayTime = 0.15;
			
			@Override
			public void handle(long now) {
				double deltaTime = 1.0 / 60.0;
				
				if (!isOnGround) {
					playerVelocityY += GRAVITY;
				}
				playerY += playerVelocityY;
				

				if (playerY >= GROUND_LEVEL) {
					playerY = GROUND_LEVEL;
					playerVelocityY = 0;
					isOnGround = true;
				} else {
					isOnGround = false;
				}
				
				if (movingLeft) {
					playerX -= WALK_SPEED;
					Sprite.setScaleX(-1);
				}
				if (movingRight) {
					playerX += WALK_SPEED;
					Sprite.setScaleX(1);
				}
				
				if (playerX < 0) playerX = 0;
				if (playerX > screenWidth - Sprite.getFitWidth()) playerX = screenWidth - Sprite.getFitWidth();
				
				Sprite.setX(playerX);
				Sprite.setY(playerY);
				
				timeElapsed += deltaTime;
				if (timeElapsed >= delayTime) {
					timeElapsed = 0.0;
					CF = (CF + 1) % animation.getFrames();
					Sprite.setViewport(new Rectangle2D(
						CF * (Sprite.getImage().getWidth() / animation.getFrames()), 
						0, 
						Sprite.getImage().getWidth() / animation.getFrames(), 
						Sprite.getImage().getHeight()
					));
				}
			}
		}.start();
	}
	// Hit box
	public Bounds getBoundsInParent() {
		return this.Sprite.getBoundsInParent();
	}
	
	// SETTERS
	public void setFitWidth(double w) {
		this.Sprite.setFitWidth(w);
	}
	public void setFitHeight(double h) {
		this.Sprite.setFitHeight(h);
	}
	public void setImage(Image img) {
		this.Sprite.setImage(img);
	}
	
	// Show up
	public ImageView Node() {
		return this.Sprite;
	}

	
	
	// GETTERS
	public double getFitWidth() {
		return this.Sprite.getFitWidth();
	}
	public double getFitHeight() {
		return this.getFitHeight();
	}
	
}
