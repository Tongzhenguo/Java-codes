package OJ;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tongzhenguo on 2019/10/28.
 *
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 */


public class Pascals_Triangle_II {

    // 杨辉三角n行m列通项公式为：$C_{n-1}^{m-1} = \frac{(n-1)!}{(m-1)!(n-m)!}$
    // 组合数又有如下规律：$C_{n-1}^{m-1} = C_{n-1}^{m-2} * \frac{n-m}{m-1} $
    public List<Integer> getRow(int rowIndex) {
        // note(a-lan-ruo-2): C(4,1)=C(4,0)*4/1,C(4,2)=C(4,1)*3/2,
        //C(4,3)=C(4,2)*2/3,C(4,4)=C(4,3)*1/4:
        //找到规律
        List<Integer> res = new ArrayList<Integer>(rowIndex+1);
        long nk = 1;
        for(int i = 0; i <= rowIndex; i++){
            res.add((int)nk);
            // C_{rowIndex}^{i}到C_{rowIndex}^{i+1}的递推公式
            nk = nk * (rowIndex - i) / (i + 1);
        }
        return res;
    }

}
