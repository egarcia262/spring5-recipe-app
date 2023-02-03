package guru.springframework.spring5recipeapp.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.spring5recipeapp.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, String> {
	
	Optional<Category> findByDescription(String description);
}
