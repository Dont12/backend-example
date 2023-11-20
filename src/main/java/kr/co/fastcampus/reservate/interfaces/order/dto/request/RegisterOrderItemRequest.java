package kr.co.fastcampus.reservate.interfaces.order.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterOrderItemRequest(
        @NotNull Long itemId,
        @NotBlank String itemName,
        @NotNull Long itemPrice
) {

}
