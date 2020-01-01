package com.e_mobadara.audiomanaging;

import android.app.Dialog;
import android.arch.persistence.room.Room;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

import com.e_mobadara.Adapter.TabAdapter;
import com.e_mobadara.Database.AudioFile;
import com.e_mobadara.Database.MyDatabase;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import fragments.EncouragementActivity;
import fragments.ExcellentActivity;
import fragments.GoodActivity;

public class MainAudioModuleActivity extends AppCompatActivity {

    private static final String TAG = "MainAudioModuleActivity";

    ViewPager viewPager1;
    TabLayout tabLayout1;
    TabAdapter adapter;

    MyDatabase dbInstance;

    private static String langue = "AR"; // Par defaut
    public static String getLangue() {
        return langue;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_module_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if(getIntent().getExtras()!=null){langue=getIntent().getStringExtra("langue");}
        setupTablayout();
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayShowTitleEnabled(false);
        actionbar.setDisplayHomeAsUpEnabled(true);

        dbInstance = Room.databaseBuilder(this,
                MyDatabase.class, "AudioFiles")
                .allowMainThreadQueries()
                .build();
        loadDataFromDatabase();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        Log.d(TAG,"onCreateOptionsMenu");
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    private void styleMenuButton(Menu menu) {
        int id = R.id.item1;
        if(langue.equals("AR")){id = R.id.item1;}
        else if (langue.equals("FR")){id = R.id.item2;}
        else if (langue.equals("TA")){id = R.id.item3;}
        else if (langue.equals("AN")){id = R.id.item4;}
        else if (langue.equals("DA")){id = R.id.item5;}
        // Find the menu item you want to style
        MenuItem item = menu.findItem(id);
        SpannableString spanString = new SpannableString(menu.findItem(id).getTitle().toString());
        spanString.setSpan(new ForegroundColorSpan(Color.RED), 0, spanString.length(), 0); //fix the color to white
        item.setTitle(spanString);
        MenuItem id1=menu.findItem(R.id.item1);
        MenuItem id2=menu.findItem(R.id.item2);
        MenuItem id3=menu.findItem(R.id.item3);
        MenuItem id4=menu.findItem(R.id.item4);
        MenuItem id5=menu.findItem(R.id.item5);
        switch(AudioSettingsActivity.language)
        {
            case 0:id1.setTitle("Arabe");id2.setTitle("Français");id3.setTitle("Tamazight");id4.setTitle("Anglais");id5.setTitle("Darija");
                break;
            case 1:id1.setTitle("العربية");id2.setTitle("الفرنسية");id3.setTitle(" الامازيغية");id4.setTitle(" الانجليزية");id5.setTitle("الدارجة");
                break;
            case 2:id1.setTitle("Arabic");id2.setTitle("French");id3.setTitle("Tamazight");id4.setTitle("English");id5.setTitle("Darija");

                break;
            case 3:id1.setTitle("العربية");id2.setTitle("الفرنسية");id3.setTitle(" الامازيغية");id4.setTitle(" الانجليزية");id5.setTitle("الدارجة");

                break;
        }
    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        boolean result = super.onPrepareOptionsMenu(menu);
        styleMenuButton(menu);
        return result;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int i1 = item.getItemId();// On peut créer le menu via le code

        switch (AudioSettingsActivity.language)
        {
            case 0:

                i1 = item.getItemId();// On peut créer le menu via le code
                if (i1 == R.id.item1) {
                    Toast.makeText(this, "Langue 'arabe'",
                            Toast.LENGTH_LONG).show();
                    langue = "AR";
                    reloadActivity();

                } else if (i1 == R.id.item2) {
                    Toast.makeText(this, "langue 'francais'",
                            Toast.LENGTH_LONG).show();
                    langue = "FR";
                    reloadActivity();

                } else if (i1 == R.id.item3) {
                    Toast.makeText(this, "langue 'Tamazight'",
                            Toast.LENGTH_LONG).show();
                    langue = "TA";
                    reloadActivity();

                } else if (i1 == R.id.item4) {
                    Toast.makeText(this, "Langue 'Anglais'",
                            Toast.LENGTH_LONG).show();
                    langue = "AN";
                    reloadActivity();

                } else if (i1 == R.id.item5) {
                    Toast.makeText(this, "Langue 'Darija'",
                            Toast.LENGTH_LONG).show();
                    langue = "DA";
                    reloadActivity();

                } else if (i1 == android.R.id.home) {
                    Intent i = new Intent(this,AudioSettingsActivity.class);
                    i.putExtra("lang",AudioSettingsActivity.language);
                    startActivity(i);
                    finish();
                    return true;
                }
                break;
            case 2:
                i1 = item.getItemId();// On peut créer le menu via le code
                if (i1 == R.id.item1) {
                    Toast.makeText(this, "'Arabic' language",
                            Toast.LENGTH_LONG).show();
                    langue = "AR";
                    reloadActivity();

                } else if (i1 == R.id.item2) {
                    Toast.makeText(this, "'french' language",
                            Toast.LENGTH_LONG).show();
                    langue = "FR";
                    reloadActivity();

                } else if (i1 == R.id.item3) {
                    Toast.makeText(this, "'Tamazight' language",
                            Toast.LENGTH_LONG).show();
                    langue = "TA";
                    reloadActivity();

                } else if (i1 == R.id.item4) {
                    Toast.makeText(this, "'English' language",
                            Toast.LENGTH_LONG).show();
                    langue = "EN";
                    reloadActivity();

                } else if (i1 == R.id.item5) {
                    Toast.makeText(this, "'Darija' language",
                            Toast.LENGTH_LONG).show();
                    langue = "DA";
                    reloadActivity();

                } else if (i1 == android.R.id.home) {
                    Intent i = new Intent(this,AudioSettingsActivity.class);
                    i.putExtra("lang",AudioSettingsActivity.language);
                    startActivity(i);
                    finish();
                    return true;
                }
                break;
            case 1:
                i1 = item.getItemId();// On peut créer le menu via le code
                if (i1 == R.id.item1) {
                    Toast.makeText(this, "اللغة العربية",
                            Toast.LENGTH_LONG).show();
                    langue = "AR";
                    reloadActivity();

                } else if (i1 == R.id.item2) {
                    Toast.makeText(this, "اللغة الفرنسية",
                            Toast.LENGTH_LONG).show();
                    langue = "FR";
                    reloadActivity();

                } else if (i1 == R.id.item3) {
                    Toast.makeText(this, "اللغة الامازيغية",
                            Toast.LENGTH_LONG).show();
                    langue = "TA";
                    reloadActivity();

                } else if (i1 == R.id.item4) {
                    Toast.makeText(this, "اللغة الانجليزية",
                            Toast.LENGTH_LONG).show();
                    langue = "EN";
                    reloadActivity();

                } else if (i1 == R.id.item5) {
                    Toast.makeText(this, "اللغة الدارجة",
                            Toast.LENGTH_LONG).show();
                    langue = "DA";
                    reloadActivity();

                } else if (i1 == android.R.id.home) {
                    Intent i = new Intent(this,AudioSettingsActivity.class);
                    i.putExtra("lang",AudioSettingsActivity.language);
                    startActivity(i);
                    finish();
                    return true;
                }
                break;
            case 3:
                i1 = item.getItemId();// On peut créer le menu via le code
                if (i1 == R.id.item1) {
                    Toast.makeText(this, "'Arabic' language",
                            Toast.LENGTH_LONG).show();
                    langue = "AR";
                    reloadActivity();

                } else if (i1 == R.id.item2) {
                    Toast.makeText(this, "'french' language",
                            Toast.LENGTH_LONG).show();
                    langue = "FR";
                    reloadActivity();

                } else if (i1 == R.id.item3) {
                    Toast.makeText(this, "'Tamazight' language",
                            Toast.LENGTH_LONG).show();
                    langue = "TA";
                    reloadActivity();

                } else if (i1 == R.id.item4) {
                    Toast.makeText(this, "'English' language",
                            Toast.LENGTH_LONG).show();
                    langue = "EN";
                    reloadActivity();

                } else if (i1 == R.id.item5) {
                    Toast.makeText(this, "'Darija' language",
                            Toast.LENGTH_LONG).show();
                    langue = "DA";
                    reloadActivity();

                } else if (i1 == android.R.id.home) {
                    Intent i = new Intent(this,AudioSettingsActivity.class);
                    i.putExtra("lang",AudioSettingsActivity.language);
                    startActivity(i);
                    finish();
                    return true;
                }
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setupTablayout() {
        tabLayout1 = findViewById(R.id.tablayout1);
        viewPager1 = findViewById(R.id.viewpager1);
        tabLayout1.setTabGravity(TabLayout.GRAVITY_FILL);

        switch (AudioSettingsActivity.language)
        {
            case 1:
                tabLayout1.addTab(tabLayout1.newTab().setText("ممتاز"));
                tabLayout1.addTab(tabLayout1.newTab().setText("حسن"));
                tabLayout1.addTab(tabLayout1.newTab().setText("تشجيع"));
                break;
            case 0:
                tabLayout1.addTab(tabLayout1.newTab().setText("EXCELENT"));
                tabLayout1.addTab(tabLayout1.newTab().setText("BON"));
                tabLayout1.addTab(tabLayout1.newTab().setText("ENCOURAGEMENT"));
                break;
            case 2:
                tabLayout1.addTab(tabLayout1.newTab().setText("EXCELENT"));
                tabLayout1.addTab(tabLayout1.newTab().setText("GOOD"));
                tabLayout1.addTab(tabLayout1.newTab().setText("ENCOURAGEMENT"));
                break;
            case 3:
                tabLayout1.addTab(tabLayout1.newTab().setText("ممتاز"));
                tabLayout1.addTab(tabLayout1.newTab().setText("حسن"));
                tabLayout1.addTab(tabLayout1.newTab().setText("تشجيع"));
                break;


        }



        adapter = new TabAdapter(getSupportFragmentManager(), tabLayout1.getTabCount());
        viewPager1.setAdapter(adapter);
        viewPager1.setOffscreenPageLimit(3);
        viewPager1.setCurrentItem(1);
        viewPager1.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout1));
        tabLayout1.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager1.setCurrentItem(tab.getPosition());
                try {
                    EncouragementActivity.mp.reset();
                    ExcellentActivity.mp.reset();
                    GoodActivity.mp.reset();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager1.setCurrentItem(tab.getPosition());
                try {
                    EncouragementActivity.mp.reset();
                    ExcellentActivity.mp.reset();
                    GoodActivity.mp.reset();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    void reloadActivity(){
        Intent intent = new Intent(this,MainAudioModuleActivity.class);
        intent.putExtra("langue",langue);
        startActivity(intent);
        finish();
    }

    boolean checkAudioFileIfExist(String folder_path){
        File folder = new File( folder_path );
        boolean success = true;
        if (!folder.exists()) {
            //Toast.makeText(this, "audio-file Does Not Exist...", Toast.LENGTH_SHORT).show();
            success = false;
        }
        if (success) {
            return success;
        } else {
            //Toast.makeText(this, "Failed - Error", Toast.LENGTH_SHORT).show();
            return success;
        }
    }
    void loadDataFromDatabase() {
        /* To query all records */
        Log.d(TAG, " fetching data from database :");
        List<AudioFile> afs = dbInstance.AudioFileDao().getAudioFiles();
        //AudioFile e = new AudioFile(...) ;
        //dbInstance.etabDao().addAudioFile(e);
        if(afs.size()!=0){
            for(AudioFile af : afs) {
                if(!checkAudioFileIfExist(af.getafPath())){
                    dbInstance.AudioFileDao()
                            .deleteAudioFile(af);
                }
            }
        }
    }
}
