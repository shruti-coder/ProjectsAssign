package com.main;

	public class Tshirt {

	    private String id;
	    private String name;
	    private String colour;
	    private String size;
	    private String genderRecommendation;
	    private float price;
	    private float rating;
	    private String availability;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getColour() {
			return colour;
		}
		public void setColour(String colour) {
			this.colour = colour;
		}
		public String getSize() {
			return size;
		}
		public void setSize(String size) {
			this.size = size;
		}
		public String getGenderRecommendation() {
			return genderRecommendation;
		}
		public void setGenderRecommendation(String genderRecommendation) {
			this.genderRecommendation = genderRecommendation;
		}
		public float getPrice() {
			return price;
		}
		public void setPrice(float price) {
			this.price = price;
		}
		public float getRating() {
			return rating;
		}
		public void setRating(float rating) {
			this.rating = rating;
		}
		public String getAvailability() {
			return availability;
		}
		public void setAvailability(String availability) {
			this.availability = availability;
		}
		public Tshirt(String id, String name, String colour, String size, String genderRecommendation, float price,
				float rating, String availability) {
			super();
			this.id = id;
			this.name = name;
			this.colour = colour;
			this.size = size;
			this.genderRecommendation = genderRecommendation;
			this.price = price;
			this.rating = rating;
			this.availability = availability;
		}
		public Tshirt() {
			super();
		}
	    
	    


	}

