package OJ;

/**
 * Created by arachis on 2017/10/6.
 * Implement a trie with insert, search, and startsWith methods.

 Note:
 You may assume that all inputs are consist of lowercase letters a-z.
 */
class TrieNode {
   public boolean isWord;
   public TrieNode[] children = new TrieNode[26];
}

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
       if(cur.children[c - 'a'] == null){
        cur.children[c - 'a'] = new TrieNode();
       }
       cur = cur.children[c - 'a'];
      }
      cur.isWord = true;
  }

 /** Returns if the word is in the trie. */
 public boolean search(String word) {
      TrieNode cur = root;
      for(int i = 0; i < word.length(); i++){
       char c = word.charAt(i);
       if(cur.children[c - 'a'] == null)
            return false;
       else cur = cur.children[c - 'a'];
      }
      return cur.isWord;
 }

 /** Returns if there is any word in the trie that starts with the given prefix. */
 public boolean startsWith(String prefix) {
      TrieNode cur = root;
      for(int i = 0; i < prefix.length(); i++){
       char c = prefix.charAt(i);
       if(cur.children[c - 'a'] == null)
          return false;
       else cur = cur.children[c - 'a'];
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
