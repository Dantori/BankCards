package ru.trofimov.bankcards.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.trofimov.bankcards.domain.BankCard;

import java.util.Optional;

@Repository
public interface BankCardRepository extends CrudRepository<BankCard, Long> {

    /**
     * Ищет карту банка по номеру карты.
     * @param cardNumber Номер карты.
     * @return Карта банка с соответствующим номером или пустое значение, если карта не найдена.
     */
    Optional<BankCard> findByCardNumber(String cardNumber);
}
