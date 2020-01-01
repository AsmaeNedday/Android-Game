package com.e_mobadara.audiomanaging;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class chooseImportOrExportActivity extends AppCompatActivity {

    Button  import_button, export_button,quitter;
    String localy_or_server;
    Activity  activityi ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_import_or_export);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        activityi=this;


        if(getIntent().getExtras()!=null){localy_or_server = getIntent().getStringExtra("WorkToDo");}

        import_button = findViewById(R.id.audio_file_import_button);
        export_button = findViewById(R.id.audio_file_export_button);
        quitter = findViewById(R.id.home);
        quitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(activityi,AudioSettingsActivity.class);
                i.putExtra("lang",AudioSettingsActivity.language);
                finish();
                startActivity(i);

            }
        });
        switch (AudioSettingsActivity.language)
        {
            case 0: import_button.setText("Importer");export_button.setText("Exporter");
                break;
            case 1:import_button.setText("تحميل");export_button.setText("مشاركة");
                break;
            case 2:import_button.setText("import");export_button.setText("Export");
                break;
            case 3:import_button.setText("تحميل");export_button.setText("مشاركة");
                break;
        }

        import_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(localy_or_server.equals("localy")) {
                    Intent i = new Intent(getApplication(), localyImportActivity.class);
                    startActivity(i);
                    finish();
                }else if(localy_or_server.equals("server")){
                    Intent i = new Intent(getApplication(), ExportImportActivity.class);
                    i.putExtra("WorkToDo","import");
                    startActivity(i);
                    finish();
                }
            }
        });

        export_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(localy_or_server.equals("localy")) {
                    Intent i = new Intent(getApplication(), localyExportActivity.class);
                    startActivity(i);
                    finish();
                }else if(localy_or_server.equals("server")){
                    Intent i = new Intent(getApplication(), ExportImportActivity.class);
                    i.putExtra("WorkToDo","export");
                    startActivity(i);
                    finish();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                Intent i = new Intent(this,AudioSettingsActivity.class);
                i.putExtra("lang",AudioSettingsActivity.language);
                startActivity(i);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
