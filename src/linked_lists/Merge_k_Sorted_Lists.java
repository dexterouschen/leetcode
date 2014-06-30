package linked_lists;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import test_data_structure.ListNode;

/*
 Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */

public class Merge_k_Sorted_Lists {
	/*
	 * solve this problem by using a heap
	 */
	public ListNode mergeKLists(List<ListNode> lists) {
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
		for (ListNode x : lists) {
			while (x != null) {
				heap.add(x.val);
				// add everything in all list (not just heads) into the heap
				x = x.next;
			}
		}
		if (heap.isEmpty() || lists.isEmpty()) {
			return null;
		}
		ListNode result = new ListNode(heap.remove());
		ListNode first = result;
		int counter = heap.size();
		for (int i = 0; i < counter; i++) {
			result.next = new ListNode(heap.remove());
			result = result.next;
		}
		return first;
	}

	public static ListNode mergeKLists(ArrayList<ListNode> lists) {
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
