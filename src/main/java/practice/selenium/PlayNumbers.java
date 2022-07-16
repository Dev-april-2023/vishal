package practice.selenium;

import java.util.Scanner;

public class PlayNumbers {

	
	
	
	public void palindromeNumber() {

		int n = 1234;
		int rev = 0;

		while (n != 0) {
			rev = (rev * 10) + (n % 10);
			n = n / 10;
		}
		System.out.println(rev);
	}
	
	public static void main(String[] args) {
		PlayNumbers pn = new PlayNumbers();
		
		
		

		pn.reverseNum_Stringbuffer();

	}
	
	
	// using stringbuffer class 
	public void reverseNum_Stringbuffer() {
		
		StringBuffer sb = new StringBuffer(String.valueOf(1765));
		StringBuffer rev = sb.reverse();
		System.out.println(rev);
		
		StringBuffer sb2 = new StringBuffer(String.valueOf(12378));
		System.out.println(sb2.reverse());
		
	}
	
	//using stringbuilder class
	public void reverseNum_StringBuilder() {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the number: ");
		int n = sc.nextInt();
		
		
		StringBuilder sb = new StringBuilder();
		sb.append(n);
		StringBuilder rev = sb.reverse();
		System.out.println(rev);
	}
	
}

