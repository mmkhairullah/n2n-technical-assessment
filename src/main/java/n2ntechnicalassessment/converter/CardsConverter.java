package n2ntechnicalassessment.converter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import n2ntechnicalassessment.repository.CardsRepository;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CardsConverter {

    private final CardsRepository cardsRepository;
}
