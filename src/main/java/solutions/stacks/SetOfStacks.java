package solutions.stacks;

public class SetOfStacks {
    final int stackCapacity = 10;
    final int maxNumStacks = 10;

    int[] heights = new int[maxNumStacks];
    Stack[] stacks = new Stack[maxNumStacks];

    public Object pop() {
        int s = findLast();
        if (heights[s] == 0) return null;
        heights[s]--;
        return stacks[s].pop();
    }

    public void push(Object item) {
        int s = findFirstUnfilled();
        if (stacks[s] == null) stacks[s] = new Stack();
        stacks[s].push(item);
        heights[s]++;
    }

    public int findFirstUnfilled() {
        for (int s = 0; s < heights.length; s++) {
            if (heights[s] < stackCapacity) {
                return s;
            }
        }
        return increaseNumStacks();
    }

    public int findLast() {
        for (int s = heights.length - 1; s > -1; s--) {
            if (heights[s] > 0) {
                return s;
            }
        }
        return 0;
    }

    public int increaseNumStacks() {
        return 0;
    }
}