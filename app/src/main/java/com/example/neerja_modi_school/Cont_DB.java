package com.example.neerja_modi_school;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.neerja_modi_school.databinding.ActivityContDbBinding;

public class Cont_DB extends BaseActivity {
    ActivityContDbBinding activityContDbBinding;
    DatabaseHelper myDb;
    TableLayout tableLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityContDbBinding = ActivityContDbBinding.inflate(getLayoutInflater());
        setContentView(activityContDbBinding.getRoot());
        myDb = new DatabaseHelper(this);
        tableLayout = findViewById(R.id.table_layout);
        displayDataInTable();
    }
    public void displayDataInTable() {
        Cursor res = myDb.showRegisterUser();
        if(res.getCount()==0)
        {
            TextView noData = new TextView(this);
            noData.setText("No data found");
            tableLayout.addView(noData);
            return;
        }
        else {
            TableRow headerRow = new TableRow(this);
            headerRow.addView(createTextView("ID"));
            headerRow.addView(createTextView("Name"));
            headerRow.addView(createTextView("Mobile Number"));
            headerRow.addView(createTextView("Email"));
            headerRow.addView(createTextView("Message"));
            tableLayout.addView(headerRow);
            while (res.moveToNext()) {
                TableRow row = new TableRow(this);
                row.addView(createTextView(res.getString(0)));
                row.addView(createTextView(res.getString(1)));
                row.addView(createTextView(res.getString(2)));
                row.addView(createTextView(res.getString(3)));
                row.addView(createTextView(res.getString(4)));
                tableLayout.addView(row);
            }
        }
    }
    private TextView createTextView (String text){
        TextView textView = new TextView(this);
        textView.setText(text);
        textView.setPadding(8, 8, 8, 8);
        textView.setBackgroundResource(R.drawable.cell_border1);
        return textView;
    }
}