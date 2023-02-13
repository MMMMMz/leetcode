class MinStack {

    Deque<Long> stack;
    PriorityQueue<Long> queue;
    public MinStack() {
        stack = new ArrayDeque<>();
        queue = new PriorityQueue<>();
    }
    
    public void push(int val) {
        stack.push((long)val);
        queue.offer((long)val);
    }
    
    public void pop() {
        long popNum = stack.peek();
        stack.pop();
        queue.remove(popNum);
    }
    
    public int top() {
        
        return (int)stack.peek().longValue();
    }
    
    public int getMin() {
        return (int)queue.peek().longValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
