package OJ;

/**
 * Created by arachis on 2017/5/3.
 */
public class Excel_Sheet_Column_Title {
    public String convertToTitle(int n) {
        if(n == 0) return "";//特殊情况，EXCEL中是没有第0列的
        n = n -1;
        //因为一般进制是从0开始，而EXCEL是从1开始的，为了统一，所以这里减一；
        //原来是1，2，3;这里就成了0，1，2
        int div = n / 26;
        int mod = n % 26;
        return  convertToTitle(div ) + (char)( 'A' + mod );
    }

}
