package ru.trofimov.bankcards.service;

import org.springframework.transaction.annotation.Transactional;
import ru.trofimov.bankcards.domain.BankCard;

import java.util.List;

public interface BankCardService {


    /**
     * Retrieve a bank card by its ID.
     *
     * @param id the ID of the bank card to retrieve
     * @return the bank card associated with the given ID
     */
    BankCard getCardById(Long id);

    /**
     * Retrieve a list of all bank cards.
     *
     * @return a list containing all bank cards
     */
    List<BankCard> getAllCards();

    /**
     * Add a new bank card to the repository.
     *
     * @param bankCard the bank card to add
     * @return the added bank card
     */
    BankCard addCard(BankCard bankCard);

    /**
     * Update an existing bank card with new information.
     *
     * @param bankCard the updated bank card information
     * @return the updated bank card
     */
    BankCard updateCard(BankCard bankCard);

    /**
     * Toggle the status of a bank card.
     *
     * @param status the new status to set for the card
     * @param id     the ID of the bank card to update
     * @return the updated bank card with the new status
     */
    BankCard toggleCardStatus(String status, Long id);

    /**
     * Delete a bank card by its ID.
     *
     * @param id the ID of the bank card to delete
     */
    void deleteCardById(Long id);
}
