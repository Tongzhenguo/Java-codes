package OJ;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tongzhenguo on 2017/6/26.
 * Your task is to calculate a^b mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.

 Example1:

 a = 2
 b = [3]

 Result: 8
 Example2:

 a = 2
 b = [1,0]

 Result: 1024
 */
public class Super_Pow {
    /**
     * The main idea is cashed on the repeated pattern of the remainder of a^b.
     As long as we know the length of the pattern m, we just have to find an index point of this pattern based on b mod m.
     In addition, if a > 1337, we can let a = a mod 1337.
     Because if we let a = (1337x + c) where c = a mod 1337,
     (1337x + c)(1337x + c)(1337x + c)...(1337x + c) mod 1337 == ccc...c mod 1337.
     */

    int DIV = 1337;

     List<Integer> findLoop(int a){
      List<Integer> index = new ArrayList<>();
      boolean[] set = new boolean[DIV];
      int rem = a % DIV;
      while ( ! set[rem] ) {
       set[rem]=true;
       index.add(rem);
       rem = (rem*a) % DIV;
      }
      return index;
     }

     int modBy(int[] b, int m){
      int rem = 0;
      for (int i=0; i < b.length; i++) {
       rem = (rem*10+b[i]) % m;
      }
      return rem;
     }

     public int superPow(int a, int[] b) {
      if (a==0 || a==DIV || b==null || b.length == 0) return 0;
      if (a==1) return 1;
      if (a > DIV) return superPow( a % DIV, b);
      List<Integer> index = findLoop(a);
      int loopsize = index.size();
      int rem = modBy(b, loopsize);
      rem = rem==0? loopsize: rem;
      return index.get(rem-1);
     }

}
