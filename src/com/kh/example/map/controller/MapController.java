package com.kh.example.map.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import com.kh.example.map.model.compare.SnackCompare;
import com.kh.example.map.model.vo.Snack;

public class MapController {

	public void doMap() {
		
		// HashMap
		HashMap<String, Snack> map = new HashMap<String, Snack>(); // 키는 String으로 많이 쓴다
		
		// put(K key, V value) : 키와 값 추가
		map.put("새우깡", new Snack("짠맛", 1500));
		map.put("다이제", new Snack("단맛", 2500));
		map.put("포테이토칩", new Snack("짠맛", 1500));
		map.put("고소미",new Snack("고소한맛", 1000));
		
		System.out.println("map : " + map);
		// map : {다이제=단맛[2500원], 새우깡=짠맛[1500원], 포테이토칩=짠맛[1500원], 고소미=고소한맛[1000원]}
		// 순서 유지 X, value 중복 허용
		
		map.put("새우깡", new Snack("매운맛", 1500));
		
		System.out.println("map : " + map);
		// map : {다이제=단맛[2500원], 새우깡=매운맛[1500원], 포테이토칩=짠맛[1500원], 고소미=고소한맛[1000원]}
		// 새우깡 -> key 같다 -> 덮어 씌워진다
		// key를 String으로 썼기 때문에 equals() hashCode()를 오버라딩 안해도 알아서 중복 허용 하지 않는다
		
		// containKey(Object key) : key가 있으면 true 반환
		// containValue(Object value) : value가 있으면 true 반환
		System.out.println(map.containsKey("새우깡"));
		System.out.println(map.containsValue(new Snack("짠맛", 1500)));
		// value는 오버라이딩 해줘야한다
		
		// get(Object key) : 키의 값 반환
		System.out.println(map.get("새우깡"));
		System.out.println(map.get("홈런볼")); // 없는 값 : null
		
		// map 엘리먼트 접근하기
		// 1. values() : 모든 value들을 Collection에 담아 반환
		System.out.println(map.values());
		
		// 2. keySet() : 모든 key를 set에 담아 반환
		Set<String> set1 = map.keySet();
		System.out.println("set1 : " + set1);
		// keySet()으로 key 값 알아낸후 get()으로 value 얻을 수 있다
		Iterator<String> it1 = set1.iterator(); // set의 값은 iterator 얻을 수 있다. get() 사용 안됨
		while(it1.hasNext()) { // 방법 1
			String key = it1.next();
			System.out.println(key + ", " + map.get(key));
		}
		
		for(String key : map.keySet()) { // 방법 2
			System.out.println(key + ", " + map.get(key));
		}
		
		// 3. entrySet() : 모든 entry(키+값의 쌍) 객체를 set에 담아 반환
		Set<Entry<String, Snack>> set2 = map.entrySet();
		Iterator<Entry<String, Snack>> it2 = set2.iterator();
		while(it2.hasNext()) { // 방법 1
			Entry<String, Snack> entry = it2.next();
			System.out.println(entry.getKey() + ", " + entry.getValue());
		}
		
		for(Entry<String, Snack> e : map.entrySet()) { // 방법 2
			System.out.println(e.getKey() + " : " + e.getValue());
		}
		
		// TreeMap
		TreeMap<String, Snack> map2 = new TreeMap<String, Snack>();
		map2.putAll(map);
		System.out.println(map2); // key값을 보고 알아서 정렬이 된다
		
		// 내림차순을 위해서 SnackCompare 클래스는 만는다
		TreeMap<String, Snack> map3 = new TreeMap<String, Snack>(new SnackCompare());
		map3.putAll(map);
		System.out.println(map3);
		
		// size() : map에 저장된 entry 수 반환
		System.out.println(map.size());
		
		// remove(Object key) : key에 해당하는 객체 삭제 후 해당 값 반환
		System.out.println(map.remove("다이제"));
		
		// remove(Object key, Object value) : 해당 키와 값이 맞으면 삭제 후 true 반환
		System.out.println(map.remove("고소미", new Snack("고소한맛", 1000)));
		System.out.println(map.remove("포테이토", new Snack("짠맛", 1500)));
		
		System.out.println("map : " + map);
		
		// clear() : 모든 entry 삭제
		// isEmpty() : map이 비어있으면 true 반환
		map.clear();
		System.out.println(map); // {}
		System.out.println(map.isEmpty());
	}
	
	public void doProperties() {
		
		Properties prop = new Properties(); // Map이지만 String으로 고정되어 <>할 필요 없다
//		prop.put(1, 10); // put()는 java.util.Hashtable<Object,Object> <- java.util.Properties 부모 클래스 메소드이다
//		System.out.println(prop);
		
		prop.setProperty("채소", "오이");
		prop.setProperty("과일", "사과");
		prop.setProperty("간식", "젤리");
		System.out.println(prop);
		// {과일=사과, 채소=오이, 간식=젤리} 순서 유지 되지 않는다
		
		prop.setProperty("채소", "피망");
		System.out.println(prop);
		// {과일=사과, 채소=피망, 간식=젤리} 키가 중복되면 덮어씌워진다
		
		// getProperty(String key) : key를 통해 value 반환
		System.out.println(prop.getProperty("채소"));
		System.out.println(prop.getProperty("견과")); //  없는 값 null
		
		// prop.getProperty(key, defaultValue)
		// key를 통해 value를 반환하는데 이 때 해당 key가 없으면 지정 defaultValue를 반환
		System.out.println(prop.getProperty("채소", "땅콩"));
		System.out.println(prop.getProperty("견과", "땅콩"));
	}
	
	public void fileSave() {
		
//		try (FileOutputStream fos = new FileOutputStream("test.properties");){
		try (FileOutputStream fos = new FileOutputStream("test.xml");){	
		
			Properties prop = new Properties();
			prop.setProperty("title", "Properties Practice");
			prop.setProperty("width", "1920");
			prop.setProperty("height", "1080");
			prop.setProperty("language", "kor");
			
			// store(OutputStream out, String comments)
			// store(Writer writer, String comments)
			// 저장된 정보를 바이트/문자 스트림으로 출력 저장, comments는 주석으로 저장
//			prop.store(fos, "Properties Test File");
			
			// prop.storeToXML(OutputStream os, String comment)
			// 저장된 정보를 바이트 스트림으로 xml로 출렬 저장
			prop.storeToXML(fos, "storeToXML Test");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void fileOpen() {
		
//		try (FileInputStream fis = new FileInputStream("test.xml");){
		try (FileInputStream fis = new FileInputStream("test.properties");){
			
			Properties prop = new Properties();
			
			// loadFromXML(InputStream in)
			// 바이트스트림으로 저장된 xml파일의 내용을 읽어와서 properties 객체에 저장
//			prop.loadFromXML(fis);
			
			// load(InputStream in)
			// load(Reader reader)
			// 바이트/문자 스트림으로 저장된 파일의 내용을 읽어와서 properties객체에 저장
			prop.load(fis);
			
			System.out.println(prop);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
