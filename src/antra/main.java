package antra;

import java.util.*;

//remove all duplicate values from input array
class Main {
	public static void main(String[] args) {
		int[] input = { 1, 3, 2, -1, 0, -1, 3 }; // output: [1, 2, 0]
		int[] output = removeDup(input);
		for (int i : output) {
			System.out.println(i);
		}
	}

	public static int[] removeDup(int[] input) {

		List<Integer> list = new ArrayList<>();
		Map<Integer, Integer> counter = new HashMap<>();
		for (int i = 0; i < input.length; i++) {
			int value = input[i];
			counter.put(value, counter.getOrDefault(value, 0)+1);
//			if (counter.containsKey(value)) {
//				counter.put(value, counter.get(value) + 1);
//			} else {
//				counter.put(value, 1);
//			}
		}
		for (Integer key : counter.keySet()) {
			if (counter.get(key) == 1) {
				list.add(key);
			}
		}
		int[] res = new int[list.size()];
		for (int i=0; i<list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}
}
