package loverflower.controller;

import loverflower.dto.ProductDto;
import loverflower.model.Product;
import loverflower.model.Result;
import loverflower.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {


    @Autowired
    ProductService productService;


    @GetMapping
    public List<Product> getAllProducts() {
        List<Product> allProducts = productService.getAllProducts();
        return allProducts;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }


    @PostMapping
    public Result addProduct(@RequestBody ProductDto productDto) {
        return productService.create(productDto);
    }

    @PutMapping("/{id}")
    public Result udpate(@PathVariable Long id,@RequestBody ProductDto productDto ){
        return productService.update(id, productDto);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        return productService.delete(id);
    }




}
