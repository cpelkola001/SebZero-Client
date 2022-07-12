package com.arlania.fxscenes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.SwingUtilities;
import com.arlania.Client;
import com.arlania.ItemDef;
import com.arlania.JagexColor;
import com.arlania.Model;
import com.arlania.ModelUtil;
import com.arlania.NPCDef;
import com.arlania.ParticleDefinition;
import com.arlania.Player;
import com.arlania.RSInterface;
import com.arlania.signlink;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.control.ListCell;

/**
 * 
 * @author Suic
 * TODO: improve most of the code(and use MVC)
 */

public class DefEditorSceneController implements Initializable {

	
	
	@FXML
	private Button confirmChangesButton, loadModelColors, saveButton, saveButton1, defaultsButton, loadNpcColorsButton, saveNpcDataButton,
	resetNpcData;
	
	@FXML
	private Slider zoomSlider, xRotationSlider, yRotationSlider, opacitySlider, xAngleSlider, yAngleSlider, zAngleSlider, 
	xOffsetMSlider, yOffsetMSlider, yOffsetFSlider;
	
	@FXML
	private TextField zoomTextField, xRotationTextField, yRotationTextField, changeIDTextField, opacityTextField,
	yAngleTextField, xAngleTextField, zAngleTextField, textureField1, textureField2, textureField3, particleHexField, particleIndexField,
	invModelTextField, maleEquipTextField, femaleEquipTextField, xOffsetMTextField, yOffsetMTextField, yOffsetFTextField,
	runAnimField, standAnimField, walkAnimField, xzSizeField, ySizeField, npcModelsField, drawDotField, renderPriField, headIconField,
	combatLvlField, nameField, squaresNeededField, npcIdField;
	
	@FXML
	private Label zoomLabel, rotationXLabel, rotationYLabel, opacityLabel, xAngleLabel, yAngleLabel, zAngleLabel, xOffsetMLabel, yOffsetMLabel, 
	yOffsetFLabel, invModelLabel, maleEquipLabel, femaleEquipLabel;

	/**
	 * these 3 variables r used in getEquipModel method.
	 */
	public static int xValue = 0;
	public static int yValue = 0;
	public static int zValue = 0;

	ItemDef def = ItemDef.forID(Client.currentlyEditedItemId);
	
	private int defaultInvModel = def.modelID;
	private int defaultMaleModel = def.maleEquip1;
	private int defaultFemaleModel = def.femaleEquip1;
	private int defaultZoom = def.modelZoom;
	private int defaultRotationX = def.rotationX;
	private int defaultRotationY = def.rotationY;
	private int defaultOpacity = def.shadow;
	private int[] defaultModelColors = def.originalModelColors;
	private byte defaultMaleXOffset = def.maleXOffset;
	private byte defaultMaleYOffset = def.maleYOffset;
	private byte defaultFemaleYOffset = def.femaleYOffset;
	

	
	
	public ColorPicker particleColorPicker = new ColorPicker();

	public ListView<ColorWrapper> colors = new ListView<>();
	
	
	@FXML
	public ListView<ColorWrapper> npcColorsListView;

	public ListView<ColorWrapper> remainingColorsListView = new ListView<>();

	public ListView<Integer> modelListView = new ListView<>();
	@FXML
	private ImageView itemImageView;

	private ObservableList<ColorWrapper> modelColors = FXCollections.observableArrayList();
	
	private ObservableList<ColorWrapper> npcModelColors = FXCollections.observableArrayList();

	private Color convert(int hslColor) {
		return JagexColor.RS2HSB_to_RGB(hslColor);
	}

	private int convert(Color color) {

		return JagexColor.RGB_to_RS2HSB((int) (color.getRed() * 255D), (int) (color.getGreen() * 255D),
				(int) (color.getBlue() * 255D));
	}

	private void readColors(ObservableList<ColorWrapper> source) {
		colors.setItems(source);
	}
	
	private void readNpcColors(ObservableList<ColorWrapper> source) {
		npcColorsListView.setItems(source);
	}

	private void readRemainingColors(ObservableList<ColorWrapper> source) { // TODO
		remainingColorsListView.setItems(source);
	}
	
