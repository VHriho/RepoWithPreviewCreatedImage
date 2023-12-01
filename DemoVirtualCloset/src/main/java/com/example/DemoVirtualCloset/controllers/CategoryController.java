package com.example.DemoVirtualCloset.controllers;
import com.example.DemoVirtualCloset.domain.Category;
import com.example.DemoVirtualCloset.dto.CategoryDto;
import com.example.DemoVirtualCloset.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/create-category")
    public String showCreateCategoryForm(CategoryDto categoryDto) {
        return "newCategoryForm";
    }

    @PostMapping("/category")
    public String createCategory(@Valid CategoryDto categoryDto) {
        categoryService.create(categoryDto);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id) {
        categoryService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("category", categoryService.showUpdateForm(id));
        return "editCategoryItem";
    }

    @PostMapping("/category/{id}")
    public String updateCategoryItems(@PathVariable("id") Long id, @Valid CategoryDto categoryDto) {
        categoryService.updateCategoryItems(id, categoryDto);
        return "redirect:/";
    }

}
