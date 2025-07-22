package com.example.taller_17_fragments_contacto_correo_mensaje_20;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerController extends FragmentPagerAdapter {

    int numtabs;

    public PagerController(@NonNull FragmentManager fm, int biel) {
        super(fm, biel);
        this.numtabs = biel;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ContactoFragment();
            case 1:
                return new CorreoFragment();
            case 2:
                return new MensajeFragment();
            default:
                return null;


        }

    }

    @Override
    public int getCount() {
        return numtabs;
    }



}
