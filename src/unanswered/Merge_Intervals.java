package unanswered;

import java.util.ArrayList;
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
		ArrayList<Interval> list = new ArrayList<>();

		return list;
	}

	public static void main(String[] args) {
		ArrayList<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(2, 6));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(15, 18));
		System.out.println(merge(intervals));
	}

}
