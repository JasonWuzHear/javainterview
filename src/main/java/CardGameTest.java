import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CardGameTest {
    int[][] cases = new int[][] {
        {1,2,3,4,5},
        {1,2,3},
        {1,1,1,1,10},
    };

    int[] solns = new int[] {
        6,
        6,
        11,
    };

    @Test
    public void test() {
        for(int i=0; i<cases.length; i++) {
            CardGame game = new CardGame(cases[i]);
            int maxScore = game.getMaxScore(true);
            assertTrue(String.format("case #: %s. maxScore: %s", Integer.toString(i), Integer.toString(maxScore)),
             maxScore == solns[i]);
        }
    }
}