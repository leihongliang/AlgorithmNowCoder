package basic_class_05;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import basic_class_05.Code01_PreInPosTraversal.Node;

public class TestBST {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	//方法一
	public static int preValue = Integer.MIN_VALUE;
	public static boolean checkBST(Node head) {
		if (head == null) {
			return true;//到底了
		}
		boolean isLeftBst = checkBST(head.left);
		if(!isLeftBst) {
			return false;
		}
		if(head.value <= preValue) {
			return false;
		}else {
			preValue = head.value;
		}
		return checkBST(head.right);
	}

	//方法二 递归的方法
	public static boolean checkBST2(Node head){
		List<Node> inOrderList = new ArrayList<>();
		process2(head, inOrderList);
		int preValue = Integer.MIN_VALUE;
		//判断是否递增
		for (Node node : inOrderList) {
			if (node.value <= preValue){
				return false;
			}else {
				preValue = node.value;
			}
		}
		return true;
	}
	public static void process2(Node head, List<Node> inOrderList) {
		if (head == null) {
			return;
		}
		process2(head.left, inOrderList);
		inOrderList.add(head);
		process2(head.right, inOrderList);
	}


	// 方法三 非递归
	public static boolean checkBST3(Node head) {
		if (head != null) {
			int preValue = Integer.MIN_VALUE;
			Stack<Node> stack = new Stack<Node>();
			while (!stack.isEmpty() || head != null) {
				if (head != null) {
					stack.push(head);
					head = head.left;
				} else {
					head = stack.pop();
					if(head.value <= preValue) {
						return false;
					}else {
						preValue = head.value;
					}
					head = head.right;
				}
			}
		}
		return true;
	}

	public static boolean isBST(Node head) {
		return process(head).isBST;//
	}

	public static class ReturnType {
		public boolean isBST;
		public int max;
		public int min;

		public ReturnType(boolean isBST, int max, int min) {
			this.isBST = isBST;
			this.max = max;
			this.min = min;
		}
	}

	public static ReturnType process(Node x) {
		if (x == null) {
			return new ReturnType(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
		}
		ReturnType leftData = process(x.left);
		ReturnType rightData = process(x.right);
		int max = Math.max(x.value, Math.max(leftData.max, rightData.max));
		int min = Math.min(x.value, Math.min(leftData.min, rightData.min));
		boolean isBST = leftData.isBST 
				& rightData.isBST 
				& leftData.max < x.value 
				& rightData.min > x.value;
		return new ReturnType(isBST, max, min);

	}
	

	public static boolean isBalanced(Node head) {
		return walk(head).isBalanced;// 
	}
	
	public static class ReturnInfo{
		
		public boolean isBalanced;
		public int height;
		
		public ReturnInfo(boolean isBalanced, int height) {
			this.isBalanced = isBalanced;
			this.height = height;
		}
	}
	
	public static ReturnInfo walk(Node x) {
		if(x == null) {
			return new ReturnInfo(true, 0);
		}
		ReturnInfo leftData = walk(x.left);
		ReturnInfo rightData = walk(x.right);
		int height = Math.max(leftData.height, rightData.height) + 1;
		boolean isBalanced = leftData.isBalanced && rightData.isBalanced 
				&& Math.abs(leftData.height - rightData.height) < 2;
		return new ReturnInfo(isBalanced, height);
		
	}
	
	
	public static class ReturnDetail{
		public int height;
		public int nodes;
		public ReturnDetail(int h, int n) {
			height = h;
			nodes = n;
		}
	}
	
	public static ReturnDetail f(Node x) {
		if(x == null) {
			return new ReturnDetail(0,0);
		}
		ReturnDetail lDetail = f(x.left);
		ReturnDetail rDetail = f(x.right);
		int height = Math.max(lDetail.height, rDetail.height) + 1;
		int nodes = lDetail.nodes + 1 + rDetail.nodes;
		return new ReturnDetail(height, nodes);
	}
	
	public static boolean isFull(Node head) {
		ReturnDetail allDetail =  f(head);
		int height = allDetail.height;
		int allNodes = allDetail.nodes;
		return (1 << height) - 1 == allNodes;
	}

	public static void main(String[] args) {
		Node head = new Node(5);
		head.left = new Node(3);
		head.right = new Node(7);
		head.left.left = new Node(2);
		head.left.right = new Node(4);
		head.left.left.left = new Node(1);
		head.right.left= new Node(6);
		head.right.right= new Node(8);
		System.out.println(checkBST(head));
		System.out.println(checkBST2(head));
		System.out.println(checkBST3(head));
	}
}
