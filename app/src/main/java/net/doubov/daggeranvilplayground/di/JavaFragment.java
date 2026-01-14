package net.doubov.daggeranvilplayground.di;

import android.content.res.Resources;

import androidx.fragment.app.Fragment;

import javax.inject.Inject;

public class JavaFragment extends Fragment implements Greeter {
    @Override
    public void greet() {
        System.out.println("LX+++ FRAG JAVA " + resources);
    }

    private Resources resources;

    @Inject
    public JavaFragment(Resources resources) {
        this.resources = resources;
    }

}
