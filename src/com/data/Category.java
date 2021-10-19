package com.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Category {
	
	//Herpes_zoster_shingles,Hives,TEST;
	Herpes_zoster_shingles,Hives,Pemphigus_vulgaris,Staphylococcal_scalded_skin_syndrome,Stevens_Johnson_syndrome,Toxic_epidermal_necrolysis,Toxic_shock_syndrome,OTHER,TEST;
	/*Pemphigus_vulgaris,Staphylococcal_scalded_skin_syndrome,Stevens-Johnson_syndrome,Toxic_epidermal_necrolysis,Toxic_shock_syndrome*/
	
	
    // Store the categories as strings.
    public static List<Category> categories = new ArrayList<>(Arrays.asList(values()));
    
    /**
     * Returns the one of n index of a category label.
     */
    public static double[] categoryToOneOfN(final Category category) {
        double[] correctOutput = new double[categories.size()];
        //correctOutput[categories.indexOf(category)] = 1;
       //correctOutput[categories.indexOf(category)] = 5;
       correctOutput[categories.indexOf(category)] = 0;
        return correctOutput;
    }
};