package com.kodonho.android.tetris;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    float displayWidth;
    FrameLayout layout;
    // 화면을 그리는 역할
    Screen screen;
    // 스테이지
    Stage stage;
    Preview preview;
    // 그리드 가로칸의 개수
    final float WIDTH_SIZE = 17;
    // 그리드의 크기 단위
    float unit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        displayWidth = metrics.widthPixels;
        unit = displayWidth/WIDTH_SIZE;

        layout = findViewById(R.id.layout);
        // 스테이지와 프리뷰를 생성해서 스크린 클래스에 담아준다
        stage = new Stage(unit, 0, 0);
        preview = new Preview(unit, 0, 13);
        screen = new Screen(this, stage, preview);
        layout.addView(screen);
    }
}