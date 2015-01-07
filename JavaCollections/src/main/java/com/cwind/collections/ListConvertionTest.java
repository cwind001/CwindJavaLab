package com.cwind.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ListConvertionTest {
	public static void main(String[] args){
		ArrayList<String> al = new ArrayList<String>();
		al.add("test1");
		al.add("test2");
		al.add("test3");
		//����1��ֱ�����
		LinkedList<String> ll = new LinkedList<String>();
		for(String str : al){
			ll.add(str);
		}
		for(String str : ll) {
			System.out.println(str);
		}
		
		//����2��ͨ��ObjectArrayת��
		Object[] strs = al.toArray();
		List tmpList = Arrays.asList(strs);
		LinkedList ll2 = new LinkedList(tmpList);
		
		for(String str : ll) {
			System.out.println(str);
		}
	}
}