	NPCDef npcDef = NPCDef.forID(1);
	
	private int defaultRunAnim = npcDef.runAnim;
	private int defaultStandAnim = npcDef.standAnim;
	private int defaultWalkAnim = npcDef.walkAnim;
	private int defaultXZSize = npcDef.sizeXZ;
	private int defaultYSize = npcDef.sizeY;
	private int[] defaultNpcModels = npcDef.models;
	private boolean defaultDrawDotSetting = npcDef.drawMinimapDot;
	private boolean defaultRenderPri = npcDef.hasRenderPriority;
	private int defaultHeadIcon = npcDef.headIcon;
	private int defaultCombatLvl = npcDef.combatLevel;
	private String defaultNpcName = npcDef.name;
	private byte defaultSquaresNeeded = npcDef.squaresNeeded;
	private int[] defaultNpcColors = npcDef.originalColours;
	private int[] defaultDestColors = npcDef.destColours;



	private List<Integer> colorList = new ArrayList<>();
	private List<Integer> npcColorList = new ArrayList<>();

	private int[] colorArray;
	private int[] npcColorArray;

	private void reset() {
		colorList.clear();
		colors.getItems().clear();
		ItemDef itemDef = ItemDef.forID(Client.currentlyEditedItemId);
		itemDef.originalModelColors = null;
		itemDef.newModelColor = null;
		colorArray = null;
		readColorsFromModel();

	}
	
	private void resetNpcData() {
		npcColorList.clear();
		npcColorsListView.getItems().clear();
		npcDef.originalColours = null;
		npcDef.destColours = null;
		npcColorArray = null;
		readNpcColorsFromModel();
	}
	
	
	private int currentlyEditedIndex = -1;

	private final int[] textureIds = { 24, 40, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68,
			69, 70, 71, 72, 73, 74, 75 };
	private List<Integer> foundTextures = new ArrayList<>();

	private void retexture(int index) {
		int originalId = foundTextures.get(index);
		int targetId = Integer.parseInt(fields[index].getText());
		def.originalModelColors[index] = originalId;
		System.out.println("At index: " + def.originalModelColors[index]);
		System.out.println("Just original: " + originalId);
		def.newModelColor[index] = targetId;
		clearCaches();
		textureField1.clear();
		textureField1.setPromptText("Current texture id: " + targetId);
		System.out.println("Changed from texture: " + originalId + " to " + targetId);
	}

	private void clearCaches() {
		ItemDef.spriteCache.clear();
		ItemDef.modelCache.clear();
		Player.modelCache.clear();
	}

	private void fetchTextures() {
		System.out.println("Starting array: " + colorList);
		for (int textures : textureIds) {
			if (colorList.contains(textures)) {
				foundTextures.add(textures);
				colorList.remove(colorList.indexOf(textures));
			}
		}
		System.out.println("Ending array " + colorList);
	}
	int color = 0;
	int npcColor = 0;
	private void readColorsFromModel() {
		modelColors.clear();
		Model model = new Model(def.modelID);
		if (model.triangleColour != null) {
			for (Map.Entry<Integer, AtomicInteger> entry : ModelUtil.getModelColors(model)) {
				color = entry.getKey();
				int dest[] = def.newModelColor;
				if (dest != null) {
					for (int i = 0; i < dest.length; i++) {
						int dColor = dest[i];
						if (dColor == color) {
							color = def.originalModelColors[i];
							System.out.println("Found a color");
						}
					}
				}
				/**
				 * TODO: redo this part later (awfully done even tho it works)
				 */
				colorList.add(color);
				colorArray = new int[colorList.size()];
				for (int i = 0; i < colorArray.length; i++) {
					colorArray[i] = colorList.get(i);
					def.originalModelColors = colorArray;
					def.newModelColor = new int[colorArray.length]; // TODO edit this later aswell
				}
					if (!Arrays.stream(textureIds).anyMatch(x -> x == color)) {
						modelColors.add(new ColorWrapper(def, entry.getValue().get(), color, entry.getKey()));
					}
			}
			System.out.println("Original colors components: " + Arrays.toString(def.originalModelColors));
		} else
			System.out.println("Model colors: " + Arrays.toString(model.triangleColour));

	}
	
