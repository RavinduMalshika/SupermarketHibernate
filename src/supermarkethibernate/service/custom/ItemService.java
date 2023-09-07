package supermarkethibernate.service.custom;

import supermarkethibernate.dto.ItemDto;
import supermarkethibernate.service.SuperService;

import java.util.List;

public interface ItemService extends SuperService {
    String saveItem(ItemDto itemDto);

    String updateItem(ItemDto itemDto);

    String deleteItem(String id);

    ItemDto getItem(String id);

    List<ItemDto> getAllCustomers();
}
