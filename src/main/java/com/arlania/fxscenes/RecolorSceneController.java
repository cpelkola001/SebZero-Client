package com.arlania.fxscenes;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.SwingUtilities;

import com.arlania.Client;
import com.arlania.FrameReader;
import com.arlania.JagexColor;
import com.arlania.Model;
import com.arlania.ModelUtil;
import com.arlania.SpotAnim;

/**
 * TODO: add documentation
 *
 * @author Stan van der Bend (https://www.rune-server.ee/members/StanDev/)
 * @version 1.0
 * @since 2019-02-01
 */
public class RecolorSceneController implements Initializable {

	public ListView<ColorWrapper> colors;

	private ObservableList<ColorWrapper> modelColors = FXCollections.observableArrayList();

	public Button loadModelColors;

	public Button save;
	public Button reset;
	public Button toggle;

	public Slider widthSlider;
	public Slider heightSlider;
	public Slider rotationSlider;

	public TextField gfxIdBox;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		SwingUtilities.invokeLater(() -> reset());

		loadModelColors.setOnAction(event -> readColors(modelColors));
		reset.setOnAction(event -> SwingUtilities.invokeLater(() -> reset()));
		save.setOnAction(event -> SwingUtilities.invokeLater(() -> save()));
		toggle.setOnAction(event -> {
			SwingUtilities.invokeLater(() -> {

				ModelUtil.keepPlaying = !ModelUtil.keepPlaying;
				if (ModelUtil.keepPlaying) {

					Client.myPlayer.anInt1520 = ModelUtil.spotAnim.getId();
				}

			});
		});
		rotationSlider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> var1, Number var2, Number var3) {
				SwingUtilities.invokeLater(() -> {
					ModelUtil.spotAnim.rotation = var3.intValue();
					SpotAnim.modelCache.clear();
				});
			}
		});
		widthSlider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> var1, Number var2, Number var3) {
				SwingUtilities.invokeLater(() -> {
					ModelUtil.spotAnim.setMultiplierWidth(var3.doubleValue());

				});
			}
		});
		heightSlider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> var1, Number var2, Number var3) {
				SwingUtilities.invokeLater(() -> {
					ModelUtil.spotAnim.setMultiplierHeight(var3.doubleValue());
				});
			}
		});
		gfxIdBox.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent var1) {
				if (var1.getCode().equals(KeyCode.ENTER)) {
					try {
						int id = Integer.parseInt(gfxIdBox.getText().trim());
						SwingUtilities.invokeLater(() -> {
							ModelUtil.setGFX(id);
							Client.myPlayer.anInt1520 = id;
							Client.myPlayer.currentAnim = 0;

							reset();
						});

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

		});
	}

	private void readColors(ObservableList<ColorWrapper> source) {
		colors.getItems().clear();
		colors.getItems().addAll(source);
	}

	private void readColorsFromModel() {
		modelColors.clear();

		Model model = ModelUtil.spotAnim.getModel();
		if (model.triangleColour != null) {
			for (Map.Entry<Integer, AtomicInteger> entry : ModelUtil.getModelColors(model)) {
				int color = entry.getKey();
				int dest[] = ModelUtil.spotAnim.destColours;
				if (dest != null) {
					for (int i = 0; i < dest.length; i++) {
						int dColor = dest[i];
						if (dColor == color) {
							color = ModelUtil.spotAnim.originalColours[i];
							System.out.println("Found a color");
						}
					}
				}

				modelColors.add(new ColorWrapper(ModelUtil.spotAnim, entry.getValue().get(), color, entry.getKey()));
			}
			System.out.println("Added " + modelColors.size() + " colors");
		} else
			System.out.println("Model colors: " + Arrays.toString(model.triangleColour));

	}

	private void save() {
		try {
			SpotAnim.saveCustomGFXes();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void reset() {
		colors.getItems().clear();
		if (ModelUtil.spotAnim != null) {

			if (ModelUtil.spotAnim.getModel() == null) {
				Client.myPlayer.anInt1520 = ModelUtil.spotAnim.getId(); // gfx id
				Client.myPlayer.currentAnim = 0; // current animation
				Client.myPlayer.animCycle = 0; // animation cycle
				if (FrameReader.animationlist[Integer.parseInt(
						Integer.toHexString(SpotAnim.cache[ModelUtil.spotAnim.getId()].animation.frameIDs[0]).substring(
								0, Integer.toHexString(SpotAnim.cache[ModelUtil.spotAnim.getId()].animation.frameIDs[0])
										.length() - 4),
						16)].length == 0) {
					Client.instance.onDemandFetcher
							.requestFileData(
									1, Integer
											.parseInt(
													Integer.toHexString(SpotAnim.cache[ModelUtil.spotAnim
															.getId()].animation.frameIDs[0])
															.substring(0, Integer
																	.toHexString(SpotAnim.cache[ModelUtil.spotAnim
																			.getId()].animation.frameIDs[0])
																	.length() - 4),
													16));
				}
				while (ModelUtil.spotAnim.getModel() == null) {
					System.out.println("Waiting on model to load!");
				}

			}
			readColorsFromModel();
			widthSlider.setValue(ModelUtil.spotAnim.multiplierWidth);
			heightSlider.setValue(ModelUtil.spotAnim.multiplierHeight);
			rotationSlider.setValue(ModelUtil.spotAnim.rotation);
		} else
			System.out.println("Please first select a gfx, ::selectgfx <id>");

	}

	private static Color convert(int hslColor) {
		return JagexColor.RS2HSB_to_RGB(hslColor);
	}

	private static int convert(Color color) {

		return JagexColor.RGB_to_RS2HSB((int) (color.getRed() * 255D), (int) (color.getGreen() * 255D),
				(int) (color.getBlue() * 255D));
	}

	private final class ColorWrapper extends HBox {

		final ColorPicker picker = new ColorPicker();
		final Button reset = new Button("reset");
		final SpotAnim definition;
		int initialColor;
		int targetColor;

		ColorWrapper(SpotAnim definition, int occurences, int initialColor, int targetColor) {
			this.initialColor = initialColor;
			this.targetColor = targetColor;
			this.definition = definition;
			getChildren().addAll(picker, reset, new Label("Occurences: " + occurences));
			picker.setValue(convert(targetColor));
			picker.setOnAction(event -> changeColor());
			reset.setOnAction(event -> resetValueToInitialColor());
		}

		void changeColor() {
			targetColor = convert(picker.getValue());
			System.out.println("Set color " + initialColor + " to " + convert(targetColor));
			SwingUtilities.invokeLater(() -> {
				definition.recolor(initialColor, targetColor);
				SpotAnim.modelCache.clear();
			});

		}

		void resetValueToInitialColor() {
			picker.setValue(convert(initialColor));
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;

			ColorWrapper wrapper = (ColorWrapper) o;

			if (initialColor != wrapper.initialColor)
				return false;
			return targetColor == wrapper.targetColor;
		}

		@Override
		public int hashCode() {
			int result = initialColor;
			result = 31 * result + targetColor;
			return result;
		}
	}

}
