package application;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Iterator;

import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;

public class World {
	private int CF = 0;
	private static double GRAVITY = 1.0;
	private static final double JUMP_STRENGTH = -15.0;
	private static double WALK_SPEED = 5.0;

	private double playerVelocityY = 0.0;
	private double playerX = 100;
	private double playerY = 200;
	private boolean isOnGround = true;
	private double GROUND_LEVEL = 400;

	private boolean movingLeft = false;
	private boolean movingRight = false;
	
	// animation
	public AssetType idle;
	public ArrayList<ImageView> grounds = new ArrayList<ImageView>();
	public ArrayList<ImageView> groundUp = new ArrayList<ImageView>();
	public ArrayList<Animetion> coins = new ArrayList<Animetion>();
	public ArrayList<ImageView> skyGrounds = new ArrayList<>();
	
	private int coinScore = 0;
	private Label CoinCounter;
	private Pane root;
	private boolean isJump = false;
	private ImageView key;
	private String backgroundIMG = "background.png";
	private Scene app;
	private String idleSet = "";
	private String runSet = "";
	
	public World(String level , String chars) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = 1200;
		double screenHeight = (double) 700;
		/*ImageView UserFrame = new ImageView(new Image(getClass().getResource("/object/other/Lovepik_com-380332881-brown-pixel-art-text-box-dialog-black-frame.png").toExternalForm()));
        UserFrame.setFitWidth(400);  // กำหนดความกว้างของปุ่ม
        UserFrame.setFitHeight(600);  // กำหนดความสูงของปุ่ม
        UserFrame.setLayoutX((screenWidth / 2) - 230);
        UserFrame.setLayoutY((screenHeight / 2) - 300);*/
        
        
        Text Home = new Text("HOME");
        Font customFont1 = Font.loadFont(getClass().getResource("/fonts/PressStart2P.ttf").toExternalForm(), 35);  // เปลี่ยน path ให้เป็นฟอนต์ที่คุณต้องการ
        Home.setFont(customFont1);  // กำหนดฟอนต์ที่ใช้กับข้อความ
        Home.setFill(Color.WHITE);  // กำหนดสีของข้อความเป็นสีขาว
        
		
		ComboBox<String> comboBox = new ComboBox<>();
		comboBox.getItems().addAll("Love oop class", "I don't love oop class", "Just chill");
		comboBox.setStyle("-fx-font-family: 'Press Start 2P'; -fx-font-size: 20px;");
		comboBox.setValue("Love oop class");
		comboBox.setLayoutX((screenWidth / 2) - 150);
		comboBox.setLayoutY((screenHeight / 2) - 30);
		comboBox.setPrefHeight(50);
		comboBox.setPrefWidth(300);
		
		Text success = new Text("You Win !!");
	     Font customFont33 = Font.loadFont(getClass().getResource("/fonts/PressStart2P.ttf").toExternalForm(), 60);  // เปลี่ยน path ให้เป็นฟอนต์ที่คุณต้องการ
	     success.setFont(customFont33);  // กำหนดฟอนต์ที่ใช้กับข้อความ
	     success.setX((screenWidth / 2) - 10);
	     success.setY(screenHeight / 2);
	     success.setFill(Color.WHITE);
	    
		
	     ImageView FrameTaxt = new ImageView(new Image(getClass().getResource("/object/other/Lovepik_com-380332886-gray-green-pixel-art-text-box-dialog-frame-greyish-green.png").toExternalForm()));  // เปลี่ยน path ให้เป็นภาพปุ่ม Start
        FrameTaxt.setFitWidth(800);  // กำหนดความกว้างของปุ่ม
        FrameTaxt.setFitHeight(600);  // กำหนดความสูงของปุ่ม
        
        FrameTaxt.setX(900);
        FrameTaxt.setY(screenHeight - 150);
	     
