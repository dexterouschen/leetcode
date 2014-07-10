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

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		ListNode newHead = new ListNode(0);
		ListNode pointer1 = l1, pointer2 = l2, pointer3 = newHead;
		while (pointer1 != null || pointer2 != null) {
			if (pointer1 != null) {
				carry += pointer1.val;
				pointer1 = pointer1.next;
			}
			if (pointer2 != null) {
				carry += pointer2.val;
				pointer2 = pointer2.next;
			}
			pointer3.next = new ListNode(carry % 10);
			pointer3 = pointer3.next;
			carry /= 10;
		}
		if (carry == 1)
			pointer3.next = new ListNode(1);
		return newHead.next;
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
