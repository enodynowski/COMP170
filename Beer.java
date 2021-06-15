public class Beer {
	public static void main(String[] args) {
		beerSong();
	}
	public static void beerSong() {
		int beerCount = 0;
		for (int i = 10; i >= beerCount; i--) {
			if (i > 0) {
				System.out.println(i + " bottles of beer on the wall, " + i + " bottles of beer.");
				System.out.print("Take one down, pass it around " + (i - 1) + " bottles of beer on the wall\n\n");
			}
		}
	}
}
