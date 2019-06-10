package com.ftninformatika.glumcivezba;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.ftninformatika.glumcivezba.fragments.FragmentPodatak;
import com.ftninformatika.glumcivezba.fragments.FragmentSpisak;

public class MainActivity extends AppCompatActivity implements FragmentSpisak.OnItemSelectedListener {

    private int position = 0;
    private boolean landscapeMode = false;
    private boolean masterShown = false;
    private boolean detailShown = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) 	{

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_action_name);
            actionBar.setHomeButtonEnabled(true);
            actionBar.show();
        }

        if (savedInstanceState == null) {
            FragmentSpisak fragmentSpisak = new FragmentSpisak();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.master_view, fragmentSpisak, "Fragment_Spisak_1");
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }

        if(findViewById(R.id.detail_view)!= null){
            landscapeMode = true;
            getSupportFragmentManager().popBackStack();

            FragmentPodatak  fragmentPodatak = (FragmentPodatak) getSupportFragmentManager().findFragmentById(R.id.detail_view);
              if(fragmentPodatak == null) {
                  FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                  fragmentPodatak = new FragmentPodatak();
                  ft.replace(R.id.detail_view, fragmentPodatak, "Fragmnet_Podatak_1");
                  ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                  ft.commit();
                  detailShown = true;
              }
        }
        masterShown = true;
        detailShown = false;

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
        if(landscapeMode){
            FragmentPodatak  fragmentPodatak = (FragmentPodatak) getSupportFragmentManager().findFragmentById(R.id.detail_view);
            fragmentPodatak.updateContent(position);
        }else{
            FragmentPodatak fragmentPodatak = new FragmentPodatak();
            fragmentPodatak.setContent(position);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.master_view, fragmentPodatak, "Fragment_Podatak_2");
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(null);
            ft.commit();

            masterShown = false;
            detailShown = true;
        }
    }
}
