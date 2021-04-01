package com.ossovita.foregroundserviceexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editTextInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextInput = findViewById(R.id.edit_text_input);
    }

    public void startService(View v){
        String input = editTextInput.getText().toString();
        ContextCompat.startForegroundService( this,new Intent(this,ExampleService.class).putExtra("inputExtra",input));
    }

    public void stopService(View v){
        stopService(new Intent(this,ExampleService.class));
    }
}