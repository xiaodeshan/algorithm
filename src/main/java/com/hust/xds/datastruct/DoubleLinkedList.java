package com.hust.xds.datastruct;

/**
 * 双向链表java实现
 *
 * @author Deshan Xiao
 */
public class DoubleLinkedList<T> {
	static final class Node<T> {
		Node<T> next;
		Node<T> prev;
		T data;

		public Node(T entity) {
			data = entity;
		}
	}

	private Node<T> head;
	private Node<T> tail;
	private int size = 0;

	/**
	 * 头插法
	 * 
	 * @param entity
	 */
	public void insertHead(T entity) {
		Node<T> node = new Node<T>(entity);
		if (head == null) {
			head = tail = node;
			size = size + 1;
			return;
		}

		node.prev = null;
		node.next = head;
		head.prev = node;
		head = node;
		size = size + 1;
	}

	/**
	 * 头插法o
	 * 
	 * @param entity
	 */
	public void insertTail(T entity) {
		Node<T> node = new Node<T>(entity);
		if (head == null) {
			size = size + 1;
			head = tail = node;
			return;
		}

		node.prev = tail;
		tail.next = node;
		size = size + 1;
		tail = node;
	}

	/**
	 * 打印链表
	 */
	public void printLinkedList() {
		Node<T> visitNode = head;
		while (visitNode != null) {
			System.out.println(visitNode.data.toString());

			visitNode = visitNode.next;
		}
	}

	/**
	 * @return {@code true} 当列表为空 {@code false} 当列表不为空
	 */
	public boolean isEmpty() {
		return head == null;
	}

	public Node<T> deleteFirst() {
		if (head == null) {
			throw new RuntimeException("链表为空");
		}

		Node<T> first = head;
		head = first.next;
		if (first.next == null) {
			tail = null;
		} else {
			first.next.prev = null;
			/* 删除对下节点的引用，便于垃圾回收 */
			first.next = null;
		}
		size = size - 1;
		return first;
	}

	public Node<T> deleteLast() {
		if (head == null) {
			throw new RuntimeException("链表为空");
		}

		Node<T> last = tail;
		tail = last.prev;
		size = size - 1;
		if (last.prev == null) {
			head = null;
		} else {
			last.prev.next = null;
			/* 删除对上节点的引用，便于垃圾回收 */
			last.prev = null;
		}

		return last;
	}

	public Node<T> deleteNode(Node<T> deleteNode) {
		if (deleteNode == null) {
			return null;
		}

		if (deleteNode.prev == null) {
			deleteFirst();
			return deleteNode;
		} else if (deleteNode.next == null) {
			deleteLast();

			return deleteNode;
		} else {
			deleteNode.prev.next = deleteNode.next;
			deleteNode.next.prev = deleteNode.prev;
			size = size - 1;
		}

		deleteNode.next = null;
		deleteNode.prev = null;

		return deleteNode;
	}

	public Node<T> getNode(int index) {
		int pos = 0;
		Node<T> visitNode = head;

		for (; pos < index && visitNode != null; pos++) {
			visitNode = visitNode.next;
		}

		return visitNode;

	}

	public T get(int index) {
		Node<T> node = getNode(index);
		if (node == null) {
			return null;
		} else {
			return node.data;
		}
	}
	
	public int size() {
		return size;
	}
}
