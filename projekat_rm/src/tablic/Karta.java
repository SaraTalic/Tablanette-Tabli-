package tablic;

import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Karta extends Parent{
	
	String znak;
	int vrijednost;

    private static final int CARD_WIDTH = 60;
    private static final int CARD_HEIGHT = 80;
	
	public Karta(String znak,int vr) {
		this.znak=znak;
		this.vrijednost=vr;
		
		 Rectangle bg = new Rectangle(CARD_WIDTH, CARD_HEIGHT);
	     bg.setArcWidth(20);
	     bg.setArcHeight(20);
	     bg.setFill(Color.WHITE);

	     Text text1 = new Text(vr+"");
	     text1.setFont(Font.font(18));
	     text1.setX(CARD_WIDTH - text1.getLayoutBounds().getWidth() - 10);
	     text1.setY(text1.getLayoutBounds().getHeight());

	     Text text2 = new Text(text1.getText());
	     text2.setFont(Font.font(18));
	     text2.setX(10);
	     text2.setY(CARD_HEIGHT - 10);

	     Text view = new Text(znak);
	     view.setRotate(180);
	     view.setX(CARD_WIDTH - 32);
	     view.setY(CARD_HEIGHT - 32);
	     Text view1 = new Text(znak);
	        
	     view1.setX(10);
	     view1.setY(13);

	     getChildren().addAll(bg,view, view1, text1, text2);
	}

}
