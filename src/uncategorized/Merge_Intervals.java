package uncategorized;

import java.util.*;

import test_data_structure.Interval;

/*
 Given a collection of intervals, merge all overlapping intervals.

 For example,
 Given [1,3],[2,6],[8,10],[15,18],
 return [1,6],[8,10],[15,18].
 */

public class Merge_Intervals {

	/**
	 * First sort the intervals using their 'start' values. This can be done by
	 * writing your own sorting methods. But here I simply used a sorting
	 * algorithm within Java by defining a new Comparator within Collections
	 * class. Another important thing is the "i--" expression in for-loop.
	 * Without it, conditions where 3 or more continuous intervals that need to
	 * be merged can be handled properly.
	 */
	public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		if (intervals == null || intervals.size() < 2) {
			return intervals;
		}
		ArrayList<Interval> list = new ArrayList<Interval>(intervals);
		Collections.sort(list, new Comparator<Interval>() { // trick is here
					public int compare(Interval i1, Interval i2) {
						return i1.start == i2.start ? 0 : (i1.start > i2.start ? 1 : -1);
					}
				});
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i).start <= list.get(i - 1).end) {
				int nstart = list.get(i - 1).start, nend = list.get(i - 1).end > list.get(i).end ? list
						.get(i - 1).end : list.get(i).end;
				list.set(i - 1, new Interval(nstart, nend));
				list.remove(i);
				i--; // don't forget this, else 3 intervals in a row won't be merged.
			}
		}
		return list;
	}

	public static void main(String[] args) {
		ArrayList<Interval> intervals = new ArrayList<>();
		// intervals.add(new Interval(15, 18));
		// intervals.add(new Interval(9, 12));
		// intervals.add(new Interval(2, 6));
		// intervals.add(new Interval(8, 10));
		// intervals.add(new Interval(1, 3));

		intervals.add(new Interval(2, 3));
		intervals.add(new Interval(4, 5));
		intervals.add(new Interval(6, 7));
		intervals.add(new Interval(8, 9));
		intervals.add(new Interval(1, 10));

		for (Interval i : merge(intervals))
			System.out.println(i.start + " " + i.end);
	}

}
