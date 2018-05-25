package  com.google.android.gms.location.sample.locationupdates;

import android.app.Activity;
import android.app.ProgressDialog;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.MediaController;
import android.widget.VideoView;

public class X extends Activity implements SurfaceHolder.Callback, MediaPlayer.OnPreparedListener {


        Bundle extras = getIntent().getExtras();

            String vidAddress = extras.getString("url");

            //The key argument here must match that used in the other activity

        // Do what ever you want with stats
    ProgressDialog pDialog;
    private MediaPlayer mediaPlayer;
    private SurfaceHolder vidHolder;
    private SurfaceView vidSurface;
    //String vidAddress = "http://view.vzaar.com/10738002/video";
    @Override
    public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder arg0) {


        try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setDisplay(vidHolder);
            mediaPlayer.setDataSource(vidAddress);
            mediaPlayer.prepare();
            mediaPlayer.setOnPreparedListener(this);
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        }
        catch(Exception e){
            e.printStackTrace();
        }

//setup
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder arg0) {
    }

    @Override
    public void onPrepared(MediaPlayer mp) {

        mediaPlayer.start();
//start playback
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        vidSurface = (SurfaceView) findViewById(R.id.myVideo);
        vidHolder = vidSurface.getHolder();
        vidHolder.addCallback(this);


    }


}

