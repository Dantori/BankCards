package ru.trofimov.bankcards.web.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.trofimov.bankcards.service.impl.BankCardServiceImpl;
import ru.trofimov.bankcards.service.BankCardService;
import ru.trofimov.bankcards.web.dto.BankCardDto;
import ru.trofimov.bankcards.web.dto.validation.OnCreate;
import ru.trofimov.bankcards.web.dto.validation.OnUpdate;
import ru.trofimov.bankcards.web.mapper.CardMapper;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bankcard")
@Tag(name = "Bank card controller", description = "Card API")
@Validated
public class BankCardController {

    private final BankCardService bankCardService;
    private final CardMapper cardMapper;
    private static final Logger logger = LoggerFactory.getLogger(BankCardServiceImpl.class);

    @Autowired
    public BankCardController(BankCardService bankCardService, CardMapper cardMapper) {
        this.bankCardService = bankCardService;
        this.cardMapper = cardMapper;
    }

    /**
     * Create a new bank card.
     *
     * @param bankCardDto the bank card data to create
     * @return the created bank card data
     */
    @PostMapping("/create")
    @Operation(summary = "Add a new card.")
    public BankCardDto create(@Validated(OnCreate.class) @RequestBody BankCardDto bankCardDto) {
        logger.info("Execution: BankCardController.create({})", bankCardDto.getClass().getSimpleName());
        return cardMapper.toDto(bankCardService.addCard(cardMapper.toEntity(bankCardDto)));
    }

    /**
     * Retrieve a bank card by its ID.
     *
     * @param id the ID of the bank card to retrieve
     * @return the bank card data associated with the given ID
     */
    @GetMapping("/{id}")
    @Operation(summary = "Get card by ID.")
    public BankCardDto getById(@PathVariable Long id) {
        logger.info("Execution: BankCardController.getById({})", id);
        return cardMapper.toDto(bankCardService.getCardById(id));
    }

    /**
     * Retrieve a list of all bank cards.
     *
     * @return a list containing all bank card data
     */
    @GetMapping("/getAll")
    @Operation(summary = "Get all cards.")
    public List<BankCardDto> getAll() {
        logger.info("Execution: BankCardController.getAll()");
        return cardMapper.toDto(bankCardService.getAllCards());
    }

    /**
     * Update an existing bank card with new information.
     *
     * @param bankCardDto the updated bank card information
     * @return the updated bank card data
     */
    @PutMapping("/update")
    @Operation(summary = "Update card.")
    public BankCardDto update(@Validated(OnUpdate.class) @RequestBody BankCardDto bankCardDto) {
        logger.info("Execution: BankCardController.update({})", bankCardDto.getClass().getSimpleName());
        return cardMapper.toDto(bankCardService.updateCard(cardMapper.toEntity(bankCardDto)));
    }

    /**
     * Toggle the status of a bank card.
     *
     * @param status the new status to set for the card
     * @param id     the ID of the bank card to update
     * @return the updated bank card data with the new status
     */
    @PutMapping("/toggleStatus/{status}/{id}")
    @Operation(summary = "Blocked card by id.")
    public BankCardDto toggleStatus(@Validated(OnUpdate.class) @PathVariable String status, @PathVariable Long id) {
        logger.info("Execution: BankCardController.toggleStatus({}, {})", status, id);
        return cardMapper.toDto(bankCardService.toggleCardStatus(status, id));
    }

    /**
     * Delete a bank card by its ID.
     *
     * @param id the ID of the bank card to delete
     * @return a message indicating the deletion status
     */
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete card by id.")
    public String deleteById(@PathVariable Long id) {
        logger.info("Execution: BankCardController.deleteById({})", id);
        bankCardService.deleteCardById(id);
        return "Card is deleted.";
    }
}
