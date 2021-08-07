package tests;

import static org.junit.jupiter.api.Assertions.*;
import classes.MyDataFrame;
import classes.MyPandas;
import java.io.FileNotFoundException;

class MyDataFrameTest {

    @org.junit.jupiter.api.Test
    void testHead() throws FileNotFoundException {
        String r1 = "";
        String r2 = "";

        MyDataFrame df;
        MyDataFrame df2;
        df = MyPandas.readCSV("ak.txt");
        df2 = df.head(5);

        for(int i = 0; i < 5; i++) {
            r1 += df.state.get(i) + ", " + df.gender.get(i) + ", " + df.year.get(i) + ", " + df.name.get(i) + ", " + df.count.get(i);
            r2 += df2.state.get(i) + ", " + df.gender.get(i) + ", " + df.year.get(i) + ", " + df.name.get(i) + ", " + df.count.get(i);
        }

        assert(r1.equals(r2));

    }

    @org.junit.jupiter.api.Test
    void testTail() throws FileNotFoundException {
        String r1 = "";
        String r2 = "";

        MyDataFrame df;
        MyDataFrame df2;
        df = MyPandas.readCSV("ak.txt");
        df2 = MyPandas.readCSV("ak.txt").tail(5);

        for(int i = 0; i < 5; i++) {
            int j = df.state.toArray().length;
            r1 += df.state.get(j-5+i) + ", " + df.gender.get(j-5+i) + ", " + df.year.get(j-5+i) + ", " + df.name.get(j-5+i) + ", " + df.count.get(j-5+i);
            r2 += df2.state.get(i) + ", " + df2.gender.get(i) + ", " + df2.year.get(i) + ", " + df2.name.get(i) + ", " + df2.count.get(i);
        }

        assert(r1.equals(r2));

    }

    @org.junit.jupiter.api.Test
    void dType() throws FileNotFoundException {
        MyDataFrame df  = MyPandas.readCSV("ak.txt");

        assertTrue(df.dType(0).equals("String"));
    }

    @org.junit.jupiter.api.Test
    void testDType() throws FileNotFoundException {
        MyDataFrame df  = MyPandas.readCSV("ak.txt");

        assertTrue(df.dType("year").equals("Integer"));
    }

    @org.junit.jupiter.api.Test
    void testSlice1() throws FileNotFoundException {
        MyDataFrame df = MyPandas.readCSV("ak.txt");
        MyPandas.writeCSV(df.slice(2), "slice1_result.txt");

        assertTrue(TestSupport.compareFiles("test_slice1.csv", "slice1_result.txt"));

    }

    @org.junit.jupiter.api.Test
    void testSlice2() throws FileNotFoundException {
        MyDataFrame df = MyPandas.readCSV("ak.txt");
        MyPandas.writeCSV(df.slice("name"), "slice2_result.txt");

        assertTrue(TestSupport.compareFiles("test_slice2.csv", "slice2_result.txt"));
    }

    @org.junit.jupiter.api.Test
    void testSlice3() throws FileNotFoundException {
        MyDataFrame df = MyPandas.readCSV("ak.txt");
        MyPandas.writeCSV(df.slice(new int[]{0, 1, 2}), "slice3_result.txt");

        assertTrue(TestSupport.compareFiles("test_slice3.csv", "slice3_result.txt"));
    }

    @org.junit.jupiter.api.Test
    void testSlice4() throws FileNotFoundException {
        MyDataFrame df = MyPandas.readCSV("ak.txt");
        MyPandas.writeCSV(df.slice(new String[]{"state", "year", "name", "count"}), "slice4_result.txt");

        assertTrue(TestSupport.compareFiles("test_slice4.csv", "slice4_result.txt"));

    }

    @org.junit.jupiter.api.Test
    void filter() throws FileNotFoundException {
        MyDataFrame df  = MyPandas.readCSV("test_data.txt");
        MyPandas.writeCSV(df.filter("state","=","AK"),"filter_result.txt");

        assertTrue(TestSupport.compareFiles("filter_answer.txt","filter_result.txt"));
    }

    @org.junit.jupiter.api.Test
    void testLoc1() throws FileNotFoundException {
        MyDataFrame df = MyPandas.readCSV("ak.txt");
        MyPandas.writeCSV(df.loc(100), "loc1_result.txt");

        assertTrue(TestSupport.compareFiles("test_loc1.csv", "loc1_result.txt"));
    }

    @org.junit.jupiter.api.Test
    void testLoc2() throws FileNotFoundException {
        MyDataFrame df = MyPandas.readCSV("ak.txt");
        MyPandas.writeCSV(df.loc("100"), "loc2_result.txt");

        assertTrue(TestSupport.compareFiles("test_loc2.csv", "loc2_result.txt"));
    }

    @org.junit.jupiter.api.Test
    void testLoc3() throws FileNotFoundException {
        MyDataFrame df = MyPandas.readCSV("ak.txt");
        MyPandas.writeCSV(df.loc(5, 10), "loc3_result.txt");

        assertTrue(TestSupport.compareFiles("test_loc3.csv", "loc3_result.txt"));
    }

    @org.junit.jupiter.api.Test
    void testLoc4() throws FileNotFoundException {
        MyDataFrame df = MyPandas.readCSV("ak.txt");
        MyPandas.writeCSV(df.loc("5", "10"), "loc4_result.txt");

        assertTrue(TestSupport.compareFiles("test_loc4.csv", "loc4_result.txt"));
    }

    @org.junit.jupiter.api.Test
    void sort() throws FileNotFoundException {
        MyDataFrame df  = MyPandas.readCSV("test_data.txt");
        MyPandas.writeCSV(df.sort(3),"sortByIndex_result.txt");

        assertTrue(TestSupport.compareFiles("sortByIndex_answer.txt","sortByIndex_result.txt"));
    }

    @org.junit.jupiter.api.Test
    void testSort() throws FileNotFoundException {
        MyDataFrame df  = MyPandas.readCSV("test_data.txt");
        MyPandas.writeCSV(df.sort("count"),"sortByName_result.txt");

        assertTrue(TestSupport.compareFiles("sortByName_answer.txt","sortByName_result.txt"));
    }

    @org.junit.jupiter.api.Test
    void getMin() throws FileNotFoundException {
        MyDataFrame df  = MyPandas.readCSV("test_data.txt");

        assertTrue((int)df.getMin(4)==5);
    }

    @org.junit.jupiter.api.Test
    void testGetMin() throws FileNotFoundException {
        MyDataFrame df  = MyPandas.readCSV("test_data.txt");
        String answer = (String) df.getMin("state");

        assertTrue(answer.equals("AK"));
    }

    @org.junit.jupiter.api.Test
    void getMax() throws FileNotFoundException {
        MyDataFrame df  = MyPandas.readCSV("test_data.txt");

        assertTrue((int)df.getMax(2)==1980);
    }

    @org.junit.jupiter.api.Test
    void testGetMax() throws FileNotFoundException {
        MyDataFrame df  = MyPandas.readCSV("test_data.txt");
        String answer = (String) df.getMax("name");

        assertTrue(answer.equals("Mary"));
    }
}