package kr.co.fastcampus.reservate.infrastructure.order;

import java.util.List;
import java.util.stream.Collectors;
import kr.co.fastcampus.reservate.domain.item.ItemReader;
import kr.co.fastcampus.reservate.domain.order.Order;
import kr.co.fastcampus.reservate.domain.order.OrderCommand;
import kr.co.fastcampus.reservate.domain.order.OrderItem;
import kr.co.fastcampus.reservate.domain.order.OrderItemFactory;
import kr.co.fastcampus.reservate.domain.order.dto.request.RegisterOrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class OrderItemFactoryImpl implements OrderItemFactory {

    private final ItemReader itemReader;
    private final OrderCommand orderCommand;

    @Override
    public List<OrderItem> store(Order order, RegisterOrderDto dto) {
        return dto.orderItems().stream()
                .map(registerOrderItem -> {
                    var item = itemReader.getItem(registerOrderItem.itemId());
                    var initOrderItem = registerOrderItem.toEntity(order, item);
                    return orderCommand.store(initOrderItem);
                })
                .collect(Collectors.toList());
    }
}
