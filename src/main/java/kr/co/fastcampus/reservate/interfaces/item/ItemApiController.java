package kr.co.fastcampus.reservate.interfaces.item;

import jakarta.validation.Valid;
import kr.co.fastcampus.reservate.application.item.ItemFacade;
import kr.co.fastcampus.reservate.common.response.CommonResponse;
import kr.co.fastcampus.reservate.interfaces.item.dto.request.RegisterItemRequest;
import kr.co.fastcampus.reservate.interfaces.item.dto.response.ItemInfoResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/items")
public class ItemApiController {

    private final ItemFacade itemFacade;
    private final ItemDtoMapper itemDtoMapper;

    @PostMapping
    public CommonResponse<Long> registerItem(@RequestBody @Valid RegisterItemRequest request) {
        var response = itemFacade.registerItem(itemDtoMapper.of(request));
        return CommonResponse.ok(response);
    }

    @PostMapping("/change-on-sales/{id}")
    public CommonResponse<Void> changeOnSaleItem(@PathVariable("id") Long id) {
        itemFacade.changeOnSaleItem(id);
        return CommonResponse.ok();
    }

    @PostMapping("/change-end-of-sales/{id}")
    public CommonResponse<Void> changeEndOfSaleItem(@PathVariable("id") Long id) {
        itemFacade.changeEndOfSaleItem(id);
        return CommonResponse.ok();
    }

    @GetMapping("/{id}")
    public CommonResponse<ItemInfoResponse> retrieve(@PathVariable("id") Long id) {
        var response = itemFacade.retrieveItemInfo(id);
        return CommonResponse.ok(itemDtoMapper.of(response));
    }
}
