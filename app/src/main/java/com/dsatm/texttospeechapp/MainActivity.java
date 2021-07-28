package com.dsatm.texttospeechapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
  EditText textToSpeech;
  Button convertButton;
  TextToSpeech tts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textToSpeech = findViewById(R.id.editSpeech);
        convertButton= findViewById(R.id.buttonConvert);

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS){
                    tts.setLanguage(Locale.UK);
                }
            }
        });
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = textToSpeech.getText().toString();
                tts.speak(str,TextToSpeech.QUEUE_FLUSH,null);
            }
        });

    }
}