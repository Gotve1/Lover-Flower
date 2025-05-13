package loverflower.controller;

import loverflower.dto.OrderDto;
import loverflower.model.Order;
import loverflower.model.Result;
import loverflower.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;


    @GetMapping
    public List<Order> getAllorder(){
        List<Order> allOrders = orderService.getAllOrders();
        return allOrders;
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id){
        return orderService.getOrderById(id);
    }


    @PostMapping
    public Result addOrder(@RequestBody OrderDto orderDto){
        return orderService.create(orderDto);
    }

    @PutMapping("/{id}")
    public Result updateOrder(@PathVariable Long id, @RequestBody OrderDto orderDto){
        return orderService.update(id, orderDto);
    }

    @DeleteMapping("/{id}")
    public Result deleteOrder(@PathVariable Long id){
        return orderService.delete(id);
    }


}
