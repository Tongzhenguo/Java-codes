package data.code.similarity;

/**
 * Created by YYT on 2016/10/10.
 *
 * 对数似然率相似度
 */
public class logLikelihoodRatio {

    public static double entropy(int... elements) {
        double sum = 0;
        for (int element : elements) {
            sum += element;
        }
        double result = 0.0;
        for (int x : elements) {
            if (x < 0) {
                throw new IllegalArgumentException(
                        "Should not have negative count for entropy computation: (" + x + ')');
            }
            int zeroFlag = (x == 0 ? 1 : 0);
            result += x * Math.log((x + zeroFlag) / sum);
        }
        return -result;
    }

    public static double logLikelihoodRatio(int k11, int k12, int k21, int k22) {
        double rowEntropy = entropy(k11, k12) + entropy(k21, k22);
        double columnEntropy = entropy(k11, k21) + entropy(k12, k22);
        double matrixEntropy = entropy(k11, k12, k21, k22);
        return 2 * (matrixEntropy - rowEntropy - columnEntropy);
    }



}
