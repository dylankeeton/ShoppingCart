/*Dylan Keeton Sonal Jain
 * DK23765 SJ23277
 * Section: 16165
 * EE 422C- Assignment 3
 */
package Assignment3;

import java.util.*;
import java.io.*;

public class A3Driver 
{
	  public static void main(String[] args) 
	  {
		  ArrayList<Item> shoppingCart = new ArrayList<Item>(); 
		  if (args.length != 1) 
		  {
			  System.err.println ("Error: Incorrect number of command line arguments");
			  System.exit(-1);
		  } 
		  try {
			  FileReader freader = new FileReader(args[0]);
			  BufferedReader reader = new BufferedReader(freader);
			  for (String s = reader.readLine(); s != null; s = reader.readLine()) 
			  {
				  try{
					  String[] input = s.split(" ");
					  input[0] = input[0].toLowerCase();
					  switch(input[0])
					  {
					  	case "insert" : insertItem(input, shoppingCart); break;
						case "search" : searchItem(input, shoppingCart); break;
						case "delete" : deleteItem(input, shoppingCart); break;
						case "update" : updateItem(input, shoppingCart); break;
						case "print" : 
						{
							if(input.length != 1)
								throw new InvalidCategoryException("Invalid Category");
							double total = 0;
							Iterator<Item> i = shoppingCart.iterator();
							while (i.hasNext()) 
							{
								Item temp = i.next();
								total += temp.calculatePrice(); 
								temp.printItemAttributes();
							}	
							System.out.printf("Total Shopping Cart Charge: $%.02f\n", total);
							break;
						}
						default: throw new InvalidCategoryException("Invalid Category");
					  }
					} 
					catch(InvalidCategoryException a){
						System.err.println("INVALID INPUT, COMMAND ABORTED");
					}
					catch(ArrayIndexOutOfBoundsException a)
					{	
						System.err.println("INVALID INPUT, COMMAND ABORTED");
					}
				  	catch(NumberFormatException a)
				  	{
				  		System.err.println("INVALID INPUT, COMMAND ABORTED");
				  	}
				}
			} 
			catch (FileNotFoundException e) 
			{
				System.err.println ("Error: File not found. Exiting...");
				e.printStackTrace();
				System.exit(-1);
			} catch (IOException e) 
			{
				System.err.println ("Error: IO exception. Exiting...");
				e.printStackTrace();
				System.exit(-1);
			}
		
		/* General code example for how to iterate an array list. You will have to modify this heavily, to suit your needs.
		  Iterator<Item> i = shoppingCart.iterator();
		  while (i.hasNext()) 
		  {
			  Item temp = i.next();
			  temp.calculatePrice(); 
			  temp.printItemAttributes();
			  //This (above) works because of polymorphism: a determination is made at runtime, 
			  //based on the inherited class type, as to which method is to be invoked. Eg: If it is an instance
			  // of Grocery, it will invoke the calculatePrice () method defined in Grocery.
		  }	
		  
		  
		*/
	  }
	  
