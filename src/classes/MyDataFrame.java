package classes;

import java.io.FileNotFoundException;
import java.util.*;

import static classes.MyPandas.*;

public class MyDataFrame {
    public ArrayList<String>  state;
    public ArrayList<String>  gender;
    public ArrayList<Integer> year;
    public ArrayList<String>  name;
    public ArrayList<Integer> count;

    public MyDataFrame (List<String> state, List<String> gender, List<Integer> year, List<String> name, List<Integer> count) {
        this.state  = (ArrayList<String>) state;
        this.gender = (ArrayList<String>) gender;
        this.year   = (ArrayList<Integer>) year;
        this.name   = (ArrayList<String>) name;
        this.count  = (ArrayList<Integer>) count;
    }

    // Head and Tail
    /**
     * @param n number of rows to return from top of data
     * @return classes.MyDataFrame object, filtered to top "n" rows
     */
    public MyDataFrame head(int n) {
        ArrayList<String> st  = new ArrayList<>(state.subList(0,  n));
        ArrayList<String> ge  = new ArrayList<>(gender.subList(0, n));
        ArrayList<Integer> yr = new ArrayList<>(year.subList(0,   n));
        ArrayList<String> nm  = new ArrayList<>(name.subList(0,   n));
        ArrayList<Integer> ct = new ArrayList<>(count.subList(0,  n));
        return new MyDataFrame(st, ge, yr, nm, ct);
    }

    /**
     * @param n number of rows to return from bottom of data
     * @return classes.MyDataFrame object, filtered to last "n" rows
     */
    public MyDataFrame tail(int n) {
        ArrayList<String> st  = new ArrayList<>(state.subList( (state.toArray().length  - n),  state.toArray().length));
        ArrayList<String> ge  = new ArrayList<>(gender.subList((gender.toArray().length - n), gender.toArray().length));
        ArrayList<Integer> yr = new ArrayList<>(year.subList(  (year.toArray().length   - n),   year.toArray().length));
        ArrayList<String> nm  = new ArrayList<>(name.subList(  (name.toArray().length   - n),   name.toArray().length));
        ArrayList<Integer> ct = new ArrayList<>(count.subList( (count.toArray().length  - n),  count.toArray().length));
        return new MyDataFrame(st, ge, yr, nm, ct);
    }

    // Data types
    /**
     * @param index numeric index of column for which the data type is desired
     * @return String indicating data type of the column selected by 'index'
     */
    public String dType(int index) {
        int counter = 0;
        int s = 0;
        int i = 0;

        ArrayList al = new ArrayList();

        if(index == 0) al = state;
        if(index == 1) al = gender;
        if(index == 2) al = year;
        if(index == 3) al = name;
        if(index == 4) al = count;

        for (Object o : al) {
            counter++;
            if (o instanceof String) {
                s++;
            } else if (o instanceof Integer) {
                i++;
            }
        }

        if(counter == s) return "String";
        if(counter == i) return "Integer";
        else return "String";

    }

    /**
     * @param col_name String name of column for which the data type is desired
     * @return String indicating data type of the column selected by 'col_name'
     */
    public String dType(String col_name) {
        int counter = 0;
        int s = 0;
        int i = 0;

        ArrayList al = new ArrayList();

        if(col_name == "state") al  = state;
        if(col_name == "gender") al = gender;
        if(col_name == "year") al   = year;
        if(col_name == "name") al   = name;
        if(col_name == "count") al  = count;

        for (Object o : al) {
            counter++;
            if (o instanceof String) {
                s++;
            } else if (o instanceof Integer) {
                i++;
            }
        }

        if(counter == s) return "String";
        if(counter == i) return "Integer";
        else return "String";

    }


    // Slicing
    /**
     * @param index numeric index of which column to select
     * @return  classes.MyDataFrame object, filtered to subset one column selected by 'index'
     */

