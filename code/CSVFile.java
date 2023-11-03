/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ajinkyabhushan
 */
public class CSVFile {

    private static final String filename = "customerlist.csv";
    URL url = Thread.currentThread().getContextClassLoader().getResource(filename);
   
    public CSVFile() {
    }
    
    public List<Member>readData() throws IOException{
        List<Member> arraymember = new ArrayList<>();
           try (BufferedReader readfile = new BufferedReader(new InputStreamReader(url.openStream()))) {
                String line = readfile.readLine();
                
                while(line != null){
                   Member m = new Member();
                    String[] record = line.split(",");
                  for(int i = 0 ; i < record.length; i++){
                      switch(i){
                          case 0:  
                              if (record[0].isEmpty()) {
                                  m.assignID();
                              }
                              else
                                m.setMembership_number(record[0]);                     
                             break;
                          case 1:
                             m.setLast_name(record[1]);
                             break;
                          case 2:
                             m.setFirst_name(record[2]);
                             break;
                          case 3:
                             m.setDate(record[3]);
                             break;
                          case 4:
                             m.setGender(record[4]);
                             break;
                          case 5:
                             m.setAddress(record[5]);
                             break;
                          case 6:
                             m.setPhone_no(record[6]);
                             break;
                          case 7:
                             m.setAge(m.ageCalculate(record[3]));
                             break;
                          case 8:
                             m.setFees(m.feesCalculate(record[9]));
                             break;
                          case 9:
                             m.setStartDate(record[7]);
                             break;
                          case 10:
                             m.setEndDate(m.endDateCalculate(record[7],record[8]));
                             break;
                          case 11:
                              m.setMemberType(record[8]);
                              break;
                      }
                  }
                   // m.addMember(record[0],record[1],record[2],record[3],record[4],record[5]);
                  // System.out.println(record.length);
                    arraymember.add(m);             
                    line = readfile.readLine();
                }
                
    }   catch (FileNotFoundException ex) {
            Logger.getLogger(CSVFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arraymember;
}
    
      public void writeList(String print){ 
        try{
           BufferedWriter writefile = new BufferedWriter (new FileWriter(new File(url.getPath()), true));
            writefile.write('\n'+print);
              System.err.println("Write Error ");
              writefile.close();
            } catch(IOException e){
             System.out.println(e.getMessage());
        }
      }
      
      
      public void removeList(List<Member> memberList){
        String record;
        try (BufferedWriter writefile = new BufferedWriter(new FileWriter(new File("temp.csv"),false))){
            for (int i = 0 ; i < memberList.size(); i++){
                record = memberList.get(i).printAll();
                writefile.write(record+"\n");
                  System.err.println("remove Error");
            }
        } catch (IOException ex) {
            System.out.print(ex);
        }
        
        try{
            File oldFile = new File(filename);
            File updateFile = new File("temp.csv");
            oldFile.delete();
            updateFile.renameTo(oldFile);
            
        }catch(Exception e){
            System.out.print(e);
        }
        
    }   
        
 }
      
      
   
