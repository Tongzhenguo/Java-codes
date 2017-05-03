package OJ;

/**
 * Created by arachis on 2017/5/3.
 */
public class Excel_Sheet_Column_Title {
    public String convertToTitle(int n) {
        if(n == 0) return "";
        //从右到左，注意A-Z是从1开始的，但一般进制是从0开始，所以用“”表示数字0
        n = n -1;
        int div = n / 26;
        int mod = n % 26;
        return  convertToTitle(div ) + (char)( 'A' + mod );
    }

}
