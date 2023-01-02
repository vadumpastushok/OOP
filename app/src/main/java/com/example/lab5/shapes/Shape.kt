package com.example.lab5.shapes

import android.graphics.Canvas
import android.graphics.Paint

abstract class Shape {

    val strokePaint = Paint(Paint.ANTI_ALIAS_FLAG)
    val fillPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    init {
        strokePaint.style = Paint.Style.STROKE
        fillPaint.style = Paint.Style.FILL
    }

    abstract fun setInitialCoordinates(x: Float, y: Float)

    abstract fun moveX(x: Float)

    abstract fun moveY(y: Float)

    abstract fun preDraw(canvas: Canvas)

    abstract fun draw(canvas: Canvas)

    abstract fun drawHighlighted(canvas: Canvas)

    abstract fun getIcon(): Int

    abstract fun getInfo(): String

    abstract fun newInstance(): Shape
}