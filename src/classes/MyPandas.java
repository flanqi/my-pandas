package classes;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class MyPandas {

    public static MyDataFrame readCSV(String path) throws FileNotFoundException {
        Scanner s = new Scanner(new File(path));
        ArrayList<String[]> records = new ArrayList<>();
        String[] record;
        ArrayList<String> st = new ArrayList<>();
        ArrayList<String> ge = new ArrayList<>();
        ArrayList<Integer> yr = new ArrayList<>();
        ArrayList<String> nm = new ArrayList<>();
        ArrayList<Integer> ct = new ArrayList<>();
        while (s.hasNext()) {
            record = s.nextLine().split(",");
            st.add(record[0]);
            ge.add(record[1]);
            yr.add(Integer.valueOf(record[2]));
            nm.add(record[3]);
            ct.add(Integer.valueOf(record[4]));
            records.add(record);
        }

        ArrayList<ArrayList> listoflists = new ArrayList<>();
        listoflists.add(st);
        listoflists.add(ge);
        listoflists.add(yr);
        listoflists.add(nm);
        listoflists.add(ct);
        s.close();

        return new MyDataFrame(listoflists.get(0), listoflists.get(1), listoflists.get(2), listoflists.get(3), listoflists.get(4));
    }

    public static void writeCSV(MyDataFrame data, String path) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), StandardCharsets.UTF_8));
            for (int i = 0; i < data.state.toArray().length; i++) {
                String oneLine =
                        data.state.get(i) +
                                "," +
                                data.gender.get(i) +
                                "," +
                                data.year.get(i) +
                                "," +
                                data.name.get(i) +
                                "," +
                                data.count.get(i);
                bw.write(oneLine);
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (IOException ignored) {
        }
    }

    public static MyDataFrame concat(MyDataFrame df1, MyDataFrame df2) {

        ArrayList<String> state = new ArrayList<>();
        state.addAll(df1.state);
        state.addAll(df2.state);

        ArrayList<String> gender = new ArrayList<>();
        gender.addAll(df1.gender);
        gender.addAll(df2.gender);

        ArrayList<Integer> year = new ArrayList<>();
        year.addAll(df1.year);
        year.addAll(df2.year);

        ArrayList<String> name = new ArrayList<>();
        name.addAll(df1.name);
        name.addAll(df2.name);

        ArrayList<Integer> count = new ArrayList<>();
        count.addAll(df1.count);
        count.addAll(df2.count);

        return new MyDataFrame(state, gender, year, name, count);
    }

}

