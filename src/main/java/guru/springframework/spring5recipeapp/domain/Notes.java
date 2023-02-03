package guru.springframework.spring5recipeapp.domain;

import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by jt on 6/13/17.
 */
@Getter
@Setter
public class Notes {

    private String id;

    private Recipe recipe;

    private String recipeNotes;
    
}
