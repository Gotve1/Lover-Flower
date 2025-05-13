package loverflower.service;

import loverflower.dto.ProductDto;
import loverflower.model.Category;
import loverflower.model.Product;
import loverflower.model.Result;
import loverflower.repository.CategoryRepo;
import loverflower.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;


    @Autowired
    CategoryRepo categoryRepo;

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product getProductById(Long id) {
        return productRepo.findById(id).get();
    }

    public Result create(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setColor(productDto.getColor());
        product.setImage_url(productDto.getImage_url());
        product.setOccasion(productDto.getOccasion());
        product.setType(productDto.getType());
        product.setQuantity(productDto.getQuantity());
        Optional<Category> categoryOptional = categoryRepo.findById(productDto.getCategory_id());
        Category category = categoryOptional.get();
        product.setCategory_id((List<Category>) category);
        productRepo.save(product);
        return new Result(true, "Product created successfully");
    }


    public Result update(Long id,ProductDto productDto){
        Optional<Product> optionalProduct = productRepo.findById(id);
        if (optionalProduct.isPresent()){
            Product product = new Product();
            product.setName(productDto.getName());
            product.setDescription(productDto.getDescription());
            product.setPrice(productDto.getPrice());
            product.setColor(productDto.getColor());
            product.setImage_url(productDto.getImage_url());
            product.setOccasion(productDto.getOccasion());
            product.setType(productDto.getType());
            product.setQuantity(productDto.getQuantity());
            Optional<Category> categoryOptional = categoryRepo.findById(productDto.getCategory_id());
            Category category = categoryOptional.get();
            product.setCategory_id((List<Category>) category);
            productRepo.save(product);
            return new Result(true,"Product updated successfully");

        }
        return new Result(false,"Product not found");
    }


    public Result delete(Long id){
        Optional<Product> optionalProduct = productRepo.findById(id);
        if (optionalProduct.isPresent()){
            productRepo.deleteById(id);
            return new Result(true,"Product deleted successfully");
        }
        return new Result(false,"Product not found");
    }

}
