package practice.selenium;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class PlayStrings {

	String statement = "Im a boy and Im a good player-and-im-a-good human";

	public void findDuplicateWords_HashMap() {
		String inputstring = statement.toLowerCase();
		String words[] = inputstring.split("[-\\s]");

		Map<String, Integer> wordmap = new HashMap<String, Integer>();

		for (String str : words) {

			if (wordmap.get(str) != null) {
				wordmap.put(str, wordmap.get(str) + 1);
			} else {
				wordmap.put(str, 1);
			}

		}

		Set<String> set = wordmap.keySet();
		for (String str : set) {

			if (wordmap.get(str) > 1) {
		    System.out.println(str + " : " + wordmap.get(str));
			}

		}

	}

	public void findDuplicateChar_HashMap() {

		String str = "satyanarayana";
		char ch[] = str.toCharArray();

		Map<Character, Integer> charmap = new HashMap<Character, Integer>();

		for (Character c : ch) {

			if (charmap.get(c) != null) {
				charmap.put(c, charmap.get(c) + 1);

			} else {

				charmap.put(c, 1);
			}
		}

		Set<Character> charset = charmap.keySet();

		for (Character c : charset) {
			if (charmap.get(c) > 1) {
				System.out.println("Number of occurences of " + c + ":" + charmap.get(c));
			}

		}

	}

	public void findDuplicateWords_ForLoop() {

		String inputstring = statement.toLowerCase();

		String words[] = inputstring.split("[-\\s]");

		for (int i = 0; i < words.length; i++) {
			int count = 1;

			for (int j = i + 1; j < words.length; j++) {
				if (words[i].equals(words[j])) {
					count++;
					words[j] = "";
				}
			}
			if (count > 1 && words[i] != "") {
				System.out.println(words[i] + "=" + count);
			}

		}

	}

	public void findDuplicateChar_ForLoop() {

		Scanner sc = new Scanner(System.in);

		String str = sc.next();

		char c[] = str.toCharArray();

		int count;

		for (int i = 0; i < c.length; i++) {
			count = 1;
			for (int j = i + 1; j < c.length; j++) {
				if (c[i] == c[j]) {
					count++;
					c[j] = '0';
				}
			}
			if (count > 1 && c[i] != '0') {
				System.out.println(c[i]);
			}
		}
	}

	public void palindromeString() {

		String str = "satya";
		String revstr = "";
		for (int i = 0; i < str.length(); i++) {

			char c = str.charAt(i);
			revstr = c + revstr;
		}
		System.out.println(revstr);
	}

	public static void main(String[] args) {
		PlayStrings ps = new PlayStrings();

		ps.palindromeString();

	}

}
