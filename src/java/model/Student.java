
package model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

public class Student {
    private String name;
    private boolean gender;
    private LocalDate dob;

    public Student() {
    }

    public Student(String name, boolean gender, LocalDate dob) {
        this.name = name;
        this.gender = gender;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", gender=" + gender + ", dob=" + dob + '}';
    }
    
    
    public void randomValues(){
        Random random = new Random();
        String character="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String nameRandom="";
        for(int i = 1; i <= 6; i++){
            int index=random.nextInt(character.length());
            nameRandom+=character.charAt(index);
        }
        name=nameRandom;
        gender=random.nextBoolean();
        boolean cont=true;
        while(cont){
            try {
                int year=random.nextInt(124)+1900;
                int month=random.nextInt(12)+1;
                int day=random.nextInt(31)+1;
                dob=LocalDate.of(year, month, day);
                cont=false;
            } catch (Exception e) {
            }
        }
        
    }
    public static void main(String[] args) {
        Student st=new Student();
        st.randomValues();
        System.out.println(st.toString());
    }
}
