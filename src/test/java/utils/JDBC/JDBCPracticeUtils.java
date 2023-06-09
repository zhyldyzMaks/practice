package utils.JDBC;

import org.junit.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class JDBCPracticeUtils {

    public static void main(String[] args) {

        JDBCUtils.establishConnection();
        List<Map<String, Object>> regionData = JDBCUtils.executeQuery("select * from regions");
        System.out.println(regionData.get(2).get("REGION_NAME"));

        List<Map<String, Object>> countriesData = JDBCUtils.executeQuery("select * from countries");
        for (int i = 0; i < countriesData.size();i++){
            System.out.println(countriesData.get(i).get("COUNTRY_NAME"));

        }

        //test case: validate table 'regions' has 2 columns
        //test case: validate those column names are: REGION_ID and REGION_NAME


        int expectedColumnCount = 2;
        String[] expectedColumnNames = {"REGION_ID","REGION_NAME"};
        int actualColumnCount = regionData.get(0).size();
        String [] actualColumnNames = regionData.get(0).keySet().toArray(new String[0]);

        System.out.println(actualColumnCount);
        System.out.println(Arrays.toString(actualColumnNames));

        Assert.assertEquals("Column count is not matching", expectedColumnCount, actualColumnCount);

        for (int i = 0; i<expectedColumnNames.length;i++){
            Assert.assertEquals("Column names are not matching",
                    expectedColumnNames[i], actualColumnNames[i]);
        }

        JDBCUtils.closeConnection();
    }

}
