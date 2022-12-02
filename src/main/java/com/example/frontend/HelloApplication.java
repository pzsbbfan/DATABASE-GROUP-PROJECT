package com.example.frontend;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static int idproduct;
    public static int idcustomer;
    public static int salesid;
    public static String shipstatus;
    @Override
    public void start(Stage stage) throws IOException {
        GridPane root = new GridPane();
        root.setVgap(5);
        root.setHgap(10);
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        VBox vBoxfield = new VBox();
        HBox hBox = new HBox();
        Button display = new Button("Display Order Details!");
        Button placeOrder = new Button("Place Order");
        Button sales = new Button("Display Sales Info");
        TextArea textArea = new TextArea();
        TextArea salesArea = new TextArea();

        Label productID = new Label("IDPRODUCT: ");
        Label IDcustomer = new Label("IDCUSTOMER: ");
        Label SalesID = new Label("SALESID: ");
        Label STATUS = new Label("SHIPSTATUS: ");

        TextField P_ID = new TextField();
        TextField cus_id = new TextField();
        TextField sales_id = new TextField();
        TextField ship_status = new TextField();
        vbox.getChildren().addAll(productID,IDcustomer,SalesID,STATUS);
        vBoxfield.getChildren().addAll(P_ID,cus_id,sales_id,ship_status);
        hBox.getChildren().addAll(vbox,vBoxfield);

        display.setOnAction(e ->{
            textArea.setText(Database.getData());
        });
        sales.setOnAction(event -> {
            salesArea.setText(Database.getSales());
        });

        placeOrder.setOnAction(event -> {
            idproduct = Integer.parseInt(P_ID.getText());
            idcustomer = Integer.parseInt(cus_id.getText());
            salesid = Integer.parseInt(sales_id.getText());
            shipstatus = ship_status.getText();
            Database.updateData();
            System.out.println("Data Updated!");
        });
        root.add(hBox,0,0);
        root.add(placeOrder,0,1);
        root.add(display,0,2);
        root.add(textArea,0,3);
        root.add(sales,0,4);
        root.add(salesArea,0,5);



        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}