package kr.co.fastcampus.reservate.domain.order.dto.response;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import kr.co.fastcampus.reservate.domain.order.Order;
import kr.co.fastcampus.reservate.domain.order.Order.Status;
import kr.co.fastcampus.reservate.domain.order.OrderItem;
import lombok.Builder;

@Builder
public record OrderInfoDto(
        Long id,
        Long userId,
        String payMethod,
        Long totalPrice,
        LocalDateTime orderedAt,
        Status status,
        List<OrderItemInfoDto> orderItems
) {

    public static OrderInfoDto from(Order order, List<OrderItem> orderItems) {
        return OrderInfoDto.builder()
                .id(order.getId())
                .userId(order.getUserId())
                .payMethod(order.getPayMethod())
                .totalPrice(order.calculateTotalAmount())
                .orderedAt(order.getOrderedAt())
                .status(order.getStatus())
                .orderItems(getOrderItemInfo(orderItems))
                .build();
    }

    private static List<OrderItemInfoDto> getOrderItemInfo(List<OrderItem> orderItems) {
        return orderItems.stream()
                .map(OrderItemInfoDto::from)
                .collect(Collectors.toList());
    }
}
