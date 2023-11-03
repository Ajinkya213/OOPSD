/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ajinkyabhushan
 */

//Empty Consturctor

public class Member implements FeesStructure{
    
    public static String pattern = "dd/MM/yy";
    private String membership_number;
    private String first_name;
    private String last_name;
    private String date;
    private String gender;
    //private Date dob;
    private String address;
    private String phone_no;
    private String age;
    private String membertype;
    private String startdate;
    private String enddate;
    private String fees;
    

    public Member() {
        this.membership_number = "";
        this.first_name = "";
        this.last_name = "";
        this.date = "";
        this.gender = "";
        this.address = "";
        this.phone_no = "";
        this.age = "";
        this.fees = "";
        this.startdate = "";
        this.enddate = "";
        this.membertype ="";
    }
   
    
    
    public void Member( String first_name, String last_name, String date, String gender, String address, String phone_no, String start_date, String membertype) {
        this.membership_number = assignID();
        this.first_name = first_name;
        this.last_name= last_name;
        this.date = date;
        this.gender = gender;
        this.address = address;
        this.phone_no = phone_no;
        this.age = this.ageCalculate(date);
        this.fees = this.feesCalculate(membertype);
        this.startdate = start_date;
        this.enddate = endDateCalculate(start_date, membertype);
        this.membertype = membertype;
        
    }
    
    
    public Member(String memString){
        this.membership_number = memString;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public void setMembership_number(String membership_number) {
        this.membership_number = membership_number;
    }
    
    public void setDate(String date){
        this.date = date;
    }
    
    
    public void setAge(String age) {
        this.age = age;
        
    }
    
    public void setFees(String fees){
        this.fees = fees;
    }
    
    public void setStartDate(String startdate){
        this.startdate = startdate;
    }
    
    public void setEndDate(String enddate){
        this.enddate = enddate;
    }
    
    public void setMemberType(String membertype){
        this.membertype = membertype;
    }
    
     /**
     * @return the serial_no
     */
    public String getMembership_Number() {
        return membership_number;
    }

    /**
     * @return the first_name
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * @return the last_name
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @return the phone_no
     */
    public String getPhone_no() {
        return phone_no;
    }

    /**
     * @return the fees
     */
    
    public String getDate(){
        return this.date;
    }

    // * @return the Date of Birth
     
    public String getAge(){
        return this.age;
    }
    
    public String getFees(){
        return this.fees;
    }
    
    public String getStartDate(){
        return  this.startdate;
    }
    
    public String getEndDate(){
        return  this.enddate;
    }
    
    public String getMemberType(){
        return this.membertype;
    }
    
    /**
     * @return the member type
     */
    
    public String ageCalculate(String inputdate){
        if (inputdate.isEmpty()){
            return "";
        }else{
        try {
            SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
            Date calDate = dateformat.parse(inputdate);
            Instant instant = calDate.toInstant();
            ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
            LocalDate localDate = zonedDateTime.toLocalDate();
            Period period = Period.between(localDate, LocalDate.of(2021, 9, 01));
            return  ""+period.getYears();
        } catch (ParseException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    }
    
    public String assignID(){
         Random rand = new Random();
        Integer i = rand.nextInt(999999);
        return this.membership_number = i.toString();
    }
    
    public String printAll() { //To change body of generated methods, choose Tools | Templates.
        System.out.println("code.Member.printAll()");
        return this.membership_number+','+this.last_name+','+this.first_name+','+this.date+','+this.gender+','+this.getAge()+','+this.fees+','+this.startdate+','+this.enddate+','+this.membertype;
    }
    

    public String feesCalculate(String membertype) {
        int fees;
        if(membertype == "Single Monthly")
        {
            fees = 36;
            return fees+"";
        }
         if(membertype == "Single Yearly")
        {
            fees = 36*12;
            return fees+"";
        }
         if(membertype == "Family Monthly")
         {
             fees = 60;
             return fees+"";
         }
         if(membertype == "Family Yearly")
         {
             fees = 60*12;
             return fees+"";
         }
         if(membertype == "Vistor"){
             fees = 12;
             return fees+"";
         }
        return "";
    }
    
    public String endDateCalculate(String startdate, String membertype) {
        try {
            SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
            Date calDate = dateformat.parse(startdate);
            Calendar cal = Calendar.getInstance();
            cal.setTime(calDate);
            Date date = new Date();
            if(membertype == "Single Monthly")
            {
                cal.add(Calendar.MONTH,1);
                date =  cal.getTime();
                return dateformat.format(date);
            }
            if(this.membertype == "Single Yearly")
            {
                cal.add(Calendar.YEAR, 1);
            }
            if(this.membertype == "Family Monthly")
            {
                cal.add(Calendar.MONTH, 1);
            }
            if(this.membertype == "Family Yearly")
            {
                cal.add(Calendar.YEAR, 1);
            }
            
        } catch (ParseException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  "";
    }
}
