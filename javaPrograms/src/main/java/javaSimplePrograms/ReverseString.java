package javaSimplePrograms;

public class ReverseString {

	public static void main(String[] args) {
		String s1="Ashish";
		int count=s1.length();
		String rev="";
		for(int i=count-1; i>=0; i--) {
			rev=rev+ s1.charAt(i);
			
		}
		System.out.println(rev);
	}

}
