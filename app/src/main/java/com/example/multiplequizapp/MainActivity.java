package com.example.multiplequizapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText password = findViewById(R.id.passwordInput);
        Button unlock = findViewById(R.id.unlockButton);

        unlock.setOnClickListener(v -> {
            if (password.getText().toString().equals("1234")) {
                showHomeScreen();
            } else {
                Toast.makeText(MainActivity.this,
                        "Incorrect Password!",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showHomeScreen() {
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);
        layout.setPadding(24, 24, 24, 24);
        layout.setBackgroundColor(Color.rgb(234, 242, 255));

        TextView title = new TextView(this);
        title.setText("Quiz World");
        title.setTextSize(30);
        title.setTextColor(Color.BLUE);
        title.setGravity(Gravity.CENTER);
        layout.addView(title);

        String[] categories = {
                "Math Quiz",
                "Computer Quiz",
                "Science Quiz",
                "General Knowledge"
        };

        for (String category : categories) {
            Button button = new Button(this);
            button.setText(category);
            layout.addView(button);
        }

        setContentView(layout);
    }
}