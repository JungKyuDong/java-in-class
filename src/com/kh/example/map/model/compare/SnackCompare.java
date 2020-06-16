package com.kh.example.map.model.compare;

import java.util.Comparator;

public class SnackCompare implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {

		// key값 내림차순
		return -o1.compareTo(o2);
	}

	
}
