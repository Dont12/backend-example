package kr.co.fastcampus.reservate.interfaces.order.dto.response;

import java.time.LocalDateTime;
import java.util.List;
import kr.co.fastcampus.reservate.domain.order.Order.Status;

public record OrderInfoResponse(
        Long id,
        Long userId,
        String payMethod,
        Long totalPrice,
        LocalDateTime orderedAt,
        Status status,
        List<OrderItemInfoResponse> orderItems
) {

}
