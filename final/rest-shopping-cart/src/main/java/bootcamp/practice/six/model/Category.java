package bootcamp.practice.six.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * POJO modeling categories. Each product has a category. Being an entity, the
 * Category gains consistency.
 * 
 */
@Entity
public class Category {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	/**
	 * The name used to identify the category in a url like path. 
	 */
	private String urlname;

	public Category(String name, String urlname) {
		this.name = name;
		this.urlname = urlname;
	}

	Category() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrlname() {
		return urlname;
	}

	public void setUrlname(String urlname) {
		this.urlname = urlname;
	}

	public Long getId() {
		return id;
	}

}
