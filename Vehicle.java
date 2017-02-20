public class Vehicle{
 protected static double fuelCapacity;
 protected static int seats = 4; 
 protected static double cargoCapacity;
 protected static int wheels = 4;
 protected static double baseWeight = 1000;
 
 protected double money; 
 protected double fuel;
 protected int passengers;
 protected double cargo;
 protected int tires;
 protected double forwardProgress;
 protected double speed; 
 
 protected static int[] gasStops; 
 protected static final int finishLine = 2890; 
 
 static {
  gasStops = new int[10]; 
  for (int n = 0; n < 10; n++){
   gasStops[n] = 200 * n+1; 
  }
 }
 
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
  
 }
 
 public void drive(){
   fuel -= 10;
   forwardProgress += 200; 
   int chance = (int) Math.random() * 100; 
   if (chance <= 20) //Chance of losing tire = distance / 10
    tires --; 
   this.fillGas(); 

 } 
 public void drive(int distance){
   double distanceSoFar = forwardProgress + distance; 
   //Take away ten gallons of fuel for every 200 miles
   fuel -= (distance/200.0) * 10; 
   double distanceToGas = distanceSoFar % 200; 
   fuel -= (distanceToGas/200.0) * 10; 
   //check to make sure they made it to gas station
   if (fuel >= 0)
   	this.fillGas(); 
   forwardProgress += (distance + distanceToGas); 
   int chances = (int) Math.random() * 100; 
   if (chances <= (distance + (distanceToGas / 10)))
    tires --; 
   
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
  double gallons = 30 - fuel; 	
  fuel = 30; 
  money -= (gallons * 3); //each gallon costs 3 dollars
 }
 
 public void buyTire(){
  tires++; 
  money -= 90; 
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