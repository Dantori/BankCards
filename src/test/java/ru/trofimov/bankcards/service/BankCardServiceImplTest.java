package ru.trofimov.bankcards.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.trofimov.bankcards.domain.BankCard;
import ru.trofimov.bankcards.repository.BankCardRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BankCardServiceImplTest {

    @InjectMocks
    private BankCardServiceImpl bankCardService;

    @Mock
    private BankCardRepository bankCardRepository;

    @Test
    void getAllCards_test() {
        BankCard bankCard1 = new BankCard(
                1L, "1111222233334444", "Иван", "Иванов", "Bank1", "credit",
                LocalDateTime.of(2025, 12, 31, 23, 59), "123", "Visa", "Cashback rewards",
                LocalDateTime.of(2022, 5, 14, 12, 0), "Active", 15000.0, 5000.0, 1000.0, "USD"
        );

        BankCard bankCard2 = new BankCard(
                2L, "5555666677778888", "Елена", "Петрова", "Bank2", "debit",
                LocalDateTime.of(2026, 6, 30, 23, 59), "456", "Mastercard", "Travel insurance",
                LocalDateTime.of(2023, 3, 8, 10, 30), "Active", 3000.0, 0.0, 500.0, "EUR"
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
                LocalDateTime.of(2025, 12, 31, 23, 59), "123", "Visa", "Cashback rewards",
                LocalDateTime.of(2022, 5, 14, 12, 0), "Active", 15000.0, 5000.0, 1000.0, "USD"
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
                LocalDateTime.of(2025, 12, 31, 23, 59), "123", "Visa", "Cashback rewards",
                LocalDateTime.of(2022, 5, 14, 12, 0), "Active", 15000.0, 5000.0, 1000.0, "USD"
        );
        when(bankCardRepository.findById(id)).thenReturn(Optional.of(bankCard));
        bankCardService.deleteCardById(id);
        Mockito.verify(bankCardRepository, Mockito.times(1)).deleteById(id);
    }
}
