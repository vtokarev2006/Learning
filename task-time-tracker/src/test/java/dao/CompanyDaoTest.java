package dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import model.Company;

import org.junit.Test;

public class CompanyDaoTest extends AbstractDaoForTesting {

	@Test
	public void testFind() throws Exception {

		logger.debug("\nSTARTED testFind()\n");
		List<Company> allItems = companyDao.findAll();
		assertTrue(allItems.size() > 0);
		// get the first item in the list
		Company c1 = allItems.get(0);
		int id = c1.getId();
		Company c2 = companyDao.find(id);
		assertTrue(c1.equals(c2));
		logger.debug("\nFINISHED testFind()\n");
	}

	@Test
	public void testFindAll() throws Exception {
		logger.debug("\nSTARTED testFindAll()\n");
		int rowCount = countRowsInTable("company");
		if (rowCount > 0) {
			List<Company> allItems = companyDao.findAll();
			assertTrue(
					"Company.findAll list not equal to row count of table ttt_company",
					rowCount == allItems.size());
		} else {
			throw new IllegalStateException(
					"INVALID TESTING SCENARIO: Company table is empty");
		}
		logger.debug("\nFINISHED testFindAll()\n");
	}

}
