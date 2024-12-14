package com.example.placesinqena.MainPackage

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.placesinqena.databinding.ActivityAboutBinding

class About : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        goToGitHub()
        telephoneContact()
        goToEmail()
        goToLinkedIn()

    }


    private fun goToGitHub() {
        binding.ivGithub.setOnClickListener {
            val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Abdallah-Alqiran"))
            startActivity(webIntent)
        }
    }

    private fun goToLinkedIn() {
        binding.ivLinkedin.setOnClickListener {
            try {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/abdallah-alqiran/"))
                intent.setPackage("com.linkedin.android")
                startActivity(intent)
            }
            catch (e: Exception) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/abdallah-alqiran/"))
                startActivity(intent)
                e.printStackTrace()
            }
        }
    }

    private fun goToEmail() {
        binding.tvEmail.setOnClickListener {

            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:abdallahalqiran765@gmail.com")
                putExtra(Intent.EXTRA_SUBJECT, "Hello!!!")
                putExtra(Intent.EXTRA_TEXT, "Welcome")
            }

            try  {
                startActivity(intent)
            }
            catch(_: Exception) {
                Toast.makeText(this, "Please download any email app first", Toast.LENGTH_LONG).show()
            }

        }
    }

    private fun telephoneContact() {
        binding.tvNumber.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+201016611062"))
            try {
              startActivity(intent)
            }
            catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }


}