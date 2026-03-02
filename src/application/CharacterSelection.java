package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.List;
import javafx.geometry.Rectangle2D;
public class CharacterSelection {
	private static Button selectedCharacterButton = null;  // ตัวแปรเก็บปุ่มที่ถูกเลือก
	private static ImageView characterImageView = new ImageView();
	private static String selectedCharacter = "Pink Girl";

	
    public static void showCharacterSelectionScene(Stage primaryStage) {
        // สร้าง root ของ layout
        AnchorPane root = new AnchorPane();
        
        
        // ใส่พื้นหลัง
        String path = "background/bg_v_b.png"; // ให้แน่ใจว่าไม่ใช้ "/" ที่นำหน้า path
        Image backgroundImage = new Image(Main.class.getClassLoader().getResource(path).toExternalForm());
        
        ImageView imageView = new ImageView(backgroundImage);
        imageView.setFitWidth(1200);  // กำหนดความกว้างของภาพพื้นหลัง
        imageView.setFitHeight(700);  // กำหนดความสูงของภาพพื้นหลัง
        root.getChildren().add(imageView);  // เพิ่มภาพพื้นหลังใน layout
        
        Text selectCharacterText = new Text("SELECT PLAYER");
        
        String path1 = "fonts/PressStart2P.ttf";
        Font customFont1 = Font.loadFont(Main.class.getClassLoader().getResource(path1).toExternalForm(), 30);  // เปลี่ยน path ให้เป็นฟอนต์ที่คุณต้องการ
        selectCharacterText.setFont(customFont1);  // กำหนดฟอนต์ที่ใช้กับข้อความ
        selectCharacterText.setFill(Color.WHITE);  // กำหนดสีของข้อความเป็นสีขาว
    
        //AnchorPane.setTopAnchor(selectCharacterText, (root.getHeight() - selectCharacterText.getBoundsInLocal().getHeight()) / 2);
        //AnchorPane.setLeftAnchor(selectCharacterText, (root.getWidth() - selectCharacterText.getBoundsInLocal().getWidth()) / 2);
        AnchorPane.setTopAnchor(selectCharacterText, 100.0);
        AnchorPane.setLeftAnchor(selectCharacterText, 400.0);
        // เพิ่มปุ่มสำหรับเลือกตัวละคร (ตัวอย่าง 2 ตัวเลือก)
        Button character1Button = new Button("PLAYER 1");
       
        String path3 = "fonts/PressStart2P.ttf";
        Font customFont3 = Font.loadFont(Main.class.getClassLoader().getResource(path3).toExternalForm(), 25);  // เปลี่ยน path ให้เป็นฟอนต์ที่คุณต้องการ
        character1Button.setFont(customFont3);  // กำหนดฟอนต์ที่ใช้กับข้อความ
        //DoneButton.setTextFill(Color.WHITE);  // กำหนดสีของข้อความเป็นสีขาว
        AnchorPane.setTopAnchor(character1Button, 400.0);
        AnchorPane.setLeftAnchor(character1Button, 280.0);
      
        
        Button character2Button = new Button("PLAYER 2");
        String path4 = "fonts/PressStart2P.ttf";
        Font customFont4 = Font.loadFont(Main.class.getClassLoader().getResource(path4).toExternalForm(), 25);  // เปลี่ยน path ให้เป็นฟอนต์ที่คุณต้องการ
        character2Button.setFont(customFont4);  // กำหนดฟอนต์ที่ใช้กับข้อความ
        //DoneButton.setTextFill(Color.WHITE);  // กำหนดสีของข้อความเป็นสีขาว
        AnchorPane.setTopAnchor(character2Button, 400.0);
        AnchorPane.setLeftAnchor(character2Button, 670.0);
        
        
        Text back = new Text("<");
        String path5 = "fonts/PressStart2P.ttf";
        Font customFont7 = Font.loadFont(Main.class.getClassLoader().getResource(path5).toExternalForm(), 45);  // เปลี่ยน path ให้เป็นฟอนต์ที่คุณต้องการ
        back.setFont(customFont7);  // กำหนดฟอนต์ที่ใช้กับข้อความ
        back.setFill(Color.WHITE);  // กำหนดสีของข้อความเป็นสีขาว
        AnchorPane.setTopAnchor(back, 600.0);
        AnchorPane.setLeftAnchor(back, 70.0);
        
        Text next = new Text("NEXT");
        String path6 = "fonts/PressStart2P.ttf";
        Font customFont6 = Font.loadFont(Main.class.getClassLoader().getResource(path6).toExternalForm(), 28);  // เปลี่ยน path ให้เป็นฟอนต์ที่คุณต้องการ
        next.setFont(customFont6);  // กำหนดฟอนต์ที่ใช้กับข้อความ
        next.setFill(Color.WHITE);  // กำหนดสีของข้อความเป็นสีขาว
        AnchorPane.setTopAnchor(next, 530.0);
        AnchorPane.setLeftAnchor(next, 540.0);
        
        String path7 = "object/other/—Pngtree—button game_6976878.png";
        ImageView nextBT = new ImageView(new Image(Main.class.getClassLoader().getResource(path7).toExternalForm()));  // เปลี่ยน path ให้เป็นภาพปุ่ม Start
        // ตั้งขนาดของปุ่ม
        nextBT.setFitWidth(295);  // กำหนดความกว้างของปุ่ม
        nextBT.setFitHeight(195);  // กำหนดความสูงของปุ่ม
        
        AnchorPane.setTopAnchor(nextBT, 450.0);
        AnchorPane.setLeftAnchor(nextBT, 448.0);
        /*exitButton1.setFitWidth(300);  // กำหนดความกว้างของปุ่ม
        exitButton1.setFitHeight(200);  // กำหนดความสูงของปุ่ม*/
        
        character1Button.setOnMouseEntered((MouseEvent e) -> {
        	character1Button.setOpacity(0.8);  // ลดความทึบให้ดูเหมือนเปลี่ยนสีเมื่อเมาส์ชี้
        	
        });
        character1Button.setOnMouseExited((MouseEvent e) -> {
        	character1Button.setOpacity(1.0);  // คืนค่าความทึบเป็นปกติ
        	 
        });
        
        character2Button.setOnMouseEntered((MouseEvent e) -> {
        	character2Button.setOpacity(0.8);  // ลดความทึบให้ดูเหมือนเปลี่ยนสีเมื่อเมาส์ชี้
    	     
    });
        character2Button.setOnMouseExited((MouseEvent e) -> {
        	character2Button.setOpacity(1.0);  // คืนค่าความทึบเป็นปกติ
    	    
    });
        
        nextBT.setOnMouseEntered((MouseEvent e) -> {
        	nextBT.setOpacity(0.7);  // ลดความทึบให้ดูเหมือนเปลี่ยนสีเมื่อเมาส์ชี้
        	next.setOpacity(0.7);
        });
        nextBT.setOnMouseExited((MouseEvent e) -> {
        	nextBT.setOpacity(1.0);  // คืนค่าความทึบเป็นปกติ
        	next.setOpacity(1.0); 
        });
        
        next.setOnMouseEntered((MouseEvent e) -> {
    	next.setOpacity(0.7);  // ลดความทึบให้ดูเหมือนเปลี่ยนสีเมื่อเมาส์ชี้
    	nextBT.setOpacity(0.7); 
    });
    next.setOnMouseExited((MouseEvent e) -> {
    	next.setOpacity(1.0);  // คืนค่าความทึบเป็นปกติ
    	nextBT.setOpacity(1.0); 
    });
    
    
    back.setOnMouseEntered((MouseEvent e) -> {
    	back.setOpacity(0.7);  // ลดความทึบให้ดูเหมือนเปลี่ยนสีเมื่อเมาส์ชี้
    	back.setOpacity(0.7);
    });
    back.setOnMouseExited((MouseEvent e) -> {
    	back.setOpacity(1.0);  // คืนค่าความทึบเป็นปกติ
    	back.setOpacity(1.0); 
    });
   
      //ฟังก์ชั่นเมื่อกดปุ่มเลือกตัวละคร
        character1Button.setOnAction(e -> {
        	String path8 = "player1-pink/Pink_Monster_Idle_4.png";
            handleCharacterSelection(character1Button, "PinkGirl", List.of(new Image(Main.class.getClassLoader().getResource(path8).toExternalForm())),32,32);
            selectedCharacter = "PinkGirl";
        });

        character2Button.setOnAction(e -> {
        	String path9 = "player2-shi/Idle.png";
            handleCharacterSelection(character2Button, "Shibuya",List.of(new Image(Main.class.getClassLoader().getResource(path9).toExternalForm())),128,128);
            selectedCharacter = "Shibuya";
        });

        
        // กำหนดให้ตัวละคร 1 ถูกเลือกโดยอัตโนมัติเมื่อหน้าโหลด
        String path10 = "player1-pink/Pink_Monster_Idle_4.png";
        selectedCharacter = "PinkGirl";
        handleCharacterSelection(character1Button, selectedCharacter,List.of(new Image(Main.class.getClassLoader().getResource(path10).toExternalForm())),32,32);
        
        nextBT.setOnMouseClicked((MouseEvent e) -> {
            // สร้างหน้าใหม่ (ที่สามารถเป็นหน้าต่อไปที่เลือกตัวละครหรืออื่น ๆ)
            System.out.println("Next Button Clicked");
            // เปลี่ยน Scene ไปยังหน้าถัดไป
            //showNextScene(primaryStage); 
            LevelSelection.showLevelSelectionScene(primaryStage,selectedCharacter);
        });
        next.setOnMouseClicked((MouseEvent e) -> {
            // สร้างหน้าใหม่ (ที่สามารถเป็นหน้าต่อไปที่เลือกตัวละครหรืออื่น ๆ)
            System.out.println("Next Button Clicked");
            // เปลี่ยน Scene ไปยังหน้าถัดไป
            //showNextScene(primaryStage); 
            LevelSelection.showLevelSelectionScene(primaryStage,selectedCharacter);
        });
        
        back.setOnMouseClicked((MouseEvent e) -> {
            // สร้างหน้าใหม่ (ที่สามารถเป็นหน้าต่อไปที่เลือกตัวละครหรืออื่น ๆ)
            System.out.println("Next Button Clicked");
            // เปลี่ยน Scene ไปยังหน้าถัดไป
            //showNextScene(primaryStage); 
            showMainMenu1(primaryStage);
        });
        
        // เพิ่มปุ่มเลือกตัวละครลงใน root
        root.getChildren().addAll(selectCharacterText, character1Button, character2Button,nextBT,next,back);
        root.getChildren().add(characterImageView);

        // สร้าง Scene สำหรับหน้าเลือกตัวละคร
        Scene characterSelectionScene = new Scene(root, 1200, 700);

        // เปลี่ยนไปที่ Scene ใหม่
        primaryStage.setScene(characterSelectionScene);
    }
    public static void showMainMenu1(Stage primaryStage) {
        // สร้าง root ของ layout สำหรับ Main Menu
        AnchorPane root = new AnchorPane();
        
        String path = "background/bg_v_b.png";
        Image backgroundImage = new Image(Main.class.getClassLoader().getResource(path).toExternalForm()); // ใส่ path ของภาพพื้นหลัง
        ImageView imageView = new ImageView(backgroundImage);
        imageView.setFitWidth(1200);  // กำหนดความกว้างของภาพพื้นหลัง
        imageView.setFitHeight(700);  // กำหนดความสูงของภาพพื้นหลัง
        root.getChildren().add(imageView);  // เพิ่มภาพพื้นหลังใน layout
       
        
        
        // โหลดฟอนต์ของเกม
        String path1 = "fonts/PressStart2P.ttf";
        Font customFont = Font.loadFont(Main.class.getClassLoader().getResource(path1).toExternalForm(), 60);  // ใส่ path ของฟอนต์
        Text welcomeText = new Text("Gold Jump");
        welcomeText.setFont(customFont);  // ใช้ฟอนต์ที่โหลด
        welcomeText.setFill(Color.WHITE);  // กำหนดสีข้อความเป็นสีขาว

        // ตั้งตำแหน่งของข้อความ
        AnchorPane.setTopAnchor(welcomeText, 200.0);
        AnchorPane.setLeftAnchor(welcomeText, 320.0);
        
        String path6 = "object/other/—Pngtree—button game_6976878.png";
        String path7 = "object/other/—Pngtree—button game_6976878.png";
        ImageView startButton1 = new ImageView(new Image(Main.class.getClassLoader().getResource(path6).toExternalForm()));  // เปลี่ยน path ให้เป็นภาพปุ่ม Start
        ImageView exitButton1 = new ImageView(new Image(Main.class.getClassLoader().getResource(path7).toExternalForm()));  // เปลี่ยน path ให้เป็นภาพปุ่ม Exit

        // ตั้งขนาดของปุ่ม
        startButton1.setFitWidth(300);  // กำหนดความกว้างของปุ่ม
        startButton1.setFitHeight(200);  // กำหนดความสูงของปุ่ม
        exitButton1.setFitWidth(300);  // กำหนดความกว้างของปุ่ม
        exitButton1.setFitHeight(200);  // กำหนดความสูงของปุ่ม
        
     // สร้างข้อความสำหรับปุ่ม
        Text buttonText = new Text("PLAY");
        String path2 = "fonts/PressStart2P.ttf";
        Font customFont6 = Font.loadFont(Main.class.getClassLoader().getResource(path2).toExternalForm(), 25);  // เปลี่ยน path ให้เป็นฟอนต์ที่คุณต้องการ
        buttonText.setFont(customFont6);  // กำหนดฟอนต์ที่ใช้กับข้อความ
        buttonText.setFill(Color.WHITE);  // กำหนดสีของข้อความเป็นสีขาว
        
        Text buttonText1 = new Text("EXIT");
        String path3 = "fonts/PressStart2P.ttf";
        Font customFont2 = Font.loadFont(Main.class.getClassLoader().getResource(path3).toExternalForm(), 25);  // เปลี่ยน path ให้เป็นฟอนต์ที่คุณต้องการ
        buttonText1.setFont(customFont2);  // กำหนดฟอนต์ที่ใช้กับข้อความ
        buttonText1.setFill(Color.WHITE);  // กำหนดสีของข้อความเป็นสีขาว

        // ตั้งตำแหน่งของปุ่ม
        AnchorPane.setTopAnchor(startButton1, 250.0);
        AnchorPane.setLeftAnchor(startButton1, 445.0);
        AnchorPane.setTopAnchor(buttonText, 332.0);  // ขยับข้อความเล็กน้อยให้อยู่ตรงกลางปุ่ม
        AnchorPane.setLeftAnchor(buttonText, 545.0);  // ขยับข้อความเล็กน้อยให้อยู่ตรงกลางปุ่ม

        AnchorPane.setTopAnchor(exitButton1, 350.0);
        AnchorPane.setLeftAnchor(exitButton1, 445.0);
        AnchorPane.setTopAnchor(buttonText1, 432.0);  // ขยับข้อความเล็กน้อยให้อยู่ตรงกลางปุ่ม
        AnchorPane.setLeftAnchor(buttonText1, 545.0);  // ขยับข้อความเล็กน้อยให้อยู่ตรงกลางปุ่ม

        // การทำงานเมื่อคลิกปุ่ม Exit
        exitButton1.setOnMouseClicked((MouseEvent e) -> {
            System.out.println("Exiting the game...");
            System.exit(0);  // ปิดโปรแกรม
        });
        buttonText1.setOnMouseClicked((MouseEvent e) -> {
            System.out.println("Exiting the game...");
            System.exit(0);  // ปิดโปรแกรม
        });

        // การทำงานเมื่อคลิกปุ่ม Start (ถ้าคุณต้องการให้เปิดหน้าเกม)
        startButton1.setOnMouseClicked((MouseEvent e) -> {
            System.out.println("Starting the game...");
            CharacterSelection.showCharacterSelectionScene(primaryStage);
            
            
        });
        buttonText.setOnMouseClicked((MouseEvent e) -> {
            System.out.println("Starting the game...");
            CharacterSelection.showCharacterSelectionScene(primaryStage);
            
            
        });
     // เปลี่ยนสีเมื่อเมาส์เข้ามาบนปุ่ม Start
        startButton1.setOnMouseEntered((MouseEvent e) -> {
            startButton1.setOpacity(0.7);  // ลดความทึบให้ดูเหมือนเปลี่ยนสีเมื่อเมาส์ชี้
            buttonText.setOpacity(0.7);
        });
        
        buttonText.setOnMouseEntered((MouseEvent e) -> {
            startButton1.setOpacity(0.7);  // ลดความทึบให้ดูเหมือนเปลี่ยนสีเมื่อเมาส์ชี้
            buttonText.setOpacity(0.7);
        });

        // กลับสู่สีเดิมเมื่อเมาส์ออกจากปุ่ม Start
        startButton1.setOnMouseExited((MouseEvent e) -> {
            startButton1.setOpacity(1.0);  // คืนค่าความทึบเป็นปกติ
            buttonText.setOpacity(1.0);
        });
        
        buttonText.setOnMouseExited((MouseEvent e) -> {
            startButton1.setOpacity(1.0);  // คืนค่าความทึบเป็นปกติ
            buttonText.setOpacity(1.0);
        });


        // เปลี่ยนสีเมื่อเมาส์เข้ามาบนปุ่ม Exit
        exitButton1.setOnMouseEntered((MouseEvent e) -> {
            exitButton1.setOpacity(0.7);  // ลดความทึบให้ดูเหมือนเปลี่ยนสีเมื่อเมาส์ชี้
            buttonText1.setOpacity(0.7);
        });
        buttonText1.setOnMouseEntered((MouseEvent e) -> {
            exitButton1.setOpacity(0.7);  // ลดความทึบให้ดูเหมือนเปลี่ยนสีเมื่อเมาส์ชี้
            buttonText1.setOpacity(0.7);
        });

        // กลับสู่สีเดิมเมื่อเมาส์ออกจากปุ่ม Exit
        exitButton1.setOnMouseExited((MouseEvent e) -> {
            exitButton1.setOpacity(1.0);  // คืนค่าความทึบเป็นปกติ
            buttonText1.setOpacity(1.0);
        });
        buttonText1.setOnMouseExited((MouseEvent e) -> {
            exitButton1.setOpacity(1.0);  // คืนค่าความทึบเป็นปกติ
            buttonText1.setOpacity(1.0);
        });

        // เพิ่มปุ่มลงใน root
        root.getChildren().addAll(welcomeText, startButton1, buttonText, exitButton1,buttonText1);

        // สร้าง Scene ใหม่สำหรับหน้า Main Menu
        Scene mainMenuScene = new Scene(root, 1200, 700);
        primaryStage.setScene(mainMenuScene);  // เปลี่ยน Scene ไปที่ Main Menu
    }
	private static void handleCharacterSelection(Button selectedButton, String characterName,List<Image> characterFrames , int w , int h) {
        // ถ้าหากมีปุ่มที่ถูกเลือกอยู่แล้ว
        if (selectedCharacterButton != null) {
            // รีเซ็ตสีของปุ่มที่เลือกก่อนหน้านี้
        	String path4 = "fonts/PressStart2P.ttf";
        	Font customFont4 = Font.loadFont(Main.class.getClassLoader().getResource(path4).toExternalForm(), 25);  // เปลี่ยน path ให้เป็นฟอนต์ที่คุณต้องการ
        	selectedCharacterButton.setFont(customFont4);  // กำหนดฟอนต์ที่ใช้กับข้อความ
            selectedCharacterButton.setStyle("-fx-background-color: white; -fx-text-fill: black;");
        }

        // เปลี่ยนสีของปุ่มที่เลือกใหม่
        String path5 = "fonts/PressStart2P.ttf";
        Font customFont4 = Font.loadFont(Main.class.getClassLoader().getResource(path5).toExternalForm(), 25);  // เปลี่ยน path ให้เป็นฟอนต์ที่คุณต้องการ
        selectedButton.setFont(customFont4);  // กำหนดฟอนต์ที่ใช้กับข้อความ
        selectedButton.setStyle("-fx-background-color: brown; -fx-text-fill: white;");

        // กำหนดปุ่มที่ถูกเลือก
        selectedCharacterButton = selectedButton;
        Rectangle2D firstFrame = new Rectangle2D(0, 0, w, h);
        characterImageView.setImage(characterFrames.get(0)); // แสดงเฟรมแรก
        if (characterName == "PinkGirl") {
        	characterImageView.setScaleX(5.0);
        	characterImageView.setScaleY(5.0);
        	characterImageView.setViewport(firstFrame);
            AnchorPane.setTopAnchor(characterImageView, 250.0);
            AnchorPane.setLeftAnchor(characterImageView, 575.0);
        }
        if (characterName == "Shibuya") {
        	characterImageView.setScaleX(2.0);
        	characterImageView.setScaleY(2.0);
        	characterImageView.setViewport(firstFrame);
            AnchorPane.setTopAnchor(characterImageView, 150.0);
            AnchorPane.setLeftAnchor(characterImageView, 560.0);
        }
        
        

       
        
    }
   
}