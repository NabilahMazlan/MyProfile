package com.example.a17010304.myprofile;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName, etGPA;
    RadioGroup rpGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.name);
        etGPA = findViewById(R.id.gpa);
        rpGender = findViewById(R.id.radioGroupGender);



    }

    @Override
    protected void onPause() {
        super.onPause();
        String strName = etName.getText().toString();
        String strGpa = etGPA.getText().toString();
        Float ttlGPA = Float.parseFloat(strGpa);
        int idgender = rpGender.getCheckedRadioButtonId();


        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putString("name", strName);
        prefEdit.putFloat("gpa",ttlGPA);
        prefEdit.putInt("gender", idgender);
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        String strGpa = etGPA.getText().toString();
        Float ttlGPA = Float.parseFloat(strGpa);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String name = prefs.getString("name", "strName");
        Float gpa = prefs.getFloat("gpa", ttlGPA);
        rpGender.check(prefs.getInt("gender", 0));
        Toast toast = Toast.makeText(getApplicationContext(), name + gpa + rpGender, Toast.LENGTH_LONG);
        toast.show();

    }
}