    public MyDataFrame slice(int index) {
        ArrayList<String> st  = new ArrayList<>(state);
        ArrayList<String> ge  = new ArrayList<>(gender);
        ArrayList<Integer> yr = new ArrayList<>(year);
        ArrayList<String> nm  = new ArrayList<>(name);
        ArrayList<Integer> ct = new ArrayList<>(count);

        st.replaceAll(e -> null);
        ge.replaceAll(e -> null);
        Collections.fill(yr, null);
        nm.replaceAll(e -> null);
        Collections.fill(ct, null);

        if(index == 0) return new MyDataFrame(state, ge, yr, nm, ct);
        if(index == 1) return new MyDataFrame(st, gender, yr, nm, ct);
        if(index == 2) return new MyDataFrame(st, ge, year, nm, ct);
        if(index == 3) return new MyDataFrame(st, ge, yr, name, ct);
        if(index == 4) return new MyDataFrame(st, ge, yr, nm, count);
        else return new MyDataFrame(state, gender, year, name, count);
    }

    /**
     * @param col_name string indicating which column to select
     * @return  classes.MyDataFrame object, filtered to subset one column selected by 'col_name'
     */

    public MyDataFrame slice(String col_name) {
        ArrayList<String> st  = new ArrayList<>(state);
        ArrayList<String> ge  = new ArrayList<>(gender);
        ArrayList<Integer> yr = new ArrayList<>(year);
        ArrayList<String> nm  = new ArrayList<>(name);
        ArrayList<Integer> ct = new ArrayList<>(count);

        st.replaceAll(e -> null);
        ge.replaceAll(e -> null);
        Collections.fill(yr, null);
        nm.replaceAll(e -> null);
        Collections.fill(ct, null);

        if(col_name == "state")   return new MyDataFrame(state, ge, yr, nm, ct);
        if(col_name == "gender")  return new MyDataFrame(st, gender, yr, nm, ct);
        if(col_name == "year")    return new MyDataFrame(st, ge, year, nm, ct);
        if(col_name == "name")    return new MyDataFrame(st, ge, yr, name, ct);
        if(col_name == "count")   return new MyDataFrame(st, ge, yr, nm, count);
        else return new MyDataFrame(state, gender, year, name, count);
    }


    /**
     * @param indexArr an int[] array containing numeric indices of columns to select
     * @return  classes.MyDataFrame object, filtered to subset columns selected by indexArr indices
     */
    public MyDataFrame slice(int[] indexArr) {
        ArrayList<String> st  = new ArrayList<>(state);
        ArrayList<String> ge  = new ArrayList<>(gender);
        ArrayList<Integer> yr = new ArrayList<>(year);
        ArrayList<String> nm  = new ArrayList<>(name);
        ArrayList<Integer> ct = new ArrayList<>(count);

        if (Arrays.stream(indexArr).noneMatch(i -> i == 0)) st.replaceAll(e -> null);
        if (Arrays.stream(indexArr).noneMatch(i -> i == 1)) ge.replaceAll(e -> null);
        if (Arrays.stream(indexArr).noneMatch(i -> i == 2)) Collections.fill(yr, null);
        if (Arrays.stream(indexArr).noneMatch(i -> i == 3)) nm.replaceAll(e -> null);
        if (Arrays.stream(indexArr).noneMatch(i -> i == 4)) Collections.fill(ct, null);

        return new MyDataFrame(st, ge, yr, nm, ct);

    }

    /**
     * @param nameArr a String[] array containing strings of column names to select
     * @return  classes.MyDataFrame object, filtered to subset columns named in nameArr
     */

    public MyDataFrame slice(String[] nameArr) {
        ArrayList<String> st  = new ArrayList<>(state);
        ArrayList<String> ge  = new ArrayList<>(gender);
        ArrayList<Integer> yr = new ArrayList<>(year);
        ArrayList<String> nm  = new ArrayList<>(name);
        ArrayList<Integer> ct = new ArrayList<>(count);

        if (Arrays.stream(nameArr).noneMatch(i -> i == "state")) st.replaceAll(e -> null);
        if (Arrays.stream(nameArr).noneMatch(i -> i == "gender")) ge.replaceAll(e -> null);
        if (Arrays.stream(nameArr).noneMatch(i -> i == "year")) Collections.fill(yr, null);
        if (Arrays.stream(nameArr).noneMatch(i -> i == "name")) nm.replaceAll(e -> null);
        if (Arrays.stream(nameArr).noneMatch(i -> i == "count")) Collections.fill(ct, null);

        return new MyDataFrame(st, ge, yr, nm, ct);
    }

