package org.unitconverter.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.unitconverter.CONFIG;
import org.unitconverter.Converter;

public class TestAll {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		String[] output = Converter.getUnitsAppropriated(CONFIG.Units.LENGTH);
		for(int i = 0; i<output.length; i++){
			System.out.println(output[i]);
		}
		
		Converter conv = new Converter();
		System.out.println(conv.convert(250, "cm", "m"));
	}

}
