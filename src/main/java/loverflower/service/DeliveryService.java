package loverflower.service;

import loverflower.dto.DeliveryDto;
import loverflower.model.Delivery;
import loverflower.model.Result;
import loverflower.repository.DeliveryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {

     @Autowired
    DeliveryRepo deliveryRepo;


     public List<Delivery> getAllDeliveries() {
        return deliveryRepo.findAll();
     }


     public Delivery getDeliveryById(Long id) {
        return deliveryRepo.findById(id).orElse(null);
     }

     public Result create(DeliveryDto deliveryDto){
        Delivery delivery = new Delivery();
        delivery.setAddress(deliveryDto.getAddress());
        delivery.setTracking_number(deliveryDto.getTracking_number());
        deliveryRepo.save(delivery);
        return new Result(true,"Delivery created successfully");
     }

     public Result update(Long id, DeliveryDto deliveryDto){
         Optional<Delivery> optionalDelivery = deliveryRepo.findById(id);
         if (optionalDelivery.isPresent()) {
             Delivery delivery = new Delivery();
             delivery.setAddress(deliveryDto.getAddress());
            delivery.setTracking_number(deliveryDto.getTracking_number());
            deliveryRepo.save(delivery);
            return new Result(true,"Delivery updated successfully");
        }
        return new Result(false,"Delivery not found");
     }

     public Result delete(Long id){
         Optional<Delivery> optionalDelivery = deliveryRepo.findById(id);
         if (optionalDelivery.isPresent()){
             deliveryRepo.deleteById(id);
             return new Result(true,"Delivery deleted successfully");
         }
         return new Result(false,"Delivery not found");
     }
}
