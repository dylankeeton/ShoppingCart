/*Dylan Keeton Sonal Jain
 * DK23765 SJ23277
 * Section: 16165
 * EE 422C- Assignment 3
 */
package Assignment3;

public class Electronics extends Item 
{
	private boolean fragile;
	private String state;

//============================================================================
	public Electronics(String n, double p, int q, int w, boolean f, String s) {
		super(n, p, q, w);
		fragile = f;
		state = s;	
	}
	
	public boolean isFragile() {
		return fragile;
	}

	public void setFragile(boolean fragile) {
		this.fragile = fragile;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	float calculatePrice () 
	{
		float final_price = 0;
		final_price += quantity * price;
		if(!(state.equals("TX") || state.equals("NM") || state.equals("VA") || state.equals("AZ") || state.equals("AK")))
			final_price += final_price * .10;
		final_price += 20*weight*quantity;
		if(fragile)
			final_price += (20*weight*quantity)*.2;
		return final_price;
	}
	
	void printItemAttributes () 
	{
		if(fragile)
			System.out.printf("Name: %s Price: $%.02f Quantity: %d Weight: %d lb(s) FRAGILE State: %s\nTotal Charge: $%.02f\n", name, price, quantity, weight, state, calculatePrice());
		else
			System.out.printf("Name: %s Price: $%.02f Quantity: %d Weight: %d lb(s) NOTFRAGILE State: %s\nTotal Charge: $%.02f\n", name, price, quantity, weight, state, calculatePrice());
	}

	
}