		 Button DoneButton = new Button("Done");
	     Font customFont3 = Font.loadFont(getClass().getResource("/fonts/PressStart2P.ttf").toExternalForm(), 25);  // เปลี่ยน path ให้เป็นฟอนต์ที่คุณต้องการ
	     DoneButton.setFont(customFont3);  // กำหนดฟอนต์ที่ใช้กับข้อความ
	    

//         Set an event handler for the button
	     DoneButton.setOnAction(e-> {
	    	 if (comboBox.getValue() == "Love oop class") {
	    		 System.exit(0);
	    	 }
        });
		
		this.CoinCounter = new Label(Integer.toString(coinScore));
		CoinCounter.setId("counter");
		CoinCounter.setFont(new Font("Arial", 30));
		CoinCounter.setTextFill(Color.BLACK);
		CoinCounter.setLayoutX(80);
		CoinCounter.setLayoutY(28);
		Assets assets = new Assets();
		int W = 100;
		int H = 100;
		if (chars == "PinkGirl") {
			W = 100;
			H = 100;
			this.idleSet = "Pink_Monster_Idle_4.png";
			this.runSet = "Pink_Monster_Run_6.png";
			idle = assets.GetCharsByName("Pink_Monster_Idle_4.png");
		}
		if (chars == "Shibuya") {
			W = 200;
			H = 200;
			this.idleSet = "Idle.png";
			this.runSet = "Run.png";
			idle = assets.GetCharsByName("Idle.png");
		}
		
		for (int i = 0; i < 10; i++) {
			Animetion coin = new Animetion(assets.GetObjectByName("coin.png"),true);
			coin.Start().setX(Math.random() * screenWidth);
			coin.Start().setY(Math.random() * 400);
			coin.Start().setFitHeight(30);
			coin.Start().setFitWidth(30);
			coins.add(coin);
		}
		
		Animetion portal = new Animetion(assets.GetObjectByName("portal.png"),false);
		portal.setFitHeight(100);
		portal.setFitWidth(100);
		portal.Start().setX(screenWidth - 100);
		
		
		
		int skyGroundY = 250;
		double overlapFactor = 0.7; // Adjust this value for more or less overlap

		for (int i = 0; i < 10; i++) {
		    ImageView skyGround = new ImageView(assets.GetObjectByName("1.png").getImage());
		    skyGround.setY(skyGroundY);
		    skyGround.setFitHeight(50);
		    skyGround.setFitWidth(50);
		    skyGround.setX((skyGround.getFitWidth() * i) * overlapFactor); // Reduce spacing
		    skyGrounds.add(skyGround);
		}
		
		this.key = new ImageView(assets.GetObjectByName("key.png").getImage());
		key.setFitHeight(100);
		key.setFitWidth(100);
		key.setX(500);
		key.setY(100);
		
		ImageView brush = new ImageView(assets.GetObjectByName("Bush (1).png").getImage());
		brush.setFitHeight(brush.getImage().getHeight());
		brush.setFitWidth(brush.getImage().getWidth());
		brush.setX(500);
		brush.setY(screenHeight - 150);
		
		ImageView brush2 = new ImageView(assets.GetObjectByName("Bush (2).png").getImage());
		brush2.setFitHeight(brush2.getImage().getHeight());
		brush2.setFitWidth(brush2.getImage().getWidth());
		brush2.setX(900);
		brush2.setY(screenHeight - 150);
		
		ImageView brush3 = new ImageView(assets.GetObjectByName("Bush (3).png").getImage());
		brush3.setFitHeight(brush3.getImage().getHeight() * 1.4);
		brush3.setFitWidth(brush3.getImage().getWidth() * 1.4);
		brush3.setX(50);
		brush3.setY(screenHeight - 150);
		
		
		ImageView coinView = new ImageView(assets.GetObjectByName("coin.png").getImage());
		coinView.setViewport(new Rectangle2D(0, 0, 20, 20));
		coinView.setFitHeight(50);
		coinView.setFitWidth(50);
		coinView.setX(20);
		coinView.setY(20);

		
		if (level == "Eazy") {
			this.backgroundIMG = "background.png";
			System.out.println(true);
		}else if (level == "Hard") {
			this.backgroundIMG = "background2.png";
			System.out.println(false);
		}
		ImageView bg = new ImageView(assets.GetBackgroundByName(this.backgroundIMG).getImage());
		bg.setFitHeight(screenHeight);
		bg.setFitWidth(screenWidth);
		Player player = new Player(assets.GetCharsByName("Pink_Monster_Idle_4.png"));
		player.setFitHeight(100);
		player.setFitWidth(100);

