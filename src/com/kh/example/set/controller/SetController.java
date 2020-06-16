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
		
		HashSet<Dog> set = new HashSet<Dog>(); // new HashSet�� <> ����ֵ��ȴ�. -> Ÿ���߷� ����
		
		// add(E e) : set �ȿ� e �߰�
		set.add(new Dog("���", 2.2));
		set.add(new Dog("�̵�", 5.4));
		set.add(new Dog("���", 1.9));
		
		System.out.println("set : " + set);
		// set : [���(1.9kg), ���(2.2kg), �̵�(5.4kg)] : ���� ���� �ȵȴ�
		
		set.add(new Dog("���", 2.2));
		System.out.println("set : " + set);
		// set : [���(1.9kg), ���(2.2kg), �̵�(5.4kg), ���(2.2kg)] => �ߺ� ���?? �ٸ� ��ü�̱� ������ �ȴ�
		// equals()�� hashCode()�� �������̵� �ؾ��Ѵ�
	
		// LinkedHashSet
		LinkedHashSet<Dog> set2 = new LinkedHashSet<Dog>();
		
		set2.add(new Dog("����", 2.1));
		set2.add(new Dog("����", 8.3));
		set2.add(new Dog("�κ�", 5.0));
		set2.add(new Dog("����", 2.1));
		set2.add(new Dog("����", 6.1));
		set2.add(new Dog("����", 5.2));
		set2.add(new Dog("����", 9.5));
		set2.add(new Dog("����", 12.5));
		
		System.out.println("set2 : " + set2);
		//set2 : [����(2.1kg), ����(8.3kg), �κ�(5.0kg), ����(6.1kg), ����(5.2kg), ����(9.5kg), ����(12.5kg)]
		// ������ �����ǳ� �ߺ��� ��������ʴ´�
	
		
		// TreeSet
		TreeSet<Dog> set3 = new TreeSet<Dog>(set2);
		System.out.println("set3 : " + set3);
		// Exception in thread "main" java.lang.ClassCastException: 
		// com.kh.example.set.model.vo.Dog cannot be cast to java.lang.Comparable
		// set3 : [����(5.2kg), �κ�(5.0kg), ����(6.1kg), ����(9.5kg), ����(12.5kg), ����(2.1kg), ����(8.3kg)]
		
		
		TreeSet<Dog> set4 = new TreeSet<Dog>(new DogCompare());
		set4.add(new Dog("����", 6.1));
		set4.add(new Dog("����", 8.3));
		set4.add(new Dog("�κ�", 5.0));
		set4.add(new Dog("����", 2.1));
		set4.add(new Dog("����", 6.1));
		set4.add(new Dog("����", 5.2));
		set4.add(new Dog("����", 9.5));
		set4.add(new Dog("����", 12.5));
		
		System.out.println("set4 : " + set4);
		// Comparator �ϱ��� - set4 : [����(5.2kg), �κ�(5.0kg), ����(6.1kg), ����(9.5kg), ����(12.5kg), ����(6.1kg), ����(8.3kg)]
		// Comparator �� �� - set4 : [����(12.5kg), ����(9.5kg), ����(8.3kg), ����(6.1kg), ����(5.2kg), �κ�(5.0kg), ����(2.1kg)]
		// set4.add(new Dog("����", 6.1))�� �������
		// Comparator�� CompareTo ���� �� - set4 : [����(12.5kg), ����(9.5kg), ����(8.3kg), ����(6.1kg), ����(6.1kg), ����(5.2kg), �κ�(5.0kg), ����(2.1kg)]
		
		// List������ get()�̿��ؼ� ���� ���´ٸ� Set������ Iterator<E>�� ����� �� �ִ�
		
		// Set �ȿ� �ִ� element �����ϱ�
		// ���� 1. Set�� List�� �ű��
		
		ArrayList<Dog> list = new ArrayList<Dog>();
		list.addAll(set4);
		System.out.println("list : " + list);
		System.out.println("list.get(4) : " + list.get(4));
		
		// ���� 2. Iterator ���
		Iterator<Dog> it = set4.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		while(it.hasNext()) { // Iterator�� ���̻� �����Ͱ� ���� ��°��� ���� = �ܹ����̴�
			System.out.println("re : " + it.next());
		}
		
		// ListIterator�� List�� �� �� �ִ�
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
