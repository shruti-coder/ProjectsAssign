package com.training.nagarro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Controller;

/**
 *
 */
@Entity
@Table(name="tshirt")
@Controller
public class TShirt 
{
    @Id
    private String id;
    @Column(name="name")
    private String name;
    @Column(name="colour")
    private String colour;
    @Column(name="size")
    private String size;
    @Column(name="gender")
    private String gender;
    @Column(name="price")
    private float price;
    @Column(name="rating")
    private float rating;
    @Column(name="availability")
    private String availability;

	/**
	 * @return id
	 */
    public String getId() 
    {
        return id;
    }

	/**
	 * @param id
	 */
    public void setId(String id) 
    {
        this.id = id;
    }

	/**
	 * @return name
	 */
    public String getName() 
    {
        return name;
    }

	/**
	 * @param name
	 */
	public void setName(String name) 
	{
		this.name = name;
	}

	/**
	 * @return colour
	 */
	public String getColour() 
	{
		return colour;
	}

	/**
	 * @param colour
	 */
	public void setColour(String colour) 
	{
		this.colour = colour;
	}

	/**
	 * @return price
	 */
	public float getPrice() 
	{
		return price;
	}

	/**
	 * @param price
	 */
	public void setPrice(float price) 
	{
		this.price = price;
	}

	/**
	 * @return rating
	 */
	public float getRating() 
	{
		return rating;
	}

	/**
	 * @param rating
	 */
	public void setRating(float rating) 
	{
		this.rating = rating;
	}

	/**
	 * @return size
	 */
	public String getSize() 
	{
		return size;
	}

	/**
	 * @param size
	 */
	public void setSize(String size) 
	{
		this.size = size;
	}

	/**
	 * @return genderRecommendation
	 */
	public String getGender() 
	{
		return gender;
	}

	/**
	 * @param genderRecommendation
	 */
	public void setGender(String gender) 
	{
		this.gender= gender;
	}

	/**
	 * @return availability
	 */
	public String getAvailability() 
	{
		return availability;
	}

	/**
	 * @param availability
	 */
	public void setAvailability(String availability) 
	{
		this.availability = availability;
	}
	public TShirt() {
		
	}
	
	public TShirt(String id, String name, String colour, String size, String gender, float price,
			float rating, String availability) {
		super();
		this.id = id;
		this.name = name;
		this.colour = colour;
		this.size = size;
		this.gender= gender;
		this.price = price;
		this.rating = rating;
		this.availability = availability;
	}

	@Override
	public String toString() 
	{
		return "TShirt [id=" + id + ", name=" + name + ", colour=" + colour + ", price=" + price + ", rating=" + rating
				+ ", size=" + size + ", genderRecommendation=" + gender + ", availability=" + availability
				+ "]";
	}
}
