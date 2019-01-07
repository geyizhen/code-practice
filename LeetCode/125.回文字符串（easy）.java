/*
** Data     ：2018-12-24 21:42:26
** Author   ：geyizhen
** Language ：java
** Summury  ：
*/
/*
qusetion describe:

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama"is a palindrome.
"race a car"is not a palindrome.

Note: 
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
*/
public class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            while(!isNumberOrLetter(s.charAt(i)) && i < j)
                i ++;
            while(!isNumberOrLetter(s.charAt(j)) && i < j)
                j --;
            if(i < j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                return false;//Character.toLowerCase 是将字符转为小写
            i ++;
            j --;
        }
        return true;
    }
    public boolean isNumberOrLetter(char s){
        if(s >= '0' && s <= '9' || s >= 'a' && s <= 'z' || s >= 'A' && s <= 'Z')
            return true;
        return false;
        
    }
}