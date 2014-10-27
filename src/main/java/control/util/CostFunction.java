package control.util;

public class CostFunction {

	public static float calculate(float distance, float category, float weight, boolean express){
		return category * distance * weight;
	}
}
