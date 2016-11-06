package tn.esprit.numbersnshapes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class SubActivity extends Activity {
    ImageView type,learn,play,back;
    Intent intent;
    String extra;
    MediaPlayer myPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        type =( ImageView) findViewById(R.id.type);
        back=( ImageView) findViewById(R.id.back);
        play=( ImageView) findViewById(R.id.play);
        extra = getIntent().getExtras().getString("type");
        int t=R.drawable.balooon;
        if ( extra.equals("colors")) t = R.drawable.colors;
        if ( extra.equals("shapes")) t = R.drawable.shapes;
        if ( extra.equals("numbers")) t = R.drawable.numbers;

        type.setImageResource(t);
        learn = (ImageView)findViewById(R.id.learn);

        learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                learn.setEnabled(false);
                intent = new Intent( SubActivity.this ,Learn.class);
                intent.putExtra("type", extra);
                playSound(getApplicationContext(), R.raw.learn2);
                startActivity(intent);
                learn.setEnabled(true);

            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play.setEnabled(false);
                intent = new Intent( SubActivity.this ,PlayActivity.class);
                intent.putExtra("type", extra);
                playSound(getApplicationContext(), R.raw.play2);
                startActivity(intent);
                play.setEnabled(true);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(getApplicationContext(), R.raw.balloonpop);
                finish();
            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    Thread th;
    Context mycontext;
    int mysoundID;
    private void playSound( Context cnt ,  int soundID){
        mycontext=cnt;
        mysoundID=soundID;
        th= new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    myPlayer= MediaPlayer.create(mycontext,mysoundID);
                    myPlayer.start();
                    Thread.sleep(myPlayer.getDuration());
                    myPlayer.release();
                    myPlayer.reset();
                    myPlayer=null;
                }catch (Exception e) { }  }
        });
        th.start(); // waits till audio file finishes


    }




}
