package linked_lists;

import java.util.HashMap;

import test_data_structure.RandomListNode;

/*
 A linked list is given such that each node contains an additional random pointer 
 which could point to any node in the list or null.

 Return a deep copy of the list.
 */

public class Copy_List_with_Random_Pointer {
	/*
	 * http://blog.csdn.net/linhuanmars/article/details/22463599
	 */
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return head;
		HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode newHead = new RandomListNode(head.label);
		map.put(head, newHead);
		RandomListNode pre = newHead;
		RandomListNode node = head.next;
		while (node != null) {
			RandomListNode newNode = new RandomListNode(node.label);
			map.put(node, newNode);
			pre.next = newNode;
			pre = newNode;
			node = node.next;
		}
		node = head;
		RandomListNode copyNode = newHead;
		while (node != null) {
			copyNode.random = map.get(node.random);
			copyNode = copyNode.next;
			node = node.next;
		}
		return newHead;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
