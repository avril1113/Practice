/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    private List<Integer> list = new ArrayList<>();
    private int index;

    public NestedIterator(List<NestedInteger> nestedList) {
        getListHelper(nestedList);
        index = 0;
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return list.get(index++);
        }
        
        return null;
    }

    @Override
    public boolean hasNext() {
        if (index < list.size())
           return true;
        
        return false;
    }
    
    private void getListHelper(List<NestedInteger> l) {
        for (NestedInteger nest : l) {
            if (nest.isInteger()) {
                list.add(nest.getInteger());
            } else {
                getListHelper(nest.getList());
            }
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */