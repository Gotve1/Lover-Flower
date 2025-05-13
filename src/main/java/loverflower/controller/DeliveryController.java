package loverflower.controller;

import loverflower.dto.DeliveryDto;
import loverflower.model.Delivery;
import loverflower.model.Result;
import loverflower.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    @Autowired
    DeliveryService deliveryService;


    @GetMapping
    public List<Delivery> getAllDelivery(){
        List<Delivery> allDeliveries = deliveryService.getAllDeliveries();
        return allDeliveries;
    }

    @GetMapping("/{id}")
    public Delivery getDeliveryById(@PathVariable Long id){
        return deliveryService.getDeliveryById(id);
    }


    @PostMapping
    public Result create(@RequestBody DeliveryDto deliveryDto){
        return deliveryService.create(deliveryDto);
    }


    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, @RequestBody DeliveryDto deliveryDto){
        return deliveryService.update(id, deliveryDto);
    }


}
