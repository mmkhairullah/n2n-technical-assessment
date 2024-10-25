package n2ntechnicalassessment.controller;

import lombok.RequiredArgsConstructor;
import n2ntechnicalassessment.dto.CardsDto;
import n2ntechnicalassessment.dto.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import n2ntechnicalassessment.service.CardGameService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseDTO<List<CardsDto>> getAllCardsInDeck() {
        return createResponse(HttpStatus.OK, cardGameService.getAllCardsList());
    }

//    @GetMapping("/phoneModel/{phoneModels}/{attributes}")
//    public ResponseDTO<List<String>> getAllPhoneModelandAttributes(@PathVariable String phoneModels, @PathVariable String attributes) {
//        return createResponse(HttpStatus.OK, bookStoreService.getAllPhoneModelandAttributes(phoneModels, attributes));
//    }
//
//    @PostMapping("/{customerIdNumber}")
//    public ResponseDTO<List<CustomerResDTO>> getCustomerDetails(@PathVariable String customerIdNumber) {
//        return createResponse(HttpStatus.OK, bookStoreService.getCustomerDetails(customerIdNumber));
//    }

}
