package kr.stam.app;

import java.io.*;
import java.util.*;

public class Main {
	static List<Integer> list = new ArrayList<Integer>(); 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int[] numbers = new int[n];
		for(int i = 0; i < n; i ++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		List<Integer> list = combination(numbers, m);
		list.sort(null);
		
		Object[] result = list.stream().filter(v -> v - m <= 0).toArray();
		
		bw.write(result[result.length - 1] + "");
		bw.flush();
		bw.close();
	}
	
	private static List<Integer> combination(int[] numbers, int m) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < numbers.length - 2; i ++) {
			for(int j = i + 1; j < numbers.length - 1; j ++) {
				for(int k = j + 1; k < numbers.length; k ++) {
					list.add(numbers[i] + numbers[j] + numbers[k]);
				}
			}
		}
		return list;
	}
}
