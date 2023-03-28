package sort;

import java.util.ArrayList;

public class Sorting {

  protected ArrayList<String> old = new ArrayList<>();

  protected ArrayList<ArrayList<String>> sort(String tobeconverted, int colno) {
    ArrayList<ArrayList<String>> converted = new ArrayList<>();
    int o = 0;
    String temp = "";
    converted.add(new ArrayList<String>());
  
    char[] chararray = tobeconverted.toCharArray();
    for (int i = 0; i < chararray.length; i++) {
      if (chararray[i] == '-') {
        converted.get(o).add(temp);
        temp = "";
        continue;
      }
      if (chararray[i] == '|') {
        converted.add(new ArrayList<String>());
        o++;
        continue;
      }
      temp += chararray[i];
    }

    return converted;
  }
  

  protected ArrayList<Integer> compare(ArrayList<String> newa) {
    ArrayList<Integer> indexes = new ArrayList<>();
    for (int i = 0; i < newa.size(); i++) {
      indexes.add(i);
    }
    for (int i = 0; i < old.size(); i++) {
      compare:for (int j = 0; j < old.size(); j++) {
        if (newa.get(i).equals(old.get(j))) {
          if (i > 0) { //Checks for Similar Numbers to ensure unique numbers on table
            for (int j2 = 1; j2 < i + 1; j2++) {
              if (indexes.get(i - j2) == j) {
                continue compare;
              }
            }
          }
          indexes.set(i, j);
        }
      }
    }
    return indexes;
  }
}