		ImageView playerSprite = new ImageView(idle.getImage());
		playerSprite.setPreserveRatio(true);
		playerSprite.setX(playerX);
		playerSprite.setY(playerY);

		playerSprite.setFitWidth(W);
		playerSprite.setFitHeight(H);
		playerSprite.setId("data");
		playerSprite.setViewport(
				new Rectangle2D(0, 0, playerSprite.getImage().getWidth() / idle.getFrames(), idle.getHeight()));

		this.GROUND_LEVEL = screenHeight - playerSprite.getFitHeight() - 100;

		Rectangle border = new Rectangle(playerSprite.getX(), playerSprite.getY(), playerSprite.getFitWidth(),
				playerSprite.getFitHeight());
		border.setStroke(Color.RED);
		border.setFill(Color.TRANSPARENT);
		border.setStrokeWidth(2);

		int place_next = -100;
		for (int i = 0; i < 20; i++) {
			ImageView object = new ImageView(assets.GetObjectByName("1.png").getImage());
			object.setX(place_next);
			object.setY(screenHeight - 100);
			grounds.add(object);
			place_next += 120;
		}

		this.root = new Pane();
		root.getChildren().add(bg);
		root.getChildren().add(playerSprite);
		skyGrounds.forEach(e -> root.getChildren().add(e));
		grounds.forEach(e -> {
			root.getChildren().add(e);
		});
		coins.forEach(e -> {
			root.getChildren().add(e.Start());
		});
		root.getChildren().add(coinView);
		root.getChildren().add(CoinCounter);
//		root.getChildren().add(portal.Start());
		root.getChildren().add(Home);
		root.getChildren().add(brush);
		root.getChildren().add(brush2);
		root.getChildren().add(brush3);
		this.app = new Scene(root, screenWidth, screenHeight);

		app.setOnKeyPressed(e -> {
			switch (e.getCode()) {
			case W:
			case SPACE:
				isOnGround = true;
				if (isOnGround) {
					playerVelocityY = JUMP_STRENGTH;
					isJump = true;
				}
				
				break;
			case A:
				movingLeft = true;
				break;
			case D:
				movingRight = true;
				break;
			default:
				break;
			}
		});

		app.setOnKeyReleased(e -> {
			switch (e.getCode()) {
			case A:
				movingLeft = false;
				break;
			case D:
				movingRight = false;
				break;
			case W:
			case SPACE:
				isOnGround = false;
				isJump = false;
			break;
			default:
				break;
			}
		});

