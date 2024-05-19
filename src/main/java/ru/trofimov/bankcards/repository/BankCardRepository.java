package ru.trofimov.bankcards.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.trofimov.bankcards.domain.BankCard;

import java.util.Optional;

@Repository
public interface BankCardRepository extends CrudRepository<BankCard, Long> {

    /**
     * Retrieve a bank card by its card number.
     *
     * @param cardNumber the card number to search for
     * @return the optional bank card found by the card number
     */
    Optional<BankCard> findByCardNumber(String cardNumber);
}
