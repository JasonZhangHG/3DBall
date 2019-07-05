package com.ball.project;

import android.media.MediaPlayer;
import android.os.Bundle;

import com.ball.project.tagcloud.TagCloudView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TagCloudView mTagCloudView;

    private MediaPlayer mMediaPlayer;

    private int[] mMusicList = {R.raw.soulmatch1, R.raw.soulmatch2, R.raw.soulmatch3};
    private int mPlayMusicCount;
    private TagCloudAdapter mTagCloudAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTagCloudView = findViewById(R.id.tag_cloud);
        mTagCloudView.setBackgroundColor(CommonUtils.getColor(R.color.colorTheme));
        mTagCloudAdapter = new TagCloudAdapter(new String[100]);
        mTagCloudView.setAdapter(mTagCloudAdapter);
        startMusic();
    }

    public void startMusic() {
        int musicPosition = mPlayMusicCount % 3;
        if (mMediaPlayer != null) {
            mMediaPlayer.stop();
        }
        mMediaPlayer = MediaPlayer.create(this, mMusicList[musicPosition]);
        mMediaPlayer.setLooping(false);
        mMediaPlayer.start();
        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mPlayMusicCount++;
                startMusic();
            }
        });
    }
}
