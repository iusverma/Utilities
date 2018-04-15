package com.atlasian.online;

import java.util.Scanner;

/*h
A third-party provider uses a custom data format to exchange information with us. We
need to validate the input before we process it further. Character encoding is US-ASCII.
valid characters are all the characters between 0x20 (space) and 0x7E (~).

All fields are delimited by '|', and '~' is the escape character. There are only three
valid escape sequences
* '~| stands for '|'
* '~~' stands for '~'
* '~n' stands for new line

A line represents one record, it must start and end with '|'.
The first line contains the field names. The remaining lines contain the records. Names 
can't be empty and must be unique, there is not restriction on values.
If a record has more fields than there are names defined, the last name defined will be
used and '_#' will be appended to the field name where # is the number if extra records
starting at 1.

Here is a valid example
|name|address|~n|Patrick|patrick@test.com|pat@test.com|~n|Annie||annie@test.com|~n

This represent following data:
______________________________________________________________
|	name			|	address				|	address_1		|
|____________________________________________________________|
|	Patrick 		|	patrick@test.com		|	pat@test.com		|
|____________________________________________________________|
|	Annie 		|						|	annie@test.com	|
|____________________________________________________________|

Valid input should output statistics about the data: number of records, number of fields,
number of empty values and number of the last field. For the given example, following 
output is expected: "2:3:1:address_1"
Invalid input such as '~~~~' should outout the following message "0:0:0:format_error"

You have to write a validate function which verifies the input string conforms to the
requirements and generate wither the expected output or the error message.

*/
public class ParseRecords {
	public static void main(String...args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();

		if (!isValid(input)) {
			System.out.println("0:0:0:format_error");
		}
		// Spliting rows
		String[] records = input.split("~n");
		// Splitting fields
		String[][] data = new String[records.length][];
		int maxDataSize = 0; // it will store number of records
		int emptySpace = 0; // it will hold empty fields in records
		for (int i = 0; i < records.length; i++) {
			// removing the first '|' from each row
			records[i] = records[i].substring(1, records[i].length() - 1);
			data[i] = records[i].split("\\|");
			if (data[i].length > maxDataSize)
				maxDataSize = data[i].length;
		}

		for (int i = 0; i < records.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				System.out.println("' " + data[i][j] + " '");
				if (data[i][j].isEmpty())
					emptySpace++;
			}
		}

		formatOutput(data, maxDataSize, emptySpace);
		scan.close();
	}

	private static void formatOutput(String[][] data, int numberOfFields, int numberOfEmptyValues) {
		String numberOfRecords = "";
		String lastFieldName = "";
		String result = "";

		numberOfRecords = Integer.toString(data.length - 1);
		result = numberOfRecords + ":" + numberOfFields + ":" + numberOfEmptyValues + ":";

		int numberOfHeaders = numberOfFields - data[0].length;
		lastFieldName = data[0][data[0].length - 1] + "_" + numberOfHeaders;

		result += lastFieldName;
		System.out.println(result);
	}

	private static boolean isValid(String input) {
		/*
		 * For validation will try to find out all instance of '~ + one character' and
		 * if i find any thing other than ~, n or | will return false
		 */
		return true;
	}
}
