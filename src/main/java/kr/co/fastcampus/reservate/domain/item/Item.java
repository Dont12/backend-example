package kr.co.fastcampus.reservate.domain.item;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import kr.co.fastcampus.reservate.domain.BaseTimeEntity;
import kr.co.fastcampus.reservate.domain.order.Order;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Item extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private String name;
    private Long price;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Builder
    private Item(String name, Long price) {
        this.name = name;
        this.price = price;
        this.status = Status.PREPARE;
    }

    /**
     * 상품 상태 "판매중" 변경
     */
    public void changeOnSale() {
        this.status = Status.ON_SALE;
    }

    /**
     * 상품 상태 "판매종료" 변경
     */
    public void changeEndOfSale() {
        this.status = Status.END_OF_SALE;
    }

    @Getter
    @RequiredArgsConstructor
    public enum Status {
        PREPARE("판매준비중"),
        ON_SALE("판매중"),
        END_OF_SALE("판매종료");

        private final String description;
    }
}
