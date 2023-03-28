package fxapplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import sort.Insertion;
import sort.Merge;

public class AppControl implements Initializable {

  Stage stage;
  private File locvalue = new File("C:\\Windows\\Temp\\Temporary.CLT");
  private FileChooser choose = new FileChooser();
  private double xOffset = 0, yOffset = 0;
  ObservableList<TableData> sheetlist = FXCollections.observableArrayList();

  private void deltemp() { // This func exists so unsaved tables are still sorted
    locvalue = new File("C:\\Windows\\Temp\\Temporary.CLT");
    locvalue.delete();
  }

  private void tooltips() { // tooltips when you hover over buttons
    AddB.setTooltip(new Tooltip("Add a Row"));
    MinusB.setTooltip(new Tooltip("Detract a Row"));
    NewB.setTooltip(
      new Tooltip("Erases Current Table and creates a row in a new table")
    );
    OpenB.setTooltip(new Tooltip("Opens A CLT file"));
    SaveB.setTooltip(new Tooltip("Save current table as a CLT file"));
    ESaveB.setTooltip(new Tooltip("Save current CLT file"));
    mbItemname.setTooltip(new Tooltip("Sort your Item Names"));
  }

  private void initcell() { // initialize the cells and allows it to take data
    Itemname.setCellValueFactory(new PropertyValueFactory<>("Itemname"));
    Property1.setCellValueFactory(new PropertyValueFactory<>("Property1"));
    Property2.setCellValueFactory(new PropertyValueFactory<>("Property2"));
    NumProperty1.setCellValueFactory(
      new PropertyValueFactory<>("Numproperty1")
    );
    NumProperty2.setCellValueFactory(
      new PropertyValueFactory<>("Numproperty2")
    );
  }

  private void editcell() { // allows for on double click turn cells into textfields
    Itemname.setCellFactory(TextFieldTableCell.forTableColumn());
    Property1.setCellFactory(TextFieldTableCell.forTableColumn());
    Property2.setCellFactory(TextFieldTableCell.forTableColumn());
    NumProperty1.setCellFactory(
      TextFieldTableCell.forTableColumn(new IntegerStringConverter())
    );
    NumProperty2.setCellFactory(
      TextFieldTableCell.forTableColumn(new IntegerStringConverter())
    );
  }

  private String titles() {
    String titles =Itemname.getText()+"\n"+Property1.getText()+"\n"+Property2.getText()+"\n"+NumProperty1.getText()+"\n"+NumProperty2.getText();
    return titles;
  }

  private String saveasstring() { // Code relies heavily on tostring toarray conversion so this was made for
    // reusability
    String print = "";
    TableData TableData = new TableData();
    List<List<String>> SavedArray = new ArrayList<>();
    for (int i = 0; i < MainT.getItems().size(); i++) {
      TableData = MainT.getItems().get(i);
      SavedArray.add(new ArrayList<>());
      SavedArray.get(i).add(TableData.getItemname());
      SavedArray.get(i).add(TableData.getProperty1());
      SavedArray.get(i).add(TableData.getProperty2());
      SavedArray.get(i).add(String.valueOf(TableData.getNumproperty1()));
      SavedArray.get(i).add(String.valueOf(TableData.getNumproperty2()));
    }
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < MainT.getItems().size(); j++) {
        print += SavedArray.get(j).get(i) + "-";
      }

