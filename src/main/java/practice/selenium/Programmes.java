package practice.selenium;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Programmes {

	public static void main(String[] args) throws IOException {
		//palindromeNumber();
		//palindromeNumberWithStringBuffer();
		//palindromeNumberWithStringBuilder();
		//palindromeString();
		//palindromeStringWithStringBuffer();
		//palindromeStringWithStringBuilder();
		//findDuplicateWordsInString();
		//findDuplicateCharacters();
		//fibnosciSeries();
		//findMissingNumberInArray();
		//maxAndMinInArray();
		//minAndMaxWithoutCollections();
		//duplicateEleInArrayWithoutMap();
		//convertArrayToArrayList();
		//writeDataInTextFile();
		textFileReader();
		
		
		
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	public static void palindromeNumber() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number to make it reverse: ");
		int num = sc.nextInt();
		int originalnum =num;
		int revnum = 0;
		
		while(num>0) {
			
			revnum = (revnum*10)+num%10;
			num = num/10;
		}
		System.out.println("Reverse number is: "+revnum);
		if(revnum==originalnum) {
			System.out.println("given number is palindrome number");
		}
		else {
			System.out.println("given number is not a palindrome");
		}
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public static void palindromeNumberWithStringBuffer() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number");
		int a = sc.nextInt();
		StringBuffer sb = new StringBuffer(String.valueOf(a));
		System.out.println("Number after reversing is :" + sb.reverse());
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	public static void palindromeNumberWithStringBuilder() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int a = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		sb.append(a);
		System.out.println("Number after reverse: "+ sb.reverse());
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	public static void palindromeString() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String to make it reverse : ");
		String str = sc.next();
		String org_str = str;
		String revstr="";
		
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			revstr = c+ revstr;
		}
		System.out.println("String after reverse: "+revstr);
		if(org_str.equalsIgnoreCase(revstr)) {
			System.out.println("String is a palindrome");
		}
		else {
			System.out.println("String is not a plindrome");
		}
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	public static void palindromeStringWithStringBuffer() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String to make it reverse : ");
		String str = sc.next();
		
		StringBuffer sb = new StringBuffer(str);
		System.out.println("String after reverse: "+sb.reverse());
		
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	public static void palindromeStringWithStringBuilder() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String to make it reverse : ");
		String str = sc.next();
		
		StringBuilder sb = new StringBuilder(str);
		System.out.println("String after reverse: "+sb.reverse());
		
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	public static void findDuplicateWordsInString() {
		
		String str = "java is a programming language and groov-is-a-scripting language";
		String words[] = str.split("\\s+|-");
		System.out.println(Arrays.toString(words));
		Map<String,Integer> wordmap = new HashMap<String,Integer>();
		
		for(String word: words) {
			if(wordmap.get(word)!=null) {
				wordmap.put(word, wordmap.get(word)+1);
			}
			else {
				wordmap.put(word, 1);
			}
		}
		Set<String> setstr = wordmap.keySet();
		
		for(String strkey:setstr) {
			
			if(wordmap.get(strkey)>1) {
				System.out.println("For "+strkey+": there are "+wordmap.get(strkey)+" duplicate values exist ");
			}
		}
		
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public static void findDuplicateCharacters() {
		String str = "satyanarayana";
		char ch[] = str.toCharArray();
		Map<Character,Integer> charmap = new HashMap<Character,Integer>();
		for(char c : ch) {
			if(charmap.get(c)!=null) {
				charmap.put(c, charmap.get(c)+1);
			}else {
				charmap.put(c, 1);
			}
		}
		Set<Character> chars = charmap.keySet();
		for(char eachchar:chars) {
			if(charmap.get(eachchar)>1) {
				System.out.println(eachchar+":"+charmap.get(eachchar));
			}
		}
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public static void fibnosciSeries() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the series number");
		int a = sc.nextInt();
		int n1=0; int n2=1; int sum=0;
		System.out.print(n1+" "+n2);
		
		for(int i=2;i<a;i++) {
			sum =n1+n2;
			System.out.print(" "+sum);
			n1=n2;
			n2=sum;
		}
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public static void findMissingNumberInArray() {
		int a[] = {14,11,15,13,16};
		int sum1 = 0;
		int sum2 = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=0;i<a.length;i++) {
			list.add(a[i]);
		}
		Collections.sort(list);
		
		for(int eachnum:list) {
			sum1=sum1+eachnum;
		}
		int lastnum = list.get(list.size()-1);
		for(int i=list.get(0);i<=lastnum;i++) {
			sum2=sum2+i;
		}
		System.out.println("Missing number in Array:"+(sum2-sum1));
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	public static void maxAndMinInArray() {
		int a[] = {14,11,15,11,12,13,13,16};
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i =0;i<a.length;i++) {
			list.add(a[i]);
		}
		Collections.sort(list);
		System.out.println(list+": Minimum value is = "+list.get(0));
		System.out.println(list+": Maximum value is = "+list.get(list.size()-1));
		System.out.println(list+": Second max value is = "+list.get(list.size()-2));

	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public static void minAndMaxWithoutCollections() {
		int a[] = {14,11,15,11,12,13,13,16};
		
		int max = a[0];
		int min = a[0];
		int len = a.length; System.out.println("lenth of array:"+len);
		for(int i=1;i<a.length;i++) {
			if(a[i]>max) {
				max=a[i];
			}
		}
		System.out.println("max num is:"+max);
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public static void duplicateEleInArrayWithoutMap() {
		
		String str[] = {"java","C#","groovy","C#","C#","java"};
		int count=0;
		boolean flag = false;
		HashSet<String> list = new HashSet<String>();
		for(int i=0;i<str.length;i++) {
			for(int j=i+1;j<str.length;j++)
			if(str[i].equalsIgnoreCase(str[j])) {
				
				list.add(str[i]);
				flag = true;
			}
			
		}
		if(flag==true) {
		System.out.println("Duplicate elements found: "+list);
		}else {
			System.out.println("Duplicate elements not found");
		}
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//public static void 
	
	public static void convertArrayToArrayList() {
		
		//int arr1[] = {2,3,6,9,1};
		String  arr[] = {"Java", "Python","C#"};
		
		ArrayList al = new ArrayList(Arrays.asList(arr));
		Collections.sort(al,Collections.reverseOrder());
		System.out.println(al);
		
	}
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	public static void writeDataInTextFile() throws IOException {
		
		FileWriter fw = new FileWriter(".\\datafiles\\Textfile.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write("Testcase name: "+"fail");
		System.out.println("Data success");
		bw.close();
		
	}
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	public static void textFileReader() throws IOException {
		
		FileReader fr = new FileReader(".\\datafiles\\Textfile.txt");
		BufferedReader br = new BufferedReader(fr);
		
		System.out.println(br.readLine());
		
		br.close();
		fr.close();
	}
	

}
