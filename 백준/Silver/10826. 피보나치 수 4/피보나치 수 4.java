import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		BigInteger[] fib = new BigInteger[n+1];
		
		if (n == 0) {
			System.out.println(0);
			return;
		}
		
		fib[0] = new BigInteger("0");
		fib[1] = new BigInteger("1");
		for (int i=2;i<n+1;i++) {
			fib[i] = fib[i-1].add(fib[i-2]);
		}
		
		System.out.println(fib[n]);
	}
}