package com.example.lab5

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab5.databinding.ActivityMainBinding
import com.example.lab5.shapes.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var popupMenu: PopupMenu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        val drawingBoard = initDrawingBoard()
        val adapter = initRecyclerAdapter()
        MyEditor.initEditor(drawingBoard, adapter)
        initPopupMenu()
        initListeners()
    }

    private fun initDrawingBoard(): DrawingBoard {
        val drawingBoard = DrawingBoard(this)
        drawingBoard.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        binding.boardLayout.addView(drawingBoard)
        return drawingBoard
    }

    private fun initRecyclerAdapter(): RecyclerAdapter {
        val adapter = RecyclerAdapter()
        binding.bottomRv.layoutManager = LinearLayoutManager(this)
        binding.bottomRv.adapter = adapter
        return adapter
    }

    private fun initPopupMenu() {
        popupMenu = PopupMenu(this, binding.moreBtn)
        popupMenu.menu.add(getString(R.string.point))
        popupMenu.menu.add(getString(R.string.line))
        popupMenu.menu.add(getString(R.string.rect))
        popupMenu.menu.add(getString(R.string.ellipse))
        popupMenu.menu.add(getString(R.string.dumbbell))
        popupMenu.menu.add(getString(R.string.cube))
        popupMenu.menu.add(getString(R.string.show_hide_table))
        popupMenu.setOnMenuItemClickListener {
            when (it.title) {
                getString(R.string.point) -> setSelectedShape(Point())
                getString(R.string.line) -> setSelectedShape(Line())
                getString(R.string.rect) -> setSelectedShape(Rectangle())
                getString(R.string.ellipse) -> setSelectedShape(Ellipse())
//                getString(R.string.dumbbell) -> setSelectedShape(Dumbbell())
//                getString(R.string.cube) -> setSelectedShape(Cube())
                getString(R.string.show_hide_table) -> showHideTable()
            }
            true
        }
    }

    private fun setSelectedShape(shape: Shape) {
        MyEditor.setSelectedShape(shape)
        binding.pointBtn.setBackgroundColor(
            if (shape is Point) Color.WHITE else Color.TRANSPARENT)
        binding.lineBtn.setBackgroundColor(
            if (shape is Line) Color.WHITE else Color.TRANSPARENT)
        binding.rectBtn.setBackgroundColor(
            if (shape is Rectangle) Color.WHITE else Color.TRANSPARENT)
        binding.ellipseBtn.setBackgroundColor(
            if (shape is Ellipse) Color.WHITE else Color.TRANSPARENT)
    }

    private var isTableShown = false

    private fun showHideTable() {
        isTableShown = !isTableShown
        binding.bottomRv.isVisible = isTableShown
        MyEditor.tableStateChanged()
    }

    private fun initListeners() {
        binding.moreBtn.setOnClickListener {
            popupMenu.show()
        }
        binding.pointBtn.setOnClickListener {
            setSelectedShape(Point())
        }
        binding.lineBtn.setOnClickListener {
            setSelectedShape(Line())
        }
        binding.rectBtn.setOnClickListener {
            setSelectedShape(Rectangle())
        }
        binding.ellipseBtn.setOnClickListener {
            setSelectedShape(Ellipse())
        }
        binding.tableBtn.setOnClickListener {
            showHideTable()
        }
    }
}