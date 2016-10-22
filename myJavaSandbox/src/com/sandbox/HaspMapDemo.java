package com.sandbox;

import java.util.HashMap;
import java.util.Iterator;

import org.testng.annotations.Test;

@Test
public class HaspMapDemo {
	public  void doMap() {
		// TODO Auto-generated method stub
		System.out.println("in main ");
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		hm.put("wes", 1958);
		hm.put("barb", 1957);
		hm.put("chris", 1987);
		hm.put("jon", 1994);
		hm.put("matt", 1998);
		
		String sKey = "matt";	//Retrieving value from HashMap
		Integer year = hm.get(sKey); System.out.println("get this Key value: " + sKey +" ,value: "+ year); 

		System.out.println("\nIterate thru hash map:");	//iterate HashMap
		Iterator<String> keySetIterator = hm.keySet().iterator(); 
		while(keySetIterator.hasNext()){ 
			String key = keySetIterator.next(); 
			System.out.println("key: " + key + " value: " + hm.get(key)); 
		}

		// ContainsKey and ContainsValue Example
		System.out.println("Does HashMap contains 'wes' as key: " + hm.containsKey("wes")); 
		System.out.println("Does HashMap contains 3000 as value: " + hm.containsValue(3000));
			
		System.out.println("Size of Map: " + hm.size()); //get the number of hash entries
		
		String key = "wes"; //remove a key/value pair
		Object value = hm.remove(key); 
		System.out.println("Following value is removed from Map with key 'wes': " + value); 

		System.out.println("Size of Map: " + hm.size());
		hm.clear(); //clears hashmap , removes all element 
		System.out.println("Size of Map after clearing it for reuse: " + hm.size());

		boolean isEmpty = hm.isEmpty(); 
		System.out.println("Is HashMap is empty: " + isEmpty);

	}
}
