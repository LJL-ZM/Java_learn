public class Card {
    private Character suit;
    private Integer rank;

    public Card(Character suit, Integer rank){
        this.rank = rank;
        this.suit = suit;
    }

    public Character getSuit() {
        return suit;
    }

    public void setSuit(Character suit) {
        this.suit = suit;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "" + suit + rank;
    }
}
