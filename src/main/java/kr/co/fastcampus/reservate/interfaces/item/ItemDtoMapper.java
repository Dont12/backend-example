package kr.co.fastcampus.reservate.interfaces.item;

import kr.co.fastcampus.reservate.domain.item.dto.request.RegisterItemDto;
import kr.co.fastcampus.reservate.domain.item.dto.response.ItemInfoDto;
import kr.co.fastcampus.reservate.interfaces.item.dto.request.RegisterItemRequest;
import kr.co.fastcampus.reservate.interfaces.item.dto.response.ItemInfoResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface ItemDtoMapper {

    RegisterItemDto of(RegisterItemRequest request);

    ItemInfoResponse of(ItemInfoDto dto);
}
