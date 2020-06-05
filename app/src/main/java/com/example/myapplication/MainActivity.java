package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements IShowText {

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
        BlankFragment blankFragment1 = (BlankFragment) getSupportFragmentManager().findFragmentByTag(BlankFragment.TAG1);

        assert blankFragment != null;
        name = blankFragment.getText();
        assert blankFragment1 != null;
        group = blankFragment1.getText();

        if (!name.equals("") && !group.equals("")) {
            Toast.makeText(this, "не все поля заполнены", Toast.LENGTH_SHORT).show();
            return null;
        } else {
            return new Student(name, group);
        }
    }

    @Override
    public void showText(String s, int i) {
        switch (i) {
            case 0:
                BlankFragment blankFragment = (BlankFragment) getSupportFragmentManager().findFragmentByTag(BlankFragment.TAG1);
                assert blankFragment != null;
                blankFragment.showText(s);
                break;

            case 1:
                BlankFragment blankFragment1 = (BlankFragment) getSupportFragmentManager().findFragmentByTag(BlankFragment.TAG);
                assert blankFragment1 != null;
                blankFragment1.showText(s);
                break;
        }
    }
}
