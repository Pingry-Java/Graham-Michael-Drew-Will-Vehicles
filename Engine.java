public class Engine{
	private int cylinders; // this is the basic indicator for the strength of an engine
	private int weight;
	
	public Engine(){
		this(6);
	}
	public Engine(int cylinders){
		this.cylinders=cylinders; // we don't have to do anything with this number
		this.weight = cylinders * cylinders * cylinders; // we don't have to do anything with this number
	}
	
}