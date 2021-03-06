import java.util.Scanner; 

public class RoadTrip
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in); 
		int cargoPrice;
		
		// friendly greeting
		System.out.println("Welcome to Road Trip, a REALLY fun, interactive game!"); 
		System.out.println("Please type what type of vehicle you would like to drive: bus, car, motorcycle, truck?"); 
		String vehicleType = keyboard.nextLine(); 
		
		Vehicle vehicle;
		 
		// Checks the user's selection of vehicle
		if (vehicleType.equals("bus"))
			vehicle = new Bus(); 
		else if (vehicleType.equals("car"))
			vehicle = new Car(); 
		else if (vehicleType.equals("truck"))
			vehicle = new Truck(); 
		else
			vehicle = new Motorcycle();
 
 		//background story
		System.out.println("You are starting in New York. Will you make it across the country to San Francisco?");
		System.out.println("I will fill the first tank of gas for you. Gas is 3 dollars a gallon, a tire is $90");
		System.out.println("BEWARE - the probability of blowing out a tire increases with distance traveled.\n"); 		
		
		// Fills the tank of gas to begin the game
		vehicle.fillGas();  
		
		// Gets passengers in the vehicle for weight
		System.out.println("How many passangers will you take in your vehicle? "); 
		int passengers = keyboard.nextInt(); 
		keyboard.nextLine(); 
		vehicle.setPassengers(passengers); 
		//Passengers are cargo
		int weighCargo = passengers * 150; 
		
		//Ask if they want cargo
		System.out.println("How much cargo will you add? "); 
		int cargo = keyboard.nextInt(); 
		keyboard.nextLine(); 
		vehicle.setCargo(weighCargo + cargo); 
		
		boolean drive = true; 
		boolean driveDistance = true; 
		
		// checks if a vehicle is stranded (conditions vary between vehicles)
		while (!(vehicle.isStranded()))
		{
			System.out.println("Type yes if you would just like to drive to the next gas station (get a full tank) and no if you want to input how far to drive: "); 
			if (keyboard.nextLine().equals("yes"))
				drive = vehicle.drive();  
			else
			{
				System.out.println("How far do you want to drive? This is a risk..."); 
				int distance = keyboard.nextInt(); 
				keyboard.nextLine(); 
				driveDistance = vehicle.drive(distance); 
			}
			if (drive == false)
			{
				System.out.println("The requested operation was unsuccessful. Your vehicle was not equipped.");
				break; 
			}

			// checks the specifics of why the vehicle is stranded
			if (vehicle.isStranded())
			{
				if (vehicle.getTires() < vehicle.getTires()){
					System.out.println("Your tires exploded! Now you must walk. So terrible!"); 
					break; 
				}
				else if (vehicle.getFuel() <= 0){
					System.out.println("Your gas tank is dry as the desert. Now you must walk. So terrible!"); 
					break;
				}
				else if (vehicle.getMoney() <= 0){
					System.out.println("You have no money, and your car doesn't drive poor people. Now you must walk. So terrible!");
					break;
				}

			}
			// check if the vehicle has driven all the miles
			if (vehicle.arrived()) 
			{
				System.out.println("YOU WON!!!"); 
				break; 
			}
			
			//Tell them the resources they have left
			printResources(vehicle);
			
			System.out.println();
			
			
			if (vehicle.getForwardProgress()%200==0){
			
				cargoPrice = (int)(Math.random()*11+5);
			
				System.out.println("Please type 'yes' if you would like to top up your vehicle");
				if (keyboard.nextLine().equals("yes")){
				
					if (((vehicle.getFuelCapacity() - vehicle.getFuel())*3) > vehicle.getMoney()){
						System.out.println("I'm sorry, you don't have enough money for that");
						System.out.println("Would you like to sell some cargo?");
						if (keyboard.nextLine().equals("yes"))
							sellItems(vehicle, cargoPrice, keyboard);
					}
					
					if (((vehicle.getFuelCapacity() - vehicle.getFuel()) * 3) <= vehicle.getMoney())
						vehicle.fillGas();
				}
				System.out.println("Please type 'yes' if you would like to purchase a tire for the journey"); 
				String next = keyboard.nextLine();
				if (next.equals("yes"))
				{
					if (vehicle.getMoney() < 90)
						System.out.println("I'm sorry, you don't have enough money for that."); 
					else
					{
						vehicle.setTires(vehicle.getTires() + 1); 
						vehicle.setMoney(vehicle.getMoney() - 90);
					} 
				}
			}
				
		}
	}
	
	public static void printResources(Vehicle vehicle){
		System.out.println("RESOURCES REMAINING"); 
		System.out.println("\tGallons of gas: " + Math.round(vehicle.getFuel() * 1000.0) / 1000.0); 
		System.out.println("\tTires remaining: " + vehicle.getTires()); 
		System.out.println("\tDistance traveled: " + vehicle.getForwardProgress());
		System.out.println("\tMoney remaining: " + vehicle.getMoney()); 
	}
	
	public static void sellItems(Vehicle vehicle, int cargoPrice, Scanner keyboard){
		System.out.println("This station is selling cargo for " + cargoPrice + " dollars");
		System.out.println("How much cargo would you like to sell?");
		vehicle.sellCargo(Integer.parseInt(keyboard.nextLine()), cargoPrice);
	}
	
	public static void buyItems(Vehicle vehicle, int cargoPrice, Scanner keyboard){
		System.out.println("This station is selling cargo for " + cargoPrice + " dollars");
		System.out.println("How much cargo would you like buy?");
		vehicle.buyCargo(Integer.parseInt(keyboard.nextLine()), cargoPrice);
	}
}