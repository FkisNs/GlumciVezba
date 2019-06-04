package com.ftninformatika.glumcivezba.providers;

import com.ftninformatika.glumcivezba.models.Glumci;

import java.util.ArrayList;
import java.util.List;

public class GlumacProvider {
    public static List<String> getGlumacNames(){
        List<String> names = new ArrayList<>();
        names.add("Glumac1");
        names.add("Glumac2");
        names.add("Glumac3");
        return names;
    }
    public static Glumci getGlumacById(int id) {

        switch (id) {
            case 0:
                return new Glumci(0,"Petar","Petrovic","Bio negde","Crash_Test_Dummy.png",4,"neki datum","neki filmovi");
            case 1: return new Glumci(1,"Mika","Zivkovic","Bio tamo","Crash_Test_Dummy.png",3,"neki datum","neki filmovi");
            case 2: return new Glumci(2,"Leo","Leonic","Bio ovde","Crash_Test_Dummy.png",5,"neki datum","neki filmovi");
            default:
                return null;
        }
    }
}
