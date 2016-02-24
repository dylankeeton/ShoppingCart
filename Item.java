/*Dylan Keeton Sonal Jain
 * DK23765 SJ23277
 * Section: 16165
 * EE 422C- Assignment 3
 */
package Assignment3;

public class Item 
{
	protected String name;
	protected double price;
	protected int quantity, weight;
//======================================================================
	public Item(String n, double p, int q, int w)
	{
		name = n;
		price = p;
		quantity = q;
		weight = w;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	float calculatePrice () 
	{
		float final_price = 0;
		// Insert price calculation here
		return final_price;
	}

	void printItemAttributes () 
	{
		
	}

}
