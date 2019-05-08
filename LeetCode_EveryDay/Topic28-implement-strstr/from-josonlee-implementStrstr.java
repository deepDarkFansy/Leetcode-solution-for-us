//实现 strStr() 函数。 
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回 -1。 
//
// 示例 1: 
//
// 输入: haystack = "hello", needle = "ll"
//输出: 2
// 
//
// 示例 2: 
//
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
// 
//
// 说明: 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。 
//

class Solution {
    public int strStr(String haystack, String needle) {
        if(needle==null||needle.length()==0) return 0;

        char[] arr1 = haystack.toCharArray();
        char[] arr2 = needle.toCharArray();

        int result = 0;

        for(int i=0;i<arr1.length;i++){
            if(i+arr2.length>arr1.length) return -1;//长度不足以匹配
            int j = i+arr2.length-1;
            boolean flag = true;//标记有无完全匹配
            if(arr1[i]!=arr2[0]) continue;
            for(int k=0;k<=arr2.length/2;k++){
                if(arr1[i+k]==arr2[k]&&arr1[j-k]==arr2[arr2.length-k-1])
                    continue;
                else flag = false;
            }
            if(flag){
                result = i;
                break;
            }
        }
        return result;
    }
}