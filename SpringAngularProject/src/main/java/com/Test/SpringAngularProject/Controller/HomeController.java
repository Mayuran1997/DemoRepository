package com.Test.SpringAngularProject.Controller;

import java.util.List;
import java.util.Optional;

import org.mockito.internal.matchers.CapturesArguments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Test.SpringAngularProject.Model.Category;
import com.Test.SpringAngularProject.Repository.CategoryRepository;
import com.Test.SpringAngularProject.Service.CategoryService;

@RestController
public class HomeController {
	
	@Autowired
	private CategoryService categoryservice;
	
	@Autowired
	private CategoryRepository ctrepo;
	
	@PostMapping("/addcategory")
	public Category addCategory( @RequestBody Category Category) {
		return categoryservice.saveCategory(Category);
	}
	
	@PostMapping("/addcategory/{uid}")
	public Category addSubCategory( @PathVariable("uid") int parentId ,@RequestBody Category Category) {
		return categoryservice.saveSubCategory(Category,parentId);
	}

	@GetMapping("/categories")
	public List<Category>getCategories(){
		return categoryservice.getActiveCategories();
	}
	
	
	@GetMapping("/categories/{uid}")
	public List<Category>getSubCategories(@PathVariable("uid") int parentId){
		return categoryservice.getActiveSubCategories(parentId);
	}
	
	@PutMapping("/updatecategory")
	public Category updateCategory(@RequestBody Category cat) {
		return categoryservice.update(cat);
	}
	
	@DeleteMapping("/delcategory")
	public String deleteAll() {
		categoryservice.deleteAllCategory();
		return "deleted all the categories";
	}
	
	@DeleteMapping("/delcategory/{uid}")
	public String delete(@PathVariable int uid) {
		Category ct= ctrepo.findByUid((long)uid);
		if(ct.getParentId()==0) {
			List<Category>catlist=ctrepo.findByParentIdAndActivity(uid, 0);
			if(catlist==null)
				categoryservice.deleteSelectedCategory(uid); 
			else {
				ctrepo.deleteAll(catlist);
			}
		}
		else
		categoryservice.deleteSelectedCategory(uid);
		
		return "delete success";
		
	}
}
