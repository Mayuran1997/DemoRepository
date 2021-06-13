package com.Test.SpringAngularProject.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Test.SpringAngularProject.Model.Category;
import com.Test.SpringAngularProject.Repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryrepo;
	
	//for adding main category
	public Category saveCategory(Category category) {
		category.setParentId(0);
		return categoryrepo.save(category);
	}
	
	//for adding subcategory
	public Category saveSubCategory(Category category,int parentId) {
		category.setParentId(parentId);
		return categoryrepo.save(category);
	}

	//for retrieving all the categories which are active.
	public List<Category> getActiveCategories() {
		int active=0;
		return categoryrepo.findByActivity(active);
	}
	
	//for retrieving all the subcategories which are active.
		public List<Category> getActiveSubCategories(int uid) {
			int active=0;
			return categoryrepo.findByParentIdAndActivity(uid,active);
		}
	
	//delete the catagories by their uid
	public void deleteSelectedCategory(int id) {
		categoryrepo.deleteById((long) id);
	}
	
	//delete all the catagories 
	public void deleteAllCategory() {
		categoryrepo.deleteAll();
	}

	
	public Category update(Category cat) {
		return categoryrepo.save(cat);
	}
	
	
	
	

	
	
	

}
