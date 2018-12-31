package javaSimplePrograms;

import java.util.HashSet;
import java.util.Set;

public class DuplicateString2 {

	public static void main(String[] args) {
		String names[]= {"Java", "Selenium", "C", "JavaScript", "Java", "C"};
		int count=names.length;
		
		Set<String> store=new HashSet<String>();
		for (String name : names) {
			if(store.add(name)==false) {
				System.out.println("Duplicate element is=="+name);
				
			}
		}
		
		
	}

}
