package kr.co.fastcampus.reservate.domain.order.PayMethod.validator;

import static kr.co.fastcampus.reservate.common.response.ErrorCode.COMMON_INVALID_PARAMETER;

import kr.co.fastcampus.reservate.common.exception.CustomException;
import kr.co.fastcampus.reservate.domain.order.Order;
import kr.co.fastcampus.reservate.domain.order.dto.request.PaymentDto;
import org.springframework.stereotype.Component;

@org.springframework.core.annotation.Order(value = 1)
@Component
public class PayAmountValidator implements PaymentValidator {

    @Override
    public void validate(Order order, PaymentDto dto) {
        if (!order.calculateTotalAmount().equals(dto.price()))
            throw new CustomException(COMMON_INVALID_PARAMETER, "주문가격이 불일치합니다.");
    }
}