	  static void insertItem(String[] input, ArrayList<Item> sc)
	  {
		  try{
			  String[] states = {"AK", "AL", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN",
			  			 "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV",
			  			 "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN",
			  			 "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};
			  int index = 0;
			  for(int i = 0; i < sc.size(); i++)
			  {
				  if(input[2].compareTo(sc.get(i).getName()) < 0)
				  {
					  index = i;
					  break;
				  }
				  index = sc.size();
			  }
			  if(Double.valueOf(input[3]) < 0 || Integer.valueOf(input[4]) < 0 || Integer.valueOf(input[5]) < 0)
				  throw new InvalidCategoryException("Invalid Category");
			  switch(input[1])
			  {
				case "clothing": 
				{
					if(input.length == 6)
						sc.add(index, new Clothing(input[2],Double.valueOf(input[3]),Integer.valueOf(input[4]),Integer.valueOf(input[5]))); 
					else
						throw new InvalidCategoryException("Invalid Category");
					break;
				}
				case "electronics":
				{
					if(Arrays.asList(states).contains(input[7]))
					{
						if(input[6].equals("F") && input.length == 8)
							sc.add(index, new Electronics(input[2],Double.valueOf(input[3]),Integer.valueOf(input[4]),Integer.valueOf(input[5]),true,input[7]));
						else if(input[6].equals("NF") && input.length == 8)
							sc.add(index, new Electronics(input[2],Double.valueOf(input[3]),Integer.valueOf(input[4]),Integer.valueOf(input[5]),false,input[7]));
						else
							throw new InvalidCategoryException("Invalid Category");
					}
					else
						throw new InvalidCategoryException("Invalid Category");
					break;
				}
				case "groceries":
				{
					if(input[6].equals("P") && input.length == 7)
						sc.add(index, new Grocery(input[2],Double.valueOf(input[3]),Integer.valueOf(input[4]),Integer.valueOf(input[5]),true));
					else if(input[6].equals("NP") && input.length == 7)
						sc.add(index, new Grocery(input[2],Double.valueOf(input[3]),Integer.valueOf(input[4]),Integer.valueOf(input[5]),false));					
					else
					{
						throw new InvalidCategoryException("Invalid Category");
					}
					break;	
				}
				default: throw new InvalidCategoryException("Invalid Category");
			}
			
		 }
		 catch(InvalidCategoryException a)
		 {	
			System.err.println("INVALID INPUT, COMMAND ABORTED");
			return;
		 }
		 catch(ArrayIndexOutOfBoundsException a)
		 {
			System.err.println("INVALID INPUT, COMMAND ABORTED");
			return;
		 }
		 catch(NumberFormatException a)
		 {
		  	System.err.println("INVALID INPUT, COMMAND ABORTED");
		  	return;
		 }
		 
		 
	 }
	  
	 static void searchItem(String[] input, ArrayList<Item> sc)
	 {
		 try{
			 if(input.length != 2)
					throw new InvalidCategoryException("Invalid Category");
				else
				{
					int total = 0;
					for(int i = 0; i < sc.size(); i++)
					{
						if(sc.get(i).getName().equals(input[1]))
							total += sc.get(i).getQuantity();
					}
					System.out.printf("Total Quantity of %s: %d\n", input[1], total);
				}
		 }
		 catch(InvalidCategoryException a)
		 {	
			System.err.println("INVALID INPUT, COMMAND ABORTED");
			return;
		 }
		 
	 }
	  
	  static void deleteItem(String[] input, ArrayList<Item> sc)
	  {
		  try{
			  if(input.length != 2){
				  throw new InvalidCategoryException("Invalid Input");
			  }
			  
			  int count = 0;
			  String name = input[1];
			  int i = 0;
			
			  while(i < sc.size()){
				 if(name.equals(sc.get(i).getName())){
					 count += sc.get(i).getQuantity();
					 sc.remove(i);
					 i--;
				 }
				 i++; 
			  }
			  System.out.println("Name: " + input[1] + "  Quantity Deleted: " + count);
		  }
		  catch(InvalidCategoryException a)
		  {	
			System.err.println("INVALID INPUT, COMMAND ABORTED");
			return;
		  }
		  
	  }
	  
	  static void updateItem(String[] input, ArrayList<Item> sc)
	  {
		  int quantity = 0;
		  try {
			  if(input.length != 3){
				  throw new InvalidCategoryException("Invalid Input");
			  }  
			  quantity = Integer.parseInt(input[2]);  
		  }
		  catch (NumberFormatException e) {
			  System.out.println("quantity number is not valid");
			  return;
		  }
		  catch(InvalidCategoryException a)
		  {	
			System.err.println("INVALID INPUT, COMMAND ABORTED");
			return;
		  }
		  
		  
		  String name = input[1];
		  boolean nameFound = false;
		  int i = 0;
		  while(i < sc.size()) {
			  if(name.equals(sc.get(i).getName()))
			  {
				  nameFound = true;
				  break;
			  }
			  i++;
		  }	  
		  try{
			  if(nameFound == false)
			  {
				  throw new InvalidCategoryException("Name not Found.");
			  }	 
		  }
		  catch(InvalidCategoryException a)
		  {	
			System.err.println("INVALID INPUT, COMMAND ABORTED");
			return;
		  }
		  sc.get(i).setQuantity(quantity);	  
		  System.out.print("Name: " + input[1] + "  Updated Quantity: " + input[2] + "\n");	 
	  }
	  
}
