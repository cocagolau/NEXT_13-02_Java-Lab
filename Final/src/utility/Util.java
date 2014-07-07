package utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import map.Region;

public class Util {

	public static Region.Name Region(String regionName) {
	
		if (regionName.equals("Seoul"))
			return Region.Name.Seoul;
		else if (regionName.equals("Asan"))
			return Region.Name.Asan;
		else if (regionName.equals("Chuncheon"))
			return Region.Name.Chuncheon;
		else if (regionName.equals("Deajeon"))
			return Region.Name.Deajeon;
		else if (regionName.equals("Wonju"))
			return Region.Name.Wonju;
		else if (regionName.equals("Gwangju"))
			return Region.Name.Gwangju;
		else if (regionName.equals("Kyungju"))
			return Region.Name.Kyungju;
		else
			return null; // ¾î¶ßÄ«Áö?
	}
	
	public static String Region(Region.Name region) {
		
		if (region.equals(Region.Name.Seoul))
			return "Seoul";
		else if (region.equals(Region.Name.Asan))
			return "Asan";
		else if (region.equals(Region.Name.Chuncheon))
			return "Chuncheon";
		else if (region.equals(Region.Name.Deajeon))
			return "Deajeon";
		else if (region.equals(Region.Name.Wonju))
			return "Wonju";
		else if (region.equals(Region.Name.Gwangju))
			return "Gwangju";
		else if (region.equals(Region.Name.Kyungju))
			return "Kyungju";
		else
			return null; // ¾î¶ßÄ«Áö?
	}
	
	public static List<Integer> randomizeTo (int lineSize, int numberOfStaff) {
		List<Integer> randomNumbers = new ArrayList<Integer>();
		Random seed = new Random();
		Random random;
	
		for (int i=0; i<lineSize; i++) {
			random = new Random(seed.nextLong());
			randomNumbers.add(random.nextInt(numberOfStaff));
		}
		return randomNumbers;
	}

}
