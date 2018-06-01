package com.kodonho.android.tetris;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Stage {
    float unit;
    int top, left;
    Paint grid, wall, temp;

    int stage_map[][] = {
            {9,0,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,0,9},
            {9,0,0,0,0,0,0,0,0,0,0,9},
            {9,9,9,9,9,9,9,9,9,9,9,9},
    };
    public Stage(float unit, int top, int left){
        this.unit = unit;
        this.top = top;
        this.left = left;

        grid = new Paint();
        grid.setColor(Color.parseColor("#FFEEEEEE"));
        grid.setStyle(Paint.Style.STROKE);
        grid.setStrokeWidth(3);

        wall = new Paint();
        wall.setColor(Color.BLUE);
        wall.setStyle(Paint.Style.FILL_AND_STROKE);
    }
    // 호출되면 그림을 그린다.
    public void onDraw(Canvas canvas){
        // 스테이지 그리기
        for(int y=0; y<stage_map.length; y++){
            for(int x=0; x<stage_map[0].length; x++){
                int current = stage_map[y][x];
                switch(current){
                    case 9:
                        temp = wall;
                        break;
                }
                if(current != 0) {
                    canvas.drawRect(
                            x * unit,
                            y * unit,
                            x * unit + unit,
                            y * unit + unit,
                            temp
                    );
                }
                // allways draw stroke on the rectangles
                canvas.drawRect(
                        x * unit,
                        y * unit,
                        x * unit + unit,
                        y * unit + unit,
                        grid
                );
            }
        }
    }
}
