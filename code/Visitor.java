/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author ajinkyabhushan
 */
public class Visitor extends Member{
    
    private String vistor_number;
    private String vistorName;
    Member member;

    public Visitor() {
        this.vistor_number = "VIS"+member.assignID();
        this.vistorName = "New Vistor";
    }
    
   // public Visitor(String vistor_number, String name, String surname,String gender) {
       // super(surname, surname, gender);
       // this.vistor_number = vistor_number;
   // }
    
    @Override
    public String toString(){
        return this.vistor_number+','+this.vistorName;
    }
    
}
