/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclassifier;

import java.util.Scanner;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;
/**
 *
 * @author Fahmi
 */
public class MyClassifier {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
        System.out.println("Silahkan masukkan dataset path");
        Scanner Read = new Scanner(System.in);
        String path = Read.next();
        
    }
    public Instances loadData(String path) throws Exception{
        DataSource source = new DataSource(path);
        Instances data = source.getDataSet();
        // setting class attribute if the data format does not provide this information
        // For example, the XRFF format saves the class attribute information as well
        if (data.classIndex() == -1)
            data.setClassIndex(data.numAttributes() - 1);
        return data;
    }
    public Instances removeAttributes(Instances oldData) throws Exception{
        String[] options = new String[2];
        options[0] = "-R";                                    // "range"
        options[1] = "1";                                     // first attribute
        
        Remove remove = new Remove();                         // new instance of filter
        remove.setOptions(options);                           // set options
        remove.setInputFormat(oldData);                          // inform filter about dataset **AFTER** setting options
        Instances newData = Filter.useFilter(oldData, remove);
        return newData;
    }
}

