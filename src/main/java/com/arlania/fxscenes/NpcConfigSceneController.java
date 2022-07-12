package com.arlania.fxscenes;

import java.net.URL;
import java.util.ResourceBundle;

import com.arlania.Client;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class NpcConfigSceneController implements Initializable {

	@FXML
	private Button saveButton, setCurrentPositionButton;

	@FXML
	private TextField npcIdField, directionField, xPositionField, yPositionField, zPositionField, coordinateField,
			radiusField;

	private final Client instance = Client.instance;

	@FXML
	private MenuItem northMenu, northEastMenu, northWestMenu, southMenu, southEastMenu, southWestMenu, eastMenu,
			westMenu;

	private int direction = 0;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		instance.npcEditing = true;
		
		handleMenus();
		
		instance.sendNpcConfigPacket(1, 1, 1, 1, 1, true, 1);
		
		setCurrentPositionButton.setOnMouseClicked(x -> {
			final int xPos = Client.getBaseX() + (Client.myPlayer.x - 6 >> 7);
			final int yPos = Client.getBaseY() + (Client.myPlayer.y - 6 >> 7);
			final int height = instance.plane;
			xPositionField.setText(String.valueOf(xPos));
			yPositionField.setText(String.valueOf(yPos));
			zPositionField.setText(String.valueOf(height));
		});

		saveButton.setOnMouseClicked(x -> {
			final int npcId = Integer.parseInt(npcIdField.getText());
			final int xPos = Integer.parseInt(xPositionField.getText());
			final int yPos = Integer.parseInt(yPositionField.getText());
			final int zPos = Integer.parseInt(zPositionField.getText());
			final boolean coordinate = Boolean.parseBoolean(coordinateField.getText());
			final int radius = Integer.parseInt(radiusField.getText());
			instance.sendNpcConfigPacket(npcId, direction, xPos, yPos, zPos, coordinate, radius);
		});

	}

	private void handleMenus() { // ULTIMATE SHIT CODE, but cba

		northMenu.setOnAction(x -> {
			directionField.setText("NORTH");
			direction = 1;
		});
		northEastMenu.setOnAction(x -> {
			directionField.setText("NORTH_EAST");
			direction = 2;
		});
		northWestMenu.setOnAction(x -> {
			directionField.setText("NORTH_WEST");
			direction = 0;
		});
		southMenu.setOnAction(x -> {
			directionField.setText("SOUTH");
			direction = 6;
		});
		southEastMenu.setOnAction(x -> {
			directionField.setText("SOUTH_EAST");
			direction = 7;
		});
		southWestMenu.setOnAction(x -> {
			directionField.setText("SOUTH_WEST");
			direction = 5;
		});
		eastMenu.setOnAction(x -> {
			directionField.setText("EAST");
			direction = 4;
		});
		westMenu.setOnAction(x -> {
			directionField.setText("WEST");
			direction = 3;
		});

	}

}
