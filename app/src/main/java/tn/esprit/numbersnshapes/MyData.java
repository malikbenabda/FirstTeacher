package tn.esprit.numbersnshapes;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by malik on 15-May-16.
 */
public  class MyData {





    public static  final String  SHARED_PREFERENCES_ID="tn.esprit.malikBenabda";




    // Setting data
    public static int scoreColorSuccess,scoreColorFail;
    public static int scoreShapeSuccess,scoreShapeFail;
    public static int scoreNumberSuccess,scoreNumberFail;

    public static  final String  SC1="scoreColorSuccess";
    public static  final String  SC0="scoreColorFail";
    public static  final String  SS1="scoreShapeSuccess";
    public static  final String  SS0="scoreShapeFail";
    public static  final String  SN1="scoreNumberSuccess";
    public static  final String  SN0="scoreNumberFail";
    public static String language="FRENCH";


    public static void saveData( ){}
    public static void loadData(){}



        //apprendre Color

//    public static  String[] colorNames = new String[]{  "BLUE",  "RED","ORANGE","GREEN","BLACK","WHITE"    };
    public static  String[] colorNames = new String[]{  "BLEU",  "ROUGE","ORANGE","VERT","NOIR","BLANC"    };
    public static int Csample[]=new int[]{R.drawable.blue,R.drawable.red,R.drawable.orange,R.drawable.green,R.drawable.black,R.drawable.white};
    public static int Cexample[] = new int [] {R.drawable.b2,R.drawable.r1,R.drawable.o3,R.drawable.g2, R.drawable.n2,R.drawable.w2};
    public static int Csounds[] = new int[]{R.raw.blue,R.raw.red,R.raw.orange,R.raw.green,R.raw.black,R.raw.white};
    public final static int COLOR_SIZE=Csample.length;



    //apprendre Shape
//    public static  String[] shapeNames = new String[]{   "CIRCLE","ARROW","CRESCENT","DIAMOND","HEART","OVAL","RECTANGLE","SQUARE","STAR","TRIANGLE"  };
    public static  String[] shapeNames = new String[]{   "CERCLE","FLECHE","CROISSANT","DIAMOND","COEUR","OVAL","RECTANGLE","CARRE","ETOILE","TRIANGLE"  };
    public static int Ssample[]=new int[]{R.drawable.circle,R.drawable.arrow,R.drawable.crescent,R.drawable.diamond,R.drawable.heart,R.drawable.oval,R.drawable.rectangle,R.drawable.square,R.drawable.star,R.drawable.triangle};
    public static int Sexample[]=new int[]{R.drawable.circle,R.drawable.arrow,R.drawable.crescent,R.drawable.diamond,R.drawable.heart,R.drawable.oval,R.drawable.rectangle,R.drawable.square,R.drawable.star,R.drawable.triangle};
    public static int Ssounds[]=new int[]{R.raw.circle,R.raw.arrow,R.raw.crescent,R.raw.diamond,R.raw.heart,R.raw.oval,R.raw.rectangle,R.raw.square,R.raw.star,R.raw.triangle};
    public final static int SHAPE_SIZE=Ssample.length;


    //apprendre Numbers
//    public static  String[] numberNames = new String[]{"ONE","TWO","THREE","FOUR","FIVE","SIX","SEVEN","EIGHT","NINE","TEN" };
    public static  String[] numberNames = new String[]{"UN","DEUX","TROIS","QUATRES","CINQ","SIX","SEPT","HUIT","NEUF","DIX" };
    public static int Nsample[]=new int[]{R.drawable.nbr1,R.drawable.nbr2,R.drawable.nbr3,R.drawable.nbr4,R.drawable.nbr5,R.drawable.nbr6,R.drawable.nbr7,R.drawable.nbr8,R.drawable.nbr9,R.drawable.nbr10};
    public static int Nexample[]=new int[]{R.drawable.fingers1,R.drawable.fingers2,R.drawable.fingers3,R.drawable.fingers4,R.drawable.fingers5,R.drawable.fingers6,R.drawable.fingers7,R.drawable.fingers8,R.drawable.fingers9,R.drawable.fingers10};
    public static int Nsounds[] = new int[]{R.raw.one,R.raw.two,R.raw.three,R.raw.four,R.raw.five,R.raw.six,R.raw.seven,R.raw.eight,R.raw.nine,R.raw.ten };
    public final static int NUMBER_SIZE=Nsample.length;


    //Tests
    // Color Test order :
    public static  String[] colorQestions = new String[]{  "BLUE",  "RED","ORANGE","GREEN","BLACK","WHITE"    };






}
