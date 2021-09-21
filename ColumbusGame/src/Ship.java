import java.awt.Point;
import java.util.Random;
public class Ship {
	Point location;
	OceanMap OCMap;
	int[][] elemen;

	public void goEast() {
		// TODO Auto-generated method stub
		if (exact(location.x + 1, location.y))
			location.x += 1;
	}
	public Point getShipReviewLocation() {
		// TODO Auto-generated method stub
		return location;
	}

	public void goWest() {
		// TODO Auto-generated method stub
		if (exact(location.x - 1, location.y))
			location.x -= 1;
	}

	public void goNorth() {
		// TODO Auto-generated method stub
		if (exact(location.x, location.y - 1))
			location.y -= 1;
	}

	public void goSouth() {
		// TODO Auto-generated method stub
		if (exact(location.x, location.y + 1))
			location.y += 1;
	}

	private boolean exact(int x, int y) {
		return x >= 0 && y >= 0 && x < OCMap.getSize() && y < OCMap.getSize() && elemen[x][y] == 0;
	}

	public Ship(OceanMap grid) {
		Random ramd = new Random();
		int x = 4, j = 4;
		elemen = grid.getMap();
		while (elemen[x][j] != 0) {
			x = ramd.nextInt(10);
			j = ramd.nextInt(10);
		}
		this.location = new Point(x, j);
		this.OCMap = grid;
	}
}
