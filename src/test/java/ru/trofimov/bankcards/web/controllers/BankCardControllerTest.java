package ru.trofimov.bankcards.web.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.trofimov.bankcards.domain.BankCard;
import ru.trofimov.bankcards.service.BankCardService;
import ru.trofimov.bankcards.web.dto.BankCardDto;
import ru.trofimov.bankcards.web.mapper.CardMapper;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BankCardControllerTest {

    @InjectMocks
    private BankCardController bankCardController;

    @Mock
    private BankCardService bankCardService;

    @Mock
    private CardMapper cardMapper;

    @Test
    void create_test() {
        BankCardDto testCardDto = new BankCardDto();
        testCardDto.setCardNumber("1234567890");
        BankCard testCard = new BankCard();

        when(cardMapper.toEntity(testCardDto)).thenReturn(testCard);
        when(bankCardService.addCard(testCard)).thenReturn(testCard);
        when(cardMapper.toDto(testCard)).thenReturn(testCardDto);

        BankCardDto createdCardDto = bankCardController.create(testCardDto);

        verify(cardMapper).toEntity(testCardDto);
        verify(bankCardService).addCard(testCard);
        verify(cardMapper).toDto(testCard);
        assertEquals(testCardDto, createdCardDto);
    }

    @Test
    void getById_test() {
        BankCardDto testCardDto = new BankCardDto();
        testCardDto.setId(1L);
        BankCard testCard = new BankCard();
        testCard.setId(1L);

        when(bankCardService.getCardById(1L)).thenReturn(testCard);
        when(cardMapper.toDto(testCard)).thenReturn(testCardDto);

        BankCardDto result = bankCardController.getById(1L);

        verify(cardMapper).toDto(testCard);
        verify(bankCardService).getCardById(1L);
        assertEquals(testCardDto, result);
    }
}