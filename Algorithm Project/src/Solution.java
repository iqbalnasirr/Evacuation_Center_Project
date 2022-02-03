import java.util.List;

public class Solution {
	
	// List of category to have the maximal value
	public List<Category> category;;
	// Maximal value possible
	public int value;
	
	public Solution(List<Category> category, int value) {
		this.category = category;
		this.value = value;
	}
	
	public void display() {
		if (category != null  &&  !category.isEmpty()){
			System.out.println("\nEvacuation Center");
			System.out.println("Priority = " + value);
			System.out.println("Category to pick :");
			
			for (Category category : category) {
				System.out.println(" - " + category.str());
			}
		}
	}

}