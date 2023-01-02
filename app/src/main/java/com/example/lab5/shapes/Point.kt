package com.example.lab5.shapes

import android.graphics.Canvas
import android.graphics.Color
import com.example.lab5.R

class Point : Shape() {

    private var x = 0f
    private var y = 0f

    private val radius = 16f

    override fun setInitialCoordinates(x: Float, y: Float) {
        this.x = x
        this.y = y
    }

    override fun moveX(x: Float) {
        this.x = x
    }

    override fun moveY(y: Float) {
        this.y = y
    }

    override fun preDraw(canvas: Canvas) {
        strokePaint.color = Color.BLACK
        canvas.drawCircle(x, y, radius, strokePaint)
    }

    override fun draw(canvas: Canvas) {
        fillPaint.color = Color.BLACK
        canvas.drawCircle(x, y, radius, fillPaint)
    }

    override fun drawHighlighted(canvas: Canvas) {
        fillPaint.color = Color.GRAY
        canvas.drawCircle(x, y, radius * 1.33f, fillPaint)
    }

    override fun getIcon(): Int {
        return R.drawable.point
    }

    override fun getInfo(): String {
        return "x: $x; y: $y"
    }

    override fun newInstance(): Shape {
        return Point()
    }
}