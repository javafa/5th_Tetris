package com.kodonho.android.tetris;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

public class Block {
    int colors[] = {
        Color.RED, Color.GREEN, Color.BLUE, Color.CYAN, Color.MAGENTA, Color.YELLOW, Color.parseColor("#FF00FF") // 얘가 보라색
    };

    float unit;
    int index;
    int x,y;
    int rotation;
    int rotation_limit;
    int block[][][];
    int paint_index;
    Paint paint;

    public Block(int block[][][], int index){
        this.index = index;
        this.block = block;
        this.x = 0;
        this.y = 0;
        this.rotation = 0;
        this.rotation_limit = block.length;
        this.paint_index = index;
        paint = new Paint();
        paint.setColor(colors[index]);
    }

    public void rotate(){
        rotation++;
        if(rotation >= rotation_limit)
            rotation = 0;
    }
    public void right(){
        x++;
    }
    public void left(){
        x--;
    }
    public void down(){
        y++;
    }
    public void setUnit(float unit){
        this.unit = unit;
    }
    public void onDraw(Canvas canvas){
        onDraw(canvas, 0);
    }
    public void onDraw(Canvas canvas, float left){
        // 블럭 그리기
        float tempX = 0;
        for(int i=0; i<block[rotation].length; i++){
            for(int j=0; j<block[rotation].length; j++){
                int current = block[rotation][i][j];
                // 스테이지는 항상 left가 0이기 때문에 x좌표가 변해도 항상 0이된다
                // 그래서 left가 0일경우는 x값만 사용하도록 설정
                if(left > 0)
                    tempX = left+j;
                else
                    tempX = j; // 스테이지에서는 블럭의 좌표값을 더해준다.

                if(current > 0) // 블럭이 있는곳만 색칠
                    canvas.drawRect(
                        (tempX + x) * unit,
                        (i + y) * unit,
                        (tempX + x) * unit + unit,
                        (i + y) * unit + unit,
                        paint
                );
            }
        }
    }
}
