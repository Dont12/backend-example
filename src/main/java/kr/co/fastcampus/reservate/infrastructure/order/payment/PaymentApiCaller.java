package kr.co.fastcampus.reservate.infrastructure.order.payment;

import kr.co.fastcampus.reservate.domain.order.PayMethod.PayMethod;
import kr.co.fastcampus.reservate.domain.order.dto.request.PaymentDto;

public interface PaymentApiCaller {

    boolean support(PayMethod payMethod);

    void pay(PaymentDto dto);
}
