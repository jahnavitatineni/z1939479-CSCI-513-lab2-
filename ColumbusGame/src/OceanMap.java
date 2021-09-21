import java.util.Arrays;
public class OceanMap {
	int[][] grid;
	int height;
	int mn, km;
	int isletC;

	public int[][] getMap() {
		// TODO Auto-generated method stub
		return grid;
	}

	public OceanMap(int height, int isletC) {
		grid = new int[height][height];
		this.height = height;
		this.isletC = isletC;
		initialize();
	}
	private void initialize() {
		// TODO Auto-generated method stub
		for (int i = 0; i < height; i++) {
			Arrays.fill(grid[i], 0);
			createIslands();
		}
	}

	private void createIslands() {
		// TODO Auto-generated method stub
		for (int k = 0; k < isletC; k++) {
			mn = (int) (Math.random() * height);
			km = (int) (Math.random() * height);
			if (grid[mn][km] == 0)
				grid[mn][km] = 1;
			else
				k--;
		}

	}

	public int getSize() {
		return height;
	}

}
