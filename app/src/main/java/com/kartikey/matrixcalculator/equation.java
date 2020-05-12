package com.kartikey.matrixcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class equation extends AppCompatActivity {
    int a1,a2,a3,b1,b2,b3,c1,c2,c3,d1,d2,d3;
    EditText ca1,ca2,ca3,cb1,cb2,cb3,cc1,cc2,cc3,cd1,cd2,cd3;
    Button sol,clr;
    TextView det,det1,det2,det3,x1,y1,z1,msg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equation);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ca1= findViewById(R.id.a1);
        ca2= findViewById(R.id.a2);
        msg = findViewById(R.id.msg);
        ca3= findViewById(R.id.a3);
        cb1= findViewById(R.id.b1);
        cb2= findViewById(R.id.b2);
        cb3= findViewById(R.id.b3);
        cc1= findViewById(R.id.c1);
        cc2= findViewById(R.id.c2);
        cc3= findViewById(R.id.c3);
        cd1= findViewById(R.id.d1);
        cd2= findViewById(R.id.d2);
        cd3= findViewById(R.id.d3);
        sol = findViewById(R.id.sol);
        clr = findViewById(R.id.clr);
        det = findViewById(R.id.det);
        det1 = findViewById(R.id.det1);
        det2 = findViewById(R.id.det2);
        det3 = findViewById(R.id.det3);
        x1 = findViewById(R.id.x1);
        y1 = findViewById(R.id.y1);
        z1 = findViewById(R.id.z1);


        sol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a1 = Integer.parseInt(String.valueOf(ca1.getText()));
                a2 = Integer.parseInt(String.valueOf(ca2.getText()));
                a3 = Integer.parseInt(String.valueOf(ca3.getText()));
                b1 = Integer.parseInt(String.valueOf(cb1.getText()));
                b2 = Integer.parseInt(String.valueOf(cb2.getText()));
                b3 = Integer.parseInt(String.valueOf(cb3.getText()));
                c1 = Integer.parseInt(String.valueOf(cc1.getText()));
                c2 = Integer.parseInt(String.valueOf(cc2.getText()));
                c3 = Integer.parseInt(String.valueOf(cc3.getText()));
                d1 = Integer.parseInt(String.valueOf(cd1.getText()));
                d2 = Integer.parseInt(String.valueOf(cd2.getText()));
                d3 = Integer.parseInt(String.valueOf(cd3.getText()));

                double coeff[][] = {{ a1, b1, c1,d1 },
                        { a2, b2, c2, d2 },
                        { a3, b3, c3, d3 }};
                findSolution(coeff);

            }
        });
        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ca1.setText("");
                ca2.setText("");
                ca3.setText("");
                cb1.setText("");
                cb2.setText("");
                cb3.setText("");
                cc1.setText("");
                cc2.setText("");
                cc3.setText("");
                msg.setText("");
                det.setText("D= ");
                det1.setText("D1= ");
                det3.setText("D3= ");
                det2.setText("D2= ");
                x1.setText("x =");
                y1.setText("y =");
                z1.setText("z =");

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

    // This function finds the solution of system of
// linear equations using cramer's rule
    void findSolution(double coeff[][])
    {
        // Matrix d using coeff as given in cramer's rule
        double d[][] = {
                { coeff[0][0], coeff[0][1], coeff[0][2] },
                { coeff[1][0], coeff[1][1], coeff[1][2] },
                { coeff[2][0], coeff[2][1], coeff[2][2] },
        };

        // Matrix d1 using coeff as given in cramer's rule
        double d1[][] = {
                { coeff[0][3], coeff[0][1], coeff[0][2] },
                { coeff[1][3], coeff[1][1], coeff[1][2] },
                { coeff[2][3], coeff[2][1], coeff[2][2] },
        };

        // Matrix d2 using coeff as given in cramer's rule
        double d2[][] = {
                { coeff[0][0], coeff[0][3], coeff[0][2] },
                { coeff[1][0], coeff[1][3], coeff[1][2] },
                { coeff[2][0], coeff[2][3], coeff[2][2] },
        };

        // Matrix d3 using coeff as given in cramer's rule
        double d3[][] = {
                { coeff[0][0], coeff[0][1], coeff[0][3] },
                { coeff[1][0], coeff[1][1], coeff[1][3] },
                { coeff[2][0], coeff[2][1], coeff[2][3] },
        };

        // Calculating Determinant of Matrices d, d1, d2, d3
        double D = determinantOfMatrix(d);
        double D1 = determinantOfMatrix(d1);
        double D2 = determinantOfMatrix(d2);
        double D3 = determinantOfMatrix(d3);
        det.setText(det.getText()+String.valueOf(D));
        det1.setText(det1.getText()+String.valueOf(D1) );
        det2.setText(det2.getText()+String.valueOf(D2));
        det3.setText(det3.getText()+String.valueOf(D3));


        // Case 1
        if (D != 0)
        {
            // Coeff have a unique solution. Apply Cramer's Rule
            double x = D1 / D;
            double y = D2 / D;
            double z = D3 / D; // calculating z using cramer's rule
            x1.setText(x1.getText()+String.valueOf(x));
            y1.setText(x1.getText()+String.valueOf(y));
            z1.setText(x1.getText()+String.valueOf(z));

        }

        // Case 2
        else
        {
            if (D1 == 0 && D2 == 0 && D3 == 0)
                msg.setText("Infinite solutions");
            else if (D1 != 0 || D2 != 0 || D3 != 0)
                msg.setText("No solution");
        }
    }
}

