
public class Pirate {
	
	//Instance Variables	
	String name;
	int health;                       
	int swordsmanship;
	int agility;
	Boolean hasParrot;
	Boolean hasPegLeg;
	int doubloons;               
	
	//Class Variable
	static int numberOfPirates;
	
	//1st Constructor
	public Pirate (String name, int swordsmanship, int agility, Boolean hasParrot, Boolean hasPegLeg) {
		this.name = name;
		this.swordsmanship = swordsmanship;
		this.agility = agility;
		this.hasParrot = hasParrot;
		this.hasPegLeg = hasPegLeg;
		
		health = 10;
		doubloons = 25;
		numberOfPirates++;
	}
	
	//2nd Constructor
	public Pirate (String name) {
		
		this.name = name;
		
		int randSwd = (int) (Math.random() * 10) + 1;  //Random # 1-10
		int randAgi = (int) (Math.random() * 10) + 1;  //Random # 1-10
		
		this.swordsmanship = randSwd;
		this.agility = randAgi;
		
				
		int randParrot = (int) (Math.random() * 4) + 1; // Random # 1-4 for a 25% chance
		if (randParrot == 4) {
			hasParrot = true;
		} else {
			hasParrot = false;
		}
		
		int randPegLeg = (int) (Math.random() * 10 )+ 1; // Random # 1-10 for a 10% chance
		if (randPegLeg == 10) {
			hasPegLeg = true;
		} else {
			hasPegLeg = false;
		}
		
		health = 10;
		doubloons = 25;
		numberOfPirates++;
	}
	
	//Main method - creates pirates
	public static void main(String[] args) {
		
		Pirate blackbeard = new Pirate("BlackBeard");
		
		Pirate calicoJack = new Pirate("Calico Jack");
		
		blackbeard.toString();
		calicoJack.toString();		
		
		calicoJack.swashbuckle(blackbeard);
	
	}
	
	//getAgility method 
	public int getAgility() {
		return agility;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	//swashbuckle method
	public String swashbuckle (Pirate p) {
		
		//Strings to return
		String dodgedPhrase = " dodged yar attack!" ;
		String swabsDeck = " swabs the deck with ";
		
		int dodgeValue = (int) (Math.random() * 21); //Random # 0-20
		
		if (p.hasPegLeg = true) { //Peg leg will lose 1 value from agility
			p.agility = p.agility - 1;
		}
		
		if (hasParrot = true) { //Parrot will gain 1 value to swordsmanship
		swordsmanship = swordsmanship + 1;
		}
		
		if (health == 0 || health < 0) {
			health = 0;
			doubloons = doubloons + p.doubloons; //Attacking pirate will keep previous doubloons + doubloons from pirate fought
			p.doubloons = p.doubloons - p.doubloons;
			numberOfPirates--;
			}
				
		if (p.getAgility() > dodgeValue) { //Dodge successful
			System.out.println(p.name + dodgedPhrase);			
			return dodgedPhrase;
		} else { //Dodge failed --> Attack is result
			int failedDodge = (int) (Math.random() * swordsmanship) + 1;	
			p.health = p.health - failedDodge;
			System.out.println(name + swabsDeck + p.name +" for " +failedDodge); 
			return swabsDeck;
		}

	}
	
	//napping method
	public Boolean  isNapping () {
		if (health == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	//toString method
	public String toString () {
		String currentStatus; 
		String stats = name + "  H: " + health + "  S: " + swordsmanship + "  A: " + agility + "  $" + doubloons; //stats include name, health, swordsmanship etc
				
		currentStatus = stats + "  Has parrot: " + hasParrot + " Has pegleg: " + hasPegLeg; //currenStatus includes stats + parrot + pegleg
		System.out.println(currentStatus);
		return currentStatus;
	}
	
	
}
