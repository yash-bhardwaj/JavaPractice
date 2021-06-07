// Java program to print
// next greater number
// of Q queries
import java.util.*;

class GFG
{
    public static int[] query(int arr[], int query[]) {
        int ans[] = new int[arr.length];
        Stack<Integer> s = new Stack<>();

        s.push(arr[0]);
        int j = 0;

        for(int i = 1; i < arr.length; i++) {
            int next = arr[i];
            if(!s.isEmpty()) {
                int element = s.pop();

                while(next > element) {
                    ans[j] = next;
                    j++;
                    if(s.isEmpty()) break;
                    element = s.pop();
                }

                if (element > next) s.push(element);
            }
            s.push(next);
        }
        while(!s.isEmpty()) {
            s.pop();
            ans[j] = -1;
            j++;
        }
        return ans;
    }

    // Driver Code
    public static void main(String[] args)
    {
        int arr[] = {3, 4, 2, 7,
                5, 8, 10, 6};
        int query[] = {3, 6, 1};
        int ans[] = query(arr,query);

        for(int i = 0; i < query.length; i++) {
            System.out.print(ans[query[i]] + " ");
        }
    }
}

// This code was contributed
// by Harshit Sood
