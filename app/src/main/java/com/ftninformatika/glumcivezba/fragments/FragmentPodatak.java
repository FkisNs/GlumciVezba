package com.ftninformatika.glumcivezba.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.ftninformatika.glumcivezba.R;
import com.ftninformatika.glumcivezba.providers.GlumacProvider;

import java.io.IOException;
import java.io.InputStream;

public class FragmentPodatak extends Fragment {
    private int position = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // Shows a toast message (a pop-up message)
        Toast.makeText(getActivity(), "FragmentPodatak.onCreate()", Toast.LENGTH_SHORT).show();

        if (savedInstanceState != null) {
            position = savedInstanceState.getInt("position");
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);

        // Shows a toast message (a pop-up message)
        Toast.makeText(getActivity(), "FragmentPodatak.onCreateView()", Toast.LENGTH_SHORT).show();

        // Finds view in the view hierarchy and returns it.
        return inflater.inflate(R.layout.fragment_podatak, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        // Shows a toast message (a pop-up message)
        Toast.makeText(getActivity(), "DetailFragment.onActivityCreated()", Toast.LENGTH_SHORT).show();

        if (savedInstanceState != null) {
            position = savedInstanceState.getInt("position", 0);
        }

        ImageView ivImage = (ImageView) getView().findViewById(R.id.iv_image);
        InputStream is;
        try {
            is = getActivity().getAssets().open(GlumacProvider.getGlumacById(position).getFotografija());
            Drawable drawable = Drawable.createFromStream(is, null);
            ivImage.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }


        TextView tvIme = (TextView) getView().findViewById(R.id.tv_ime);
        tvIme.setText(GlumacProvider.getGlumacById(position).getIme());
        TextView tvPrezime = (TextView) getView().findViewById(R.id.tv_prezime);
        tvPrezime.setText(GlumacProvider.getGlumacById(position).getPrezime());
        TextView tvBiografija = getView().findViewById(R.id.tv_biografija);
        tvBiografija.setText(GlumacProvider.getGlumacById(position).getBiografija());
        TextView tvDatum = getView().findViewById(R.id.tv_datum);
        tvDatum.setText(GlumacProvider.getGlumacById(position).getDatumR());
        TextView tvFilmovi = getView().findViewById(R.id.tv_filmovi);
        tvFilmovi.setText(GlumacProvider.getGlumacById(position).getFilmovi());

        RatingBar rbRating = (RatingBar) getView().findViewById(R.id.rb_ocena);
        rbRating.setRating(GlumacProvider.getGlumacById(position).getOcena());
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        super.onSaveInstanceState(savedInstanceState);

        // Shows a toast message (a pop-up message)
        Toast.makeText(getActivity(), "FragmentPodatak.onSaveInstanceState()", Toast.LENGTH_SHORT).show();

        savedInstanceState.putInt("position", position);
    }
    public void setContent(final int position) {

        this.position = position;

        Log.v("FragmentPodatak", "setContent() sets position to " + position);
    }

    public void updateContent(final int position) {

        this.position = position;

           Log.v("DetailFragment", "updateContent() sets position to " + position);
        ImageView ivImage = (ImageView) getView().findViewById(R.id.iv_image);
        InputStream is;
        try {
            is = getActivity().getAssets().open(GlumacProvider.getGlumacById(position).getFotografija());
            Drawable drawable = Drawable.createFromStream(is, null);
            ivImage.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }


        TextView tvIme = (TextView) getView().findViewById(R.id.tv_ime);
        tvIme.setText(GlumacProvider.getGlumacById(position).getIme());
        TextView tvPrezime = (TextView) getView().findViewById(R.id.tv_prezime);
        tvPrezime.setText(GlumacProvider.getGlumacById(position).getPrezime());
        TextView tvBiografija = getView().findViewById(R.id.tv_biografija);
        tvBiografija.setText(GlumacProvider.getGlumacById(position).getBiografija());
        TextView tvDatum = getView().findViewById(R.id.tv_datum);
        tvDatum.setText(GlumacProvider.getGlumacById(position).getDatumR());
        TextView tvFilmovi = getView().findViewById(R.id.tv_filmovi);
        tvFilmovi.setText(GlumacProvider.getGlumacById(position).getFilmovi());

        RatingBar rbRating = (RatingBar) getView().findViewById(R.id.rb_ocena);
        rbRating.setRating(GlumacProvider.getGlumacById(position).getOcena());
}

}