import java.io.IOException;
import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class TestSuit
{
	@Rule
	public final ExpectedException exException = ExpectedException.none();


	@Test
	public void testFilePartReaderConstructor()
	{
		exException.expect(IllegalArgumentException.class);
		FilePartReader fpr = new FilePartReader("src/main/java/daninak.txt", 0, 1);
	}

	@Test
	public void testReadLines() throws IOException
	{
		FilePartReader fpr = new FilePartReader("src/main/java/daninak.txt", 1, 1);
		String result = fpr.readLines();

		assertEquals("DANI EGYY BUZI2 ", result);
	}

	private void assertEquals(String s, String result)
	{
	}

	@Test
	public void testWordsByABC() throws IOException
	{
		class MockedReader extends FilePartReader
		{

			public MockedReader(String filePath, Integer fromLine, Integer toLine)
			{
				super(filePath, fromLine, toLine);
			}

			@Override
			public String readLines() throws IOException
			{
				return "shit on shitterino";
			}
		}
		WordAnalyzer fwa = new WordAnalyzer(new MockedReader("zhtrd", 1, 2));
		ArrayList result = fwa.wordsByABC();
		String resultString = "";
		for (int i = 0; i < result.size(); i++)
		{
			resultString += result.get(i);
		}
		String goodResult = "shitonshitterino";
		assertEquals(goodResult, resultString);
	}


	@Test
	public void testwordsContainingSubString() throws IOException
	{
		class MockedReader extends FilePartReader
		{

			public MockedReader(String filePath, Integer fromLine, Integer toLine)
			{
				super(filePath, fromLine, toLine);
			}

			@Override
			public String readLines() throws IOException
			{
				return "shit on shitterino";
			}
		}
		WordAnalyzer fwa = new WordAnalyzer(new MockedReader("gjjmg", 1, 2));
		ArrayList result = fwa.wordsContainingSubString("é");
		String resultString = "";
		for (int i = 0; i < result.size(); i++)
		{
			resultString += result.get(i);
		}

		String goodResult = "shit";
		assertEquals(goodResult, resultString);
	}
}
