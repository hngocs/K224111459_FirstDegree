package com.hngocs.k22411c_firstdegree;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    //Khai báo các biến để quản lý các bộ nhớ của các view
    EditText edtCoefficientA;
    EditText edtCoefficientB;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        addViews();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void addViews() {
        edtCoefficientA=findViewById(R.id.edtCoefficientA);
        edtCoefficientB=findViewById(R.id.edtCoefficientB);
        txtResult=findViewById(R.id.txtResult);
    }

    public void do_solution(View view) {

        // Lấy hệ số a trên giao diện
        String hsa=edtCoefficientA.getText().toString();
        double a=Double.parseDouble(hsa);
        // Lấy hệ số a trên giao diện
        double b=Double.parseDouble(edtCoefficientB.getText().toString());

        if (a==0 && b==0)
        {
            //txtResult.setText("Infinity");
            txtResult.setText(getResources().getText(R.string.title_infinity));
        }
        else if(a==0 && b!=0){
            //txtResult.setText("No solution");
            txtResult.setText(getResources().getText(R.string.title_nosolution));
        }
        else {
            double x=-b/a;
            txtResult.setText("x="+x);
        }

    }

    public void do_next(View view) {
        edtCoefficientA.setText("");
        edtCoefficientB.setText("");
        txtResult.setText("");
        //di chuyển con trỏ nhập liệu vào HSA để nhập cho lẹ
        edtCoefficientA.requestFocus();

    }

    public void do_exit(View view) {
        finish();
    }

    private void setLocale(String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
        recreate(); // Refresh UI
    }

    // Language switching
    public void translate_english(View view) {
        setLocale("en");
    }

    public void translate_vietnamese(View view) {
        setLocale("vi");
    }

    public void translate_french(View view) {
        setLocale("fr");
    }

    public void translate_spanish(View view) {
        setLocale("es");
    }
}