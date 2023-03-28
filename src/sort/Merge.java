package sort;

import java.util.ArrayList;

public class Merge extends Sorting {

  private ArrayList<ArrayList<String>> old = new ArrayList<>();

  public ArrayList<ArrayList<String>> sort(String tobeconverted, int colno) {
    super.old = super.sort(tobeconverted, colno).get(colno);
    old = super.sort(tobeconverted, colno);
    ArrayList<ArrayList<String>> converted = super.sort(tobeconverted, colno);
    converted.set(colno, mergesort(converted.get(colno)));
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
    converted.set(colno, reversemergesort(converted.get(colno)));
    ArrayList<Integer> Indexes = super.compare(converted.get(colno));
    for (int i = 0; i < converted.size(); i++) {
      if (i == colno) continue;
      for (int j = 0; j < converted.get(i).size(); j++) {
        converted.get(i).set(j, old.get(i).get(Indexes.get(j)));
      }
    }
    return converted;
  }

  public ArrayList<ArrayList<String>> nsort(String tobeconverted, int colno) {
    super.old = super.sort(tobeconverted, colno).get(colno);
    old = super.sort(tobeconverted, colno);
    ArrayList<ArrayList<String>> converted = super.sort(tobeconverted, colno);
    converted.set(colno, nmergesort(converted.get(colno)));
    ArrayList<Integer> Indexes = super.compare(converted.get(colno));
    for (int i = 0; i < converted.size(); i++) {
      if (i == colno) continue;
      for (int j = 0; j < converted.get(i).size(); j++) {
        converted.get(i).set(j, old.get(i).get(Indexes.get(j)));
      }
    }
    return converted;
  }

  public ArrayList<ArrayList<String>> reversensort(
    String tobeconverted,
    int colno
  ) {
    super.old = super.sort(tobeconverted, colno).get(colno);
    old = super.sort(tobeconverted, colno);
    ArrayList<ArrayList<String>> converted = super.sort(tobeconverted, colno);
    converted.set(colno, reversenmergesort(converted.get(colno)));
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
    converted.set(colno, lengthmergesort(converted.get(colno)));
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
    converted.set(colno, reverselengthmergesort(converted.get(colno)));
    ArrayList<Integer> Indexes = super.compare(converted.get(colno));
    for (int i = 0; i < converted.size(); i++) {
      if (i == colno) continue;
      for (int j = 0; j < converted.get(i).size(); j++) {
        converted.get(i).set(j, old.get(i).get(Indexes.get(j)));
      }
    }
    return converted;
  }

  private static ArrayList<String> mergesort(ArrayList<String> Array) {
    int length = Array.size();
    if (length <= 1) return Array;
    int mid = length / 2;
    ArrayList<String> Left = new ArrayList<>();
    ArrayList<String> Right = new ArrayList<>();
    for (int i = 0; i < length; i++) {
      if (i < mid) {
        Left.add(Array.get(i));
      } else {
        Right.add(Array.get(i));
      }
    }
    mergesort(Left);
    mergesort(Right);
    merge(Left, Right, Array);
    return Array;
  }

  private static void merge(
    ArrayList<String> Left,
    ArrayList<String> Right,
    ArrayList<String> Array
  ) {
    int Leftsize = Array.size() / 2;
    int Rightsize = Array.size() - Leftsize;
    int i = 0, l = 0, r = 0;
    while (l < Leftsize && r < Rightsize) {
      if (
        Left.get(l).toUpperCase().charAt(0) <
        Right.get(r).toUpperCase().charAt(0)
      ) {
        Array.set(i, Left.get(l));
        i++;
        l++;
      } else {
        Array.set(i, Right.get(r));
        i++;
        r++;
      }
    }
    while (l < Leftsize) {
      Array.set(i, Left.get(l));
      i++;
      l++;
    }
    while (r < Rightsize) {
      Array.set(i, Right.get(r));
      i++;
      r++;
    }
  }

  private static ArrayList<String> reversemergesort(ArrayList<String> Array) {
    int length = Array.size();
    if (length <= 1) return Array;
    int mid = length / 2;
    ArrayList<String> Left = new ArrayList<>();
    ArrayList<String> Right = new ArrayList<>();
    for (int i = 0; i < length; i++) {
      if (i < mid) {
        Left.add(Array.get(i));
      } else {
        Right.add(Array.get(i));
      }
    }
    reversemergesort(Left);
    reversemergesort(Right);
    reversemerge(Left, Right, Array);
    return Array;
  }

  private static void reversemerge(
    ArrayList<String> Left,
    ArrayList<String> Right,
    ArrayList<String> Array
  ) {
    int Leftsize = Array.size() / 2;
    int Rightsize = Array.size() - Leftsize;
    int i = 0, l = 0, r = 0;
    while (l < Leftsize && r < Rightsize) {
      if (
        Left.get(l).toUpperCase().charAt(0) >
        Right.get(r).toUpperCase().charAt(0)
      ) {
        Array.set(i, Left.get(l));
        i++;
        l++;
      } else {
        Array.set(i, Right.get(r));
        i++;
        r++;
      }
    }
    while (l < Leftsize) {
      Array.set(i, Left.get(l));
      i++;
      l++;
    }
    while (r < Rightsize) {
      Array.set(i, Right.get(r));
      i++;
      r++;
    }
  }

