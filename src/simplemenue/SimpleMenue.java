package simplemenue;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SimpleMenue extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Title section
        Text restaurantTitle = new Text("McDonald's");
        restaurantTitle.setFont(Font.font("Arial", FontWeight.BOLD, 36));
        restaurantTitle.setFill(javafx.scene.paint.Color.ORANGE);
        
        // Logo section
        Image logoImage = new Image("file:/Users/rayanbawazeer/Library/Mobile Documents/com~apple~CloudDocs/AlYamamah/4.SWE312/Lab/Lab3/hamburger.jpg");  
        ImageView logoImageView = new ImageView(logoImage);
        logoImageView.setFitWidth(100);  
        logoImageView.setPreserveRatio(true);
        
        HBox titleBox = new HBox();
        titleBox.getChildren().addAll(restaurantTitle, logoImageView);
        
        // Form title
        Text formTitle = new Text("Please fill the form below to place your order:");
        
        // Name fields
        Text nameLabel = new Text("NAME:");
        nameLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 14));
        TextField firstNameField = new TextField();
        TextField lastNameField = new TextField();
        
        HBox nameBox = new HBox(10);
        nameBox.getChildren().addAll(nameLabel, firstNameField, lastNameField);
        
        // Chicken Mac section
        Text chickenMacLabel = new Text("Chicken Mac");
        TextField chickenMacQuantity = new TextField();
        Text chickenMacPrice = new Text("$5");
        
        HBox chickenMacBox = new HBox();
        chickenMacBox.getChildren().addAll(chickenMacLabel, chickenMacQuantity, chickenMacPrice);

        // Big Mac section
        Text bigMacLabel = new Text("Big Mac");
        TextField bigMacQuantity = new TextField();
        Text bigMacPrice = new Text("$7");
        
        HBox bigMacBox = new HBox();
        bigMacBox.getChildren().addAll(bigMacLabel, bigMacQuantity, bigMacPrice);

        // Cheese Burger section
        Text cheeseBurgerLabel = new Text("Cheese Burger");
        TextField cheeseBurgerQuantity = new TextField();
        Text cheeseBurgerPrice = new Text("$4");
        
        HBox cheeseBurgerBox = new HBox();
        cheeseBurgerBox.getChildren().addAll(cheeseBurgerLabel, cheeseBurgerQuantity, cheeseBurgerPrice);

        // Special requests
        Text specialRequestLabel = new Text("Special requests:");
        specialRequestLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 14));
        TextArea specialRequestArea = new TextArea();
        specialRequestArea.setPrefSize(300, 250);
        VBox.setVgrow(specialRequestArea, Priority.NEVER);
        
        // Bill output
        Text billText = new Text();

        // Order button
        Button orderButton = new Button("ORDER");
        orderButton.setFont(Font.font("Times New Roman", FontWeight.BOLD, 14));
        
        HBox orderBox = new HBox();
        orderBox.getChildren().add(orderButton);
        orderBox.setAlignment(Pos.CENTER);

        // Order action
        orderButton.setOnAction(event -> {
            double totalAmount = 0;

            // Calculate totals
            if (!chickenMacQuantity.getText().isEmpty()) {
                double chickenMacTotal = Double.parseDouble(chickenMacQuantity.getText()) * 5;
                totalAmount += chickenMacTotal;
            }
            if (!bigMacQuantity.getText().isEmpty()) {
                double bigMacTotal = Double.parseDouble(bigMacQuantity.getText()) * 7;
                totalAmount += bigMacTotal;
            }
            if (!cheeseBurgerQuantity.getText().isEmpty()) {
                double cheeseBurgerTotal = Double.parseDouble(cheeseBurgerQuantity.getText()) * 4;
                totalAmount += cheeseBurgerTotal;
            }

            // Display the bill
            billText.setText("Thank you " + firstNameField.getText() + " " + lastNameField.getText() +
                              " for shopping with us.\nSpecial requests: " + specialRequestArea.getText() +
                              "\nSubtotal: $" + String.format("%.2f", totalAmount));
            billText.setFill(javafx.scene.paint.Color.RED);
        });
        
        // Main layout
        VBox mainLayout = new VBox(10);
        mainLayout.getChildren().addAll(titleBox, formTitle, nameBox, chickenMacBox, bigMacBox, cheeseBurgerBox, specialRequestLabel, specialRequestArea, billText, orderBox);
        mainLayout.setPadding(new Insets(10));
        
        // Scene setup
        Scene scene = new Scene(mainLayout, 600, 550);

        primaryStage.setTitle("McDonald's Order Form");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
