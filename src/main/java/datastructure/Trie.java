package datastructure;

/**
 * Created by tongzhenguo on 2019/11/12.
 */

public class Trie {

    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(cur.next[c - 'a'] == null){
                cur.next[c - 'a'] = new TrieNode();
            }
            cur = cur.next[c - 'a'];
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(cur.next[c - 'a'] == null)
                return false;
            else cur = cur.next[c - 'a'];
        }
        return cur.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(cur.next[c - 'a'] == null)
                return false;
            else cur = cur.next[c - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        /**
         * Your Trie object will be instantiated and called as such:
         * Trie obj = new Trie();
         * obj.insert(word);
         * boolean param_2 = obj.search(word);
         * boolean param_3 = obj.startsWith(prefix);
         */

    }

}
