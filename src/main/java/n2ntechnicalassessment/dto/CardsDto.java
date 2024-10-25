package n2ntechnicalassessment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CardsDto {

    private String cardId;

    public CardsDto(String cardId) {
        this.cardId = cardId;
    }

}
