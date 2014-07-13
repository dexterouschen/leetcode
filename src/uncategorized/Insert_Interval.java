package uncategorized;

import java.util.*;

import test_data_structure.Interval;

/*
 Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

 You may assume that the intervals were initially sorted according to their start times.

 Example 1:
 Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

 Example 2:
 Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

 This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */

public class Insert_Interval {

	public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		intervals.add(newInterval);
		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.start == i2.start ? 0 : (i1.start > i2.start ? 1 : -1);
			}
		});
		ArrayList<Interval> nlist = new ArrayList<>();
		nlist.add(intervals.get(0));
		for (int i = 1; i < intervals.size(); i++) {
			// check ith interval's end value is between i-1th's start and end
			if (intervals.get(i).start <= nlist.get(nlist.size() - 1).end) {
				// if true than merge
				Interval nintv = new Interval(
						nlist.get(nlist.size() - 1).start,
						intervals.get(i).end > nlist.get(nlist.size() - 1).end ? intervals.get(i).end
								: nlist.get(nlist.size() - 1).end);
				nlist.set(nlist.size() - 1, nintv);
			} else { // else remain
				nlist.add(intervals.get(i));
			}
		}
		return nlist;
	}

	public static void main(String[] args) {
		// ArrayList<Interval> intervals1 = new ArrayList<>();
		// intervals1.add(new Interval(1, 3));
		// intervals1.add(new Interval(6, 9));
		// ArrayList<Interval> list1 = insert(intervals1, new Interval(2, 5));
		// for (Interval l : list1)
		// // [1,5],[6,9].
		// System.out.println(l.start + "  " + l.end);

		ArrayList<Interval> intervals2 = new ArrayList<>();
		intervals2.add(new Interval(1, 2));
		intervals2.add(new Interval(3, 5));
		intervals2.add(new Interval(6, 7));
		intervals2.add(new Interval(8, 10));
		intervals2.add(new Interval(12, 16));
		ArrayList<Interval> list2 = insert(intervals2, new Interval(4, 9));
		for (Interval l : list2)
			// [1,2],[3,10],[12,16].
			System.out.println(l.start + "  " + l.end);
	}

}
