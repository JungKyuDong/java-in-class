package com.kh.example.set.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.ListIterator;
import java.util.TreeSet;

import com.kh.example.set.model.compare.DogCompare;
import com.kh.example.set.model.vo.Dog;

public class SetController {

	public void doSet() {
		
		HashSet<Dog> set = new HashSet<Dog>(); // new HashSet뒤 <> 비워둬도된다. -> 타입추론 가능
		
		// add(E e) : set 안에 e 추가
		set.add(new Dog("모모", 2.2));
		set.add(new Dog("이든", 5.4));
		set.add(new Dog("사랑", 1.9));
		
		System.out.println("set : " + set);
		// set : [사랑(1.9kg), 모모(2.2kg), 이든(5.4kg)] : 순서 유지 안된다
		
		set.add(new Dog("모모", 2.2));
		System.out.println("set : " + set);
		// set : [사랑(1.9kg), 모모(2.2kg), 이든(5.4kg), 모모(2.2kg)] => 중복 허용?? 다른 객체이기 때문에 된다
		// equals()와 hashCode()를 오버라이딩 해야한다
	
		// LinkedHashSet
		LinkedHashSet<Dog> set2 = new LinkedHashSet<Dog>();
		
		set2.add(new Dog("초코", 2.1));
		set2.add(new Dog("콩이", 8.3));
		set2.add(new Dog("두부", 5.0));
		set2.add(new Dog("초코", 2.1));
		set2.add(new Dog("로이", 6.1));
		set2.add(new Dog("공주", 5.2));
		set2.add(new Dog("왕자", 9.5));
		set2.add(new Dog("조이", 12.5));
		
		System.out.println("set2 : " + set2);
		//set2 : [초코(2.1kg), 콩이(8.3kg), 두부(5.0kg), 로이(6.1kg), 공주(5.2kg), 왕자(9.5kg), 조이(12.5kg)]
		// 순서는 유지되나 중복은 허용하지않는다
	
		
		// TreeSet
		TreeSet<Dog> set3 = new TreeSet<Dog>(set2);
		System.out.println("set3 : " + set3);
		// Exception in thread "main" java.lang.ClassCastException: 
		// com.kh.example.set.model.vo.Dog cannot be cast to java.lang.Comparable
		// set3 : [공주(5.2kg), 두부(5.0kg), 로이(6.1kg), 왕자(9.5kg), 조이(12.5kg), 초코(2.1kg), 콩이(8.3kg)]
		
		
		TreeSet<Dog> set4 = new TreeSet<Dog>(new DogCompare());
		set4.add(new Dog("초코", 6.1));
		set4.add(new Dog("콩이", 8.3));
		set4.add(new Dog("두부", 5.0));
		set4.add(new Dog("초코", 2.1));
		set4.add(new Dog("로이", 6.1));
		set4.add(new Dog("공주", 5.2));
		set4.add(new Dog("왕자", 9.5));
		set4.add(new Dog("조이", 12.5));
		
		System.out.println("set4 : " + set4);
		// Comparator 하기전 - set4 : [공주(5.2kg), 두부(5.0kg), 로이(6.1kg), 왕자(9.5kg), 조이(12.5kg), 초코(6.1kg), 콩이(8.3kg)]
		// Comparator 한 후 - set4 : [조이(12.5kg), 왕자(9.5kg), 콩이(8.3kg), 초코(6.1kg), 공주(5.2kg), 두부(5.0kg), 초코(2.1kg)]
		// set4.add(new Dog("로이", 6.1))가 사라졌다
		// Comparator와 CompareTo 적용 후 - set4 : [조이(12.5kg), 왕자(9.5kg), 콩이(8.3kg), 로이(6.1kg), 초코(6.1kg), 공주(5.2kg), 두부(5.0kg), 초코(2.1kg)]
		
		// List에서는 get()이용해서 값을 꺼냈다면 Set에서는 Iterator<E>만 사용할 수 있다
		
		// Set 안에 있는 element 접근하기
		// 접근 1. Set을 List로 옮기기
		
		ArrayList<Dog> list = new ArrayList<Dog>();
		list.addAll(set4);
		System.out.println("list : " + list);
		System.out.println("list.get(4) : " + list.get(4));
		
		// 접근 2. Iterator 사용
		Iterator<Dog> it = set4.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		while(it.hasNext()) { // Iterator에 더이상 데이터가 없어 출력값이 없다 = 단방향이다
			System.out.println("re : " + it.next());
		}
		
		// ListIterator은 List만 쓸 수 있다
		ListIterator<Dog> lit = list.listIterator();
		while(lit.hasNext()) {
			System.out.println(lit.next());
		}
		
		System.out.println();
		
		while(lit.hasPrevious()) {
			System.out.println(lit.previous());
		}
	}
}
