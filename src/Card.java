import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Card {
private Random rand = new Random();
private String firstPart,lastPart,fullLink;
private int randLetter= rand.nextInt(4)+1,randNumber = rand.nextInt(13)+1,value;
private Image card;
private ImageView imageView;

public Card(){
	//Defining first half of file name
	if(randNumber==1) 
		firstPart="ace";
	else if (randNumber==2)
		firstPart="2";
	else if (randNumber==3)
		firstPart="3";
	else if (randNumber==4)
		firstPart="4";
	else if (randNumber==5)
		firstPart="5";
	else if (randNumber==6)
		firstPart="6";
	else if (randNumber==7)
		firstPart="7";
	else if (randNumber==8)
		firstPart="8";
	else if (randNumber==9)
		firstPart="9";
	else if (randNumber==10)
		firstPart="10";
	else if (randNumber==11)
		firstPart="jack";
	else if (randNumber==12)
		firstPart="queen";
	else if (randNumber==13)
		firstPart="king";
	
	//Defining Last half of file name
	if(randLetter==1) 
		lastPart="_of_spades";
	else if (randLetter==2)
		lastPart="_of_clubs";
	else if (randLetter==3)
		lastPart="_of_hearts";
	else if (randLetter==4)
		lastPart="_of_diamonds";
	
	//Creating Image Link
	fullLink=firstPart+lastPart+".png";
	card = new Image(fullLink);
	imageView=new ImageView(card);
	
	
	//Adding Value of card
	value=randNumber;
}

public String getFullLink() {
	return fullLink;
}
public ImageView getImageView() {
	return imageView;
}
public int getValue() {
	return value;
}
public void resetCard() {
	randLetter= rand.nextInt(4)+1;
	randNumber = rand.nextInt(13)+1;
	if(randNumber==1) 
		firstPart="ace";
	else if (randNumber==2)
		firstPart="2";
	else if (randNumber==3)
		firstPart="3";
	else if (randNumber==4)
		firstPart="4";
	else if (randNumber==5)
		firstPart="5";
	else if (randNumber==6)
		firstPart="6";
	else if (randNumber==7)
		firstPart="7";
	else if (randNumber==8)
		firstPart="8";
	else if (randNumber==9)
		firstPart="9";
	else if (randNumber==10)
		firstPart="10";
	else if (randNumber==11)
		firstPart="jack";
	else if (randNumber==12)
		firstPart="queen";
	else if (randNumber==13)
		firstPart="king";
	
	//Defining Last half of file name
	if(randLetter==1) 
		lastPart="_of_spades";
	else if (randLetter==2)
		lastPart="_of_clubs";
	else if (randLetter==3)
		lastPart="_of_hearts";
	else if (randLetter==4)
		lastPart="_of_diamonds";
	
	fullLink=firstPart+lastPart+".png";
	card = new Image(fullLink);
	imageView=new ImageView(card);
	
	value=randNumber;
}
}
