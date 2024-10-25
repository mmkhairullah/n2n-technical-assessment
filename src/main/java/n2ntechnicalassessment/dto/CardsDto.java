package n2ntechnicalassessment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CardsDto {

    private int playerNumber;

    private String cardId;

    public CardsDto(int playerNumber, String cardId) {
        this.playerNumber = playerNumber;
        this.cardId = cardId;
    }

    // Getters for encapsulation
    public int getPlayerNumber() {
        return playerNumber;
    }

    public String getCardId() {
        return cardId;
    }



}
