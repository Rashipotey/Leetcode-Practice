class NumberContainers {
    Map<Integer, Integer> indexToNumbers;
    Map<Integer, TreeSet<Integer>> numberToIndices;
    public NumberContainers() {
        indexToNumbers=new HashMap<>();
        numberToIndices=new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(indexToNumbers.containsKey(index)) {
            int previousNumber=indexToNumbers.get(index);
            numberToIndices.get(previousNumber).remove(index);
            if(numberToIndices.get(previousNumber).isEmpty()) {
                numberToIndices.remove(previousNumber);
            }
        }
        indexToNumbers.put(index, number);
        numberToIndices.putIfAbsent(number, new TreeSet<>());
        numberToIndices.get(number).add(index);
    }
    
    public int find(int number) {
        if(numberToIndices.containsKey(number)) {
            return numberToIndices.get(number).first();
        }
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */