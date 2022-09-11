package hasan.gurgur.customalertdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hasan.gurgur.customalertdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.showDialog.setOnClickListener {
            this.showDialog(
                title = "WelcomeAlertdialog",
                description = getString(R.string.desc),
                icon = R.drawable.ic_baseline_account_balance_24,
                btn_pos = "accept",
                btn_neg = "cancel"
            )
        }

    }
}