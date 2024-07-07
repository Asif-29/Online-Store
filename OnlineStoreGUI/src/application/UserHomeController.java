
//@author Md. Asif Hassan | CSE

package application;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;
public class UserHomeController {

	@FXML
	
	public void Electronics (ActionEvent event)throws IOException{
		System.out.println("Welcome To Home");
		//To hide the current window
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.hide();
		//New Window
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("Electronics.fxml"));
		//Parent root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setTitle("Add Product To Store");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	public void Clothing (ActionEvent event)throws IOException{
		System.out.println("Welcome To Home");
		//To hide the current window
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.hide();
		//New Window
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("Clothing.fxml"));
		//Parent root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setTitle("Add Product To Store");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	public void FoodItem (ActionEvent event)throws IOException{
		System.out.println("Welcome To Home");
		//To hide the current window
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.hide();
		//New Window
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("FoodItem.fxml"));
		//Parent root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setTitle("Add Product To Store");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void AddCarT (ActionEvent event)throws IOException{
		System.out.println("Welcome To Home");
		//To hide the current window
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.hide();
		//New Window
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("CarT.fxml"));
		//Parent root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setTitle("Add Product To Store");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void AddBack (ActionEvent event)throws IOException{
		System.out.println("Welcome To Home");
		//To hide the current window
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.hide();
		//New Window
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("OnlineStore.fxml"));
		//Parent root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setTitle("Add Product To Store");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
}
