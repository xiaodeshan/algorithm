package com.hust.xds.dispatch;
import java.util.HashMap;

/**
 * LRU算法java实现，复杂度O（n）
 *
 * @author Deshan Xiao
 */
public class LRUCache<K, V> {
	public HashMap<K, Node<K, V>> map = new HashMap<>();
	public final int MAX_SIZE;

	private volatile int size = 0;
	private Node<K, V> first;
	private Node<K, V> last;

	public LRUCache(int size) {
		MAX_SIZE = size;
	}

	void put(K key, V value) {
		V v = getValue(key);
		if (v == null) {
			Node<K, V> newNode = new Node<>(key, value);
			if (size >= MAX_SIZE) {
				deleteLast();
			}
			newNode.next = first;
			if(first == null) {
				last = newNode;
			}else {
				first.pre = newNode;
			}
			first = newNode;

			map.put(key, newNode);
			size++;
		} else {
			transToHead(key, v);
			first.value = value;
		}
	}

	private V getValue(K key) {
		Node<K, V> node = map.get(key);
		return node == null ? null : node.value;
	}
	
	private Node<K, V> getNode(K key) {
		Node<K, V> node = map.get(key);
		return node;
	}

	@SuppressWarnings("hiding")
	private class Node<K, V> {
		private K key;
		private V value;
		private Node<K, V> next;
		private Node<K, V> pre;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;

			next = pre = null;
		}
	}

	private void deleteLast() {
		if (last != null) {
			Node<K, V> removeNode = map.remove(last.key);

			if (removeNode == first) {
				first = null;
			}
			last = last.pre;
			if (removeNode.pre != null)
				removeNode.pre.next = null;
			removeNode.pre = null;

			size--;
		}
	}

	private void transToHead(K key, V value) {
		Node<K,V> oldNode = getNode(key);
		if(oldNode == first)
			return;
		if(oldNode.pre != null) oldNode.pre.next = oldNode.next;
		if(oldNode.next != null) oldNode.next.pre = oldNode.pre;
		if(oldNode == last) last = last.pre;
		
		if(last == null || first == null) {
			first = last = oldNode;
		}
		
		oldNode.next = first;
		first.pre = oldNode;
		first = oldNode;
		
		oldNode.pre = null;
	}

	public void printLRU() {
		System.out.println("-----size:" + size + "/" + MAX_SIZE + "------");

		Node<K, V> temp = first;

		while (temp != null) {
			System.out.println("key:[" + temp.key.toString() + "]" + " value:[" + temp.value.toString() + "]");
			temp = temp.next;
		}
	}

}
