package kr.co.fastcampus.reservate.domain.order.dto.request;

import kr.co.fastcampus.reservate.domain.item.Item;
import kr.co.fastcampus.reservate.domain.order.Order;
import kr.co.fastcampus.reservate.domain.order.OrderItem;

public record RegisterOrderItemDto(
        Long itemId,
        String itemName,
        Long itemPrice
) {

    public OrderItem toEntity(Order order, Item item) {
        return OrderItem.builder()
                .order(order)
                .userId(order.getUserId())
                .itemId(item.getId())
                .itemName(itemName)
                .itemPrice(itemPrice)
                .build();
    }
}
