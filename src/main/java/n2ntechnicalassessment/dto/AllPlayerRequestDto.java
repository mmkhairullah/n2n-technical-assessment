package n2ntechnicalassessment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AllPlayerRequestDto {

    List<PlayerNumberDto> allPlayersCards;
}
