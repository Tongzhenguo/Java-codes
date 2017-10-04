package OJ;

import java.util.Arrays;

/**
 * Created by arachis on 2017/10/4.
 *spread in:散布,diameter:直径
 * There are a number of spherical balloons spread in two-dimensional space.
 * For each balloon, provided input is the start and end coordinates of the horizontal diameter.
 * Since it's horizontal, y-coordinates don't matter and hence the x-coordinates of start and end of the diameter suffice.
 * Start is always smaller than end. There will be at most 104 balloons.

 An arrow can be shot up exactly vertically from different points along the x-axis.
 A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend.
 There is no limit to the number of arrows that can be shot.
 An arrow once shot keeps travelling up infinitely.
 The problem is to find the minimum number of arrows that must be shot to burst all balloons.

 Example:
 Input:
 [[10,16], [2,8], [1,6], [7,12]]
 Output:
 2
 Explanation:
 One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6]) and another arrow at x = 11 (bursting the other
 */
public class Minimum_Number_of_Arrows_to_Burst_Balloons {
    /**
     * balloons = [[7,10], [1,5], [3,6], [2,4], [1,4]]
     After sorting(by xend), it becomes:

     balloons = [[2,4], [1,4], [1,5], [3,6], [7,10]]
     So first of all, we shoot at position 4(xend of current balloon), we go through the array and see that all first 4 balloons can be taken care of by this single shot.
     Then we need another shot for one last balloon. So the result should be 2.
     *
     * */
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        int arrowPos = points[0][1];
        int arrowCnt = 1;
        for (int i = 1; i < points.length; i++) {
            if (arrowPos >= points[i][0]) {
                continue;
            }
            arrowCnt++;
            arrowPos = points[i][1];
        }
        return arrowCnt;

    }

}
