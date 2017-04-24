package OJ;

/**
 * Created by arachis on 2017/4/11.
 * 一个非负整数的数组，假设你的初始位置是0，数组的每一个元素A[i]代表这你可走的最大步数，设计算法判断你是否可以到达n-1
 * Idea is to work backwards from the last index. Keep track of the smallest index that can "jump" to the last index.
 * Check whether the current index can jump to this smallest index.
 */
public class Jump_Game {
    public boolean canJump(int A[]) {
        int last=A.length-1;// backwards from the last index.
        for(int i=A.length-2;i>=0;i--){//后向遍历，判断从当前位置是否可以到达起始位置
            if(i+A[i]>=last) last=i;// Keep track of the smallest index that can "jump" to the last index.
        }
        return last<=0;
    }

    public static void main(String[] args) {
        new Jump_Game().canJump( new int[]{ 3,2,1,0,4 } );
    }

}
