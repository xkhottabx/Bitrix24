package com.cybertek.tests;

import com.cybertek.utilities.DBType;
import org.junit.*;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static com.cybertek.utilities.DBUtility.*;

public class EmployeesDBTest {

    @Before
    public void setUp() throws SQLException {
        establishConnection(DBType.ORACLE);
    }

    @Test
    public void countTest() throws SQLException {
        int rowsCount = getRowsCount("SELECT * FROM EMPLOYEES WHERE JOB_ID='IT_PROG'");
        Assert.assertTrue(rowsCount > 0);
    }

    @Test
    public void nameTestByID() throws SQLException {
        List<Map<String, Object>> empData = runSQLQuery("SELECT FIRST_NAME, LAST_NAME, DEPARTMENT_ID FROM EMPLOYEES WHERE EMPLOYEE_ID>105");
        //Assert.assertEquals("David", empData.get(0).get("FIRST_NAME"));
       // Assert.assertEquals("Austin", empData.get(0).get("LAST_NAME"));
        Assert.assertEquals(new BigDecimal(60), empData.get(0).get("DEPARTMENT_ID"));

    }

    @After
    public void tearDown(){
        closeConnections();
    }
}
