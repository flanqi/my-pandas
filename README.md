# MyPandas
MyPandas is a Java module that acts like the pandas library with basic dataframe operations.

## Operations 
MyPandas supports the following operations corresponding to pandas operations:
- `readCSV`: similar as pandas.read_csv()
- `writeCSV`: similar as pandas.DataFrame.to_csv()
- `concat`: similar as pandas.concat()

MyDataFrame supports the following dataframe operations similar to pandas.DataFrame:
- `head`: similar as pandas.DataFrame.head()
- `tail`: similar as pandas.DataFrame.tail()
- `dType`: simlar as pandas.DataFrame.dtypes
- `loc`: similar as pandas.DataFrame.iloc or pandas.DataFrame.loc depending on type of inputs
- `filter`: filter rows based on conditions
- `slice`: slice certain column(s) based on conditions
- `sort`: similar as pandas.DataFrame.sort_values()
- `getMin`/`getMax`: simlar as pandas.DataFrame.min() or pandas.DataFrame.max()

## Usage

Under the root directory, there are two sample datasets (ak.txt and al.txt) for testing. The module is built for datasets of similar formats, although it can be generalized in a way that be used for all types of datasets.

```java
// Initialize dataframe
MyDataFrame df1 = readCSV("ak.txt");
MyDataFrame df2 = readCSV("al.txt");

MyDataFrame df_test = df1.head(5); # get first 5 observations of df1
// perform other operations as you want :))
// see more examples in src/classes/MyDataFrame.java and tests/
```
