import java.io.PrintStream;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
/**
 * This is a class that is used to make the game playing card 24.
 * This game is designed in a way that it will display
 * 4 random cards which include all 52 paying cards.
 * The user is supposed to make an equation that include the
 * basic four operation to make an expression to get the value 24 
 * using the four cards displayed on the screen.
 * 
 * The cards are represented by 
 * their numbers (2-10),
 * Ace is one,
 * Jack is 11,
 * Queen is 12 and
 * King is 13. 
 * @author Jaison, Conner, Waqar
 *
 */
public class MainDriver extends Application{

	HBox hb2;
	private String userEquation="";
	private Card[] card=new Card[4];
	private String[] solutions=new String[40];
	private int ansCount;
	private long seconds;
	private long startTime = System.nanoTime();
	Label lb2;

	
	

	
	
	@Override
	/**
	 * creates a window to display the 4 playing cards with all other button
	 * findSol= finds the solution 
	 * refresh= when hit will display another set of 4 cards 
	 * verify= this button will check the solution from the possible solutions list
	 */
	public void start(Stage primaryStage) throws Exception {
	
		 card[0]=new Card();
		 card[1]=new Card();
		 card[2]=new Card();
		 card[3]=new Card();
		 
		hb2=new HBox(card[0].getImageView(),card[1].getImageView(),card[2].getImageView(),card[3].getImageView());
		
		Button findSol = new Button("Find a Solution");
		findSol.setStyle("-fx-background-color: Red");
		findSol.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		findSol.setPrefWidth(150);
		findSol.setPrefHeight(32);
		
		TextField tf=new TextField();
		tf.setEditable(false);
		tf.setPrefWidth(200);
		tf.setPrefHeight(32);
		
		TextField tf2=new TextField();
		tf2.setPrefHeight(32);
		
		Button refresh = new Button("Refresh");
		refresh.setPrefHeight(32);
		refresh.setStyle("-fx-background-color: Red");
		refresh.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		
		PrintStream Tests = new PrintStream("File Tests.txt");
		
		findSol.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			
			public void handle(ActionEvent e) {
				Tests.println("Find Solution button pressed");				
				tf.setText(isWinnable(card));
			}
		});
		
		refresh.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				card[0].resetCard();
				card[1].resetCard();
				card[2].resetCard();
				card[3].resetCard();
				
				hb2.getChildren().remove(0);
				hb2.getChildren().remove(0);
				hb2.getChildren().remove(0);
				hb2.getChildren().remove(0);

				hb2.getChildren().addAll(card[0].getImageView(),card[1].getImageView(),card[2].getImageView(),card[3].getImageView());
				tf.setText("");
				lb2.setText("");
				tf2.setText("");
				startTime = System.nanoTime();
				Tests.println("refresh button pressed");		
			}
		});
		
		HBox hb1=new HBox(findSol,tf,refresh);
		hb1.setSpacing(5);
		
		Label lb=new Label("Enter an expression:");
		lb.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
		lb.setTextFill(Color.RED);
		lb.setPrefHeight(32);
		
		Button verify = new Button("Verify");
		verify.setPrefHeight(32);
		verify.setPrefWidth(100);
		verify.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		verify.setStyle("-fx-background-color: Red");
		
		
		lb2=new Label("");
		
		verify.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				//System.out.println("Verify button pressed");
				userEquation=tf2.getText();
				System.out.println("Winning equation: "+isWinnable(card));
				verifyAnswer();
			}
		});
		
		HBox hb3=new HBox(lb,tf2,verify,lb2);
		hb3.setSpacing(5);
		
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

	/**
	 * This method makes possible solution for the displayed for the given cards.
	 * 
	 * @param c the parameter c[] holds the solution for the each set of displayed cards
	 * @return Returns the possible solution according to the values displayed in the window
	 */
	
	public String isWinnable(Card c[]) {
		String solutionEquation="There is no solution for this set";
		// ++(+-/*)
		int i=0,j=1,k=2,l=3;
		ansCount=0;
		int count=0;
		for(count=0;count<25;count++) {
		if(c[i].getValue()+c[j].getValue()+c[k].getValue()+c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"+"+c[j].getValue()+"+"+c[k].getValue()+"+"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		else if(c[i].getValue()+c[j].getValue()+c[k].getValue()-c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"+"+c[j].getValue()+"+"+c[k].getValue()+"-"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		else if(c[i].getValue()+c[j].getValue()+c[k].getValue()/c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"+"+c[j].getValue()+"+"+c[k].getValue()+"/"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		else if(c[i].getValue()+c[j].getValue()+c[k].getValue()*c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"+"+c[j].getValue()+"+"+c[k].getValue()+"*"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		// +-(+-/*)
		else if(c[i].getValue()+c[j].getValue()-c[k].getValue()+c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"+"+c[j].getValue()+"-"+c[k].getValue()+"+"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		else if(c[i].getValue()+c[j].getValue()-c[k].getValue()-c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"+"+c[j].getValue()+"-"+c[k].getValue()+"-"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		else if(c[i].getValue()+c[j].getValue()-c[k].getValue()/c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"+"+c[j].getValue()+"-"+c[k].getValue()+"/"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		else if(c[i].getValue()+c[j].getValue()-c[k].getValue()*c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"+"+c[j].getValue()+"-"+c[k].getValue()+"*"+c[l].getValue();	
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		// +/(+-/*)
		else if(c[i].getValue()+c[j].getValue()/c[k].getValue()+c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"+"+c[j].getValue()+"/"+c[k].getValue()+"+"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		else if(c[i].getValue()+c[j].getValue()/c[k].getValue()-c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"+"+c[j].getValue()+"/"+c[k].getValue()+"-"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		else if(c[i].getValue()+c[j].getValue()/c[k].getValue()/c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"+"+c[j].getValue()+"/"+c[k].getValue()+"/"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		else if(c[i].getValue()+c[j].getValue()/c[k].getValue()*c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"+"+c[j].getValue()+"/"+c[k].getValue()+"*"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		// +*(+-/*)
		else if(c[i].getValue()+c[j].getValue()*c[k].getValue()+c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"+"+c[j].getValue()+"*"+c[k].getValue()+"+"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		else if(c[i].getValue()+c[j].getValue()*c[k].getValue()-c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"+"+c[j].getValue()+"*"+c[k].getValue()+"-"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		else if(c[i].getValue()+c[j].getValue()*c[k].getValue()/c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"+"+c[j].getValue()+"*"+c[k].getValue()+"/"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		else if(c[i].getValue()+c[j].getValue()*c[k].getValue()*c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"+"+c[j].getValue()+"*"+c[k].getValue()+"*"+c[l].getValue();	
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		////////////////
		////////////////
		// -+(+-/*)
		else if(c[i].getValue()-c[j].getValue()+c[k].getValue()+c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"-"+c[j].getValue()+"+"+c[k].getValue()+"+"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		else if(c[i].getValue()-c[j].getValue()+c[k].getValue()-c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"-"+c[j].getValue()+"+"+c[k].getValue()+"-"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		else if(c[i].getValue()-c[j].getValue()+c[k].getValue()/c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"-"+c[j].getValue()+"+"+c[k].getValue()+"/"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		else if(c[i].getValue()-c[j].getValue()+c[k].getValue()*c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"-"+c[j].getValue()+"+"+c[k].getValue()+"*"+c[l].getValue();	
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		// --(+-/*)
		else if(c[i].getValue()-c[j].getValue()-c[k].getValue()+c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"-"+c[j].getValue()+"-"+c[k].getValue()+"+"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		else if(c[i].getValue()-c[j].getValue()-c[k].getValue()-c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"-"+c[j].getValue()+"-"+c[k].getValue()+"-"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		else if(c[i].getValue()-c[j].getValue()-c[k].getValue()/c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"-"+c[j].getValue()+"-"+c[k].getValue()+"/"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		else if(c[i].getValue()-c[j].getValue()-c[k].getValue()*c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"-"+c[j].getValue()+"-"+c[k].getValue()+"*"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		// -/(+-/*)
		else if(c[i].getValue()-c[j].getValue()/c[k].getValue()+c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"-"+c[j].getValue()+"/"+c[k].getValue()+"+"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		else if(c[i].getValue()-c[j].getValue()/c[k].getValue()-c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"-"+c[j].getValue()+"/"+c[k].getValue()+"-"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		else if(c[i].getValue()-c[j].getValue()/c[k].getValue()/c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"-"+c[j].getValue()+"/"+c[k].getValue()+"/"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		else if(c[i].getValue()-c[j].getValue()/c[k].getValue()*c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"-"+c[j].getValue()+"/"+c[k].getValue()+"*"+c[l].getValue();	
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		// -*(+-/*)
		else if(c[i].getValue()-c[j].getValue()*c[k].getValue()+c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"-"+c[j].getValue()+"*"+c[k].getValue()+"+"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		else if(c[i].getValue()-c[j].getValue()*c[k].getValue()-c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"-"+c[j].getValue()+"*"+c[k].getValue()+"-"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		else if(c[i].getValue()-c[j].getValue()*c[k].getValue()/c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"-"+c[j].getValue()+"*"+c[k].getValue()+"/"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		else if(c[i].getValue()-c[j].getValue()*c[k].getValue()*c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"-"+c[j].getValue()+"*"+c[k].getValue()+"*"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		////////////////
		////////////////
		// /+(+-/*)
		else if(c[i].getValue()/c[j].getValue()+c[k].getValue()+c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"/"+c[j].getValue()+"+"+c[k].getValue()+"+"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		else if(c[i].getValue()/c[j].getValue()+c[k].getValue()-c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"/"+c[j].getValue()+"+"+c[k].getValue()+"-"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		else if(c[i].getValue()/c[j].getValue()+c[k].getValue()/c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"/"+c[j].getValue()+"+"+c[k].getValue()+"/"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		else if(c[i].getValue()/c[j].getValue()+c[k].getValue()*c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"/"+c[j].getValue()+"+"+c[k].getValue()+"*"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		// /-(+-/*)
		else if(c[i].getValue()/c[j].getValue()-c[k].getValue()+c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"/"+c[j].getValue()+"-"+c[k].getValue()+"+"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		else if(c[i].getValue()/c[j].getValue()-c[k].getValue()-c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"/"+c[j].getValue()+"-"+c[k].getValue()+"-"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		else if(c[i].getValue()/c[j].getValue()-c[k].getValue()/c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"/"+c[j].getValue()+"-"+c[k].getValue()+"/"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		else if(c[i].getValue()/c[j].getValue()-c[k].getValue()*c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"/"+c[j].getValue()+"-"+c[k].getValue()+"*"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		// //(+-/*)
		else if(c[i].getValue()/c[j].getValue()/c[k].getValue()+c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"/"+c[j].getValue()+"/"+c[k].getValue()+"+"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		else if(c[i].getValue()/c[j].getValue()/c[k].getValue()-c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"/"+c[j].getValue()+"/"+c[k].getValue()+"-"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		else if(c[i].getValue()/c[j].getValue()/c[k].getValue()/c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"/"+c[j].getValue()+"/"+c[k].getValue()+"/"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		else if(c[i].getValue()/c[j].getValue()/c[k].getValue()*c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"/"+c[j].getValue()+"/"+c[k].getValue()+"*"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		// /*(+-/*)
		else if(c[i].getValue()/c[j].getValue()*c[k].getValue()+c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"/"+c[j].getValue()+"*"+c[k].getValue()+"+"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		else if(c[i].getValue()/c[j].getValue()*c[k].getValue()-c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"/"+c[j].getValue()+"*"+c[k].getValue()+"-"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		else if(c[i].getValue()/c[j].getValue()*c[k].getValue()/c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"/"+c[j].getValue()+"*"+c[k].getValue()+"/"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		else if(c[i].getValue()/c[j].getValue()*c[k].getValue()*c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"/"+c[j].getValue()+"*"+c[k].getValue()+"*"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		////////////////
		////////////////
		// *+(+-/*)
		else if(c[i].getValue()*c[j].getValue()+c[k].getValue()+c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"*"+c[j].getValue()+"+"+c[k].getValue()+"+"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		else if(c[i].getValue()*c[j].getValue()+c[k].getValue()-c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"*"+c[j].getValue()+"+"+c[k].getValue()+"-"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		else if(c[i].getValue()*c[j].getValue()+c[k].getValue()/c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"*"+c[j].getValue()+"+"+c[k].getValue()+"/"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		else if(c[i].getValue()*c[j].getValue()+c[k].getValue()*c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"*"+c[j].getValue()+"+"+c[k].getValue()+"*"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		// *-(+-/*)
		else if(c[i].getValue()*c[j].getValue()-c[k].getValue()+c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"*"+c[j].getValue()+"-"+c[k].getValue()+"+"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		else if(c[i].getValue()*c[j].getValue()-c[k].getValue()-c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"*"+c[j].getValue()+"-"+c[k].getValue()+"-"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		else if(c[i].getValue()*c[j].getValue()-c[k].getValue()/c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"*"+c[j].getValue()+"-"+c[k].getValue()+"/"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		else if(c[i].getValue()*c[j].getValue()-c[k].getValue()*c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"*"+c[j].getValue()+"-"+c[k].getValue()+"*"+c[l].getValue();	
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		// /*(+-/*)
		else if(c[i].getValue()*c[j].getValue()/c[k].getValue()+c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"*"+c[j].getValue()+"/"+c[k].getValue()+"+"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		else if(c[i].getValue()*c[j].getValue()/c[k].getValue()-c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"*"+c[j].getValue()+"/"+c[k].getValue()+"-"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		else if(c[i].getValue()*c[j].getValue()/c[k].getValue()/c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"*"+c[j].getValue()+"/"+c[k].getValue()+"/"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		else if(c[i].getValue()*c[j].getValue()/c[k].getValue()*c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"*"+c[j].getValue()+"/"+c[k].getValue()+"*"+c[l].getValue();	
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		// **(+-/*)
		else if(c[i].getValue()*c[j].getValue()*c[k].getValue()+c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"*"+c[j].getValue()+"*"+c[k].getValue()+"+"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		else if(c[i].getValue()*c[j].getValue()*c[k].getValue()-c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"*"+c[j].getValue()+"*"+c[k].getValue()+"-"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		else if(c[i].getValue()*c[j].getValue()*c[k].getValue()/c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"*"+c[j].getValue()+"*"+c[k].getValue()+"/"+c[l].getValue();
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		else if(c[i].getValue()*c[j].getValue()*c[k].getValue()*c[l].getValue()==24) {
			solutionEquation=""+c[i].getValue()+"*"+c[j].getValue()+"*"+c[k].getValue()+"*"+c[l].getValue();		
			solutions[ansCount]=solutionEquation;
			ansCount++;
		}
		
		i++;
		j++;
		k++;
		l++;
		if (i==4) 
			i=0;
		if (j==4) 
			j=0;
		if (k==4) 
			k=0;
		if (l==4) 
			l=0;
		System.out.println("i="+i);
		System.out.println("j="+j);
		System.out.println("k="+k);		
		System.out.println("l="+l);
		System.out.println("Count: "+count);
		System.out.println("Solution: "+solutionEquation);
		}
		
		if (solutionEquation.equals(""))
			solutionEquation="There is no solution for this set";
		System.out.println("Amount of Solutions: "+ansCount);
		//for verify store all solutions into an array then check against the solution they enter
		return solutionEquation;
	}
	/**
	 * This method is to verify the answer to the one in the solution.
	 * The if statement check if there is possible solution if not return "There is no solution for this set"
	 * In the while statement the program checks both the user input solution and the possible solution and if the 
	 * answer is correct the program prints out "Answer was Correct".
	 * The program also prints out the time user took to figure out the solution for the game.
	 */
	
	public void verifyAnswer() {
		int i=0;
		System.out.println("in verify answer function");
		System.out.println("Number of Answers: "+ansCount);
		System.out.println("User ans: "+userEquation);
		if (ansCount==0)
			lb2.setText("There is no solution for this set");
		else{
			int c=0;
			
			while(c<ansCount) {
				if (solutions[i].equals(userEquation)) {
					System.out.println("Ans was Correct");
					final long duration = System.nanoTime() - startTime;
					seconds = TimeUnit.NANOSECONDS.toSeconds(duration);
					lb2.setText("Congradulations! You took "+seconds+" seconds to find an answer.");
					break;
				}
				i++;
				c++;
				System.out.println("C: "+c);
				
			}
			
			System.out.println("Ans was not Correct");
	}
	}
}
