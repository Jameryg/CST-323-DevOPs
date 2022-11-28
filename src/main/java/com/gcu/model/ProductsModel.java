package com.gcu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

public class ProductsModel 
{
	// Class variables 
	@NotNull(message="Image must be a .jpg.")
	@Size(min=2, max=50, message="Image must be a .jpg.")
	private String jpgImage;
	
	@NotNull(message="Tape Measure Length is a required field.")
	@Positive
	private float tapeMeasureLength;
	
	@NotNull(message="Tape Measure Measurement Unit (Ex: Imperial/Metric Systems) is a required field.")
	@Size(min=1, max=20, message="Tape Measure Measurement Unit must be identified.")
	private String tMMU;
	
	@NotNull(message="Tape Measure weight is a required field.")
	@Positive
	//@Size(min=6, max=24, message="Tape Measure weight must be identified.")
	private float tapeWeight;
	
	@NotNull(message="Tape measure description is a required field.")
	@Size(min=1, max=100, message="Tape measure must have a description.")
	private String tapeDescription;
	
	/**
	 * @return the jpgImage
	 */
	public String getJpgImage() 
	{
		return jpgImage;
	}
	
	/**
	 * @param jpgImage the jpgImage to set
	 */
	public void setJpgImage(String jpgImage)
	{
		this.jpgImage = jpgImage;
	}
	
	/** 
	 * @return the tapeMeasureLength
	 */
	public float getTapeMeasureLength() 
	{
		return tapeMeasureLength;
	}
	
	/**
	 * @param lastName the tapeMeasureLength to set 
	 */
	public void setTapeMeasureLength(float tapeMeasureLength) 
	{
		this.tapeMeasureLength = tapeMeasureLength;
	}
	
	/**
	 * @return the tMMU
	 */
	public String getTMMU() 
	{
		return tMMU;
	}
	
	/**
	 * @param username the tMMU to set 
	 */
	public void setTMMU(String tMMU) 
	{
		this.tMMU = tMMU;
	}
	
	/**
	 * @return the tapeWeight
	 */
	public float getTapeWeight() 
	{
		return tapeWeight;
	}
	
	/**
	 * @param tapeWeight the tapeWeight to set
	 */
	public void setTapeWeight(float tapeWeight)
	{
		this.tapeWeight = tapeWeight;
	}
	
	/**
	 * @return the emailAddress 
	 */
	public String getTapeDescription() 
	{
		return tapeDescription;
	}
	
	/**
	 * @param tapeDescription the tapeDescription to set
	 */
	
	public void setTapeDescription(String tapeDescription)
	{
		this.tapeDescription = tapeDescription;
	}
	
	public ProductsModel(String jpgImage, float tapeMeasureLength, String tMMU, float tapeWeight, String tapeDescription)
	{
		this.jpgImage = jpgImage;
		this.tapeMeasureLength = tapeMeasureLength;
		this.tMMU = tMMU;
		this.tapeWeight = tapeWeight;
		this.tapeDescription = tapeDescription;
	}
	
	public ProductsModel()
	{
		
	}
}