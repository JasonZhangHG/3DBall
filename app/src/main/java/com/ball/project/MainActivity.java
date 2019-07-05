package com.ball.project;

import android.os.Bundle;

import com.ball.project.tagcloud.TagCloudView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TagCloudView mTagCloudView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTagCloudView = findViewById(R.id.tag_cloud);
        mTagCloudView.setBackgroundColor(CommonUtils.getColor(R.color.colorTheme));
        TagCloudAdapter adapter = new TagCloudAdapter(new String[100]);
        mTagCloudView.setAdapter(adapter);
    }
}
