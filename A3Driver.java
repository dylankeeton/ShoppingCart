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
		  try 
			{
				FileReader freader = new FileReader(args[0]);
				BufferedReader reader = new BufferedReader(freader);
				for (String s = reader.readLine(); s != null; s = reader.readLine()) 
				{
					try{
						String[] input = s.split(" ");
						switch(input[0])
						{
						case "insert" : break;
						case "search" : break;
						case "delete" : deleteItem(input, shoppingCart); break;
						case "update" : updateItem(input, shoppingCart); break;
						case "print" : System.out.println("Hello");break;
						default: throw new InvalidCategoryException("Invalid Category");
						}
					} catch(InvalidCategoryException a){
						
						System.err.println("INVALID CATEGORY, COMMAND ABORTED");
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
		
		// General code example for how to iterate an array list. You will have to modify this heavily, to suit your needs.
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

	  }
	  
	  
	  static void deleteItem(String[] input, ArrayList<Item> sc)
	  {
		  if(input.length != 2){
			  System.out.println("INVALID INPUT");
			  return;
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
	  
	  static void updateItem(String[] input, ArrayList<Item> sc)
	  {
		  if(input.length != 3){
			  System.out.println("INVALID INPUT");
			  return;
		  }
		  
		  int quantity = 0;
		  try {
			quantity = Integer.parseInt(input[2]);  
		  }
		  catch (NumberFormatException e) {
			  System.out.println("quantity number is not valid");
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
		  }
		  
		  if(nameFound == false)
		  {
			  System.out.println("name not found.  invalid command");
			  return;
		  }
		  
		  sc.get(i).setQuantity(quantity);
		  
		  System.out.print("Name: " + input[1] + "  Updated Quantity: " + input[2]);
		  
		  
			 
	  }
	  
}
