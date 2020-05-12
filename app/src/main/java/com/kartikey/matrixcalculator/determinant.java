package com.kartikey.matrixcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class determinant extends AppCompatActivity {
    int a1,a2,a3,b1,b2,b3,c1,c2,c3;
    EditText a11,a12,a13,b11,b12,b13,c11,c12,c13;
    Button sol,clr;
    TextView msg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_determinant);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        a11 = findViewById(R.id.a11);
        a12 = findViewById(R.id.a12);
        clr = findViewById(R.id.clr);
        sol = findViewById(R.id.sol);
        a13 = findViewById(R.id.a13);
        msg = findViewById(R.id.msg);
        b11 = findViewById(R.id.b11);
        b12 = findViewById(R.id.b12);
        b13 = findViewById(R.id.b13);
        c11 = findViewById(R.id.c11);
        c12 = findViewById(R.id.c12);
        c13 = findViewById(R.id.c13);

        sol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                a1 = Integer.parseInt(String.valueOf(a11.getText()));
                a2 = Integer.parseInt(String.valueOf(a12.getText()));
                a3 = Integer.parseInt(String.valueOf(a13.getText()));
                b1 = Integer.parseInt(String.valueOf(b11.getText()));
                b2 = Integer.parseInt(String.valueOf(b12.getText()));
                b3 = Integer.parseInt(String.valueOf(b13.getText()));
                c1 = Integer.parseInt(String.valueOf(c11.getText()));
                c2 = Integer.parseInt(String.valueOf(c12.getText()));
                c3 = Integer.parseInt(String.valueOf(c13.getText()));

                double a[][] = {{ a1, b1, c1},
                        { a2, b2, c2},
                        { a3, b3, c3}};
                double d = determinantOfMatrix(a);

                msg.setText("Determinant is equal to : "+String.valueOf(d));


            }
        });

        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a11.setText("");
                a12.setText("");
                a13.setText("");
                b11.setText("");
                b12.setText("");
                b13.setText("");
                c11.setText("");
                c12.setText("");
                c13.setText("");
                msg.setText("");
            }
        });





    }

    double determinantOfMatrix(double mat[][])
    {
        double ans;
        ans = mat[0][0] * (mat[1][1] * mat[2][2] - mat[2][1] * mat[1][2])
                - mat[0][1] * (mat[1][0] * mat[2][2] - mat[1][2] * mat[2][0])
                + mat[0][2] * (mat[1][0] * mat[2][1] - mat[1][1] * mat[2][0]);
        return ans;
    }
}
