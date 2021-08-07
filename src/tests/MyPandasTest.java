package tests;

import classes.MyDataFrame;
import classes.MyPandas;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class MyPandasTest {

    @Test
    void readCSV() throws FileNotFoundException {
        MyDataFrame df1  = MyPandas.readCSV("ak.txt");
        MyPandas.writeCSV(df1, "readcsv.txt");
        assertTrue(TestSupport.compareFiles("ak.txt", "readcsv.txt"));
    }

    @Test
    void writeCSV() throws FileNotFoundException {
        MyDataFrame df1  = MyPandas.readCSV("ak.txt");
        MyPandas.writeCSV(df1, "writecsv.txt");
        assertTrue(TestSupport.compareFiles("ak.txt", "writecsv.txt"));
    }

    @Test
    void concat() throws FileNotFoundException {
        MyDataFrame df1  = MyPandas.readCSV("test_data.txt");
        MyDataFrame df2  = MyPandas.readCSV("test_data.txt");

        MyPandas.writeCSV(MyPandas.concat(df1, df2), "concat_result.txt");

        assertTrue(TestSupport.compareFiles("concat_result.txt", "concat_answer.txt"));
    }
}