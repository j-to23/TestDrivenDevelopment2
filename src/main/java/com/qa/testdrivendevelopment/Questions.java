package com.qa.testdrivendevelopment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Questions {
	/**
	 * EXAMPLE: THIS ONE HAS BEEN DONE FOR YOU <br>
	 * 
	 * Given a name, return "Hi" plus the name <br>
	 * <br>
	 * For Example:<br>
	 * greetingExample("John") → "Hi John" <br>
	 * greetingExample("Matt") → "Hi Matt" <br>
	 * greetingExample("Angelica") → "Hi Angelica"
	 * 
	 */
	public String greetingExample(String name) {
		return "Hi " + name;
	}

	/**
	 * Given a string and a char, returns the position in the String where the char
	 * first appears. Ensure the positions are numbered correctly, please refer to
	 * the examples for guidance. <br>
	 * Do not ignore case <br>
	 * Ignore whitespace <br>
	 * If the char does not occur, return the number -1. <br>
	 * <br>
	 * For Example: <br>
	 * returnPosition("This is a Sentence",'s') → 4 <br>
	 * returnPosition("This is a Sentence",'S') → 8 <br>
	 * returnPosition("Fridge for sale",'z') → -1
	 */
	public int returnPosition(String input, char letter) {
		String input1 = input.replace(" ", "");
		int charfind = input1.indexOf(letter) + 1;
		// System.out.println(charfind);
		if (charfind > 0) {
			return charfind;
		} else {
			return -1;
		}
	}

	/**
	 * Given two Strings of equal length, 'merge' them into one String. Do this by
	 * 'zipping' the Strings together. <br>
	 * Start with the first char of the first String. <br>
	 * Then add the first char from the second String. <br>
	 * Then add the second char from the first String. <br>
	 * And so on. <br>
	 * Maintain case. <br>
	 * You will not encounter whitespace. <br>
	 * <br>
	 * For Example: <br>
	 * zipped("String","Fridge") → "SFtrriidngge" <br>
	 * zipped("Dog","Cat") → "DCoagt"<br>
	 * zipped("True","Tree") → "TTrrueee" <br>
	 * zipped("return","letter") → "rleettutrenr" <br>
	 */
	public String zipped(String input1, String input2) {
		int i = 0;
		String zip = "";
		int size = input1.length();
		for (i = 0; i < size; i++) {
			zip = zip + input1.charAt(i) + input2.charAt(i);
		}
		// System.out.println(zip);
		return zip;
	}

	/**
	 * Given an Array of Strings, remove any duplicate Strings that occur, then
	 * return the Array. <br>
	 * Do not ignore case. <br>
	 * <br>
	 * For Example: <br>
	 * removeDuplicates({"Dog"}) → {"Dog"} <br>
	 * removeDuplicates({"Dog","Cat"}) → {"Dog","Cat"} <br>
	 * removeDuplicates({"Dog","Dog","Cat"}) → {"Dog","Cat"} <br>
	 * removeDuplicates({"Dog","DoG","Cat"}) → {"Dog","DoG","Cat"}
	 */
	public String[] removeDuplicates(String[] stringArray) {
		List<String> cleaning = Arrays.asList(stringArray);
		cleaning = cleaning.stream().distinct().collect(Collectors.toList());
		String[] nodupes = new String[cleaning.size()];
		nodupes = cleaning.toArray(nodupes);
		return nodupes;
	}

	/**
	 * Given a large string that represents a csv (comma separated values), the
	 * structure of each record will be as follows:
	 * owner,nameOfFile,encrypted?,fileSize <br>
	 * <br>
	 * Example:
	 * "Bert,private.key,True,1447\nBert,public.key,False,1318\nJeff,private.key,False,1445"
	 * <br>
	 * <br>
	 * Where a comma separates out the fields, and the \n represents a new line.
	 * <br>
	 * For each record, if it is not encrypted, return the names of the owners of
	 * the files in a String Array. <br>
	 * Do not include duplicate names. <br>
	 * <br>
	 * For Example: <br>
	 * csvScan("Jeff,private.key,False,1445") → {"Jeff"} <br>
	 * csvScan("Bert,private.key,True,1447\nBert,public.key,True,1318\nJeff,private.key,False,1445")
	 * → {"Jeff"} <br>
	 * csvScan("Bert,private.key,False,1447\nBert,public.key,False,1318\nJeff,private.key,False,1445")
	 * → {"Bert","Jeff"} <br>
	 * csvScan("Bert,private.key,True,1447\nBert,public.key,False,1318\nJeff,private.key,False,1445")
	 * → {"Bert","Jeff"}
	 */
	public String[] csvScan(String csvInput) {
		String c = csvInput;
		int i = 0;
		String name;
		if (c.indexOf("\n") > 1) {
			String[] csv = c.split("\n");
			ArrayList<String> listnames = new ArrayList<String>();
			for (i = 0; i < csv.length; i++) {
				if (csv[i].indexOf("False") > 0) {
					name = csv[i].substring(0, csv[i].indexOf(","));
					listnames.add(name);
				}
			}
			List<String> duplicatecleaning = listnames.stream().distinct().collect(Collectors.toList());
			String[] names = new String[duplicatecleaning.size()];
			names = duplicatecleaning.toArray(names);

			return names;
		} else {
			String[] names = new String[1];
			name = c.substring(0, c.indexOf(","));
			names[0] = name;
			return names;
		}
	}

	/**
	 * Write a function to randomly generate a list with 5 even numbers between 100
	 * and 200 inclusive. <br>
	 * <br>
	 * For Example: <br>
	 * listGen() → {100,102,122,198,200} <br>
	 * listGen() → {108,104,106,188,200} <br>
	 * listGen() → {154,102,132,178,164}
	 */
	public int[] listGen() {
		int x = 0;
		int i = 0;
		int[] y = new int[5];
		for (i = 0; i < 5; i++) {
			x = ThreadLocalRandom.current().nextInt(100, 200 + 1);
			y[i] = x;
		}
		return y;
	}

	/**
	 * A prime number is one which is only divisible by one and itself. <br>
	 * Write a function which returns the boolean True if a number is prime, and the
	 * boolean False if not. <br>
	 * <br>
	 * For Example: <br>
	 * isPrime(3) → True <br>
	 * isPrime(8) → False
	 */
	public boolean isPrime(int num) {
		int i = 2;
		int a = 0;
		boolean prime = true;
		for (i = 2; i < num - 1; i++) {
			a = num % i;
			if (a == 0) {
				prime = false;
			}
		}
		return prime;
	}

	/**
	 * Wrtie a function which returns the number of vowels in a given string. <br>
	 * You should ignore case. <br>
	 * <br>
	 * For Example: <br>
	 * getVowel("Hello") → 2 <br>
	 * getVowel("hEelLoooO") → 6
	 */
	public int getVowel(String input) {
		input = input.toLowerCase();
		int n = 0;
		int vowelcount = 0;
		for (n = 0; n < input.length(); n++) {
			char cha = input.charAt(n);
			String chara = String.valueOf(cha);
			if (chara.equals("a") || chara.equals("e") || chara.equals("i") || chara.equals("o") || chara.equals("u")) {
				vowelcount++;
			}
		}
		return vowelcount;
	}

	/**
	 * Given two string inputs, if one can be made from the other return the boolean
	 * True, if not return the boolean False. <br>
	 * <br>
	 * For Example: <br>
	 * wordFinder("dog", "god") → True <br>
	 * wordFinder("tiredest", "tree") → True <br>
	 * wordFinder("dog", "cat") → False <br>
	 * wordFinder("tripping", "gin") → True
	 */
	public boolean wordFinder(String initialWord, String madeString) {
		String a = initialWord;
		String b = madeString;
		ArrayList<String> word = new ArrayList<String>();
		int i = 0;
		int n = 0;
		for (i = 0; i < b.length(); i++) {
			word.add(String.valueOf(b.charAt(i)));
		}
		i = 0;
		for (i = 0; i < a.length(); i++) {
			for (n = 0; n < word.size(); n++) {
				if (String.valueOf(a.charAt(i)).equals(word.get(n))) {
					word.remove(n);
				}
			}
		}
		String finalword = word.toString();
		if (finalword == "[]") {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * There is a well known mnemonic which goes "I before E, except after C", which
	 * is used to determine which order "ei" or "ie" should be in a word. <br>
	 * <br>
	 * Write a function which returns the boolean True if a string follows the
	 * mnemonic, and returns the boolean False if not. <br>
	 * <br>
	 * For Example: <br>
	 * iBeforeE("ceiling") → True <br>
	 * iBeforeE("believe") → True <br>
	 * iBeforeE("glacier") → False <br>
	 * iBeforeE("height") → False
	 */
	public boolean iBeforeE(String input) {
		int n = 0;
		for (n = 0; n < input.length(); n++) {
			char here = input.charAt(n);
			String a = String.valueOf(here);
			if (a.equals("e")) {
				if (String.valueOf(input.charAt(n - 1)).equals("c")
						&& String.valueOf(input.charAt(n + 1)).equals("i")) {
					return true;
				} else if (String.valueOf(input.charAt(n - 1)).equals("i")
						&& String.valueOf(input.charAt(n - 2)).equals("c")) {
					return false;
				} else if (String.valueOf(input.charAt(n - 1)).equals("i")) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * A factorial is the product of itself and all previous numbers <br>
	 * eg 3 factorial is 1 x 2 x 3 = 6 <br>
	 * <br>
	 * Write a function which can compute the factorial of a given number between 1
	 * and 10 inclusive. <br>
	 * <br>
	 * For Example: <br>
	 * factorial(1) → 1 <br>
	 * factorial(4) → 24 <br>
	 * factorial(8) → 40320
	 */
	public int factorial(int number) {
		int i;
		int x = 1;
		for (i = 0; i < number; i++) {
			x = x * (number - i);
		}
		return x;
	}

}
