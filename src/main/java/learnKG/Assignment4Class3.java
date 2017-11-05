package learnKG;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by arachis on 2017/11/3.
 */
public class Assignment4Class3 {

    //任务2中过滤实体用的可选属性
    enum CleanAttr {
        ABSTRACT("摘要",0), CATEGORY("类别",1), NAME("名字",2), SECTION("宗派",3);

        private String name ;
        private int index ;

        private CleanAttr( String name , int index ){
            this.name = name ;
            this.index = index ;
        }

        public String getName() {
            return name;
        }
        public int getIndex() {
            return index;
        }
    }

    /**********************************************************************
     * 给定字符串与正则表达式，打印所有匹配的子串
     * String str : 带匹配的字符串
     * String regex : 模板(正则表达式)
     **********************************************************************/
    public void extract(String str, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    /**********************************************************************
     * 给定知识库的abstract文件与正则表达式，使用正则从abstract中抽取属性值，每抽出一条属性值打印一行abstract一行属性的主语、宾语对
     * String input : 实体abstract属性文件的完整路径
     * String regex : 模板
     **********************************************************************/
    public void extractFromFile(String input, String regex) throws IOException {
        Pattern pattern = Pattern.compile(regex);
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(input), "utf-8"));
        String line = "";
        while ((line=br.readLine())!=null) {
            String subject = line.split("/resource/")[1].split("> <")[0];
            String sentence = line.split("> \"")[1].split("\"")[0];
            Matcher matcher = pattern.matcher(sentence);
            while (matcher.find()) {
                System.out.println("sentence: "+sentence);
                System.out.println("relation: "+subject+"\t:\t"+matcher.group());
            }
        }
        br.close();
    }

    /**********************************************************************
     * 给定人工标注文件路径和阈值，被标注为正确实体的次数不小于阈值则被视为正确实体返回，否则被视为错误实体打印出来
     * String path : 人工标注结果文件的路径
     * int threshold : 阈值
     **********************************************************************/
    public HashSet<String> clean(String path, int threshold) throws IOException {
        HashSet<String> result = new HashSet<>();
        HashMap<String, Integer> countMap = new HashMap<>();
        File[] fileList = new File(path).listFiles();
        for (File file:fileList){
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path+file.getName()),"utf-8"));
            String line = "";
            while ((line=br.readLine())!=null) {
                if (countMap.containsKey(line)){
                    int count = countMap.get(line);
                    countMap.put(line, ++count);
                } else {
                    countMap.put(line, 1);
                }
            }
            br.close();
        }

        System.out.println("/******* 通过标注去除的实体 *******/");
        int removeCount = 0;
        for (String key:countMap.keySet()){
            if (countMap.get(key)>=threshold){
                result.add(key);
            } else {
                System.out.println(key);
                removeCount++;
            }
        }
        System.out.println("/******* 共计"+removeCount+"个 *******/");

        return result;
    }

    /**********************************************************************
     * 给定实体和知识库的属性文件，属性值中包含过滤词的实体被视为错误实体打印出来，不包含过滤词的实体被视为正确实体返回
     * CleanAttr attr : 数据清洗使用的属性，可选属性包括：CleanAttr.ABSTRACT, CleanAttr.CATEGORY, CleanAttr.NAME, CleanAttr.SECTION
     * HashSet<String> entities : 待过滤的集体集合
     * String aliasFile : 实体属性文件完整路径
     * String[] filters :  过滤词
     **********************************************************************/
    public HashSet<String> clean(CleanAttr attr, HashSet<String> entities, String attrFile, String[] filters) throws IOException {
        System.out.println("/******* 通过"+attr.getName()+"去除的实体 *******/");
        int removeCount = 0;
        HashSet<String> result = new HashSet<>();
        if (attr.equals(CleanAttr.NAME)){
            for (String sbj:entities){
                boolean remove = false;
                for (String filter:filters) {
                    if (sbj.contains(filter))
                        remove = true;
                }
                if (remove) {
                    System.out.println(sbj);
                    removeCount++;
                } else {
                    result.add(sbj);
                }
            }
        } else {
            result = entities;
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(attrFile),"utf-8"));
        String line = "";
        while ((line=br.readLine())!=null) {
            String subject = line.split(" <")[0];
            if (result.contains(subject)) {
                boolean remove = false;
                for (String filter:filters){
                    if (line.contains(filter))
                        remove = true;
                }
                if (remove) {
                    System.out.println(subject);
                    result.remove(subject);
                    removeCount++;
                }
            }
        }
        br.close();
        System.out.println("/******* 共计"+removeCount+"个 *******/");
        return result;
    }

    public static void main(String args[]) throws IOException {
        Assignment4Class3 assignment = new Assignment4Class3();
        /*************************** 任务1 *************************************
         * 包括一个java使用正则表达式的示例和一个从实体的abstract中抽取寺庙位
         * 置属性的示例。
         **********************************************************************/
        //java使用正则表达式示例
        String str = "万佛寺是中国成都一座已经不存在的佛教寺庙，遗址位于市一环路北二段与白马寺街交叉路口北侧，即成都老城西门外。";
        assignment.extract(str,"位于[^，|^。]+");

        //从实体的abstract中抽取寺庙位置属性
        assignment.extractFromFile("resource/Assignment1/abstracts.ttl","位于[^，|^。]+");

        /*************************** 任务2 *************************************
         * 首先根据人工标注的结果过滤掉置信度低的实体，置信度高的实体可通过
         * 实体的属性信息过滤，每次过滤打印错误的实体，返回正确的实体。
         **********************************************************************/
        //根据人工标注的结果过滤掉置信度低的实体
        HashSet<String> temples = new HashSet<>();
        String labeledFilePath = "resource/Assignment2/entities_labeled/";
        temples = assignment.clean(labeledFilePath,3);

        //根据实体的属性过滤掉属性值包含过滤词的实体
        //可选属性包括：CleanAttr.ABSTRACT, CleanAttr.CATEGORY, CleanAttr.NAME, CleanAttr.SECTION
        String abstractFile = "resource/Assignment2/abstracts.ttl";
        String[] abstractFilters = {"官署","清真","阿訇","穆斯林","伊斯兰教","礼拜","天主教","出版"};
        temples = assignment.clean(CleanAttr.ABSTRACT, temples, abstractFile, abstractFilters);
    }

}