    // Filtering
    /**
     *
     * @param col column name
     * @param op <,> or =
     * @param o the cut-off value
     * @return  data filtered by applying �col op o�on classes.MyDataFrame object, e.g. �count > 10�,�state = �IL��.
     */
    public MyDataFrame filter(String col, String op, Object o) {
        ArrayList<String> state2 = new ArrayList<String>();
        ArrayList<String> gender2 = new ArrayList<String>();
        ArrayList<Integer> year2 = new ArrayList<Integer>();
        ArrayList<String> name2 = new ArrayList<String>();
        ArrayList<Integer> count2 = new ArrayList<Integer>();
        ArrayList<Integer> indexes = new ArrayList<Integer>();

        if(col.equals("state")) {
            // get indexes
            for(int i=0;i<this.state.size();i++) {
                String curr = this.state.get(i);
                String target = (String) o;

                if(c1(op,curr,target)) {
                    indexes.add(i);
                }
            }
        } else if (col.equals("gender")) {
            for(int i=0;i<this.gender.size();i++) {
                String curr = this.gender.get(i);
                String target = (String) o;

                if(c1(op,curr,target)) {
                    indexes.add(i);
                }
            }
        } else if (col.equals("year")) {
            for(int i=0;i<this.year.size();i++) {
                int curr = this.year.get(i);
                int target = (int) o;

                if(c2(op,curr,target)) {
                    indexes.add(i);
                }
            }
        } else if (col.equals("name")) {
            for(int i=0;i<this.name.size();i++) {
                String curr = this.name.get(i);
                String target = (String) o;

                if(c1(op,curr,target)) {
                    indexes.add(i);
                }
            }
        } else {
            for(int i=0;i<this.count.size();i++) {
                int curr = this.count.get(i);
                int target = (int) o;

                if(c2(op,curr,target)) {
                    indexes.add(i);
                }
            }
        }


        for(int i:indexes) {
            state2.add(this.state.get(i));
            gender2.add(this.gender.get(i));
            year2.add(this.year.get(i));
            name2.add(this.name.get(i));
            count2.add(this.count.get(i));
        }

        return new MyDataFrame(state2,gender2,year2,name2,count2);

    }

    // auxiliary function 1 - returns indexes after filtering
    private boolean c1(String op, String o1, String o2) {
        if(op.equals("=")) {
            return o1.equals(o2);
        } else if (op.equals("<")) {
            return o1.compareTo(o2)<0;
        } else {
            return o1.compareTo(o2)>0;
        }
    }

    // auxiliary function 2 - returns indexes after filtering
    private boolean c2(String op, int o1, int o2) {
        if(op.equals("=")) {
            return o1==o2;
        } else if (op.equals("<")) {
            return o1<o2;
        } else {
            return o1>o2;
        }
    }


    // Indexing
    /**
     *
     * @param index row number from which data will be returned
     * @return  data filtered to row 'index' until the last row of data
     */
    public MyDataFrame loc(int index) {
        ArrayList<String> st  = new ArrayList<>(state.subList( index,  state.toArray().length));
        ArrayList<String> ge  = new ArrayList<>(gender.subList(index, gender.toArray().length));
        ArrayList<Integer> yr = new ArrayList<>(year.subList(  index,   year.toArray().length));
        ArrayList<String> nm  = new ArrayList<>(name.subList(  index,   name.toArray().length));
        ArrayList<Integer> ct = new ArrayList<>(count.subList( index,  count.toArray().length));
        return new MyDataFrame(st, ge, yr, nm, ct);
    }

    /**
     *
     * @param label string value of row number from which data will be returned
     * @return  data filtered to row 'label' until the last row of data
     */
    public MyDataFrame loc(String label) {
        ArrayList<String> st  = new ArrayList<>(state.subList( Integer.parseInt(label),  state.toArray().length));
        ArrayList<String> ge  = new ArrayList<>(gender.subList(Integer.parseInt(label), gender.toArray().length));
        ArrayList<Integer> yr = new ArrayList<>(year.subList(  Integer.parseInt(label),   year.toArray().length));
        ArrayList<String> nm  = new ArrayList<>(name.subList(  Integer.parseInt(label),   name.toArray().length));
        ArrayList<Integer> ct = new ArrayList<>(count.subList( Integer.parseInt(label),  count.toArray().length));
        return new MyDataFrame(st, ge, yr, nm, ct);
    }


