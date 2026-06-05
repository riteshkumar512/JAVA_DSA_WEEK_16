package Lecture_26;

import java.util.Stack;

public class Lc_84LargestRectangleinHistogram {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};

        System.out.println(Largest_Rectangle(heights));

    }
    public static int Largest_Rectangle(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!st.isEmpty() && heights[i] < heights[st.peek()]) {
                int h = heights[st.pop()];
                int r = i;
                if (st.isEmpty()) {
                    ans = Math.max(ans, h * r);
                } else {
                    int l = st.peek();
                    ans = Math.max(ans, h * (r - l - 1));
                }
            }
            st.push(i);
        }
        int r = heights.length;
        while (!st.isEmpty()) {
            int h = heights[st.pop()];
            if (st.isEmpty()) {
                ans = Math.max(ans, h * r);
            } else {
                int l = st.peek();
                ans = Math.max(ans, h * (r - l - 1));
            }
        }
        return ans;
    }
}
