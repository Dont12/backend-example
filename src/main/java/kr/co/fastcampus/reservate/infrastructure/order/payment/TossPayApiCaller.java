package kr.co.fastcampus.reservate.infrastructure.order.payment;

import kr.co.fastcampus.reservate.domain.order.PayMethod.PayMethod;
import kr.co.fastcampus.reservate.domain.order.dto.request.PaymentDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class TossPayApiCaller implements PaymentApiCaller {

    @Override
    public boolean support(PayMethod payMethod) {
        return PayMethod.TOSS_PAY == payMethod;
    }

    @Override
    public void pay(PaymentDto dto) {
        System.out.println("Toss 결제!!");
    }
}
