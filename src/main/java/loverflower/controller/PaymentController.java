package loverflower.controller;

import loverflower.dto.PaymentDto;
import loverflower.model.Payment;
import loverflower.model.Result;
import loverflower.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPER_ADMIN')")
    public List<Payment> getPayments() {
        return paymentService.getAllPayments();
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPER_ADMIN')")
    @GetMapping("/{id}")
    public HttpEntity<Payment> getPaymentById(@PathVariable Long id) {
        return ResponseEntity.ok(paymentService.getPaymentById(id));
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPER_ADMIN')")
    @PostMapping
    public Result createPayment(@RequestBody PaymentDto paymentDto) {
        return paymentService.create(paymentDto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPER_ADMIN')")
    public Result updatePayment(@PathVariable Long id, @RequestBody PaymentDto paymentDto) {
        return paymentService.update(id, paymentDto);
    }
}
