package tn.esprit.numbersnshapes;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import org.json.JSONObject;

public class ParentalContral extends Activity {

    TextView color,shape,numero;
    ImageView sharing;
    int pc,ps,pn;



    @Override
     protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parental_contral);

    //    FacebookSdk.sdkInitialize(getApplicationContext());
      //  AppEventsLogger.activateApp(getApplication());
        color =(TextView) findViewById(R.id.colorScorePercentage);
        shape =(TextView) findViewById(R.id.formeScorePercentage);
        numero =(TextView) findViewById(R.id.numeroScorePercentage);
        pc=ps=pn=0;
        if ( MyData.scoreColorSuccess+MyData.scoreColorFail !=0)
        { pc = (int)  (100* ((float) MyData.scoreColorSuccess/((float)  MyData.scoreColorFail+(float) MyData.scoreColorSuccess) ));
            color.setText("Meilleur Score Couleur : \n"
                    + pc +"%");
        }
        if ( MyData.scoreShapeSuccess+MyData.scoreShapeFail !=0)

        { ps= (int)  (100* ((float) MyData.scoreShapeSuccess/((float)  MyData.scoreShapeFail+(float) MyData.scoreShapeSuccess) ));
            shape.setText("Meilleur Score Formes : \n" +ps +"%");
        }

        if ( MyData.scoreNumberSuccess+MyData.scoreNumberFail !=0)
        { pn =(int)  (100* ((float) MyData.scoreNumberSuccess/((float)  MyData.scoreNumberFail+(float) MyData.scoreNumberSuccess) ));
            numero.setText("Meilleur Score Numeros : \n" + pn+"%");
        }


        sharing = (ImageView) findViewById(R.id.sharing_button);
        sharing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doShare("Numbers&Letters Score  ", "My kid scored "+pc+"% in discovering Colors, "
                        +ps+"% in learning Shapes and knows"+pn+"% of the numbers! THANKS 'Numbers&Shapes App' :) "   );
            }
        });

   //     facebookStuff();

    }



    public void doShare(String subject, String description) {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT,description);
       ParentalContral.this.startActivity(Intent.createChooser(intent, "Numbers&Shapes Scores")) ;

    }
   /* private void facebookStuff(){
        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
               accessToken= loginResult.getAccessToken();
            }

            @Override
            public void onCancel() {
                System.out.println("Cancel");

            }

            @Override
            public void onError(FacebookException exception) {
                System.out.println(exception.toString());
            }
        });
    }

*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_parental_contral, menu);
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
}
