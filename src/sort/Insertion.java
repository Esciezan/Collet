package sort;

import java.util.ArrayList;

public class Insertion extends Sorting {

  protected ArrayList<ArrayList<String>> old = new ArrayList<>();

  public ArrayList<ArrayList<String>> sort(String tobeconverted, int colno) {
    super.old = super.sort(tobeconverted, colno).get(colno);
    old = super.sort(tobeconverted, colno);
    ArrayList<ArrayList<String>> converted = super.sort(tobeconverted, colno);
    converted.set(colno, Insertionsort(converted.get(colno)));
    ArrayList<Integer> Indexes = super.compare(converted.get(colno));
    for (int i = 0; i < converted.size(); i++) {
      if (i == colno) continue;
      for (int j = 0; j < converted.get(i).size(); j++) {
        converted.get(i).set(j, old.get(i).get(Indexes.get(j)));
      }
    }

    return converted;
  }

  public ArrayList<ArrayList<String>> reversesort(
    String tobeconverted,
    int colno
  ) {
    super.old = super.sort(tobeconverted, colno).get(colno);
    old = super.sort(tobeconverted, colno);
    ArrayList<ArrayList<String>> converted = super.sort(tobeconverted, colno);
    converted.set(colno, reverseInsertionsort(converted.get(colno)));
    ArrayList<Integer> Indexes = super.compare(converted.get(colno));
    for (int i = 0; i < converted.size(); i++) {
      if (i == colno) continue;
      for (int j = 0; j < converted.get(i).size(); j++) {
        converted.get(i).set(j, old.get(i).get(Indexes.get(j)));
      }
    }

    return converted;
  }

  public ArrayList<ArrayList<String>> lengthsort(
    String tobeconverted,
    int colno
  ) {
    super.old = super.sort(tobeconverted, colno).get(colno);
    old = super.sort(tobeconverted, colno);
    ArrayList<ArrayList<String>> converted = super.sort(tobeconverted, colno);
    converted.set(colno, lengthInsertionsort(converted.get(colno)));
    ArrayList<Integer> Indexes = super.compare(converted.get(colno));
    for (int i = 0; i < converted.size(); i++) {
      if (i == colno) continue;
      for (int j = 0; j < converted.get(i).size(); j++) {
        converted.get(i).set(j, old.get(i).get(Indexes.get(j)));
      }
    }

    return converted;
  }

  public ArrayList<ArrayList<String>> reverselengthsort(
    String tobeconverted,
    int colno
  ) {
    super.old = super.sort(tobeconverted, colno).get(colno);
    old = super.sort(tobeconverted, colno);
    ArrayList<ArrayList<String>> converted = super.sort(tobeconverted, colno);
    converted.set(colno, reverselengthInsertionsort(converted.get(colno)));
    ArrayList<Integer> Indexes = super.compare(converted.get(colno));
    for (int i = 0; i < converted.size(); i++) {
      if (i == colno) continue;
      for (int j = 0; j < converted.get(i).size(); j++) {
        converted.get(i).set(j, old.get(i).get(Indexes.get(j)));
      }
    }

    return converted;
  }

  public ArrayList<ArrayList<String>> numsort(String tobeconverted, int colno) {
    super.old = super.sort(tobeconverted, colno).get(colno);
    old = super.sort(tobeconverted, colno);
    ArrayList<ArrayList<String>> converted = super.sort(tobeconverted, colno);
    converted.set(colno, numInsertionsort(converted.get(colno)));
    ArrayList<Integer> Indexes = super.compare(converted.get(colno));
    for (int i = 0; i < converted.size(); i++) {
      if (i == colno) continue;
      for (int j = 0; j < converted.get(i).size(); j++) {
        converted.get(i).set(j, old.get(i).get(Indexes.get(j)));
      }
    }

    return converted;
  }

  public ArrayList<ArrayList<String>> reversenumsort(
    String tobeconverted,
    int colno
  ) {
    super.old = super.sort(tobeconverted, colno).get(colno);
    old = super.sort(tobeconverted, colno);
    ArrayList<ArrayList<String>> converted = super.sort(tobeconverted, colno);
    converted.set(colno, reversenumInsertionsort(converted.get(colno)));
    ArrayList<Integer> Indexes = super.compare(converted.get(colno));
    for (int i = 0; i < converted.size(); i++) {
      if (i == colno) continue;
      for (int j = 0; j < converted.get(i).size(); j++) {
        converted.get(i).set(j, old.get(i).get(Indexes.get(j)));
      }
    }

    return converted;
  }

  private ArrayList<String> Insertionsort(ArrayList<String> tobesorted) {
    for (int i = 1; i < tobesorted.size(); i++) {
      String temp = tobesorted.get(i);
      int j = i - 1;
      while (
        j >= 0 &&
        tobesorted.get(j).toUpperCase().charAt(0) > temp.toUpperCase().charAt(0)
      ) {
        tobesorted.set(j + 1, tobesorted.get(j));
        j--;
      }
      tobesorted.set(j + 1, temp);
    }
    return tobesorted;
  }

  private ArrayList<String> reverseInsertionsort(ArrayList<String> tobesorted) {
    for (int i = 1; i < tobesorted.size(); i++) {
      String temp = tobesorted.get(i);
      int j = i - 1;
      while (
        j >= 0 &&
        tobesorted.get(j).toUpperCase().charAt(0) < temp.toUpperCase().charAt(0)
      ) {
        tobesorted.set(j + 1, tobesorted.get(j));
        j--;
      }
      tobesorted.set(j + 1, temp);
    }
    return tobesorted;
  }

  private ArrayList<String> lengthInsertionsort(ArrayList<String> tobesorted) {
    for (int i = 1; i < tobesorted.size(); i++) {
      String temp = tobesorted.get(i);
      int j = i - 1;
      while (j >= 0 && tobesorted.get(j).length() < temp.length()) {
        tobesorted.set(j + 1, tobesorted.get(j));
        j--;
      }
      tobesorted.set(j + 1, temp);
    }
    return tobesorted;
  }

  private ArrayList<String> reverselengthInsertionsort(
    ArrayList<String> tobesorted
  ) {
    for (int i = 1; i < tobesorted.size(); i++) {
      String temp = tobesorted.get(i);
      int j = i - 1;
      while (j >= 0 && tobesorted.get(j).length() > temp.length()) {
        tobesorted.set(j + 1, tobesorted.get(j));
        j--;
      }
      tobesorted.set(j + 1, temp);
    }
    return tobesorted;
  }

  private ArrayList<String> numInsertionsort(ArrayList<String> tobesorted) {
    for (int i = 1; i < tobesorted.size(); i++) {
      String temp = tobesorted.get(i);
      int j = i - 1;
      while (
        j >= 0 && Integer.parseInt(tobesorted.get(j)) > Integer.parseInt(temp)
      ) {
        tobesorted.set(j + 1, tobesorted.get(j));
        j--;
      }
      tobesorted.set(j + 1, temp);
    }
    return tobesorted;
  }

  private ArrayList<String> reversenumInsertionsort(
    ArrayList<String> tobesorted
  ) {
    for (int i = 1; i < tobesorted.size(); i++) {
      String temp = tobesorted.get(i);
      int j = i - 1;
      while (
        j >= 0 && Integer.parseInt(tobesorted.get(j)) < Integer.parseInt(temp)
      ) {
        tobesorted.set(j + 1, tobesorted.get(j));
        j--;
      }
      tobesorted.set(j + 1, temp);
    }
    return tobesorted;
  }
}
