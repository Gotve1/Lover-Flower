package loverflower.controller;

import loverflower.dto.OrderDto;
import loverflower.model.Order;
import loverflower.model.Result;
import loverflower.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;


    @GetMapping
    @PreAuthorize("hasAnyRole('USER','ADMIN','SUPER_ADMIN')")
    public List<Order> getAllorder(){
        List<Order> allOrders = orderService.getAllOrders();
        return allOrders;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER','ADMIN','SUPER_ADMIN')")
    public Order getOrderById(@PathVariable Long id){
        return orderService.getOrderById(id);
    }


    @PostMapping
    @PreAuthorize("hasAnyRole('USER','ADMIN',SUPER_ADMIN')")
    public Result addOrder(@RequestBody OrderDto orderDto){
        return orderService.create(orderDto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER','ADMIN','SUPER_ADMIN')")
    public Result updateOrder(@PathVariable Long id, @RequestBody OrderDto orderDto){
        return orderService.update(id, orderDto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER','ADMIN','SUPER_ADMIN')")
    public Result deleteOrder(@PathVariable Long id){
        return orderService.delete(id);
    }


}
