package com.example.lab5.shapes

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.example.lab5.R

class Ellipse: Shape() {

    companion object {
        private const val strokeWidth = 8f
    }

    private var startX = 0f
    private var startY = 0f

    private var centerX = 0f
    private var centerY = 0f

    private var endX = 0f
    private var endY = 0f

    override fun setInitialCoordinates(x: Float, y: Float) {
        startX = x
        startY = y
        centerX = x
        centerY = y
        endX = x
        endY = y
    }

    override fun moveX(x: Float) {
        val offset = x - centerX
        startX = centerX - offset
        endX = centerX + offset
    }

    override fun moveY(y: Float) {
        val offset = y - centerY
        startY = centerY - offset
        endY = centerY + offset
    }

    override fun preDraw(canvas: Canvas) {
        strokePaint.color = Color.BLACK
        strokePaint.strokeWidth = strokeWidth
        canvas.drawOval(startX, startY, endX, endY, strokePaint)
    }

    override fun draw(canvas: Canvas) {
        strokePaint.color = Color.BLACK
        strokePaint.strokeWidth = strokeWidth
        canvas.drawOval(startX, startY, endX, endY, strokePaint)
    }

    override fun drawHighlighted(canvas: Canvas) {
        strokePaint.color = Color.GRAY
        strokePaint.strokeWidth = strokeWidth * 2f
        canvas.drawOval(startX, startY, endX, endY, strokePaint)
    }

    override fun getIcon(): Int {
        return R.drawable.ellipse
    }

    override fun getInfo(): String {
        return "startX: $startX; startY: $startY; centerX: $centerX; centerY: $centerY; endX: $endX; endY: $endY;"
    }

    override fun newInstance(): Shape {
        return Ellipse()
    }
}