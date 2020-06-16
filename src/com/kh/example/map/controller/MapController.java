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
		HashMap<String, Snack> map = new HashMap<String, Snack>(); // Ű�� String���� ���� ����
		
		// put(K key, V value) : Ű�� �� �߰�
		map.put("�����", new Snack("§��", 1500));
		map.put("������", new Snack("�ܸ�", 2500));
		map.put("��������Ĩ", new Snack("§��", 1500));
		map.put("��ҹ�",new Snack("����Ѹ�", 1000));
		
		System.out.println("map : " + map);
		// map : {������=�ܸ�[2500��], �����=§��[1500��], ��������Ĩ=§��[1500��], ��ҹ�=����Ѹ�[1000��]}
		// ���� ���� X, value �ߺ� ���
		
		map.put("�����", new Snack("�ſ��", 1500));
		
		System.out.println("map : " + map);
		// map : {������=�ܸ�[2500��], �����=�ſ��[1500��], ��������Ĩ=§��[1500��], ��ҹ�=����Ѹ�[1000��]}
		// ����� -> key ���� -> ���� ��������
		// key�� String���� ��� ������ equals() hashCode()�� ������� ���ص� �˾Ƽ� �ߺ� ��� ���� �ʴ´�
		
		// containKey(Object key) : key�� ������ true ��ȯ
		// containValue(Object value) : value�� ������ true ��ȯ
		System.out.println(map.containsKey("�����"));
		System.out.println(map.containsValue(new Snack("§��", 1500)));
		// value�� �������̵� ������Ѵ�
		
		// get(Object key) : Ű�� �� ��ȯ
		System.out.println(map.get("�����"));
		System.out.println(map.get("Ȩ����")); // ���� �� : null
		
		// map ������Ʈ �����ϱ�
		// 1. values() : ��� value���� Collection�� ��� ��ȯ
		System.out.println(map.values());
		
		// 2. keySet() : ��� key�� set�� ��� ��ȯ
		Set<String> set1 = map.keySet();
		System.out.println("set1 : " + set1);
		// keySet()���� key �� �˾Ƴ��� get()���� value ���� �� �ִ�
		Iterator<String> it1 = set1.iterator(); // set�� ���� iterator ���� �� �ִ�. get() ��� �ȵ�
		while(it1.hasNext()) { // ��� 1
			String key = it1.next();
			System.out.println(key + ", " + map.get(key));
		}
		
		for(String key : map.keySet()) { // ��� 2
			System.out.println(key + ", " + map.get(key));
		}
		
		// 3. entrySet() : ��� entry(Ű+���� ��) ��ü�� set�� ��� ��ȯ
		Set<Entry<String, Snack>> set2 = map.entrySet();
		Iterator<Entry<String, Snack>> it2 = set2.iterator();
		while(it2.hasNext()) { // ��� 1
			Entry<String, Snack> entry = it2.next();
			System.out.println(entry.getKey() + ", " + entry.getValue());
		}
		
		for(Entry<String, Snack> e : map.entrySet()) { // ��� 2
			System.out.println(e.getKey() + " : " + e.getValue());
		}
		
		// TreeMap
		TreeMap<String, Snack> map2 = new TreeMap<String, Snack>();
		map2.putAll(map);
		System.out.println(map2); // key���� ���� �˾Ƽ� ������ �ȴ�
		
		// ���������� ���ؼ� SnackCompare Ŭ������ ���´�
		TreeMap<String, Snack> map3 = new TreeMap<String, Snack>(new SnackCompare());
		map3.putAll(map);
		System.out.println(map3);
		
		// size() : map�� ����� entry �� ��ȯ
		System.out.println(map.size());
		
		// remove(Object key) : key�� �ش��ϴ� ��ü ���� �� �ش� �� ��ȯ
		System.out.println(map.remove("������"));
		
		// remove(Object key, Object value) : �ش� Ű�� ���� ������ ���� �� true ��ȯ
		System.out.println(map.remove("��ҹ�", new Snack("����Ѹ�", 1000)));
		System.out.println(map.remove("��������", new Snack("§��", 1500)));
		
		System.out.println("map : " + map);
		
		// clear() : ��� entry ����
		// isEmpty() : map�� ��������� true ��ȯ
		map.clear();
		System.out.println(map); // {}
		System.out.println(map.isEmpty());
	}
	
	public void doProperties() {
		
		Properties prop = new Properties(); // Map������ String���� �����Ǿ� <>�� �ʿ� ����
//		prop.put(1, 10); // put()�� java.util.Hashtable<Object,Object> <- java.util.Properties �θ� Ŭ���� �޼ҵ��̴�
//		System.out.println(prop);
		
		prop.setProperty("ä��", "����");
		prop.setProperty("����", "���");
		prop.setProperty("����", "����");
		System.out.println(prop);
		// {����=���, ä��=����, ����=����} ���� ���� ���� �ʴ´�
		
		prop.setProperty("ä��", "�Ǹ�");
		System.out.println(prop);
		// {����=���, ä��=�Ǹ�, ����=����} Ű�� �ߺ��Ǹ� ���������
		
		// getProperty(String key) : key�� ���� value ��ȯ
		System.out.println(prop.getProperty("ä��"));
		System.out.println(prop.getProperty("�߰�")); //  ���� �� null
		
		// prop.getProperty(key, defaultValue)
		// key�� ���� value�� ��ȯ�ϴµ� �� �� �ش� key�� ������ ���� defaultValue�� ��ȯ
		System.out.println(prop.getProperty("ä��", "����"));
		System.out.println(prop.getProperty("�߰�", "����"));
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
			// ����� ������ ����Ʈ/���� ��Ʈ������ ��� ����, comments�� �ּ����� ����
//			prop.store(fos, "Properties Test File");
			
			// prop.storeToXML(OutputStream os, String comment)
			// ����� ������ ����Ʈ ��Ʈ������ xml�� ��� ����
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
			// ����Ʈ��Ʈ������ ����� xml������ ������ �о�ͼ� properties ��ü�� ����
//			prop.loadFromXML(fis);
			
			// load(InputStream in)
			// load(Reader reader)
			// ����Ʈ/���� ��Ʈ������ ����� ������ ������ �о�ͼ� properties��ü�� ����
			prop.load(fis);
			
			System.out.println(prop);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
