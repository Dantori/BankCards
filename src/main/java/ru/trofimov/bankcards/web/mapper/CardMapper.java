package ru.trofimov.bankcards.web.mapper;

import org.mapstruct.Mapper;
import ru.trofimov.bankcards.domain.BankCard;
import ru.trofimov.bankcards.web.dto.BankCardDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardMapper {

    /**
     * Преобразует объект BankCard в BankCardDto.
     * @param bankCard Карта банка для преобразования.
     * @return DTO представление карты банка.
     */
    BankCardDto toDto(BankCard bankCard);

    /**
     * Преобразует список объектов BankCard в список объектов BankCardDto.
     * @param bankCards Список карт банка для преобразования.
     * @return Список DTO представлений карт банка.
     */
    List<BankCardDto> toDto(List<BankCard> bankCards);

    /**
     * Преобразует объект BankCardDto в BankCard.
     * @param bankCardDto DTO представление карты банка для преобразования.
     * @return Карта банка.
     */
    BankCard toEntity(BankCardDto bankCardDto);
}
