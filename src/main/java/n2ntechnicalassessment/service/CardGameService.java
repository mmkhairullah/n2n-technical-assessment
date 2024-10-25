package n2ntechnicalassessment.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import n2ntechnicalassessment.converter.CardsConverter;
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
    private final CardsConverter cardsConverter;

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
                cardsDtoList.add(dto);
            });
            return cardsDtoList;
        } else {
            return new ArrayList<>();
        }
    }

    public List<AllPlayerResponseDto> getAllPlayerCardAndWinner(List<AllPlayerRequestDto> requests) {
        List<AllPlayerResponseDto> responses = new ArrayList<>();

        // Step 1: Collect player cards
        Map<Integer, List<CardsDto>> playerCardsMap = new HashMap<>();

        for (AllPlayerRequestDto playerRequest : requests) {
            for (PlayerNumberDto playerCard : playerRequest.getAllPlayersCards()) {
                int playerNumber = playerCard.getPlayerNumber();
                List<CardsDto> playerCards = getPlayerCard(playerNumber);
                playerCardsMap.put(playerNumber, playerCards);
            }
        }

        // Step 2: Create response DTOs
        for (Map.Entry<Integer, List<CardsDto>> entry : playerCardsMap.entrySet()) {
            AllPlayerResponseDto responseDto = new AllPlayerResponseDto();
            responseDto.setAllPlayersCards(entry.getValue());
            responses.add(responseDto);
        }

        // Step 3: Determine winners
        List<CardsDto> winningCards = winnerCondition(responses);

        // Set winner cards in the last response DTO
        if (!responses.isEmpty()) {
            responses.get(responses.size() - 1).setWinnerPlayer(winningCards);
        }

        return responses;
    }

    public List<CardsDto> winnerCondition(List<AllPlayerResponseDto> allPlayersCardResults) {
        Map<Integer, List<CardsDto>> playerCardsMap = new HashMap<>();

        // Organize cards by player
        allPlayersCardResults.forEach(playerResponse -> {
            List<CardsDto> playerCards = playerResponse.getAllPlayersCards();
            if (playerCards != null) { // Check for null
                playerCards.forEach(playerCard ->
                        playerCardsMap.computeIfAbsent(playerCard.getPlayerNumber(), k -> new ArrayList<>()).add(playerCard)
                );
            }
        });

        Map<Integer, Integer> playerWinningCounts = new HashMap<>();
        Map<Integer, String> playerHighestCard = new HashMap<>();

        // Count winning cards and determine highest card
        for (Map.Entry<Integer, List<CardsDto>> entry : playerCardsMap.entrySet()) {
            int playerNumber = entry.getKey();
            List<CardsDto> cards = entry.getValue();

            if (cards.isEmpty()) continue; // Skip players with no cards

            // Count occurrences of each alphanumeric part of card IDs
            Map<String, Long> cardCount = new HashMap<>();

            // Iterate through each card and count occurrences of alphanumeric parts
            for (CardsDto card : cards) {
                String alphanumericPart = getAlphanumericPart(card.getCardId());
                cardCount.put(alphanumericPart, cardCount.getOrDefault(alphanumericPart, 0L) + 1);
            }

            long maxCount = cardCount.values().stream().max(Long::compare).orElse(0L);
            playerWinningCounts.put(playerNumber, (int) maxCount);

            // Determine the highest cards based on count
            List<String> highestCards = cardCount.entrySet().stream()
                    .filter(e -> e.getValue() == maxCount)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());

            // Use compareMultipleCards to find the best among the highest cards
            String bestCard = compareMultipleCards(highestCards);

            playerHighestCard.put(playerNumber, bestCard);
        }

        // Determine overall winner
        int winningPlayer = -1;
        int maxWinningCount = -1;

        for (Map.Entry<Integer, Integer> entry : playerWinningCounts.entrySet()) {
            int count = entry.getValue();

            if (count > maxWinningCount ||
                    (count == maxWinningCount &&
                            (winningPlayer == -1 || compareCards(playerHighestCard.get(entry.getKey()),
                                    playerHighestCard.get(winningPlayer)) > 0))) {
                maxWinningCount = count;
                winningPlayer = entry.getKey();
            }
        }

        // Return the winning player's cards or an empty list if no winner
        return winningPlayer == -1 ? new ArrayList<>() : playerCardsMap.getOrDefault(winningPlayer, new ArrayList<>());
    }

    private String getAlphanumericPart(String cardId) {
        return Optional.ofNullable(cardId)
                .map(id -> id.replaceAll("[^A-Za-z]", ""))
                .orElse("");
    }

    private int compareCards(String card1Id, String card2Id) {
        if (card1Id == null || card1Id.isEmpty()) return -1; // Treat empty as lesser
        if (card2Id == null || card2Id.isEmpty()) return 1;  // Treat empty as lesser

        String alphaPart1 = getAlphanumericPart(card1Id);
        String alphaPart2 = getAlphanumericPart(card2Id);

        int alphaComparison = alphaPart1.compareTo(alphaPart2);

        if (alphaComparison != 0) return alphaComparison;

        char symbol1 = card1Id.charAt(card1Id.length() - 1);
        char symbol2 = card2Id.charAt(card2Id.length() - 1);

        return getSymbolValue(symbol1) - getSymbolValue(symbol2);
    }

    private String compareMultipleCards(List<String> cardIds) {
        // Sort the card IDs using the existing compareCards method
        // Use the existing compareCards method for comparison
        return cardIds.stream().min(this::compareCards) // Get the best card (first in sorted order)
                .orElse(""); // Return empty if no cards are present
    }

    private int getSymbolValue(char symbol) {
        switch (symbol) {
            case '*': return 4;
            case '^': return 3;
            case '#': return 2;
            case '@': return 1;
            default: return 0; // Unknown symbols treated as lowest value
        }
    }

}
