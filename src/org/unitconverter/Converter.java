/**
 * 
 */
package org.unitconverter;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
	private static List<String> length =  Arrays.asList("m", "mm", "cm", "km");

	private static List<String> mass =  Arrays.asList("kg", "g", "mg", "t");
	
	private static List<String> capacity =  Arrays.asList("m³", "cm³", "dm³", "mm³", "L", "mL","cL");
	
	private static List<String> area =Arrays.asList("m²", "cm²", "dm³", "mm³", "ha");
	
	private static List<String> speed =Arrays.asList("m/s", "km/h", "km/s", "m/h");
	
	private static List<String> force=Arrays.asList("N", "kN", "MN");
	
	private static List<String> current =Arrays.asList("A", "mA", "kA");
	
	private static List<String> tension =Arrays.asList("V", "mV", "kV");
	
	private static List<String> power =Arrays.asList("W", "mW",
			"MW", "kW");
	
	private static List<String> energy =Arrays.asList("J", "kJ", "Nm");

	
	
	public static double convert(double myFromValue, String myFromUnit,  String myToUnit){
		return Amount.valueOf(myFromValue, Unit.valueOf(myFromUnit)).to(Unit.valueOf(myToUnit)).getMaximumValue();
	}
	
	
	public static String[] getUnitsAppropriated(CONFIG.Units myUnits){
		String[] a = {};
		
		if(myUnits.equals(CONFIG.Units.LENGTH))
		{
			return length.toArray(a);
		}
		if(myUnits.equals(CONFIG.Units.MASS))
		{
			return mass.toArray(a);
		}
		if(myUnits.equals(CONFIG.Units.CAPACITY))
		{
			return capacity.toArray(a);
		}
		if(myUnits.equals(CONFIG.Units.AREA))
		{
			return area.toArray(a);
		}

		return concatAll(length.toArray(a), mass.toArray(a), capacity.toArray(a), area.toArray(a), force.toArray(a), current.toArray(a),
				tension.toArray(a), energy.toArray(a), power.toArray(a), speed.toArray(a));
	}
	
	public static String[] getConvertableUnits(String myUnit){
		String[] a = {};
		if(length.contains(myUnit))
			return  length.toArray(a);
		if(mass.contains(myUnit))
			return mass.toArray(a);
		if(capacity.contains(myUnit))
			return capacity.toArray(a);
		if(area.contains(myUnit))
			return area.toArray(a);
		if(speed.contains(myUnit))
			return speed.toArray(a);
		if(force.contains(myUnit))
			return force.toArray(a);
		if(current.contains(myUnit))
			return current.toArray(a);
		if(tension.contains(myUnit))
			return tension.toArray(a);
		if(energy.contains(myUnit))
			return energy.toArray(a);
		return power.toArray(a);
	}
	
	
	
	
	private static <T> T[] concatAll(T[] first, T[]... rest) {
		  int totalLength = first.length;
		  for (T[] array : rest) {
		    totalLength += array.length;
		  }
		  T[] result = Arrays.copyOf(first, totalLength);
		  int offset = first.length;
		  for (T[] array : rest) {
		    System.arraycopy(array, 0, result, offset, array.length);
		    offset += array.length;
		  }
		  return result;
		}


	
}
