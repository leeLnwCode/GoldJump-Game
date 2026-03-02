package application;

import javafx.animation.PauseTransition;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class GameScene {
    private Scene scene;
    private String selectedCharacter;
    private String selectedLevel;
    private Stage primaryStage;
    private Text st;
    private AnchorPane root = new AnchorPane();
    public GameScene(Stage primaryStage,String selectedCharacter, String selectedLevel,Text selectText) {
        this.selectedCharacter = selectedCharacter;
        this.selectedLevel = selectedLevel;
        this.primaryStage = primaryStage;
        this.st = selectText;
        // สร้าง Scene และแสดงข้อมูลที่เลือก
        createGameScene(primaryStage);
    }
    private void createGameScene(Stage primaryStage) {
        // สร้าง root ของ layout
        //AnchorPane root = new AnchorPane();

        // สร้าง ImageView สำหรับพื้นหลัง
        ImageView imageView = new ImageView();
        Image backgroundImage = null;

        // เปลี่ยนพื้นหลังตามระดับที่เลือก
        if ("Easy".equals(selectedLevel)) {
        	st.setText("Loading...");
        	this.scene = new World(this.selectedLevel,this.selectedCharacter).GetWorld();
        	//backgroundImage = new Image(getClass().getResource("/background/Preview 1.png").toExternalForm());
            //backgroundImage = new Image("file:///C:/Users/Asus/OneDrive/Desktop/oop/OOP_gold_jump_project/src/bg/background/Preview%201.png");
        } else if ("Hard".equals(selectedLevel)) {
        	this.scene = new World(this.selectedLevel,this.selectedCharacter).GetWorld();
        	
//          backgroundImage = new Image(getClass().getResource("/background/background.png").toExternalForm());
        }
        
//        imageView.setImage(backgroundImage);
//        imageView.setFitWidth(1200); // ขนาดของพื้นหลัง
//        imageView.setFitHeight(700); // ขนาดของพื้นหลัง
//        root.getChildren().add(imageView); // เพิ่มพื้นหลังลงใน root layout
//
//        // สร้างข้อความที่แสดงตัวละครที่เลือก
//        Text characterText = new Text("Character: " + selectedCharacter);
//        
//        
//        Font customFont6 = Font.loadFont(getClass().getResource("/fonts/PressStart2P.ttf").toExternalForm(), 22);
//        characterText.setFont(customFont6);
//        characterText.setFill(Color.BLACK);
//        AnchorPane.setTopAnchor(characterText, 310.0);
//        AnchorPane.setLeftAnchor(characterText, 390.0);
//        
//        // สร้างข้อความที่แสดงระดับที่เลือก
//        Text levelText = new Text("Level: " + selectedLevel);
//        Font customFont7 = Font.loadFont(getClass().getResource("/fonts/PressStart2P.ttf").toExternalForm(), 22);
//        levelText.setFont(customFont7);
//        levelText.setFill(Color.BLACK);
//        AnchorPane.setTopAnchor(levelText, 390.0);
//        AnchorPane.setLeftAnchor(levelText, 390.0);
//        
//        
//        ImageView FrameTaxt = new ImageView(new Image(getClass().getResource("/object/other/Lovepik_com-380332886-gray-green-pixel-art-text-box-dialog-frame-greyish-green.png").toExternalForm()));  // เปลี่ยน path ให้เป็นภาพปุ่ม Start
//        // ตั้งขนาดของปุ่ม
//        FrameTaxt.setFitWidth(900);  // กำหนดความกว้างของปุ่ม
//        FrameTaxt.setFitHeight(700);  // กำหนดความสูงของปุ่ม
//        
//        
//        AnchorPane.setTopAnchor(FrameTaxt, 35.0);
//        AnchorPane.setLeftAnchor(FrameTaxt, 160.0);
//        
//        Text ExitTenxt = new Text("X");
//        Font customFont8 = Font.loadFont(getClass().getResource("/fonts/PressStart2P.ttf").toExternalForm(), 45);  // เปลี่ยน path ให้เป็นฟอนต์ที่คุณต้องการ
//        ExitTenxt.setFont(customFont8);  // กำหนดฟอนต์ที่ใช้กับข้อความ
//        ExitTenxt.setFill(Color.WHITE);  // กำหนดสีของข้อความเป็นสีขาว
//        AnchorPane.setTopAnchor(ExitTenxt, 240.0);
//        AnchorPane.setLeftAnchor(ExitTenxt, 820.0);
//        
//        
//        Text Home = new Text("HOME");
//        Font customFont1 = Font.loadFont(getClass().getResource("/fonts/PressStart2P.ttf").toExternalForm(), 35);  // เปลี่ยน path ให้เป็นฟอนต์ที่คุณต้องการ
//        Home.setFont(customFont1);  // กำหนดฟอนต์ที่ใช้กับข้อความ
//        Home.setFill(Color.WHITE);  // กำหนดสีของข้อความเป็นสีขาว
//        AnchorPane.setTopAnchor(Home, 615.0);
//        AnchorPane.setLeftAnchor(Home, 40.0);
//        
//        
//        ExitTenxt.setOnMouseEntered((MouseEvent e) -> {
//        	ExitTenxt.setFill(Color.RED);   // ลดความทึบให้ดูเหมือนเปลี่ยนสีเมื่อเมาส์ชี้
//        	
//        });
//        ExitTenxt.setOnMouseExited((MouseEvent e) -> {
//        	ExitTenxt.setFill(Color.WHITE);  // คืนค่าความทึบเป็นปกติ
//        	 
//        });
//        
//        ExitTenxt.setOnMouseClicked((MouseEvent e) -> {
//        	root.getChildren().removeAll(FrameTaxt,ExitTenxt);
//           
//        });
//        
//        Home.setOnMouseEntered((MouseEvent e) -> {
//        	Home.setOpacity(0.8);  // ลดความทึบให้ดูเหมือนเปลี่ยนสีเมื่อเมาส์ชี้
//    	     
//    });
//        Home.setOnMouseExited((MouseEvent e) -> {
//        	Home.setOpacity(1.0);  // คืนค่าความทึบเป็นปกติ
//    	    
//    });
//        
//        Home.setOnMouseClicked((MouseEvent e) -> {
//        	//โค้ดใช้เปลี่ยนฉาก
//        	
//        	showMainMenu2(primaryStage);
//        });
//        
//        
//        PauseTransition pause = new PauseTransition(Duration.seconds(2.0));
//        pause.setOnFinished(event -> {
//        	Font customFont9 = Font.loadFont(getClass().getResource("/fonts/PressStart2P.ttf").toExternalForm(), 15);  // เปลี่ยน path ให้เป็นฟอนต์ที่คุณต้องการ
//        	characterText.setFont(customFont9);  // กำหนดฟอนต์ที่ใช้กับข้อความ
//            Font customFont10 = Font.loadFont(getClass().getResource("/fonts/PressStart2P.ttf").toExternalForm(), 15);  // เปลี่ยน path ให้เป็นฟอนต์ที่คุณต้องการ
//            levelText.setFont(customFont10);  // กำหนดฟอนต์ที่ใช้กับข้อความ
//            
//            characterText.setFill(Color.YELLOW);
//            levelText.setFill(Color.YELLOW);
//            
//        	AnchorPane.setTopAnchor(characterText, 50.0);
//            AnchorPane.setLeftAnchor(characterText, 80.0);
//            AnchorPane.setTopAnchor(levelText, 90.0);
//            AnchorPane.setLeftAnchor(levelText, 80.0);
//            root.getChildren().remove(FrameTaxt);
//            root.getChildren().addAll(FrameTaxt,ExitTenxt);
//            // ลบข้อความต้อนรับเมื่อหมดเวลา
//            //root.getChildren().removeAll(characterText, levelText);
//           
//        });
//        pause.play();
//
//        // เพิ่มข้อความใน layout
//        root.getChildren().addAll(FrameTaxt,characterText, levelText,Home);
//
//        // สร้าง Scene สำหรับหน้าเกม
//        scene = new Scene(root, 1200, 700);
    }
	public Scene getScene() {
        return scene;
    }
	public static void showMainMenu2(Stage primaryStage) {
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
    
}