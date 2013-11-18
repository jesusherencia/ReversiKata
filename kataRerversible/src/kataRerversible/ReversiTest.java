package kataRerversible;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ReversiTest {

	@Test
	public void test() {
	String[] input={
			"........",
			"........",
			"........",
			"...BW...",
			"...WB...",
			"........",
			"........",
			"........",
			"B"
	};
	String[] output={
			"........",
			"........",
			"....O...",
			"...BWO..",
			"..OWB...",
			"...O....",
			"........",
			"........",
			"B"
			};
	
	assertEquals(output, new Reversi(input).afficherResultat());
	}
	
@Test
public void TestWhite(){
	String[] input={
			"........",
			"........",
			"....B...",
			"...BB...",
			"...WB...",
			"........",
			"........",
			"........",
			"W"
	};
	String[] output={
			"........",
			"........",
			"...OBO..",
			"...BB...",
			"...WBO..",
			"........",
			"........",
			"........",
			"W"
			};
	assertEquals(output, new Reversi(input).afficherResultat());
}

}
