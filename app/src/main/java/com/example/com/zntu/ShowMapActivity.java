package com.example.com.zntu;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.pm.ActivityInfo;


public class ShowMapActivity extends Activity {

    EditText etNumb;
    TextView tvMes, tvHsN;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);



        etNumb = (EditText) findViewById(R.id.etNumb);
        tvMes = (TextView) findViewById(R.id.tvMes);
        tvHsN = (TextView) findViewById(R.id.tvHsN);

        Intent intent = getIntent();
        int f = Integer.parseInt(intent.getStringExtra("mes"));


        TouchImageView img = new TouchImageView(this);
        img.setImageResource(R.drawable.univ);
       /*  if (f > 0 && f <= 10||f >= 125 && f <= 183) {

            img.setImageResource(R.drawable.z1_1);


           } else if (f >= 214 && f <= 284) {

            img.setImageResource(R.drawable.z1_2);


        } else if (f >= 320 && f <= 381) {

            img.setImageResource(R.drawable.z1_3);

          }else  if (f>=185&&f<=198){

            img.setImageResource(R.drawable.z4_1);


           }else  if (f>=285&&f<=299){

            img.setImageResource(R.drawable.z4_2);


            }else  if (f>=385&&f<=398){

            img.setImageResource(R.drawable.z4_3);



            }else  if (f>=483&&f<=498){

            img.setImageResource(R.drawable.z4_4);



            }else  if (f>=11&&f<=19){

            img.setImageResource(R.drawable.z3_1);


            }else  if (f>=20&&f<=29){

            img.setImageResource(R.drawable.z3_2);


            }else  if (f>=30&&f<=39){

            img.setImageResource(R.drawable.z3_3);


            }else  if (f>=40&&f<=49){

            img.setImageResource(R.drawable.z3_4);


            }else  if (f>=50&&f<=58){

            img.setImageResource(R.drawable.z3_5);



             }else  if (f>=520&&f<=529){

            img.setImageResource(R.drawable.z5_2);


            }else  if (f>=530&&f<=534){

            img.setImageResource(R.drawable.z5_3);


            }else  if (f>=538&&f<=539){

            img.setImageResource(R.drawable.z5_3);


            }else  if (f>=540&&f<=549){

            img.setImageResource(R.drawable.z5_4);

            }   */

        img.setMaxZoom(4f);
        setContentView(img);



        }
    }
