class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int m = firstList.length;
        int n = secondList.length;
        if(m == 0 || n == 0){
            return new int[0][0];
        }
        List<int[]> list = new ArrayList<>();
        int i = 0, j = 0;

        while(i < m && j < n){
            if(firstList[i][1] < secondList[j][0]){
                i++;
            } else if(firstList[i][0] > secondList[j][1]){
                j++;
            } else {
                list.add(new int[]{Math.max(firstList[i][0], secondList[j][0]), Math.min(firstList[i][1], secondList[j][1])});
                if(firstList[i][1] < secondList[j][1]){
                    i++;
                } else {
                    j++;
                }
            }
        }

        return list.toArray(new int[list.size() - 1][]);

    }
}
