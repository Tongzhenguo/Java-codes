/*
package neuroph;

import org.neuroph.core.Layer;
import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.learning.DataSet;
import org.neuroph.core.learning.DataSetRow;
import org.neuroph.core.learning.LearningRule;
import org.neuroph.nnet.Perceptron;
import org.neuroph.nnet.comp.neuron.ThresholdNeuron;
import org.neuroph.nnet.learning.BinaryDeltaRule;
import org.neuroph.util.*;

*/
/**
 * Created by arachis on 2017/1/15.
 *//*

public class CreateNetWork extends NeuralNetwork{
    private void createNetWork(int inputNeuronsCount,int outputNeuronsCount,TransferFunctionType transferFunctionType){
        //设置神经网络类型，这里我们设置为感知机
        this.setNetworkType(NeuralNetworkType.PERCEPTRON);

        //初始化神经元输入刺激设置
        NeuronProperties inputNeuronProperties = new NeuronProperties();
        inputNeuronProperties.setProperty("transferFunction",TransferFunctionType.LINEAR);

        //创建输入刺激
        Layer inputLayer = LayerFactory.createLayer(inputNeuronsCount, inputNeuronProperties);
        this.addLayer(inputLayer);

        NeuronProperties outputNeuronProperties = new NeuronProperties();
        outputNeuronProperties.setProperty("neuronType", ThresholdNeuron.class);
        outputNeuronProperties.setProperty("thresh", new Double(Math.abs(Math.random())));
        outputNeuronProperties.setProperty("transferFunction",transferFunctionType);
        //为sigmoid和tanh 传输函数设置斜率属性
        outputNeuronProperties.setProperty("transferFunction.slope",new Double(1));

        //创建一个神经元的输出
        Layer outputLayer = LayerFactory.createLayer(outputNeuronsCount, outputNeuronProperties);
        this.addLayer(outputLayer);

        //在输入和输出层中建立全连接
        ConnectionFactory.fullConnect(inputLayer,outputLayer);

        //为神经网络设置默认输入输出
        NeuralNetworkFactory.setDefaultIO(this);
        this.setLearningRule(new BinaryDeltaRule());
    }

    public static void main(String[] args) {
        //利用感知机进行与运算测试

        //建立训练集，有两个输入一个输出
        DataSet trainingSet = new DataSet(2, 1);
        trainingSet.addRow(new DataSetRow(new double[]{.0,.0},new double[]{.0}));
        trainingSet.addRow(new DataSetRow(new double[]{.0,1.0},new double[]{.0}));
        trainingSet.addRow(new DataSetRow(new double[]{1.0,.0},new double[]{.0}));
        trainingSet.addRow(new DataSetRow(new double[]{1.0,1.0},new double[]{1.0}));

        //建立一个感知机,定义输入刺激是2两个，输出是1个
        Perceptron myPerceptron = new Perceptron(2, 1);
        LearningRule lr = myPerceptron.getLearningRule();

//        lr.addListener(this);
        //开始学习训练集
        myPerceptron.learn(trainingSet);

        //测试
        System.out.println("Testing trained perception");
//        testNeuronNetWork(myPerceptron,trainingSet);

    }

}
*/
