package OJ;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by arachis on 2017/10/6.
 *
 * Implement a MapSum class with insert, and sum methods.

 For the method insert, you'll be given a pair of (string, integer). The string represents the key and the integer represents the value.
 If the key already existed, then the original key-value pair will be overridden to the new one.

 For the method sum, you'll be given a string representing the prefix, and you need to return the sum of all the pairs' value whose key starts with the prefix.

 Example 1:
 Input: insert("apple", 3), Output: Null
 Input: sum("ap"), Output: 3
 Input: insert("app", 2), Output: Null
 Input: sum("ap"), Output: 5
 */
public class MapSum {

 /**
  * The key idea is to keep two hash maps, one with just original strings. The other with all prefixes.
  * When a duplicate insert is found, then update all it's prefixes with the difference of previous value of the same key(take it from original map)
  */

 Map<String, Integer> map;
 Map<String, Integer> original;
 /** Initialize your data structure here. */
 public MapSum() {
  map = new HashMap<>();
  original = new HashMap<>();
 }

 public void insert(String key, int val) {
    val -= original.getOrDefault(key, 0); // calculate the diff to be added to prefixes
    String s = "";
    for(char c : key.toCharArray()) {
     s += c; // creating all prefixes
     map.put(s, map.getOrDefault(s, 0) + val); //update/insert all prefixes with new value
    }
    original.put(key, original.getOrDefault(key, 0) + val);
 }

 public int sum(String prefix) {
     return map.getOrDefault(prefix, 0);
 }

 public static void main(String[] args) {

  /**
   * Your MapSum object will be instantiated and called as such:
   * MapSum obj = new MapSum();
   * obj.insert(key,val);
   * int param_2 = obj.sum(prefix);
   */

 }

}
