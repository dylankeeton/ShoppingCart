/*Dylan Keeton Sonal Jain
 * DK23765 SJ23277
 * Section: 16165
 * EE 422C- Assignment 3
 */
package Assignment3;

public class Grocery extends Item {
	
	private boolean perishable;
	
//=====================================================================================
	public Grocery(String n, double p, int q, int w, boolean b) {
		super(n, p, q, w);
		perishable = b;
	}
	
	
	public boolean isPerishable() {
		return perishable;
	}

	public void setPerishable(boolean perishable) {
		this.perishable = perishable;
	}
	
	float calculatePrice () 
	{
		float final_price = 0;
		final_price += quantity * price;
		final_price += 20*weight*quantity;
		if(perishable)
			final_price += (20*weight*quantity)*.2;
		return final_price;
	}
	
	void printItemAttributes () 
	{
		if(perishable)
			System.out.printf("Name: %s Price: $%.02f Quantity: %d Weight: %d lb(s) PERISHABLE\nTotal Charge: $%.02f\n", name, price, quantity, weight, calculatePrice());
		else
			System.out.printf("Name: %s Price: $%.02f Quantity: %d Weight: %d lb(s) NOTPERISHABLE\nTotal Charge: $%.02f\n", name, price, quantity, weight, calculatePrice());
	}
	
}
