package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setFragment(R.id.container,0, BlankFragment.TAG);
        setFragment(R.id.container1, 1, BlankFragment.TAG1);

        final RecyclerView recyclerView = findViewById(R.id.recyclerView);
        final AdapterMain adapterMain = new AdapterMain();
        recyclerView.setAdapter(adapterMain);

        findViewById(R.id.activityMain_btn_addStudent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (createNewStudent()!=null){
                    adapterMain.add(createNewStudent());
                }
            }
        });

    }

    private void setFragment(int id, int i, String tag) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(id, new BlankFragment(i), tag)
                .commit();
    }

    Student createNewStudent() {
        String name;
        String group;

        BlankFragment blankFragment = (BlankFragment) getSupportFragmentManager().findFragmentByTag(BlankFragment.TAG);
        assert blankFragment != null;
        blankFragment.setHint("введите имя");
        BlankFragment blankFragment1 = (BlankFragment) getSupportFragmentManager().findFragmentByTag(BlankFragment.TAG1);
        assert blankFragment1 != null;
        blankFragment1.setHint("введите группу");

        name = blankFragment.getText();
        group = blankFragment1.getText();

        if (name.equals("") && group.equals("")) {
            Toast.makeText(this, "не все поля заполнены", Toast.LENGTH_SHORT).show();
            return null;
        } else {
            return new Student(name, group);
        }
    }
}
