package loverflower.service;

import loverflower.dto.CategoryDto;
import loverflower.model.Category;
import loverflower.model.Result;
import loverflower.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    public Category getCategoryById(Long id) {
        return categoryRepo.findById(id).get();
    }

    public Result create(CategoryDto categoryDto){
        Category category = new Category();
        category.setName(categoryDto.getName());
        categoryRepo.save(category);
        return new Result(true,"Category created successfully");
    }

    public Result update(Long id,CategoryDto categoryDto) {
        Optional<Category> categoryOptional = categoryRepo.findById(id);
        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            category.setName(categoryDto.getName());
            categoryRepo.save(category);
            return new Result(true, "Category updated successfully");
        }
        return new Result(false,"Category not found");
    }


    public Result delete(Long id) {
        Optional<Category> categoryOptional = categoryRepo.findById(id);
        if (categoryOptional.isPresent()) {
            categoryRepo.deleteById(id);
            return new Result(true, "Category deleted successfully");
        }
        return new Result(false, "Category not found");
    }
}
