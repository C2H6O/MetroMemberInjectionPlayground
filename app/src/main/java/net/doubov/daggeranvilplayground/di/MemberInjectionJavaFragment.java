package net.doubov.daggeranvilplayground.di;

import android.content.res.Resources;

import javax.inject.Inject;

public class MemberInjectionJavaFragment {

    @Inject
    Resources resources;

    public void ensureResourcesNotNull() {
        System.out.println("LX+++ resources asset manager: " + resources.getAssets());
    }

}
