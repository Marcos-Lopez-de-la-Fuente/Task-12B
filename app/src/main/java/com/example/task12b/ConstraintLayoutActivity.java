package com.example.task12b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ConstraintLayoutActivity extends AppCompatActivity {

    private Button buttonToast;
    private Button buttonCount;
    private TextView showCount;
    private Button goToLinearLayout;
    private Button goToRelativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_layout);


        this.buttonToast = findViewById(R.id.button_toast);
        this.buttonCount = findViewById(R.id.button_count);
        this.showCount = findViewById(R.id.show_count);
        this.goToLinearLayout = findViewById(R.id.goToLinearLayout);
        this.goToRelativeLayout = findViewById(R.id.goToRelativeLayout);



        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.showCount.setText(extras.getString("count"));
        }

        if (savedInstanceState != null) {
            this.showCount.setText(savedInstanceState.getString("numberCount"));
        }



        this.buttonCount.setOnClickListener(view ->
                this.sumCount()
        );

        this.buttonToast.setOnClickListener(view ->
                this.showToastCount()
        );

        this.goToLinearLayout.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("count", this.showCount.getText());
            this.startActivity(intent);
        });

        this.goToRelativeLayout.setOnClickListener(view -> {
            Intent intent = new Intent(this, RelativeLayoutActivity.class);
            intent.putExtra("count", this.showCount.getText());
            this.startActivity(intent);
        });

    }

    public void sumCount() {
        int sum = Integer.parseInt((String) this.showCount.getText()) + 1;
        this.showCount.setText(String.valueOf(sum));

    }


    public void showToastCount() {
        Toast.makeText(this, showCount.getText(), Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("numberCount", (String) this.showCount.getText());

    }
}