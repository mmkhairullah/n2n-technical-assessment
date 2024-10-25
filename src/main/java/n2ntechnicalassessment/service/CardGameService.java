package n2ntechnicalassessment.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import n2ntechnicalassessment.dto.AllPlayerRequestDto;
import n2ntechnicalassessment.dto.AllPlayerResponseDto;
import n2ntechnicalassessment.dto.CardsDto;
import n2ntechnicalassessment.dto.PlayerNumberDto;
import n2ntechnicalassessment.entity.Cards;
import n2ntechnicalassessment.repository.CardsRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CardGameService {

    private final CardsRepository cardsRepository;

    public List<CardsDto> getAllCardsList() {
        List<CardsDto> cardsDtoList = new ArrayList<>();
        List<Cards> allCardsList = cardsRepository.findAll();
        allCardsList.forEach((c) -> {
            CardsDto dto = new CardsDto(0, c.getCard());
            cardsDtoList.add(dto);
        });
        return cardsDtoList ;
    }

    public List<CardsDto> getPlayerCard(int onePlayerNumber) {

        //total only 4 player
        if (onePlayerNumber > 0 && onePlayerNumber <= 4) {
            List<Cards> cardList = cardsRepository.getPlayerCardsBasedOnNumber();
            List<CardsDto> cardsDtoList = new ArrayList<>();
            cardList.forEach((c) -> {
                CardsDto dto = new CardsDto();
                dto.setPlayerNumber(onePlayerNumber);
                dto.setCardId(c.getCard());
                log.info("playerCard : " + c.getCard());
                cardsDtoList.add(dto);
            });
            return cardsDtoList;
        } else {
            return new ArrayList<>();
        }
    }

    public List<AllPlayerResponseDto> getAllPlayerCardAndWinner(List<AllPlayerRequestDto> requests) {
        List<AllPlayerResponseDto> responses = new ArrayList<>();

        Map<Integer, List<CardsDto>> playerCardsMap = new HashMap<>();

        for (AllPlayerRequestDto playerRequest : requests) {
            for (PlayerNumberDto playerCard : playerRequest.getAllPlayersCards()) {
                int playerNumber = playerCard.getPlayerNumber();
                List<CardsDto> playerCards = getPlayerCard(playerNumber);
                playerCardsMap.put(playerNumber, playerCards);
            }
        }

        for (Map.Entry<Integer, List<CardsDto>> entry : playerCardsMap.entrySet()) {
            AllPlayerResponseDto responseDto = new AllPlayerResponseDto();
            responseDto.setAllPlayersCards(entry.getValue());
            responses.add(responseDto);
        }

        List<CardsDto> winningCards = winnerCondition(responses);

        if (!responses.isEmpty()) {
            responses.get(responses.size() - 1).setWinnerPlayer(winningCards);
        }

        return responses;
    }

    public List<CardsDto> winnerCondition(List<AllPlayerResponseDto> allPlayersCardResults) {
        Map<Integer, List<CardsDto>> playerCardsMap = new HashMap<>();

        allPlayersCardResults.forEach(playerResponse -> {
            List<CardsDto> playerCards = playerResponse.getAllPlayersCards();
            if (playerCards != null) {
                playerCards.forEach(playerCard ->
                        playerCardsMap.computeIfAbsent(playerCard.getPlayerNumber(), k -> new ArrayList<>()).add(playerCard)
                );
            }
        });

        Map<Integer, Integer> playerWinningCounts = new HashMap<>();
        Map<Integer, String> playerHighestCard = new HashMap<>();

        for (Map.Entry<Integer, List<CardsDto>> entry : playerCardsMap.entrySet()) {
            int playerNumber = entry.getKey();
            log.info("playerNumber : " + playerNumber);
            List<CardsDto> cards = entry.getValue();

            if (cards.isEmpty()) continue;

            Map<String, Long> cardCount = new HashMap<>();

            for (CardsDto card : cards) {
                String alphanumericPart = getAlphanumericPart(card.getCardId());
                log.info("alphanumericPart : " + alphanumericPart);
                cardCount.put(alphanumericPart, cardCount.getOrDefault(alphanumericPart, 0L) + 1);
            }

            long maxCount = cardCount.values().stream().max(Long::compare).orElse(0L);
            log.info("maxCount = : " + maxCount);
            playerWinningCounts.put(playerNumber, (int) maxCount);

            List<String> highestCards = cardCount.entrySet().stream()
                    .filter(e -> e.getValue() == maxCount)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());

            String bestCard = compareMultipleCards(highestCards);
            log.info("bestCard = : " + bestCard);
            playerHighestCard.put(playerNumber, bestCard);
        }

        int winningPlayer = -1;
        int maxWinningCount = -1;

        for (Map.Entry<Integer, Integer> entry : playerWinningCounts.entrySet()) {
            int count = entry.getValue();
            log.info("count = : " + count);

            if (count > maxWinningCount ||
                    (count == maxWinningCount &&
                            (winningPlayer == -1 || compareHighestCard(playerHighestCard.get(entry.getKey()),
                                    playerHighestCard.get(winningPlayer)) > 0))) {
                maxWinningCount = count;
                winningPlayer = entry.getKey();
                log.info("winningPlayer = : " + winningPlayer);
                log.info("maxWinningCount = : " + maxWinningCount);
            }
        }

        return winningPlayer == -1 ? new ArrayList<>() : playerCardsMap.getOrDefault(winningPlayer, new ArrayList<>());
    }

    private String getAlphanumericPart(String cardId) {
        return Optional.ofNullable(cardId)
                .map(id -> id.replaceAll("[^A-Za-z]", ""))
                .orElse("");
    }

    private int compareHighestCard(String card1Id, String card2Id) {
        if (card1Id == null || card1Id.isEmpty()) return -1;
        if (card2Id == null || card2Id.isEmpty()) return 1;

        String alphaPart1 = getAlphanumericPart(card1Id);
        String alphaPart2 = getAlphanumericPart(card2Id);

        int alphaComparison = alphaPart1.compareTo(alphaPart2);

        if (alphaComparison != 0) return alphaComparison;

        char symbol1 = card1Id.charAt(card1Id.length() - 1);
        char symbol2 = card2Id.charAt(card2Id.length() - 1);

        return getSymbolValue(symbol1) - getSymbolValue(symbol2);
    }

    private String compareMultipleCards(List<String> cardIds) {
        return cardIds.stream().min(this::compareHighestCard)
                .orElse("");
    }

    private int getSymbolValue(char symbol) {
        log.info("symbol : " + symbol);

        switch (symbol) {
            case '*': return 4;
            case '^': return 3;
            case '#': return 2;
            case '@': return 1;
            default: return 0;
        }
    }

}
