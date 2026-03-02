package application;

import javafx.application.Application;
import javafx.animation.PauseTransition;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class Main extends Application { 
    private Stage primaryStage;
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
//        Assets assets = new Assets();
//        System.out.print(assets.GetBackgroundByName("background.png"));
        // สร้าง root ของ layout
        AnchorPane root = new AnchorPane();
        AnchorPane mainMenuRoot = new AnchorPane();
        Text mainMenuText = new Text("Main Menu");
        mainMenuText.setFont(Font.font(20));
        
        mainMenuRoot.getChildren().add(mainMenuText);
        //getClass().getResource("/background/bg_v_b.png").toExternalForm()
        ///resources
        // ใส่พื้นหลังให้กับหน้า
        Image backgroundImage = new Image(getClass().getResource("/background/bg_v_b.png").toExternalForm()); // ใส่ path ของภาพพื้นหลัง
        ImageView imageView = new ImageView(backgroundImage);
        imageView.setFitWidth(1200);  // กำหนดความกว้างของภาพพื้นหลัง
        imageView.setFitHeight(700);  // กำหนดความสูงของภาพพื้นหลัง
        root.getChildren().add(imageView);  // เพิ่มภาพพื้นหลังใน layout
        
        //getClass().getResource("/fonts/PressStart2P.ttf").toExternalForm()
        Font customFont4 = Font.loadFont(getClass().getResource("/fonts/PressStart2P.ttf").toExternalForm(), 50);  // ใส่ path ของฟอนต์
        Text welcomeText1 = new Text("Welcome!");
        welcomeText1.setFont(customFont4);  // ใช้ฟอนต์ที่โหลด
        welcomeText1.setFill(Color.YELLOW);  // กำหนดสีข้อความเป็นสีขาว

        // ตั้งตำแหน่งของข้อความ
        AnchorPane.setTopAnchor(welcomeText1, 180.0);
        AnchorPane.setLeftAnchor(welcomeText1, 400.0);
        
        
        // โหลดฟอนต์ของเกม
        Font customFont = Font.loadFont(getClass().getResource("/fonts/PressStart2P.ttf").toExternalForm(), 60);  // ใส่ path ของฟอนต์
        Text welcomeText = new Text("Gold Jump");
        welcomeText.setFont(customFont);  // ใช้ฟอนต์ที่โหลด
        welcomeText.setFill(Color.WHITE);  // กำหนดสีข้อความเป็นสีขาว

        // ตั้งตำแหน่งของข้อความ
        AnchorPane.setTopAnchor(welcomeText, 200.0);
        AnchorPane.setLeftAnchor(welcomeText, 320.0);
        //getClass().getResource("Lovepik_com-380332881-brown-pixel-art-text-box-dialog-black-frame.png").toExternalForm()
        ImageView UserFrame = new ImageView(new Image(getClass().getResource("/object/other/Lovepik_com-380332881-brown-pixel-art-text-box-dialog-black-frame.png").toExternalForm()));
        UserFrame.setFitWidth(600);  // กำหนดความกว้างของปุ่ม
        UserFrame.setFitHeight(350);  // กำหนดความสูงของปุ่ม
        
        AnchorPane.setTopAnchor(UserFrame, 200.0);
        AnchorPane.setLeftAnchor(UserFrame, 270.0);
        
        
        // ตั้งข้อความ
        Text instructionText = new Text("Enter Your Name");
        Font customFont1 = Font.loadFont(getClass().getResource("/fonts/PressStart2P.ttf").toExternalForm(), 20);  // เปลี่ยน path ให้เป็นฟอนต์ที่คุณต้องการ
        instructionText.setFont(customFont1);  // กำหนดฟอนต์ที่ใช้กับข้อความ
        instructionText.setFill(Color.WHITE);  // กำหนดสีของข้อความเป็นสีขาว
     
        
        AnchorPane.setTopAnchor(instructionText, 289.0);
        AnchorPane.setLeftAnchor(instructionText, 445.0);
        
        // สร้าง TextField สำหรับกรอกชื่อ
        TextField nameField = new TextField();
        nameField.setPromptText("Enter a name (at least 6 characters, no special characters)"); 
        nameField.setFont(Font.font("Arial", 20));
        nameField.setStyle("-fx-background-color: white; -fx-text-fill: black;");
        AnchorPane.setTopAnchor(nameField, 360.0);
        AnchorPane.setLeftAnchor(nameField, 405.0);
        nameField.setPrefWidth(380);


        // สร้างปุ่มตกลง
        Button DoneButton = new Button("Done");
        Font customFont3 = Font.loadFont(getClass().getResource("/fonts/PressStart2P.ttf").toExternalForm(), 25);  // เปลี่ยน path ให้เป็นฟอนต์ที่คุณต้องการ
        DoneButton.setFont(customFont3);  // กำหนดฟอนต์ที่ใช้กับข้อความ
        //DoneButton.setTextFill(Color.WHITE);  // กำหนดสีของข้อความเป็นสีขาว
        AnchorPane.setTopAnchor(DoneButton, 450.0);
        AnchorPane.setLeftAnchor(DoneButton, 522.0);
        
        DoneButton.setOnMouseEntered((MouseEvent e) -> {
        	DoneButton.setOpacity(0.7);  // ลดความทึบให้ดูเหมือนเปลี่ยนสีเมื่อเมาส์ชี้
            //buttonText.setOpacity(0.7);
        });
        DoneButton.setOnMouseExited((MouseEvent e) -> {
        	DoneButton.setOpacity(1.0);  // คืนค่าความทึบเป็นปกติ
            //buttonText.setOpacity(1.0);
        });
        
        

        // สร้างข้อความแจ้งเตือน
        Text errorText = new Text();
        //errorText.setFont(Font.font("Arial", 18));
        errorText.setFill(Color.RED);
        Font customFont5 = Font.loadFont(getClass().getResource("/fonts/PressStart2P.ttf").toExternalForm(), 14);  // เปลี่ยน path ให้เป็นฟอนต์ที่คุณต้องการ
        errorText.setFont(customFont5);  // กำหนดฟอนต์ที่ใช้กับข้อความ
        AnchorPane.setTopAnchor(errorText, 295.0);
        AnchorPane.setLeftAnchor(errorText, 110.0);

        // สร้างข้อความต้อนรับ
        Text welcomeText2 = new Text();
        welcomeText2.setFont(Font.font("Arial", 30));  
        welcomeText2.setFill(Color.WHITE);
        AnchorPane.setTopAnchor(welcomeText2, 300.0);
        AnchorPane.setLeftAnchor(welcomeText2, 400.0);

        
        //getClass().getResource("%E2%80%94Pngtree%E2%80%94button%20game_6976878.png").toExternalForm()
        ImageView startButton1 = new ImageView(new Image(getClass().getResource("/object/other/—Pngtree—button game_6976878.png").toExternalForm()));  // เปลี่ยน path ให้เป็นภาพปุ่ม Start
        ImageView exitButton1 = new ImageView(new Image(getClass().getResource("/object/other/—Pngtree—button game_6976878.png").toExternalForm()));  // เปลี่ยน path ให้เป็นภาพปุ่ม Exit

        // ตั้งขนาดของปุ่ม
        startButton1.setFitWidth(300);  // กำหนดความกว้างของปุ่ม
        startButton1.setFitHeight(200);  // กำหนดความสูงของปุ่ม
        exitButton1.setFitWidth(300);  // กำหนดความกว้างของปุ่ม
        exitButton1.setFitHeight(200);  // กำหนดความสูงของปุ่ม
        
     // สร้างข้อความสำหรับปุ่ม
        Text buttonText = new Text("PLAY");
        Font customFont6 = Font.loadFont(getClass().getResource("/fonts/PressStart2P.ttf").toExternalForm(), 25);  // เปลี่ยน path ให้เป็นฟอนต์ที่คุณต้องการ
        buttonText.setFont(customFont6);  // กำหนดฟอนต์ที่ใช้กับข้อความ
        buttonText.setFill(Color.WHITE);  // กำหนดสีของข้อความเป็นสีขาว
        
        Text buttonText1 = new Text("EXIT");
        Font customFont2 = Font.loadFont(getClass().getResource("/fonts/PressStart2P.ttf").toExternalForm(), 25);  // เปลี่ยน path ให้เป็นฟอนต์ที่คุณต้องการ
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
     // ตรวจสอบชื่อเมื่อกรอกและกดปุ่มตกลง
        DoneButton.setOnAction(e -> {
            String name = nameField.getText();
            if (isValidName(name)) {
                // ถ้าชื่อถูกต้อง
                errorText.setText("");  // ลบข้อความแจ้งเตือน
                welcomeText1.setText("Welcome " + name + " !");  // แสดงข้อความต้อนรับ
                
                
                // ลบ TextField และปุ่ม Submit
                root.getChildren().removeAll(nameField,UserFrame, DoneButton, instructionText,welcomeText1);
                AnchorPane.setTopAnchor(welcomeText1, (root.getHeight() - welcomeText1.getBoundsInLocal().getHeight()) / 2);
                AnchorPane.setLeftAnchor(welcomeText1, (root.getWidth() - welcomeText1.getBoundsInLocal().getWidth()) / 2);
                root.getChildren().addAll(welcomeText1);
                PauseTransition pause = new PauseTransition(Duration.seconds(1.75));
                pause.setOnFinished(event -> {
                    // ลบข้อความต้อนรับเมื่อหมดเวลา
                    root.getChildren().remove(welcomeText1);
                    root.getChildren().addAll(welcomeText, startButton1, buttonText, exitButton1,buttonText1);
                });
                pause.play();
               
                
            } else {
                // ถ้าชื่อไม่ถูกต้อง
            	AnchorPane.setTopAnchor(instructionText, 260.0);
                AnchorPane.setLeftAnchor(instructionText, 445.0);
                errorText.setText("Invalid name! Must be at least 6 characters and no special characters.");
            }
        });

        // เพิ่มทุกสิ่งลงใน root
        root.getChildren().addAll(UserFrame,instructionText, nameField, DoneButton, errorText,welcomeText1);


        

        // สร้าง Scene
        Scene scene = new Scene(root, 1200, 700);

        // ตั้งค่า Scene เริ่มต้นเป็นหน้าหลัก
        primaryStage.setTitle("Gold Jump Game");
        primaryStage.setScene(scene);
        primaryStage.show();

		
    }
    public static void main(String[] args) {
        launch(args);
    }
	public static void showMainMenu(Stage primaryStage2) {
		// TODO Auto-generated method stub
		
	}
	public void showMainMenu() {
	    start(primaryStage); // เรียก start อีกครั้งเพื่อรีเซ็ตกลับไปหน้าเมนู
	}
	public void start1(Stage primaryStage) {
	    // ตั้งค่า primaryStage
	    GameScene gameScene = new GameScene(primaryStage, "CharacterName", "Easy",null);
	    primaryStage.setScene(gameScene.getScene());
	    primaryStage.show();
	}
    private boolean isValidName(String name) {
        // ตรวจสอบว่าชื่อมีความยาวอย่างน้อย 6 ตัว และไม่มีตัวอักษรพิเศษ
        return name.length() >= 6 && name.matches("[A-Za-z0-9]+");
    }

}
