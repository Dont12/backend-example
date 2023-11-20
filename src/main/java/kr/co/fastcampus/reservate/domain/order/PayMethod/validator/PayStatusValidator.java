package kr.co.fastcampus.reservate.domain.order.PayMethod.validator;

import static kr.co.fastcampus.reservate.common.response.ErrorCode.COMMON_INVALID_PARAMETER;

import kr.co.fastcampus.reservate.common.exception.CustomException;
import kr.co.fastcampus.reservate.domain.order.Order;
import kr.co.fastcampus.reservate.domain.order.dto.request.PaymentDto;
import org.springframework.stereotype.Component;

@org.springframework.core.annotation.Order(value = 3)
@Component
public class PayStatusValidator implements PaymentValidator {

    @Override
    public void validate(Order order, PaymentDto dto) {
        if (order.isAlreadyPaymentComplete()) {
            throw new CustomException(COMMON_INVALID_PARAMETER, "이미 결제완료된 주문입니다.");
        }
    }
}
