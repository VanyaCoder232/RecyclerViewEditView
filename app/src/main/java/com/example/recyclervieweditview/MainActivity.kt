package com.example.recyclervieweditview

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclervieweditview.databinding.EditActivityBinding
import com.example.recyclervieweditview.databinding.MainActivityBinding
import com.example.recyclervieweditview.ui.theme.RecyclerViewEditViewTheme

class MainActivity : ComponentActivity() {


    lateinit var binding: MainActivityBinding
    private val adadter = CatAdapter()
    var CallEdit: ActivityResultLauncher<Intent>? = null


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        CallEdit = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ res:ActivityResult ->
            if (res.resultCode == RESULT_OK) {
                adadter.addCat(res.data?.getSerializableExtra("Cat") as Cat)
            }

        }

        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()

    }

    private fun init(){
        binding.apply {
            rcListOfCats.layoutManager = GridLayoutManager(this@MainActivity, 2)
            rcListOfCats.adapter = adadter

            buttAdd.setOnClickListener{
                CallEdit?.launch(Intent(this@MainActivity, EditActivity::class.java))

            }

        }

    }



}
