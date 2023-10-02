package com.example.qrcode.scan_result

import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.camera.core.CameraSelector
import androidx.camera.core.ExperimentalGetImage
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageCapture
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.example.qrcode.BarcodeAnalyser
import com.example.qrcode.R
import com.google.mlkit.vision.barcode.common.Barcode
import java.util.concurrent.Executors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScanResultScreen(value:String?) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Dérogation")
                },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Filled.Close,"")
                    }
                }
            )
        }) { padding ->

    Surface(modifier = Modifier.fillMaxSize().padding(padding),
        color = MaterialTheme.colorScheme.background) {
        Surface(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top)
            .padding(top = 36.dp)
            .padding(horizontal = 20.dp)
            .clip(shape = RoundedCornerShape(16.dp, 16.dp, 16.dp, 16.dp))
            .border(width = 2.dp, color = Color.Gray, shape = RoundedCornerShape(16.dp)),
            color = MaterialTheme.colorScheme.primaryContainer){
        Column(
            modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(vertical = 20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = value ?: "PL - 123 - AK"
            )
            Text(
                text = stringResource(R.string.qrcode_result_valid),
                modifier = Modifier.padding(top = 20.dp),
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = stringResource(R.string.qrcode_result_end_validity),
                modifier = Modifier.padding(top = 20.dp),
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "12/05/2024",
                modifier = Modifier.padding(top = 10.dp),
                style = MaterialTheme.typography.bodyLarge
            )
        }
        }
    }

}
}