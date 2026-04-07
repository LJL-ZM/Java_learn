import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    private final Integer DECK_SIZE = 52;
    private final Integer ONE_SUIT_CNT = 13;
    private final Integer PLEAR_CNT = 4;
    private final Character[] suits = {'♥', '♠', '♣', '♦'};
    private ArrayList<Card> deck = new ArrayList<>(DECK_SIZE);
    //生成牌堆中所有牌，顺序
    public Deck(){
        for(int k = 0; k < suits.length; k++){
            Character suit = suits[k];
            for(int rank = 1; rank <= ONE_SUIT_CNT; rank++){
                deck.add(new Card(suit, rank));
            }
        }
    }
    private void swap(int pos1, int pos2){
        Card tmp = deck.get(pos1);
        deck.set(pos1, deck.get(pos2));
        deck.set(pos2, tmp);
    }
    //进行一次洗牌
    public void shuffle(){
        //对于每一个位置的牌，都生成一个0-51的随机数，将它与对应位置的牌互换
        Random random = new Random();
        for(int i = 0; i < deck.size(); i++){
            int pos = random.nextInt(DECK_SIZE);
            swap(pos, i);
        }
    }

    //进行一次发牌
    public List<List<Card>> deal(){
        List<List<Card>> ret = new ArrayList<>();
        for(int i = 1; i <= PLEAR_CNT; i++){
            List<Card> onePlear = new ArrayList<>();
            for(int j = 0; j < DECK_SIZE / PLEAR_CNT; j++){
                onePlear.add(deck.get(j + (i - 1) * (DECK_SIZE / PLEAR_CNT)));
            }
            ret.add(onePlear);
        }
        return ret;
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        for(int i = 0; i < deck.size(); i++){
            stringBuilder.append(deck.get(i).toString() + " ");
            if(i % 4 == 3 && i != deck.size() - 1){
                stringBuilder.append('\n');
            }
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
    public static void main(String[] args){
        Deck deck = new Deck();
        deck.shuffle();
        List<List<Card>> playerCards = deck.deal();
        for(int i  = 0; i < 4; i++){
            System.out.println(playerCards.get(i));
        }
        //System.out.println(deck);
    }
}
