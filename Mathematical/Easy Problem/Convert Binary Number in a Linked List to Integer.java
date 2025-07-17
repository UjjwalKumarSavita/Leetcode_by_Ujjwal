// https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/description/

public class Solution {
    public int getDecimalValue(ListNode head) {
        StringBuilder st = new StringBuilder();
        ListNode temp = head;
        while(temp != null){
            st.append(temp.val);
            temp = temp.next;
        }
        int decimal = 0;
        int len = st.length();
        int pow = 1;
        for(int i = len - 1 ; i >= 0 ; i--){
            int rem = st.charAt(i) - '0';
            // System.out.println(rem);
            decimal += rem * pow;

            pow *= 2;
        }

        return decimal;
    }
}