package application;
	

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Main extends Application {
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			VBox root = new VBox(20);
			Scene scene = new Scene(root,1000,700);
			
			HBox gore = new HBox(30);
			HBox sredina = new HBox(20);
			HBox dole = new HBox(30);
			
			//Nase karte
			Button k1 = new Button();
			Button k2 = new Button();
			Button k3 = new Button();
			Button k4 = new Button();
			Button k5 = new Button();
			Button k6 = new Button();
			
			k1.setMinSize(120, 200);
			k2.setMinSize(120, 200);
			k3.setMinSize(120, 200);
			k4.setMinSize(120, 200);
			k5.setMinSize(120, 200);
			k6.setMinSize(120, 200);
			
			
			//Karte protivnika (Ne mogu se pritisnuti bukv ne sluze nicemu ali kao tu su zbog estetike)
			Button pk1 = new Button();
			Button pk2 = new Button();
			Button pk3 = new Button();
			Button pk4 = new Button();
			Button pk5 = new Button();
			Button pk6 = new Button();

			pk1.setMinSize(120, 200);
			pk2.setMinSize(120, 200);
			pk3.setMinSize(120, 200);
			pk4.setMinSize(120, 200);
			pk5.setMinSize(120, 200);
			pk6.setMinSize(120, 200);
			
			pk1.setDisable(true);
			pk2.setDisable(true);
			pk3.setDisable(true);
			pk4.setDisable(true);
			pk5.setDisable(true);
			pk6.setDisable(true);
			
			//Karte na stolu
			
			ArrayList<Button> karteNaStolu= new ArrayList<Button>();
			
			karteNaStolu.add(new Button("Prva"));
			karteNaStolu.add(new Button("Druga"));
			karteNaStolu.add(new Button("Treca"));
			karteNaStolu.add(new Button("Cetvrta"));
			karteNaStolu.add(new Button("Peta"));
			karteNaStolu.add(new Button("Sesta"));
		
			//Ovo ce prolaziti kroz karte na stolu iz servera i za svaku kartu praviti dugme
			//i stavljati ga na sredinu stola kao da je dole, treba jos napraviti funkciju 
			//da updajtuje ovu listu dugmadi na stolu svaki put kad neko baci kartu 
			//
			for(Button b:karteNaStolu) {
				b.setMinSize(100, 170);
				b.setDisable(true);
			}
			
			
			gore.setAlignment(Pos.BASELINE_CENTER);
			sredina.setAlignment(Pos.BASELINE_CENTER);
			dole.setAlignment(Pos.BASELINE_CENTER);
			
			gore.getChildren().addAll(pk1,pk2,pk3,pk4,pk5,pk6);
			sredina.getChildren().addAll(karteNaStolu);
			dole.getChildren().addAll(k1,k2,k3,k4,k5,k6);
			root.getChildren().addAll(gore,sredina,dole);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
