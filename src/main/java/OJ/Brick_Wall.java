package OJ;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tongzhenguo on 2017/5/22.
 * There is a brick wall in front of you. The wall is rectangular and has several rows of bricks.
 * The bricks have the same height but different width. You want to draw a vertical line from the top to the bottom and cross the least bricks.

 The brick wall is represented by a list of rows. Each row is a list of integers representing the width of each brick in this row from left to right.

 If your line go through the edge of a brick, then the brick is not considered as crossed.
 一道砖墙，每块砖的长度不同，设计算法画一条垂线，使得经过的砖最少，不能再墙边画垂线，返回最少通过的砖
 Example:
 Input:
 [[1,2,2,1],
 [3,1,2],
 [1,3,2],
 [2,4],
 [3,1,2],
 [1,3,1,1]]
 Output: 2

 *
 */
public class Brick_Wall {
    /**
     * We want to cut from the edge of the most common location among all the levels,
     * hence using a map to record the locations and their corresponding occurrence.
     * 计算共现次数最多的长度，然后画一刀
     */
    public int leastBricks(List<List<Integer>> wall) {
        if(wall.size() == 0) return 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(List<Integer> list : wall){
            int length = 0;
            for(int i = 0; i < list.size() - 1; i++){
                length += list.get(i);
                map.put(length, map.getOrDefault(length, 0) + 1);
                count = Math.max(count, map.get(length));
            }
        }
        return wall.size() - count;
    }



}
