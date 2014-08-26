package linked_lists;

import test_data_structure.ListNode;

/*
 You are given two linked lists representing two non-negative numbers.
 The digits are stored in reverse order and each of their nodes contain a single digit. 
 Add the two numbers and return it as a linked list.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 */

public class Add_Two_Numbers {
	/**
	 * Simple linked list pointers operation again. But be careful when you have
	 * your 'carry' = 1 when finished traversing the entire lists. In this case,
	 * you need to create a new node at the end of your resulting list.
	 */
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		ListNode n1 = l1, n2 = l2, nhead = new ListNode(0), n3 = nhead;
		// we use list1 for in-place calculation to save space
		n3.next = n1;
		while (n1 != null && n2 != null) {
			int sum = n1.val + n2.val + carry;
			n1.val = sum % 10;
			carry = sum / 10;
			n3 = n1;
			n1 = n1.next;
			n2 = n2.next;
		}
		if (n1 == null) {
			n3.next = n2;
			while (n2 != null) {
				int sum = n2.val + carry;
				n2.val = sum % 10;
				carry = sum / 10;
				n3 = n2;
				n2 = n2.next;
			}
		} else if (n2 == null) {
			while (n1 != null) {
				int sum = n1.val + carry;
				n1.val = sum % 10;
				carry = sum / 10;
				n3 = n1;
				n1 = n1.next;
			}
		}
		if (carry == 1) { // if there is a "1" left.
			n3.next = new ListNode(1);
		}
		return nhead.next;
	}

	public static void main(String[] args) {
		ListNode l11 = new ListNode(7);
		ListNode l12 = new ListNode(9);
		ListNode l13 = new ListNode(1);
		ListNode l14 = new ListNode(8);
		ListNode l21 = new ListNode(9);
		ListNode l22 = new ListNode(9);
		ListNode l23 = new ListNode(3);
		ListNode l24 = new ListNode(0);
		ListNode l25 = new ListNode(4);
		ListNode l26 = new ListNode(5);
		l11.next = l12;
		l12.next = l13;
		l13.next = l14;
		l21.next = l22;
		l22.next = l23;
		l23.next = l24;
		l24.next = l25;
		l25.next = l26;

		// ListNode l11 = new ListNode(8);
		// ListNode l12 = new ListNode(1);
		// l11.next=l12;
		// ListNode l21 = new ListNode(0);
		// ListNode l14 = new ListNode(8);

		ListNode ln = addTwoNumbers(l11, l21);
		while (ln != null) {
			System.out.print(ln.val + "->");
			ln = ln.next;
		}
		System.out.print("null"); // should return 1000963

	}

}
