/*
package data.code.learntoWeka;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;

*/
/**
 * Created by arachis on 2016/12/7.
 * link:http://blog.csdn.net/Bryan__/article/details/40902923?locationNum=2&fps=1
 *//*

public class Demo1 {

    static Classifier cModel = null;

    public static void main(String[] args) {
        FastVector fvWekaAttributes = step1();
        try {
            Instances isTrainingSet = step2(fvWekaAttributes);
            step3(isTrainingSet,isTrainingSet);
            step4(isTrainingSet,isTrainingSet.firstInstance());

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    */
/**
     * 第四步：使用这个分类器
     * @param isTrainingSet
     *//*

    private static void step4(Instances isTrainingSet,Instance iUse) throws Exception {
        // Specify that the instance belong to the training set
        // in order to inherit from the set description
        iUse.setDataset(isTrainingSet);

        // Get the likelihood of each classes
        // fDistribution[0] is the probability of being “positive”
        // fDistribution[1] is the probability of being “negative”
        double[] fDistribution = cModel.distributionForInstance(iUse);
    }

    */
/**
     * 第三步：测试分类器
     * @param isTrainingSet
     *//*

    private static void step3(Instances isTrainingSet,Instances isTestingSet) throws Exception {
        // Test the model
        Evaluation eTest = new Evaluation(isTrainingSet);
        eTest.evaluateModel(cModel, isTestingSet);

        // Print the result à la Weka explorer:
        String strSummary = eTest.toSummaryString();
        System.out.println(strSummary);

        // Get the confusion matrix
        //double[][] cmMatrix = eTest.confusionMatrix();
        System.out.println(eTest.toMatrixString());
    }

    */
/**
     * 第一步：用特征表达问题（属性）
     这一步相当于构建一个arff文件
     我们先把特征放入weka.core.FastVector中
     每个特征都包含在weka.core.Attribute类中
     现在我们有 两个numeric 特征，一个 nominal 特征 (blue, gray, black) 和一个 nominal 类 (positive, negative).
     *//*

    private static FastVector step1() {
        // Declare two numeric attributes
        Attribute Attribute1 = new Attribute("firstNumeric");
        Attribute Attribute2 = new Attribute("secondNumeric");

        // Declare a nominal attribute along with its values
        FastVector fvNominalVal = new FastVector(3);
        fvNominalVal.addElement("blue");
        fvNominalVal.addElement("gray");
        fvNominalVal.addElement("black");
        Attribute Attribute3 = new Attribute("aNominal", fvNominalVal);

        // Declare the class attribute along with its values
        FastVector fvClassVal = new FastVector(2);
        fvClassVal.addElement("positive");
        fvClassVal.addElement("negative");
        Attribute ClassAttribute = new Attribute("theClass", fvClassVal);

        // Declare the feature vector
        FastVector fvWekaAttributes = new FastVector(4);
        fvWekaAttributes.addElement(Attribute1);
        fvWekaAttributes.addElement(Attribute2);
        fvWekaAttributes.addElement(Attribute3);
        fvWekaAttributes.addElement(ClassAttribute);
        return fvWekaAttributes;
    }

    */
/**
     *第二步：训练分类器
     需要训练集实例和分类器
     我们先创建一个空的训练集（weka.core.Instances）
     命名这个关系为 “Rel”（相当于文件名字）
     属性模型使用第一步中定义的vector定义
     初始化训练集容量为10
     定义类属性为第一步向量中的第四个（classindex）
     *//*

    private static Instances step2(FastVector fvWekaAttributes) throws Exception {
        // Create an empty training set
        Instances isTrainingSet = new Instances("Rel", fvWekaAttributes, 10);
        // Set class index
        isTrainingSet.setClassIndex(3);
        // Create the instance
        Instance iExample = new MyInstance();
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(0), 1.0);
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(1), 0.5);
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(2), "gray");
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(3), "positive");

        // add the instance
        isTrainingSet.add(iExample);

        // Create a naïve bayes classifier
        cModel = (Classifier)new NaiveBayes();
        cModel.buildClassifier(isTrainingSet);
        return isTrainingSet;
    }




}
*/
