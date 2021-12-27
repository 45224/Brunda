package theTest;
import java.util.ArrayList;
import java.util.Scanner;


class PlayerNotFound extends Exception { 
    public PlayerNotFound(String errorMessage) {
        super(errorMessage);
    }
}

class Player{
public String name;
public String country;
public int matchPlayed;
public int runs;
public int wickets;
public int outOnZero;
public String type;
public Player(String name, String country, int matchPlayed, int runs, int wickets, int outOnZero, String type) {
this.country = country;
this.name = name;
this.matchPlayed = matchPlayed;
this.runs = runs;
this.wickets = wickets;
this.outOnZero = outOnZero;
this.type = type;
}
public float averageScore() {
return runs/matchPlayed;
}
}

class Model{
public ArrayList<Player> players = new ArrayList<Player>();
public void addPlayer(Player player) {
if(players != null && players.size() >= 20) {
System.out.println("Already 20 Teams...");
return;
}
players.add(player);
System.out.println("Added..");
}
public void displayFinal() {
if(players != null && players.size() > 0) {
System.out.println("\nid\tName\tCountry\tMatch played\tRuns \tWickets\tOut On Zero\ttype");
for(int i=0; i<players.size(); i++) {
if(i < 11) {
System.out.println(i+1+"\t"+players.get(i).name+"\t"+players.get(i).country+"\t"+players.get(i).matchPlayed+"\t"+players.get(i).runs+"\t"+players.get(i).wickets+"\t"+players.get(i).outOnZero+"\t"+players.get(i).type);
} 
}
}else {
System.out.println("No player, add new players...");
}
System.out.println();
}
public void displayAllPlayers() {
if(players != null && players.size() > 0) {
System.out.println("\nid\tName\tCountry\tMatch\tRuns\tWickets\tOutOnZero\tBowler/Batsman/AllRounder");
for(int i=0; i<players.size(); i++) {
System.out.println(i+1+"\t"+players.get(i).name+"\t"+players.get(i).country+"\t"+players.get(i).matchPlayed+"\t"+players.get(i).runs+"\t"+players.get(i).wickets+"\t"+players.get(i).outOnZero+"\t"+players.get(i).type);
}
}else {
System.out.println("No player,please add new players...");
}
System.out.println();
}
public void updatePlayer(String name, String country, int matchPlayed, int runs, int wickets, int outOnZero, String type) {
int a=-1;
if(players != null)
for(int i=0; i<players.size(); i++) {
if(players.get(i).name == name) {
a = i;
break;
}
}
try {
if(a== -1) {
throw new PlayerNotFound("No player found by this name...");
}
Player player = players.get(a);
player.country = country;
player.matchPlayed = matchPlayed;
player.runs = runs;
player.wickets = wickets;
player.outOnZero = outOnZero;
player.type = type;
System.out.println("Updated");
}
catch(PlayerNotFound e) {
System.out.println(e.getMessage());
}
}
}

public class team {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	Model model = new Model();
	String name, country, type;
	int matchPlayed, runs, wickets, outOnZero;
	Player player;
	while(true) {
	System.out.print("Select from menu");
	System.out.print("\n1. Display All Players \n2. Update Player Information \n3. Display Final Team \n4. Add Player information \n5. Exit");
	int choice = sc.nextInt();
	switch(choice) {
	case 1:
	model.displayAllPlayers();
	break;
	case 2:
	System.out.println("Update");
	System.out.print("Enter name : ");
	name = sc.next();
	System.out.println("Enter country : ");
	country = sc.next();
	System.out.println("Enter matches : ");
	matchPlayed = sc.nextInt();
	System.out.println("Enter runs : ");
	runs = sc.nextInt();
	System.out.println("Enter wickets : ");
	wickets = sc.nextInt();
	System.out.println("Enter out on zeros : ");
	outOnZero = sc.nextInt();
	System.out.println("Enter bowler/batsman/allrounder/wicketKeeper: ");
	type = sc.next();
	model.updatePlayer(name, country, matchPlayed, runs, wickets, outOnZero, type);
	break;
	case 3:
	model.displayFinal();
	break;
	case 4:
    System.out.print("Enter the name of player : ");
	name = sc.next();
	System.out.print("Enter the country : ");
	country = sc.next();
	System.out.print("Enter number of matches played : ");
	matchPlayed = sc.nextInt();
	System.out.print("Enter number of runs scored : ");
	runs = sc.nextInt();
	System.out.print("Enter the wickets taken : ");
	wickets = sc.nextInt();
	System.out.print("Enter out on zeros : ");
	outOnZero = sc.nextInt();
	System.out.print("Enter bowler/batsman/allrounder/wicketKeeper: ");
	type = sc.next();
	player = new Player(name, country, matchPlayed, runs, wickets, outOnZero, type);
	model.addPlayer(player);
	break;
	case 5:
	System.exit(0);
	default:
	System.out.println("Select number from menu");
	}
	}
	}
	}


		