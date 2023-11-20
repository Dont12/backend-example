package kr.co.fastcampus.reservate.domain.order.dto.request;

import kr.co.fastcampus.reservate.domain.order.PayMethod.PayMethod;

public record PaymentDto(
        Long orderId,
        Long price,
        PayMethod payMethod
) {

}
