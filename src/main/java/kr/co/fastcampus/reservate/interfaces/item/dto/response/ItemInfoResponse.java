package kr.co.fastcampus.reservate.interfaces.item.dto.response;

import kr.co.fastcampus.reservate.domain.item.Item;

public record ItemInfoResponse(
        String name,
        Long price,
        Item.Status status
) {

}