	private void readNpcColorsFromModel() {
		npcModelColors.clear();
		int[] models = npcDef.models;
		
		System.out.println("npc models: " + Arrays.toString(models));
		
		System.out.println("Npc id: " + npcDef.id);
		
		//System.out.println();
		
		for(int x = 0; x < models.length; x++) {
			Model model = new Model(models[x]);
			
			System.out.println("Fetching for model: " + model.getModelId());
			System.out.println("That models triangle colors: " + Arrays.toString(model.triangleColour));
			
			if(model.triangleColour != null) {
				for (Map.Entry<Integer, AtomicInteger> entry : ModelUtil.getModelColors(model)) {
					npcColor = entry.getKey();
					int[] npcDest = npcDef.destColours;
					if(npcDest != null) {
						for(int i = 0; i < npcDest.length; i++) {
							int npcDColor = npcDest[i];
							if(npcDColor == npcColor) {
							npcColor = npcDef.originalColours[i];
						//	System.out.println("Found a color: " + color);
							}
						}
					}
					
					// new stuff here
					npcColorList.add(npcColor);
					npcColorArray = new int[npcColorList.size()];
					for(int i = 0; i < npcColorArray.length; i++) {
						npcColorArray[i] = npcColorList.get(i);
						npcDef.originalColours = npcColorArray;
						npcDef.destColours = new int[npcColorArray.length];
					}
					
					// more new stuff
					npcModelColors.add(new ColorWrapper(npcDef, entry.getValue().get(), npcColor, entry.getKey()));
					
				}
				System.out.println("Original npc color components: " + Arrays.toString(npcDef.originalColours));
			}
			
		}
	}

	TextField[] fields = null;
	
	private void changeParticleColor(Color color) {
		int rgb = (int) (color.getRed() * 1 * 255);
		rgb = (rgb << 8) + (int) (color.getGreen() * 255);
		rgb = (rgb << 8) + (int)(color.getBlue() * 255);
		ParticleDefinition.cache[currentlyEditedIndex].setStartColor(rgb);
		particleHexField.setText("0x" + Integer.toHexString(rgb));
	}
	
	private final static Gson GSON = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
            .setPrettyPrinting()
            .create();
    
    private final static Type TYPE = new TypeToken<HashSet<ItemDef>>() {}.getType();
    private final static Type NPC_TYPE = new TypeToken<HashSet<NPCDef>>() {}.getType();
    
    public static Set<ItemDef> customItems = new HashSet<>();
    
    public static Set<NPCDef> customNpcs = new HashSet<>();
    
    static final Path PATH = Paths.get(signlink.findcachedir() + "customitems.json");
    static final Path NPC_PATH = Paths.get(signlink.findcachedir() + "customnpcs.json");
    
    public final static void loadCustomItems() throws FileNotFoundException { //TODO - Rest
        
       final File file = PATH.toFile();
        
       final FileReader reader = new FileReader(file);
        
        
        Set<ItemDef> items = GSON.fromJson(reader, TYPE);
        
        
        
        if(items == null) {
            return;
        }
 
        
        customItems.addAll(items);
        
        System.out.println(customItems.size());
        
        for(ItemDef def : items) {
           
            ItemDef cItem = ItemDef.forID(def.id);
          //  System.out.println("Model zoom from cItem: " + cItem.modelZoom);
           // System.out.println("From def: " + def.modelZoom);
            cItem.modelZoom = def.modelZoom;
            cItem.rotationX = def.rotationX;
            cItem.rotationY = def.rotationY;
            cItem.shadow = def.shadow;
            cItem.originalModelColors = def.originalModelColors;
            cItem.newModelColor = def.newModelColor;
            cItem.modelID = def.modelID;
            cItem.maleEquip1 = def.maleEquip1;
            cItem.femaleEquip1 = def.femaleEquip1;
            cItem.maleXOffset = def.maleXOffset;
            cItem.maleYOffset = def.maleYOffset;
            cItem.femaleYOffset = def.femaleYOffset;
            
          //  System.out.println("C item modelzoom: " + cItem.modelZoom);
          //  System.out.println("Def modelzoom: " + def.modelZoom);
          //  System.out.println("def id: " + def.id);
              //System.out.println("cItem id: " + cItem.id);;  
            
        }
        
    }
    
