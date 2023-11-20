package kr.co.fastcampus.reservate.interfaces.order;

import kr.co.fastcampus.reservate.domain.order.dto.request.PaymentDto;
import kr.co.fastcampus.reservate.domain.order.dto.request.RegisterOrderDto;
import kr.co.fastcampus.reservate.domain.order.dto.response.OrderInfoDto;
import kr.co.fastcampus.reservate.interfaces.order.dto.request.PaymentRequest;
import kr.co.fastcampus.reservate.interfaces.order.dto.request.RegisterOrderRequest;
import kr.co.fastcampus.reservate.interfaces.order.dto.response.OrderInfoResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface OrderDtoMapper {

    RegisterOrderDto of(RegisterOrderRequest request);

    PaymentDto of(PaymentRequest request);

    OrderInfoResponse of(OrderInfoDto response);
}
