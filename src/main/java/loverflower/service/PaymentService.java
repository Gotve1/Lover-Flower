package loverflower.service;


import loverflower.dto.PaymentDto;
import loverflower.model.Order;
import loverflower.model.Payment;
import loverflower.model.Result;
import loverflower.repository.OrderRepo;
import loverflower.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    PaymentRepo paymentRepo;

    @Autowired
    OrderRepo orderRepo;

    public List<Payment> getAllPayments() {
        return paymentRepo.findAll();
    }

    public Payment getPaymentById(Long id) {
        return paymentRepo.findById(id).get();
    }


    public Result create(PaymentDto paymentDto){
        Payment payment = new Payment();
        payment.setAmount(paymentDto.getAmount());
        payment.setMethod(paymentDto.getMethod());

        Optional<Order> orderOptional = orderRepo.findById(paymentDto.getOrder_id());
        Order order = orderOptional.get();
        payment.setOrder_id((List<Order>) order);
        paymentRepo.save(payment);
        return new Result(true,"Payment created successfully");
    }

    public Result update(Long id,PaymentDto paymentDto){
        Optional<Payment> paymentOptional = paymentRepo.findById(id);
        if (paymentOptional.isPresent()){
            Payment payment = new Payment();
            Optional<Order> orderOptional = orderRepo.findById(paymentDto.getOrder_id());
            Order order = orderOptional.get();
            payment.setOrder_id((List<Order>) order);
            payment.setMethod(paymentDto.getMethod());
            payment.setAmount(paymentDto.getAmount());
            paymentRepo.save(payment);
            return new Result(true,"Payment updated successfully");
        }
        return new Result(false,"Payment not found");
    }
}
