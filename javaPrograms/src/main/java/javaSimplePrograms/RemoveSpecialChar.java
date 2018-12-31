package javaSimplePrograms;

public class RemoveSpecialChar {

	public static void main(String[] args) {
		String s1="Selenium12545%$@&*43!864";
		System.out.println(s1.replaceAll("[^a-zA-Z]", ""));
		
		System.out.println(s1.replaceAll("[^a-zA-Z0-9]", ""));
	}

}
