package com.example.DemoVirtualCloset.dto;

import java.io.Serializable;

public class CategoryDto implements Serializable {
    public Long id;

    public String nameCategory;

    public String nameCategoryItem;

    public String itemImage;

    @Override
    public String toString() {
        return String.format("CategoryDto{id=%d, nameCategory='%s', nameCategoryItem='%s', itemImage='%s'}", id, nameCategory, nameCategoryItem, itemImage);
    }

    public Long getCategoryId() {
        return id;
    }

    public void setCategoryId(Long categoryId) {
        this.id = categoryId;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getNameCategoryItem() {
        return nameCategoryItem;
    }

    public void setNameCategoryItem(String nameCategoryItemDto) {
        this.nameCategoryItem = nameCategoryItemDto;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImageDto) {
        this.itemImage = itemImageDto;
    }

}
