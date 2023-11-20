package kr.co.fastcampus.reservate.infrastructure.item;

import java.util.Objects;
import kr.co.fastcampus.reservate.common.exception.CustomException;
import kr.co.fastcampus.reservate.common.response.ErrorCode;
import kr.co.fastcampus.reservate.domain.item.Item;
import kr.co.fastcampus.reservate.domain.item.ItemCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Slf4j
@RequiredArgsConstructor
@Component
public class ItemCommandImpl implements ItemCommand {

    private final ItemRepository itemRepository;

    @Override
    public Item store(Item item) {
        validCheck(item);
        return itemRepository.save(item);
    }

    private void validCheck(Item item) {
        if (!StringUtils.hasText(item.getName())) {
            throw new CustomException(ErrorCode.COMMON_INVALID_PARAMETER);
        }

        if (Objects.isNull(item.getPrice())) {
            throw new CustomException(ErrorCode.COMMON_INVALID_PARAMETER);
        }
    }
}
