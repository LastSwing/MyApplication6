package com.example.administrator.myapplication6;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.myapplication6.R;


public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{

    private TextView contextMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        contextMenu = (TextView)findViewById(R.id.tv_context);
        registerForContextMenu(contextMenu);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id){
            case R.id.action_settings:
                Toast.makeText(MainActivity.this, "action_settings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_other:
                Toast.makeText(MainActivity.this, "action_other", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_content, menu);
    }

    public boolean onContextItemSelected(MenuItem menuItem){

        int id = menuItem.getItemId();
        switch (id){
            case R.id.action3:
                Toast.makeText(this, "action3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action4:
                Toast.makeText(this, "action4", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onContextItemSelected(menuItem);
    }

    public void onPopup(View v) {

        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.menu_content);
        popup.show();
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        int id = menuItem.getItemId();
        switch (id){
            case R.id.action3:
                Toast.makeText(this, "action3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action4:
                Toast.makeText(this, "action4", Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }

}