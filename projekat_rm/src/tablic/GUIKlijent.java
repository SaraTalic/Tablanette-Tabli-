package tablic;


import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class GUIKlijent extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		VBox sto=new VBox(10);
		sto.setPadding(new Insets(15,50,50,50));
		sto.setAlignment(Pos.BASELINE_CENTER);
		sto.setBackground(new Background(new BackgroundFill(Color.rgb(0,128,0), CornerRadii.EMPTY, Insets.EMPTY)));
		
		Karte karte=new Karte();
		
		VBox karteNaStolu=new VBox(5);
		//karteNaStolu.setPadding(new Insets(20,40,40,40));
		//karteNaStolu.setAlignment(Pos.TOP_LEFT);
		
		ArrayList<Karta> k=karte.postaviKarteNaSto();
		
		karteNaStolu.getChildren().addAll(k);
		
		sto.getChildren().addAll(karteNaStolu);
		
		Scene scena1=new Scene(sto,700,500);
		primaryStage.setScene(scena1);
		primaryStage.show();
		
		
	}
	
	public static void main(String[]args) {
		
		launch(args);
	}

}
