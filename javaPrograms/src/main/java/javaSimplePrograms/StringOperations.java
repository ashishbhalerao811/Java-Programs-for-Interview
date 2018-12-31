package javaSimplePrograms;

public class StringOperations {

	public static void main(String[] args) {
		String s1="Welcome to Java World";
		String s2="Java";
		String s3=new String("Welcome to Java World");
		
		
//		System.out.println("contains(s2) ---"+s1.contains(s2));
//
//		
//		System.out.println("equals(s3) ---"+s1.equals(s3)); // It checks only values
//		
//		System.out.println("compareTo(s3) ---"+s1.compareTo(s3)); //positive , negative
//		
//		System.out.println("==  ---"+s1==(s3));//It check Reference and value
//		
//		
//		System.out.println("------------------------------");
//		
		//Vertical split
			String a[]=s2.split("");
			int count=a.length;
			System.out.println("Length of the string is==="+count);
			for(int i=count-1; i>=0; i--) {
				System.out.println(a[i]);
		}
		//Horizontal split
//		int count=s2.length();
//		String rev=" ";
//		for(int i=count-1; i>=0; i--) {
//			rev=rev+s2.charAt(i);
//			
//			
//		}
//		System.out.println(rev);
	}

}
