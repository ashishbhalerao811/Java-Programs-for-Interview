package javaSimplePrograms;


public class fabonacci {

	public static void main(String[] args) {

		int a=0, b=1, k=0;
		int count=10;
		System.out.print(a+" "+b);
		for(int i=2; i<=count; i++) {
		k=a+b;
		a=b;
		b=k;
		System.out.print(" "+k);
		}
		
	}

}
