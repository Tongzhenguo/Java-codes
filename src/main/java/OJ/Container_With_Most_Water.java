package OJ;

/**
 * Created by arachis on 2017/4/18.
 * Given n non-negative integers a1, a2, ..., an,
 * where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 Note: You may not slant the container and n is at least 2.

 给定n个非负整数a1，a2，...，an，其中每个表示坐标（i，ai）处的点。
 绘制n条垂直线，使得线i的两个端点在（i，ai）和（i，0）处。S(i,j) = min(ai, aj) * (j-i)
 找到两条线，它们与x轴一起形成一个容器，使得容器含有最多的水。 注意：您不能倾斜容器，n至少为2。
 */
public class Container_With_Most_Water {
    /**
     * In this problem, the smart scan way is to set two pointers initialized at both ends of the array. Every time move the smaller value pointer to inner array.
     * Then after the two pointers meet, all possible max cases have been scanned and the max situation is 100% reached somewhere in the scan.
     */
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right])
                    * (right - left));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return maxArea;
    }

}
