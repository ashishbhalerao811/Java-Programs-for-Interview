package javaSimplePrograms;

public class LargestSmallestNoInArray {

	public static void main(String[] args) {
		
		int a[]= {1,0,-5,50,865};
		int count=a.length;
		int max=a[0];
		int min=a[0];
		for(int i=1; i<count; i++) {
			if(a[i]>max) {
				max=a[i];
			}
			
			else if(a[i]<min) {
				
				min=a[i];
				
			}
		}
		System.out.println(max);
		
		System.out.println(min);
		
	}

}
