package kr.co.fastcampus.reservate.domain.order.dto.request;

import java.util.List;
import kr.co.fastcampus.reservate.domain.order.Order;

public record RegisterOrderDto(
        Long userId,
        String payMethod,
        List<RegisterOrderItemDto> orderItems
) {

    public Order toEntity() {
        return Order.builder()
                .userId(userId)
                .payMethod(payMethod)
                .build();
    }
}
