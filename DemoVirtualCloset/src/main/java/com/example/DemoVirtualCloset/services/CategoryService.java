package com.example.DemoVirtualCloset.services;

import com.example.DemoVirtualCloset.domain.Category;
import com.example.DemoVirtualCloset.dto.CategoryDto;
import com.example.DemoVirtualCloset.repositories.CategoryRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Iterable<CategoryDto> getAll() {
        List<CategoryDto> categoryDtos = new ArrayList<>();
        for (Category category : categoryRepository.findAll()) {
            CategoryDto categoryDto = new CategoryDto();

            categoryDto.setCategoryId(category.getId());
            categoryDto.setNameCategory(category.getNameCategory());
            categoryDto.setNameCategoryItem(category.getNameCategoryItem());
            categoryDto.setItemImage(category.getItemImage());

            categoryDtos.add(categoryDto);
        }
        return  categoryDtos;
    }

    public Optional<Category> getById(Long id) {
        return categoryRepository.findById(id);
    }

    public void create(CategoryDto categoryDto) {
        Category category = new Category();

        category.setId(categoryDto.getCategoryId());
        category.setNameCategory(categoryDto.getNameCategory());
        category.setNameCategoryItem(categoryDto.getNameCategoryItem());
        category.setItemImage(categoryDto.getItemImage());

        categoryRepository.save(category);
    }

    public void delete(Long id) {
        Category category = getById(id).orElseThrow(() -> new IllegalArgumentException("Category id: " + id + "not found"));
        categoryRepository.delete(category);
    }

    public CategoryDto showUpdateForm(@PathVariable("id") Long id) {
        Category category = getById(id).orElseThrow(() -> new IllegalArgumentException("Category id: " + id + "not found"));

        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryId(category.getId());
        categoryDto.setNameCategory(category.getNameCategory());
        categoryDto.setNameCategoryItem(category.getNameCategoryItem());
        categoryDto.setItemImage(category.getItemImage());

        return categoryDto;
    }

    public void updateCategoryItems(@PathVariable("id") Long id, @Valid CategoryDto categoryDto){

        Category category = getById(id).orElseThrow(() -> new IllegalArgumentException("Category id: " + id + "not found"));

        category.setNameCategory(categoryDto.getNameCategory());
        category.setNameCategoryItem(categoryDto.getNameCategoryItem());
        category.setItemImage(categoryDto.getItemImage());
        categoryRepository.save(category);
    }

}