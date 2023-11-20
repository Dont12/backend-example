package kr.co.fastcampus.reservate.application.item;

import kr.co.fastcampus.reservate.domain.item.ItemService;
import kr.co.fastcampus.reservate.domain.item.dto.request.RegisterItemDto;
import kr.co.fastcampus.reservate.domain.item.dto.response.ItemInfoDto;
import kr.co.fastcampus.reservate.domain.notification.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ItemFacade {
    private final ItemService itemService;
    private final NotificationService notificationService;

    public Long registerItem(RegisterItemDto dto) {
        var itemId = itemService.registerItem(dto);
        notificationService.sendEmail(null, null, null);
        return itemId;
    }

    public void changeOnSaleItem(Long id) {
        itemService.changeOnSale(id);
    }

    public void changeEndOfSaleItem(Long id) {
        itemService.changeEndOfSale(id);
    }

    public ItemInfoDto retrieveItemInfo(Long id) {
        return itemService.retrieveItem(id);
    }
}
