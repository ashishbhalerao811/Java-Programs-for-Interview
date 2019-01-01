package javaSimplePrograms;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class StringOperations {

	public static void main(String[] args) {
		String s1="Welcome to Java World";
		String s2="Java";
		String s3=new String("Welcome to Java World");
		
		System.out.println("String s1= "+s1);
		System.out.println("String s2= "+s2);
		System.out.println("String s3= "+s3);
		
		//1. comparison---
		//a. .equals()===== It only checks content not reference
		System.out.println(s1.equals(s3));
		
		//b. == ---It checks both content and reference
		System.out.println(s1== s3);
		
		//c. .compareTo() === It checks both content and returns integer (0, positive , negative)
		System.out.println(s1.compareTo(s3));
		
		
		//2. substring()
		System.out.println(s1.substring(5));		// from index
		System.out.println(s1.substring(3, 10));	// limit
		
		
		//3. split()
		String a[]=s1.split(" ");
		int count=a.length;
		for(int i=0; i<count; i++) {
			
			System.out.println(a[i]);
			
		}
		
		
		
		System.out.println(("***************"));
		
		//4. startsWith() , endsWith()
		System.out.println(s1.startsWith("W"));// it checks content (small/capital words).
		System.out.println(s1.endsWith("world")); // it checks content (small/capital words).
		
		//5. replace()
		System.out.println(s1.replace("W", "Universe_"));
		
		String date="01-01-2019";
		System.out.println(date.replace("-", "/"));
		System.out.println(date.replace("-", ""));
		
		//6. replaceFirst()
		System.out.println(s1.replaceFirst("W", "X"));
		
		//7. replaceAll()
		System.out.println(s1.replaceAll("W", "Universe_"));
		
		//8. remove()=== there is no such method in a string or StringBuffer class. 
		// we can use relace() to remove any char or string
		System.out.println(s1.replace("World", ""));
		System.out.println(s2.replace("J", ""));
		
		//9. concat()
		int y=10;
		int x=20;
		System.out.println(s2+y+x);// Java1020, as compiler starts compiling from left.

		System.out.println(y+x+s2);
		
		//10. length()
		System.out.println(s2.length());
		
		//11. contains()
		System.out.println("s1= "+s1);

		System.out.println("s2= "+s2);
		System.out.println(s1.contains(s2));
		System.out.println(s2.contains(s1));
		System.out.println(s1.contains(s1));
		System.out.println(s2.contains(s2));
		
		//12.intern()
		System.out.println("s1= "+s1);

		System.out.println("s3= "+s3);
		System.out.println(s1==s3);

		System.out.println(s1==(s3.intern()));
			
		//13. isEmpty()
		String s4="";
		
		System.out.println(s1.isEmpty());
		System.out.println("s4 is empty");
		System.out.println(s4.isEmpty());
		
		//14. toUpperCase(), toLowerCase()
		System.out.println(s1.toUpperCase());
		System.out.println(s1.toLowerCase());
	}

}
