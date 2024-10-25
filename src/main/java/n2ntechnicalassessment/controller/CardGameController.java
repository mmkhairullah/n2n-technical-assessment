package n2ntechnicalassessment.controller;

import lombok.RequiredArgsConstructor;
import n2ntechnicalassessment.dto.AllPlayerRequestDto;
import n2ntechnicalassessment.dto.AllPlayerResponseDto;
import n2ntechnicalassessment.dto.CardsDto;
import n2ntechnicalassessment.dto.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import n2ntechnicalassessment.service.CardGameService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@Validated
@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/cardgame")
public class CardGameController extends BaseController {

    private final CardGameService cardGameService;

    @GetMapping("/cards/all")
    public ResponseDTO<List<CardsDto>> getAllCardsList() {
        return createResponse(HttpStatus.OK, cardGameService.getAllCardsList());
    }

    @PostMapping("/{onePlayerNumber}")
    public ResponseDTO<List<CardsDto>> getOnePlayerCard(@PathVariable int onePlayerNumber) {
        return createResponse(HttpStatus.OK, cardGameService.getPlayerCard(onePlayerNumber));
    }

    @PostMapping("/allPlayers")
    public ResponseDTO<List<AllPlayerResponseDto>> getAllPlayerCard(@RequestBody List<AllPlayerRequestDto> allPlayers) {
        return createResponse(HttpStatus.OK, cardGameService.getAllPlayerCardAndWinner(allPlayers));
    }
}
