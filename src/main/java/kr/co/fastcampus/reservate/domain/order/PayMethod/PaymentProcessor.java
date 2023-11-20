package kr.co.fastcampus.reservate.domain.order.PayMethod;

import kr.co.fastcampus.reservate.domain.order.Order;
import kr.co.fastcampus.reservate.domain.order.dto.request.PaymentDto;

public interface PaymentProcessor {
    void pay(Order order, PaymentDto dto);
}
