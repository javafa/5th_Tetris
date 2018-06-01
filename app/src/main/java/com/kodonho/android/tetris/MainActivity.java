package com.kodonho.android.tetris;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity
    implements View.OnClickListener,Stage.Controll {

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
        //버튼 연결
        findViewById(R.id.btnDown).setOnClickListener(this);
        findViewById(R.id.btnRotate).setOnClickListener(this);
        findViewById(R.id.btnLeft).setOnClickListener(this);
        findViewById(R.id.btnRight).setOnClickListener(this);

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        displayWidth = metrics.widthPixels;
        unit = displayWidth/WIDTH_SIZE;

        layout = findViewById(R.id.layout);
        // 스테이지와 프리뷰를 생성해서 스크린 클래스에 담아준다
        stage = new Stage(unit, 0, 0, this);
        preview = new Preview(unit, 0, 13);
        screen = new Screen(this, stage, preview);
        layout.addView(screen);

        // 새로운 블럭을 세팅
        setNewBlock();
        // 프리뷰에 세팅된 블럭을 스테이지로 이동
        moveBlockToStage();
    }

    public void setNewBlock(){
        Block newBlock = BlockFactory.newBlock();
        preview.setBlock(newBlock);
    }

    @Override
    public void moveBlockToStage(){
        Block block = preview.getBlock();
        stage.setBlock(block);
        setNewBlock();
        screen.invalidate();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnDown:
                stage.down();
                break;
            case R.id.btnRotate:
                stage.rotate();
                break;
            case R.id.btnLeft:
                stage.left();
                break;
            case R.id.btnRight:
                stage.right();
                break;
        }
        screen.invalidate();
    }
}
