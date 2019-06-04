package com.ftninformatika.glumcivezba.fragments;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ftninformatika.glumcivezba.R;
import com.ftninformatika.glumcivezba.providers.GlumacProvider;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class FragmentPodatak extends Fragment {
    private int position = 0;

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
    public void setContent(final int position) {

        this.position = position;

        Log.v("DetailFragment", "setContent() sets position to " + position);
    }
}