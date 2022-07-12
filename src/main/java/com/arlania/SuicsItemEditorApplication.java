package com.arlania;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SuicsItemEditorApplication extends Application{

	@Override
	public void start(Stage arg0) throws Exception {
		
			String resourcePath = "fxscenes/ItemEditorScene.fxml";
			URL location = getClass().getResource(resourcePath);
			FXMLLoader loader = new FXMLLoader(location);
			try {
				arg0.setTitle("Milo's def editor");
				Scene scene = new Scene(loader.load());
				arg0.setScene(scene);
				scene.getStylesheets().add("modena_dark.css");
				arg0.show();
			} catch (IOException e) {
				e.printStackTrace();
				Platform.exit();
			}
	
	}

}
