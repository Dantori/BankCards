package ru.trofimov.bankcards.web.mapper;

import org.mapstruct.Mapper;
import ru.trofimov.bankcards.domain.BankCard;
import ru.trofimov.bankcards.web.dto.BankCardDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardMapper {

    /**
     * Convert a BankCard entity to a BankCardDto data transfer object.
     *
     * @param bankCard the BankCard entity to convert
     * @return the corresponding BankCardDto data transfer object
     */
    BankCardDto toDto(BankCard bankCard);

    /**
     * Convert a list of BankCard entities to a list of BankCardDto data transfer objects.
     *
     * @param bankCards the list of BankCard entities to convert
     * @return a list containing the corresponding BankCardDto data transfer objects
     */
    List<BankCardDto> toDto(List<BankCard> bankCards);

    /**
     * Convert a BankCardDto data transfer object to a BankCard entity.
     *
     * @param bankCardDto the BankCardDto data transfer object to convert
     * @return the corresponding BankCard entity
     */
    BankCard toEntity(BankCardDto bankCardDto);
}
