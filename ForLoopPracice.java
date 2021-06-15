public class ForLoopPracice // copy this program to a new <name>.java file
// change the name of this class to match the new file name (the part before .java)
{
	public static void main(String[] args) 
	{
		for (int i = 1; i<=10; i++){
			System.out.println("a loop: " + i);
			for (int j = 1; j<=10; j++){
				System.out.println("   b loop: "+j);
			}
			for (int j = 1; j<=10; j++){
				System.out.println("      c loop: "+j);
			}
		}
	}
}
