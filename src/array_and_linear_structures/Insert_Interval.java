package array_and_linear_structures;

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
	/**
	 * Divide 'intervals' into three parts: (1) the ones that don't need to
	 * merged and comes before newInterval; (2) the ones that need to be
	 * merged/added/removed; (3) the ones that don't need to be merged and comes
	 * after newInterval. So this algorithm can be taken into three steps: (a)
	 * copy smaller intervals into list; (b) merge overlapping intervals; and
	 * (c) copy larger intervals into list.
	 */
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> list = new ArrayList<>();
		if (intervals == null || intervals.size() == 0) {
			list.add(newInterval);
			return list;
		}
		if (newInterval.end < intervals.get(0).start) { // if newInterval is
														// added to the head
			list.add(newInterval);
			list.addAll(intervals);
			return list;
		}
		if (newInterval.start > intervals.get(intervals.size() - 1).end) { // if
																			// newInterval
																			// is
																			// added
																			// to
																			// the
																			// tail
			list.addAll(intervals);
			list.add(newInterval);
			return list;
		}
		int index = 0;
		// add those whose end is smaller than newInterval's start
		while (index < intervals.size() && intervals.get(index).end < newInterval.start) {
			list.add(intervals.get(index));
			index++;
		}
		if (index == intervals.size()) {
			list.add(newInterval);
			return list;
		}
		// merge/add/remove those whose start <= newInterval.end
		int nstart = newInterval.start, nend = newInterval.end; // new
																// interval's
																// start and end
		while (index < intervals.size() && intervals.get(index).start <= newInterval.end) {
			nstart = Math.min(intervals.get(index).start, nstart);
			nend = Math.max(intervals.get(index).end, nend);
			index++;
		}
		list.add(new Interval(nstart, nend));
		// add the rest of intervals into the new list
		for (int i = index; i < intervals.size(); i++) {
			list.add(intervals.get(i));
		}
		return list;
	}

	public static void main(String[] args) {
		// List<Interval> intervals1 = new ArrayList<>();
		// intervals1.add(new Interval(1, 3));
		// intervals1.add(new Interval(6, 9));
		// ArrayList<Interval> list1 = insert(intervals1, new Interval(2, 5));
		// for (Interval l : list1)
		// // [1,5],[6,9].
		// System.out.println(l.start + "  " + l.end);

		List<Interval> intervals2 = new ArrayList<>();
		intervals2.add(new Interval(1, 2));
		intervals2.add(new Interval(3, 5));
		intervals2.add(new Interval(6, 7));
		intervals2.add(new Interval(8, 10));
		intervals2.add(new Interval(12, 16));
		List<Interval> list2 = insert(intervals2, new Interval(4, 9));
		for (Interval l : list2)
			// [1,2],[3,10],[12,16].
			System.out.println(l.start + "  " + l.end);
	}

}
