/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int in[] = new int[n];
        int out[] = new int[n];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++)
            {
                if(knows(i, j) && i != j){
                    in[j]++;
                    out[i]++;
                }
            }
        }

        for(int i = 0 ; i < n ; i++)
        {
            if(in[i] == n - 1 && out[i] == 0){
                return i;
            }
        }
        return -1;
    }
}
