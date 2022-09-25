class RandomizedSet {

    HashMap<Integer, Integer> index;
    List<Integer> nums;
    Random random;

    public RandomizedSet() {
        index = new HashMap<>();
        nums = new ArrayList<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if(index.containsKey(val)){
            return false;
        }

        nums.add(val);
        index.put(val, nums.size() - 1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!index.containsKey(val)){
            return false;
        }
        nums.set(index.get(val), nums.get(nums.size() - 1));
        index.put(nums.get(nums.size() - 1), index.get(val));
        index.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }
    
    public int getRandom() {
        int randomIndex = random.nextInt(nums.size());
        return nums.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
