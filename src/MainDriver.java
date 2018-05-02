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
		
		Random rand1 = new Random();
		int randLetter1 = rand1.nextInt(4)+1;
		int randLetter2 = rand1.nextInt(4)+1;
		int randLetter3 = rand1.nextInt(4)+1;
		int randLetter4 = rand1.nextInt(4)+1;
		String l1="";
		if(randLetter1==1) 
			l1="_of_spades";
		else if (randLetter1==2)
			l1="_of_spades";
		else if (randLetter1==3)
			l1="_of_spades";
		else if (randLetter1==4)
			l1="_of_spades";
		String l2="";
		if(randLetter2==1) 
			l2="_of_clubs";
		else if (randLetter2==2)
			l2="_of_clubs";
		else if (randLetter2==3)
			l2="_of_clubs";
		else if (randLetter2==4)
			l2="_of_clubs";
		String l3="";
		if(randLetter3==1) 
			l3="_of_hearts";
		else if (randLetter3==2)
			l3="_of_hearts";
		else if (randLetter3==3)
			l3="_of_hearts";
		else if (randLetter3==4)
			l3="_of_hearts";
		String l4="";
		if(randLetter4==1) 
			l4="_of_diamonds";
		else if (randLetter4==2)
			l4="_of_diamonds";
		else if (randLetter4==3)
			l4="_of_diamonds";
		else if (randLetter4==4)
			l4="_of_diamonds";
		
		Random rand2 = new Random();
		
		int randNum1 = rand2.nextInt(13)+1;
		String n1="";
		if(randNum1==1) 
			n1="ace";
		else if (randNum1==2)
			n1="2";
		else if (randNum1==3)
			n1="3";
		else if (randNum1==4)
			n1="4";
		else if (randNum1==5)
			n1="5";
		else if (randNum1==6)
			n1="6";
		else if (randNum1==7)
			n1="7";
		else if (randNum1==8)
			n1="8";
		else if (randNum1==9)
			n1="9";
		else if (randNum1==10)
			n1="10";
		else if (randNum1==11)
			n1="jack";
		else if (randNum1==12)
			n1="queen";
		else if (randNum1==13)
			n1="king";
		
		int randNum2 = rand2.nextInt(13)+1;
		String n2="";
		if(randNum2==1) 
			n2="ace";
		else if (randNum2==2)
			n2="2";
		else if (randNum2==3)
			n2="3";
		else if (randNum2==4)
			n2="4";
		else if (randNum2==5)
			n2="5";
		else if (randNum2==6)
			n2="6";
		else if (randNum2==7)
			n2="7";
		else if (randNum2==8)
			n2="8";
		else if (randNum2==9)
			n2="9";
		else if (randNum2==10)
			n2="10";
		else if (randNum2==11)
			n2="jack";
		else if (randNum2==12)
			n2="queen";
		else if (randNum2==13)
			n2="king";
		
		int randNum3 = rand2.nextInt(13)+1;
		String n3="";
		if(randNum3==1) 
			n3="ace";
		else if (randNum3==2)
			n3="2";
		else if (randNum3==3)
			n3="3";
		else if (randNum3==4)
			n3="4";
		else if (randNum3==5)
			n3="5";
		else if (randNum3==6)
			n3="6";
		else if (randNum3==7)
			n3="7";
		else if (randNum3==8)
			n3="8";
		else if (randNum3==9)
			n3="9";
		else if (randNum3==10)
			n3="10";
		else if (randNum3==11)
			n3="jack";
		else if (randNum3==12)
			n3="queen";
		else if (randNum3==13)
			n3="king";
		
		int randNum4 = rand2.nextInt(13)+1;
		String n4="";
		if(randNum4==1) 
			n4="ace";
		else if (randNum4==2)
			n4="2";
		else if (randNum4==3)
			n4="3";
		else if (randNum4==4)
			n4="4";
		else if (randNum4==5)
			n4="5";
		else if (randNum4==6)
			n4="6";
		else if (randNum4==7)
			n4="7";
		else if (randNum4==8)
			n4="8";
		else if (randNum4==9)
			n4="9";
		else if (randNum4==10)
			n4="10";
		else if (randNum4==11)
			n4="jack";
		else if (randNum4==12)
			n4="queen";
		else if (randNum4==13)
			n4="king";
	
		card1 = new Image(n1+l1+".png");
		imageView1=new ImageView(card1);
		card2 = new Image(n2+l2+".png");
		imageView2=new ImageView(card2);
		card3 = new Image(n3+l3+".png");
		imageView3=new ImageView(card3);
		card4 = new Image(n4+l4+".png");
		imageView4=new ImageView(card4);
		
		HBox hb2=new HBox(imageView1,imageView2,imageView3,imageView4);
		
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
