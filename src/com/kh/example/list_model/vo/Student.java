package com.kh.example.list_model.vo;

public class Student implements Comparable<Student>{ // 정렬을 하기 위해 implements Comparable

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
		return name + "(" + score + "점)";
	}
	
	@Override
	public int hashCode() { // equals()를 오버라이딩하면 hashCode()는 무조건 오버라이딩 해야한다
		final int prime = 31;
		int result = 1;
		result = prime * result + (name == null? 0 : name.hashCode()); // 참조형일때
//		result = prime * result + score; // 기본형일때
		
		return result;
	}
	
	@Override
	public boolean equals(Object obj) { // 동등 객체 비교를 위해 만든다
		// 기본 equals()는 주소값을 보고 비교한다
		
		// 객체 자체 비교
		if(this == obj) { // 같은 객체라면
			return true;
		}
		if(obj == null) { // obj 객체가 생성되지 않았다면
			return false;
		}
		if(getClass() != obj.getClass()) {
			return false;
		}
		
		// 필드 값 비교
		Student other = (Student)obj;
		if(name == null) {
			if(other.name != null) {
				return false;
			}
		}
		else if(!name.equals(other.name)) {
			return false;
		}
		if(score != other.score) { // int는 null이 없다
			return false;
		}
		
		return true;
	}

	@Override
	public int compareTo(Student o) {

		String otherName = o.getName();
		
		// this.name VS otherName
		//	String			String
		// ArrayList<String> list1 ==> sort() 이상 없이 됐었다
		//		String 안에 정렬 기준이 이미 오름차순 정렬로 세워져 있다
		
		int result = name.compareTo(otherName);
		// 비교주체.compareTo(비교대상)
		// 비교주체가 비교대상과 같으면 0 반환
		// 비교주체가 비교대상보다 크면 1 반환
		// 비교주체가 비교대상보다 작으면 -1 반환 ==> 오름차순일때
		// 내림차순으로 하고 싶으면 '-'를 붙이면 된다
		
		return result;
		
		// 내림차순의 결과를 원하면
//		 return -result;
	}

//	@Override
//	public int compareTo(Object o) { // Comparable<Student>이 아닌 Comparable로만 했을때
//		
//		// 이름 오름차순
//		String otehrName = ((Student)o).getName();
//		
//	}
}