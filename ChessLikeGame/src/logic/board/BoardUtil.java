package logic.board;

public class BoardUtil {
	public static final int NUM_TILES = 36;

	public BoardUtil() {
		throw new RuntimeException("you Cannot instsntiate me!!");
	}

	public static boolean isValidTileCoordinate(int coordinate) {
		return coordinate >= 0 && coordinate < NUM_TILES;
	}

	public static boolean FIRST_COL(int colNumber) {
		if (colNumber == 0 || colNumber == 6 || colNumber == 12 || colNumber == 18 || colNumber == 24
				|| colNumber == 30)
			return true;
		return false;

	}

	public static boolean SECOND_COL(int colNumber) {
		if (colNumber == 1 || colNumber == 7 || colNumber == 13 || colNumber == 19 || colNumber == 25
				|| colNumber == 31)
			return true;
		return false;

	}

	public static boolean FIFTH_COL(int colNumber) {
		if (colNumber == 4 || colNumber == 10 || colNumber == 16 || colNumber == 22 || colNumber == 28
				|| colNumber == 34)
			return true;
		return false;
	}

	public static boolean SIXTH_COL(int colNumber) {
		if (colNumber == 5 || colNumber == 11 || colNumber == 17 || colNumber == 23 || colNumber == 29
				|| colNumber == 35)
			return true;
		return false;
	}

}
