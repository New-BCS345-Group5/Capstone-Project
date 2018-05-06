import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author Jaison, Corner, Waqar
 *This calss contains the if statemests to identfy the 52 playing cards.
 *Each of the cards is identfied by file name. first part of the file name 
 *is the numbers and the last part will identfy what shape does the card belongs to.
 */

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
/**
 * this method is a string that identify the whole card with the number and the shape
 * @return returns the card details with number and shape
 */
public String getFullLink() {
	return fullLink;
}
/**
 * This method get the image on the screen
 * @return Returns image
 */
public ImageView getImageView() {
	return imageView;
}
/**
 * This method add the random values to the playing cards according the file name.
 * @return Returns the values of the card
 */
public int getValue() {
	return value;
}
/**
 * This method add the random values to the playing cards according the file name.
 * @return Returns the values of the card
 */
public int getRandLetter() {
	return randLetter;
}
/**
 * @return Returns the first part of the card link
 */
public String getFirstPart() {
	return firstPart;
}
/**
 * @return Returns the last part of the card link
 */
public String getLastPart() {
	return lastPart;
}
/**
 * @return Returns the suit of the card
 */
public String getSuit() {
	if(randLetter==1) 
		return "spades";	
	else if (randLetter==2)
		return "clubs";
	else if (randLetter==3)
		return "hearts";
	else if (randLetter==4)
		return "diamonds";
	else
		return "No suit";
	
}
/**
 * This method sets a new card number
 */
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
