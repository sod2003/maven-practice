package com.skillstorm;

public class ArrayHelpers {
    public static int findMax(int[] array) {
        if (!(array == null || array.length == 0)) {
            int max = array[0];
			for (int i = 1; i < array.length; i++) {
				if (array[i] > max) {
					max = array[i];
				}
			}
            return max;
		}
		return 0;
	}
}
