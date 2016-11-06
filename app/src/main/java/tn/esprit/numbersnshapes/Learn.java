package tn.esprit.numbersnshapes;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Learn extends Activity {
    String type;
    int order;
    MediaPlayer myPlayer;
    ImageView sample,example,rightArrow,lefttArrow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        sample = (ImageView) findViewById(R.id.sample);
        rightArrow = (ImageView) findViewById(R.id.right);
        lefttArrow = (ImageView) findViewById(R.id.left);
        example = (ImageView) findViewById(R.id.example);
        type= getIntent().getExtras().getString("type");
        order=0;
        if ( type.equals("colors")){
            sample.setImageResource(MyData.Csample[order]);
            example.setImageResource(MyData.Cexample[order]);
        }

        if ( type.equals("shapes")){
            sample.setImageResource(MyData.Ssample[order]);
            example.setImageResource(MyData.Sexample[order]);

        }

        if ( type.equals("numbers")){
            sample.setImageResource(MyData.Nsample[order]);
            example.setImageResource(MyData.Nexample[order]);
        }
        sample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ( type.equals("colors")) playSound(getApplicationContext(), MyData.Csounds[order]);
                if ( type.equals("shapes")) playSound(getApplicationContext(), MyData.Ssounds[order]);
                if ( type.equals("numbers"))playSound(getApplicationContext(), MyData.Nsounds[order]);

            }
        });

        rightArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                order++;
                if ( type.equals("colors")){
                    if ( order< MyData.Csample.length){
                        sample.setImageResource(MyData.Csample[order]);
                        example.setImageResource(MyData.Cexample[order]);
                    }
                    else {
                        playSound(getApplicationContext(), R.raw.success2);
                        finish();
                    }
                }

                if ( type.equals("shapes")){
                    if ( order< MyData.Ssample.length){

                        sample.setImageResource(MyData.Ssample[order]);
                        example.setImageResource(MyData.Sexample[order]);
                    }
                    else {
                        playSound(getApplicationContext(), R.raw.success2);
                        finish();
                    }
                }

                if ( type.equals("numbers")){
                    if ( order< MyData.Nsample.length){
                        sample.setImageResource(MyData.Nsample[order]);
                        example.setImageResource(MyData.Nexample[order]);
                    }
                    else {
                        playSound(getApplicationContext(), R.raw.success2);
                        finish();
                    }
                }



            }
        });
        lefttArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                order--;
                if ( order<0)
                { playSound(getApplicationContext(), R.raw.balloonpop);
                    finish();}
                else{
                if ( type.equals("colors")){
                        sample.setImageResource(MyData.Csample[order]);
                        example.setImageResource(MyData.Cexample[order]);
                }
                if ( type.equals("shapes")){
                        sample.setImageResource(MyData.Ssample[order]);
                        example.setImageResource(MyData.Sexample[order]);
                        }

                if ( type.equals("numbers")){
                        sample.setImageResource(MyData.Nsample[order]);
                        example.setImageResource(MyData.Nexample[order]);
                    }

                }
            }
        });



    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_learn, menu);
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
