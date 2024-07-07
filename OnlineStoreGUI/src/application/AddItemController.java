
//@author Md. Asif Hassan | CSE

package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddItemController {
	
	public void AddBack (ActionEvent event)throws IOException{
		System.out.println("Welcome To Home");
		//To hide the current window
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.hide();
		//New Window
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("AdminHome.fxml"));
		//Parent root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setTitle("Add Product To Store");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
