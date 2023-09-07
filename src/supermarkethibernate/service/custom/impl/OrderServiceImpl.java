package supermarkethibernate.service.custom.impl;

import org.hibernate.Transaction;
import supermarkethibernate.dao.DaoFactory;
import supermarkethibernate.dao.custom.CustomerDao;
import supermarkethibernate.dao.custom.ItemDao;
import supermarkethibernate.dao.custom.OrderDao;
import supermarkethibernate.dao.custom.OrderDetailDao;
import supermarkethibernate.dto.OrderDetailDto;
import supermarkethibernate.dto.OrderDto;
import supermarkethibernate.entity.CustomerEntity;
import supermarkethibernate.entity.ItemEntity;
import supermarkethibernate.entity.OrderDetailEntity;
import supermarkethibernate.entity.OrderEntity;
import supermarkethibernate.service.custom.OrderService;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = (OrderDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ORDER);
    private OrderDetailDao orderDetailDao = (OrderDetailDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ORDER_DETAIL);
    private ItemDao itemDao = (ItemDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ITEM);
    private CustomerDao customerDao = (CustomerDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.CUSTOMER);

    @Override
    public String placeOrder(OrderDto orderDto) {
        CustomerEntity customerEntity = customerDao.get(orderDto.getCustID(), session);

        Transaction transaction = session.beginTransaction();

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(orderDto.getOrderID());
        orderEntity.setDate(new Date());
        orderEntity.setCustomerEntity(customerEntity);

        if(orderDao.save(orderEntity, session)) {
            Boolean isOrderDetailSaved = true;

            for (OrderDetailDto orderDetailDto : orderDto.getOrderDetailDtos()) {
                ItemEntity itemEntity = itemDao.get(orderDetailDto.getItemID(), session);
                OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
                orderDetailEntity.setOrderEntity(orderEntity);
                orderDetailEntity.setItemEntity(itemEntity);
                orderDetailEntity.setQty(orderDetailDto.getQty());
                orderDetailEntity.setDiscount(orderDetailDto.getDiscount());

                itemEntity.setQtyOnHand(itemEntity.getQtyOnHand() - orderDetailDto.getQty());
                itemDao.update(itemEntity, session);

                if(!orderDetailDao.save(orderDetailEntity, session)) {
                    isOrderDetailSaved = false;
                }
            }

            if(isOrderDetailSaved) {
                transaction.commit();
                return "Success";
            } else {
                transaction.rollback();
                return "Failed";
            }
        } else {
            transaction.rollback();
            return "Order Save Error";
        }
    }
}