  private static ArrayList<String> nmergesort(ArrayList<String> Array) {
    int length = Array.size();
    if (length <= 1) return Array;
    int mid = length / 2;
    ArrayList<String> Left = new ArrayList<>();
    ArrayList<String> Right = new ArrayList<>();
    for (int i = 0; i < length; i++) {
      if (i < mid) {
        Left.add(Array.get(i));
      } else {
        Right.add(Array.get(i));
      }
    }
    nmergesort(Left);
    nmergesort(Right);
    nmerge(Left, Right, Array);
    return Array;
  }

  private static void nmerge(
    ArrayList<String> Left,
    ArrayList<String> Right,
    ArrayList<String> Array
  ) {
    int Leftsize = Array.size() / 2;
    int Rightsize = Array.size() - Leftsize;
    int i = 0, l = 0, r = 0;
    while (l < Leftsize && r < Rightsize) {
      if (Integer.parseInt(Left.get(l)) > Integer.parseInt(Right.get(r))) {
        Array.set(i, Left.get(l));
        i++;
        l++;
      } else {
        Array.set(i, Right.get(r));
        i++;
        r++;
      }
    }
    while (l < Leftsize) {
      Array.set(i, Left.get(l));
      i++;
      l++;
    }
    while (r < Rightsize) {
      Array.set(i, Right.get(r));
      i++;
      r++;
    }
  }

  private static ArrayList<String> reversenmergesort(ArrayList<String> Array) {
    int length = Array.size();
    if (length <= 1) return Array;
    int mid = length / 2;
    ArrayList<String> Left = new ArrayList<>();
    ArrayList<String> Right = new ArrayList<>();
    for (int i = 0; i < length; i++) {
      if (i < mid) {
        Left.add(Array.get(i));
      } else {
        Right.add(Array.get(i));
      }
    }
    reversenmergesort(Left);
    reversenmergesort(Right);
    reversenmerge(Left, Right, Array);
    return Array;
  }

  private static void reversenmerge(
    ArrayList<String> Left,
    ArrayList<String> Right,
    ArrayList<String> Array
  ) {
    int Leftsize = Array.size() / 2;
    int Rightsize = Array.size() - Leftsize;
    int i = 0, l = 0, r = 0;
    while (l < Leftsize && r < Rightsize) {
      if (Integer.parseInt(Left.get(l)) < Integer.parseInt(Right.get(r))) {
        Array.set(i, Left.get(l));
        i++;
        l++;
      } else {
        Array.set(i, Right.get(r));
        i++;
        r++;
      }
    }
    while (l < Leftsize) {
      Array.set(i, Left.get(l));
      i++;
      l++;
    }
    while (r < Rightsize) {
      Array.set(i, Right.get(r));
      i++;
      r++;
    }
  }

  private static ArrayList<String> lengthmergesort(ArrayList<String> Array) {
    int length = Array.size();
    if (length <= 1) return Array;
    int mid = length / 2;
    ArrayList<String> Left = new ArrayList<>();
    ArrayList<String> Right = new ArrayList<>();
    for (int i = 0; i < length; i++) {
      if (i < mid) {
        Left.add(Array.get(i));
      } else {
        Right.add(Array.get(i));
      }
    }
    lengthmergesort(Left);
    lengthmergesort(Right);
    lengthmerge(Left, Right, Array);
    return Array;
  }

  private static void lengthmerge(
    ArrayList<String> Left,
    ArrayList<String> Right,
    ArrayList<String> Array
  ) {
    int Leftsize = Array.size() / 2;
    int Rightsize = Array.size() - Leftsize;
    int i = 0, l = 0, r = 0;
    while (l < Leftsize && r < Rightsize) {
      if (Left.get(l).length() > Right.get(r).length()) {
        Array.set(i, Left.get(l));
        i++;
        l++;
      } else {
        Array.set(i, Right.get(r));
        i++;
        r++;
      }
    }
    while (l < Leftsize) {
      Array.set(i, Left.get(l));
      i++;
      l++;
    }
    while (r < Rightsize) {
      Array.set(i, Right.get(r));
      i++;
      r++;
    }
  }

  private static ArrayList<String> reverselengthmergesort(
    ArrayList<String> Array
  ) {
    int length = Array.size();
    if (length <= 1) return Array;
    int mid = length / 2;
    ArrayList<String> Left = new ArrayList<>();
    ArrayList<String> Right = new ArrayList<>();
    for (int i = 0; i < length; i++) {
      if (i < mid) {
        Left.add(Array.get(i));
      } else {
        Right.add(Array.get(i));
      }
    }
    reverselengthmergesort(Left);
    reverselengthmergesort(Right);
    reverselengthmerge(Left, Right, Array);
    return Array;
  }

  private static void reverselengthmerge(
    ArrayList<String> Left,
    ArrayList<String> Right,
    ArrayList<String> Array
  ) {
    int Leftsize = Array.size() / 2;
    int Rightsize = Array.size() - Leftsize;
    int i = 0, l = 0, r = 0;
    while (l < Leftsize && r < Rightsize) {
      if (Left.get(l).length() < Right.get(r).length()) {
        Array.set(i, Left.get(l));
        i++;
        l++;
      } else {
        Array.set(i, Right.get(r));
        i++;
        r++;
      }
    }
    while (l < Leftsize) {
      Array.set(i, Left.get(l));
      i++;
      l++;
    }
    while (r < Rightsize) {
      Array.set(i, Right.get(r));
      i++;
      r++;
    }
  }
}
