package kr.co.fastcampus.reservate.domain.order;

public interface OrderCommand {

    Order store(Order order);

    OrderItem store(OrderItem orderItem);
}
