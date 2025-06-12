package com.example.recyclervieweditview

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.recyclervieweditview.databinding.EditActivityBinding
import com.example.recyclervieweditview.ui.theme.RecyclerViewEditViewTheme

class EditActivity : ComponentActivity() {
    lateinit var binding: EditActivityBinding

    private var CatsImage = listOf(
        R.drawable.cat1,
        R.drawable.cat2,
        R.drawable.cat3,
        R.drawable.cat4,
        R.drawable.cat5,
        R.drawable.cat6,
        R.drawable.cat7,
        R.drawable.cat8,
        R.drawable.cat9,
        R.drawable.cat10,
        R.drawable.cat11,
        R.drawable.cat12,
        R.drawable.cat13,
    )
    var index:Int  = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RecyclerViewEditViewTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting2(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }

        binding = EditActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imageView.setImageResource(CatsImage[0])

        binding.apply{
            bNext.setOnClickListener{
                index++
                if (index == CatsImage.size) index = 0
                imageView.setImageResource(CatsImage[index])
            }

            bEarly.setOnClickListener{
                index--
                if (index == -1) index = CatsImage.size-1
                imageView.setImageResource(CatsImage[index])
            }

            bDone.setOnClickListener{
                val i = Intent()
                val cat = Cat(CatsImage[index], edName.getText().toString(), edDesc.getText().toString())
                i.putExtra("Cat",cat)
                setResult(RESULT_OK,i)
                finish()

            }

        }

    }

}


@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    RecyclerViewEditViewTheme {
        Greeting2("Android")
    }
}