package com.gzeinnumer.easysqlitecrudexample;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.gzeinnumer.easysqlitecrudexample.databinding.ActivityTestBinding;
import com.gzeinnumer.easysqlitecrudexample.entity.Table1;
import com.gzeinnumer.easysqlitecrudexample.helper.DBInstance;

import java.util.List;

public class TestActivity extends AppCompatActivity {

    private static final String TAG = "TestActivity";

    private ActivityTestBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SQLiteDatabase sqLiteDatabase = DBInstance.getDataBase(getApplicationContext());

        Table1 table1 = new Table1(sqLiteDatabase);

        binding.btnInsert.setOnClickListener(view -> {
            boolean istrue = table1.insert();
            Log.d(TAG, "onCreate_1: " + istrue);
        });
        binding.btnUpdate.setOnClickListener(view -> {
            boolean istrue2 = table1.update();
            Log.d(TAG, "onCreate_2: " + istrue2);
        });
        binding.btnDelete.setOnClickListener(view -> {
            boolean istrue3 = table1.delete();
            Log.d(TAG, "onCreate_3: " + istrue3);
        });
        binding.btnCount.setOnClickListener(view -> {
            int count = table1.count();
            Log.d(TAG, "onCreate_4: " + count);
        });
        binding.btnCount2.setOnClickListener(view -> {
            int count2 = table1.count2();
            Log.d(TAG, "onCreate_5: " + count2);
        });
        binding.btnCount3.setOnClickListener(view -> {
            int count3 = table1.queryCount();
            Log.d(TAG, "onCreate_6: " + count3);
        });
        binding.btnRead.setOnClickListener(view -> {
            List<Table1> read = table1.read();
            Log.d(TAG, "onCreate_7: " + read.get(0).getName());
            Log.d(TAG, "onCreate_7: " + read.size());
        });
        binding.btnRead2.setOnClickListener(view -> {
            List<Table1> read2 = table1.read2();
            Log.d(TAG, "onCreate_8: " + read2.get(0).getName());
            Log.d(TAG, "onCreate_8: " + read2.size());
        });
        binding.btnQuery.setOnClickListener(view -> {
            List<Table1> listQuery = table1.query();
            Log.d(TAG, "onCreate_9: " + listQuery.get(0).getName());
            Log.d(TAG, "onCreate_9: " + listQuery.get(0).getTable2_name());
            Log.d(TAG, "onCreate_9: " + listQuery.size());
        });
        binding.btnQueryResultUpdate.setOnClickListener(view -> {
            boolean queryUpdate = table1.queryResultUpdate();
            Log.d(TAG, "onCreate_10: " + queryUpdate);
        });
        binding.btnRead3.setOnClickListener(view -> {
            Table1 read3 = table1.read3();
            if (read3!=null)
                Log.d(TAG, "onCreate_11: " + read3.getName());
            else
                Log.d(TAG, "onCreate_11: " + "null");
        });
        binding.btnRead4.setOnClickListener(view -> {
            Table1 read4 = table1.read4();
            if (read4!=null)
                Log.d(TAG, "onCreate_12: " + read4.getName());
            else
                Log.d(TAG, "onCreate_12: " + "null");
        });
        binding.btnInsertOrIgnore.setOnClickListener(view -> {
            boolean istrue = table1.insertOrIgnore();
            Log.d(TAG, "onCreate_13: " + istrue);
        });
        binding.btnInsertOrUpdate.setOnClickListener(view -> {
            boolean istrue = table1.insertOrUpdate();
            Log.d(TAG, "onCreate_14: " + istrue);
        });
    }
}