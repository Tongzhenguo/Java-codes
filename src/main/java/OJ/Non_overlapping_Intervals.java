package OJ;

import datastructure.Interval;

import java.util.Arrays;

/**
 * Created by arachis on 2017/10/4.
 *
 * Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

 Note:
 You may assume the interval's end point is always bigger than its start point.
 Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.

 Example 1:
 Input: [ [1,2], [2,3], [3,4], [1,3] ]
 Output: 1
 Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.

 Example 2:
 Input: [ [1,2], [1,2], [1,2] ]
 Output: 2
 Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.

 Example 3:
 Input: [ [1,2], [2,3] ]
 Output: 0
 Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 */
public class Non_overlapping_Intervals {
    /**
     * the classic Greedy problem
     * Sorting Interval.end in ascending order :O(nlogn), then traverse intervals array to get the maximum number of non-overlapping intervals: O(n). Total is O(nlogn).
     */
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0)  return 0;

        Arrays.sort(intervals,(a, b) -> a.end - b.end );
        int end = intervals[0].end;
        int count = 1;

        for (int i = 1; i < intervals.length; i++) {
            if (end <= intervals[i].start) {
                end = intervals[i].end;
                count++;
            }
        }
        return intervals.length - count;
    }


}
