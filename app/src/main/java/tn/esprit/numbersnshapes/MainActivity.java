package tn.esprit.numbersnshapes;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
    ImageView colors,numbers,shapes,parents ;
    Intent intent;
    MediaPlayer myPlayer;
    SharedPreferences preferences;


    Thread th;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        colors =(ImageView) findViewById(R.id.colors);
        parents=(ImageView) findViewById(R.id.parent);
        numbers=(ImageView) findViewById(R.id.numbers);
        shapes =(ImageView) findViewById(R.id.shapes);
        preferences = getSharedPreferences(MyData.SHARED_PREFERENCES_ID,MODE_PRIVATE);
        loadData();
        playSound(getApplicationContext(), R.raw.soundtrack);
      /*  parents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ParentalContral.class);
                startActivity(i);

            }
        });
*/
        parents.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {




                Intent i = new Intent(MainActivity.this, ParentalContral.class);
                startActivity(i);

                return false;
            }
        });

        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colors.setEnabled(false);
                intent = new Intent( MainActivity.this , SubActivity.class);
                intent.putExtra("type", "colors");
                playSound(getApplicationContext(), R.raw.colors2);
                startActivity(intent);
                colors.setEnabled(true);
            }
        });
        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbers.setEnabled(false);
                intent = new Intent( MainActivity.this , SubActivity.class);
                intent.putExtra("type", "numbers");
                playSound(getApplicationContext(), R.raw.numbers2);
                startActivity(intent);
                numbers.setEnabled(true);
            }
        });
        shapes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shapes.setEnabled(false);
                intent = new Intent( MainActivity.this , SubActivity.class);
                intent.putExtra("type", "shapes");
                playSound(getApplicationContext(), R.raw.shapes2);
                startActivity(intent);
                shapes.setEnabled(true);
            }
        });




    }


    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Quitter l'application")
                .setMessage("Etes Vous sur de vouloir quitter ?")
                .setPositiveButton("Oui", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("Non", null)
                .show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    private void loadData(){
        MyData.scoreColorSuccess =  preferences.getInt(MyData.SC1, 0);
        MyData.scoreColorFail =  preferences.getInt(MyData.SC0, 0);

        MyData.scoreNumberSuccess =  preferences.getInt(MyData.SN1, 0);
        MyData.scoreNumberFail =  preferences.getInt(MyData.SN0, 0);

        MyData.scoreShapeSuccess =  preferences.getInt(MyData.SS1, 0);
        MyData.scoreShapeFail =  preferences.getInt(MyData.SS0, 0);


    }

}
