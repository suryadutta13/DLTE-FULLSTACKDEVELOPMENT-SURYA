package host;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.smartcardio.Card;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Listofcards {
    private ArrayList<Cards> cards=new ArrayList<>();

    public ArrayList<Cards> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Cards> cards) {
        this.cards = cards;
    }
}
