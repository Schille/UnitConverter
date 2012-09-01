/**
 * 
 */
package org.unitconverter;



import java.util.ArrayList;
import java.util.Set;

import javax.measure.converter.UnitConverter;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Volume;
import javax.measure.unit.BaseUnit;
import javax.measure.unit.Dimension;
import javax.measure.unit.NonSI;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

import org.jscience.physics.amount.Amount;

/**
 * @author Michael Schilonka
 *
 */
public class Converter {
	
	public static double convert(double myFromValue, String myFromUnit,  String myToUnit){
		return Amount.valueOf(myFromValue, Unit.valueOf(myFromUnit)).to(Unit.valueOf(myToUnit)).getMaximumValue();
	}
	
	
	public static String[] getUnitsAppropriated(CONFIG.Units myUnits){
		ArrayList<String> result = new ArrayList<String>();

	

		
		if(myUnits.equals(CONFIG.Units.LENGTH) || myUnits.equals(CONFIG.Units.ALL))
		{
			result.add("m");
			result.add("mm");
			result.add("cm");
			result.add("km");
		}
		if(myUnits.equals(CONFIG.Units.MASS) || myUnits.equals(CONFIG.Units.ALL))
		{
			result.add("kg");
			result.add("g");
			result.add("mg");
			result.add("t");
		}
		if(myUnits.equals(CONFIG.Units.CAPACITY) || myUnits.equals(CONFIG.Units.ALL))
		{
			result.add("m³");
			result.add("cm³");
			result.add("dm³");
			result.add("mm³");
			result.add("l");
			result.add("ml");
			result.add("cl");
		}
			

		String[] a = {};
		return result.toArray(a);
	}

	
}
