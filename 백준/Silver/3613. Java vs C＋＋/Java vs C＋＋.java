
import java.util.*;
import java.io.*;

public class Main {

	static boolean isCpp(String input) {
		boolean containUnderbar = false;
		for (int i=0;i<input.length();i++) {
			char c = input.charAt(i);
			if ('A' <= c && c <= 'Z') {
				return false;
			}
			if (i == 0 && c == '_') {
				return false;
			}
			if (i > 0) {
				char pre = input.charAt(i-1);
				if (pre == '_' && c == '_') {
					return false;
				}
			}
			if (i == input.length()-1) {
				if (c == '_') {
					return false;
				}
			}
			if (c == '_') {
				containUnderbar = true;
			}
		}
		
		if (containUnderbar) {
			return true;
		}
		return false;
	}
	
	static String convertToJava(String input) {
		StringBuilder sb = new StringBuilder();
		sb.append(input.charAt(0));
		
		for (int i=1;i<input.length();i++) {
			if (input.charAt(i) == '_') {
				continue;
			}
			else if (input.charAt(i-1) == '_') {
				sb.append(Character.toUpperCase(input.charAt(i)));
			}
			else {
				sb.append(input.charAt(i));
			}
		}
		
		return sb.toString();
	}
	
	static boolean isJava(String input) {
		if (input.contains("_")) {
			return false;
		}
		for (int i=0;i<input.length();i++) {
			char c = input.charAt(i);
			if ('A' <= c && c <= 'Z') {
				if (i == 0) {
					return false;
				}
				if (i > 0) {
					char pre = input.charAt(i-1);
					if (('A' <= pre && pre <= 'Z') && ('A' <= c && c <= 'Z')) {
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}
	
	static String convertToCpp(String input) {
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<input.length();i++) {
			if ('A' <= input.charAt(i) && input.charAt(i) <= 'Z') {
				sb.append("_").append(Character.toLowerCase(input.charAt(i)));
			}
			else {
				sb.append(input.charAt(i));
			}
		}
		return sb.toString();
	}
	
	static boolean isJustWord(String input) {
		for (int i=0;i<input.length();i++) {
			char c = input.charAt(i);
			if ('a' > c || c > 'z') {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		if (isCpp(input)) {
			System.out.println(convertToJava(input));
		}
		else if (isJava(input)) {
			System.out.println(convertToCpp(input));
		}
		else if (isJustWord(input)) {
			System.out.println(input);
		}
		else {
			System.out.println("Error!");
		}
	}
}
