package com.ftninformatika.glumcivezba;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.ftninformatika.glumcivezba.fragments.FragmentPodatak;
import com.ftninformatika.glumcivezba.fragments.FragmentSpisak;

public class MainActivity extends AppCompatActivity implements FragmentSpisak.OnItemSelectedListener {

    private boolean landscape = false;
    private int position = 0;
    private FragmentSpisak fragmentSpisak = null;
    private FragmentPodatak fragmentPodatak = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) 	{

        super.onCreate(savedInstanceState);

        Toast.makeText(getBaseContext(), "MainActivity.onCreate()", Toast.LENGTH_SHORT).show();

        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            this.position = savedInstanceState.getInt("position");
        }

        fragmentSpisak = new FragmentSpisak();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.master_view, fragmentSpisak, "Fragment_Spisak_1");
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();

        fragmentPodatak = new FragmentPodatak();
        fragmentPodatak.setContent(position);
        if (findViewById(R.id.detail_view) != null) {
            landscape = true;
            getSupportFragmentManager().popBackStack();
            ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.detail_view, fragmentPodatak, "Fragment_Podatak_1");
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        super.onSaveInstanceState(savedInstanceState);

        // Shows a toast message (a pop-up message)
        Toast.makeText(this, "MainActivity.onSaveInstanceState()", Toast.LENGTH_SHORT).show();

        savedInstanceState.putInt("position", position);
    }

    @Override
    public void OnItemSelected(int position) {
        this.position = position;
        if(landscape){
            fragmentPodatak.updateContent(position);
        }else{
            fragmentPodatak.setContent(position);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.master_view, fragmentPodatak, "Fragment_Podatak_1");
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(null);
            ft.commit();
        }
    }
}
