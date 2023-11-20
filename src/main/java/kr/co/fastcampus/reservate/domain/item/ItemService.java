package kr.co.fastcampus.reservate.domain.item;

import kr.co.fastcampus.reservate.domain.item.dto.request.RegisterItemDto;
import kr.co.fastcampus.reservate.domain.item.dto.response.ItemInfoDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class ItemService {

    private final ItemCommand itemCommand;
    private final ItemReader itemReader;

    @Transactional
    public Long registerItem(RegisterItemDto dto) {
        var initItem = dto.toEntity();
        var item = itemCommand.store(initItem);
        return item.getId();
    }

    @Transactional
    public void changeOnSale(Long id) {
        var item = itemReader.getItem(id);
        item.changeOnSale();
    }

    @Transactional
    public void changeEndOfSale(Long id) {
        var item = itemReader.getItem(id);
        item.changeEndOfSale();
    }

    public ItemInfoDto retrieveItem(Long id) {
        var item = itemReader.getItem(id);
        return ItemInfoDto.from(item);
    }
}
