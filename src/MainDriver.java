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
import javafx.stage.Stage;
/**
 * This is a class that is used to make the game playing card 24.
 * This game is designed in a way that it will display
 * 4 random cards which inlude all 52 paying cards.
 * The user is supossed to make an equation that include the
 * basic four operation to make an expersion to get the value 24.
 * @author Jaison, Corner, Waqar
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
	
	public void start(Stage primaryStage) throws Exception {
	
		 card[0]=new Card();
		 card[1]=new Card();
		 card[2]=new Card();
		 card[3]=new Card();
		 
		hb2=new HBox(card[0].getImageView(),card[1].getImageView(),card[2].getImageView(),card[3].getImageView());
		
		Button findSol = new Button("Find a Solution");
		
		TextField tf=new TextField();
		tf.setEditable(false);
		tf.setPrefWidth(200);
		
		TextField tf2=new TextField();
		
		Button refresh = new Button("Refresh");
		
		findSol.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				System.out.println("Find Solution button pressed");				
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
			}
		});
		
		HBox hb1=new HBox(findSol,tf,refresh);
		
		Label lb=new Label("Enter an expression:");
		
		Button verify = new Button("Verify");
		
		
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
	 * 
	 * @param c
	 * @return
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
