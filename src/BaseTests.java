import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class BaseTests {

	@Test
	void testCardLink() {
		Card[] card=new Card[4];
		card[0]=new Card();
		 card[1]=new Card();
		 card[2]=new Card();
		 card[3]=new Card();
		Assert.assertEquals(card[0].getFirstPart()+card[0].getLastPart()+".png", card[0].getFullLink());
		Assert.assertEquals(card[1].getFirstPart()+card[1].getLastPart()+".png", card[1].getFullLink());
		Assert.assertEquals(card[2].getFirstPart()+card[2].getLastPart()+".png", card[2].getFullLink());
		Assert.assertEquals(card[3].getFirstPart()+card[3].getLastPart()+".png", card[3].getFullLink());
	}
	
	@Test
	void testFirstPart() {
		Card[] card=new Card[4];
		card[0]=new Card();
		 card[1]=new Card();
		 card[2]=new Card();
		 card[3]=new Card();
		 
		if(card[0].getValue()==1) 
			Assert.assertEquals(card[0].getFirstPart(),"ace");
		else if (card[0].getValue()==2)
			Assert.assertEquals(card[0].getFirstPart(),"2");
		else if (card[0].getValue()==3)
			Assert.assertEquals(card[0].getFirstPart(),"3");
		else if (card[0].getValue()==4)
			Assert.assertEquals(card[0].getFirstPart(),"4");
		else if (card[0].getValue()==5)
			Assert.assertEquals(card[0].getFirstPart(),"5");
		else if (card[0].getValue()==6)
			Assert.assertEquals(card[0].getFirstPart(),"6");
		else if (card[0].getValue()==7)
			Assert.assertEquals(card[0].getFirstPart(),"7");
		else if (card[0].getValue()==8)
			Assert.assertEquals(card[0].getFirstPart(),"8");
		else if (card[0].getValue()==9)
			Assert.assertEquals(card[0].getFirstPart(),"9");
		else if (card[0].getValue()==10)
			Assert.assertEquals(card[0].getFirstPart(),"10");
		else if (card[0].getValue()==11)
			Assert.assertEquals(card[0].getFirstPart(),"jack");
		else if (card[0].getValue()==12)
			Assert.assertEquals(card[0].getFirstPart(),"queen");
		else if (card[0].getValue()==13)
			Assert.assertEquals(card[0].getFirstPart(),"king");
	}
	
	@Test
	void testLastPart() {
		Card[] card=new Card[4];
		card[0]=new Card();
		 card[1]=new Card();
		 card[2]=new Card();
		 card[3]=new Card();
		 
		if(card[0].getRandLetter()==1) 
			Assert.assertEquals(card[0].getSuit(),"spades");
		else if (card[0].getRandLetter()==2)
			Assert.assertEquals(card[0].getSuit(),"clubs");
		else if (card[0].getRandLetter()==3)
			Assert.assertEquals(card[0].getSuit(),"hearts");
		else if (card[0].getRandLetter()==4)
			Assert.assertEquals(card[0].getSuit(),"diamonds");
		
	}
}
