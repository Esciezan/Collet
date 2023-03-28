package fxapplication;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class IOControl {
    public static void output(File file,String tobeprinted,String Titles) throws IOException {
        String temp="";
        ArrayList<String> printout= new ArrayList<>(5000);
        FileWriter output = new FileWriter(file,false);
        BufferedWriter out = new BufferedWriter(output);
        PrintWriter clr= new PrintWriter(output,false);
        output.write("");
        out.append(Titles);
        out.newLine();
        char[] chararray=tobeprinted.toCharArray();
        for (int i = 0; i < chararray.length; i++) {
            if(chararray[i] == '|'){
            printout.add(temp);
            temp="";
            continue;
            }
            temp+=chararray[i];
        }
        for (int i = 0; i < printout.size(); i++) {
            out.append(printout.get(i));
            out.newLine();
        }
        out.flush();
        clr.flush();
        out.close();
        output.close();
}
static ArrayList<ArrayList<String>> input(File file) throws FileNotFoundException{
  
    int count=0;
    ArrayList<ArrayList<String>> tobeused= new ArrayList<>();
    ArrayList<String> interpretted= new ArrayList<>();
    Scanner input = new Scanner(file);
    for (int i = 0; i < 6; i++) {
        tobeused.add(new ArrayList<String>());
    }
    while(input.hasNextLine()){
        if(count>4){
            interpretted.add(input.nextLine());
            continue;
            }
        tobeused.get(5).add(input.nextLine());
        count++;
    }
    for(int j=0; j<interpretted.size();j++) {
        String[] temp =interpretted.get(j).split("-");
        for(int g=0; g<temp.length;g++) {
            tobeused.get(j).add(temp[g]);
        }
    }
    input.close();
    return tobeused;
}
}