    /**
     *
     * @param from integer value of row number from which data will be returned
     * @param to integer value of row number to which data will be returned
     * @return  data filtered from row 'from' until row 'to'
     */
    public MyDataFrame loc(int from, int to) {
        ArrayList<String> st  = new ArrayList<>(state.subList( from,  to));
        ArrayList<String> ge  = new ArrayList<>(gender.subList(from,  to));
        ArrayList<Integer> yr = new ArrayList<>(year.subList(  from,  to));
        ArrayList<String> nm  = new ArrayList<>(name.subList(  from,  to));
        ArrayList<Integer> ct = new ArrayList<>(count.subList( from,  to));
        return new MyDataFrame(st, ge, yr, nm, ct);
    }

    /**
     *
     * @param from string value of row number from which data will be returned
     * @param to string value of row number to which data will be returned
     * @return  data filtered from row 'from' until row 'to'
     */
    public MyDataFrame loc(String from, String to) {
        ArrayList<String> st  = new ArrayList<>(state.subList( Integer.parseInt(from),  Integer.parseInt(to)));
        ArrayList<String> ge  = new ArrayList<>(gender.subList(Integer.parseInt(from),  Integer.parseInt(to)));
        ArrayList<Integer> yr = new ArrayList<>(year.subList(  Integer.parseInt(from),  Integer.parseInt(to)));
        ArrayList<String> nm  = new ArrayList<>(name.subList(  Integer.parseInt(from),  Integer.parseInt(to)));
        ArrayList<Integer> ct = new ArrayList<>(count.subList( Integer.parseInt(from),  Integer.parseInt(to)));
        return new MyDataFrame(st, ge, yr, nm, ct);
    }

    // Sorting
    /**
     *
     * @param index column index
     * @return the data sorted (ascending order) by the column specified by index.
     */
    public MyDataFrame sort(int index) {
        ArrayList<String> state2 = new ArrayList<String>();
        ArrayList<String> gender2 = new ArrayList<String>();
        ArrayList<Integer> year2 = new ArrayList<Integer>();
        ArrayList<String> name2 = new ArrayList<String>();
        ArrayList<Integer> count2 = new ArrayList<Integer>();

        if(index==0) {
            state2 = new ArrayList<String>(this.state);
            ArrayIndexComparatorStr comparator = new ArrayIndexComparatorStr(state2);
            Integer[] indexes = comparator.createIndexArray();
            Arrays.sort(indexes, comparator);
            Collections.sort(state2);

            for(int i:indexes) {
                gender2.add(this.gender.get(i));
                year2.add(this.year.get(i));
                name2.add(this.name.get(i));
                count2.add(this.count.get(i));
            }
        } else if (index==1) {
            gender2 = new ArrayList<String>(this.gender);
            ArrayIndexComparatorStr comparator = new ArrayIndexComparatorStr(gender2);
            Integer[] indexes = comparator.createIndexArray();
            Arrays.sort(indexes, comparator);
            Collections.sort(gender2);

            for(int i:indexes) {
                state2.add(this.state.get(i));
                year2.add(this.year.get(i));
                name2.add(this.name.get(i));
                count2.add(this.count.get(i));
            }
        } else if (index==2) {
            year2 = new ArrayList<Integer>(this.year);
            ArrayIndexComparatorInt comparator = new ArrayIndexComparatorInt(year2);
            Integer[] indexes = comparator.createIndexArray();
            Arrays.sort(indexes, comparator);
            Collections.sort(year2);

            for(int i:indexes) {
                state2.add(this.state.get(i));
                gender2.add(this.gender.get(i));
                name2.add(this.name.get(i));
                count2.add(this.count.get(i));
            }
        } else if (index==3) {
            name2 = new ArrayList<String>(this.name);
            ArrayIndexComparatorStr comparator = new ArrayIndexComparatorStr(name2);
            Integer[] indexes = comparator.createIndexArray();
            Arrays.sort(indexes, comparator);
            Collections.sort(name2);

            for(int i:indexes) {
                state2.add(this.state.get(i));
                gender2.add(this.gender.get(i));
                year2.add(this.year.get(i));
                count2.add(this.count.get(i));
            }
        } else {
            count2 = new ArrayList<Integer>(this.count);
            ArrayIndexComparatorInt comparator = new ArrayIndexComparatorInt(count2);
            Integer[] indexes = comparator.createIndexArray();
            Arrays.sort(indexes, comparator);
            Collections.sort(count2);

            for(int i:indexes) {
                state2.add(this.state.get(i));
                gender2.add(this.gender.get(i));
                name2.add(this.name.get(i));
                year2.add(this.year.get(i));
            }
        }

        return new MyDataFrame(state2,gender2,year2,name2,count2);
    }

