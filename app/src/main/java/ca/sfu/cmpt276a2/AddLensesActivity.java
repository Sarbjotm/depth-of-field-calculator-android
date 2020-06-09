package ca.sfu.cmpt276a2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddLensesActivity extends AppCompatActivity {

    private String make;
    private double distance;
    private double aperture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_lens);
        setupEndAddingLensesBtn();
        setupSaveBtn();
    }

    private void setupEndAddingLensesBtn(){
        Button btn = (Button) findViewById(R.id.btnCancel);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); //terminates current activity and returns to previous
                }

        });
    }

    private void setupSaveBtn(){
        Button btn = (Button) findViewById(R.id.btnSave);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                EditText editMake = (EditText) findViewById(R.id.editTextCameraMake);
                String make = editMake.getText().toString();
                intent.putExtra("modelMake", make);

                EditText editFocalLength = (EditText) findViewById(R.id.editFocalLength);
                String focalLength = editFocalLength.getText().toString();
                intent.putExtra("modelFocal", focalLength);

                EditText editAperture = (EditText) findViewById(R.id.editAperture);
                String apertureLength = editAperture.getText().toString();
                intent.putExtra("modelAperture", apertureLength);

                setResult(Activity.RESULT_OK, intent);
                finish();

            }

        });
    }
    public static Intent makeIntent(Context context){
        return new Intent(context, AddLensesActivity.class);
    }
}