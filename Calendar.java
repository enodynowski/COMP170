public class Calendar {
	public static void main(String[] args) {
		printCalendar(2, 28);
	}

	public static void printCalendar(int firstSunday, int dayCount) {
		printHeader();
		printLine();
		if (firstSunday > 1) {
			printVertical();
		}
		printBlanks(firstSunday);
		printWeekOneDates(firstSunday);
		printVertical();
		printWeekTwo(firstSunday);
		printVertical();
		printWeekThree(firstSunday);
		printVertical();
		printWeekFour(firstSunday);
		printVertical();
		printWeekFive(firstSunday, dayCount);
		if (dayCount > 28) {
			printVertical();
			printWeekSix(firstSunday, dayCount);
			printEndBlanks(firstSunday, dayCount);
		}
		else{
		printEndBlanks(firstSunday, dayCount);
		}
		System.out.println();
		printLine();
}

	public static void printBlanks(int firstSunday) {
		for (int i = 1; i <= ((firstSunday) * -1 + 8) % 7; i++) {
			printBlankDay();
		}
	}
	public static void printWeekOneDates(int firstSunday){
		for (int i = 1; i < firstSunday; i++){
			System.out.print(padded(i, 9)+ "  |");
		}
		System.out.println();
	}
	public static void printWeekTwo(int firstSunday){
		for (int j = firstSunday; j <= firstSunday + 6; j++) {
			if (j < 10) {
				System.out.print(padded(j, 9) + "  |");
			}
			else{
				System.out.print (padded(j, 9) + " |");
			}
		}
		System.out.println();
	}
	public static void printWeekThree(int firstSunday) {
		for (int j = firstSunday + 7; j <= firstSunday + 13; j++) {
			if (j < 10) {
				System.out.print(padded(j, 9) + "  |");
			} else {
				System.out.print(padded(j, 9) + " |");
			}
		}
		System.out.println();
	}
	public static void printWeekFour (int firstSunday){
		for (int j = firstSunday + 14; j <= firstSunday + 20; j++) {
			if (j < 10) {
				System.out.print(padded(j, 9) + "  |");
			} else {
				System.out.print(padded(j, 9) + " |");
			}
		}
		System.out.println();
	}
	public static void printWeekFive (int firstSunday, int dayCount) {
		if (dayCount == 28) {
			for (int j = firstSunday + 21; j <= dayCount; j++) {
				System.out.print(padded(j, 9) + " |");
			}
		}
		else {
			if (firstSunday < 4) {
				for (int j = firstSunday + 21; j <= firstSunday + 27; j++) {
					System.out.print(padded(j, 9) + " |");
				}
				System.out.println();
			}
			else {
				for (int j = firstSunday + 21; j <= dayCount; j++) {
					System.out.print(padded(j, 9) + " |");
				}
			}
		}
	}
	public static void printWeekSix (int firstSunday, int dayCount){
		for (int j = firstSunday + 28; j <= dayCount; j++){
			System.out.print(padded(j, 9) + " |");
		}
	}
	public static void printEndBlanks(int firstSunday, int dayCount){
		if (dayCount == 28) {
			for (int i = dayCount; i <= firstSunday + 26; i++) {
				printBlankDay();
			}
		}
		else{
			for (int i = dayCount; i < firstSunday + 27; i++){
				printBlankDay();
			}
		}
	}

	public static void printBlankDay(){
		System.out.print("      |");

	}
	public static void printVertical(){
		System.out.print("|");
	}
	public static String padded(int n, int width){
		String s = "" + n;
		for (int i = s.length(); i < width; i++){
			s = "   " + n;
		}
		return s;
	}
	public static void printHeader(){
		System.out.println("  Sun    Mon    Tue    Wed    Thu    Fri    Sat  ");
	}
	public static void printLine(){
		System.out.println("+------+------+------+------+------+------+------+");
	}
}








