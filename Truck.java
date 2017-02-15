public class Truck extends Vehicle {
 
 //OVERRIDE static fields
 protected static double fuelCapacity;
 protected static int seats = 4; 
 protected static double cargoCapacity;
 protected static int wheels = 18;
 protected static double baseWeight = 6000;
 
 public Truck(){
  fuelCapacity = 50; //Gallons  
  cargoCapacity = 600;  //Pounds
  money = 1000; //USD 
  fuel = 50; //Gallons 
  passengers = 4; //People 
  cargo = 0; //Pounds
  tires = 5; 
  odometer = 0; //Miles 
  forwardProgress = 0; //Miles 
  speed = 50; //Mph 
 }
 
 public void loadCargo(int cargo){
  this.cargo += cargo; 
 }
 
 
 
}