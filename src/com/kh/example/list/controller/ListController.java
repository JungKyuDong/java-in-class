package com.kh.example.list.controller;

import java.util.ArrayList;
import java.util.Collections;

import com.kh.example.list.model.compare.StudentCompare;
import com.kh.example.list.model.vo.Student;

public class ListController {

	public void doList() {
		
		ArrayList<String> list1 = new ArrayList<String>();
		// ArrayList is a raw type. References to generic type ArrayList<E> should be parameterized
		// 컬렉션 장점 3. 여러 개 타입 저장 가능
		//				  제네릭을 넣으면 타입 제한
		list1.add("박신우");
//		list1.add(10);
//		list1.add(new Student("박신우", 99));
		
		ArrayList<Student> list = new ArrayList<Student>(3); // 길이 3인 list 생성
		// add(E e) : 리스트 끝에 데이터 e 추가
		list.add(new Student("테스트", 0));
		list.add(new Student("도대담", 60));
		list.add(new Student("남나눔", 90));
		
		System.out.println("list : " + list); // 순서 유지 확인
		
		list.add(new Student("하현호", 85));
		
		System.out.println("현재 list에 담긴 element 개수 : " + list.size());
		System.out.println("list : " + list);
		
		list.add(new Student("문미미", 66));
		
		System.out.println("현재 list에 담긴 element 개수 : " + list.size());
		
		System.out.println("list : " + list);
		// 컬렉션 장점 1. 크기 제약 없다
		
		// 컬렉션 장점 2. 추가/삭제/정렬 등의 기능처리 간단
		// add(int index, E e) : index번째 인덱스에 e 추가
		list.add(0, new Student("류라라", 100));
		
		System.out.println("현재 list에 담긴 element 개수 : " + list.size());
		System.out.println("list : " + list);
		
		// 인덱스 3에 강건강 학생 40점 삽입
		list.add(3, new Student("강건강", 40));
		System.out.println("현재 list에 담긴 element 개수 : " + list.size());
		System.out.println("list : " + list);
		
		// remove(int index) : index번째 객체 삭제
		list.remove(1);
		System.out.println("list : " + list);
		
		// remove(Object o) : 해당 Object객체 삭제
		list.remove(new Student("강건강", 40));
		System.out.println("list : " + list);
		// 삭제 되지 않았다 -> 주소값을 보고 삭제하는데 new라는 연산자 때문에 주소값이 다른 객체이다
		// 동일 객체 : 주소값이 같은 객체
		// 동등 객체 : 값이 같은 객체 -> 동등 객체로 만들기 위해 Student클래스에서 equals() 오버라이딩했다

		// 정렬 1. Collections 이용
		list1.add("홍길동"); // String클래스안에 Comparable<String>에서 정렬 기준이 세워져 있다
		list1.add("백길동");
		list1.add("왕길동");
		System.out.println("list1 정렬 전 : " + list1);
		Collections.sort(list1);
		System.out.println("list1 정렬 후 : " + list1);
		
		Collections.sort(list); // 정렬 기준이 세워져있지 않아서 안된다
		System.out.println("list 정렬 후(Collections) : " + list);
		
		// 문제 : 같은 점수가 있을 때, 이름으로 오름차순 정렬
		list.add(new Student("윤예의", 85));
		
		// 정렬 2. List 안에 있는 sort()메소드 이용
		list.sort(new StudentCompare()); // sort()는 Comparator를 받는다 그래서 새로운 클래스 생성한다
		System.out.println("list 정렬 후 (list.sort()) : " + list);
		
		// set(int index, E e) : index번째 인덱스에 있는 요소 E요소 수정
		list.set(2, new Student("송성실", 52));
		System.out.println("list : " + list);
		
		// get(int index) : index번째 인덱스에 있는 요소 가지고 옴
		Student getStudent = list.get(2);
		System.out.println(getStudent);
		System.out.println("list : " + list);
		
		// contains(Object o) : o가 리스트에 존재한다면 true 반환
		// indexOf(Object o) : o가 리스트에 위치하는 인덱스 번호 반환
		boolean bool1 = list.contains(new Student("남나눔", 90));
		System.out.println("90점인 남나눔 학생이 있습니까? " + bool1);
		boolean bool2 = list.contains(new Student("남나눔", 14));
		System.out.println("14점인 남나눔 학생이 있습니까? " + bool2);
		
		int index1 = list.indexOf(new Student("남나눔", 90));
		System.out.println("90점인 남나눔 학생은 몇 번째에 있습니까? " + index1);
		int index2 = list.indexOf(new Student("남나눔", 14)); // 존재하지 않는 학생은 -1 반환
		System.out.println("14점인 남나눔 학생은 몇 번째에 있습니까? " + index2);
		
		// clear() : 저장된 모든 객체 삭제
		// isEmpty() : 리스트가 비었을 때 true 반환
		System.out.println("list가 비었습니까? " + list.isEmpty());
		list.clear();
		System.out.println("list가 진짜 비었습니까? " + list.isEmpty());
		System.out.println("list : " + list); // list : []
	}
}
