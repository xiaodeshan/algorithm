package com.hust.xds.dispatch;

public class TestLRU {
	public static void main(String[] args) {
		LRUCache<Integer, String> lruCache = new LRUCache<>(5);
		
		lruCache.put(1, "123");		
		lruCache.put(2, "AA");
		lruCache.put(3, "BB");
		lruCache.put(4, "VV");	
		lruCache.put(5, "DD");		
		lruCache.put(3, "SS");	
		lruCache.put(4, "hh");
		lruCache.put(2, "kk");
		lruCache.put(6, "mm");	
		lruCache.put(8, "hh");
		
		lruCache.printLRU();
	}

}
