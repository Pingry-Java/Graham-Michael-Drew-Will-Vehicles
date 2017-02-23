public class Engine{
	private int cylinders; // this is the basic indicator for the strength of an engine
	private double weight;
	
	public Engine(){
		this(6);
	}
	public Engine(int cylinders){
		this.cylinders= cylinders;
		this.weight = cylinders * cylinders * cylinders; 
	}
	
	public double fuelRequired(double speed, double distance, double cargo)
	{
		if ((speed * (weight + cargo)) > (cylinders * 800))
			return -1; 
		else
			return .000000007 * distance * (weight + cargo) * speed * speed; //just used a calculated constant
	}
	
	public double getWeight(){
		return this.weight;
	}
	
}