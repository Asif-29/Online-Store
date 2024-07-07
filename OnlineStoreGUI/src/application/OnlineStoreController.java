
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
public class OnlineStoreController {

	@FXML
	
	public void Admin(ActionEvent event)throws IOException{
		System.out.println("Welcome OnlineStore");
		//To hide the current window
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.hide();
		//New Window
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("AdminHome.fxml"));
		//Parent root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setTitle("Admin Home");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void User(ActionEvent event)throws IOException{
		System.out.println("Welcome OnlineStore");
		//To hide the current window
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.hide();
		//New Window
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("UserHome.fxml"));
		//Parent root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setTitle("User Home");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}