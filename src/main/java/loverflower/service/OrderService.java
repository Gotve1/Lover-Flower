package loverflower.service;

import loverflower.dto.OrderDto;
import loverflower.model.Order;
import loverflower.model.Product;
import loverflower.model.Result;
import loverflower.model.User;
import loverflower.repository.OrderRepo;
import loverflower.repository.ProductRepo;
import loverflower.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    ProductRepo productRepo;


    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepo.findById(id).get();
    }


    public Result create(OrderDto orderDto){
        Order order = new Order();
        order.setOrderNumber(orderDto.getOrderNumber());
        Optional<User> userOptional = userRepo.findById(orderDto.getUser_id());
        User user = userOptional.get();
        order.setUser_id((List<User>) user);
        Optional<Product> optionalProduct = productRepo.findById(orderDto.getProductId());
        Product product = optionalProduct.get();
        order.setProductId((List<Product>) product);
        order.setDeliveryAddress(orderDto.getDeliveryAddress());
        order.setPaymentMethod(orderDto.getPaymentMethod());
        order.setTotalPrice(orderDto.getTotalPrice());
        order.setDeliveryAddress(orderDto.getDeliveryAddress());
        order.setQuantity(orderDto.getQuantity());
        orderRepo.save(order);
        return new Result(true,"Order created successfully");
    }


    public Result update(Long id, OrderDto orderDto){
        Optional<Order> orderOptional = orderRepo.findById(id);
        if (orderOptional.isPresent()){
            Order order = orderOptional.get();
            Optional<User> userOptional = userRepo.findById(orderDto.getUser_id());
            User user = userOptional.get();
            order.setUser_id((List<User>) user);
            Optional<Product> optionalProduct = productRepo.findById(orderDto.getProductId());
            Product product = optionalProduct.get();
            order.setProductId((List<Product>) product);
            order.setOrderNumber(orderDto.getOrderNumber());
            order.setDeliveryAddress(orderDto.getDeliveryAddress());
            order.setPaymentMethod(orderDto.getPaymentMethod());
            order.setTotalPrice(orderDto.getTotalPrice());
            order.setDeliveryAddress(orderDto.getDeliveryAddress());
            order.setQuantity(orderDto.getQuantity());
            orderRepo.save(order);
            return new Result(true,"Order updated successfully");
        }
        return new Result(false,"Order not found");
    }

    public Result delete(Long id){
        Optional<Order> orderOptional = orderRepo.findById(id);
        if (orderOptional.isPresent()){
            orderRepo.deleteById(id);
            return new Result(true,"Order deleted successfully");
        }
        return new Result(false,"Order not found");
    }
}
