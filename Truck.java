public class Truck extends Vehicle {
 
 //OVERRIDE static fields
 protected static double fuelCapacity;
 protected static int seats = 4; 
 protected static double cargoCapacity = 1000;
 protected static int wheels = 18;
 protected static double baseWeight = 6000;
 
 public Truck(){
  fuelCapacity = 50; //Gallons  
  cargoCapacity = 600;  //Pounds
  money = 1000; //USD 
  fuel = 50; //Gallons 
  passengers = 4; //People 
  cargo = 0; //Pounds
  tires = 20; 
  forwardProgress = 0; //Miles 
  speed = 50; //Mph 
  engine = new Engine(8); 
 }
 
 public boolean isStranded(){
  return (tires < 18 || fuel <= 0 || money <= 0);
 }
 
 
}