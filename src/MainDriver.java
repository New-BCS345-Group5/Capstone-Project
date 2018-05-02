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
	
	private Image card1;
	private Image card2;
	private Image card3;
	private Image card4;
	private ImageView imageView1;
	private ImageView imageView2;
	private ImageView imageView3;
	private ImageView imageView4;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		Button findSol = new Button("Find a Solution");
		findSol.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				
			}
		});
		
		TextField tf=new TextField();
		
		Button refresh = new Button("Refresh");
		refresh.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				
			}
		});
		
		HBox hb1=new HBox(findSol,tf,refresh);
		
		Card card1=new Card();
		Card card2=new Card();
		Card card3=new Card();
		Card card4=new Card();
		
		HBox hb2=new HBox(card1.getImageView(),card2.getImageView(),card3.getImageView(),card4.getImageView());
		
		Label lb=new Label("Enter an expression:");

		TextField tf2=new TextField();
		
		Button verify = new Button("Verify");
		verify.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				
			}
		});
		HBox hb3=new HBox(lb,tf2,verify);
		
		VBox vb=new VBox(hb1,hb2,hb3);
		
		Button resetPos = new Button("Reset");
		resetPos.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				
			}
		});
		Group gp=new Group(vb);

		Scene scene = new Scene(gp, 900, 400, Color.WHITE);
		
		primaryStage.setTitle("Card Game");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[]args) {
		launch(args);
	}

}
