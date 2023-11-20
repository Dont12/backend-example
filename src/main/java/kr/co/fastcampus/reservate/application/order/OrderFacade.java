package kr.co.fastcampus.reservate.application.order;

import kr.co.fastcampus.reservate.domain.notification.NotificationService;
import kr.co.fastcampus.reservate.domain.order.OrderService;
import kr.co.fastcampus.reservate.domain.order.dto.request.PaymentDto;
import kr.co.fastcampus.reservate.domain.order.dto.request.RegisterOrderDto;
import kr.co.fastcampus.reservate.domain.order.dto.response.OrderInfoDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderFacade {
    private final OrderService orderService;
    private final NotificationService notificationService;

    public Long registerOrder(RegisterOrderDto dto) {
        var orderId = orderService.registerOrder(dto);
        notificationService.sendKakao("ORDER_COMPLETE", "content");
        return orderId;
    }

    public OrderInfoDto retrieveOrder(Long id) {
        return orderService.retrieveOrder(id);
    }

    public void paymentOrder(PaymentDto dto) {
        orderService.paymentOrder(dto);
        notificationService.sendKakao(null, null);
    }
}
