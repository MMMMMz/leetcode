class Solution {

    class Point{
        int val;
        int pos;
        public Point(int val, int pos){
            this.val = val;
            this.pos = pos;
        }
    }

    public int[] advantageCount(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        PriorityQueue<Point> maxpq = new PriorityQueue<>(
        (Point p1, Point p2) -> { 
            return p2.val - p1.val;
        });

        for(int i = 0 ; i < nums2.length ; i++)
        {
           maxpq.offer(new Point(nums2[i], i));
        }

        Arrays.sort(nums1);
        int left = 0;
        int right = nums1.length - 1;
        while(!maxpq.isEmpty())
        {
            Point p = maxpq.poll();
            if(nums1[right] > p.val){
                res[p.pos] = nums1[right];
                right--;
            } else {
                res[p.pos] = nums1[left];
                left++;
            }
        }

        return res;
    }
}
