package tn.esprit.numbersnshapes;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PlayActivity extends Activity {
    String extra;
    int score=0;
    int selectedItemIndex;
    Random randomer;

    MediaPlayer myPlayer;
    int correctPosition,incorrectPosition1,incorrectPosition2;
    ImageView rightArrow,lefttArrow,ch1,ch2,ch3;
    TextView questionTextView,scoreTextView;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        preferences = getSharedPreferences(MyData.SHARED_PREFERENCES_ID,MODE_PRIVATE);
        extra = getIntent().getExtras().getString("type");
        rightArrow = (ImageView) findViewById(R.id.rightplay);
        lefttArrow = (ImageView) findViewById(R.id.leftplay);
        ch1 = (ImageView) findViewById(R.id.choice1);
        ch2 = (ImageView) findViewById(R.id.choice2);
        ch3 = (ImageView) findViewById(R.id.choice3);
        questionTextView = (TextView) findViewById(R.id.question);
        scoreTextView = (TextView) findViewById(R.id.score);
        scoreTextView.setText(""+score);
        randomer= new Random();
        choiceGenerator();
        questionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (extra.equals("colors")){
                    playSound(getApplicationContext(), MyData.Csounds[selectedItemIndex]);
                }
                if (extra.equals("shapes")){
                    playSound(getApplicationContext(), MyData.Ssounds[selectedItemIndex]);
                }
                if (extra.equals("numbers")){
               playSound(getApplicationContext(), MyData.Nsounds[selectedItemIndex]);

                }

            }
        });
        ch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( correctPosition==0){
                    success();
                }else{
                    fail();
                }
                choiceGenerator();
            }
        });

        ch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( correctPosition==1){
                    //correct answer
                    success();
                }else{
                    //wrong answer
                    fail();
                }
                choiceGenerator();
            }
        });

        ch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( correctPosition==2){
                    success();
                }else{
                   fail();
                }
                choiceGenerator();
            }
        });



        rightArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choiceGenerator();

            }
        });
        lefttArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                playSound(getApplicationContext(), R.raw.balloonpop);
                finish();
                setEnabledAll(true);
            }
        });


    }
    private void success(){
        score++;
        playSound(getApplicationContext(), R.raw.success1);
        MyData.scoreColorSuccess++;
        scoreTextView.setText(""+score);
    }
    private void fail(){
        score--;
        scoreTextView.setText("" + score);
      playSound(getApplicationContext(), R.raw.fail1);
        MyData.scoreColorFail++;
        testGameOver();


    }
    private void testGameOver(){
                   if ( score<0){
                        score=0;
                       scoreTextView.setText("" + score);
                       playSound(getApplicationContext(), R.raw.fail2);
                       new AlertDialog.Builder(this)
                               .setIcon(android.R.drawable.ic_dialog_info)
                               .setTitle("Oops! Vous avez perdu")
                               .setMessage("Voulez vous apprendre? ")
                               .setPositiveButton("Oui", new DialogInterface.OnClickListener()
                               {
                                   @Override
                                   public void onClick(DialogInterface dialog, int which) {

                                       saveData();
                                       finish();
                                   }

                               })
                               .setNegativeButton("Réessayer ", null)
                               .show();







                   }
    }
    private void choiceGenerator(){

        if ( extra.equals("colors")){
            int p = Math.abs(randomer.nextInt());
            selectedItemIndex=p%MyData.COLOR_SIZE;
            questionTextView.setText("Cliquer sur le " + MyData.colorNames[selectedItemIndex]);
            int r= Math.abs(randomer.nextInt(3));

            correctPosition=r%3;
            incorrectPosition1=(r+1)%3;
            incorrectPosition2=(r-1)%3;
            if ( correctPosition==0){
                ch1.setImageResource(MyData.Csample[selectedItemIndex]);
                ch2.setImageResource(MyData.Csample[(p+1)%MyData.COLOR_SIZE]);
                ch3.setImageResource(MyData.Csample[(p-2)%MyData.COLOR_SIZE]);
            }
            if ( correctPosition==1){
                ch2.setImageResource(MyData.Csample[selectedItemIndex]);
                ch1.setImageResource(MyData.Csample[(p+1)%MyData.COLOR_SIZE]);
                ch3.setImageResource(MyData.Csample[(p-1)%MyData.COLOR_SIZE]);
            }
            if ( correctPosition==2){
                ch3.setImageResource(MyData.Csample[selectedItemIndex]);
                ch1.setImageResource(MyData.Csample[(p+1)%MyData.COLOR_SIZE]);
                ch2.setImageResource(MyData.Csample[(p-1)%MyData.COLOR_SIZE]);
            }


        }

        if ( extra.equals("shapes")) {
            int p = Math.abs(randomer.nextInt());
            selectedItemIndex=p%MyData.SHAPE_SIZE;
            questionTextView.setText("Cliquer sur le " + MyData.shapeNames[selectedItemIndex]);
            int r= Math.abs(randomer.nextInt(3));

            correctPosition=r%3;
            incorrectPosition1=(r+1)%3;
            incorrectPosition2=(r-1)%3;
            if ( correctPosition==0){
                ch1.setImageResource(MyData.Ssample[selectedItemIndex]);
                ch2.setImageResource(MyData.Ssample[(p+1)%MyData.SHAPE_SIZE]);
                ch3.setImageResource(MyData.Ssample[(p-2)%MyData.SHAPE_SIZE]);
            }
            if ( correctPosition==1){
                ch2.setImageResource(MyData.Ssample[selectedItemIndex]);
                ch1.setImageResource(MyData.Ssample[(p+1)%MyData.SHAPE_SIZE]);
                ch3.setImageResource(MyData.Ssample[(p-1)%MyData.SHAPE_SIZE]);
            }
            if ( correctPosition==2){
                ch3.setImageResource(MyData.Ssample[selectedItemIndex]);
                ch1.setImageResource(MyData.Ssample[(p+1)%MyData.SHAPE_SIZE]);
                ch2.setImageResource(MyData.Ssample[(p-1)%MyData.SHAPE_SIZE]);
            }

        }

        if ( extra.equals("numbers")) {
            int p = Math.abs(randomer.nextInt());
            selectedItemIndex=p%MyData.NUMBER_SIZE;
            questionTextView.setText("Cliquer sur le  " + MyData.numberNames[selectedItemIndex]);
            int r= Math.abs(randomer.nextInt(3));

            correctPosition=r%3;
            incorrectPosition1=(r+1)%3;
            incorrectPosition2=(r-1)%3;
            if ( correctPosition==0){
                ch1.setImageResource(MyData.Nsample[selectedItemIndex]);
                ch2.setImageResource(MyData.Nsample[(p+1)%MyData.NUMBER_SIZE]);
                ch3.setImageResource(MyData.Nsample[(p-2)%MyData.NUMBER_SIZE]);
            }
            if ( correctPosition==1){
                ch2.setImageResource(MyData.Nsample[selectedItemIndex]);
                ch1.setImageResource(MyData.Nsample[(p+1)%MyData.NUMBER_SIZE]);
                ch3.setImageResource(MyData.Nsample[(p-1)%MyData.NUMBER_SIZE]);
            }
            if ( correctPosition==2){
                ch3.setImageResource(MyData.Nsample[selectedItemIndex]);
                ch1.setImageResource(MyData.Nsample[(p+1)%MyData.NUMBER_SIZE]);
                ch2.setImageResource(MyData.Nsample[(p-1)%MyData.NUMBER_SIZE]);
            }

        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_play, menu);
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

    private void setEnabledAll(boolean x){
        rightArrow.setEnabled(x);
        ch1.setEnabled(x);
        ch2.setEnabled(x);
        ch3.setEnabled(x);
        questionTextView.setEnabled(x);
        scoreTextView.setEnabled(x);
    }

    private void saveData(){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(MyData.SC0, MyData.scoreColorFail);
        editor.putInt(MyData.SC1, MyData.scoreColorSuccess);
        editor.putInt(MyData.SS0, MyData.scoreShapeFail);
        editor.putInt(MyData.SS1, MyData.scoreShapeSuccess);
        editor.putInt(MyData.SN0, MyData.scoreNumberFail);
        editor.putInt(MyData.SN1, MyData.scoreNumberSuccess);
        editor.commit();
    }


}
