package com.kh.example.list.model.vo;

public class Student implements Comparable<Student>{ // ������ �ϱ� ���� implements Comparable

	private String name;
	private int score;
	
	public Student() {
		
	}
	
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return name + "(" + score + "��)";
	}
	
	@Override
	public int hashCode() { // equals()�� �������̵��ϸ� hashCode()�� ������ �������̵� �ؾ��Ѵ�
		final int prime = 31;
		int result = 1;
		result = prime * result + (name == null? 0 : name.hashCode()); // �������϶�
		result = prime * result + score; // �⺻���϶�
		
		return result;
	}
	
	@Override
	public boolean equals(Object obj) { // ���� ��ü �񱳸� ���� �����
		// �⺻ equals()�� �ּҰ��� ���� ���Ѵ�
		
		// ��ü ��ü ��
		if(this == obj) { // ���� ��ü���
			return true;
		}
		if(obj == null) { // obj ��ü�� �������� �ʾҴٸ�
			return false;
		}
		if(getClass() != obj.getClass()) {
			return false;
		}
		
		// �ʵ� �� ��
		Student other = (Student)obj;
		if(name == null) {
			if(other.name != null) {
				return false;
			}
		}
		else if(!name.equals(other.name)) {
			return false;
		}
		if(score != other.score) { // int�� null�� ����
			return false;
		}
		
		return true;
	}

	@Override
	public int compareTo(Student o) {

		String otherName = o.getName();
		
		// this.name VS otherName
		//	String			String
		// ArrayList<String> list1 ==> sort() �̻� ���� �ƾ���
		//		String �ȿ� ���� ������ �̹� �������� ���ķ� ������ �ִ�
		
		int result = name.compareTo(otherName);
		// ����ü.compareTo(�񱳴��)
		// ����ü�� �񱳴��� ������ 0 ��ȯ
		// ����ü�� �񱳴�󺸴� ũ�� 1 ��ȯ
		// ����ü�� �񱳴�󺸴� ������ -1 ��ȯ ==> ���������϶�
		// ������������ �ϰ� ������ '-'�� ���̸� �ȴ�
		
		return result;
		
		// ���������� ����� ���ϸ�
//		 return -result;
	}

//	@Override
//	public int compareTo(Object o) { // Comparable<Student>�� �ƴ� Comparable�θ� ������
//		
//		// �̸� ��������
//		String otehrName = ((Student)o).getName();
//		
//	}
}