    public final static void loadCustomNpcs() throws FileNotFoundException { //TODO - Rest
        
        final File file = NPC_PATH.toFile();
         
        final FileReader reader = new FileReader(file);
         
         
         Set<NPCDef> npcs = GSON.fromJson(reader, NPC_TYPE);
         
         
         
         if(npcs == null) {
             return;
         }
  
         
         customNpcs.addAll(npcs);
         
         System.out.println(customNpcs.size());
         
         for(NPCDef npcDef : npcs) {
            
             NPCDef customNpc = NPCDef.forID(npcDef.id);
             customNpc.runAnim = npcDef.runAnim;
             customNpc.standAnim = npcDef.standAnim;
             customNpc.walkAnim = npcDef.walkAnim;
             customNpc.sizeXZ = npcDef.sizeXZ;
             customNpc.sizeY = npcDef.sizeY;
             customNpc.models = npcDef.models;
             customNpc.drawMinimapDot = npcDef.drawMinimapDot;
             customNpc.hasRenderPriority = npcDef.hasRenderPriority;
             customNpc.headIcon = npcDef.headIcon;
             customNpc.combatLevel = npcDef.combatLevel;
             customNpc.name = npcDef.name;
             customNpc.squaresNeeded = npcDef.squaresNeeded;
             customNpc.originalColours = npcDef.originalColours;
             customNpc.destColours = npcDef.destColours;
         }
         
     }
    
    HashSet<ItemDef> tempSet = new HashSet<>();
    
