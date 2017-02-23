public class Bus extends Vehicle{
 protected static double fuelCapacity;
 protected static int seats = 30; 
 protected static double cargoCapacity;
 protected static int wheels = 8;
 protected static double baseWeight = 750;
 
 
 public Bus(){
  fuelCapacity = 40; //Gallons  
  cargoCapacity = 300;  //Pounds
  money = 1000; //USD 
  fuel = 0; //Gallons 
  passengers = 30; //People 
  cargo = 0; //Pounds
  tires = 10; 
  forwardProgress = 0; //Miles 
  speed = 50; //Mph 
  engine = new Engine(8); 
 }
 
 public boolean isStranded(){
  return (tires < 8 || fuel <= 0 || money <= 0);
 }
}