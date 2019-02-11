/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author HP
 */
public class ExcelExporter {
    ExcelExporter(){}
    public void exportTable(JTable jTable1,File file) throws IOException{
      TableModel model=jTable1.getModel();
      FileWriter out=new FileWriter(file);
      BufferedWriter bw=new BufferedWriter(out);
      for (int i=0;i<model.getColumnCount();i++){
        bw.write(model.getColumnName(i)+"\t");
      }
      bw.write("\n");
      for (int i=0;i<model.getRowCount();i++){
        for (int j=0;j<model.getColumnCount();j++){
            String s = (String)model.getValueAt(i,j);
            if(s==null)
          bw.write(""+"\t");
            else
                bw.write(s+"\t"); 
        }
        bw.write("\n");
      }
      bw.close();
   System.out.print("Write out to"+file);


}

    
    
}
