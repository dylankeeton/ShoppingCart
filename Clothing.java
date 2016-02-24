/*Dylan Keeton Sonal Jain
 * DK23765 SJ23277
 * Section: 16165
 * EE 422C- Assignment 3
 */
package Assignment3;

public class Clothing extends Item 
{
	
	public Clothing(String n, double p, int q, int w) {
		super(n, p, q, w);
	}

	float calculatePrice () 
	{
		float final_price = 0;
		final_price += quantity * price;
		final_price += final_price * .10;
		final_price += 20*weight*quantity;
		return final_price;
	}
	
	void printItemAttributes () 
	{
		System.out.printf("Name: %s Price: $%.02f Quantity: %d Weight %d lb(s)\nTotal Charge: $%.02f\n", name, price, quantity, weight, calculatePrice());
	}
	

}
