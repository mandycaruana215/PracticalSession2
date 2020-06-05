package com.example.mobilepractical2final;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PageAdapter extends FragmentStatePagerAdapter {
    private int counttab;
    public PageAdapter(@NonNull FragmentManager fm, int counttab) {
        super(fm);
        this.counttab = counttab;
    }


    @Override
    public Fragment getItem(int i) {
        switch (i){


            case 0 : WorldTab  worldtab = new WorldTab();
                    return worldtab;

            case 1 : BusinessTab businesstab = new BusinessTab();
                     return businesstab;

            case 2 : ScienceTab sciencetab = new ScienceTab();
                     return sciencetab;

            case 3 : SportsTab sportstab = new SportsTab();
                     return sportstab;

            case 4 : TechnologyTab technologytab = new TechnologyTab();
                return technologytab;




            default: return null;
        }


    }

    @Override
    public int getCount() {
        return counttab;
    }
}