      print += "|";
    }
    return print;
  }

  private void loadcell(ArrayList<ArrayList<String>> tobeadded) {
    sheetlist.clear();
  
    for (int i = 0; i < tobeadded.get(0).size(); i++) {
      sheetlist.add(
        new TableData(
          tobeadded.get(0).get(i),
          tobeadded.get(1).get(i),
          tobeadded.get(2).get(i),
          Integer.parseInt(tobeadded.get(3).get(i)),
          Integer.parseInt(tobeadded.get(4).get(i))
        )
      );
    }
  }

  // Standard Scenebuilder GUI initialization
  @FXML
  private MenuButton mbItemname;

  @FXML
  private TableColumn<TableData, String> Itemname;

  @FXML
  private TableView<TableData> MainT;

  @FXML
  private Button NewB;

  @FXML
  private TableColumn<TableData, Integer> NumProperty1;

  @FXML
  private TableColumn<TableData, Integer> NumProperty2;

  @FXML
  private Button OpenB;

  @FXML
  private TableColumn<TableData, String> Property1;

  @FXML
  private TableColumn<TableData, String> Property2;

  @FXML
  private Button SaveB;

  @FXML
  private Button ESaveB;

  @FXML
  private Button AddB;

  @FXML
  private Button MinusB;

  @FXML
  private Button ExitB;

  @FXML
  private BorderPane Scenepane;

  @FXML
  private ToolBar MenuBar;

  @FXML
  private ToolBar Topbar;

  @FXML
  private ToolBar Bottobar;

  @FXML
  private Label Title;

  @FXML
  private Label sortby;

  @FXML
  private Label Ico;

  @FXML
  private TextField col1;
  @FXML
  private TextField col2;
  @FXML
  private TextField col3;
  @FXML
  private TextField col4;
  @FXML
  private TextField col5;
  
  @FXML
  private RadioButton RBCoffee;

  @FXML
  private RadioButton RBMidnight;

  //Column renaming
  @FXML
  void renamecol1(KeyEvent event) {
    try {
      if (event.getCode() == KeyCode.ENTER) {
        Itemname.setText(col1.getText());
        col1.setText("");
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  @FXML
  void renamecol2(KeyEvent event) {
    try {
      if (event.getCode() == KeyCode.ENTER) {
        Property1.setText(col2.getText());
        col2.setText("");
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  @FXML
  void renamecol3(KeyEvent event) {
    try {
      if (event.getCode() == KeyCode.ENTER) {
        Property2.setText(col3.getText());
        col3.setText("");
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  @FXML
  void renamecol4(KeyEvent event) {
    try {
      if (event.getCode() == KeyCode.ENTER) {
        NumProperty1.setText(col4.getText());
        col4.setText("");
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  @FXML
  void renamecol5(KeyEvent event) {
    try {
      if (event.getCode() == KeyCode.ENTER) {
        NumProperty2.setText(col5.getText());
        col5.setText("");
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  // FILE HANDLING
  @FXML
  void Create(ActionEvent event) {
    locvalue = new File("C:\\Windows\\Temp\\Temporary.CLT");
    deltemp();
    sheetlist.clear();
    sheetlist.add(new TableData("INSERT ITEM HERE", " ", " ", 1, 0));
  }

  @FXML
  void Open(ActionEvent event) throws FileNotFoundException {
    try {
      File savedtable = choose.showOpenDialog(new Stage());
      deltemp();
      locvalue = savedtable;
      ArrayList<ArrayList<String>> load=IOControl.input(savedtable);
      Itemname.setText(load.get(5).get(0));
      Property1.setText(load.get(5).get(1));
      Property2.setText(load.get(5).get(2));
      NumProperty1.setText(load.get(5).get(3));
      NumProperty2.setText(load.get(5).get(4));
      loadcell(load);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  @FXML
  void Save(ActionEvent event) throws IOException {
    try {
      File saving = choose.showSaveDialog(new Stage()); 
      deltemp();
      locvalue = saving;
      IOControl.output(saving, saveasstring(),titles());
    } catch (NullPointerException e) {
      return;
    }
  }

  @FXML
  void ESave(ActionEvent event) throws IOException {
    try {
      IOControl.output(locvalue, saveasstring(),titles());
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  @FXML
  void Add(ActionEvent event) {
    if (sheetlist.size() > 0) {
      sheetlist.add(new TableData("INSERT ITEM HERE", " ", " ", 1, 0));
    }
  }

  @FXML
  void Minus(ActionEvent event) {
    ObservableList<TableData> aTableDatas, sTableDatas;
    aTableDatas = MainT.getItems();
    sTableDatas = MainT.getSelectionModel().getSelectedItems();
    sTableDatas.forEach(aTableDatas::remove);
  }

  @FXML
  void drag(MouseEvent event) {
    stage = (Stage) Topbar.getScene().getWindow();
    stage.setX(event.getScreenX() - xOffset);
    stage.setY(event.getScreenY() - yOffset);
  }

  @FXML
  void dragpre(MouseEvent event) {
    xOffset = event.getSceneX();
    yOffset = event.getSceneY();
  }

  @FXML
  void Exit_Func(ActionEvent event) {
    stage = (Stage) Scenepane.getScene().getWindow();
    File temp = new File("C:\\Windows\\Temp\\Temporary.CLT");
    temp.delete();
    stage.close();
  }

  @FXML
  void Min_Func(ActionEvent event) {
    stage = (Stage) Scenepane.getScene().getWindow();
    stage.setIconified(true);
  }

  // Table Editing(commits edited textfields on to text)
  @FXML
  void commitItemname(TableColumn.CellEditEvent<TableData, String> tEditEvent) {
    TableData TableData = MainT.getSelectionModel().getSelectedItem();
    String newdata = tEditEvent.getNewValue();
    TableData.setItemname(newdata);
    if (newdata.equalsIgnoreCase("")) { // turns blank cells into spaces so they are read by the string to array
      // converter
      TableData.setItemname(" ");
    }
  }

  @FXML
  void commitNumproperty1(
    TableColumn.CellEditEvent<TableData, Integer> tEditEvent
  ) {
    TableData TableData = MainT.getSelectionModel().getSelectedItem();
    TableData.setNumproperty1(tEditEvent.getNewValue());
  }

  @FXML
  void commitNumproperty2(
    TableColumn.CellEditEvent<TableData, Integer> tEditEvent
  ) {
    TableData TableData = MainT.getSelectionModel().getSelectedItem();
    TableData.setNumproperty2(tEditEvent.getNewValue());
  }

  @FXML
  void commitProperty1(
    TableColumn.CellEditEvent<TableData, String> tEditEvent
  ) {
    String newdata = tEditEvent.getNewValue();
    TableData TableData = MainT.getSelectionModel().getSelectedItem();
    TableData.setProperty1(newdata);
    if (newdata.equalsIgnoreCase("")) { // more of the same from itemname wont be commented further due to
      // redundancy
      TableData.setProperty1(" ");
    }
  }

  @FXML
  void commitProperty2(
    TableColumn.CellEditEvent<TableData, String> tEditEvent
  ) {
    String newdata = tEditEvent.getNewValue();
    TableData TableData = MainT.getSelectionModel().getSelectedItem();
    TableData.setProperty2(newdata);
    if (newdata.equalsIgnoreCase("")) {
      TableData.setProperty2(" ");
    }
  }

  // MERGE SORTING
  @FXML
  void sortMergeitemname(ActionEvent event)
    throws NumberFormatException, IOException {
    Merge merge = new Merge();
    ArrayList<ArrayList<String>> Sorted = merge.sort(saveasstring(), 0);
    loadcell(Sorted);
  }

  @FXML
  void reversesortMergeitemname(ActionEvent event)
    throws NumberFormatException, IOException {
    Merge merge = new Merge();
    ArrayList<ArrayList<String>> Sorted = merge.reversesort(saveasstring(), 0);
    loadcell(Sorted);
  }

  @FXML
  void sortMergeLengthitemname(ActionEvent event) {
    Merge merge = new Merge();
    ArrayList<ArrayList<String>> Sorted = merge.lengthsort(saveasstring(), 0);
    loadcell(Sorted);
  }

  @FXML
  void reversesortMergeLengthitemname(ActionEvent event) {
    Merge merge = new Merge();
    ArrayList<ArrayList<String>> Sorted = merge.reverselengthsort(
      saveasstring(),
      0
    );
    loadcell(Sorted);
  }

  @FXML
  void sortMergeProperty1(ActionEvent event) {
    Merge merge = new Merge();
    ArrayList<ArrayList<String>> Sorted = merge.sort(saveasstring(), 1);
    loadcell(Sorted);
  }

  @FXML
  void reversesortMergeProperty1(ActionEvent event) {
    Merge merge = new Merge();
    ArrayList<ArrayList<String>> Sorted = merge.reversesort(saveasstring(), 1);
    loadcell(Sorted);
  }

  @FXML
  void sortMergeLengthProperty1(ActionEvent event) {
    Merge merge = new Merge();
    ArrayList<ArrayList<String>> Sorted = merge.lengthsort(saveasstring(), 1);
    sheetlist.clear();
    loadcell(Sorted);
  }

  @FXML
  void reversesortMergeLengthProperty1(ActionEvent event) {
    Merge merge = new Merge();
    ArrayList<ArrayList<String>> Sorted = merge.reverselengthsort(
      saveasstring(),
      1
    );
    loadcell(Sorted);
  }

  @FXML
  void sortMergeProperty2(ActionEvent event) {
    Merge merge = new Merge();
    ArrayList<ArrayList<String>> Sorted = merge.sort(saveasstring(), 2);
    sheetlist.clear();
    loadcell(Sorted);
  }

  @FXML
  void reversesortMergeProperty2(ActionEvent event) {
    Merge merge = new Merge();
    ArrayList<ArrayList<String>> Sorted = merge.reversesort(saveasstring(), 2);
    loadcell(Sorted);
  }

  @FXML
  void sortMergeLengthProperty2(ActionEvent event) {
    Merge merge = new Merge();
    ArrayList<ArrayList<String>> Sorted = merge.lengthsort(saveasstring(), 2);
    loadcell(Sorted);
  }

  @FXML
  void reversesortMergeLengthProperty2(ActionEvent event) {
    Merge merge = new Merge();
    ArrayList<ArrayList<String>> Sorted = merge.reverselengthsort(
      saveasstring(),
      2
    );
    loadcell(Sorted);
  }

  @FXML
  void sortMergeNProperty1(ActionEvent event) {
    Merge merge = new Merge();
    ArrayList<ArrayList<String>> Sorted = merge.nsort(saveasstring(), 3);
    loadcell(Sorted);
  }

  @FXML
  void reversesortMergeNProperty1(ActionEvent event) {
    Merge merge = new Merge();
    ArrayList<ArrayList<String>> Sorted = merge.reversensort(saveasstring(), 3);
    sheetlist.clear();
    loadcell(Sorted);
  }

  @FXML
  void sortMergeLengthNProperty1(ActionEvent event) {
    Merge merge = new Merge();
    ArrayList<ArrayList<String>> Sorted = merge.lengthsort(saveasstring(), 3);
    sheetlist.clear();
    loadcell(Sorted);
  }

  @FXML
  void reversesortMergeLengthNProperty1(ActionEvent event) {
    Merge merge = new Merge();
    ArrayList<ArrayList<String>> Sorted = merge.reverselengthsort(
      saveasstring(),
      3
    );
    loadcell(Sorted);
  }

  @FXML
  void sortMergeNProperty2(ActionEvent event) {
    Merge merge = new Merge();
    ArrayList<ArrayList<String>> Sorted = merge.nsort(saveasstring(), 4);
    sheetlist.clear();
    loadcell(Sorted);
  }

  @FXML
  void reversesortMergeNProperty2(ActionEvent event) {
    Merge merge = new Merge();
    ArrayList<ArrayList<String>> Sorted = merge.reversensort(saveasstring(), 4);
    sheetlist.clear();
    loadcell(Sorted);
  }

  @FXML
  void sortMergeLengthNProperty2(ActionEvent event) {
    Merge merge = new Merge();
    ArrayList<ArrayList<String>> Sorted = merge.lengthsort(saveasstring(), 4);
    loadcell(Sorted);
  }

  @FXML
  void reversesortMergeLengthNProperty2(ActionEvent event) {
    Merge merge = new Merge();
    ArrayList<ArrayList<String>> Sorted = merge.reverselengthsort(
      saveasstring(),
      4
    );
    loadcell(Sorted);
  }

  // INSERTION SORTING
  @FXML
  void sortInsertionitemname(ActionEvent event)
    throws NumberFormatException, IOException {
    Insertion insert = new Insertion();
    ArrayList<ArrayList<String>> Sorted = insert.sort(saveasstring(), 0);
    loadcell(Sorted);
  }

  @FXML
  void reversesortInsertionitemname(ActionEvent event) {
    Insertion insert = new Insertion();
    ArrayList<ArrayList<String>> Sorted = insert.reversesort(saveasstring(), 0);
    loadcell(Sorted);
  }

  @FXML
  void sortInsertionLengthitemname(ActionEvent event) {
    Insertion insert = new Insertion();
    ArrayList<ArrayList<String>> Sorted = insert.lengthsort(saveasstring(), 0);
    loadcell(Sorted);
  }

  @FXML
  void reversesortInsertionLengthitemname(ActionEvent event) {
    Insertion insert = new Insertion();
    ArrayList<ArrayList<String>> Sorted = insert.reverselengthsort(
      saveasstring(),
      0
    );
    loadcell(Sorted);
  }

  @FXML
  void sortInsertionproperty2(ActionEvent event)
    throws NumberFormatException, IOException {
    Insertion insert = new Insertion();
    ArrayList<ArrayList<String>> Sorted = insert.sort(saveasstring(), 2);
    loadcell(Sorted);
  }

  @FXML
  void reversesortInsertionproperty2(ActionEvent event) {
    Insertion insert = new Insertion();
    ArrayList<ArrayList<String>> Sorted = insert.reversesort(saveasstring(), 2);
    loadcell(Sorted);
  }

  @FXML
  void sortInsertionLengthproperty2(ActionEvent event) {
    Insertion insert = new Insertion();
    ArrayList<ArrayList<String>> Sorted = insert.lengthsort(saveasstring(), 2);
    loadcell(Sorted);
  }

  @FXML
  void reversesortInsertionLengthproperty2(ActionEvent event) {
    Insertion insert = new Insertion();
    ArrayList<ArrayList<String>> Sorted = insert.reverselengthsort(
      saveasstring(),
      2
    );
    loadcell(Sorted);
  }

  @FXML
  void sortInsertionproperty1(ActionEvent event)
    throws NumberFormatException, IOException {
    Insertion insert = new Insertion();
    ArrayList<ArrayList<String>> Sorted = insert.sort(saveasstring(), 3);
    loadcell(Sorted);
  }

  @FXML
  void reversesortInsertionproperty1(ActionEvent event) {
    Insertion insert = new Insertion();
    ArrayList<ArrayList<String>> Sorted = insert.reversesort(saveasstring(), 3);
    loadcell(Sorted);
  }

  @FXML
  void sortInsertionLengthproperty1(ActionEvent event) {
    Insertion insert = new Insertion();
    ArrayList<ArrayList<String>> Sorted = insert.lengthsort(saveasstring(), 3);
    loadcell(Sorted);
  }

  @FXML
  void reversesortInsertionLengthproperty1(ActionEvent event) {
    Insertion insert = new Insertion();
    ArrayList<ArrayList<String>> Sorted = insert.reverselengthsort(
      saveasstring(),
      1
    );
    loadcell(Sorted);
  }

  @FXML
  void sortInsertionnproperty1(ActionEvent event)
    throws NumberFormatException, IOException {
    Insertion insert = new Insertion();
    ArrayList<ArrayList<String>> Sorted = insert.sort(saveasstring(), 4);
    loadcell(Sorted);
  }

  @FXML
  void reversesortInsertionnproperty2(ActionEvent event) {
    Insertion insert = new Insertion();
    ArrayList<ArrayList<String>> Sorted = insert.reversesort(saveasstring(), 4);
    loadcell(Sorted);
  }

  @FXML
  void sortInsertionLengthnproperty2(ActionEvent event) {
    Insertion insert = new Insertion();
    ArrayList<ArrayList<String>> Sorted = insert.lengthsort(saveasstring(), 4);
    loadcell(Sorted);
  }

  @FXML
  void sortInsertionnproperty2(ActionEvent event)
    throws NumberFormatException, IOException {
    Insertion insert = new Insertion();
    ArrayList<ArrayList<String>> Sorted = insert.sort(saveasstring(), 4);
    loadcell(Sorted);
  }

  @FXML
  void reversesortInsertionnproperty1(ActionEvent event) {
    Insertion insert = new Insertion();
    ArrayList<ArrayList<String>> Sorted = insert.reversesort(saveasstring(), 4);
    loadcell(Sorted);
  }

  @FXML
  void sortInsertionLengthnproperty1(ActionEvent event) {
    Insertion insert = new Insertion();
    ArrayList<ArrayList<String>> Sorted = insert.lengthsort(saveasstring(), 4);
    loadcell(Sorted);
  }

  @FXML
  void reversesortInsertionLengthnproperty2(ActionEvent event) {
    Insertion insert = new Insertion();
    ArrayList<ArrayList<String>> Sorted = insert.reverselengthsort(
      saveasstring(),
      4
    );
    loadcell(Sorted);
  }

  @FXML
  void reversesortInsertionLengthnproperty1(ActionEvent event) {
    Insertion insert = new Insertion();
    ArrayList<ArrayList<String>> Sorted = insert.reverselengthsort(
      saveasstring(),
      4
    );
    loadcell(Sorted);
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    choose
      .getExtensionFilters()
      .addAll(new ExtensionFilter("Collection Files", "*.CLT"));
    choose.setInitialDirectory(
      new File("C:\\Users\\" + System.getProperty("user.name") + "\\Documents")
    );
    tooltips();
    initcell();
    editcell();
    MainT.setItems(sheetlist);
    MainT.setEditable(true);
  }
}
