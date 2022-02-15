package com.example.demotest;

import org.springframework.util.StringUtils;

/**
 * @author 田一品
 * @desc
 * @date 2022/1/24
 */
public class test {
    public static void main(String[] args) {
        System.out.printf(lengthOfLongestSubstring("dvdf") + "");
    }

        public static int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            int length = 0;
            int maxLength = 0;
            char[] chars = s.toCharArray();
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i< chars.length; i++) {
                int i1 = builder.toString().indexOf(chars[i]);
                if (i1 == -1 ) {
                    builder.append(chars[i]);
                    length ++;
                    if (length > maxLength) {
                        maxLength = length;
                    }
                } else {
                    String temp = builder.toString().substring(i1 + 1)
                            + (chars[i]);
                    builder.delete(0, builder.length());
                    builder.append(temp);
                    length = 0;
                }
            }
            
            return maxLength;
        }
}
