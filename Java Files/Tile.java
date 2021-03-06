public class Tile {

    private Player owner;
    private String name;
    private int pos;
    private int cost;
    private int[] rent = {0,0,0,0,0,0};
    private int houseCost;
    private int addOn = 0;
    private boolean owned = false;

    public Tile ( String n, int c, int position ) {
	name = n;
	cost = c;
	pos = position;
    }

    public Tile ( String n, int C, int hc, int a, int b, int c, int d, int e, int f, int position) {
	name = n;
	cost = C;
	houseCost = hc;
	rent[0] = a;
	rent[1] = b;
	rent[2] = c;
	rent[3] = d;
	rent[4] = e;
	rent[5] = f;
	pos = position;
    }

    public Player getOwner(){
	return owner;
    }

    public String getName () {
	return name;
    }

    public int getCost () {
	return cost;
    }

    /*
    public int getRent () {
	return rent;
    }
    */

    public int getPos(){
	return pos;
    }
    
    public int getAddOn(){
	return addOn;
    }

    public boolean getOwned(){
	return owned;
    }


    public void setOwner ( Player n ) {
	owner = n;
	owned = true;
    }

    public void setAddOn ( int n ) {
	addOn += n;
    }

    public int getHouseCost(){
	return houseCost;
    }
  
    public String toString() {
	String s = "";
	s += "   " + name + "\n";
	s += "   Cost:" + cost + "\n";
	//	s += "   rent:" + rent + "\n";
	if ( addOn >= 4 ) {
	    s += "   " + 4 + " houses\n";
	    s += "   " + ( addOn - 4 ) + " hotels\n";
	}
	else 
	    s += "   " + addOn + " houses\n";
	return s;
    }

    public int calculateRent () {
	return rent[addOn];
    }

    public int sellHouse (int n) {
	addOn -= n;
	return n * houseCost;
    }
    
    public int buyHouse(int n){
	addOn += n;
	return n*houseCost;
    }
    
    public void renew(){
	owned = false;
	addOn = 0;
    }


}
