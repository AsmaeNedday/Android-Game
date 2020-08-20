package com.example.nedday.Jeu_T_6_21.state;


import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.location.Location;
import android.media.MediaPlayer;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.e_mobadara.audiomanaging.AudioSettingsActivity;
import com.example.ensias_auth_library.models.GameStat;
import com.example.nedday.Jeu_T_6_21.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import java.util.ArrayList;
import java.util.List;

import static com.example.nedday.Jeu_T_6_21.state.First.mp;


public class PopupActivity extends AppCompatActivity implements com.google.android.gms.location.LocationListener, GoogleApiClient.OnConnectionFailedListener, GoogleApiClient.ConnectionCallbacks{

    /**cette activité représente le premier menu présenté à l'utilisateur : jouer / apprendre / langue */

    public static int muet;
    //pour l activation du GPS
    private Location mylocation;
    private GoogleApiClient googleApiClient;
    private final static int REQUEST_CHECK_SETTINGS_GPS=0x1;
    private final static int REQUEST_ID_MULTIPLE_PERMISSIONS=0x2;
    public static double longitude,latitude;

    /////

    Dialog myDialog;
    Button a2, a1, a3, sound, music;
    Button t1, t2, t3, t4, quitter;
    TextView choose;


    public static int langue = 1;
    public static int niveau = 0;
    public static int rubrique = 0; // 1 pour learn et 2 pour play
    public static Activity activity_pop;
    //public static GameStat gameStat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Have a full Screen
        activity_pop = (Activity) this;



        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.menu_learn_play_language);


        //GPS
        setUpGClient();
        //

        myDialog = new Dialog(this);
       /* gameStat = new GameStat();
        gameStat.setApp_id("2019_3_3_4");
        gameStat.setExercise_id("T_6_21");
        gameStat.setLevel_id("1");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ' ' HH:mm:ss");
        String currentDate = sdf.format(new Date());
        gameStat.setCreated_at(currentDate);
        System.out.println("dddddddddddddddddddd" + currentDate);
        //gameStat.setUpdated_at("a");


       */

        /**  a2 Pour la rubrique jouer  a1 Pour la rubrique Apprendre a3 pour la rubrique langue*/
        a1 = (Button) findViewById(R.id.a1);
        a2 = (Button) findViewById(R.id.a2);
        a3 = (Button) findViewById(R.id.a3);
        sound = (Button) findViewById(R.id.sound);
        quitter = (Button) findViewById(R.id.quitter);
        music = (Button) findViewById(R.id.music);


        if ((!mp.isPlaying()) && muet==0){
            mp.start();
        }
        if(mp.isPlaying()){
            music.setBackgroundResource(R.drawable.volume);

        }
        else{

            music.setBackgroundResource(R.drawable.muet);

        }






        /**Traitement selon la langue séléctionnée */
        switch (PopupActivity.langue)
        {
            case 0:  a2.setText("Jouer"); a1.setText("Apprendre"); a3.setText("Langue");sound.setText("Paramètres");break;
            case 1:  a2.setText("إلعب");a1.setText("تعلم"); a3.setText("اللغة");sound.setText("الاعدادات");break;
            case 2 : a2.setText("Play");a1.setText("Learn"); a3.setText("Language");sound.setText("Parameters");break;
            case 3:  a2.setText("إلعب");a1.setText("تعلم"); a3.setText("اللغة");sound.setText("الاعدادات");break;
        }

        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rubrique=2;
                Intent data2 = new Intent(PopupActivity.this, Menu_jouer.class);
                startActivity(data2);
            }
        });



        /** Le traitement de l'apprentissage */

        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rubrique=1;
                Intent data1 = new Intent(PopupActivity.this, Menu_learn.class);
                startActivity(data1);
            }

        });


        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data1 = new Intent(PopupActivity.this, AudioSettingsActivity.class);
                data1.putExtra("lang",PopupActivity.langue);
                startActivity(data1);
            }

        });

        quitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /* SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ' ' HH:mm:ss");
                String dateSortie=sdf.format(new Date());
                gameStat.setCreated_at(dateSortie);
                System.out.println("ssssssssssoooooooort"+dateSortie);
                System.out.println("ffffffffffffffffffffff"+dateSortie);
                if (array_L.size()>0)
                {
                    // Retourner la plus grande valeur
                    Object min = Collections.min(array_L);
                    System.out.println("miiiiiiiiiiiiiiiiiiiiiiin"+min);
                    gameStat.setMin_time_succeed_sec(min.toString());
                    int somme=0;
                    int moy;
                    for (Object obj:array_L)
                    {
                        somme=somme+(int)obj;

                    }
                    moy=(int)somme/array_L.size();
                    gameStat.setAvg_time_succeed_sec(String.valueOf(moy));
                    System.out.println("avggggggggg"+moy);

                }

                gameStat.setLatitude(String.valueOf(latitude));
                System.out.println("laaat"+latitude);
                gameStat.setLongitude(String.valueOf(longitude));
                System.out.println("loooooooong"+String.valueOf(longitude));



                gameStat.setSuccessful_attempts(String.valueOf(PopupActivity.win_score));
                gameStat.setFailed_attempts(String.valueOf(lose_score));

                FoxyAuth.storeGameStat(activity_pop,gameStat);*/
                activity_pop.finish();





            }

        });

        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mp.isPlaying()){
                    mp.pause();
                    music.setBackgroundResource(R.drawable.muet);
                    muet=1;
                }
                else{
                    mp.start();
                    music.setBackgroundResource(R.drawable.volume);
                    muet=0;
                }

            }

        });

        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.setContentView(R.layout.langue);
                t1 = (Button) myDialog.findViewById(R.id.a1);
                t2 = (Button) myDialog.findViewById(R.id.a3);
                t3 = (Button) myDialog.findViewById(R.id.a4);
                t4=(Button) myDialog.findViewById(R.id.a5);
                choose = (TextView) myDialog.findViewById(R.id.choose);

                switch (langue)
                {
                    case 0:
                        choose.setText("Choix du langage");
                        t1.setText("Arabe");t2.setText("Anglais");t3.setText("Français");t4.setText("Darija");break;
                    case 1:
                        choose.setText("اختيار اللغة");

                        t1.setText("العربية ");t2.setText("الانجليزية");t3.setText(" الفرنسية ");t4.setText(" الدارجة ");break;
                    case 2:
                        choose.setText("Choice of the language");
                        t1.setText("Arabic");t2.setText("English");t3.setText("French ");t4.setText("Darija");break;
                    case 3:  choose.setText("اختيار اللغة");

                        t1.setText("العربية ");t2.setText("الانجليزية");t3.setText(" الفرنسية ");t4.setText(" الدارجة ");break;

                }


                t1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        PopupActivity.langue=1;
                        Intent data1 = new Intent(PopupActivity.this, PopupActivity.class);
                        startActivity(data1);

                        activity_pop.finish();



                    }
                });

                t2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        PopupActivity.langue=2;
                        Intent data1 = new Intent(PopupActivity.this, PopupActivity.class);
                        startActivity(data1);
                        activity_pop.finish();

                    }
                });
                t3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        PopupActivity.langue=0;
                        Intent data1 = new Intent(PopupActivity.this, PopupActivity.class);
                        startActivity(data1);
                        activity_pop.finish();


                    }
                });
                t4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        PopupActivity.langue=3;
                        Intent data1 = new Intent(PopupActivity.this, PopupActivity.class);
                        startActivity(data1);
                        activity_pop.finish();


                    }
                });




                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                myDialog.show();
            }

        });






    }

    @Override
    protected void onPause() {

        super.onPause();
        if (mp.isPlaying()){
            mp.pause();
        }


    }
    public void onResume() {

        super.onResume();
        if ((!mp.isPlaying()) && muet==0){
            mp.start();
        }
        if(mp.isPlaying()){
            music.setBackgroundResource(R.drawable.volume);

        }
        else{

            music.setBackgroundResource(R.drawable.muet);

        }


    }

   /**  GPS **/
    private synchronized void setUpGClient() {
        googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, 0, this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        googleApiClient.connect();
    }

    @Override
    public void onLocationChanged(Location location) {
        mylocation = location;
        if (mylocation != null) {
            latitude=mylocation.getLatitude();
            longitude=mylocation.getLongitude();
            System.out.println("Latitude : "+latitude);
            System.out.println("Longitude : "+longitude);

            //latitudeTextView.setText("Latitude : "+latitude);
            //longitudeTextView.setText("Longitude : "+longitude);
            //Or Do whatever you want with your location
        }
    }



    @Override
    public void onConnected(Bundle bundle) {
        checkPermissions();
    }

    @Override
    public void onConnectionSuspended(int i) {
        //Do whatever you need
        //You can display a message here
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        //You can display a message here
    }

    private void getMyLocation(){
        if(googleApiClient!=null) {
            if (googleApiClient.isConnected()) {
                int permissionLocation = ContextCompat.checkSelfPermission(PopupActivity.this,
                        Manifest.permission.ACCESS_FINE_LOCATION);
                if (permissionLocation == PackageManager.PERMISSION_GRANTED) {
                    mylocation =                     LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
                    LocationRequest locationRequest = LocationRequest.create();
                    locationRequest.setInterval(3000);
                    locationRequest.setFastestInterval(3000);
                    locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
                    LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
                            .addLocationRequest(locationRequest);
                    builder.setAlwaysShow(true);
                    LocationServices.FusedLocationApi
                            .requestLocationUpdates(googleApiClient, locationRequest, (com.google.android.gms.location.LocationListener) this);
                    PendingResult<LocationSettingsResult> result =
                            LocationServices.SettingsApi
                                    .checkLocationSettings(googleApiClient, builder.build());
                    result.setResultCallback(new ResultCallback<LocationSettingsResult>() {

                        @Override
                        public void onResult(LocationSettingsResult result) {
                            final Status status = result.getStatus();
                            switch (status.getStatusCode()) {
                                case LocationSettingsStatusCodes.SUCCESS:
                                    // All location settings are satisfied.
                                    // You can initialize location requests here.
                                    int permissionLocation = ContextCompat
                                            .checkSelfPermission(PopupActivity.this,
                                                    Manifest.permission.ACCESS_FINE_LOCATION);
                                    if (permissionLocation == PackageManager.PERMISSION_GRANTED) {
                                        mylocation = LocationServices.FusedLocationApi
                                                .getLastLocation(googleApiClient);
                                    }
                                    break;
                                case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                                    // Location settings are not satisfied.
                                    // But could be fixed by showing the user a dialog.
                                    try {
                                        // Show the dialog by calling startResolutionForResult(),
                                        // and check the result in onActivityResult().
                                        // Ask to turn on GPS automatically
                                        status.startResolutionForResult(PopupActivity.this,
                                                REQUEST_CHECK_SETTINGS_GPS);
                                    } catch (IntentSender.SendIntentException e) {
                                        // Ignore the error.
                                    }
                                    break;
                                case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                                    // Location settings are not satisfied.
                                    // However, we have no way
                                    // to fix the
                                    // settings so we won't show the dialog.
                                    // finish();
                                    break;
                            }
                        }
                    });
                }
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQUEST_CHECK_SETTINGS_GPS:
                switch (resultCode) {
                    case Activity.RESULT_OK:
                        getMyLocation();
                        break;
                    case Activity.RESULT_CANCELED:
                        finish();
                        break;
                }
                break;
        }
    }

    private void checkPermissions(){
        int permissionLocation = ContextCompat.checkSelfPermission(PopupActivity.this,
                android.Manifest.permission.ACCESS_FINE_LOCATION);
        List<String> listPermissionsNeeded = new ArrayList<>();
        if (permissionLocation != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(android.Manifest.permission.ACCESS_FINE_LOCATION);
            if (!listPermissionsNeeded.isEmpty()) {
                ActivityCompat.requestPermissions(this,
                        listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), REQUEST_ID_MULTIPLE_PERMISSIONS);
            }
        }else{
            getMyLocation();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        int permissionLocation = ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION);
        if (permissionLocation == PackageManager.PERMISSION_GRANTED) {
            getMyLocation();
        }
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
    /** **/
}
