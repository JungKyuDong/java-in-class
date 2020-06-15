package com.kh.example.list.model.compare;

import java.util.Comparator;

import com.kh.example.list_model.vo.Student;

public class StudentCompare implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {

		// 점수 오름차순 정렬
		int standard = o1.getScore();
		int object = o2.getScore();
		
		String standardName = o1.getName();
		String objectName = o2.getName();
		
		if(standard > object) {
			return 1;
		}
		else if(standard == object) { // 같은 점수가 있을 때, 이름으로 오름차순 정렬
			return standardName.compareTo(objectName);
		}
		else
			return -1;

	}

}
