package data.code;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Hello world!
 *
 */

public class ArrayDemo
{
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<Student>() {
            {
                for (int i = 0; i < 10; i++) {
                    Student s = new Student();
                    s.setM_name("T");
                    add(s);
                }
            }
        };
        Student[] array = new Student[1];
        /**
         * If the list fits in the
         * specified array, it is returned therein.  Otherwise, a new array is
         * allocated with the runtime type of the specified array and the size of this list.
         */
        Student[] toArray = list.toArray(array);
        System.out.println(toArray.length);
        System.out.println(Arrays.toString(toArray));

    }

    private static class Student {
        private String m_name;

        public void setM_name(String m_name) {
            this.m_name = m_name;
        }
    }
}
