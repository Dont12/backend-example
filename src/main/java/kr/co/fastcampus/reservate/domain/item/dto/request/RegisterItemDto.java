package kr.co.fastcampus.reservate.domain.item.dto.request;

import kr.co.fastcampus.reservate.domain.item.Item;

public record RegisterItemDto(
        String name,
        Long price
) {

    public Item toEntity() {
        return Item.builder()
                .name(name)
                .price(price)
                .build();
    }
}
