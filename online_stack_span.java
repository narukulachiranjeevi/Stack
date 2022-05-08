class StockSpanner {
    List<Integer> list;
    Stack<Integer> stack = new Stack<>();
    public StockSpanner() {
        list = new ArrayList<>();
    }
    
    public int next(int price) {
        list.add(price);
        if(stack.isEmpty()){
            stack.push(list.size()-1);
            return 1;
        }
        while(!stack.isEmpty() &&list.get(stack.peek())<=price){
            stack.pop();
        }
        if(stack.isEmpty()){
            stack.push(list.size()-1);
            return list.size();
        }
        else{
            int index = stack.peek();
            stack.push(list.size()-1);
            return list.size()-index-1;
        }
    }
}
