public class Pyramid{
	//Declaring and initializing the class constant PYRAMID_SIZE
	public static final int PYRAMID_SIZE = 27;
	public static void main(String[] args) {
		buildPyramid();
	}
	public static void buildPyramid() {
		int rowNumber = 1;
		for (int i = PYRAMID_SIZE; i > 0; i--) {
			if (rowNumber <= 9) {
				for (int j = 1; j <= rowNumber; j++) {
					System.out.print(rowNumber + " ");
				}
			}
			/*I've included this if/else statement because when PYRAMID_SIZE gets greater than 10, the width of
			 the number 10 is too large so the pyramid looks weird. This way when rowNumber is >= 10 it prints 3
			 fewer times and makes the pyramid look nicer. It gets ugly again with triple digit numbers though.
			 Anything between 1 and 99 looks good :D */
			else {
				for (int j = 1; j <= rowNumber - 3; j++) {
					System.out.print(rowNumber + " ");
				}
			}
			System.out.println();
			rowNumber++;
		}
	}
}
