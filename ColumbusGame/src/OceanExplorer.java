import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
public class OceanExplorer extends Application {
	int[][] ilandMap;
	Pane root;
	final int height = 10;
	final int isletC = 10;
	final int scalingFactor = 50;
	Image shipImage;
	ImageView shipImageView;
	OceanMap oceanMap;
	Stage mapStage;
	Scene scene;
	Ship ship;

	@Override
	public void start(Stage mapStage) throws Exception {
		// TODO Auto-generated method stub
		try {
			oceanMap = new OceanMap(height, isletC);
			ilandMap = oceanMap.getMap();
			root = new AnchorPane();
			drawMap();
			ship = new Ship(oceanMap);
			loadShipImage();
			scene = new Scene(root,500,500);
			mapStage.setTitle("Christopher Columbus Sails the Ocean Blue");
			mapStage.setScene(scene);
			mapStage.show();
			startSailing();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void startSailing() {
		// TODO Auto-generated method stub
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				switch (event.getCode()) {
				case RIGHT:
					ship.goEast();
					break;
				case LEFT:
					ship.goWest();
					break;
				case UP:
					ship.goNorth();
					break;
				case DOWN:
					ship.goSouth();
				default:
					break;
				}
				shipImageView.setX(ship.getShipReviewLocation().x*scalingFactor);
				shipImageView.setY(ship.getShipReviewLocation().y*scalingFactor);
			}
		});
	}

	private void loadShipImage() {
		// TODO Auto-generated method stub
		shipImage = new Image("src//ship.png", 50, 50, true, true);
		shipImageView = new ImageView(shipImage);
		shipImageView.setX(ship.getShipReviewLocation().x * scalingFactor);
		shipImageView.setY(ship.getShipReviewLocation().y * scalingFactor);
		root.getChildren().add(shipImageView);
	}

	private void drawMap() {
		// TODO Auto-generated method stub
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < height; j++) {
				Rectangle rect = new Rectangle(i * scalingFactor, j * scalingFactor, scalingFactor, scalingFactor);
				rect.setStroke(Color.BLACK);
				if (ilandMap[i][j] == 0)
					rect.setFill(Color.PALETURQUOISE);
				if (ilandMap[i][j] == 1)
					rect.setFill(Color.GREEN);
				root.getChildren().add(rect);
			}
		}

	}

	public static void main(String[] args) {
		launch(args);
	}
}
