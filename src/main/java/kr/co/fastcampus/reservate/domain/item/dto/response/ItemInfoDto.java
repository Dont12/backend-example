package kr.co.fastcampus.reservate.domain.item.dto.response;

import kr.co.fastcampus.reservate.domain.item.Item;
import lombok.Builder;

@Builder
public record ItemInfoDto(
        String name,
        Long price,
        Item.Status status
) {

    public static ItemInfoDto from(Item item) {
        return ItemInfoDto.builder()
                .name(item.getName())
                .price(item.getPrice())
                .status(item.getStatus())
                .build();
    }
}
