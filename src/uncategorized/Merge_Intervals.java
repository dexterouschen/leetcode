package uncategorized;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import test_data_structure.Interval;

/*
 Given a collection of intervals, merge all overlapping intervals.

 For example,
 Given [1,3],[2,6],[8,10],[15,18],
 return [1,6],[8,10],[15,18].
 */

public class Merge_Intervals {

	public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		if (intervals == null || intervals.size() == 0) {
			ArrayList<Interval> l = new ArrayList<>();
			return l;
		}
		ArrayList<Interval> list = new ArrayList<>(intervals);
		// sort intervals based on each's second element
		Collections.sort(list, new Comparator<Interval>() {
			@Override
			public int compare(Interval i1, Interval i2) {
				return i1.start > i2.start ? 1 : (i1.start == i2.start ? 0 : -1);
			}
		});
		// for (Interval i : list) {
		// System.out.println(i.start + " " + i.end);
		// }
		ArrayList<Interval> nlist = new ArrayList<>();
		nlist.add(list.get(0));
		for (int i = 1; i < list.size(); i++) {
			// check ith interval's end value is between i-1th's start and end
			if (list.get(i).start <= nlist.get(nlist.size() - 1).end) { // if
																		// true
																		// than
				// merge
				Interval nintv = new Interval(nlist.get(nlist.size() - 1).start,
						list.get(i).end > nlist.get(nlist.size() - 1).end ? list.get(i).end
								: nlist.get(nlist.size() - 1).end);
				nlist.set(nlist.size() - 1, nintv);
			} else { // else remain
				nlist.add(list.get(i));
			}
		}
		return nlist;
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
