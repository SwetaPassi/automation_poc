package com.mint.qa.testcases;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.BatchGetValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.mint.qa.util.SheetsServiceUtil;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

public class GooogleIntegrationTest {

        public static Sheets sheetsService;
        public static String SPREADSHEET_ID = "1sILuxZUnyl_7-MlNThjt765oWshN3Xs-PPLfqYe4DhI";

        @BeforeClass
        public void setup() throws GeneralSecurityException, IOException {
            sheetsService = SheetsServiceUtil.getSheetsService();
        }


 //  @Test
    public class googleIntegrationTest {

       List<String> ranges = Arrays.asList("E1", "E4");
       BatchGetValuesResponse readResult;
       {
           try {
               readResult = sheetsService.spreadsheets().values()
                       .batchGet(SPREADSHEET_ID)
                       .setRanges(ranges)
                       .execute();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
       ValueRange Channel = readResult.getValueRanges().get(0);
       ValueRange Product = readResult.getValueRanges().get(1);

   }
}
