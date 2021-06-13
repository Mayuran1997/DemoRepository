package com.Test.SpringAngularProject.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Test.SpringAngularProject.Model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

	List<Category> findByActivity(int active);
	
	Category findByUid(Long uid);
	List<Category> findByParentIdAndActivity(int uid,int active);

}
