package ru.trofimov.bankcards.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.trofimov.bankcards.domain.BankCard;
import ru.trofimov.bankcards.repository.BankCardRepository;
import ru.trofimov.bankcards.service.BankCardService;

import java.util.List;
import java.util.Optional;

@Service
public class BankCardServiceImpl implements BankCardService {

    private final BankCardRepository bankCardRepository;
    private static final Logger logger = LoggerFactory.getLogger(BankCardServiceImpl.class);

    @Autowired
    public BankCardServiceImpl(BankCardRepository bankCardRepository) {
        this.bankCardRepository = bankCardRepository;
    }

    @Override
    public BankCard getCardById(Long id) {
        logger.info("Execution: BankCardServiceImpl.getCardById({})", id);
        return bankCardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Card with id " + id + " not found in DB"));
    }

    @Override
    public List<BankCard> getAllCards() {
        logger.info("Execution: BankCardServiceImpl.getAllCards()");
        return (List<BankCard>) bankCardRepository.findAll();
    }

    @Override
    public BankCard addCard(BankCard bankCard) {
        logger.info("Execution: BankCardServiceImpl.addCard({})", bankCard.getClass().getSimpleName());
        Optional<BankCard> cardFromDb = bankCardRepository.findByCardNumber(bankCard.getCardNumber());
        if (cardFromDb.isPresent()) {
            throw new RuntimeException("this card already exists in the database.");
        } else {
            bankCardRepository.save(bankCard);
            return bankCardRepository.findByCardNumber(bankCard.getCardNumber())
                    .orElseThrow(() -> new RuntimeException("Card not found in DB"));
        }
    }

    @Override
    public BankCard updateCard(BankCard bankCard) {
        logger.info("Execution: BankCardServiceImpl.updateCard({})", bankCard.getClass().getSimpleName());
        Optional<BankCard> cardFromDb = bankCardRepository.findById(bankCard.getId());
        if (cardFromDb.isPresent()) {
            bankCardRepository.save(bankCard);
            return bankCard;
        } else {
            throw new RuntimeException("Card with id " + bankCard.getId() + " not found in DB");
        }
    }

    @Override
    public BankCard toggleCardStatus(String status, Long id) {
        logger.info("Execution: BankCardServiceImpl.toggleCardStatus({}, {})", status, id);
        Optional<BankCard> cardFromDb = bankCardRepository.findById(id);
        if (cardFromDb.isPresent()) {
            cardFromDb.get().setStatus(status);
            return cardFromDb.get();
        } else {
            throw new RuntimeException("Card with id " + id + " not found in DB");
        }
    }

    @Override
    public void deleteCardById(Long id) {
        logger.info("Execution: BankCardServiceImpl.deleteCardById({})", id);
        Optional<BankCard> cardFromDb = bankCardRepository.findById(id);
        if (cardFromDb.isPresent()) {
            bankCardRepository.deleteById(id);
        } else {
            throw new RuntimeException("Card with id " + id + " not found in DB");
        }
    }
}