
//@author Md. Asif Hassan | CSE

package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//import javafx.scene.layout.StackPane;
//import javafx.scene.layout.BorderPane;
//import javafx.stage.Stage;

public  class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("OnlineStore.fxml"));
			//StackPane root = new StackPane();//layout
			//Parent root = loader.load();
			Scene scene = new Scene(root);
			//root.getController();
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Md. Asif Hassan");
			primaryStage.setScene(scene);
			primaryStage.show();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}