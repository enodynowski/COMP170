public class Distance
{
	public static void main(String[] args) 
	{
		calculateDistance(10,2,3,15);
	}
	public static void calculateDistance(int x1, int y1, int x2, int y2 ){
		double d = Math.sqrt((Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2)));
		System.out.print(d);
	}
}