		new AnimationTimer() {
			double timeElapsed = 0.0;
			double delayTime = 0.15;
			boolean onSkyGround = false;
			@Override
			public void handle(long now) {
				double deltaTime = 1.0 / 60.0;

				for (ImageView skyGround : skyGrounds) {
//					System.out.println("Player = X :" + playerSprite.getX() + " Y : " + playerSprite.getY()
//							+ " SKY = X :" + skyGround.getX() + " Y : " + skyGround.getY()+" JUMP : "+isJump);
					if (playerSprite.getY() <= skyGround.getY() + skyGround.getFitHeight() && playerSprite.getY() >= skyGround.getY() - 100
						    && playerSprite.getX() >= skyGround.getX() - playerSprite.getFitWidth() / 2 
						    && playerSprite.getX() <= skyGround.getX() + skyGround.getFitWidth() - playerSprite.getFitWidth() / 2) {

						if (isJump) {
							playerVelocityY = JUMP_STRENGTH;
							GRAVITY = 1.0;
						}else {
							GRAVITY = 0;
							playerVelocityY = 0;
							playerY = skyGround.getY() - playerSprite.getFitHeight();
							isOnGround = true;
							onSkyGround = true;
						}
						break;
					} else {
						onSkyGround = false;
					}
				}
				
				if (!onSkyGround) {
					GRAVITY = 1.0;
				}
				
				if (playerSprite.getBoundsInParent().intersects(key.getBoundsInLocal())) {
					if (root.getChildren().contains(key)) {
						root.getChildren().add(portal.Start());
					}
					root.getChildren().remove(key);
				}
				if (playerSprite.getBoundsInParent().intersects(portal.Start().getBoundsInLocal())) {
					if (root.getChildren().contains(portal.Start())) {
						if (level == "Hard") {
							//root.getChildren().add(FrameTaxt);
							root.getChildren().add(comboBox);
							DoneButton.setLayoutX(comboBox.getLayoutX()+10);
							DoneButton.setLayoutY(comboBox.getLayoutY() + 100);
							root.getChildren().add(DoneButton);
							//root.getChildren().add(success);
						}else {
							root.getChildren().add(success);
							PauseTransition pause = new PauseTransition(Duration.seconds(3));
			                pause.setOnFinished(event -> {
			                    System.exit(0);
			                });
			                pause.play();
						}
						
					}
					root.getChildren().remove(portal.Start());
				}

				if (movingLeft) {
					playerX -= WALK_SPEED;
					playerSprite.setScaleX(-1);
					idle = assets.GetCharsByName(runSet);
					playerSprite.setImage(idle.getImage());
				}
				if (movingRight) {
					playerX += WALK_SPEED;
					playerSprite.setScaleX(1);
					idle = assets.GetCharsByName(runSet);
					playerSprite.setImage(idle.getImage());
				}
				if (!movingLeft && !movingRight) {
					idle = assets.GetCharsByName(idleSet);
					playerSprite.setImage(idle.getImage());
				}

				if (playerX < 0)
					playerX = 0;
				if (playerX > screenWidth - playerSprite.getFitWidth())
					playerX = screenWidth - playerSprite.getFitWidth();

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
				playerSprite.setY(playerY);
				playerSprite.setX(playerX);
//				coinView.setX(playerSprite.getX());
//				coinView.setY(playerSprite.getY());
//				CoinCounter.setLayoutX(playerSprite.getX());
//				CoinCounter.setLayoutX(playerSprite.getY());
				groundUp.forEach(e -> {
					if (playerSprite.getBoundsInParent().intersects(e.getBoundsInLocal())) {
						if (!(playerSprite.getY() + playerSprite.getFitHeight() < e.getY())) {
							playerVelocityY = 0;
							GRAVITY = 0;
							playerSprite.setY(e.getY() - playerSprite.getFitHeight());
						}
					} else {
						GRAVITY = 1.0;
					}
					
				});

				Iterator<Animetion> iterator = coins.iterator();
				while (iterator.hasNext()) {
					Animetion e = iterator.next();
					if (e.HitBox(playerSprite)) {
						coinScore++;
						CoinCounter.setText(Integer.toString(coinScore));
						root.getChildren().remove(e.Start());
						iterator.remove();
						if (coins.size() == 0) {
							root.getChildren().add(key);
						}
					}
				}
				

				timeElapsed += deltaTime;
				if (timeElapsed >= delayTime) {
					timeElapsed = 0.0;
					CF = (CF + 1) % idle.getFrames();
					playerSprite
							.setViewport(new Rectangle2D(CF * (playerSprite.getImage().getWidth() / idle.getFrames()),
									0, playerSprite.getImage().getWidth() / idle.getFrames(),
									playerSprite.getImage().getHeight()));
				}
			}
		}.start();
// CSS file loading removed to fix NullPointerException
// app.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	}
	
	// get world
	public Scene GetWorld() {
		return this.app;
	}
	
	
}
