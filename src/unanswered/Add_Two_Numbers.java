package unanswered;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;

import test_data_structure.ListNode;

/*
 You are given two linked lists representing two non-negative numbers.
 The digits are stored in reverse order and each of their nodes contain a single digit. 
 Add the two numbers and return it as a linked list.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 */

public class Add_Two_Numbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null)
			return null;
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		while (l1 != null) {
			list1.add(l1.val);
			l1 = l1.next;
		}
		while (l2 != null) {
			list2.add(l2.val);
			l2 = l2.next;
		}
		int a = Integer.getInteger(l1.toString());
		int b = Integer.getInteger(l2.toString());
		return null;
	}
	public static YearMonth getYearMonth(LocalDate orderDate) {
		return YearMonth.from(orderDate);
	}
	public static void main(String[] args) {
		LocalDate orderDate=LocalDate.now();
		System.out.println(getYearMonth(orderDate));
	}

}
