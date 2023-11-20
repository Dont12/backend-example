package kr.co.fastcampus.reservate.domain.order;

import static kr.co.fastcampus.reservate.common.response.ErrorCode.COMMON_INVALID_PARAMETER;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Objects;
import kr.co.fastcampus.reservate.common.exception.CustomException;
import kr.co.fastcampus.reservate.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class OrderItem extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private Long userId;
    private Long itemId;
    private String itemName;
    private Long itemPrice;

    @Builder

    public OrderItem(
            Order order,
            Long userId,
            Long itemId,
            String itemName,
            Long itemPrice
    ) {
        if (Objects.isNull(order)) {
            throw new CustomException(COMMON_INVALID_PARAMETER);
        }
        if (userId == null) {
            throw new CustomException(COMMON_INVALID_PARAMETER);
        }
        if (Objects.isNull(itemId)) {
            throw new CustomException(COMMON_INVALID_PARAMETER);
        }
        if (Objects.isNull(itemPrice)) {
            throw new CustomException(COMMON_INVALID_PARAMETER);
        }

        this.order = order;
        this.userId = userId;
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }
}
