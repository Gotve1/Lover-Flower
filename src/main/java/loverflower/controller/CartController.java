package loverflower.controller;

import loverflower.dto.CartDto;
import loverflower.model.Cart;
import loverflower.model.Result;
import loverflower.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {


    @Autowired
    CartService cartService;


    @GetMapping
    public List<Cart> getAllCarts() {
        List<Cart> allCarts = cartService.getAllCarts();
        return allCarts;
    }

    @GetMapping("/{id}")
    public Cart getCartById(@PathVariable Long id) {
        return cartService.getCartById(id);
    }

    @PostMapping
    public Result addCart(@RequestBody CartDto cartDto) {
        return cartService.create(cartDto);
    }


    @PutMapping("/{id}")
    public Result updateCart(@PathVariable Long id, @RequestBody CartDto cartDto) {
        return cartService.update(id, cartDto);
    }

    @DeleteMapping("/{id}")
    public Result deleteCart(@PathVariable Long id) {
        return cartService.delete(id);
    }

}
