package com.cristianrodier.kidsdraw

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    private lateinit var drawingView: DrawingView
    private lateinit var ib_brush: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawingView = findViewById(R.id.drawingView)
        drawingView.setSizeForBrush(20f)

        ib_brush = findViewById(R.id.ib_brush)

        ib_brush.setOnClickListener { showBrushSizeDialog() }
    }

    private fun showBrushSizeDialog(){
        var brushDialog = Dialog(this)
        brushDialog.setContentView(R.layout.dialog_brush_size)
        brushDialog.setTitle("Brush Size: ")
        setBrushSizeButtons(brushDialog)
    }

    private fun setBrushSizeButtons(brushDialog: Dialog) {
        var smallBtn = brushDialog.findViewById<ImageButton>(R.id.ib_small_brush)
        var mediumBtn = brushDialog.findViewById<ImageButton>(R.id.ib_medium_brush)
        var largeBtn = brushDialog.findViewById<ImageButton>(R.id.ib_large_brush)

        setBrushSizeButtonsListener(smallBtn, mediumBtn, largeBtn, brushDialog)

        brushDialog.show()

    }

    private fun setBrushSizeButtonsListener(smallBtn: ImageButton,
                                            mediumBtn: ImageButton,
                                            largeBtn: ImageButton,
                                            brushDialog: Dialog) {

        smallBtn.setOnClickListener {
            setBrushSize(10f)
            brushDialog.dismiss()
        }

        mediumBtn.setOnClickListener {
            setBrushSize(20f)
            brushDialog.dismiss()
        }

        largeBtn.setOnClickListener {
            setBrushSize(30f)
            brushDialog.dismiss()
        }
    }

    private fun setBrushSize(brushSize: Float){
        drawingView.setSizeForBrush(brushSize)
    }
}