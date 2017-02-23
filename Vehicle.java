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
   System.out.println(requiredFuel); 
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
 public boolean isStranded(){
  return (tires < 4 || fuel <= 0 || money <= 0);
 }
 
 public boolean arrived(){
  return (forwardProgress >= finishLine);
 }
 
 
 public double distanceToNextStop(){
  return forwardProgress % 200; 
 }
 
 
 public double totalWeight(){
  return baseWeight + cargo; 
 }
 
 public void fillGas(){
  double gallons = fuelCapacity - fuel;   
  fuel = fuelCapacity; 
  money -= (gallons * 3); //each gallon costs 3 dollars
 }
 
 public void loadCargo(int x){
  this.cargo+=x;
 }
 
 public void buyCargo(int x, int cargoPrice){
  if(x*cargoPrice<this.money){
    this.cargo+=x;
    this.cargo-=x*cargoPrice;
  }
 }
 
 public void sellCargo(int x, int cargoPrice){
  if(cargo>=x){
    this.cargo-=x;
    this.money+=x*cargoPrice;
  }
 }
 
 //Modifiers 
 
 public void setFuelCapacity(double x){
  fuelCapacity = x; 
 } 
 public void setSeats(int x){
  seats = x; 
 } 
 public void setCargoCapacity(double x){
  cargoCapacity = x; 
 } 
 public void setWheels(int x){
  wheels = x; 
 } 
 public void setBaseWeight(double x){
  baseWeight = x;
 } 
 public void setMoney(double x){
  money = x; 
 } 
 public void setFuel(double x){
  fuel = x; 
 } 
 public void setPassengers(int x){
  passengers = x; 
 } 
 public void setCargo(double x){
  cargo = x; 
 } 
 public void setTires(int x){
  tires = x; 
 } 
 public void setForwardProgress(int x){
  forwardProgress = x; 
 } 
 public void setSpeed(double x){
  speed = x; 
 } 
 
 //Accessors
public double getFuelCapacity(){
  return fuelCapacity;  
 } 
 public int getSeats(){
  return seats; 
 } 
 public double getCargoCapacity(){
  return cargoCapacity; 
 } 
 public int getWheels(){
  return wheels; 
 } 
 public double getBaseWeight(){
  return baseWeight; 
 } 
 public double getWeight(){
  return baseWeight + engine.getWeight() + this.cargo + this.passengers*150 + this.tires*10;
 }
 public double getMoney(){
  return money; 
 } 
 public double getFuel(){
  return fuel; 
 } 
 public int getPassengers(){
  return passengers; 
 } 
 public double getCargo(){
  return cargo; 
 } 
 public int getTires(){
  return tires; 
 } 
 public double getForwardProgress(){
  return forwardProgress; 
 } 
 public double getSpeed(){
  return speed; 
 } 
}