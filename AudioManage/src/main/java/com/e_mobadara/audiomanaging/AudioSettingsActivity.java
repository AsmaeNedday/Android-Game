package com.e_mobadara.audiomanaging;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class AudioSettingsActivity extends AppCompatActivity {

    Button server_button, localy_button, managing_button,quitter;
    public static int language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_settings);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        server_button = findViewById(R.id.audio_file_server_button);
        localy_button = findViewById(R.id.audio_file_localy_button);
        managing_button = findViewById(R.id.audio_file_managing_button);
        quitter = findViewById(R.id.home);
        language=(int)getIntent().getIntExtra("lang",-1);





        /*server_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(),ExportImportActivity.class);
                i.putExtra("WorkToDo","server");
                startActivity(i);
                finish();
            }
        });
        */
        switch (language)
        {
            case 0:
                server_button.setText("Importer/exporter serveur");
                localy_button.setText("importer /exporter en local");
                managing_button.setText("Gérer");
                break;

            case 1:server_button.setText("تحميل و مشاركة على السرفر");
                localy_button.setText("تحميل و مشاركة محلي");
                managing_button.setText("تسيير");
                break;

            case 2:

                server_button.setText("Import/Export in Server");
                localy_button.setText("Import /export locally");
                managing_button.setText("Manage");
                break;

            case 3:
                server_button.setText("تحميل و مشاركة على السرفر");
                localy_button.setText("تحميل و مشاركة محلي");
                managing_button.setText("تسيير");
                break;


        }
        quitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
        localy_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(),chooseImportOrExportActivity.class);
                i.putExtra("WorkToDo","localy");
                startActivity(i);
                finish();
            }
        });

        managing_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(),MainAudioModuleActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}
