package com.example.lab5.shapes

import android.graphics.Canvas
import android.graphics.Color
import com.example.lab5.R

class Rectangle: Shape() {

    companion object {
        private const val strokeWidth = 8f
    }

    private var startX = 0f
    private var startY = 0f

    private var endX = 0f
    private var endY = 0f

    override fun setInitialCoordinates(x: Float, y: Float) {
        startX = x
        startY = y
        endX = x
        endY = y
    }

    override fun moveX(x: Float) {
        endX = x
    }

    override fun moveY(y: Float) {
        endY = y
    }

    override fun preDraw(canvas: Canvas) {
        strokePaint.color = Color.BLACK
        strokePaint.strokeWidth = strokeWidth
        canvas.drawRect(startX, startY, endX, endY, strokePaint)
    }

    override fun draw(canvas: Canvas) {
        strokePaint.color = Color.BLACK
        strokePaint.strokeWidth = strokeWidth
        fillPaint.color = Color.WHITE
        canvas.drawRect(startX, startY, endX, endY, fillPaint)
        canvas.drawRect(startX, startY, endX, endY, strokePaint)
    }

    override fun drawHighlighted(canvas: Canvas) {
        strokePaint.color = Color.GRAY
        strokePaint.strokeWidth = strokeWidth * 2f
        canvas.drawRect(startX, startY, endX, endY, strokePaint)
    }

    override fun getIcon(): Int {
        return R.drawable.rect
    }

    override fun getInfo(): String {
        return "startX: $startX; startY: $startY; endX: $endX; endY: $endY;"
    }

    override fun newInstance(): Shape {
        return Rectangle()
    }
}