public class Template {
    public static void main(String[] args){
		System.out.println(pow(3,4));
	}
	public static int pow(int n, int y){
		int sum = n;
        System.out.println(sum);
		for (int i = 1; n>=0;){
			sum = pow(n,y);
		}
		return sum;
	}
}
