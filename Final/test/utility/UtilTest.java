package utility;

import java.util.List;

import map.Region;
import junit.framework.TestCase;

public class UtilTest extends TestCase{

	
	public void testRegion () {
		assertEquals (Region.Name.Seoul, Util.Region("Seoul"));
		assertEquals (Region.Name.Asan, Util.Region("Asan"));
		assertEquals (Region.Name.Chuncheon, Util.Region("Chuncheon"));
		assertEquals (Region.Name.Deajeon, Util.Region("Deajeon"));
		assertEquals (Region.Name.Wonju, Util.Region("Wonju"));
		assertEquals (Region.Name.Gwangju, Util.Region("Gwangju"));
		assertEquals (Region.Name.Kyungju, Util.Region("Kyungju"));
		assertEquals (null, Util.Region("seoul"));
		
		
		assertEquals ("Seoul", Util.Region(Region.Name.Seoul));
		assertEquals ("Asan", Util.Region(Region.Name.Asan));
		assertEquals ("Chuncheon", Util.Region(Region.Name.Chuncheon));
		assertEquals ("Deajeon", Util.Region(Region.Name.Deajeon));
		assertEquals ("Wonju", Util.Region(Region.Name.Wonju));
		assertEquals ("Gwangju", Util.Region(Region.Name.Gwangju));
		assertEquals ("Kyungju", Util.Region(Region.Name.Kyungju));
	}
	
	public void testRandomizeTo() {
		List<Integer> randomNumbers;
		randomNumbers = Util.randomizeTo(5, 3);
		assertEquals(5, randomNumbers.size());
	}
}
