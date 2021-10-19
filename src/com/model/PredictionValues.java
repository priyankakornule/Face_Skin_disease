package com.model;

import java.util.ArrayList;
import java.util.List;

public class PredictionValues {

	public static List<PredictionValues> predictions = new ArrayList<PredictionValues>();
	String Predicted;

	String actual;
	String totalPredicted;
	String crorrectPredicted;
	public static List<PredictionValues> getPredictions() {
		return predictions;
	}

	public static void setPredictions(List<PredictionValues> predictions) {
		PredictionValues.predictions = predictions;
	}

	public String getPredicted() {
		return Predicted;
	}

	public void setPredicted(String predicted) {
		Predicted = predicted;
	}

	public String getActual() {
		return actual;
	}

	public void setActual(String actual) {
		this.actual = actual;
	}

	public String getTotalPredicted() {
		return totalPredicted;
	}

	public void setTotalPredicted(String totalPredicted) {
		this.totalPredicted = totalPredicted;
	}

	public String getCrorrectPredicted() {
		return crorrectPredicted;
	}

	public void setCrorrectPredicted(String crorrectPredicted) {
		this.crorrectPredicted = crorrectPredicted;
	}

}
