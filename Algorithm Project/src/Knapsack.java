import java.util.ArrayList;
import java.util.List;

public class Knapsack {
	
  // Category of the victims
  private Category[] category;
  // capacity of the victims
  private int capacity;

  public Knapsack(Category[] category, int capacity) {
    this.category = category;
    this.capacity = capacity;
  }

  public void display() {
    if (category != null  &&  category.length > 0) {
      System.out.println("Evacuation Center");
      System.out.println("Capacity : " + capacity);
      System.out.println("Category :");

      for (Category category : category) {
        System.out.println("- " + category.str());
      }
    }
  }

  // The solve algorithm
  public Solution solve() {
    int NB_CATEGORY = category.length;
    // Matrix is used to store the max value at each n-th category
    int[][] matrix = new int[NB_CATEGORY + 1][capacity + 1];

    // first line is initialized to 0
    for (int i = 0; i <= capacity; i++)
      matrix[0][i] = 0;

    // Iterate on category
    for (int i = 1; i <= NB_CATEGORY; i++) {
      // Iterate on each capacity
      for (int j = 0; j <= capacity; j++) {
        if (category[i - 1].weight > j)
          matrix[i][j] = matrix[i-1][j];
        else
          // Maximize value at this rank in the matrix
          matrix[i][j] = Math.max(matrix[i-1][j], matrix[i-1][j - category[i-1].weight] 
				  + category[i-1].value);
      }
    }

    int res = matrix[NB_CATEGORY][capacity];
    int w = capacity;
    List<Category> itemsSolution = new ArrayList<>();

    for (int i = NB_CATEGORY; i > 0  &&  res > 0; i--) {
      if (res != matrix[i-1][w]) {
        itemsSolution.add(category[i-1]);
   
        res -= category[i-1].value;
        w -= category[i-1].weight;
      }
    }

    return new Solution(itemsSolution, matrix[NB_CATEGORY][capacity]);
  }

  public static void main(String[] args) {
    // Take the same instance of the problem displayed in the image
	  Category[] category = {new Category("Adult", 4, 200), 
	                new Category("Teenagers", 5, 120), 
					new Category("Family with Kids", 7, 300), 
                    new Category("Elderly", 8, 150)};

    Knapsack knapsack = new Knapsack(category, 500);
    knapsack.display();
    Solution solution = knapsack.solve();
    solution.display();
  }
}