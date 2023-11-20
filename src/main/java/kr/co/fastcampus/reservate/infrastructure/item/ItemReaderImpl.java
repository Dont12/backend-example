package kr.co.fastcampus.reservate.infrastructure.item;

import static kr.co.fastcampus.reservate.common.response.ErrorCode.COMMON_ENTITY_NOT_FOUND;

import kr.co.fastcampus.reservate.common.exception.CustomException;
import kr.co.fastcampus.reservate.domain.item.Item;
import kr.co.fastcampus.reservate.domain.item.ItemReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class ItemReaderImpl implements ItemReader {

    private final ItemRepository itemRepository;

    @Override
    public Item getItem(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new CustomException(COMMON_ENTITY_NOT_FOUND));
    }
}
