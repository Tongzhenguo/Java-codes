package OJ;

import datastructure.NestedInteger;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by arachis on 2017/9/15.
 *
 * Given a nested list of integers, implement an iterator to flatten it.

 Each element is either an integer, or a list -- whose elements may also be integers or other lists.

 Example 1:
 Given the list [[1,1],2,[1,1]],

 By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].

 Example 2:
 Given the list [1,[4,[6]]],

 By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
 */


/*
* In the constructor, we push all the nestedList into the stack from back to front, so when we pop the stack, it returns the very first element.
 * Second, in the hasNext() function, we peek the first element in stack currently, and if it is an Integer, we will return true and pop the element.
  * If it is a list, we will further flatten it.
 * This is iterative version of flatting the nested list. Again, we need to iterate from the back to front of the list.
*
* */
public class NestedIterator implements Iterator<Integer> {

    Stack<NestedInteger> stack = new Stack<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        for(int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()) {
            NestedInteger curr = stack.peek();
            if(curr.isInteger()) {
                return true;
            }
            stack.pop();
            for(int i = curr.getList().size() - 1; i >= 0; i--) {
                stack.push(curr.getList().get(i));
            }
        }
        return false;
    }
}
