package linked_lists;

import java.util.*;

import test_data_structure.ListNode;

/*
 Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */

public class Merge_k_Sorted_Lists {
	/**
	 * The basic idea is to compare the head nodes for all lists. Yet how can
	 * you compare more than two nodes at the same time? One solution is to use
	 * heaps (which can be implemented as priority queues). Therefore, the
	 * algorithm is as following: create a priority queue that collects head
	 * nodes of all lists. Keep poping out the smallest one (n) and do n =
	 * n.next until there are all "null"s in the queue.
	 */
	public static ListNode mergeKLists(List<ListNode> lists) {
		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(),
				new Comparator<ListNode>() {
					public int compare(ListNode n1, ListNode n2) {
						return n1.val == n2.val ? 0 : (n1.val > n2.val ? 1 : -1);
					}
				});
		for (ListNode node : lists) {
			if (node != null)
				heap.add(node);
		}
		ListNode nhead = new ListNode(0), trav = nhead;
		while (!heap.isEmpty()) {
			ListNode node = heap.poll();
			trav.next = node;
			trav = trav.next;
			node = node.next;
			if (node != null)
				heap.add(node);
		}
		return nhead.next;
	}

	/**
	 * Here is another solution that directly compare the head nodes without
	 * using a heap.
	 */
	public static ListNode mergeKLists2(ArrayList<ListNode> lists) {
		if (lists.isEmpty()) {
			return null;
		}
		if (lists.size() == 1) {
			return lists.get(0);
		}
		ListNode nhead = new ListNode(88888);
		ListNode cur = nhead;
		ListNode[] pointers = new ListNode[lists.size()];
		for (int i = 0; i < lists.size(); i++) {
			pointers[i] = lists.get(i);
		}
		int i = findMinHead(pointers);
		while (i != -1) {
			cur.next = pointers[i];
			cur = cur.next;
			pointers[i] = pointers[i].next;
			i = findMinHead(pointers);
		}
		return nhead.next;
	}

	public static int findMinHead(ListNode[] pointers) {
		int min = Integer.MAX_VALUE;
		int res = -1;
		for (int i = 0; i < pointers.length; i++) {
			if (pointers[i] != null && pointers[i].val <= min) {
				min = pointers[i].val;
				res = i;
			}
		}
		if (min == Integer.MAX_VALUE) {
			return -1;
		}
		return res;
	}

	public static void main(String[] args) {
		ListNode n11 = new ListNode(3);
		ListNode n12 = new ListNode(7);
		ListNode n13 = new ListNode(12);
		n11.next = n12;
		n12.next = n13;
		ListNode n21 = new ListNode(2);
		ListNode n22 = new ListNode(4);
		ListNode n23 = new ListNode(6);
		ListNode n24 = new ListNode(11);
		ListNode n25 = new ListNode(19);
		n21.next = n22;
		n22.next = n23;
		n23.next = n24;
		n24.next = n25;
		ListNode n31 = new ListNode(1);
		ListNode n32 = new ListNode(8);
		ListNode n33 = new ListNode(10);
		ListNode n34 = new ListNode(15);
		n31.next = n32;
		n32.next = n33;
		n33.next = n34;

		ArrayList<ListNode> lists = new ArrayList<ListNode>();
		lists.add(n11);
		lists.add(n21);
		lists.add(n31);
		ListNode n = mergeKLists(lists);

		while (n != null) {
			System.out.println(n.val);
			n = n.next;
		}
	}

}
