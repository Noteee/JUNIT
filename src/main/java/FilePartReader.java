import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by lugos on 2017. 04. 19..
 */
public class FilePartReader
{
	private String filePath;
	private Integer fromLine;
	private Integer toLine;

	public FilePartReader(String filePath, int fromLine, int toLine) throws IllegalArgumentException
	{
		this.filePath = filePath;
		if (toLine < fromLine || fromLine < 1)
		{
			throw new IllegalArgumentException();
		}
		this.fromLine = fromLine;
		this.toLine = toLine;

	}

	private String read() throws IOException
	{
		return new String(Files.readAllBytes(Paths.get(filePath)));
	}

	public String readLines() throws IOException
	{
		String input = read();
		String[] lines = input.split("\n");
		String stringLines = "";
		for (int i = 0; i < lines.length; i++)
		{
			if (i >= fromLine && i <= toLine)
			{
				stringLines = lines[i];
			}
		}
		System.out.println(input);
		return stringLines;
	}


}
