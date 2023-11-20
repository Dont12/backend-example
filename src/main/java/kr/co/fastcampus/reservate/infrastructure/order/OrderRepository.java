package kr.co.fastcampus.reservate.infrastructure.order;

import kr.co.fastcampus.reservate.domain.order.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
