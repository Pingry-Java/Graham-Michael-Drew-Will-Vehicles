public class Vehicle{

 // protected variables for access from other classes
 // static variables which are constant for all vehicles
 protected static double fuelCapacity;
 protected static int seats = 4; 
 protected static double cargoCapacity;
 protected static int wheels = 4;
 protected static double baseWeight = 1000;
 protected Engine engine;
 
 // non-static variables which change throughout the trip
 protected double money; 
 protected double fuel;
 protected int passengers;
 protected double cargo;
 protected int tires;
 protected double forwardProgress;
 protected double speed; 
 
 protected static int[] gasStops; 
 protected static final int finishLine = 2890; 
 
 // static initializer for the array which contains the 
 // number of gas stops and the distance between each one.
 static {
  gasStops = new int[10]; 
  for (int n = 0; n < 10; n++){
   gasStops[n] = 200 * n+1; 
  }
  
 }
 
 /**
  * Default constructor for Vehicle
  * Contains values for "car" by default
  */
  public Vehicle(){
  fuelCapacity = 30; //Gallons  
  cargoCapacity = 300;  //Pounds
  money = 1000; //USD 
  fuel = 30; //Gallons 
  passengers = 5; //People 
  cargo = 0; //Pounds
  tires = 5;  
  forwardProgress = 0; //Miles 
  speed = 60; //Mph 
  engine = new Engine(); 
  
 }
 
 /**
  * Drive method, calls the overloaded drive method with 200 miles as 
  * its default value.
  * @return The drive method with 200 as distance.
  */
 public boolean drive(){ //call other method with 200
   return this.drive(200); 

 } 

 /**
  * Overloaded drive method, takes a distance and calculates how far can be traveled, subtracts the fuel and adds 
  * the specified distance traveled, and checks if tires have blown.
  * @param distance Takes in the distance which the player would like to travel.
  * @return whether the player can drive the specified distance. 
  */
 public boolean drive(int distance){
   //Test for -1 when you do required fuel
   double requiredFuel = engine.fuelRequired(speed, distance, cargo);
   double distanceToGas;
   if (requiredFuel == -1)
    System.out.println("You didn't have enough fuel. Too bad!");
  else
    System.out.println("You took about " + Math.round(requiredFuel * 1000.0) / 1000.0 + " gallons of fuel to drive " + distance + " miles."); 
   if (requiredFuel == -1)
    return false; 
   else 
   {
    fuel -= requiredFuel;
    if (fuel < 0)
      return false; 
    else
    {
      forwardProgress += distance; 
      if ((forwardProgress % 200) != 0)
        distanceToGas = 200 - (forwardProgress % 200); //this is the wrong calculation 
      else
        distanceToGas = 0; 
      double moreFuel = engine.fuelRequired(speed, distanceToGas, cargo); 
      fuel -= moreFuel; 
      if (fuel < 0)
        return false; 
      else
      {
        forwardProgress += distanceToGas;
        int chances = (int) (Math.random() * 100); // checks if your tires have blown, chances increase with distance.
        if (chances <= (distance / 20))
          tires --;
        return true; 
      }
    }
   }
   
 }

 /**
  * Checks if a vehicle is stranded (for car), is overridden in other instances of vehicle.
  * @return whether the vehicle has less than 4 tires, less than 0 fuel, or less than 0 monies
  */
 public boolean isStranded(){
  return (tires < 4 || fuel <= 0 || money <= 0);
 }
 
 /**
  * Checks if a vehicle has arrived.
  * @return whether the vehicle has traveled 2890 miles.
  */
 public boolean arrived(){
  return (forwardProgress >= finishLine);
 }
 
 /**
  * Checks the distance a vehicle must travel to the next gas stop
  * @return the number of miles until the vehicle will arrive at the next gas stop
  */
 public double distanceToNextStop(){
  return forwardProgress % 200; 
 }
 
 /**
  * Checks how much a particular vehicle weighs
  * @return the amount of weight, in pounds, of the vehicle plus cargo.
  */
 public double totalWeight(){
  return baseWeight + cargo; 
 }

 /**
  * Fills the vehicle's gas tank. Calculates how much gas was added and 
  * subtracts the cost from player's money at $3 per gallon.
  */
 public void fillGas(){
  double gallons = fuelCapacity - fuel;   
  fuel = fuelCapacity; 
  money -= (gallons * 3); //each gallon costs 3 dollars
 }
 
 /**
  * Adds some amount of cargo to the amount of cargo in the vehicle.
  * @param x The amount (in pounds) of cargo to be added.
  */
 public void loadCargo(int x){
  this.cargo+=x;
 }
 
 /**
  * Purchases some amount of cargo. Adds the amount and subtracts the price (based on amount)
  * @param x The amount of cargo to be added
  * @param cargoPrice The cost of the cargo, per pound.
  */
 public void buyCargo(int x, int cargoPrice){
  if(x*cargoPrice<this.money){
    this.cargo+=x;
    this.money-=x*cargoPrice;
  }
 }
 
 /**
  * Sells some amount of cargo. Subtracts the weight and adds the price (based on amount sold)
  * @param x The amount of cargo to be sold
  * @param cargoPrice The price of the cargo, per pound.
  */
 public void sellCargo(int x, int cargoPrice){
  if(cargo>=x){
    this.cargo-=x;
    this.money+=x*cargoPrice;
  }
 }
 
 // Modifiers =========================================================================
 /**
  * Set the fuel capacity of a vehicle to some x
  * @param x The fuel capacity a certain vehicle is being set to
  */
 public void setFuelCapacity(double x){
  fuelCapacity = x; 
 } 
 /**
  * Set the number of seats to some x
  * @param x The number of seats in the vehicle
  */
 public void setSeats(int x){
  seats = x; 
 } 
 /**
  * Set the cargo capacity to some x
  * @param x The amount of cargo capacity in the vehicle
  */
 public void setCargoCapacity(double x){
  cargoCapacity = x; 
 } 
 /**
  * Set the number of wheels to some x
  * @param x The number of wheels on the vehicle
  */
 public void setWheels(int x){
  wheels = x; 
 } 
 /**
  * Set the weight of the vehicle to some x
  * @param x The weight of the vehicle
  */
 public void setBaseWeight(double x){
  baseWeight = x;
 } 
 /**
  * Set the amount of money in dollars to some x
  * @param x The amount of money the player has
  */
 public void setMoney(double x){
  money = x; 
 } 
 /**
  * Set the amount of fuel in gallons to some x
  * @param x The amount of fuel in the vehicle
  */
 public void setFuel(double x){
  fuel = x; 
 } 
 /**
  * Set the number of passengers to some x
  * @param x The number of passengers in the vehicle
  */
 public void setPassengers(int x){
  passengers = x; 
 } 
 /**
  * Set the amount of cargo to some x
  * @param x The amount of cargo in the vehicle
  */
 public void setCargo(double x){
  cargo = x; 
 } 
 /**
  * Set the number of tires being carried to some x
  * @param x The number of tires the vehicle is carrying
  */
 public void setTires(int x){
  tires = x; 
 } 
 /**
  * Set the total amount of distance traveled to some x
  * @param x The total distance the vehicle has traveled
  */
 public void setForwardProgress(int x){
  forwardProgress = x; 
 } 
 /**
  * Set the average speed to some x
  * @param x The average speed of the vehicle
  */
 public void setSpeed(double x){
  speed = x; 
 } 
 
 // Accessors =========================================================================
 /**
  * Get the fuel capacity of a vehicle
  * @return The fuel capacity of the vehicle
  */
 public double getFuelCapacity(){
  return fuelCapacity;  
 } 
 /**
  * Get the number of seats in a vehicle
  * @return The number of seats in the vehicle
  */
 public int getSeats(){
  return seats; 
 } 
 /**
  * Get the cargo capacity of a vehicle
  * @return The cargo capacity of the vehicle
  */
 public double getCargoCapacity(){
  return cargoCapacity; 
 } 
 /**
  * Get the number of wheels on a vehicle
  * @return The number of wheels on the vehicle
  */
 public int getWheels(){
  return wheels; 
 } 
 /**
  * Get the weight of a vehicle (excluding cargo, engine and passangers)
  * @return The base weight of the vehicle
  */
 public double getBaseWeight(){
  return baseWeight; 
 } 
 /**
  * Get the total weight of a vehicle
  * @return The total weight of the vehicle
  */
 public double getWeight(){
  return baseWeight + engine.getWeight() + this.cargo + this.passengers*150 + this.tires*10;
 }
 /**
  * Get the amount of money a player has
  * @return The amount of money the player has
  */
 public double getMoney(){
  return money; 
 } 
 /**
  * Get the amount of fuel in a vehicle
  * @return The amount fuel in the vehicle
  */
 public double getFuel(){
  return fuel; 
 } 
 /**
  * Get the number of passangers in the vehicle
  * @return The number of passangers in the vehicle
  */
 public int getPassengers(){
  return passengers; 
 } 
 /**
  * Get the cargo weight in a vehicle
  * @return The weight of the cargo in a vehicle
  */
 public double getCargo(){
  return cargo; 
 } 
 /**
  * Get the number of tires the vehicle is carrying
  * @return The total number of tires on the vehicle
  */
 public int getTires(){
  return tires; 
 } 
 /**
  * Get the total distance the vehicle has traveled
  * @return The total distance traveled by the vehicle
  */
 public double getForwardProgress(){
  return forwardProgress; 
 } 
 /**
  * Get the average speed of a vehicle
  * @return The average speed of the vehicle
  */
 public double getSpeed(){
  return speed; 
 } 
}