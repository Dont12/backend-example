package kr.co.fastcampus.reservate.interfaces.order.dto.request;

import jakarta.validation.constraints.NotNull;
import kr.co.fastcampus.reservate.domain.order.PayMethod.PayMethod;

public record PaymentRequest(
        @NotNull Long orderId,
        @NotNull Long price,
        @NotNull PayMethod payMethod
) {

}
