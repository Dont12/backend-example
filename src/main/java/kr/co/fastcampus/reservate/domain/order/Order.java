package kr.co.fastcampus.reservate.domain.order;

import static kr.co.fastcampus.reservate.common.response.ErrorCode.COMMON_ILLEGAL_STATUS;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import kr.co.fastcampus.reservate.common.exception.CustomException;
import kr.co.fastcampus.reservate.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Entity
@ToString
@NoArgsConstructor
@Table(name = "orders")
public class Order extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String payMethod;

    @OneToMany(
            mappedBy = "order",
            cascade = CascadeType.PERSIST
    )
    private final List<OrderItem> orderItems = new ArrayList<>();

    private LocalDateTime orderedAt;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Builder
    private Order(Long userId, String payMethod) {
        this.userId = userId;
        this.payMethod = payMethod;
        this.orderedAt = LocalDateTime.now();
        this.status = Status.INIT;
    }

    /**
     * 주문 가격 계산
     */
    public Long calculateTotalAmount() {
        return orderItems.stream()
                .mapToLong(OrderItem::getItemPrice)
                .sum();
    }

    /**
     * 주문 완료 상태 변경
     */
    public void orderComplete() {
        if (this.status != Status.INIT) {
            throw new CustomException(COMMON_ILLEGAL_STATUS);
        }
        this.status = Status.ORDER_COMPLETE;
    }

    /**
     * 결제 완료 확인
     */
    public boolean isAlreadyPaymentComplete() {
        return switch (this.status) {
            case ORDER_COMPLETE, DELIVERY_COMPLETE -> true;
            default -> false;
        };
    }

    @Getter
    @RequiredArgsConstructor
    public enum Status {
        INIT("주문시작"),
        ORDER_COMPLETE("주문완료"),
        DELIVERY_COMPLETE("배송완료"),
        ;

        private final String description;
    }
}
