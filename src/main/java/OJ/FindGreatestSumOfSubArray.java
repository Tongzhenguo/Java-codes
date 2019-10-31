package OJ;

public class FindGreatestSumOfSubArray {
    /**
     * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
     * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
     * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
     * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
     * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        // 动态规划求解
        //    阶段(按下标i进行划分)
        //  ，状态(全部保留f(i),只留下现元素array[i]; 初始状态:s0 = array[0])
        //  ，决策(选最大的数组和 : max{ f(i),f(i-1),array[i] } )
        //  ，状态转移公式：f(i) = max{ f(i),array[i] }

        // 保留阶段i的最佳状态，不考虑之前状态
        int pre = array[0];
        int res = array[0];
        for(int i = 1; i < array.length; i++){
            res = Math.max(Math.max(res,pre+array[i]),array[i]);
            pre = Math.max(pre+array[i],array[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        FindGreatestSumOfSubArray o = new FindGreatestSumOfSubArray();
        int[] sequence = {6,-3,-2,7,-15,1,2,2};
        System.out.println(o.FindGreatestSumOfSubArray(sequence));
    }
}