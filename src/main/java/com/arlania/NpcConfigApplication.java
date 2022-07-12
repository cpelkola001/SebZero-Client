package com.arlania;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class NpcConfigApplication extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		
			String resourcePath = "fxscenes/NpcConfigScene.fxml";
			URL location = getClass().getResource(resourcePath);
			FXMLLoader loader = new FXMLLoader(location);
			try {
				stage.setTitle("Simple npc spawn config editor");
				Scene scene = new Scene(loader.load());
				scene.getStylesheets().add("modena_dark.css");
				stage.setScene(scene);
				stage.show();
				stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				    @Override
				    public void handle(WindowEvent t) {
				    	System.out.println("Exiting cuz i like k");
				        Platform.exit();
				        Client.instance.npcEditing = false;
				        Client.instance.sendNpcConfigPacket(1, 1, 1, 1, 5, false, 1);
				       // System.exit(0); - Cant do that because, its integrated with the client, which will also exit the client.
				    }
				});
				
				
				
				
			} catch (IOException e) {
				e.printStackTrace();
				Platform.exit();
			}
	
	}

}