    /**
     *
     * @param name column name
     * @return the data sorted (ascending order) by the column specified by name.
     */
    public MyDataFrame sort(String name) {
        ArrayList<String> state2 = new ArrayList<String>();
        ArrayList<String> gender2 = new ArrayList<String>();
        ArrayList<Integer> year2 = new ArrayList<Integer>();
        ArrayList<String> name2 = new ArrayList<String>();
        ArrayList<Integer> count2 = new ArrayList<Integer>();

        if(name.equals("state")) {
            state2 = new ArrayList<String>(this.state);
            ArrayIndexComparatorStr comparator = new ArrayIndexComparatorStr(state2);
            Integer[] indexes = comparator.createIndexArray();
            Arrays.sort(indexes, comparator);
            Collections.sort(state2);

            for(int i:indexes) {
                gender2.add(this.gender.get(i));
                year2.add(this.year.get(i));
                name2.add(this.name.get(i));
                count2.add(this.count.get(i));
            }
        } else if (name.equals("gender")) {
            gender2 = new ArrayList<String>(this.gender);
            ArrayIndexComparatorStr comparator = new ArrayIndexComparatorStr(gender2);
            Integer[] indexes = comparator.createIndexArray();
            Arrays.sort(indexes, comparator);
            Collections.sort(gender2);

            for(int i:indexes) {
                state2.add(this.state.get(i));
                year2.add(this.year.get(i));
                name2.add(this.name.get(i));
                count2.add(this.count.get(i));
            }
        } else if (name.equals("year")) {
            year2 = new ArrayList<Integer>(this.year);
            ArrayIndexComparatorInt comparator = new ArrayIndexComparatorInt(year2);
            Integer[] indexes = comparator.createIndexArray();
            Arrays.sort(indexes, comparator);
            Collections.sort(year2);

            for(int i:indexes) {
                state2.add(this.state.get(i));
                gender2.add(this.gender.get(i));
                name2.add(this.name.get(i));
                count2.add(this.count.get(i));
            }
        } else if (name.equals("name")) {
            name2 = new ArrayList<String>(this.name);
            ArrayIndexComparatorStr comparator = new ArrayIndexComparatorStr(name2);
            Integer[] indexes = comparator.createIndexArray();
            Arrays.sort(indexes, comparator);
            Collections.sort(name2);

            for(int i:indexes) {
                state2.add(this.state.get(i));
                gender2.add(this.gender.get(i));
                year2.add(this.year.get(i));
                count2.add(this.count.get(i));
            }
        } else {
            count2 = new ArrayList<Integer>(this.count);
            ArrayIndexComparatorInt comparator = new ArrayIndexComparatorInt(count2);
            Integer[] indexes = comparator.createIndexArray();
            Arrays.sort(indexes, comparator);
            Collections.sort(count2);

            for(int i:indexes) {
                state2.add(this.state.get(i));
                gender2.add(this.gender.get(i));
                name2.add(this.name.get(i));
                year2.add(this.year.get(i));
            }
        }

        return new MyDataFrame(state2,gender2,year2,name2,count2);
    }


    // Aggregation
    /**
     * Min function for a column by index
     *
     * @param index index of the column
     * @return the minimum element of the column specified by index.
     */
    public Object getMin(int index) {
        if(index == 0) {
            return Collections.min(this.state);
        } else if (index==1) {
            return Collections.min(this.gender);
        } else if (index==2) {
            return Collections.min(this.year);
        } else if (index==3) {
            return Collections.min(this.name);
        } else {
            return Collections.min(this.count);
        }
    }

    /**
     * Min function for a column by column name
     *
     * @param label column name
     * @return the minimum element of the column specified by label.
     */
    public Object getMin(String label) {
        if(label.equals("state")) {
            return Collections.min(this.state);
        } else if (label.equals("gender")) {
            return Collections.min(this.gender);
        } else if (label.equals("year")) {
            return Collections.min(this.year);
        } else if (label.equals("name")) {
            return Collections.min(this.name);
        } else {
            return Collections.min(this.count);
        }

    }

