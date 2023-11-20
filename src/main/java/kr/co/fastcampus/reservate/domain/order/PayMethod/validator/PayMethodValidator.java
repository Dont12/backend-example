package kr.co.fastcampus.reservate.domain.order.PayMethod.validator;

import static kr.co.fastcampus.reservate.common.response.ErrorCode.COMMON_INVALID_PARAMETER;

import kr.co.fastcampus.reservate.common.exception.CustomException;
import kr.co.fastcampus.reservate.domain.order.Order;
import kr.co.fastcampus.reservate.domain.order.dto.request.PaymentDto;
import org.springframework.stereotype.Component;

@org.springframework.core.annotation.Order(value = 2)
@Component
public class PayMethodValidator implements PaymentValidator {

    @Override
    public void validate(Order order, PaymentDto dto) {
        if (!order.getPayMethod().equals(dto.payMethod().name())) {
            throw new CustomException(COMMON_INVALID_PARAMETER, "주문 과정에서의 결제수단이 다릅니다.");
        }
    }
}
