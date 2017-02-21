import java.util.Scanner; 

public class RoadTrip
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in); 
		System.out.println("Welcome to Road Trip, a REALLY fun, interactive game!"); 
		System.out.println("Please type what type of vehicle you would like to drive: bus, car, motorcycle, truck?"); 
		String vehicleType = keyboard.nextLine(); 
		
		Vehicle vehicle; 
		if (vehicleType.equals("bus"))
			vehicle = new Bus(); 
		else if (vehicleType.equals("car"))
			vehicle = new Car(); 
		else if (vehicleType.equals("truck"))
			vehicle = new Truck(); 
		else
			vehicle = new Motorcycle();
		
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
			printResources();
			
			System.out.println();
			
			if (vehicle.getForwardProgress()%200==0){
				System.out.println("Please type 'yes' if you would like to top up your vehicle");
				if (keyboard.nextLine().equals("yes")){
				
					if ((30-vehicle.getFuel())*3>vehicle.getMoney()){
						System.out.println("I'm sorry, you don't have enough money for that");
						System.out.println("Would you like to sell some cargo?");
						if (keyboard.nextLine().equals("yes")
							sellItems(vehicle);
					}
					
					if ((30-vehicle.getFuel())*3<=vehicle.getMoney(){
						vehicle.fillGas();
					}
				}
				System.out.println("Please type 'yes' if you would like to purchase a tire for the journey"); 
				while (keyboard.nextLine().equals("yes")){
				
					if (vehicle.getMoney()<90){
						System.out.println("I'm sorry, you don't have enough money for that");
						System.out.println("Would you like to sell some cargo?");
						if (keyboard.nextLine().equals("yes")
							sellItems(vehicle);
					}
					
					if (vehicle.getMoney()>=90){
						vehicle.buyTire(); 
					}
				
		}
	}
	
	public static void printResources(){
		System.out.println("RESOURCES REMAINING"); 
		System.out.println("\tGallons of gas: " + vehicle.getFuel()); 
		System.out.println("\tTires remaining: " + vehicle.getTires()); 
		System.out.println("\tDistance traveled: " + vehicle.getForwardProgress());
		System.out.println("\tMoney remaining: " + vehicle.getMoney()); 
	}
	
	public static void sellItems(vehicle vehicle){
		System.out.println("You have " + vehicle.getMoney() + " dollars left");
		System.out.println("How much cargo would you like to sell?");
		vehicle.sellCargo(Integer.parseInt(keyboard.nextLine()));
	}
}