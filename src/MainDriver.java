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
	private String userEquation="",solutionEquation="";
	private Card[] card=new Card[4];

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
		
		Button refresh = new Button("Refresh");
		
		findSol.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				System.out.println("Find Solution button pressed");
				isWinnable(card);
				tf.setText(solutionEquation);
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

	public void isWinnable(Card c[]) {
		solutionEquation="There is no solution for this set";
		// ++(+-/*)
		int i=0,j=1,k=2,l=3;
		int count=0;
		for(count=0;count<25;count++) {
		if(c[i].getValue()+c[j].getValue()+c[k].getValue()+c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"+"+c[j].getValue()+"+"+c[k].getValue()+"+"+c[l].getValue();
		else if(c[i].getValue()+c[j].getValue()+c[k].getValue()-c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"+"+c[j].getValue()+"+"+c[k].getValue()+"-"+c[l].getValue();
		else if(c[i].getValue()+c[j].getValue()+c[k].getValue()/c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"+"+c[j].getValue()+"+"+c[k].getValue()+"/"+c[l].getValue();
		else if(c[i].getValue()+c[j].getValue()+c[k].getValue()*c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"+"+c[j].getValue()+"+"+c[k].getValue()+"*"+c[l].getValue();	
		// +-(+-/*)
		else if(c[i].getValue()+c[j].getValue()-c[k].getValue()+c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"+"+c[j].getValue()+"-"+c[k].getValue()+"+"+c[l].getValue();
		else if(c[i].getValue()+c[j].getValue()-c[k].getValue()-c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"+"+c[j].getValue()+"-"+c[k].getValue()+"-"+c[l].getValue();
		else if(c[i].getValue()+c[j].getValue()-c[k].getValue()/c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"+"+c[j].getValue()+"-"+c[k].getValue()+"/"+c[l].getValue();
		else if(c[i].getValue()+c[j].getValue()-c[k].getValue()*c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"+"+c[j].getValue()+"-"+c[k].getValue()+"*"+c[l].getValue();	
		// +/(+-/*)
		else if(c[i].getValue()+c[j].getValue()/c[k].getValue()+c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"+"+c[j].getValue()+"/"+c[k].getValue()+"+"+c[l].getValue();
		else if(c[i].getValue()+c[j].getValue()/c[k].getValue()-c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"+"+c[j].getValue()+"/"+c[k].getValue()+"-"+c[l].getValue();
		else if(c[i].getValue()+c[j].getValue()/c[k].getValue()/c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"+"+c[j].getValue()+"/"+c[k].getValue()+"/"+c[l].getValue();
		else if(c[i].getValue()+c[j].getValue()/c[k].getValue()*c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"+"+c[j].getValue()+"/"+c[k].getValue()+"*"+c[l].getValue();	
		// +*(+-/*)
		else if(c[i].getValue()+c[j].getValue()*c[k].getValue()+c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"+"+c[j].getValue()+"*"+c[k].getValue()+"+"+c[l].getValue();
		else if(c[i].getValue()+c[j].getValue()*c[k].getValue()-c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"+"+c[j].getValue()+"*"+c[k].getValue()+"-"+c[l].getValue();
		else if(c[i].getValue()+c[j].getValue()*c[k].getValue()/c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"+"+c[j].getValue()+"*"+c[k].getValue()+"/"+c[l].getValue();
		else if(c[i].getValue()+c[j].getValue()*c[k].getValue()*c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"+"+c[j].getValue()+"*"+c[k].getValue()+"*"+c[l].getValue();	
		////////////////
		////////////////
		// -+(+-/*)
		else if(c[i].getValue()-c[j].getValue()+c[k].getValue()+c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"-"+c[j].getValue()+"+"+c[k].getValue()+"+"+c[l].getValue();
		else if(c[i].getValue()-c[j].getValue()+c[k].getValue()-c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"-"+c[j].getValue()+"+"+c[k].getValue()+"-"+c[l].getValue();
		else if(c[i].getValue()-c[j].getValue()+c[k].getValue()/c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"-"+c[j].getValue()+"+"+c[k].getValue()+"/"+c[l].getValue();
		else if(c[i].getValue()-c[j].getValue()+c[k].getValue()*c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"-"+c[j].getValue()+"+"+c[k].getValue()+"*"+c[l].getValue();	
		// --(+-/*)
		else if(c[i].getValue()-c[j].getValue()-c[k].getValue()+c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"-"+c[j].getValue()+"-"+c[k].getValue()+"+"+c[l].getValue();
		else if(c[i].getValue()-c[j].getValue()-c[k].getValue()-c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"-"+c[j].getValue()+"-"+c[k].getValue()+"-"+c[l].getValue();
		else if(c[i].getValue()-c[j].getValue()-c[k].getValue()/c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"-"+c[j].getValue()+"-"+c[k].getValue()+"/"+c[l].getValue();
		else if(c[i].getValue()-c[j].getValue()-c[k].getValue()*c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"-"+c[j].getValue()+"-"+c[k].getValue()+"*"+c[l].getValue();	
		// -/(+-/*)
		else if(c[i].getValue()-c[j].getValue()/c[k].getValue()+c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"-"+c[j].getValue()+"/"+c[k].getValue()+"+"+c[l].getValue();
		else if(c[i].getValue()-c[j].getValue()/c[k].getValue()-c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"-"+c[j].getValue()+"/"+c[k].getValue()+"-"+c[l].getValue();
		else if(c[i].getValue()-c[j].getValue()/c[k].getValue()/c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"-"+c[j].getValue()+"/"+c[k].getValue()+"/"+c[l].getValue();
		else if(c[i].getValue()-c[j].getValue()/c[k].getValue()*c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"-"+c[j].getValue()+"/"+c[k].getValue()+"*"+c[l].getValue();	
		// -*(+-/*)
		else if(c[i].getValue()-c[j].getValue()*c[k].getValue()+c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"-"+c[j].getValue()+"*"+c[k].getValue()+"+"+c[l].getValue();
		else if(c[i].getValue()-c[j].getValue()*c[k].getValue()-c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"-"+c[j].getValue()+"*"+c[k].getValue()+"-"+c[l].getValue();
		else if(c[i].getValue()-c[j].getValue()*c[k].getValue()/c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"-"+c[j].getValue()+"*"+c[k].getValue()+"/"+c[l].getValue();
		else if(c[i].getValue()-c[j].getValue()*c[k].getValue()*c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"-"+c[j].getValue()+"*"+c[k].getValue()+"*"+c[l].getValue();		
		////////////////
		////////////////
		// /+(+-/*)
		else if(c[i].getValue()/c[j].getValue()+c[k].getValue()+c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"/"+c[j].getValue()+"+"+c[k].getValue()+"+"+c[l].getValue();
		else if(c[i].getValue()/c[j].getValue()+c[k].getValue()-c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"/"+c[j].getValue()+"+"+c[k].getValue()+"-"+c[l].getValue();
		else if(c[i].getValue()/c[j].getValue()+c[k].getValue()/c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"/"+c[j].getValue()+"+"+c[k].getValue()+"/"+c[l].getValue();
		else if(c[i].getValue()/c[j].getValue()+c[k].getValue()*c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"/"+c[j].getValue()+"+"+c[k].getValue()+"*"+c[l].getValue();	
		// /-(+-/*)
		else if(c[i].getValue()/c[j].getValue()-c[k].getValue()+c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"/"+c[j].getValue()+"-"+c[k].getValue()+"+"+c[l].getValue();
		else if(c[i].getValue()/c[j].getValue()-c[k].getValue()-c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"/"+c[j].getValue()+"-"+c[k].getValue()+"-"+c[l].getValue();
		else if(c[i].getValue()/c[j].getValue()-c[k].getValue()/c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"/"+c[j].getValue()+"-"+c[k].getValue()+"/"+c[l].getValue();
		else if(c[i].getValue()/c[j].getValue()-c[k].getValue()*c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"/"+c[j].getValue()+"-"+c[k].getValue()+"*"+c[l].getValue();	
		// //(+-/*)
		else if(c[i].getValue()/c[j].getValue()/c[k].getValue()+c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"/"+c[j].getValue()+"/"+c[k].getValue()+"+"+c[l].getValue();
		else if(c[i].getValue()/c[j].getValue()/c[k].getValue()-c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"/"+c[j].getValue()+"/"+c[k].getValue()+"-"+c[l].getValue();
		else if(c[i].getValue()/c[j].getValue()/c[k].getValue()/c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"/"+c[j].getValue()+"/"+c[k].getValue()+"/"+c[l].getValue();
		else if(c[i].getValue()/c[j].getValue()/c[k].getValue()*c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"/"+c[j].getValue()+"/"+c[k].getValue()+"*"+c[l].getValue();	
		// /*(+-/*)
		else if(c[i].getValue()/c[j].getValue()*c[k].getValue()+c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"/"+c[j].getValue()+"*"+c[k].getValue()+"+"+c[l].getValue();
		else if(c[i].getValue()/c[j].getValue()*c[k].getValue()-c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"/"+c[j].getValue()+"*"+c[k].getValue()+"-"+c[l].getValue();
		else if(c[i].getValue()/c[j].getValue()*c[k].getValue()/c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"/"+c[j].getValue()+"*"+c[k].getValue()+"/"+c[l].getValue();
		else if(c[i].getValue()/c[j].getValue()*c[k].getValue()*c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"/"+c[j].getValue()+"*"+c[k].getValue()+"*"+c[l].getValue();					
		////////////////
		////////////////
		// *+(+-/*)
		else if(c[i].getValue()*c[j].getValue()+c[k].getValue()+c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"*"+c[j].getValue()+"+"+c[k].getValue()+"+"+c[l].getValue();
		else if(c[i].getValue()*c[j].getValue()+c[k].getValue()-c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"*"+c[j].getValue()+"+"+c[k].getValue()+"-"+c[l].getValue();
		else if(c[i].getValue()*c[j].getValue()+c[k].getValue()/c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"*"+c[j].getValue()+"+"+c[k].getValue()+"/"+c[l].getValue();
		else if(c[i].getValue()*c[j].getValue()+c[k].getValue()*c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"*"+c[j].getValue()+"+"+c[k].getValue()+"*"+c[l].getValue();	
		// *-(+-/*)
		else if(c[i].getValue()*c[j].getValue()-c[k].getValue()+c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"*"+c[j].getValue()+"-"+c[k].getValue()+"+"+c[l].getValue();
		else if(c[i].getValue()*c[j].getValue()-c[k].getValue()-c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"*"+c[j].getValue()+"-"+c[k].getValue()+"-"+c[l].getValue();
		else if(c[i].getValue()*c[j].getValue()-c[k].getValue()/c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"*"+c[j].getValue()+"-"+c[k].getValue()+"/"+c[l].getValue();
		else if(c[i].getValue()*c[j].getValue()-c[k].getValue()*c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"*"+c[j].getValue()+"-"+c[k].getValue()+"*"+c[l].getValue();	
		// /*(+-/*)
		else if(c[i].getValue()*c[j].getValue()/c[k].getValue()+c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"*"+c[j].getValue()+"/"+c[k].getValue()+"+"+c[l].getValue();
		else if(c[i].getValue()*c[j].getValue()/c[k].getValue()-c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"*"+c[j].getValue()+"/"+c[k].getValue()+"-"+c[l].getValue();
		else if(c[i].getValue()*c[j].getValue()/c[k].getValue()/c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"*"+c[j].getValue()+"/"+c[k].getValue()+"/"+c[l].getValue();
		else if(c[i].getValue()*c[j].getValue()/c[k].getValue()*c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"*"+c[j].getValue()+"/"+c[k].getValue()+"*"+c[l].getValue();	
		// **(+-/*)
		else if(c[i].getValue()*c[j].getValue()*c[k].getValue()+c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"*"+c[j].getValue()+"*"+c[k].getValue()+"+"+c[l].getValue();
		else if(c[i].getValue()*c[j].getValue()*c[k].getValue()-c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"*"+c[j].getValue()+"*"+c[k].getValue()+"-"+c[l].getValue();
		else if(c[i].getValue()*c[j].getValue()*c[k].getValue()/c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"*"+c[j].getValue()+"*"+c[k].getValue()+"/"+c[l].getValue();
		else if(c[i].getValue()*c[j].getValue()*c[k].getValue()*c[l].getValue()==24) 
			solutionEquation=""+c[i].getValue()+"*"+c[j].getValue()+"*"+c[k].getValue()+"*"+c[l].getValue();		
		
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

	}

}
