package control.util;
/**
 * Contains the cost function to calculate cost
 *
 */
public class CostFunction {

	/**
	 * Current cost function for calculating cost. Can be changed when needed
	 * @param distance Distance between stations
	 * @param category Unit price(cost per 1kg per 1 km)
	 * @param weight Weight of parcel
	 * @param express If it's express delivery or not
	 * @return Cost
	 */
	public static float calculate(float distance, float category, float weight, boolean express){
		return category * distance * weight;
	}
}
