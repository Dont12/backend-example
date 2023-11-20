package kr.co.fastcampus.reservate.interfaces.order.dto.response;

public record OrderItemInfoResponse(
        Long itemId,
        String itemName,
        Long itemPrice
) {

}
