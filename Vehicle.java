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
 protected double odometer;
 protected double forwardProgress;
 protected double speed; 
 
 protected static int[] gasStops; 
 protected static final finishLine = 2890; 
 
 static {
  gasStops = new int[10]
  for (int n = 0; n < 10; n++){
   gasStops[n] = 200 * n+1 
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
  odometer = 0; //Miles 
  forwardProgress = 0; //Miles 
  speed = 60; //Mph 
  
 }
 
 public void drive(){
   fuel -= 10;
   odometer += 200;
   forwardProgress += 200; 
   chance = (int) Math.random() * 100; 
   if (chance = 1)
    tires --; 

 } 
 public void driver(int distance){
 
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
  return weight + cargo; 
 }
 
 public void fillGas(){
  fuel == 30; 
 }
 
 //Modifiers 
 
 public void setFuelCapacity(double x){
  fuelCapcity = x; 
 } 
 public void setSeats(int x){
  seats = x; 
 } 
 public void setCargoCapacity(double x){
  cargoCapcity = x; 
 } 
 public void setWheels(int x){
  wheels = x; 
 } 
 public void setBaseWeight(double x){
  baseWeight = x;
 } 
 public void setFuelCapacity(double x){
  fuelCapcity = x 
 } 
 public void setFuelCapacity(double x){
  fuelCapcity = x 
 } 
 public void setFuelCapacity(double x){
  fuelCapcity = x 
 } 
 public void setFuelCapacity(double x){
  fuelCapcity = x 
 } 
 public void setFuelCapacity(double x){
  fuelCapcity = x 
 } 
 public void setFuelCapacity(double x){
  fuelCapcity = x 
 } 
 public void setFuelCapacity(double x){
  fuelCapcity = x 
 } 
 public void setFuelCapacity(double x){
  fuelCapcity = x 
 } 
 public void setFuelCapacity(double x){
  fuelCapcity = x 
 } 
 public void setFuelCapacity(double x){
  fuelCapcity = x 
 } 
 public void setFuelCapacity(double x){
  fuelCapcity = x 
 } 
 public void setFuelCapacity(double x){
  fuelCapcity = x 
 } 
 public void setFuelCapacity(double x){
  fuelCapcity = x 
 } 
 public void setFuelCapacity(double x){
  fuelCapcity = x 
 } 
}