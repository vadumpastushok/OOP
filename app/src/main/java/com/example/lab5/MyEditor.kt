package com.example.lab5

import android.annotation.SuppressLint
import com.example.lab5.shapes.Point
import com.example.lab5.shapes.Shape

@SuppressLint("NotifyDataSetChanged")
object MyEditor {
    private lateinit var drawingBoard: DrawingBoard
    private lateinit var adapter: RecyclerAdapter

    fun initEditor(drawingBoard: DrawingBoard, adapter: RecyclerAdapter) {
        this.drawingBoard = drawingBoard
        this.adapter = adapter
    }

    private val shapes = mutableListOf<Shape>()
    private var selectedShape: Shape = Point()
    private var highlightedShape: Shape? = null

    fun getShapes(): List<Shape> {
        return shapes
    }

    fun addShape(shape: Shape) {
        shapes.add(shape)
        adapter.notifyDataSetChanged()
    }

    fun removeShape(shape: Shape) {
        shapes.remove(shape)
        drawingBoard.updateView()
        adapter.notifyDataSetChanged()
    }

    fun setSelectedShape(shape: Shape) {
        selectedShape = shape
    }

    fun getSelectedShape(): Shape {
        return selectedShape
    }

    fun setHighlightedShape(shape: Shape) {
        highlightedShape = shape
        drawingBoard.updateView()
        adapter.notifyDataSetChanged()
    }

    fun getHighlightedShape(): Shape? {
        return highlightedShape
    }

    fun tableStateChanged() {
        drawingBoard.updateView()
    }

    fun saveShapes() {

    }

    fun loadShapes() {

    }
}