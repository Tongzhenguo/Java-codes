package datastructure;

/**
 * Created by arachis on 2017/10/6.
 */

//trie，又称前缀树或字典树，是一种有序树
public class TrieNode {

    boolean isWord;
    TrieNode[] next;

    //only lower-case letters.
    public TrieNode(){
        next = new TrieNode[26];
    }
}
