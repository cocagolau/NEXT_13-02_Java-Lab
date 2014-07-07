package util;

import junit.framework.TestCase;
import static util.Util.*;

public class CharacterTest extends TestCase {
	
	public void testWhitespace () {
		assertTrue (Character.isWhitespace(NEWLINE));
		assertTrue (Character.isWhitespace(NEWTAP));
		assertTrue (Character.isWhitespace(NEWSPACE));
	}
	
	public void testIdentifier() {
		assertFalse (Character.isJavaIdentifierPart('^'));		
	}

}
