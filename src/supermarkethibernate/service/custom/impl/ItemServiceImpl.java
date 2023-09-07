package supermarkethibernate.service.custom.impl;

import supermarkethibernate.dao.DaoFactory;
import supermarkethibernate.dao.custom.ItemDao;
import supermarkethibernate.dto.CustomerDto;
import supermarkethibernate.dto.ItemDto;
import supermarkethibernate.entity.CustomerEntity;
import supermarkethibernate.entity.ItemEntity;
import supermarkethibernate.service.custom.ItemService;

import java.util.ArrayList;
import java.util.List;

public class ItemServiceImpl implements ItemService {
    ItemDao itemDao = (ItemDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ITEM);

    @Override
    public String saveItem(ItemDto itemDto) {
        ItemEntity itemEntity = new ItemEntity(
                itemDto.getId(),
                itemDto.getDescription(),
                itemDto.getPackSize(),
                itemDto.getUnitPrice(),
                itemDto.getQtyOnHand()
        );

        if(itemDao.save(itemEntity, session)) {
            return "Successfully Saved";
        } else {
            return "Failed";
        }
    }

    @Override
    public String updateItem(ItemDto itemDto) {
        ItemEntity itemEntity = new ItemEntity(
                itemDto.getId(),
                itemDto.getDescription(),
                itemDto.getPackSize(),
                itemDto.getUnitPrice(),
                itemDto.getQtyOnHand()
        );

        if(itemDao.save(itemEntity, session)) {
            return "Successfully Saved";
        } else {
            return "Failed";
        }
    }

    @Override
    public String deleteItem(String id) {
        if(itemDao.delete(id, session)) {
            return "Successfully Saved";
        } else {
            return "Failed";
        }
    }

    @Override
    public ItemDto getItem(String id) {
        ItemEntity itemEntity = itemDao.get(id, session);
        return new ItemDto(
                itemEntity.getId(),
                itemEntity.getDescription(),
                itemEntity.getPackSize(),
                itemEntity.getUnitPrice(),
                itemEntity.getQtyOnHand()
        );
    }

    @Override
    public List<ItemDto> getAllCustomers() {
        ArrayList<ItemDto> itemDtos = new ArrayList<>();
        List<ItemEntity> itemEntities = itemDao.getAll(session);

        for (ItemEntity itemEntity : itemEntities) {
            ItemDto itemDto = new ItemDto(
                    itemEntity.getId(),
                    itemEntity.getDescription(),
                    itemEntity.getPackSize(),
                    itemEntity.getUnitPrice(),
                    itemEntity.getQtyOnHand()
            );
            itemDtos.add(itemDto);
        }
        return itemDtos;
    }
}
