package kr.co.fastcampus.reservate.infrastructure.item;

import kr.co.fastcampus.reservate.domain.item.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {

}
