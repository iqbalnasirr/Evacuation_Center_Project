public class Category {
	
	public String name;
	public int value;
	public int weight;
	
	public Category(String name, int value, int weight) {
		this.name = name;
		this.value = value;
		this.weight = weight;
	}
	
	public String str() {
		return name + " [Priority = " + value + ", Number of victim = " + weight + "]";
	}

}