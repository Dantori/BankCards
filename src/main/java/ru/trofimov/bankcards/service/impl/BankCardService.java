package ru.trofimov.bankcards.service.impl;

import ru.trofimov.bankcards.domain.BankCard;

import java.util.List;

public interface BankCardService {

    /**
     * Получает карту по идентификатору.
     * @param id Уникальный идентификатор карты.
     * @return Карта банка.
     */
    BankCard getCardById(Long id);

    /**
     * Получает все карты.
     * @return Список всех карт банка.
     */
    List<BankCard> getAllCards();

    /**
     * Добавляет карту.
     * @param bankCard Добавляемая карта банка.
     * @return Добавленная карта банка.
     */
    BankCard addCard(BankCard bankCard);

    /**
     * Обновляет информацию о карте.
     * @param bankCard Информация о карте для обновления.
     * @return Обновленная информация о карте банка.
     */
    BankCard updateCard(BankCard bankCard);

    /**
     * Меняет статус карты.
     * @param status Новый статус карты.
     * @param id Уникальный идентификатор карты.
     * @return Карта банка с обновленным статусом.
     */
    BankCard toggleCardStatus(String status, Long id);

    /**
     * Удаляет карту по идентификатору.
     * @param id Уникальный идентификатор карты для удаления.
     */
    void deleteCardById(Long id);
}
