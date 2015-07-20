package com.example.com.zntu;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class FindActivity extends Activity implements View.OnClickListener {

    EditText iVotTyt;
    Button btnFnd,btnShow;
    EditText etNumb;
    TextView tvMes, tvHsN, tvFlrN;
    int a;
    String b;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);

        btnFnd = (Button)findViewById(R.id.btnFnd);
        btnShow = (Button)findViewById(R.id.btnShow);

        btnFnd.setOnClickListener(this);
        btnShow.setOnClickListener(this);

        etNumb = (EditText)findViewById(R.id.etNumb);
        tvMes = (TextView)findViewById(R.id.tvMes);
        tvHsN = (TextView)findViewById(R.id.tvHsN);
        tvFlrN = (TextView)findViewById(R.id.tvFlrN);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnFnd:
                if(etNumb.getText().length() == 0){
                tvHsN.setText("Введіть");
                tvFlrN.setText("аудиторію!");
                break;}
                else {
                a = Integer.parseInt(etNumb.getText().toString());

                if(a>0&&a<=10){
                    tvHsN.setText("1");
                    tvFlrN.setText("Підвал / 3 корпус ");
                }else  if (a>=125&&a<=183){
                    tvHsN.setText("1");
                    tvFlrN.setText("1");
                }else  if (a>=214&&a<=284){
                    tvHsN.setText("1");
                    tvFlrN.setText("2");
                }else  if (a>=320&&a<=381){
                    tvHsN.setText("1");
                    tvFlrN.setText("3");
                }else  if (a>=185&&a<=198){
                    tvHsN.setText("4");
                    tvFlrN.setText("1");
                }else  if (a>=285&&a<=299){
                    tvHsN.setText("4");
                    tvFlrN.setText("2");
                }else  if (a>=385&&a<=398){
                    tvHsN.setText("4");
                    tvFlrN.setText("3");
                }else  if (a>=483&&a<=498){
                    tvHsN.setText("4");
                    tvFlrN.setText("4");
                }else  if (a>=102&&a<=117){
                    tvHsN.setText("2");
                    tvFlrN.setText("1");
                }else  if (a>=201&&a<=214){
                    tvHsN.setText("2");
                    tvFlrN.setText("2");
                }else  if (a==218){
                    tvHsN.setText("2");
                    tvFlrN.setText("2");
                }else  if (a>=302&&a<=314){
                    tvHsN.setText("2");
                    tvFlrN.setText("3");
                }else  if (a==316){
                    tvHsN.setText("2");
                    tvFlrN.setText("3");
                }else  if (a>=11&&a<=19){
                    tvHsN.setText("3");
                    tvFlrN.setText("1");
                }else  if (a>=20&&a<=29){
                    tvHsN.setText("3");
                    tvFlrN.setText("2");
                }else  if (a>=30&&a<=39){
                    tvHsN.setText("3");
                    tvFlrN.setText("3");
                }else  if (a>=40&&a<=49){
                    tvHsN.setText("3");
                    tvFlrN.setText("4");
                }else  if (a>=50&&a<=58){
                    tvHsN.setText("3");
                    tvFlrN.setText("5");
                }else  if (a==508){
                    tvHsN.setText("5");
                    tvFlrN.setText("0");
                }else  if (a>=520&&a<=529){
                    tvHsN.setText("5");
                    tvFlrN.setText("2");
                }else  if (a>=530&&a<=534){
                    tvHsN.setText("5");
                    tvFlrN.setText("3");
                }else  if (a>=538&&a<=539){
                    tvHsN.setText("5");
                    tvFlrN.setText("3");
                }else  if (a>=540&&a<=549){
                    tvHsN.setText("5");
                    tvFlrN.setText("4");
                }else {
                    tvHsN.setText("Не учбова");
                    tvFlrN.setText("аудиторія!");

                }}

                btnShow.setVisibility(View.VISIBLE);
                break;
            case R.id.btnShow:
                Intent intent = new Intent(this, ShowMapActivity.class);
                intent.putExtra("mes", etNumb.getText().toString() );
                startActivity(intent);
                break;

        }


    }
}
