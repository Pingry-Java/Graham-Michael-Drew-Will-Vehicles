import java.util.Scanner; 

public class RoadTrip
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in); 
		System.out.println("Welcome to Road Trip, a REALLY fun, interactive game!"); 
		System.out.println("Please type what type of vehicle you would like to drive: bus, car, motorcycle, truck?"); 
		String vehicleType = keyboard.nextLine(); 
		
		Bus vehicle = new Bus(); 
		/*if (vehicleType.equals("bus"))
			Vehicle vehicle = new Bus(); 
		else if (vehicleType.equals("car"))
			Vehicle vehicle = new Car(); 
		else if (vehicleType.equals("truck"))
			Vehicle vehicle = new Truck(); 
		else
			Vehicle vehicle = new Motorcycle(); */
		
		System.out.println("You are starting in New York. Will you make it across the country to San Francisco?");
		System.out.println("I will fill the first tank of gas for you. Gas is 3 dollars a gallon, a tire is $90");
		System.out.println("BEWARE - the probability of blowing out a tire increases with distance traveled."); 
		System.out.println();
		
		
		vehicle.fillGas();  
		while (!(vehicle.isStranded()))
		{
			System.out.println("Type yes if you would just like to drive to the next gas station and no if you want to input how far to drive: "); 
			if (keyboard.nextLine().equals("yes"))
				vehicle.drive(); 
			else
			{
				System.out.println("How far do you want to drive? This is a risk..."); 
				int distance = keyboard.nextInt(); 
				keyboard.nextLine(); 
				vehicle.drive(distance); 
			}
			if (vehicle.isStranded())
			{
				System.out.println("You got stranded and now you must walk. So terrible!"); 
				break; 
			}
			if (vehicle.arrived())
			{
				System.out.println("YOU WON!!!"); 
				break; 
			}
			
			//Tell them the resources they have left
			System.out.println("RESOURCES REMAINING"); 
			System.out.println("\tGallons of gas: " + vehicle.getFuel()); 
			System.out.println("\tTires remaining: " + vehicle.getTires()); 
			System.out.println("\tDistance traveled: " + vehicle.getForwardProgress());
			System.out.println("\tMoney remaining: " + vehicle.getMoney());  
			
			System.out.println();
			System.out.println("Please type 'yes' if you would like to purchase another tire for the journey"); 
			if (keyboard.nextLine().equals("yes"))
				vehicle.buyTire(); 
				
		}
	}
}