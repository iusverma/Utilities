package dailly.practice.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ConvertToSql {
	private static int counter = 1;
	private final String commaSeperator = ", ";
	private final String commitCommand = "commit;";
	private File inputFile;
	private FileInputStream fis;
	private BufferedReader br;
	private File fout;
	private FileOutputStream fos;
	private BufferedWriter bw; 

	private void init() {
		inputFile = new File("input.csv");
		try {
			fis = new FileInputStream(inputFile);
			br = new BufferedReader(new InputStreamReader(fis));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		fout = new File("insert.sql");
		try {
			fos = new FileOutputStream(fout);
			bw = new BufferedWriter(new OutputStreamWriter(fos));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void flush() {
		try {
			br.close();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void convertCsvToSQL() {
		init();
		try {
			String line;
			while (null != (line = br.readLine())) {
				writeToOutput(line);
			}
			bw.write(commitCommand);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		flush();
	}

	private void writeToOutput(final String line) {
		try {
			String sql = prepareInsertQuery(line);
			if(null != sql) {
				bw.write(sql);
				bw.newLine();
				
				counter++;
				if(counter%5==0) {
					bw.write(commitCommand);
					bw.newLine();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String prepareInsertQuery(final String line) {
		String SQL = "insert into TEMP_RAW_CUST_INFO (ID, CUST_BRANCH, CUST_SERIAL, ACC_BRANCH, ACC_SERIAL, ACC_SUFF, STATUS)";
		SQL += " values(" + counter + commaSeperator;

		StringTokenizer st1 = new StringTokenizer(line, ",");
		if(st1.countTokens()!=2) {
			// invalid tokens
			System.out.println("Line doesn't have either customer or account number or both.");
			return null;
		}
		String custDetails = st1.nextToken();
		StringTokenizer st2 = new StringTokenizer(custDetails,"-");
		if(st2.countTokens()!=2) {
			// invalid tokens
			System.out.println("Line doesn't have customer branch or serial or both.");
			return null;
		}
		SQL += Integer.parseInt(st2.nextToken()) + commaSeperator;
		SQL += Integer.parseInt(st2.nextToken()) + commaSeperator;
		
		String accDetails = st1.nextToken();
		StringTokenizer st3 = new StringTokenizer(accDetails,"-");
		if(st3.countTokens()!=3) {
			// invalid tokens
			System.out.println("Line doesn't have account branch or serial or suffix or all.");
			return null;
		}
		SQL += Integer.parseInt(st3.nextToken()) + commaSeperator;
		SQL += Integer.parseInt(st3.nextToken()) + commaSeperator;
		SQL += Integer.parseInt(st3.nextToken()) + commaSeperator;

		SQL += "'U');";
		return SQL;
	}

}
