package loverflower.service;

import loverflower.dto.CartDto;
import loverflower.model.Cart;
import loverflower.model.Product;
import loverflower.model.Result;
import loverflower.model.User;
import loverflower.repository.CartRepo;
import loverflower.repository.ProductRepo;
import loverflower.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    CartRepo cartRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    ProductRepo productRepo;


    public List<Cart> getAllCarts() {
        return cartRepo.findAll();
    }

    public Cart getCartById(Long id) {
        return cartRepo.findById(id).get();
    }

    public Result create(CartDto cartDto){
        Cart cart = new Cart();
        Optional<User> userOptional = userRepo.findById(cartDto.getUser_id());
        User user = userOptional.get();
        cart.setUser_id((List<User>) user);

        cart.setItems(cartDto.getItems());
        Optional<Product> optionalProduct = productRepo.findById(cartDto.getProduct_id());
        Product product = optionalProduct.get();
        cart.setProduct_id((List<Product>) product);
        cart.setQuantity(cartDto.getQuantity());
        cart.setTotal_price(cartDto.getTotal_price());
        cartRepo.save(cart);
        return new Result(true,"Cart created successfully");

    }


    public Result update(Long id,CartDto cartDto){
        Optional<Cart> cartOptional = cartRepo.findById(id);
        if (cartOptional.isPresent()){
            Cart cart = new Cart();
            Optional<User> userOptional = userRepo.findById(cartDto.getUser_id());
            User user = userOptional.get();
            cart.setUser_id((List<User>) user);

            cart.setItems(cartDto.getItems());
            Optional<Product> optionalProduct = productRepo.findById(cartDto.getProduct_id());
            Product product = optionalProduct.get();
            cart.setProduct_id((List<Product>)product);
            cart.setQuantity(cartDto.getQuantity());
            cart.setTotal_price(cartDto.getTotal_price());
            cartRepo.save(cart);
            return new Result(true,"Cart updated successfully");

        }
        return new Result(false,"Cart not found");
    }

    public Result delete(Long id){
        Optional<Cart> cartOptional = cartRepo.findById(id);
        if (cartOptional.isPresent()){
            cartRepo.deleteById(id);
            return new Result(true,"Cart deleted successfully");
        }
        return new Result(false,"Cart not found");
    }
}
