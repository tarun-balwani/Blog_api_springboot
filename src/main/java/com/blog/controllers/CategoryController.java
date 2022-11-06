package com.blog.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.payloads.ApiResponse;
import com.blog.payloads.CategoryDto;
import com.blog.services.CategoryService;

@RestController
@RequestMapping("api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	//POST Request
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
		
		CategoryDto createdCategoryDto = this.categoryService.createCategory(categoryDto);
		
		return new ResponseEntity<>(createdCategoryDto,HttpStatus.CREATED);
	}
	
	//GET Mapping
	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer categoryId){
		CategoryDto cat = this.categoryService.getCategory(categoryId);
		
		return new ResponseEntity<>(cat,HttpStatus.OK);
	}
	
	//PUT Mapping
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,@PathVariable Integer categoryId){
		CategoryDto updatedCategoryDto = this.categoryService.updateCategory(categoryDto, categoryId);
		
		return new ResponseEntity<>(updatedCategoryDto,HttpStatus.OK);
		
	}
	
	//Delete mapping
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId){
		this.categoryService.deleteCategory(categoryId);
		
		return new ResponseEntity<>(new ApiResponse("Category deleted Successfully", true), HttpStatus.OK);
	}
	
	
	//GET All categories
		@GetMapping("/")
		public ResponseEntity<List<CategoryDto>> getAllCategories(){
			List<CategoryDto> categories = this.categoryService.getCategories();
			
			return new ResponseEntity<>(categories,HttpStatus.OK);
		}
	
}
