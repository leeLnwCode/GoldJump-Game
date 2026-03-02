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

public class LevelSelection {	
	private static Button selectedCharacterButton = null;  // ตัวแปรเก็บปุ่มที่ถูกเลือก
	private static ImageView characterImageView = new ImageView();
	private static String selectedLevel = "Easy";
	private static Text selectCharacterText = new Text("SELECT LEVEL");;

    public static void showLevelSelectionScene(Stage primaryStage, String selectedCharacter) {
        // สร้าง root ของ layout
        AnchorPane root = new AnchorPane();
        
        

        // ใส่พื้นหลัง
        String path = "background/bg_v_b.png";
        Image backgroundImage = new Image(Main.class.getClassLoader().getResource(path).toExternalForm());
        ImageView imageView = new ImageView(backgroundImage);
        imageView.setFitWidth(1200);  // กำหนดความกว้างของภาพพื้นหลัง
        imageView.setFitHeight(700);  // กำหนดความสูงของภาพพื้นหลัง
        root.getChildren().add(imageView);  // เพิ่มภาพพื้นหลังใน layout
        
        
//        this.arText = selectCharacterText;
      
        String path1 = "fonts/PressStart2P.ttf";
        Font customFont1 = Font.loadFont(Main.class.getClassLoader().getResource(path1).toExternalForm(), 30);  // เปลี่ยน path ให้เป็นฟอนต์ที่คุณต้องการ
        selectCharacterText.setFont(customFont1);  // กำหนดฟอนต์ที่ใช้กับข้อความ
        selectCharacterText.setFill(Color.WHITE);  // กำหนดสีของข้อความเป็นสีขาว
    
        
        AnchorPane.setTopAnchor(selectCharacterText, 100.0);
        AnchorPane.setLeftAnchor(selectCharacterText, 400.0);
        // เพิ่มปุ่มสำหรับเลือกตัวละคร (ตัวอย่าง 2 ตัวเลือก)
        
        
        Button EasyButton = new Button("EASY");
        String path2 = "fonts/PressStart2P.ttf";
        Font customFont3 = Font.loadFont(Main.class.getClassLoader().getResource(path2).toExternalForm(), 25);  // เปลี่ยน path ให้เป็นฟอนต์ที่คุณต้องการ
        EasyButton.setFont(customFont3);  // กำหนดฟอนต์ที่ใช้กับข้อความ
        //DoneButton.setTextFill(Color.WHITE);  // กำหนดสีของข้อความเป็นสีขาว
        AnchorPane.setTopAnchor(EasyButton, 400.0);
        AnchorPane.setLeftAnchor(EasyButton, 328.0);
        
        Button HardButton = new Button("HARD");
        String path3 = "fonts/PressStart2P.ttf";
        Font customFont4 = Font.loadFont(Main.class.getClassLoader().getResource(path3).toExternalForm(), 25);  // เปลี่ยน path ให้เป็นฟอนต์ที่คุณต้องการ
        HardButton.setFont(customFont4);  // กำหนดฟอนต์ที่ใช้กับข้อความ
        //DoneButton.setTextFill(Color.WHITE);  // กำหนดสีของข้อความเป็นสีขาว
        AnchorPane.setTopAnchor(HardButton, 400.0);
        AnchorPane.setLeftAnchor(HardButton, 730.0);
        
        
        
        Text Easy1 = new Text("EASY");
        String path5 = "fonts/PressStart2P.ttf";
        Font customFont5 = Font.loadFont(Main.class.getClassLoader().getResource(path5).toExternalForm(), 20);  // เปลี่ยน path ให้เป็นฟอนต์ที่คุณต้องการ
        Easy1.setFont(customFont5);  // กำหนดฟอนต์ที่ใช้กับข้อความ
        Easy1.setFill(Color.WHITE);  // กำหนดสีของข้อความเป็นสีขาว
        AnchorPane.setTopAnchor(Easy1, 240.0);
        AnchorPane.setLeftAnchor(Easy1, 240.0);
        
        Text Easy2 = new Text("EASY");
        String path6 = "fonts/PressStart2P.ttf";
        Font customFont6 = Font.loadFont(Main.class.getClassLoader().getResource(path6).toExternalForm(), 20);  // เปลี่ยน path ให้เป็นฟอนต์ที่คุณต้องการ
        Easy2.setFont(customFont6);  // กำหนดฟอนต์ที่ใช้กับข้อความ
        Easy2.setFill(Color.WHITE);  // กำหนดสีของข้อความเป็นสีขาว
        AnchorPane.setTopAnchor(Easy2, 190.0);
        AnchorPane.setLeftAnchor(Easy2, 400.0);
        
        Text Easy3 = new Text("EASY");
        String path7 = "fonts/PressStart2P.ttf";
        Font customFont7 = Font.loadFont(Main.class.getClassLoader().getResource(path7).toExternalForm(), 20);  // เปลี่ยน path ให้เป็นฟอนต์ที่คุณต้องการ
        Easy3.setFont(customFont7);  // กำหนดฟอนต์ที่ใช้กับข้อความ
        Easy3.setFill(Color.WHITE);  // กำหนดสีของข้อความเป็นสีขาว
        AnchorPane.setTopAnchor(Easy3, 350.0);
        AnchorPane.setLeftAnchor(Easy3, 420.0);
        
        
        
        Text Hard1 = new Text("HARD");
        String path10 = "fonts/PressStart2P.ttf";
        Font customFont10 = Font.loadFont(Main.class.getClassLoader().getResource(path10).toExternalForm(), 20);  // เปลี่ยน path ให้เป็นฟอนต์ที่คุณต้องการ
        Hard1.setFont(customFont10);  // กำหนดฟอนต์ที่ใช้กับข้อความ
        Hard1.setFill(Color.WHITE);  // กำหนดสีของข้อความเป็นสีขาว
        AnchorPane.setTopAnchor(Hard1, 240.0);
        AnchorPane.setLeftAnchor(Hard1, 870.0);
        
        Text Hard2 = new Text("HARD");
        String path11 = "fonts/PressStart2P.ttf";
        Font customFont11 = Font.loadFont(Main.class.getClassLoader().getResource(path11).toExternalForm(), 20);  // เปลี่ยน path ให้เป็นฟอนต์ที่คุณต้องการ
        Hard2.setFont(customFont11);  // กำหนดฟอนต์ที่ใช้กับข้อความ
        Hard2.setFill(Color.WHITE);  // กำหนดสีของข้อความเป็นสีขาว
        AnchorPane.setTopAnchor(Hard2, 190.0);
        AnchorPane.setLeftAnchor(Hard2, 710.0);
        
        Text Hard3 = new Text("HARD");
        String path12 = "fonts/PressStart2P.ttf";
        Font customFont12 = Font.loadFont(Main.class.getClassLoader().getResource(path12).toExternalForm(), 20);  // เปลี่ยน path ให้เป็นฟอนต์ที่คุณต้องการ
        Hard3.setFont(customFont12);  // กำหนดฟอนต์ที่ใช้กับข้อความ
        Hard3.setFill(Color.WHITE);  // กำหนดสีของข้อความเป็นสีขาว
        AnchorPane.setTopAnchor(Hard3, 350.0);
        AnchorPane.setLeftAnchor(Hard3, 690.0);
        
        
        
        
        Easy1.setOpacity(0.0);
        Easy2.setOpacity(0.0);
        Easy3.setOpacity(0.0);

        Hard1.setOpacity(0.0);
        Hard2.setOpacity(0.0);
        Hard3.setOpacity(0.0);
        
        EasyButton.setOnAction(e -> {
        	String path16 = "player1-pink/Pink_Monster_Idle_4.png";
            
            // กำหนดให้ตัวละคร 1 ถูกเลือกโดยอัตโนมัติเมื่อหน้าโหลด
              handleCharacterSelection(EasyButton, "Character 1",List.of(new Image(Main.class.getClassLoader().getResource(path16).toExternalForm())));
        	selectedLevel = "Easy";  // เก็บข้อมูลระดับที่เลือก
            Easy1.setOpacity(1.0);
        	Easy2.setOpacity(1.0);
        	Easy3.setOpacity(1.0);
        });

        HardButton.setOnAction(e -> {
        	String path16 = "player1-pink/Pink_Monster_Idle_4.png";
            
            // กำหนดให้ตัวละคร 1 ถูกเลือกโดยอัตโนมัติเมื่อหน้าโหลด
              handleCharacterSelection(HardButton, "Character 1",List.of(new Image(Main.class.getClassLoader().getResource(path16).toExternalForm())));
        	selectedLevel = "Hard";  // เก็บข้อมูลระดับที่เลือก
            Hard1.setOpacity(1.0);
        	Hard2.setOpacity(1.0);
        	Hard3.setOpacity(1.0);
        });
        

       
        
        EasyButton.setOnMouseEntered((MouseEvent e) -> {
        	EasyButton.setOpacity(0.8);  // ลดความทึบให้ดูเหมือนเปลี่ยนสีเมื่อเมาส์ชี้
        	Easy1.setOpacity(1.0);
        	Easy2.setOpacity(1.0);
        	Easy3.setOpacity(1.0);
        	
        });
        EasyButton.setOnMouseExited((MouseEvent e) -> {
        	EasyButton.setOpacity(1.0);  // คืนค่าความทึบเป็นปกติ
        	Easy1.setOpacity(0.0);
        	Easy2.setOpacity(0.0);
        	Easy3.setOpacity(0.0);
        	 
        });
        
        HardButton.setOnMouseEntered((MouseEvent e) -> {
        	HardButton.setOpacity(0.8);  // ลดความทึบให้ดูเหมือนเปลี่ยนสีเมื่อเมาส์ชี้
        	Hard1.setOpacity(1.0);
        	Hard2.setOpacity(1.0);
        	Hard3.setOpacity(1.0);
    	     
    });
        HardButton.setOnMouseExited((MouseEvent e) -> {
        	HardButton.setOpacity(1.0);  // คืนค่าความทึบเป็นปกติ
        	Hard1.setOpacity(0.0);
        	Hard2.setOpacity(0.0);
        	Hard3.setOpacity(0.0);
    	    
    });
        
      
        Text back = new Text("<");
        String path8 = "fonts/PressStart2P.ttf";
        Font customFont8 = Font.loadFont(Main.class.getClassLoader().getResource(path8).toExternalForm(), 45);  // เปลี่ยน path ให้เป็นฟอนต์ที่คุณต้องการ
        back.setFont(customFont8);  // กำหนดฟอนต์ที่ใช้กับข้อความ
        back.setFill(Color.WHITE);  // กำหนดสีของข้อความเป็นสีขาว
        AnchorPane.setTopAnchor(back, 600.0);
        AnchorPane.setLeftAnchor(back, 70.0);
        
        Text next = new Text("START");
        String path9 = "fonts/PressStart2P.ttf";
        Font customFont9 = Font.loadFont(Main.class.getClassLoader().getResource(path9).toExternalForm(), 28);  // เปลี่ยน path ให้เป็นฟอนต์ที่คุณต้องการ
        next.setFont(customFont9);  // กำหนดฟอนต์ที่ใช้กับข้อความ
        next.setFill(Color.WHITE);  // กำหนดสีของข้อความเป็นสีขาว
        AnchorPane.setTopAnchor(next, 530.0);
        AnchorPane.setLeftAnchor(next, 528.0);
        
        String path13 = "object/other/—Pngtree—button game_6976878.png";
        ImageView nextBT = new ImageView(new Image(Main.class.getClassLoader().getResource(path13).toExternalForm()));  // เปลี่ยน path ให้เป็นภาพปุ่ม Start
        // ตั้งขนาดของปุ่ม
        nextBT.setFitWidth(295);  // กำหนดความกว้างของปุ่ม
        nextBT.setFitHeight(195);  // กำหนดความสูงของปุ่ม
        
        AnchorPane.setTopAnchor(nextBT, 450.0);
        AnchorPane.setLeftAnchor(nextBT, 448.0);
        /*exitButton1.setFitWidth(300);  // กำหนดความกว้างของปุ่ม
        exitButton1.setFitHeight(200);  // กำหนดความสูงของปุ่ม*/
        
        
        String path14 = "object/other/Bush (4).png";
        ImageView EasyPic = new ImageView(new Image(Main.class.getClassLoader().getResource(path14).toExternalForm()));  // เปลี่ยน path ให้เป็นภาพปุ่ม Start
        // ตั้งขนาดของปุ่ม
        EasyPic.setFitWidth(130);  // กำหนดความกว้างของปุ่ม
        EasyPic.setFitHeight(70);  // กำหนดความสูงของปุ่ม
        
        AnchorPane.setTopAnchor(EasyPic, 240.0);
        AnchorPane.setLeftAnchor(EasyPic, 330.0);
        
        String path15 = "object/other/Stone.png";
        ImageView HardPic = new ImageView(new Image(Main.class.getClassLoader().getResource(path15).toExternalForm()));  // เปลี่ยน path ให้เป็นภาพปุ่ม Start
        // ตั้งขนาดของปุ่ม
        HardPic.setFitWidth(130);  // กำหนดความกว้างของปุ่ม
        HardPic.setFitHeight(70);  // กำหนดความสูงของปุ่ม
        
        AnchorPane.setTopAnchor(HardPic, 240.0);
        AnchorPane.setLeftAnchor(HardPic, 731.0);
        
        
        
        
        
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

    String path16 = "player1-pink/Pink_Monster_Idle_4.png";
    
    // กำหนดให้ตัวละคร 1 ถูกเลือกโดยอัตโนมัติเมื่อหน้าโหลด
      handleCharacterSelection(EasyButton, selectedCharacter,List.of(new Image(Main.class.getClassLoader().getResource(path16).toExternalForm())));
    
        nextBT.setOnMouseClicked((MouseEvent e) -> {
            // สร้างหน้าใหม่ (ที่สามารถเป็นหน้าต่อไปที่เลือกตัวละครหรืออื่น ๆ)
            System.out.println("Next Button Clicked");
            if (selectedCharacter != null && !selectedCharacter.isEmpty() && selectedLevel != null && !selectedLevel.isEmpty()) {
                startGame(primaryStage, selectedCharacter, selectedLevel);  // เรียกฟังก์ชันที่ต้องการ
            } else {
                System.out.println("Character or Level not selected!");  // แสดงข้อความหากยังไม่ได้เลือก
            }
            
        	
        });
       
        
        next.setOnMouseClicked((MouseEvent e) -> {
            // สร้างหน้าใหม่ (ที่สามารถเป็นหน้าต่อไปที่เลือกตัวละครหรืออื่น ๆ)
            System.out.println("Next Button Clicked");
            if (selectedCharacter != null && !selectedCharacter.isEmpty() && selectedLevel != null && !selectedLevel.isEmpty()) {
                startGame(primaryStage, selectedCharacter, selectedLevel);  // เรียกฟังก์ชันที่ต้องการ
            } else {
                System.out.println("Character or Level not selected!");  // แสดงข้อความหากยังไม่ได้เลือก
            }
    
        });
            
     
        
        back.setOnMouseClicked((MouseEvent e) -> {
            // สร้างหน้าใหม่ (ที่สามารถเป็นหน้าต่อไปที่เลือกตัวละครหรืออื่น ๆ)
            System.out.println("Next Button Clicked"); 
            CharacterSelection.showCharacterSelectionScene(primaryStage);
            
        });
        
        
        // เพิ่มปุ่มเลือกตัวละครลงใน root
        root.getChildren().addAll(selectCharacterText,nextBT,next,back,HardButton,EasyButton,EasyPic,HardPic,Easy1,Easy2,Easy3,Hard1,Hard2,Hard3);

        // สร้าง Scene สำหรับหน้าเลือกตัวละคร
        Scene characterSelectionScene = new Scene(root, 1200, 700);

        // เปลี่ยนไปที่ Scene ใหม่
        primaryStage.setScene(characterSelectionScene);
    }
    private static void handleCharacterSelection(Button selectedButton, String characterName,List<Image> characterFrames) {
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
        
        
        
        characterImageView.setImage(characterFrames.get(0)); // แสดงเฟรมแรก
        characterImageView.setFitWidth(200);
        characterImageView.setFitHeight(200);
        AnchorPane.setTopAnchor(characterImageView, 150.0);
        AnchorPane.setLeftAnchor(characterImageView, 500.0);

      
       
        
    }
    private static void startGame(Stage primaryStage, String selectedCharacter, String selectedLevel) {
        // ส่งข้อมูลไปยังหน้าต่อไป (เกม)
        System.out.println("Starting Game with Character: " + selectedCharacter + " and Level: " + selectedLevel);

        // เปลี่ยนไปที่หน้าเกม
        GameScene gameScene = new GameScene(primaryStage, selectedCharacter, selectedLevel,selectCharacterText);
        primaryStage.setScene(gameScene.getScene());
    }

}

