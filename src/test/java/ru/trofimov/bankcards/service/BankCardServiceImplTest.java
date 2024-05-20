package ru.trofimov.bankcards.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.trofimov.bankcards.domain.BankCard;
import ru.trofimov.bankcards.repository.BankCardRepository;
import ru.trofimov.bankcards.service.impl.BankCardServiceImpl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BankCardServiceImplTest {

    @InjectMocks
    private BankCardServiceImpl bankCardService;

    @Mock
    private BankCardRepository bankCardRepository;



    @Test
    void addCard_test() {
        BankCard bankCard = new BankCard(
                1L, "1111222233334444", "Иван", "Иванов", "Bank1", "credit",
                new Date(2024, Calendar.SEPTEMBER, 31), "123", "Visa", "Cashback rewards",
                new Date(2024, Calendar.JUNE, 31), "Active", 15000.0, 5000.0, 1000.0, "USD"
        );

        when(bankCardRepository.findByCardNumber(bankCard.getCardNumber())).thenReturn(Optional.empty());
        when(bankCardRepository.save(bankCard)).thenReturn(bankCard);

        BankCard addedCard = bankCardService.addCard(bankCard);

        verify(bankCardRepository).findByCardNumber(bankCard.getCardNumber());
        assertEquals(bankCard.getCardNumber(), addedCard.getCardNumber());
    }

    @Test
    void updateCard_test() {
        BankCard bankCard = new BankCard(
                1L, "1111222233334444", "Иван", "Иванов", "Bank1", "credit",
                new Date(2024, Calendar.SEPTEMBER, 31), "123", "Visa", "Cashback rewards",
                new Date(2024, Calendar.JUNE, 31), "Active", 15000.0, 5000.0, 1000.0, "USD"
        );

        when(bankCardRepository.findById(bankCard.getId())).thenReturn(Optional.of(bankCard));
        when(bankCardRepository.save(bankCard)).thenReturn(bankCard);

        BankCard updatedCard = bankCardService.updateCard(bankCard);

        verify(bankCardRepository).findById(1L);
        verify(bankCardRepository).save(bankCard);

        assertEquals(bankCard.getId(), updatedCard.getId());
    }

    @Test
    void updateCard_notFoundException_test() {
        BankCard bankCard = new BankCard(
                1L, "1111222233334444", "Иван", "Иванов", "Bank1", "credit",
                new Date(2024, Calendar.SEPTEMBER, 31), "123", "Visa", "Cashback rewards",
                new Date(2024, Calendar.JUNE, 31), "Active", 15000.0, 5000.0, 1000.0, "USD"
        );

        when(bankCardRepository.findById(bankCard.getId())).thenReturn(Optional.empty());
        Exception exception = assertThrows(Exception.class, () -> bankCardService.updateCard(bankCard));
        assertEquals("Card with id 1 not found in DB", exception.getMessage());
    }

    @Test
    void getAllCards_test() {
        BankCard bankCard1 = new BankCard(
                1L, "1111222233334444", "Иван", "Иванов", "Bank1", "credit",
                new Date(2024, Calendar.SEPTEMBER, 31), "123", "Visa", "Cashback rewards",
                new Date(2024, Calendar.JUNE, 31), "Active", 15000.0, 5000.0, 1000.0, "USD"
        );

        BankCard bankCard2 = new BankCard(
                2L, "5555666677778888", "Елена", "Петрова", "Bank2", "debit",
                new Date(2024, Calendar.MAY, 31), "456", "Mastercard", "Travel insurance",
                new Date(2024, Calendar.APRIL, 31), "Active", 3000.0, 0.0, 500.0, "EUR"
        );

        when(bankCardRepository.findAll()).thenReturn(List.of(bankCard1, bankCard2));

        List<BankCard> allCards = bankCardService.getAllCards();
        assertEquals(2, allCards.size());
        assertEquals(bankCard1, allCards.get(0));
        assertEquals(bankCard2, allCards.get(1));
    }

    @Test
    void getCardById_test() {
        BankCard bankCard = new BankCard(
                1L, "1111222233334444", "Иван", "Иванов", "Bank1", "credit",
                new Date(2024, Calendar.SEPTEMBER, 31), "123", "Visa", "Cashback rewards",
                new Date(2024, Calendar.SEPTEMBER, 31), "Active", 15000.0, 5000.0, 1000.0, "USD"
        );

        when(bankCardRepository.findById(1L)).thenReturn(Optional.of(bankCard));

        BankCard returnedCard = bankCardService.getCardById(1L);
        assertEquals(bankCard, returnedCard);

        assertThrows(RuntimeException.class, () -> bankCardService.getCardById(2L));
    }

    @Test
    void deleteCardById_test() {
        Long id = 1L;
        BankCard bankCard = new BankCard(
                1L, "1111222233334444", "Иван", "Иванов", "Bank1", "credit",
                new Date(2024, Calendar.SEPTEMBER, 31), "123", "Visa", "Cashback rewards",
                new Date(2024, Calendar.SEPTEMBER, 31), "Active", 15000.0, 5000.0, 1000.0, "USD"
        );
        when(bankCardRepository.findById(id)).thenReturn(Optional.of(bankCard));
        bankCardService.deleteCardById(id);
        Mockito.verify(bankCardRepository, Mockito.times(1)).deleteById(id);
    }
}
