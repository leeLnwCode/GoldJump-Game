package application;

import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import java.awt.*;
import javafx.geometry.Bounds;
import javafx.scene.image.ImageView;

public class Animetion {
	private int CF = 0;
	
	private ImageView Sprite;
	private AssetType animation;
	private Assets sheets = new Assets();
	private boolean IsGravity;
	
	public Animetion(AssetType SpriteSheet,boolean gravity) {
		this.IsGravity = gravity;
		this.animation = SpriteSheet;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = 1200;
        double screenHeight = 700;
		this.Sprite = new ImageView(animation.getImage());
		
		new AnimationTimer() {
			double timeElapsed = 0.0;
			double delayTime = 0.15;
			double playerY = Sprite.getY();
			double playerVelocityY = 10;
			double GROUND_LEVEL = screenHeight - 120;
			@Override
			public void handle(long now) {
				double deltaTime = 1.0 / 60.0;
				
				if (IsGravity) {
					playerY += playerVelocityY;
				}

				if (playerY >= GROUND_LEVEL) {
					playerY = GROUND_LEVEL;
					playerVelocityY = 0;
				}
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
	public ImageView Start() {
		return this.Sprite;
	}
	// Get Asset
	public AssetType getAsset() {
		return this.animation;
	}

	
	
	// GETTERS
	public double getFitWidth() {
		return this.Sprite.getFitWidth();
	}
	public double getFitHeight() {
		return this.getFitHeight();
	}
	
	// Hit Box
	public boolean HitBox(ImageView player) {
		if (player.getBoundsInParent().intersects(this.Sprite.getBoundsInLocal())) {
			return true;
		}
		return false;
	}
	
}
