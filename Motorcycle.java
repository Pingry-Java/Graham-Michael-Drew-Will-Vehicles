public class Motorcycle extends Vehicle{
 protected static double fuelCapacity;
 protected static int seats = 2; 
 protected static double cargoCapacity;
 protected static int wheels = 2;
 protected static double baseWeight = 750;
 
 
 public Motorcycle(){
  fuelCapacity = 15; //Gallons  
  cargoCapacity = 40;  //Pounds
  money = 1000; //USD 
  fuel = 0; //Gallons 
  passengers = 2; //People 
  cargo = 0; //Pounds
  tires = 3; 
  forwardProgress = 0; //Miles 
  speed = 60; //Mph 
  engine = new Engine(4); 
 }
 
 public boolean isStranded(){
  return (tires < 2 || fuel <= 0 || money <= 0);
 }
}