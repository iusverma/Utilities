package dailly.practice.file.test;

import org.junit.jupiter.api.Test;

import dailly.practice.file.ConvertToSql;

class ConvertToSqlTest {

	@Test
	void test() {
		new ConvertToSql().convertCsvToSQL();
	}

}
