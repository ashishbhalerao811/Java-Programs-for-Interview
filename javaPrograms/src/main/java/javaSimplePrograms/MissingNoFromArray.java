package javaSimplePrograms;

public class MissingNoFromArray {

	public static void main(String[] args) {
		int a[]= {1,2,3,5};
		int count=a.length;
		
		int sum=0;
		for(int i=0; i<count; i++) {
			
			sum=sum+a[i];
			
		}
		System.out.println("Sum of actual array is= "+sum);
		
		
		int sum1=0;
		for(int j=0; j<=5; j++) {
			
			sum1=sum1+j;
			
		}
		System.out.println("Sum of actual array is= "+sum1);
		
		
		System.out.println("Missing number in an Array is= "+(sum1-sum));
	}

}
