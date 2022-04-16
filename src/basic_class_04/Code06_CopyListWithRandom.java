package basic_class_04;

import java.util.HashMap;

public class Code06_CopyListWithRandom {

	public static class Node {
		public int value;
		public Node next;
		public Node rand;

		public Node(int data) {
			this.value = data;
		}
	}

	public static Node copyListWithRand1(Node head) {
		HashMap<Node, Node> map = new HashMap<Node, Node>();
		Node cur = head;
		// 拷贝链表
		while (cur != null) {
			map.put(cur, new Node(cur.value));
			cur = cur.next;
		}
		cur = head;
		// 更新链表结构
		while (cur != null) {
			// cur 老
			// map.get(cur) 新
			map.get(cur).next = map.get(cur.next);
			map.get(cur).rand = map.get(cur.rand);
			cur = cur.next;
		}
		return map.get(head);
	}

	public static Node copyListWithRand2(Node head) {
		if (head == null) {
			return null;
		}
		Node cur = head;
		Node next = null;// 中间变量用来暂存之后的节点
		// copy node and link to every node，设置new节点
		// 1 -> 2
		// 1 -> 1' -> 2，成对连接
		while (cur != null) {
			next = cur.next;
			cur.next = new Node(cur.value);// 加一个节点
			cur.next.next = next;// 复制
			cur = next;// 复制下一个
		}
		cur = head;
		Node curCopy = null;
		// set copy node rand，设置new的rand
		// 1 -> 1' -> 2 -> 2'
		while (cur != null) {
			next = cur.next.next;// old 的下一个节点
			curCopy = cur.next;// new 的下一个节点
			curCopy.rand = cur.rand != null ? cur.rand.next : null;
			cur = next;
		}
		Node res = head.next;
		cur = head;
		// split head= 0 -> 1-> 2-> 3-> 4
		while (cur != null) {
			next = cur.next.next;// 2 -> 3-> 4
			curCopy = cur.next;// 1-> 2-> 3-> 4
			cur.next = next;// 0 -> 2-> 3-> 4
			curCopy.next = next != null ? next.next : null;// 1-> 3-> 4 res更改
			cur = next;// 2-> 3-> 4
		}
		return res;//
	}

	public static void printRandLinkedList(Node head) {
		Node cur = head;
		System.out.print("order: ");
		while (cur != null) {
			System.out.print(cur.value + " ");
			cur = cur.next;
		}
		System.out.println();
		cur = head;
		System.out.print("rand:  ");
		while (cur != null) {
			System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
			cur = cur.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node head = null;
		Node res1 = null;
		Node res2 = null;
		printRandLinkedList(head);
		res1 = copyListWithRand1(head);
		printRandLinkedList(res1);
		res2 = copyListWithRand2(head);
		printRandLinkedList(res2);
		printRandLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);

		head.rand = head.next.next.next.next.next; // 1 -> 6
		head.next.rand = head.next.next.next.next.next; // 2 -> 6
		head.next.next.rand = head.next.next.next.next; // 3 -> 5
		head.next.next.next.rand = head.next.next; // 4 -> 3
		head.next.next.next.next.rand = null; // 5 -> null
		head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

		printRandLinkedList(head);
		res1 = copyListWithRand1(head);
		printRandLinkedList(res1);
		res2 = copyListWithRand2(head);
		printRandLinkedList(res2);
		printRandLinkedList(head);
		System.out.println("=========================");

	}

}
