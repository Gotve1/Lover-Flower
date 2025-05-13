package loverflower.controller;

import loverflower.model.Payment;
import loverflower.service.PaymentService;

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
}
