package ru.trofimov.bankcards.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.trofimov.bankcards.service.BankCardServiceImpl;
import ru.trofimov.bankcards.service.impl.BankCardService;
import ru.trofimov.bankcards.web.dto.BankCardDto;
import ru.trofimov.bankcards.web.dto.validation.OnCreate;
import ru.trofimov.bankcards.web.dto.validation.OnUpdate;
import ru.trofimov.bankcards.web.mapper.CardMapper;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bankcard")
@Validated
public class BankCardController {

    private final BankCardService bankCardService;
    private final CardMapper cardMapper;
    private static final Logger logger = LoggerFactory.getLogger(BankCardServiceImpl.class);

    public BankCardController(BankCardService bankCardService, CardMapper cardMapper) {
        this.bankCardService = bankCardService;
        this.cardMapper = cardMapper;
    }

    /**
     * Создает новую банковскую карту.
     * @param bankCardDto DTO новой карты для создания.
     * @return DTO созданной карты.
     */
    @PostMapping("/create")
    public BankCardDto create(@Validated(OnCreate.class) @RequestBody BankCardDto bankCardDto) {
        logger.info("Execution: BankCardController.create({})", bankCardDto.getClass().getSimpleName());
        return cardMapper.toDto(bankCardService.addCard(cardMapper.toEntity(bankCardDto)));
    }

    /**
     * Получает информацию о карте по её идентификатору.
     * @param id Идентификатор карты.
     * @return DTO информации о карте.
     */
    @GetMapping("/{id}")
    public BankCardDto getById(@PathVariable Long id) {
        logger.info("Execution: BankCardController.getById({})", id);
        return cardMapper.toDto(bankCardService.getCardById(id));
    }

    /**
     * Получает список всех банковских карт.
     * @return Список DTO всех карт.
     */
    @GetMapping("/getAll")
    public List<BankCardDto> getAll() {
        logger.info("Execution: BankCardController.getAll()");
        return cardMapper.toDto(bankCardService.getAllCards());
    }

    /**
     * Обновляет информацию о карте.
     * @param bankCardDto DTO информации для обновления.
     * @return DTO обновлённой карты.
     */
    @PutMapping("/update")
    public BankCardDto update(@Validated(OnUpdate.class) @RequestBody BankCardDto bankCardDto) {
        logger.info("Execution: BankCardController.update({})", bankCardDto.getClass().getSimpleName());
        return cardMapper.toDto(bankCardService.updateCard(cardMapper.toEntity(bankCardDto)));
    }

    /**
     * Меняет статус карты.
     * @param status Новый статус карты.
     * @param id Идентификатор карты.
     * @return DTO карты с обновлённым статусом.
     */
    @PutMapping("/toggleStatus/{status}/{id}")
    public BankCardDto toggleStatus(@Validated(OnUpdate.class) @PathVariable String status, @PathVariable Long id) {
        logger.info("Execution: BankCardController.toggleStatus({}, {})", status, id);
        return cardMapper.toDto(bankCardService.toggleCardStatus(status, id));
    }

    /**
     * Удаляет карту по идентификатору.
     * @param id Идентификатор карты для удаления.
     * @return Сообщение об успешном удалении карты.
     */
    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        logger.info("Execution: BankCardController.deleteById({})", id);
        bankCardService.deleteCardById(id);
        return "Card is deleted.";
    }
}
