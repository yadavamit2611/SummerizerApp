package com.example.summerizerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ml.quaterion.text2summary.Text2Summary;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText bigText = findViewById(R.id.bigText);
        EditText sumText = findViewById(R.id.summText);
        Button summarize = findViewById(R.id.summarize);
        Button clearText = findViewById(R.id.clearText);
        Button random = findViewById(R.id.random);

        random.setOnClickListener(v ->
        {
            String text = "I’ve been teaching Design Thinking to adults for five years now and I’m tired of it. In so many places I go — universities, governments, nonprofits and businesses — Design Thinking has moved from new to normal. In business and technology, most have heard of it, many have tried it, and in some cases, people are practicing it well. I can sense the excitement wearing off and that people are ready to move on.\n" +
                    "\n" +
                    "But I don’t think we should.\n" +
                    "\n" +
                    "What I have witnessed in my teaching is that the set of principles under the moniker ‘Design Thinking’ is filling a substantial gap in how we think.\n" +
                    "\n" +
                    "To move on would be to overlook the fact that Design Thinking is popular for a reason. Unlike any other method, Design Thinking provides a model for solving grand challenges — through collaboration, imagination and empathy. Rather than move on, it’s time that we democratize access to this method, and standardize this mindset. Design Thinking needs to move out of the C-suite and universities, and become a foundational part of the curriculum in public K-12 education.";
            bigText.setText(text);

        });

        summarize.setOnClickListener(v ->
        {
            String textToSumm = bigText.getText().toString();
            if (!textToSumm.isEmpty())
            {
                sumText.setVisibility(View.VISIBLE);
                String text = bigText.getText().toString();
                String summary = Text2Summary.summarize(text, 0.7f);
                sumText.setText(summary+"");
            }
            else
            {
                Toast message = Toast.makeText(getApplicationContext(),"Please enter a text to summarise first",Toast.LENGTH_SHORT);
                message.setMargin(50,50);
                message.show();
            }

        });

        clearText.setOnClickListener(v ->
        {
            bigText.setText("");
            sumText.setText("");
            sumText.setVisibility(View.INVISIBLE);
        });


    }
}