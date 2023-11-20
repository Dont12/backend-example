package kr.co.fastcampus.reservate.domain.order.dto.response;

import kr.co.fastcampus.reservate.domain.order.OrderItem;
import lombok.Builder;

@Builder
public record OrderItemInfoDto(
        Long itemId,
        String itemName,
        Long itemPrice
) {

    public static OrderItemInfoDto from(OrderItem orderItem) {
        return OrderItemInfoDto.builder()
                .itemId(orderItem.getItemId())
                .itemName(orderItem.getItemName())
                .itemPrice(orderItem.getItemPrice())
                .build();
    }
}
