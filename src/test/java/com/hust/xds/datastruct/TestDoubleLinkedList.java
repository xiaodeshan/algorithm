package com.hust.xds.datastruct;

import org.junit.Test;

public class TestDoubleLinkedList {
	
	@Test
	public void testLinkedInsertHead() {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
		
		list.insertHead(1);
		list.insertHead(2);
		list.insertHead(3);
		list.insertHead(4);
		
		list.printLinkedList();
	}
	
	@Test
	public void testLinkedInsertTail() {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
		
		list.insertTail(1);
		list.insertTail(2);
		list.insertTail(3);
		list.insertTail(4);
		
		list.printLinkedList();
	}
	
	@Test
	public void testLinkedDelete() {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
		
		list.insertTail(1);
		list.insertTail(2);
		list.insertTail(3);
		list.insertTail(4);
		
		list.deleteFirst();
		list.deleteFirst();
		list.deleteFirst();
		list.deleteFirst();
		list.printLinkedList();
		
		list.insertTail(5);
		list.insertTail(6);
		list.insertTail(7);
		list.insertTail(8);
		
		list.deleteLast();
		list.deleteLast();
		list.deleteLast();
		list.deleteLast();
		list.printLinkedList();		
		
		
		list.insertTail(9);
		list.insertTail(10);
		list.insertTail(11);
		list.insertTail(12);
		
		
		list.deleteNode(list.getNode(2));
		list.deleteNode(list.getNode(2));
		list.deleteNode(list.getNode(0));
		list.deleteNode(list.getNode(0));
		list.printLinkedList();
	}
}
