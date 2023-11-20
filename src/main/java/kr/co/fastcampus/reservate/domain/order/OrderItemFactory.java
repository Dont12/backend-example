package kr.co.fastcampus.reservate.domain.order;

import java.util.List;
import kr.co.fastcampus.reservate.domain.order.dto.request.RegisterOrderDto;

public interface OrderItemFactory {

    List<OrderItem> store(Order order, RegisterOrderDto dto);
}
