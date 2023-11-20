package kr.co.fastcampus.reservate.interfaces.item.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record RegisterItemRequest(
        @NotEmpty String itemName,
        @NotNull Long itemPrice
) {

}
