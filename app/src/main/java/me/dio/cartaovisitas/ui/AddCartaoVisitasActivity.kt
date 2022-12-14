package me.dio.cartaovisitas.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import me.dio.cartaovisitas.App
import me.dio.cartaovisitas.R
import me.dio.cartaovisitas.data.BusinessCard
import me.dio.cartaovisitas.databinding.ActivityAddCartaoVisitasBinding

class AddCartaoVisitasActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddCartaoVisitasBinding.inflate(layoutInflater) }

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListeners()
    }

    private fun insertListeners() {
        binding.btnConfirm.setOnClickListener {
            val businessCard = BusinessCard(
                nome = binding.tilNome.editText?.text.toString(),
                empresa = binding.tilEmpresa.editText?.text.toString(),
                telefone = binding.tilTelefone.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                fundoPersonalizado = binding.tilCor.editText?.text.toString()
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_show_success, Toast.LENGTH_SHORT).show()
            finish()
        }

        binding.btnClose.setOnClickListener {
            finish()
        }
    }


}