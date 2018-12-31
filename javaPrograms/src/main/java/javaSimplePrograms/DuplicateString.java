package javaSimplePrograms;

public class DuplicateString {

	public static void main(String[] args) {
		String names[]= {"Java", "Selenium", "C", "JavaScript", "Java", "C"};
		int count=names.length;
		for(int i=0; i<count; i++) {
			for(int j=i+1; j<count; j++) {
				
				if(names[i].equals(names[j])) {
					
				System.out.println("Duplicate element is="+names[i]);
				}
			}
			
		}
			
			
		
		
		
	}

}
