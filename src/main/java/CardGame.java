import java.util.HashMap;

public class CardGame {
    int[] cards;
    HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();

    public CardGame(int[] cards) {
        this.cards = cards;
    }

    public int getMaxScore(boolean isFirst) {
        if (isFirst) return getMaxScoreFirst(0);
        return getMaxScoreSecond(0);
    }

    int getMaxScoreFirst(int start) {
        // check our hashmap if item is there
        if (memo.containsKey(start)) return memo.get(start);

        // base case
        if (cards.length - start < 4) {
            int score = sumCards(start, cards.length - start);
            memo.put(start, score);
            return score;
        }

        // otherwise, see the max score I can get by going second after I pick.
        int score = 0; int temp = 0;
        for (int i=1; i<4; i++) {
            temp = getMaxScoreSecond(start + i) + sumCards(start, i);
            if (temp > score) score = temp;
        }

        memo.put(start, score);
        return score;
    }

    int getMaxScoreSecond(int start) {
        // base case
        if (cards.length - start < 4) return 0;

        // pretend im my opponent here and track how many cards I've chosen.
        int score = 0; int cardsChosen = 0; int temp = 0;
        for (int i=1; i<4; i++) {
            temp = getMaxScoreFirst(start + i) + sumCards(start, i);
            if (temp > score) {
                score = temp;
                cardsChosen = i;
            }
        }

        // return the maxscore of going first after my opponent has chosen their cards
        return getMaxScoreFirst(start + cardsChosen);
    }

    int sumCards(int start, int grab) {
        int sum = 0;
        for (int i=0; i<start+grab; i++) sum+=cards[i];
        return sum;
    }
}