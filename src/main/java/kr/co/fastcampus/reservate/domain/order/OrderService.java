package kr.co.fastcampus.reservate.domain.order;

import kr.co.fastcampus.reservate.domain.order.PayMethod.PaymentProcessor;
import kr.co.fastcampus.reservate.domain.order.dto.request.PaymentDto;
import kr.co.fastcampus.reservate.domain.order.dto.request.RegisterOrderDto;
import kr.co.fastcampus.reservate.domain.order.dto.response.OrderInfoDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class OrderService {

    private final OrderCommand orderCommand;
    private final OrderReader orderReader;
    private final OrderItemFactory orderItemFactory;
    private final PaymentProcessor paymentProcessor;

    @Transactional
    public Long registerOrder(RegisterOrderDto dto) {
        var order = orderCommand.store(dto.toEntity());
        orderItemFactory.store(order, dto);
        return order.getId();
    }

    @Transactional
    public void paymentOrder(PaymentDto dto) {
        var order = orderReader.getOrder(dto.orderId());
        paymentProcessor.pay(order, dto);
        order.orderComplete();
    }

    public OrderInfoDto retrieveOrder(Long id) {
        var order = orderReader.getOrder(id);
        var orderItems = order.getOrderItems();
        return OrderInfoDto.from(order, orderItems);
    }
}
