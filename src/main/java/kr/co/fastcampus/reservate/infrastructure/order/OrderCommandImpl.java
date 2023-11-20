package kr.co.fastcampus.reservate.infrastructure.order;

import kr.co.fastcampus.reservate.domain.order.Order;
import kr.co.fastcampus.reservate.domain.order.OrderCommand;
import kr.co.fastcampus.reservate.domain.order.OrderItem;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class OrderCommandImpl implements OrderCommand {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    @Override
    public Order store(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public OrderItem store(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }
}
