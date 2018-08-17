package com.damianprog.utils;

import org.springframework.stereotype.Component;

@Component
public class ArrayOfIntsGetter {

	public int[] get(String ints) {

		String[] excludedIdsStringArray = ints.split(",");

		int[] excludedIdsArray = new int[excludedIdsStringArray.length];

		for (int i = 0; i < excludedIdsStringArray.length; i++)
			excludedIdsArray[i] = Integer.valueOf(excludedIdsStringArray[i]);

		return excludedIdsArray;
	}
}