package guru.springframework.spring5recipeapp.domain;

import java.util.Set;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by jt on 6/13/17.
 */
@Getter
@Setter
@Document
public class Category {

    @Id
    private String id;
    private String description;

    @DBRef
    private Set<Recipe> recipes;

}
