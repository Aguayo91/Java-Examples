package com.studytrails.java.util.collections;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapExample
{
	public static void main(String[] args)
	{
		HashMapExample example = new HashMapExample();
		example.runExample();
	}

	private void runExample()
	{
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("A", "a");
		System.out.println(hashMap);// {A=a}
		System.out.println(hashMap.containsKey("A"));// true
		hashMap.put(null, null);
		System.out.println(hashMap);// {null=null, A=a}
		Set<Entry<String, String>> entries = hashMap.entrySet();
		for (Entry<String, String> entry : entries) {
			// returns a view . The set is backed by the actual map so the
			// changes are reflected
			// in the map
			System.out.println(entry.getKey() + "=>" + entry.getValue());
			if (entry.getKey() == null)
				entry.setValue("not null");
		}
		System.out.println(hashMap);// {null=not null, A=a}
		System.out.println(hashMap.getOrDefault("B", "DefaultValue"));// DefaultValue
		Set<String> keys = hashMap.keySet();
		for (String key : keys) {
			System.out.println(key + "," + hashMap.get(key));
		}
		System.out.println(hashMap.putIfAbsent("A", "c"));// a
		System.out.println(hashMap);// {null=not null, A=a
		hashMap.replace("A", "A1");
		System.out.println(hashMap);// {null=not null, A=A1}
		hashMap.replace("A", "a", "A2");
		System.out.println(hashMap);// {null=not null, A=A1}
		hashMap.replace("A", "A1", "A2");
		System.out.println(hashMap);// {null=not null, A=A2
		System.out.println(hashMap.size());// 2
		System.out.println(hashMap.values());// [not null, A2]
		hashMap.clear();
		System.out.println(hashMap);// {}
		hashMap.put("C", "c");
		hashMap.put("B", "b");
		hashMap.put(null, null);
		hashMap.put("A", "a");
		hashMap.put("AnotherA", "somea");
		System.out.println(hashMap.keySet());// [null, A, B, C, AnotherA]
	}

}
