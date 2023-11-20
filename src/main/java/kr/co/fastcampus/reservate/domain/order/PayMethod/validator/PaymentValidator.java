package kr.co.fastcampus.reservate.domain.order.PayMethod.validator;

import kr.co.fastcampus.reservate.domain.order.Order;
import kr.co.fastcampus.reservate.domain.order.dto.request.PaymentDto;

public interface PaymentValidator {
    void validate(Order order, PaymentDto dto);
}
