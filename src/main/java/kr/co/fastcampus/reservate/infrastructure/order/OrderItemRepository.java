package kr.co.fastcampus.reservate.infrastructure.order;

import kr.co.fastcampus.reservate.domain.order.OrderItem;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {

}