    private final void saveCustomItems() {
        def = ItemDef.forID(Client.currentlyEditedItemId);
        try {
        
        final File file = PATH.toFile();
        final FileWriter writer = new FileWriter(file);
        
        
        if(!customItems.add(def)) {
        	customItems.remove(def);
            customItems.add(def);
        }
        
        //customItems.add(def);
        GSON.toJson(customItems, TYPE, writer);
        writer.flush();
        writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private final void saveCustomNpcData() {
       // npcDef = ItemDef.forID(Client.currentlyEditedItemId);
        try {
        
        final File file = NPC_PATH.toFile();
        final FileWriter writer = new FileWriter(file);
        
        
        if(!customNpcs.add(npcDef)) {
        	customNpcs.remove(npcDef);
        	customNpcs.add(npcDef);
        }
        
        //customItems.add(def);
        GSON.toJson(customNpcs, TYPE, writer);
        writer.flush();
        writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	//ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    
    private void setItems() {
    	Client.instance.askData();
    }
    
  
    
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		particleColorPicker.valueProperty().addListener((observable, oldValue, newValue) -> changeParticleColor(newValue));
		
		
		
		
		
		saveButton.setOnMouseClicked(x -> {
			
			System.out.println("Executed");
			
			saveCustomItems();
			
		});
		
		saveNpcDataButton.setOnMouseClicked(x -> {
			saveCustomNpcData();
		});
		
		
		

		fields = new TextField[] { textureField1, textureField2, textureField3 };
		textureField1.setVisible(false);
		textureField2.setVisible(false);
		textureField3.setVisible(false);
	//	opacityTextField.setText("0");
		//opacitySlider.setValue(0);
		colors.setCellFactory(param -> new ListCell<ColorWrapper>() {
			@Override
			protected void updateItem(ColorWrapper item, boolean empty) {
				super.updateItem(item, empty);

				if (item == null || empty) {
					setGraphic(null);
					return;
				}

				ColorPicker picker = new ColorPicker(); // ensures that the picker is not bound to things it shouldn't
														// be bound to
				setGraphic(picker);
				picker.valueProperty().bindBidirectional(item.targetColor);
			}
		});
		
		npcColorsListView.setCellFactory(param -> new ListCell<ColorWrapper>() {
			@Override
			protected void updateItem(ColorWrapper item, boolean empty) {
				super.updateItem(item, empty);
				
				if(item == null || empty) {
					setGraphic(null);
					return;
				}
				
				ColorPicker colorPicker = new ColorPicker();
				
				setGraphic(colorPicker);
				
				colorPicker.valueProperty().bindBidirectional(item.targetColor);
			}
		});

		remainingColorsListView.setCellFactory(param -> new ListCell<ColorWrapper>() {
			@Override
			protected void updateItem(ColorWrapper item, boolean empty) {
				super.updateItem(item, empty);

				if (item == null || empty) {
					setGraphic(null);
					return;
				}

				ColorPicker picker = new ColorPicker(); // ensures that the picker is not bound to things it shouldn't
														// be bound to
				setGraphic(picker);
				picker.valueProperty().bindBidirectional(item.targetColor);
			}
		});
		loadModelColors.setOnMouseClicked(x -> {
			reset();
			readColors(modelColors);
			foundTextures.clear();
			fetchTextures();
			readRemainingColors(modelColors);
			if (foundTextures.size() > 0) {
				textureField1.setVisible(true);
			} else {
				textureField1.setVisible(false);
				textureField2.setVisible(false);
				textureField3.setVisible(false);
			}

			if (foundTextures.size() > 1) {
				textureField2.setVisible(true);
			} else {
				textureField2.setVisible(false);
				textureField3.setVisible(false);
			}

			if (foundTextures.size() > 2) {
				textureField3.setVisible(true);
			} else {
				textureField3.setVisible(false);
			}

		});
		
		loadNpcColorsButton.setOnMouseClicked(x -> {
			resetNpcData();
			readNpcColors(npcModelColors);
			System.out.println("Reading!");
		});
		

		
		
		zoomSlider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> var1, Number var2, Number var3) {
				if (Client.itemEditing) {
					def.modelZoom = var3.intValue();
					zoomTextField.setText("" + var3.intValue());
				} else {
					System.out.println("Aint even item editing lol");
				}
			}
		});

		xRotationSlider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> var1, Number var2, Number var3) {
				if (Client.itemEditing) {
					def.rotationX = var3.intValue();
					xRotationTextField.setText("" + var3.intValue());
				}
			}
		});

		yRotationSlider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> var1, Number var2, Number var3) {
				if (Client.itemEditing) {
					def.rotationY = var3.intValue();
					yRotationTextField.setText("" + var3.intValue());

				}
			}
		});

		opacitySlider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> var1, Number var2, Number var3) {
				if (Client.itemEditing) {
					def.shadow = 400 - var3.intValue();
					System.out.println("Shadow: " + def.shadow);
					ItemDef.modelCache.clear();
					opacityTextField.setText("" + def.shadow);

				}
			}
		});
		xAngleSlider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> var1, Number var2, Number var3) {
				if (Client.itemEditing) {
					xValue = var3.intValue();
					xAngleTextField.setText("" + xValue);
					Player.modelCache.clear();
				}
			}
		});

		yAngleSlider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> var1, Number var2, Number var3) {
				if (Client.itemEditing) {
					yValue = var3.intValue();
					yAngleTextField.setText("" + yValue);
					Player.modelCache.clear();
				}
			}
		});

		zAngleSlider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> var1, Number var2, Number var3) {
				if (Client.itemEditing) {
					zValue = var3.intValue();
					zAngleTextField.setText("" + zValue);
					Player.modelCache.clear();
					ItemDef.modelCache.clear();
				}
			}
		});
		
		xOffsetMSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> var1, Number var2, Number var3) {
				if(Client.itemEditing) {
					def.maleXOffset = (byte)var3.intValue();
					xOffsetMTextField.setText("Male X offset: " + var3.intValue());
					Player.modelCache.clear();
				}
				
			}
		});
		
		yOffsetMSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> var1, Number var2, Number var3) {
				if(Client.itemEditing) {
					def.maleYOffset = (byte)var3.intValue();
					yOffsetMTextField.setText("" + var3.intValue());
					Player.modelCache.clear();
				}
				
			}
		});
		
		yOffsetFSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> var1, Number var2, Number var3) {
				if(Client.itemEditing) {
					def.femaleYOffset = (byte)var3.intValue();
					yOffsetFTextField.setText("" + var3.intValue());
					Player.modelCache.clear();
				}
				
			}
		});
		
		

		/**
		 * Useful for color testing i guess.
		 */

		
		/*particleIndexField.setOnKeyPressed(keyEvent -> {
			if (keyEvent.getCode() == KeyCode.ENTER) {
				int index = Integer.parseInt(particleIndexField.getText());
				if(index != 1) {
					currentlyEditedIndex = index;
				} else {
					particleIndexField.setText("Error: Can't edit max cape.");
					return;
				}
				System.out.println("Currently edited index: " + currentlyEditedIndex);
				
			}
		});*/

		textureField1.setOnKeyPressed(keyEvent -> {
			if (keyEvent.getCode() == KeyCode.ENTER) {
				retexture(0);

			}
		});

		textureField2.setOnKeyPressed(keyEvent -> {
			if (keyEvent.getCode() == KeyCode.ENTER) {
				retexture(1);
			}
		});

		textureField3.setOnKeyPressed(keyEvent -> {
			if (keyEvent.getCode() == KeyCode.ENTER) {
				retexture(2);
			}
		});
		
		/**
		 * NPC stuff
		 */
		
		npcIdField.setOnKeyPressed(keyEvent -> {
			if (keyEvent.getCode() == KeyCode.ENTER) {
				npcDef = NPCDef.forID(Integer.parseInt(npcIdField.getText()));
				Client.instance.sendTransformationId(npcDef.id);
				System.out.println("Transformed to: " + npcDef.id);
				defaultRunAnim = npcDef.runAnim;
				defaultStandAnim = npcDef.standAnim;
				defaultWalkAnim = npcDef.walkAnim;
				defaultXZSize = npcDef.sizeXZ;
				defaultYSize = npcDef.sizeY;
				defaultNpcModels = npcDef.models;
				defaultDrawDotSetting = npcDef.drawMinimapDot;
				defaultRenderPri = npcDef.hasRenderPriority;
				defaultHeadIcon = npcDef.headIcon;
				defaultCombatLvl = npcDef.combatLevel;
				defaultNpcName = npcDef.name;
				defaultSquaresNeeded = npcDef.squaresNeeded;
				defaultNpcColors = npcDef.originalColours;
				defaultDestColors = npcDef.destColours;
				
				
				
			}
		});
		
		runAnimField.setOnKeyPressed(keyEvent -> {
			if (keyEvent.getCode() == KeyCode.ENTER) {
				npcDef.runAnim = Integer.parseInt(runAnimField.getText());
			}
		});
		
		standAnimField.setOnKeyPressed(keyEvent -> {
			if (keyEvent.getCode() == KeyCode.ENTER) {
				npcDef.standAnim = Integer.parseInt(standAnimField.getText());
			}
		});
		
		walkAnimField.setOnKeyPressed(keyEvent -> {
			if (keyEvent.getCode() == KeyCode.ENTER) {
				npcDef.walkAnim = Integer.parseInt(walkAnimField.getText());
			}
		});
		
		xzSizeField.setOnKeyPressed(keyEvent -> {
			if (keyEvent.getCode() == KeyCode.ENTER) {
				npcDef.sizeXZ = Integer.parseInt(xzSizeField.getText());
			}
		});
		
		ySizeField.setOnKeyPressed(keyEvent -> {
			if (keyEvent.getCode() == KeyCode.ENTER) {
				npcDef.sizeY = Integer.parseInt(ySizeField.getText());
			}
		});
		
		npcModelsField.setOnKeyPressed(keyEvent -> {
			if (keyEvent.getCode() == KeyCode.ENTER) {
				String[] model = npcModelsField.getText().split(",");
				int[] models = new int[model.length];
				System.out.println("models: " + Arrays.toString(model));
				for(int i = 0; i < model.length; i++) {
					models[i] = Integer.parseInt(model[i]);
				}
				npcDef.models = models;
				clearCaches();
				NPCDef.modelCache.clear();
			}
		});
		
		drawDotField.setOnKeyPressed(keyEvent -> {
			if (keyEvent.getCode() == KeyCode.ENTER) {
				npcDef.drawMinimapDot = Boolean.parseBoolean(drawDotField.getText());
			}
		});
		renderPriField.setOnKeyPressed(keyEvent -> {
			if (keyEvent.getCode() == KeyCode.ENTER) {
				npcDef.hasRenderPriority = Boolean.parseBoolean(renderPriField.getText());
			}
		});
		
		headIconField.setOnKeyPressed(keyEvent -> {
			if (keyEvent.getCode() == KeyCode.ENTER) {
				npcDef.headIcon = Integer.parseInt(headIconField.getText());
			}
		});
		
		combatLvlField.setOnKeyPressed(keyEvent -> {
			if (keyEvent.getCode() == KeyCode.ENTER) {
				npcDef.combatLevel = Integer.parseInt(combatLvlField.getText());
			}
		});
		
		nameField.setOnKeyPressed(keyEvent -> {
			if (keyEvent.getCode() == KeyCode.ENTER) {
				npcDef.name = nameField.getText();
			}
		});
		
		squaresNeededField.setOnKeyPressed(keyEvent -> {
			if (keyEvent.getCode() == KeyCode.ENTER) {
				npcDef.squaresNeeded = Byte.parseByte(squaresNeededField.getText());
			}
		});
		
		/**
		 * NPC STUFF END
		 */
		
		changeIDTextField.setOnKeyPressed(keyEvent -> {
			if (keyEvent.getCode() == KeyCode.ENTER) {
				
				if(changeIDTextField.getText().isEmpty()) {
					System.out.println("Was empty :/");
					return;
				}
				
				int newId = Integer.parseInt(changeIDTextField.getText());
				if (newId == Client.currentlyEditedItemId) {
					return;
				}
				Client.currentlyEditedItemId = newId;
				setItems();
				Client.itemEditing = true;
				def = ItemDef.forID(newId);
				defaultInvModel = def.modelID;
				defaultMaleModel = def.maleEquip1;
				defaultFemaleModel = def.femaleEquip1;
				defaultZoom = def.modelZoom;
				defaultRotationX = def.rotationX;
				defaultRotationY = def.rotationY;
				defaultOpacity = def.shadow;
				System.out.println("Model zoom: " + def.modelZoom);
				System.out.println("Rotation Y: " + def.rotationY);
				defaultModelColors = def.newModelColor; // dont ask me.
				defaultMaleXOffset = def.maleXOffset;
				defaultMaleYOffset = def.maleYOffset;
				defaultFemaleYOffset = def.femaleYOffset;
				zoomSlider.setValue(defaultZoom);
				xRotationSlider.setValue(defaultRotationX);
				yRotationSlider.setValue(defaultRotationY);
				//opacitySlider.setValue(defaultOpacity);
				xOffsetMSlider.setValue(defaultMaleXOffset);
				yOffsetMSlider.setValue(defaultMaleYOffset);
				yOffsetFSlider.setValue(defaultFemaleYOffset);
				RSInterface rsi = RSInterface.interfaceCache[3214];
				for (int slot = 0; slot < 28; slot++) {
					rsi.inv[slot] = Client.currentlyEditedItemId + 1;
					rsi.invStackSizes[slot] = 1;
				}
				
			}
		});
		
		invModelTextField.setOnKeyPressed(keyEvent -> {
			if (keyEvent.getCode() == KeyCode.ENTER) {
				if(invModelTextField.getText().isEmpty()) {
					System.out.println("Enter something too.");
					return;
				}
				
				int id = Integer.parseInt(invModelTextField.getText());
				
				def.modelID = id;
				clearCaches();
			}
		});
		
		maleEquipTextField.setOnKeyPressed(keyEvent -> {
			if (keyEvent.getCode() == KeyCode.ENTER) {
				if(maleEquipTextField.getText().isEmpty()) {
					System.out.println("Enter something too.");
					return;
				}
				
				int id = Integer.parseInt(maleEquipTextField.getText());
				
				def.maleEquip1 = id;
				clearCaches();
			}
		});
		
		femaleEquipTextField.setOnKeyPressed(keyEvent -> {
			if (keyEvent.getCode() == KeyCode.ENTER) {
				if(femaleEquipTextField.getText().isEmpty()) {
					System.out.println("Enter something too.");
					return;
				}
				
				int id = Integer.parseInt(femaleEquipTextField.getText());
				
				def.femaleEquip1 = id;
				clearCaches();
			}
		});
		
		defaultsButton.setOnMouseClicked(x -> {
			def.modelID = defaultInvModel;
			def.maleEquip1 = defaultMaleModel;
			def.femaleEquip1 = defaultFemaleModel;
			def.modelZoom = defaultZoom;
			def.rotationX = defaultRotationX;
			def.rotationY = defaultRotationY;
			def.shadow = defaultOpacity;
			def.originalModelColors = defaultModelColors;
			def.maleXOffset = defaultMaleXOffset;
			def.maleYOffset = defaultMaleYOffset;
			def.femaleYOffset = defaultFemaleYOffset;
			clearCaches();
			
			System.out.println("Model colors original: " + Arrays.toString(def.originalModelColors));
			System.out.println("Model colors new: " + Arrays.toString(def.newModelColor));
		});
		
		resetNpcData.setOnMouseClicked(x -> {
			npcDef.runAnim = defaultRunAnim;
			npcDef.standAnim = defaultStandAnim;
			npcDef.walkAnim = defaultWalkAnim;
			npcDef.sizeXZ = defaultXZSize;
			npcDef.sizeY = defaultYSize;
			npcDef.models = defaultNpcModels;
			npcDef.drawMinimapDot = defaultDrawDotSetting;
			npcDef.hasRenderPriority = defaultRenderPri;
			npcDef.headIcon = defaultHeadIcon;
			npcDef.combatLevel = defaultCombatLvl;
			npcDef.name = defaultNpcName;
			npcDef.squaresNeeded = defaultSquaresNeeded;
			npcDef.originalColours = defaultNpcColors;
			npcDef.destColours = defaultDestColors;
			NPCDef.modelCache.clear();
		});

	}
	



	private final class ColorWrapper {

		ItemDef definition;
	 	NPCDef npcDefinition;
		int initialColor;
		private Property<Color> targetColor;

		ColorWrapper(ItemDef definition, int occurences, int initialColor, int targetColor) {
			this.initialColor = initialColor;
			this.targetColor = new SimpleObjectProperty<>(convert(targetColor));
			this.definition = definition;
			this.targetColor.addListener((observable, oldValue, newValue) -> changeColor(newValue));
		}
		
		ColorWrapper(NPCDef npcDef, int occurences, int initialColor, int targetColor) {
			this.initialColor = initialColor;
			System.out.println("Set initialColor to: " + initialColor);
			this.targetColor = new SimpleObjectProperty<>(convert(targetColor));
			this.npcDefinition = npcDef;
			this.targetColor.addListener((observable, oldValue, newValue) -> changeNpcColor(newValue));
		}

		private void changeColor(Color color) {
			SwingUtilities.invokeLater(() -> {
				definition.recolor(initialColor, convert(color));
				System.out.println(
						"Changed from color: " + initialColor + " to Color: " + convert(targetColor.getValue()));
				clearCaches();
			});

		}
		
		private void changeNpcColor(Color color) {
			SwingUtilities.invokeLater(() -> {
				npcDefinition.recolor(initialColor, convert(color));
				System.out.println("Changed from npc color: " + initialColor + " to Color: " + convert(targetColor.getValue()));
				clearCaches();
				NPCDef.modelCache.clear();
			});
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			if (o == null || getClass() != o.getClass()) {
				return false;
			}
			ColorWrapper that = (ColorWrapper) o;
			return initialColor == that.initialColor && Objects.equals(definition, that.definition)
					&& Objects.equals(targetColor.getValue(), that.targetColor.getValue());
		}

		@Override
		public int hashCode() {
			return Objects.hash(definition, initialColor, targetColor.getValue());
		}

	}
}