    /**
     * Max function for a column by index
     *
     * @param index index of the column
     * @return the maximum element of the column specified by index.
     */
    public Object getMax(int index) {
        if(index == 0) {
            return Collections.max(this.state);
        } else if (index==1) {
            return Collections.max(this.gender);
        } else if (index==2) {
            return Collections.max(this.year);
        } else if (index==3) {
            return Collections.max(this.name);
        } else {
            return Collections.max(this.count);
        }
    }

    /**
     * Max function for a column by column name
     *
     * @param label column name
     * @return the maximum element of the column specified by label.
     */
    public Object getMax(String label) {
        if(label.equals("state")) {
            return Collections.max(this.state);
        } else if (label.equals("gender")) {
            return Collections.max(this.gender);
        } else if (label.equals("year")) {
            return Collections.max(this.year);
        } else if (label.equals("name")) {
            return Collections.max(this.name);
        } else {
            return Collections.max(this.count);
        }

    }


    // Auxiliary class 1 - helps get indexes after sorting a String array
    class ArrayIndexComparatorStr implements Comparator<Integer>
    {
        private final ArrayList<String> array;

        public ArrayIndexComparatorStr(ArrayList<String> array)
        {
            this.array = array;
        }

        public Integer[] createIndexArray()
        {
            Integer[] indexes = new Integer[array.size()];
            for (int i = 0; i < array.size(); i++)
            {
                indexes[i] = i;
            }
            return indexes;
        }

        @Override
        public int compare(Integer index1, Integer index2)
        {

            return array.get(index1).compareTo(array.get(index2));
        }
    }

    // Auxiliary class 2 - helps get indexes after sorting an Integer array
    class ArrayIndexComparatorInt implements Comparator<Integer>
    {
        private final ArrayList<Integer> array;

        public ArrayIndexComparatorInt(ArrayList<Integer> array)
        {
            this.array = array;
        }

        public Integer[] createIndexArray()
        {
            Integer[] indexes = new Integer[array.size()];
            for (int i = 0; i < array.size(); i++)
            {
                indexes[i] = i;
            }
            return indexes;
        }

        @Override
        public int compare(Integer index1, Integer index2)
        {

            return array.get(index1).compareTo(array.get(index2));
        }
    }


    public static void main(String[] args) throws FileNotFoundException, FileNotFoundException {
        MyDataFrame df ;
        MyDataFrame df2;
        df  = readCSV("ak.txt");
        df2 = readCSV("al.txt");

//        writeCSV(df, "test_ak.csv");

//        MyDataFrame df3;

//        df3 = concat(df, df2);

        MyDataFrame df4;
//        df4 = df.tail(5);
        df4 = df.head(5);
//        df4 = df2.slice(0).tail(2);
//        df4 = df.loc(20000);
//        df4 = df.loc("20000");
//        df4 = df.loc(200, 205);
//        df4 = df.loc("200", "205");


        // Test by printing out concatenated dataframe. It works!
        for(int i = 0; i < df4.state.toArray().length; i++) {
            System.out.println(
                    df4.state.get(i) + ", " + df4.gender.get(i) + ", " + df4.year.get(i) + ", " + df4.name.get(i) + ", " + df4.count.get(i)
            );
        }

//        System.out.println(df3.dType("year"));

//        System.out.println(df3.dType(2));

//        for(int i = 0; i < df2.state.toArray().length; i++) {
//            System.out.println(
//                    df2.slice(2).state.get(i) + ", " + df2.slice(2).gender.get(i) + ", " + df2.slice(2).year.get(i) + ", " + df2.slice(2).name.get(i) + ", " + df2.slice(2).count.get(i)
//            );
//        }

//        System.out.println(df2.slice(0));

//        int[] intarray = new int[] {0,1};
//        String[] strarray = new String[] {"state", "count"};
//        System.out.println(Arrays.stream(intarray).anyMatch(i -> i == 1));

//        MyDataFrame df_slice;
//        df_slice = df.slice(strarray);
//        writeCSV(df_slice, "test_slice.csv");

    }

}
