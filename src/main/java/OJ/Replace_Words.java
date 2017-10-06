package OJ;

import java.util.List;

/**
 * Created by arachis on 2017/10/6.
 * successor:继承者,词缀
 * In English, we have a concept called root, which can be followed by some other words to form another longer word -
 * let's call this word successor. For example, the root an, followed by other, which can form another word another.

 Now, given a dictionary consisting of many roots and a sentence.
 You need to replace all the successor in the sentence with the root forming it.
 If a successor has many roots can form it, replace it with the root with the shortest length.

 You need to output the sentence after the replacement.
 Example 1:
 Input: dict = ["cat", "bat", "rat"]
 sentence = "the cattle was rattled by the battery"
 Output: "the cat was rat by the bat"

 NLP中英文提取词干stemming
 */
public class Replace_Words {

    class TrieNode{
        boolean isWord;
        TrieNode[] next;
        public TrieNode(){
            next = new TrieNode[26];
        }
    }

    TrieNode root = new TrieNode();

    public void add(String word){
        TrieNode cur = root;
        for(int i = 0;i<word.length();i++){
            int c = word.charAt(i)-'a';
            if(cur.next[c] == null){
                cur.next[c] = new TrieNode();
            }
            cur = cur.next[c];
        }
        cur.isWord = true;
    }

    public String findRoot(String word){
        TrieNode cur = root;
        for(int i = 0;i<word.length();i++){
            int c = word.charAt(i)-'a';
            if(cur.next[c] == null){//词典没有出现过的
                return word;
            }
            if(cur.next[c].isWord){//词典出现过，并且路径最短的
                return word.substring(0,i+1);
            }
            cur = cur.next[c];
        }
        return word;
    }

    public String replaceWords(List<String> dict, String sentence) {
        for(int i = 0;i<dict.size();i++){
            add(dict.get(i));
        }
        String[] strs = sentence.split(" ");
        for(int i = 0;i<strs.length;i++){
            strs[i] = findRoot(strs[i]);
        }
        return String.join(" ",strs);
    }
}
