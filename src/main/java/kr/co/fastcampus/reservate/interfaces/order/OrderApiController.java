package kr.co.fastcampus.reservate.interfaces.order;

import jakarta.validation.Valid;
import kr.co.fastcampus.reservate.application.order.OrderFacade;
import kr.co.fastcampus.reservate.common.response.CommonResponse;
import kr.co.fastcampus.reservate.interfaces.order.dto.request.PaymentRequest;
import kr.co.fastcampus.reservate.interfaces.order.dto.request.RegisterOrderRequest;
import kr.co.fastcampus.reservate.interfaces.order.dto.response.OrderInfoResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderApiController {

    private final OrderFacade orderFacade;
    private final OrderDtoMapper orderDtoMapper;

    @PostMapping("/init")
    public CommonResponse<Long> registerOrder(@RequestBody @Valid RegisterOrderRequest request) {
        var response = orderFacade.registerOrder(orderDtoMapper.of(request));
        return CommonResponse.ok(response);
    }

    @GetMapping("/{id}")
    public CommonResponse<OrderInfoResponse> retrieveOrder(@PathVariable Long id) {
        var response = orderFacade.retrieveOrder(id);
        return CommonResponse.ok(orderDtoMapper.of(response));
    }

    @PostMapping("/payment-order")
    public CommonResponse<Void> paymentOrder(@RequestBody @Valid PaymentRequest request) {
        orderFacade.paymentOrder(orderDtoMapper.of(request));
        return CommonResponse.ok();
    }
}
