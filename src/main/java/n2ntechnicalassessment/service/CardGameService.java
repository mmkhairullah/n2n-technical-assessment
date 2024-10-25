package n2ntechnicalassessment.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import n2ntechnicalassessment.converter.CardsConverter;
import n2ntechnicalassessment.dto.CardsDto;
import n2ntechnicalassessment.dto.PhoneModelsAndAttributesDTO;
import n2ntechnicalassessment.repository.CardsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CardGameService {

    private final CardsRepository cardsRepository;
    private final CardsConverter cardsConverter;

    public List<CardsDto> allCardsList() {

        List<CardsDto> cardsList = new ArrayList<>();

        cardsList.add(new CardsDto("2@"));
        cardsList.add(new CardsDto("2#"));
        cardsList.add(new CardsDto("2^"));
        cardsList.add(new CardsDto("2*"));
        cardsList.add(new CardsDto("3@"));
        cardsList.add(new CardsDto("3#"));
        cardsList.add(new CardsDto("3^"));
        cardsList.add(new CardsDto("3*"));
        cardsList.add(new CardsDto("4@"));
        cardsList.add(new CardsDto("4#"));
        cardsList.add(new CardsDto("4^"));
        cardsList.add(new CardsDto("4*"));
        cardsList.add(new CardsDto("5@"));
        cardsList.add(new CardsDto("5#"));
        cardsList.add(new CardsDto("5^"));
        cardsList.add(new CardsDto("5*"));
        cardsList.add(new CardsDto("6@"));
        cardsList.add(new CardsDto("6#"));
        cardsList.add(new CardsDto("6^"));
        cardsList.add(new CardsDto("6*"));
        cardsList.add(new CardsDto("7@"));
        cardsList.add(new CardsDto("7#"));
        cardsList.add(new CardsDto("7^"));
        cardsList.add(new CardsDto("7*"));
        cardsList.add(new CardsDto("8@"));
        cardsList.add(new CardsDto("8#"));
        cardsList.add(new CardsDto("8^"));
        cardsList.add(new CardsDto("8*"));
        cardsList.add(new CardsDto("9@"));
        cardsList.add(new CardsDto("9#"));
        cardsList.add(new CardsDto("9^"));
        cardsList.add(new CardsDto("9*"));
        cardsList.add(new CardsDto("10@"));
        cardsList.add(new CardsDto("10#"));
        cardsList.add(new CardsDto("10^"));
        cardsList.add(new CardsDto("10*"));
        cardsList.add(new CardsDto("J@"));
        cardsList.add(new CardsDto("J#"));
        cardsList.add(new CardsDto("J^"));
        cardsList.add(new CardsDto("J*"));
        cardsList.add(new CardsDto("Q@"));
        cardsList.add(new CardsDto("Q#"));
        cardsList.add(new CardsDto("Q^"));
        cardsList.add(new CardsDto("Q*"));
        cardsList.add(new CardsDto("K@"));
        cardsList.add(new CardsDto("K#"));
        cardsList.add(new CardsDto("K^"));
        cardsList.add(new CardsDto("K*"));
        cardsList.add(new CardsDto("A@"));
        cardsList.add(new CardsDto("A#"));
        cardsList.add(new CardsDto("A^"));
        cardsList.add(new CardsDto("A*"));

        return cardsList;
    }

    public List<CardsDto> getAllCardsList() {
        List<CardsDto> allCardsList = allCardsList();
        return allCardsList;
    }
}
