class MedianFinder {

    //大顶堆放小的，小顶堆放大的
    //为奇数的时候，先放小顶堆，再放大顶堆。为偶数的时候先放大顶堆，再放小顶堆
    //最后，为奇数的时候，是小顶堆的顶，是偶数的时候，（大顶堆+小顶堆）/2
    PriorityQueue<Integer> minQueue;
    PriorityQueue<Integer> maxQueue;

    /** initialize your data structure here. */
    public MedianFinder() {
        minQueue = new PriorityQueue<>();
        maxQueue = new PriorityQueue<>((a, b) -> (b - a));
    }
    
    public void addNum(int num) {
        if(minQueue.size() == maxQueue.size()){
            maxQueue.offer(num);
            minQueue.offer(maxQueue.poll());
        } else {
            minQueue.offer(num);
            maxQueue.offer(minQueue.poll());
        }
    }
    
    public double findMedian() {
        if(minQueue.size() == maxQueue.size()){
            return (maxQueue.peek() + minQueue.peek()) / 2.0;
        } else {
            return minQueue.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
