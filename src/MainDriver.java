import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainDriver extends Application{

	HBox hb2;
	private String num1,num2,num3,num4,op1,op2,op3;
	private String userEquation;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Card card1=new Card();
		Card card2=new Card();
		Card card3=new Card();
		Card card4=new Card();
		
		hb2=new HBox(card1.getImageView(),card2.getImageView(),card3.getImageView(),card4.getImageView());
		
		Button findSol = new Button("Find a Solution");
		findSol.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				System.out.println("Find Solution button pressed");

			}
		});
		
		TextField tf=new TextField();
		tf.setEditable(false);
		
		Button refresh = new Button("Refresh");
		refresh.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				card1.resetCard();
				card2.resetCard();
				card3.resetCard();
				card4.resetCard();
				
				hb2.getChildren().remove(0);
				hb2.getChildren().remove(0);
				hb2.getChildren().remove(0);
				hb2.getChildren().remove(0);

				hb2.getChildren().addAll(card1.getImageView(),card2.getImageView(),card3.getImageView(),card4.getImageView());
			}
		});
		
		HBox hb1=new HBox(findSol,tf,refresh);
		
		Label lb=new Label("Enter an expression:");

		TextField tf2=new TextField();
		
		Button verify = new Button("Verify");
		verify.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				//System.out.println("Verify button pressed");
				userEquation=tf2.getText();
				//Break Apart the equation entered by the user here
			}
		});
		
		HBox hb3=new HBox(lb,tf2,verify);		
		VBox vb=new VBox(hb1,hb2,hb3);
		Group gp=new Group(vb);

		Scene scene = new Scene(gp, 900, 400, Color.WHITE);
		
		primaryStage.setResizable(false);
		primaryStage.setTitle("Card Game");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[]args) {
		launch(args);
	}
	
	//public boolean isWinnable(Card c1,Card c2,Card c3,Card c4) {
		
	//	return true;
	//}

}
