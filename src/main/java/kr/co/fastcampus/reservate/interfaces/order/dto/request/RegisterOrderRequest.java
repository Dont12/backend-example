package kr.co.fastcampus.reservate.interfaces.order.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public record RegisterOrderRequest(
        @NotNull Long userId,
        @NotBlank String payMethod,
        @Valid List<RegisterOrderItemRequest> orderItems
) {

}
