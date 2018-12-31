package javaSimplePrograms;

public class ReverseVerticalString {

	public static void main(String[] args) {
		String s1="Ashish";
		int count=s1.length();
		char a[]=s1.toCharArray();
		for(int i=count-1; i>=0; i--) {
			
			System.out.println(a[i]);
		}

	}

}
