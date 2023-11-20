package kr.co.fastcampus.reservate.infrastructure.order.payment;

import static kr.co.fastcampus.reservate.common.response.ErrorCode.COMMON_INVALID_PARAMETER;

import java.util.List;
import kr.co.fastcampus.reservate.common.exception.CustomException;
import kr.co.fastcampus.reservate.domain.order.Order;
import kr.co.fastcampus.reservate.domain.order.PayMethod.PaymentProcessor;
import kr.co.fastcampus.reservate.domain.order.PayMethod.validator.PaymentValidator;
import kr.co.fastcampus.reservate.domain.order.dto.request.PaymentDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class PaymentProcessorImpl implements PaymentProcessor {
    private final List<PaymentValidator> paymentValidatorList;
    private final List<PaymentApiCaller> paymentApiCallerList;

    @Override
    public void pay(Order order, PaymentDto dto) {
        paymentValidatorList.forEach(paymentValidator -> paymentValidator.validate(order,
                dto));
        PaymentApiCaller payApiCaller = routingApiCaller(dto);
        payApiCaller.pay(dto);
    }

    private PaymentApiCaller routingApiCaller(PaymentDto dto) {
        return paymentApiCallerList.stream()
                .filter(paymentApiCaller -> paymentApiCaller.support(dto.payMethod()))
                .findFirst()
                .orElseThrow(() -> new CustomException(COMMON_INVALID_PARAMETER));
    }
}
