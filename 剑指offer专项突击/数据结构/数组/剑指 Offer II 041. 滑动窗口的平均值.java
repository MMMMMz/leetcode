class MovingAverage {

    int size;
    List<Integer> list;
    int left = 0;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        list = new ArrayList<>();
    }
    
    public double next(int val) {
        double sum = 0;
        list.add(val);
        if(list.size() < size){
            for(int i = 0 ; i < list.size() ; i++){
                sum += list.get(i);
            }
            return sum / list.size();
        } else {
            for(int i = left ; i < left + size ; i++){
                sum += list.get(i);
            }
            left++;
        }
        return sum / size;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
