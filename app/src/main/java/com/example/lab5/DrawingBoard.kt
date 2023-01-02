package com.example.lab5

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.view.MotionEvent
import android.view.SurfaceView

class DrawingBoard(context: Context) : SurfaceView(context) {

    fun updateView() {
        val canvas = holder.lockCanvas()
        canvas.drawColor(Color.WHITE)
        drawPreviousShapes(canvas)
        holder.unlockCanvasAndPost(canvas)
    }

    private fun drawPreviousShapes(canvas: Canvas) {
        canvas.drawColor(Color.WHITE)
        for(shape in MyEditor.getShapes()) {
            if (shape == MyEditor.getHighlightedShape()) {
                shape.drawHighlighted(canvas)
            } else {
                shape.draw(canvas)
            }
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        val canvas = holder.lockCanvas()
        drawPreviousShapes(canvas)
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                onActionDown(canvas, event)
            }
            MotionEvent.ACTION_MOVE -> {
                onActionMove(canvas, event)
            }
            MotionEvent.ACTION_UP -> {
                onActionUp(canvas)
            }
        }
        holder.unlockCanvasAndPost(canvas)
        return true
    }

    private fun onActionDown(canvas: Canvas, event: MotionEvent) {
        MyEditor.getSelectedShape().setInitialCoordinates(event.x, event.y)
        MyEditor.getSelectedShape().preDraw(canvas)
    }

    private fun onActionMove(canvas: Canvas, event: MotionEvent) {
        MyEditor.getSelectedShape().moveX(event.x)
        MyEditor.getSelectedShape().moveY(event.y)
        MyEditor.getSelectedShape().preDraw(canvas)
    }

    private fun onActionUp(canvas: Canvas) {
        MyEditor.getSelectedShape().let {
            it.draw(canvas)
            MyEditor.addShape(it)
        }
        val newShape = MyEditor.getSelectedShape().newInstance()
        MyEditor.setSelectedShape(newShape)
    }
}